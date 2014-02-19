package eclipse.labs.jugercp.attendees;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 * 
 * Date : september 2009
 */
public interface IAttendeeListener {
	void attendeeAdded(IAttendee p);
	
	void attendeeRemoved(IAttendee p);
	
	void allAttendeeRemoved();
	
	void attendedUpdated(IAttendee p);
}
