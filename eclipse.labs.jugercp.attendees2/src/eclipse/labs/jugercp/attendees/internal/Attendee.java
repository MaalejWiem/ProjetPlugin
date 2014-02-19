package eclipse.labs.jugercp.attendees.internal;

import eclipse.labs.jugercp.attendees.IAttendee;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 * 
 * Date : september 2009
 */
public class Attendee implements IAttendee {

	private String companyName;
	
	private String attendeeName;
	
	private int id;
	
	public Attendee(String pAttendeeName, String pCompanyName, int pId) {
		this.companyName = pCompanyName;
		this.attendeeName = pAttendeeName;
		this.id = pId;
	}
	
	@Override
	public String getCompany() {
		return companyName;
	}

	@Override
	public String getName() {
		return attendeeName;
	}

	@Override
	public void setCompany(String pCompany) {
		this.companyName = pCompany;
	}

	@Override
	public void setName(String pName) {
		this.attendeeName = pName;
	}

	@Override
	public int getId() {
		return id;
	}
}
