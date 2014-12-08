from werkzeug.wrappers import Request, Response
import urllib
import zipfile
import subprocess

@Request.application
def application(request):
    opener = urllib.URLopener()
    path = "archive.zip"
    opener.retrieve("https://build.inf.mit.bme.hu/jenkins/job/IncQuery-D_Runtime_New/lastSuccessfulBuild/artifact/*zip*/" + path, path)
    file = open(path, "rb")
    zip = zipfile.ZipFile(file)
    zip.extractall(".")
    file.close()
    os.remove(path)
    output = subprocess.check_output(["archive/scripts/start.sh"])
    return Response(output)

if __name__ == '__main__':
    from werkzeug.serving import run_simple
    run_simple('localhost', 4242, application)