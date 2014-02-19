package eclipse.labs.jugercp.attendees;

import java.util.List;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 * 
 * Date : september 2009
 */
public interface IAttendeesManager {
	void addAttendee(IAttendee pAttendee);
	
	void removeAttendee(IAttendee pAttendee);
	
	void updateAttendee(IAttendee pAttendee);
	
	List<IAttendee> getAllAttendees();
	
	int getAttendeesCount();
	
	IAttendee getAttendeeAt(int p);
	
	void removeAllAttendees();
	
	void addAttendeeListener(IAttendeeListener p);
}
