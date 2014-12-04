package hu.bme.mit.incqueryd.tooling.ide;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;
import hu.bme.mit.incqueryd.tooling.ide.util.EditorUtils;
import inventory.InstanceSet;
import inventory.Inventory;
import inventory.MachineInstance;

import java.io.IOException;
import java.text.MessageFormat;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

public class InstallInfrastructureHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		try {
			final IFile inventoryFile = EditorUtils.getCurrentlyOpenFile();
			Inventory inventory = ArchUtil.loadInventory(inventoryFile.getLocation().toFile());
			Iterable<InstanceSet> instanceSets = Iterables.filter(ImmutableList.of(inventory.getMachineSet()), InstanceSet.class);
			for (InstanceSet instanceSet : instanceSets) {
				for (final MachineInstance instance : instanceSet.getMachineInstances()) {
					new Job(MessageFormat.format("Installing infrastructure on instance {0}", instance.getIp())) {
						@Override
						protected IStatus run(IProgressMonitor monitor) {
							try {
								HttpResponse response = install(instance.getIp());
								if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
									return Status.OK_STATUS;
								} else {
									return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Bad response: " + response);
								}
							} catch (IOException e) {
								throw Throwables.propagate(e);
							}
						}
					}.schedule();
				}
			}
		} catch (IOException e) {
			throw new ExecutionException("Failed to load inventory file", e);
		}
		return null;
	}

	public static HttpResponse install(final String ip) throws IOException, ClientProtocolException { // TODO extract to bootstrap agent interface
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(MessageFormat.format("http://{0}:{1}", ip, 4242));
		HttpResponse response = client.execute(get);
		return response;
	}

}
