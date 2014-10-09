// Global variables
var labelType, useGradients, nativeTextSupport, animate;
var graph; // The grap object used for representing the system components in a graph structure
var rete_graph; // The grap object used for representing the Rete node in a graph structure
var heatmap = {}; // The heatmap object to draw
var heatmap_rete = {}; // The heatmap object to draw Rete heatmap
var heatmap_jvm = {}; // The heatmap object to draw JVM heatmap
var tm; // The treemap object for the heatmap visualization
var tm_rete; // The treemap object for the Rete heatmap visualization
var tm_jvm; // The treemap object for the JVM heatmap visualization
var selectedNode; // The selected node to draw heatmap for
var fd;
var fd_rete;
var jsonData; // The JSON data we get from the server
var images; // Store the images

//var beta_width = 140, beta_height = 80, beta_triangle_height = 20;
//var alpha_width = 140, alpha_height = 60;

var beta_width = 100, beta_height = 50, beta_triangle_height = 10;
var alpha_width = 80, alpha_height = 40;

var reteMemoryThreshold = 1000;


var resultCount = 0; // To store how many changes were seen so far

var resultsTable, deltaTable; // object for the results and delta table

var globalMonitoringTimer; // This stores the timer for the monitoring ajax request to the server

(function () {
    var ua = navigator.userAgent,
        iStuff = ua.match(/iPhone/i) || ua.match(/iPad/i),
        typeOfCanvas = typeof HTMLCanvasElement,
        nativeCanvasSupport = (typeOfCanvas == 'object' || typeOfCanvas == 'function'),
        textSupport = nativeCanvasSupport
          && (typeof document.createElement('canvas').getContext('2d').fillText == 'function');
    //I'm setting this based on the fact that ExCanvas provides text support for IE
    //and that as of today iPhone/iPad current text support is lame
    labelType = (!nativeCanvasSupport || (textSupport && !iStuff)) ? 'Native' : 'HTML';
    nativeTextSupport = labelType == 'Native';
    useGradients = nativeCanvasSupport;
    animate = !(iStuff || !nativeCanvasSupport);
})();

// Own node types and edge types **********************************************************************************************************************************************

// Host Node visualized as an image
$jit.ForceDirected.Plot.NodeTypes.implement({
    'host': {
        'render': function (node, canvas) {
            var ctx = canvas.getCtx();
            var pos = node.pos.getc(true);
            if (node.getData('image') != 0) {
                var img = node.getData('image');
                ctx.drawImage(img, pos.x - 15, pos.y - 15);

                drawGauge(canvas, { x: pos.x + img.width + 20, y: pos.y + 10 }, node.data.cpu, percentToColor(node.data.cpu), "CPU\n" + (truncateDecimals(node.data.cpu * 10) / 10) + "%", 22, 22, 12, 8);
                drawGauge(canvas, { x: pos.x + img.width + 77, y: pos.y + 10 }, node.data.memory, percentToColor(node.data.memory), "MEM\n" + (truncateDecimals(node.data.memory * 10) / 10) + "%", 22, 22, 12, 8);
            }
        },
        'contains': function (node, pos) {
            var npos = node.pos.getc(true);
            //dim = node.getData('dim');
            var width = node.getData('width');
            var height = node.getData('height');
            var npos2 = {};
            npos2.x = npos.x + 5;
            npos2.y = npos.y + 15;
            return this.nodeHelper.rectangle.contains(npos2, pos, width, height);
        }
    }
});

// Process node
$jit.ForceDirected.Plot.NodeTypes.implement({
    'process': {
        'render': function (node, canvas) {
            var ctx = canvas.getCtx();
            var pos = node.pos.getc(true);
            if (node.getData('image') != 0) {
                var img = node.getData('image');
                ctx.drawImage(img, pos.x - 25, pos.y - 20);

                drawGauge(canvas, { x: pos.x + img.width + 8, y: pos.y + 10 }, node.data.cpu, percentToColor(node.data.cpu), "CPU\n" + (truncateDecimals(node.data.cpu * 10) / 10) + "%", 22, 22, 12, 8);
                drawGauge(canvas, { x: pos.x + img.width + 65, y: pos.y + 10 }, node.data.memory, percentToColor(node.data.memory), "HEAP\n" + (truncateDecimals(node.data.memory * 10) / 10) + "%", 22, 22, 12, 8);
            }
        },
        'contains': function (node, pos) {
            var npos = node.pos.getc(true);
            //dim = node.getData('dim');
            var width = node.getData('width');
            var height = node.getData('height');
            var npos2 = {};
            npos2.x = npos.x + 5;
            npos2.y = npos.y + 15;
            return this.nodeHelper.rectangle.contains(npos2, pos, width, height);
        }
    }
});

// Beta node type
$jit.ForceDirected.Plot.NodeTypes.implement({
    'beta': {
        'render': function (node, canvas) {
            var pos = node.pos.getc(true);
            
            this.nodeHelper.rectangle.render('fill', pos, beta_width, beta_height, canvas);
            this.nodeHelper.triangle.render('fill', { x: pos.x - beta_width / 4, y: pos.y - beta_height / 2 - beta_triangle_height }, beta_triangle_height, canvas);
            this.nodeHelper.triangle.render('fill', { x: pos.x + beta_width / 4, y: pos.y - beta_height / 2 - beta_triangle_height }, beta_triangle_height, canvas);

            var memoryPercent = Math.min((node.data.memory / reteMemoryThreshold) * 100, 100);
            drawGauge(canvas, { x: pos.x, y: pos.y }, memoryPercent, percentToColor(memoryPercent), "MEM\n" + (truncateDecimals(node.data.memory * 10) / 10), 22, 22, 10, 8);
        },
        'contains': function (node, pos) {
            var npos = node.pos.getc(true);
            return this.nodeHelper.rectangle.contains(npos, pos, beta_width, beta_height);
        }
    }
});

// Alpha node type
$jit.ForceDirected.Plot.NodeTypes.implement({
    'alpha': {
        'render': function (node, canvas) {
            var pos = node.pos.getc(true);

            this.nodeHelper.rectangle.render('fill', pos, alpha_width, alpha_height, canvas);

        },
        'contains': function (node, pos) {
            var npos = node.pos.getc(true);
            return this.nodeHelper.rectangle.contains(npos, pos, alpha_width, alpha_height);
        }
    }
});

// Memory Alpha node type
$jit.ForceDirected.Plot.NodeTypes.implement({
    'memoryAlpha': {
        'render': function (node, canvas) {
            var pos = node.pos.getc(true);

            this.nodeHelper.circle.render('fill', pos, 30, canvas);

            var memoryPercent = Math.min((node.data.memory / reteMemoryThreshold) * 100, 100);
            drawGauge(canvas, { x: pos.x, y: pos.y }, memoryPercent, percentToColor(memoryPercent), "MEM\n" + (truncateDecimals(node.data.memory * 10) / 10), 22, 22, 12, 8);
        },
        'contains': function (node, pos) {
            var npos = node.pos.getc(true);
            return this.nodeHelper.circle.contains(npos, pos, 40);
        }
    }
});

function drawGauge(canvas, pos, percent, color, text, outerWidth, innerWidth, outerLineWidth, innerLineWidth) {
    var ctx = canvas.getCtx();

    text_width = ctx.measureText(text).width;

    ctx.beginPath();
    ctx.strokeStyle = "#333";
    ctx.lineWidth = outerLineWidth;
    ctx.arc(pos.x, pos.y, outerWidth, 0, Math.PI * 2, false);
    ctx.stroke();

    var degrees = percent * 3.6;
    var radians = degrees * Math.PI / 180;
    ctx.beginPath();
    ctx.strokeStyle = color;
    ctx.lineWidth = innerLineWidth;
    //The arc starts from the rightmost end. If we deduct 90 degrees from the angles
    //the arc will start from the topmost end
    ctx.arc(pos.x, pos.y, innerWidth, 0 - 90 * Math.PI / 180, radians - 90 * Math.PI / 180, false);
    ctx.stroke();

    ctx.fillStyle = color;
    ctx.font = "10px sans-serif";
    ctx.wrapText(text, pos.x - text_width / 4, pos.y - 2, 120, 10);
}

// Directed edge with label placed on it
$jit.ForceDirected.Plot.EdgeTypes.implement({
    'label-arrow-line': {
        'render': function (adj, canvas) {
            var from = adj.nodeFrom.pos.getc(true),
            to = adj.nodeTo.pos.getc(true),
            dim = adj.getData('dim'),
            direction = adj.data.$direction,
            inv = (direction && direction.length > 1 && direction[0] != adj.nodeFrom.id);

            var deltaX;
            var deltaY;
            if (adj.data.slot == "PRIMARY") {
                deltaX = - beta_width / 4;
                deltaY = - (beta_height / 2) - beta_triangle_height * 2 + 5;
            }
            else if (adj.data.slot == "SECONDARY") {
                deltaX = beta_width / 4;
                deltaY = - (beta_height / 2) - beta_triangle_height * 2 + 5;
            }
            else if (adj.data.slot == "SINGLE") {
                deltaX = 0;
                if (from.y < to.y) {
                    deltaY = -(alpha_height / 2) ;
                }
                else deltaY = (alpha_height / 2) ;
            }
            
            
            if (inv) {
                var from2 = {};
                from2.y = from.y + deltaY;
                from2.x = from.x + deltaX;
                this.edgeHelper.arrow.render(from2, to, dim, inv, canvas);
            } else {
                var to2 = {};
                to2.y = to.y + deltaY;
                to2.x = to.x + deltaX;
                this.edgeHelper.arrow.render(from, to2, dim, inv, canvas);
            }
            
            //get nodes cartesian coordinates
            var pos = adj.nodeFrom.pos.getc(true);
            var posChild = adj.nodeTo.pos.getc(true);

            //check for edge label in data
            var data = adj.data;
            if (data.labeltext) {
                var posChildX = 0, posChildY = 0;

                if (adj.data.slot == "PRIMARY") {
                    posChildX = posChild.x - beta_width / 4;
                    posChildY = posChild.y - (beta_height / 2) - beta_triangle_height * 2;
                }
                else if (adj.data.slot == "SECONDARY") {
                    posChildX = posChild.x + beta_width / 4;
                    posChildY = posChild.y - (beta_height / 2) - beta_triangle_height * 2;
                }
                else if (adj.data.slot == "SINGLE") {
                    posChildX = posChild.x;
                    if (from.y < to.y) {
                        posChildY = posChild.y - (alpha_height / 2);
                    }
                    else posChildY = posChild.y + (alpha_height / 2);
                }
                var x2 = Math.max(pos.x, posChildX);
                var x1 = Math.min(pos.x, posChildX);
                var y2 = Math.max(pos.y, posChildY);
                var y1 = Math.min(pos.y, posChildY);

                var posy = y2 - ((y2 - y1) / 2);
                var posx = x2 - ((x2 - x1) / 2);

                var ctx = canvas.getCtx();
                ctx.font = "12px  sans-serif";
                ctx.fillStyle = "#000000";
                ctx.wrapText(data.labeltext, posx, posy, 120, 16);

            }
        },
        'contains': function (adj, pos) {
            return this.edgeHelper.line.contains(adj.nodeFrom.pos, adj.nodeTo.pos, pos, 30);
        }

    }
});

//Extending the canvas object to draw multiline texts
CanvasRenderingContext2D.prototype.wrapText = function (text, x, y, maxWidth, lineHeight) {

    var lines = text.split("\n");

    for (var i = 0; i < lines.length; i++) {

        var words = lines[i].split(' ');
        var line = '';

        for (var n = 0; n < words.length; n++) {
            var testLine = line + words[n] + ' ';
            var metrics = this.measureText(testLine);
            var testWidth = metrics.width;
            if (testWidth > maxWidth && n > 0) {
                this.fillText(line, x, y);
                line = words[n] + ' ';
                y += lineHeight;
            }
            else {
                line = testLine;
            }
        }

        this.fillText(line, x, y);
        y += lineHeight;
    }
}

// End of node types and edge types **********************************************************************************************************************************************

function visualizeSystem() {
// TODO comment here for offline testing of style info
    $.getJSON('test.json', function (data) {
//      $.getJSON('test.json', function (data) {
        update(data);
    });
    globalMonitoringTimer = setTimeout(function () { visualizeSystem(); }, 5000);
}

// Update the data from the new query
function update(object) {
    
    if (jsonData != null) delete jsonData;
    jsonData = object;

    if (!hasSystemChanged()) {

        if (selectedNode != null) {
            if (selectedNode.data.nodetype == "machine") updateHeatMap();
            else if (selectedNode.data.nodetype == "process") updateJVMHeatMap();
        }
        
        updateSystemGraph();

    }
    // anyway if changed redraw the system, delete the heatmap
    else {
        $jit.id('infovis').innerHTML = "";
        $jit.id('heatmap').innerHTML = "";
        $jit.id('heatmap-rete').innerHTML = "";

        selectedNode = null;

        drawSystem();

    }

    if (!hasReteNetworkChanged()) {
        updateReteHeatMap();
        updateReteNetGraph();
    }
    else {
        $jit.id('infovis-rete').innerHTML = "";
        $jit.id('heatmap-rete').innerHTML = "";

        drawReteNet();
    }

    checkQueryResults();

}

// Heatmap related things **********************************************************************************************************************************************
// Initialize and draw heatmap object
function drawHeatMap() {

    heatmap = {};
    heatmap.data = {};
    heatmap.name = "Heatmap of OS-level resource usages for " + selectedNode.id;

    hostHeatMap();

    $jit.id('heatmap').innerHTML = "";

    tm = new $jit.TM.Squarified({
        //where to inject the visualization
        injectInto: 'heatmap',
        //no parent frames
        titleHeight: 20,
        //enable animations
        animate: animate,
        //no box offsets
        offset: 1,
        //duration of the animation
        duration: 0,

        //Add the name of the node in the correponding label
        //This method is called once, on label creation.
        onCreateLabel: function (domElement, node) {

            var html = node.name;
            if (node.data.value != null) {
                html += "<div style=\"width: 100px;height: 30px;text-align: center;margin: auto;position: absolute;top: 0;left: 0;bottom: 0;right: 0;\">" + node.data.value +"</div>";
            }
            
            domElement.innerHTML = html;

            var style = domElement.style;
            style.color = "#ffffff";
            style.display = '';
            style.cursor = 'default';
            style.border = '1px solid transparent';
            style.textAlign = "center";
            style.verticalAlign = "bottom";
            style.fontFamily = "sans-serif"; reteHeatMap

            style.fontSize = "1em";

            domElement.onmouseover = function () {
                style.border = '2px solid #0000FF';
            };
            domElement.onmouseout = function () {
                style.border = '1px solid transparent';
            };
        }
    });

    tm.loadJSON(heatmap);
    tm.refresh();

}

//How to draw the Rete heatmap
function drawReteHeatMap() {

    heatmap_rete = {};
    heatmap_rete.data = {};
    heatmap_rete.name = "Heatmap of Rete metrics and resource usages for " + selectedNode.id;
    heatmap_rete.id = "rete_top";

    reteHeatMap();

    $jit.id('heatmap-rete').innerHTML = "";

    tm_rete = new $jit.TM.Squarified({
        //where to inject the visualization
        injectInto: 'heatmap-rete',
        //no parent frames
        titleHeight: 20,
        //enable animations
        animate: animate,
        //no box offsets
        offset: 1,
        //duration of the animation
        duration: 0,

        //Add the name of the node in the correponding label
        //This method is called once, on label creation.
        onCreateLabel: function (domElement, node) {

            var html = node.name;
            if (node.data.value != null) {
                html += "<div style=\"width: 100px;height: 30px;text-align: center;margin: auto;position: absolute;top: 0;left: 0;bottom: 0;right: 0;\">" + node.data.value + "</div>";
            }

            domElement.innerHTML = html;

            var style = domElement.style;
            style.color = "#ffffff";
            style.display = '';
            style.cursor = 'default';
            style.border = '1px solid transparent';
            style.textAlign = "center";
            style.verticalAlign = "bottom";
            style.fontFamily = "sans-serif";
            style.fontSize = "1em";

            domElement.onmouseover = function () {
                style.border = '2px solid #0000FF';
            };
            domElement.onmouseout = function () {
                style.border = '1px solid transparent';
            };
        }
    });
    
    tm_rete.loadJSON(heatmap_rete);
    tm_rete.refresh();

}

// Initialize and draw JVM heatmap object
function drawJVMHeatMap() {

    heatmap_jvm = {};
    heatmap_jvm.data = {};
    heatmap_jvm.name = "Heatmap of JVM-level resource usages for " + selectedNode.id;
    heatmap_jvm.id = "jvm_top";

    JVMHeatMap();

    $jit.id('heatmap').innerHTML = "";

    tm = new $jit.TM.Squarified({
        //where to inject the visualization
        injectInto: 'heatmap',
        //no parent frames
        titleHeight: 20,
        //enable animations
        animate: animate,
        //no box offsets
        offset: 1,
        //duration of the animation
        duration: 0,

        //Add the name of the node in the correponding label
        //This method is called once, on label creation.
        onCreateLabel: function (domElement, node) {

            var html = node.name;
            if (node.data.value != null) {
                html += "<div style=\"width: 100px;height: 30px;text-align: center;margin: auto;position: absolute;top: 0;left: 0;bottom: 0;right: 0;\">" + node.data.value + "</div>";
            }

            domElement.innerHTML = html;

            var style = domElement.style;
            style.color = "#ffffff";
            style.display = '';
            style.cursor = 'default';
            style.border = '1px solid transparent';
            style.textAlign = "center";
            style.verticalAlign = "bottom";
            style.fontFamily = "sans-serif";
            style.fontSize = "1em";

            domElement.onmouseover = function () {
                style.border = '2px solid #0000FF';
            };
            domElement.onmouseout = function () {
                style.border = '1px solid transparent';
            };
        }
    });

    tm.loadJSON(heatmap_jvm);
    tm.refresh();

}

// Update the heat map with the new measurement data from the server 
function updateHeatMap() {

    if (tm == null) return;

    hostHeatMap();

    // Set aniamtion duration to 0 and refresh the new data to the heatmap visualization treemap
    tm.config.duration = 0;
    tm.loadJSON(heatmap);
    tm.refresh();

}

function updateReteHeatMap() {
    if (tm_rete == null) return;
    // Update the Rete heatmap as well
    reteHeatMap();
    tm_rete.config.duration = 0;
    tm_rete.loadJSON(heatmap_rete);
    tm_rete.refresh();
}

function updateJVMHeatMap() {
    if (tm == null) return;
    // Update the JVM heatmap as well
    JVMHeatMap();
    tm.config.duration = 0;
    tm.loadJSON(heatmap_jvm);
    tm.refresh();
}

function reteHeatMap() {

    if (selectedNode == null) return;

    // Clear the previous data
    delete heatmap_rete.children;
    heatmap_rete.children = [];

    var hostOrProcess = selectedNode.id;

    for (var i = 0; i < jsonData.rete.length; i++) {
        var reteNode = jsonData.rete[i];

        //if (reteNode.nodeType == "ProductionNode") continue; // Production node actually doesn't contain useful information

        if (hostOrProcess == reteNode.hostName || hostOrProcess == reteNode.processName) { // The tricky part so it works for both process and machine

            var node = {};
            node.name = reteNode.nodeType + " " + reteNode.reteNode;
            node.id = selectedNode.id + reteNode.reteNode;
            node.data = {};
            node.data.$area = 200;
            node.children = [];

            var updates = {};
            updates.name = "Sent updates";
            updates.id = selectedNode.id + reteNode.reteNode + "_updates";
            updates.data = {};
            updates.data.$area = 200;
            updates.children = [];

            var message = {};
            message.name = "Update messages";
            message.id = selectedNode.id + reteNode.reteNode + "_updatemessages";
            message.data = {};
            message.data.$area = 100;
            message.data.$color = percentToColor(Math.min((reteNode.updateMessagesSent / 100) * 100, 100));
            message.data.value = reteNode.updateMessagesSent;

            updates.children.push(message);

            var changes = {};
            changes.name = "Changes";
            changes.id = selectedNode.id + reteNode.reteNode + "_changes";
            changes.data = {};
            changes.data.$area = 100;
            changes.data.$color = percentToColor(Math.min((Math.log(reteNode.changesCount) / Math.log(10000000)) * 100, 100));
            changes.data.value = reteNode.changesCount;

            updates.children.push(changes);

            node.children.push(updates);

            var memoryCons = {};
            memoryCons.name = "Consumption";
            memoryCons.id = selectedNode.id + reteNode.reteNode + "_memoryconsumption";
            memoryCons.data = {};
            memoryCons.data.$area = 100;
            memoryCons.data.$color = percentToColor(Math.min((reteNode.memory / 500) * 100, 100));
            memoryCons.data.value = (truncateDecimals(reteNode.memory * 100) / 100) + " MB";

            if (reteNode.nodeClass == "Input") {
                var memory = {};
                memory.name = "Memory";
                memory.id = selectedNode.id + reteNode.reteNode + "_memory";
                memory.data = {};
                memory.data.$area = 200;
                memory.children = [];

                var tuples = {};
                tuples.name = "Tuples";
                tuples.id = selectedNode.id + reteNode.reteNode + "_tuples";
                tuples.data = {};
                tuples.data.$area = 100;
                tuples.data.$color = percentToColor(Math.min((Math.log(reteNode.tuples) / Math.log(10000000)) * 100, 100));
                tuples.data.value = reteNode.tuples;

                memory.children.push(tuples);

                memory.children.push(memoryCons);

                node.children.push(memory);
            }

            if (reteNode.nodeClass == "Beta") {
                var indexer = {};
                indexer.name = "Memory";
                indexer.id = selectedNode.id + reteNode.reteNode + "_memory";
                indexer.data = {};
                indexer.data.$area = 300;
                indexer.children = [];

                var leftindexer = {};
                leftindexer.name = "Left indexer";
                leftindexer.id = selectedNode.id + reteNode.reteNode + "_leftindexer";
                leftindexer.data = {};
                leftindexer.data.$area = 100;
                leftindexer.data.$color = percentToColor(Math.min((Math.log(reteNode.leftIndexerSize) / Math.log(10000000)) * 100, 100));
                leftindexer.data.value = reteNode.leftIndexerSize;

                indexer.children.push(leftindexer);

                var rightindexer = {};
                rightindexer.name = "Right indexer";
                rightindexer.id = selectedNode.id + reteNode.reteNode + "_rightindexer";
                rightindexer.data = {};
                rightindexer.data.$area = 100;
                rightindexer.data.$color = percentToColor(Math.min((Math.log(reteNode.rightIndexerSize) / Math.log(10000000)) * 100, 100));
                rightindexer.data.value = reteNode.rightIndexerSize;

                indexer.children.push(rightindexer);

                indexer.children.push(memoryCons);

                node.children.push(indexer);
            }

            heatmap_rete.children.push(node);
        }
    }

}

// How to draw the heatmap of host resources
function hostHeatMap() {

    if (selectedNode == null) return;

    // Clear the previous data
    delete heatmap.children;
    heatmap.children = [];

    for (var i = 0; i < jsonData.machines.length; i++) {
        if (jsonData.machines[i].host == selectedNode.id) {
            selectedNode.data.os = jsonData.machines[i].os;
        }
    }

    // CPU part
    var cpu = {};
    cpu.name = "CPU Usage";
    cpu.id = selectedNode.id + "_cpu";
    cpu.data = {};
    cpu.data.$area = 200;
    cpu.children = [];

    var cpuUsage = {};
    cpuUsage.name = "CPU utilization";
    cpuUsage.id = selectedNode.id + "_cpuusage";
    cpuUsage.data = {};
    cpuUsage.data.$area = 200;
    cpuUsage.data.$color = percentToColor(selectedNode.data.os.cpuUsage.usedCPUPercent);
    cpuUsage.data.value = (truncateDecimals(selectedNode.data.os.cpuUsage.usedCPUPercent * 100) / 100) + " %";

    cpu.children.push(cpuUsage);

    heatmap.children.push(cpu);

    // Memory part
    var memory = {};
    memory.name = "Memory Usage";
    memory.id = selectedNode.id + "_memory";
    memory.data = {};
    memory.data.$area = 600;
    memory.children = [];

    var totalMemory = {};
    totalMemory.name = "Total available memory";
    totalMemory.id = selectedNode.id + "_totalmemory";
    totalMemory.data = {};
    totalMemory.data.$area = 200;
    totalMemory.data.$color = "#0000ff";
    totalMemory.data.value = (truncateDecimals(selectedNode.data.os.memoryUsage.totalMemory * 100) / 100) + " GB";

    memory.children.push(totalMemory);

    var usedMemory = {};
    usedMemory.name = "Used memory";
    usedMemory.id = selectedNode.id + "_usedmemory";
    usedMemory.data = {};
    usedMemory.data.$area = 200;
    usedMemory.data.$color = percentToColor(selectedNode.data.os.memoryUsage.usedMemoryPercent);
    usedMemory.data.value = (truncateDecimals(selectedNode.data.os.memoryUsage.usedMemoryPercent * 100) / 100) + " %<br/>(" +
        (truncateDecimals(selectedNode.data.os.memoryUsage.usedMemory * 100) / 100) + " GB)";

    memory.children.push(usedMemory);

    var freeMemory = {};
    freeMemory.name = "Free memory";
    freeMemory.id = selectedNode.id + "_freememory";
    freeMemory.data = {};
    freeMemory.data.$area = 200;
    freeMemory.data.$color = percentToColor(100 - selectedNode.data.os.memoryUsage.freeMemoryPercent);
    freeMemory.data.value = (truncateDecimals(selectedNode.data.os.memoryUsage.freeMemoryPercent * 100) / 100) + " %<br/>(" +
        (truncateDecimals(selectedNode.data.os.memoryUsage.freeMemory * 100) / 100) + " GB)";

    memory.children.push(freeMemory);

    heatmap.children.push(memory);

    // Disk I/O part
    var disks = {};
    disks.name = "Disk Usage";
    disks.id = selectedNode.id + "_disk";
    disks.data = {};
    disks.data.$area = selectedNode.data.os.diskUsages.length * 500;
    disks.children = [];

    // Add each disks
    for (var i = 0; i < selectedNode.data.os.diskUsages.length; i++) {
        var diskUsage = selectedNode.data.os.diskUsages[i];

        var disk = {};
        disk.name = "Usage of " + diskUsage.name;
        disk.id = selectedNode.id + "_disk" + i;
        disk.data = {};
        disk.data.$area = 500;
        disk.children = [];

        var diskQueue = {};
        diskQueue.name = "Disk queue";
        diskQueue.id = disk.id + "_queue";
        diskQueue.data = {};
        diskQueue.data.$area = 100;
        diskQueue.data.$color = percentToColor(Math.min((diskUsage.diskQueue / 10) * 100, 100));
        diskQueue.data.value = truncateDecimals(diskUsage.diskQueue * 100) / 100;

        disk.children.push(diskQueue);

        var diskReads = {};
        diskReads.name = "Disk reads";
        diskReads.id = disk.id + "_reads";
        diskReads.data = {};
        diskReads.data.$area = 100;
        diskReads.data.$color = percentToColor(Math.min((diskUsage.diskReads / 300) * 100, 100));
        diskReads.data.value = truncateDecimals(diskUsage.diskReads * 100) / 100;

        disk.children.push(diskReads);

        var diskWrites = {};
        diskWrites.name = "Disk writes";
        diskWrites.id = disk.id + "_writes";
        diskWrites.data = {};
        diskWrites.data.$area = 100;
        diskWrites.data.$color = percentToColor(Math.min((diskUsage.diskWrites / 150) * 100, 100));
        diskWrites.data.value = truncateDecimals(diskUsage.diskWrites * 100) / 100;

        disk.children.push(diskWrites);

        var diskReadBytes = {};
        diskReadBytes.name = "Disk bytes read";
        diskReadBytes.id = disk.id + "_readbytes";
        diskReadBytes.data = {};
        diskReadBytes.data.$area = 100;
        diskReadBytes.data.$color = percentToColor(Math.min((diskUsage.diskReadBytes / 3000000) * 100, 100));
        diskReadBytes.data.value = (truncateDecimals(diskUsage.diskReadBytes * 100) / 100) + " Byte/sec";

        disk.children.push(diskReadBytes);

        var diskWriteBytes = {};
        diskWriteBytes.name = "Disk bytes written";
        diskWriteBytes.id = disk.id + "_writebytes";
        diskWriteBytes.data = {};
        diskWriteBytes.data.$area = 100;
        diskWriteBytes.data.$color = percentToColor(Math.min((diskUsage.diskWriteBytes / 1500000) * 100, 100));
        diskWriteBytes.data.value = (truncateDecimals(diskUsage.diskWriteBytes * 100) / 100) + " Byte/sec";

        disk.children.push(diskWriteBytes);

        disks.children.push(disk);
    }

    heatmap.children.push(disks);

    // Network I/O part
    var network = {};
    network.name = "Network Usage";
    network.id = selectedNode.id + "_network";
    network.data = {};
    network.data.$area = selectedNode.data.os.netUsages.length * 500;
    network.children = [];

    for (var i = 0; i < selectedNode.data.os.netUsages.length; i++) {
        var netUsage = selectedNode.data.os.netUsages[i];

        var net = {};
        net.name = "Usage of " + netUsage.name + " (" + netUsage.address + ")";
        net.id = selectedNode.id + "_net" + i;
        net.data = {};
        net.data.$area = 500;
        net.children = [];

        var rxTraffic = {};
        rxTraffic.name = "RX Traffic";
        rxTraffic.id = net.id + "_rxtraffic";
        rxTraffic.data = {};
        rxTraffic.data.$area = 100;
        rxTraffic.data.$color = percentToColor(Math.min((netUsage.rxTraffic / 200) * 100, 100));
        rxTraffic.data.value = (truncateDecimals(netUsage.rxTraffic * 100) / 100) + " Kbit/sec";

        net.children.push(rxTraffic);

        var rxPackets = {};
        rxPackets.name = "RX Packets";
        rxPackets.id = net.id + "_rxpackets";
        rxPackets.data = {};
        rxPackets.data.$area = 100;
        rxPackets.data.$color = percentToColor(Math.min((netUsage.rxPackets / 200) * 100, 100));
        rxPackets.data.value = (truncateDecimals(netUsage.rxPackets * 100) / 100) + " Packets";

        net.children.push(rxPackets);

        var txTraffic = {};
        txTraffic.name = "TX Traffic";
        txTraffic.id = net.id + "_txtraffic";
        txTraffic.data = {};
        txTraffic.data.$area = 100;
        txTraffic.data.$color = percentToColor(Math.min((netUsage.txTraffic / 200) * 100, 100));
        txTraffic.data.value = (truncateDecimals(netUsage.txTraffic * 100) / 100) + " Kbit/sec";

        net.children.push(txTraffic);

        var txPackets = {};
        txPackets.name = "TX Packets";
        txPackets.id = net.id + "_txpackets";
        txPackets.data = {};
        txPackets.data.$area = 100;
        txPackets.data.$color = percentToColor(Math.min((netUsage.txPackets / 200) * 100, 100));
        txPackets.data.value = (truncateDecimals(netUsage.txPackets * 100) / 100) + " Packets";

        net.children.push(txPackets);

        network.children.push(net);

    }

    heatmap.children.push(network);
}

// Construct the object necessary to draw the JVM heatmap object
function JVMHeatMap() {

    if (selectedNode == null) return;

    // Clear the previous data
    delete heatmap_jvm.children;
    heatmap_jvm.children = [];

    var node = null;

    var host = selectedNode.id.split("@")[1];
    for (var i = 0; i < jsonData.machines.length; i++) {
        if (jsonData.machines[i].host == host) {
            var machine = jsonData.machines[i];
            for (var j = 0; j < machine.nodes.length; j++) {
                if (machine.nodes[j].name == selectedNode.id) {
                    node = machine.nodes[j];
                }
            }
        }
    }

    // CPU and related part
    var cpu = {};
    cpu.name = "CPU";
    cpu.id = selectedNode.id + "_jvm_cpu";
    cpu.data = {};
    cpu.data.$area = 100;
    cpu.children = [];

    var cpuUsage = {};
    cpuUsage.name = "CPU utilization";
    cpuUsage.id = selectedNode.id + "_jvm_cpuusage";
    cpuUsage.data = {};
    cpuUsage.data.$area = 100;
    cpuUsage.data.$color = percentToColor(node.cpuUtilization);
    cpuUsage.data.value = (truncateDecimals(node.cpuUtilization * 100) / 100) + " %";

    cpu.children.push(cpuUsage);

    heatmap_jvm.children.push(cpu);


    // Memory related metrics
    var memory = {};
    memory.name = "Memory";
    memory.id = selectedNode.id + "_jvm_memory";
    memory.data = {};
    memory.data.$area = 400;
    memory.children = [];

    var maxHeap = {};
    maxHeap.name = "Max heap size";
    maxHeap.id = selectedNode.id + "_jvm_maxheap";
    maxHeap.data = {};
    maxHeap.data.$area = 100;
    maxHeap.data.$color = "#0000FF";
    maxHeap.data.value = node.maxHeap + " MB";

    memory.children.push(maxHeap);

    var usedHeap = {};
    usedHeap.name = "Used heap";
    usedHeap.id = selectedNode.id + "_jvm_usedheap";
    usedHeap.data = {};
    usedHeap.data.$area = 100;

    var usedHeapPercent = node.usedHeapPercent;

    usedHeap.data.$color = percentToColor(usedHeapPercent);
    usedHeap.data.value = (truncateDecimals(usedHeapPercent * 100) / 100) + " %<br/>(" +
                (truncateDecimals(node.usedHeap * 100) / 100) + " MB)";

    memory.children.push(usedHeap);

    var maxNonHeap = {};
    maxNonHeap.name = "Max non-heap size";
    maxNonHeap.id = selectedNode.id + "_jvm_maxnonheap";
    maxNonHeap.data = {};
    maxNonHeap.data.$area = 100;
    maxNonHeap.data.$color = "#0000FF";
    maxNonHeap.data.value = node.maxNonHeap + " MB";

    memory.children.push(maxNonHeap);

    var usedNonHeap = {};
    usedNonHeap.name = "Used non-heap";
    usedNonHeap.id = selectedNode.id + "_jvm_usednonheap";
    usedNonHeap.data = {};
    usedNonHeap.data.$area = 100;

    var usedNonHeapPercent = node.usedNonHeapPercent;

    usedNonHeap.data.$color = percentToColor(usedNonHeapPercent);
    usedNonHeap.data.value = (truncateDecimals(usedNonHeapPercent * 100) / 100) + " %<br/>(" +
                (truncateDecimals(node.usedNonHeap * 100) / 100) + " MB)";

    memory.children.push(usedNonHeap);

    heatmap_jvm.children.push(memory);

    // Memory realted metrics
    var gc = {};
    gc.name = "GC";
    gc.id = selectedNode.id + "_jvm_gc";
    gc.data = {};
    gc.data.$area = 200;
    gc.children = [];

    var gcCount = {};
    gcCount.name = "GC collections";
    gcCount.id = selectedNode.id + "_jvm_gccount";
    gcCount.data = {};
    gcCount.data.$area = 100;
    gcCount.data.$color = percentToColor(Math.min((node.gcCollectionCount / 5) * 100, 100));
    gcCount.data.value = node.gcCollectionCount;

    gc.children.push(gcCount);

    var gcTime = {};
    gcTime.name = "GC time";
    gcTime.id = selectedNode.id + "_jvm_gctime";
    gcTime.data = {};
    gcTime.data.$area = 100;
    gcTime.data.$color = percentToColor(Math.min((node.gcCollectionTime / 1000) * 100, 100));
    gcTime.data.value = node.gcCollectionTime + " ms";

    gc.children.push(gcTime);

    heatmap_jvm.children.push(gc);

}


// Functions for heat map conversions

function percentToColor(percent) {
    if (percent >= 50) {
        return rgbToHex(255, Math.round(((1 - (percent / 100)) * 255)), 0);
    }
    if (percent <= 15) {
        return rgbToHex(0, Math.round((percent / 15) * 32) + 192, Math.round(((1 - (percent / 15)) * 240)));
    }
    return rgbToHex(Math.round(((percent - 15) / 35) * 224) + 31, Math.round(((1 - ((percent-15) / 35)) * 31)) + 200, 0);
}

// Functions to convert rgb values to hexa strings
function componentToHex(c) {
    var hex = c.toString(16);
    return hex.length == 1 ? "0" + hex : hex;
}

function rgbToHex(r, g, b) {
    return "#" + componentToHex(r) + componentToHex(g) + componentToHex(b);
}

truncateDecimals = function (number) {
    return Math[number < 0 ? 'ceil' : 'floor'](number);
};
// End of Heatmap related things **********************************************************************************************************************************************


// Check if the system structure has changed since the previous query
function hasSystemChanged() {

    if (graph == null) return true; // That's the first query, sure redraw then
   
    var numberOfNodes = 0; // To count how many server machines we had previously
    for (var j = 0; j < graph.length; j++) {
        if (graph[j].data.nodetype == "machine" || graph[j].data.nodetype == "process") {
            numberOfNodes++;
        }
    }

    var nodesFound = 0; // To count how many we found of them
    for (var i = 0; i < jsonData.machines.length; i++) {

        var machine = jsonData.machines[i];

        // Check if server machines were changed
        var found = false;
        for (var j = 0; j < graph.length; j++) {
            if (machine.host == graph[j].id) {
                found = true;
                nodesFound++;
                break;
            }
        }
        if (!found) return true; // If we couldn't find the machine then return true

        for (var k = 0; k < machine.nodes.length; k++) {
            var process = machine.nodes[k];

            found = false; // reuse this variable
            for (var j = 0; j < graph.length; j++) {
                if (process.name == graph[j].id) {
                    found = true;
                    nodesFound++;
                    break;
                }
            }
            if (!found) return true; // If we couldn't find the process then return true
        }

    }

    if (numberOfNodes != nodesFound) return true;

    return false; // Every component was found from previous query, the system hasn't changed sicne then

}

// Drawing the system as a graph
function drawSystem() {

    if (jsonData.machines.length == 0) {
        return; // If we didn't get machines then we don't draw anything
    }

    if (graph != null) delete graph;
    graph = [];

    var node = {};
    node.data = {};
    node.adjacencies = [];
//    node.data.$color = "#83548B";
    node.data.$color = "#000000";
    node.data.$type = "circle"; 
    node.id = "graphnode0";
    node.name = "";

    graph.push(node);

    for (var i = 0; i < jsonData.machines.length; i++) {
        var node = {};
        node.data = {};
        node.adjacencies = [];
        var adj = {};
        adj.nodeTo = "graphnode0";
        adj.nodeFrom = jsonData.machines[i].host;
        node.adjacencies.push(adj);
        node.data.$type = "host";
        //node.data.namecolor = '#' + jsonData.machines[i].host.toColor();
        node.id = jsonData.machines[i].host;
        node.name = jsonData.machines[i].host;
        node.data.nodetype = "machine";

        node.data.cpu = jsonData.machines[i].os.cpuUsage.usedCPUPercent;
        node.data.memory = jsonData.machines[i].os.memoryUsage.usedMemoryPercent;

        for (var j = 0; j < jsonData.machines[i].nodes.length; j++) {
            var process = jsonData.machines[i].nodes[j];
            var processNode = {};
            processNode.data = {};
            processNode.adjacencies = [];

            processNode.data.$type = "process";
            //processNode.data.namecolor = '#' + process.name.toColor();
            processNode.id = process.name;
            processNode.name = process.name;
            processNode.data.nodetype = "process";

            processNode.data.cpu = process.cpuUtilization;
            processNode.data.memory = process.usedHeapPercent;

            var processAdj = {};
            processAdj.nodeFrom = jsonData.machines[i].host;
            processAdj.nodeTo = process.name;
            node.adjacencies.push(processAdj);

            graph.push(processNode);
            
        }

        graph.push(node);
    }

    // init ForceDirected
    fd = new $jit.ForceDirected({
        //id of the visualization container
        injectInto: 'infovis',
        //Enable zooming and panning
        //with scrolling and DnD
        width: 800,
        height: 1100,
        Navigation: {
            enable: true,
            type: 'Native',
            //Enable panning events only if we're dragging the empty
            //canvas (and not a node).
            panning: 'avoid nodes',
            zooming: 10 //zoom speed. higher is more sensible
        },
        // Change node and edge styles such as
        // color and width.
        // These properties are also set per node
        // with dollar prefixed data-properties in the
        // JSON structure.
        Node: {
            overridable: true,
            dim: 7
        },
        Edge: {
            overridable: true,
            type: 'line',
            color: '#23A4FF',
            lineWidth: 4
        },
        // Add node events
        Events: {
            enable: true,
            enableForEdges: true,
            type: 'Native',
            //Change cursor style when hovering a node
            onMouseEnter: function () {
                fd.canvas.getElement().style.cursor = 'move';
            },
            onMouseLeave: function () {
                fd.canvas.getElement().style.cursor = '';
            },
            //Update node positions when dragged
            onDragMove: function (node, eventInfo, e) {
                var pos = eventInfo.getPos();
                node.pos.setc(pos.x, pos.y);
                fd.plot();
            },
            //Implement the same handler for touchscreens
            onTouchMove: function (node, eventInfo, e) {
                $jit.util.event.stop(e); //stop default touchmove event
                this.onDragMove(node, eventInfo, e);
            },
            onClick: function (node, eventInfo, e) {
                
            }
        },
        //Number of iterations for the FD algorithm
        iterations: 200,
        //Edge length
        levelDistance: 200,
        // This method is only triggered
        // on label creation and only for DOM labels (not native canvas ones).
        onCreateLabel: function (domElement, node) {
            // Create a 'name' and 'close' buttons and add them
            // to the main node label
            var nameContainer = document.createElement('span'),
                style = nameContainer.style;
            nameContainer.className = 'name';
            nameContainer.innerHTML = node.data.nodetype ? (node.data.nodetype + ": " + node.name) : "";
            domElement.appendChild(nameContainer);
            style.fontSize = "1em";
            //style.color = node.data.namecolor;
            style.color = "#000000";

            //Toggle a node selection when clicking
            //its name. This is done by animating some
            //node styles like its dimension and the color
            //and lineWidth of its adjacencies.
            nameContainer.onclick = function () {
                //set final styles
                fd.graph.eachNode(function (n) {
                    if (n.id != node.id) delete n.selected;
                    n.setData('dim', 7, 'end');
                    n.eachAdjacency(function (adj) {
                        adj.setDataset('end', {
                            lineWidth: 1.0,
                            color: '#23a4ff'
                        });
                    });
                });
                if (!node.selected) {
                    node.selected = true;
                    node.setData('dim', 17, 'end');
                    node.eachAdjacency(function (adj) {
                        adj.setDataset('end', {
                            lineWidth: 3,
                            color: '#ff0000'
                        });
                    });
                } else {
                    delete node.selected;
                }
                //trigger animation to final styles
                fd.fx.animate({
                    modes: ['node-property:dim',
                            'edge-property:lineWidth:color'],
                    duration: 500
                });
                
                if (selectedNode != null) delete selectedNode;
                selectedNode = node;

                if (selectedNode.data.nodetype == "machine") {
                    drawHeatMap(); // draw the heat map for the selected host machine
                }
                else if (selectedNode.data.nodetype == "process") drawJVMHeatMap(); // draw the heatmap for the JVM on the selcted host machine

                drawReteHeatMap(); // draw the heatmap for the Rete nodes on the selected host machine
                
            };
        },
        // Change node styles when DOM labels are placed
        // or moved.
        onPlaceLabel: function (domElement, node) {
            var style = domElement.style;
            var left = parseInt(style.left);
            var top = parseInt(style.top);
            var w = domElement.offsetWidth;
            style.left = (left - w / 4) + 'px';
            style.top = (top - 35) + 'px';
            style.display = '';
        }
    });
    // load JSON data.
    fd.loadJSON(graph);

    //load images
    fd.graph.eachNode(function (node) {
        if (node.getData('type') == 'host') {

            var image = images["server"];
            node.setData('image', image); // store this image object in node
            node.setData('height', image.height);
            node.setData('width', image.width);
            
        }
        else if (node.getData('type') == 'process') {

            var image = images["process"];
            node.setData('image', image); // store this image object in node
            node.setData('height', image.height);
            node.setData('width', image.width);

        }
    });


    // compute positions incrementally and animate.
    fd.computeIncremental({
        iter: 40,
        property: 'end',
        onStep: function (perc) {

        },
        onComplete: function () {

            fd.animate({
                modes: ['linear'],
                transition: $jit.Trans.Elastic.easeOut,
                duration: 2500
            });
        }
    });
    // end
}

// Update the data for the gauges on the system graph
function updateSystemGraph() {
    fd.graph.eachNode(function (node) {
        var labeltext = "";

        for (var i = 0; i < jsonData.machines.length; i++) {
            var machine = jsonData.machines[i];
            if (machine.host == node.id) {
                node.data.cpu = machine.os.cpuUsage.usedCPUPercent;
                node.data.memory = machine.os.memoryUsage.usedMemoryPercent;
                break;
            }
            for (var j = 0; j < machine.nodes.length; j++) {
                var process = machine.nodes[j];

                if (process.name == node.id) {
                    node.data.cpu = process.cpuUtilization;
                    node.data.memory = process.usedHeapPercent;
                    break;
                }
            }
        }

    });

    fd.plot();
}

// Set the measurement data from the server for the user selected node
function setDataForSelectedNode() {

    for (var i = 0; i < jsonData.machines.length; i++) {
        if (jsonData.machines[i].host == selectedNode.id) {
            selectedNode.data.os = jsonData.machines[i].os;
            selectedNode.data.nodes = jsonData.machines[i].nodes;

            break;
        }
    }

}

//Check if the Rete network has been changed since the last query
function hasReteNetworkChanged() {

    if (rete_graph == null ||jsonData.rete == null) return true;

    for (var i = 0; i < jsonData.rete.length; i++) {
        var reteNode = jsonData.rete[i];
        var foundNode = false;

        for (var j = 0; j < rete_graph.length; j++) {
            var graphNode = rete_graph[j];
            if (reteNode.reteNode == graphNode.id) {    // Then we found the graph node
                foundNode = true;
                for (var ii = 0; ii < reteNode.subscribers.length; ii++) {
                    var edgeFound = false;
                    for (var jj = 0; jj < graphNode.adjacencies.length; jj++) {
                        if (reteNode.subscribers[ii].reteNode == graphNode.adjacencies[jj].nodeTo) edgeFound = true; // We found the edge
                    }
                    if (!edgeFound) return true;
                }
            }
        }
        if (!foundNode) return true;
    }

    for (var i = 0; i < rete_graph.length; i++) {
        var graphNode = rete_graph[i];
        var foundNode = false;

        for (var j = 0; j < jsonData.rete.length; j++) {
            var reteNode = jsonData.rete[j];
            if (reteNode.reteNode == graphNode.id) {    // Then we found the Rete node
                foundNode = true;
                for (var ii = 0; ii < graphNode.adjacencies.length; ii++) {
                    var edgeFound = false;
                    for (var jj = 0; jj < reteNode.subscribers.length; jj++) {
                        if (graphNode.adjacencies[ii].nodeTo == reteNode.subscribers[jj].reteNode) edgeFound = true; // We found the edge
                    }
                    if (!edgeFound) return true;
                }
            }
        }
        if (!foundNode) return true;
    }

    return false;

}

// Rete network visualization functions **********************************************************************************************************************************************
// Drawing the system as a graph
function drawReteNet() {

    if (jsonData.rete == null || jsonData.rete.length == 0) {
        return;
    }

    if (rete_graph != null) delete rete_graph;
    rete_graph = [];

    for (var i = 0; i < jsonData.rete.length; i++) {
        var reteNode = jsonData.rete[i];

        var node = {};
        node.data = {};

        node.adjacencies = [];

        //node.data.hostcolor = '#' + reteNode.processName.toColor();
        //node.data.$color = '#6a49ba'
        node.data.$color = '#777777'


        if (reteNode.nodeClass == "Alpha") {
            node.data.$type = "alpha";
            node.data.nodetype = "alpha";
        }
        else if(reteNode.nodeClass == "Beta"){
            node.data.$type = "beta";
            node.data.nodetype = "beta";
            node.data.memory = reteNode.memory;
        }
        else if (reteNode.nodeClass == "Input") {
            node.data.$type = "memoryAlpha";
            node.data.nodetype = "input";
            node.data.memory = reteNode.memory;
        }
        else if (reteNode.nodeClass == "Production") {
            node.data.$type = "memoryAlpha";
            node.data.nodetype = "production";
            node.data.memory = reteNode.memory;
        }

        node.id = reteNode.reteNode;
        node.name = reteNode.nodeType.replace('Node','') + " " + reteNode.reteNode + " on ";
        node.data.host = reteNode.processName;
        

        for (var j = 0; j < reteNode.subscribers.length; j++) {
            var subsciber = reteNode.subscribers[j];

            var edge = {};
            edge.nodeTo = subsciber.reteNode;
            edge.nodeFrom = reteNode.reteNode;
            edge.data = {};
            edge.data.$type = 'label-arrow-line';
            edge.data.$direction = [];
            edge.data.$direction.push(reteNode.reteNode);
            edge.data.$direction.push(subsciber.reteNode);
            edge.data.labeltext = "Updates:" + reteNode.updateMessagesSent + "\nChanges:" + reteNode.changesCount;
            edge.data.slot = subsciber.slot;

            node.adjacencies.push(edge);
        }

        rete_graph.push(node);
    }

    // init ForceDirected
    fd_rete = new $jit.ForceDirected({
        //id of the visualization container
        injectInto: 'infovis-rete',
        //Enable zooming and panning
        //with scrolling and DnD
        width: 1400,
        height: 1100,
        Navigation: {
            enable: true,
            type: 'Native',
            //Enable panning events only if we're dragging the empty
            //canvas (and not a node).
            panning: 'avoid nodes',
            zooming: 10 //zoom speed. higher is more sensible
        },
        // Change node and edge styles such as
        // color and width.
        // These properties are also set per node
        // with dollar prefixed data-properties in the
        // JSON structure.
        Node: {
            overridable: true,
            dim: 7
        },
        Edge: {
            overridable: true,
            type: 'line',
            color: '#23A4FF',
            lineWidth: 4
        },
        // Add node events
        Events: {
            enable: true,
            enableForEdges: true,
            type: 'Native',
            //Change cursor style when hovering a node
            onMouseEnter: function () {
                fd_rete.canvas.getElement().style.cursor = 'move';
            },
            onMouseLeave: function () {
                fd_rete.canvas.getElement().style.cursor = '';
            },
            //Update node positions when dragged
            onDragMove: function (node, eventInfo, e) {
                var pos = eventInfo.getPos();
                node.pos.setc(pos.x, pos.y);
                fd_rete.plot();
            },
            //Implement the same handler for touchscreens
            onTouchMove: function (node, eventInfo, e) {
                $jit.util.event.stop(e); //stop default touchmove event
                this.onDragMove(node, eventInfo, e);
            }
        },
        Tips: {
            enable: true,
            //add positioning offsets
            offsetX: 20,
            offsetY: 20,
            //implement the onShow method to
            //add content to the tooltip when a node
            //is hovered
            onShow: function (tip, node, isLeaf, domElement) {
                var html = "<div class=\"tip-title\">" + node.name + node.data.host
                  + "</div><div class=\"tip-text\">";

                var reteNode = null;
                for (var i = 0; i < jsonData.rete.length; i++) {
                    if (jsonData.rete[i].reteNode == node.id) {
                        reteNode = jsonData.rete[i];
                        break;
                    }
                }

                var consumedMemory = "Memory consumed: " + (truncateDecimals(reteNode.memory * 100) / 100) + " MB";

                if (reteNode.nodeClass == "Input") {
                    html += "Memory size: " + reteNode.tuples + "<br />";
                    html += consumedMemory;
                }
                else if (reteNode.nodeClass == "Production") {
                    html += consumedMemory;
                }
                else if (reteNode.nodeClass == "Beta") {
                    html += "Left indexer: " + reteNode.leftIndexerSize + "<br />";
                    html += "Right indexer: " + reteNode.rightIndexerSize + "<br />";
                    html += consumedMemory;
                }
                tip.innerHTML = html;
            }
        },
        //Number of iterations for the FD algorithm
        iterations: 400,
        //Edge length
        levelDistance: 200,
        // This method is only triggered
        // on label creation and only for DOM labels (not native canvas ones).
        onCreateLabel: function (domElement, node) {
            // Create a 'name' button and add it
            // to the main node label
            var nameContainer = document.createElement('span'),
                style = nameContainer.style;
            nameContainer.className = 'name';
            nameContainer.innerHTML = node.name;
            domElement.appendChild(nameContainer);
            style.fontSize = "1em";
            style.color = "#000";

            var nameContainer2 = document.createElement('span'),
                style2 = nameContainer2.style;
            nameContainer2.className = 'name';
            nameContainer2.innerHTML = node.data.host;
            domElement.appendChild(nameContainer2);
            style2.fontSize = "1em";
            //style2.color = node.data.hostcolor;
            style2.color = "#ee0000";

        },
        // Change node styles when DOM labels are placed
        // or moved.
        onPlaceLabel: function (domElement, node) {
            var style = domElement.style;
            var left = parseInt(style.left);
            var top = parseInt(style.top);
            var w = domElement.offsetWidth;
            style.left = (left - w / 2) + 'px';
            style.top = (top - 50) + 'px';
            style.display = '';
        }
    });
    // load JSON data.
    fd_rete.loadJSON(rete_graph);

    // compute positions incrementally and animate.
    fd_rete.computeIncremental({
        iter: 160,
        property: 'end',
        onStep: function (perc) {

        },
        onComplete: function () {

            fd_rete.animate({
                modes: ['linear'],
                transition: $jit.Trans.Elastic.easeOut,
                duration: 2500
            });
        }
    });
    // end
}

function updateReteNetGraph() {

    fd_rete.graph.eachNode(function (node) {
        var labeltext = "";

        for (var i = 0; i < jsonData.rete.length; i++) {
            var reteNode = jsonData.rete[i];
            if (reteNode.reteNode == node.id) {
                if (reteNode.nodeClass == "Input" || reteNode.nodeClass == "Production" || reteNode.nodeClass == "Beta") node.data.memory = reteNode.memory;
                labeltext = "Updates:" + reteNode.updateMessagesSent + "\nChanges:" + reteNode.changesCount;
                break;
            }
        }

        node.eachAdjacency(function (adj) {
            if (adj.data.$direction[0] == node.id) adj.data.labeltext = labeltext;
        });
    });

    fd_rete.plot();
}

function hashCode(str) { // java String#hashCode
    var hash = 0;
    if (str.length == 0) return hash;
    for (i = 0; i < str.length; i++) {
        char = str.charCodeAt(i);
        hash = ((hash << 5) - hash) + char;
        hash = hash & hash; // Convert to 32bit integer
    }
    return hash;
}

function intToARGB(i) {
    return ((i >> 24) & 0xFF).toString(16) +
           ((i >> 16) & 0xFF).toString(16) +
           ((i >> 8) & 0xFF).toString(16);
}

String.prototype.toColor = function () {
    var r = 0, g = 0, b = 0;
    for (var i = 0; i < this.length ; i++) {
        r += 3187 * this.charCodeAt(i);
    }
    for (var i = 0; i < this.length ; i++) {
        g += 3967 * this.charCodeAt(i);
    }
    for (var i = 0; i < this.length; i++) {
        b += 2333 * this.charCodeAt(i);
    }

    return ((r % 255) & 0xFF).toString(16) +
           ((g % 255) & 0xFF).toString(16) +
           ((b % 255) & 0xFF).toString(16);
}


// Query results **********************************************************************************************************************************************
function checkQueryResults() {
    if (resultCount < jsonData.changes) {

        clearTimeout(globalMonitoringTimer); // Cancel the current main query to the monitoring server

        $.getJSON('/results', function (data) {
            updateQueryResults(data);
        });

    }
}

function updateQueryResults(data) {
    if (resultsTable == null) {
        if (data.length == 0) {
            return;
        }
        var columns = [];

        var tupleLength = data[0].tuple.length;

        for (var i = 0; i < tupleLength; i++) {
            columns.push({ "title": i + '.' });
        }

        resultsTable = $('#results').DataTable({
            "scrollY": "750px",
            "scrollCollapse": true,
            "paging": false,
            "ordering": false,
            "deferRender": true,
            scrollCollapse: true,
            "columns": columns
        });
    }

    resultsTable.clear();

    var length = data.length;

    setTimeout(function () {
        updateResultsTable(data, 0, length);
    }, 0);
}

// This method is for adding the new rows to the results table by 1000 and not all of them by once so the UI stays responsive
function updateResultsTable(data, from, length) {
    var last = false;
    var to = from + 200;

    if (from + 200 >= length) {
        last = true;
        to = length;
    }

    for (var i = from; i < to; i++) {
        var tuple = data[i].tuple;

        var values = [];
        for (var j = 0; j < tuple.length; j++) {
            values.push(tuple[j]);
        }
        resultsTable.row.add(values);
    }

    

    if (! last) {
        setTimeout(function () {
            updateResultsTable(data, to, length);
        }, 4);
    }
    else{
        resultsTable.draw();
        getDeltaChanges();
    }
}

function getDeltaChanges() {
    $.getJSON('/deltas?from=' + resultCount, function (data) {
        updateDeltaChanges(data);
    });
}

function updateDeltaChanges(data) {
    if (deltaTable == null) {
        if (data.length == 0) {
            return;
        }

        var columns = [];

        var tupleLength = data[0].tuple.tuple.length;

        columns.push({ "title": "Change type" });

        for (var i = 0; i < tupleLength; i++) {
            columns.push({ "title": i + '.' });
        }

        deltaTable = $('#deltas').DataTable({
            "scrollY": "750px",
            "scrollCollapse": true,
            "paging": false,
            "ordering": false,
            "deferRender": true,
            scrollCollapse: true,
            "columns": columns
        });
    }

    var deltasLength = data.length;

    setTimeout(function () {
        updateDeltaTable(data, deltasLength, 0);
    }, 0);

}

function updateDeltaTable(data, deltasLength, from) {
    var last = false;
    var to = from + 200;

    if (from + 200 >= deltasLength) {
        last = true;
        to = deltasLength;
    }

    for (var i = from; i < to; i++) {
        var tuple = data[i].tuple.tuple;
        var changeDirection = data[i].changed;

        var values = [];
        values.push(changeDirection);
        for (var k = 0; k < tuple.length; k++) {
            values.push(tuple[k]);
        }
        deltaTable.row.add(values);
    }

    if (!last) {
        setTimeout(function () {
            updateDeltaTable(data, deltasLength, to);
        }, 4);
    }
    else {
        resultCount = jsonData.changes;
        deltaTable.draw();
        globalMonitoringTimer = setTimeout(function () { visualizeSystem(); }, 0);
    }
}

// Other things **********************************************************************************************************************************************

// Load the images when the document is ready
function loadImages() {
    var serverImage = new Image();
    serverImage.src = "server-icon.png";

    var processImage = new Image();
    processImage.src = "process-icon.png";

    images = {
        server: serverImage,
        process: processImage
    };
}