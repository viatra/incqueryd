package hu.bme.mit.incqueryd.tooling.ide;

import hu.bme.mit.incqueryd.tooling.ide.util.InstallerUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import com.google.common.base.Throwables;
import com.google.common.io.ByteStreams;
import com.google.common.io.Files;
import com.google.common.io.Resources;

public class DownloadInstallerHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		new Job("Downloading installer") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					URL installerUrl = new URL("https://build.inf.mit.bme.hu/jenkins/job/IncQuery-D_Runtime/lastSuccessfulBuild/artifact/*zip*/archive.zip");
					File tempDir = Files.createTempDir();
					tempDir.deleteOnExit();
					File installer = new File(tempDir, "installer.zip");
					download(installerUrl, installer);
					extract(installer, tempDir);
					File extractedDirectory = new File(tempDir, "archive"); // XXX Jenkins artifact layout
					File installerDirectory = InstallerUtils.getActualInstallerRoot();
					FileUtils.copyDirectory(extractedDirectory, installerDirectory);
				} catch (IOException e) {
					Throwables.propagate(e);
				}
				return Status.OK_STATUS;
			}
		}.schedule();
		return null;
	}

	public static void download(URL url, File file) throws IOException {
		file.getParentFile().mkdirs();
		ByteStreams.copy(Resources.newInputStreamSupplier(url), Files.newOutputStreamSupplier(file));
	}

	public static void extract(File source, File targetDirectory) throws IOException {
        ZipFile zipFile = new ZipFile(source);
        for (ZipEntry zipEntry : Collections.list(zipFile.entries())) {
            File file = new File(targetDirectory, zipEntry.getName());
            if (zipEntry.isDirectory()) {
                file.mkdirs();
            } else {
            	if ("sh".equals(FilenameUtils.getExtension(file.getName()))) { // XXX workaround for zip not preserving permissions
            		file.setExecutable(true);
            	}
            	file.getParentFile().mkdirs();
            	ByteStreams.copy(zipFile.getInputStream(zipEntry), new FileOutputStream(file));
            }
        }
        zipFile.close();
	}

}
