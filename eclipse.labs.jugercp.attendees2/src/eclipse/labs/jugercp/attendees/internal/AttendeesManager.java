package eclipse.labs.jugercp.attendees.internal;

import java.util.ArrayList;
import java.util.List;

import eclipse.labs.jugercp.attendees.IAttendee;
import eclipse.labs.jugercp.attendees.IAttendeeListener;
import eclipse.labs.jugercp.attendees.IAttendeesManager;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 * 
 * Date : september 2009
 */
public class AttendeesManager implements IAttendeesManager {

	private List<IAttendee> attendees;
	
	private List<IAttendeeListener> listAttendeeListener;
	
	public AttendeesManager() {
		attendees = new ArrayList<IAttendee>();
		listAttendeeListener = new ArrayList<IAttendeeListener>();
	}
	
	@Override
	public void addAttendee(IAttendee pAttendee) {
		this.attendees.add(pAttendee);
		
		for(IAttendeeListener current : listAttendeeListener) {
			current.attendeeAdded(pAttendee);
		}
	}

	@Override
	public List<IAttendee> getAllAttendees() {
		return attendees;
	}

	@Override
	public IAttendee getAttendeeAt(int p) {		
		try {
			return attendees.get(p);
		} catch(IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public int getAttendeesCount() {		
		return attendees.size();
	}

	@Override
	public void removeAttendee(IAttendee pAttendee) {
		attendees.remove(pAttendee);
		
		for(IAttendeeListener current : listAttendeeListener) {
			current.attendeeRemoved(pAttendee);
		}
	}

	@Override
	public void removeAllAttendees() {
		attendees.clear();	
		
		for(IAttendeeListener current : listAttendeeListener) {
			current.allAttendeeRemoved();
		}
	}

	@Override
	public void addAttendeeListener(IAttendeeListener p) {
		this.listAttendeeListener.add(p);
	}

	@Override
	public void updateAttendee(IAttendee pAttendee) {
		for(IAttendeeListener current : listAttendeeListener) {
			current.attendedUpdated(pAttendee);
		}		
	}
}
