from werkzeug.wrappers import Request, Response
import urllib
import zipfile
import subprocess
import os
import stat
import time
import shutil

@Request.application
def application(request):
    projectName = "hu.bme.mit.incqueryd.runtime"
    shutil.rmtree(projectName, True)
    opener = urllib.URLopener()
    fileName = projectName + ".zip"
    opener.retrieve("https://build.inf.mit.bme.hu/jenkins/job/IncQuery-D_Runtime_New/lastSuccessfulBuild/artifact/" + projectName + "/*zip*/" + fileName, fileName)
    file = open(fileName, "rb")
    zip = zipfile.ZipFile(file)
    zip.extractall(".")
    file.close()
    os.remove(fileName)
    startScript = projectName + "/scripts/start.sh"
    oldStats = os.stat(startScript)
    os.chmod(startScript, oldStats.st_mode | stat.S_IEXEC)
    subprocess.Popen([startScript])
    time.sleep(10) # XXX
    return Response(status = 200)

if __name__ == '__main__':
    from werkzeug.serving import run_simple
    os.chdir(os.path.dirname(os.path.abspath(__file__)))
    print os.getcwd()
    run_simple('localhost', 4242, application)