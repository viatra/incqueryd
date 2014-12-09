from werkzeug.wrappers import Request, Response
import urllib
import zipfile
import subprocess

@Request.application
def application(request):
    opener = urllib.URLopener()
    projectName = "hu.bme.mit.incqueryd.runtime"
    fileName = projectName + ".zip"
    opener.retrieve("https://build.inf.mit.bme.hu/jenkins/job/IncQuery-D_Runtime_New/ws/" + projectName + "/*zip*/" + fileName, fileName)
    file = open(fileName, "rb")
    zip = zipfile.ZipFile(file)
    zip.extractall(".")
    file.close()
    os.remove(fileName)
    output = subprocess.check_output([projectName + "/scripts/start.sh"])
    return Response(output)

if __name__ == '__main__':
    from werkzeug.serving import run_simple
    run_simple('localhost', 4242, application)