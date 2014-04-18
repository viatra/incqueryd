package hu.bme.mit.incqueryd.tooling.scriptgenerator;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.IOUtils;
import net.schmizz.sshj.connection.ConnectionException;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.connection.channel.direct.Session.Command;
import net.schmizz.sshj.transport.TransportException;
import net.schmizz.sshj.transport.verification.HostKeyVerifier;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;


public class SSHFacade {

    protected SSHClient ssh;

    public SSHFacade(final String hostname, final String username) throws IOException {
        ssh = new SSHClient();
        ssh.loadKnownHosts();
        final HostKeyVerifier hostKeyVerifier = new PromiscuousVerifier();
        ssh.addHostKeyVerifier(hostKeyVerifier);
        
        ssh.connect(hostname);
        ssh.authPublickey(username);
    }

    public void startSession() throws ConnectionException, TransportException, IOException {
        final Session session = ssh.startSession();
        try {
            //final String commandString = "ls -la";
            final String commandString = 
                    "nohup /home/szarnyasg/akka-2.2.3/bin/akka hu.bme.mit.incqueryd.tooling.actors.IncQueryDKernel > akka.out 2> akka.err < /dev/null &";
            final Command cmd = session.exec(commandString);
            System.out.println(IOUtils.readFully(cmd.getInputStream()).toString());
            cmd.join(1, TimeUnit.SECONDS);
            System.out.println("\nExit status: " + cmd.getExitStatus());
        } finally {
            session.close();
        }
    }
    
    public void runAkka() {
        
    }

    public void stop() throws IOException {
        if (ssh != null) {
            ssh.disconnect();
            ssh.close();
        }        
    }

}