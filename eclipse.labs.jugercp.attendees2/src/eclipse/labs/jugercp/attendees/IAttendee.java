package eclipse.labs.jugercp.attendees;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 * 
 * Date : september 2009
 */
public interface IAttendee {
	/**
	 * Retrieve the name of the attendee.
	 * 
	 * @return name of the attendee
	 */
	String getName();
	
	/**
	 * Replace the name of the attendee.
	 * 
	 * @param pName new name of the attendee. 
	 */
	void setName(String pName);
	
	/**
	 * Retrieve the name of the company of attendee.
	 * 
	 * @return name of the company of attendee.
	 */
	String getCompany();
	
	/**
	 * Replace the name of the company of attendee.
	 * 
	 * @param pCompany new name of the company of attendee.
	 */
	void setCompany(String pCompany);
	
	/**
	 * Retrieve the unique identifier of attendee.
	 * 
	 * @return the unique identifier of attendee.
	 */
	int getId();
}
