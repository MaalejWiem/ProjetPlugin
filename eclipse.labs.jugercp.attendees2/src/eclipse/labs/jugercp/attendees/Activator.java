package eclipse.labs.jugercp.attendees;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import eclipse.labs.jugercp.attendees.internal.Attendee;
import eclipse.labs.jugercp.attendees.internal.AttendeesManager;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 * 
 * Date : september 2009
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "eclipse.labs.jugercp.attendees";

	// The shared instance
	private static Activator plugin;
	
	private IAttendeesManager refAttendeesManager;
	
	private int count = 0;
	
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;	
		refAttendeesManager = new AttendeesManager();
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		refAttendeesManager.removeAllAttendees();
		super.stop(context);
		System.out.println(+count);
	}

	public IAttendeesManager getAttendeesManager() {
		return refAttendeesManager;
	}
	
	public IAttendee createAttendee(String pName, String pCompanyName) {		
		return new Attendee(pName, pCompanyName, count++);
	}
	
	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
