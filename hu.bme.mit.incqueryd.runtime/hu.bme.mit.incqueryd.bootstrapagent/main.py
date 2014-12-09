from werkzeug.wrappers import Request, Response
import urllib
import zipfile
import subprocess
import os
import stat

@Request.application
def application(request):
    opener = urllib.URLopener()
    projectName = "hu.bme.mit.incqueryd.runtime"
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
    output = subprocess.check_output([startScript])
    return Response(output)

if __name__ == '__main__':
    from werkzeug.serving import run_simple
    run_simple('localhost', 4242, application)