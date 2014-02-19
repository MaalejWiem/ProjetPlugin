package eclipse.labs.jugercp.attendees.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import eclipse.labs.jugercp.attendees.Activator;
import eclipse.labs.jugercp.attendees.IAttendee;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 * 
 * Date : september 2009
 */
public class AttendeeViewPart extends ViewPart {

	public AttendeeViewPart() {
	}

	@Override
	public void createPartControl(Composite parent) {
		GridLayout myGridLayout = new GridLayout(2,false);
		parent.setLayout(myGridLayout);
		
		Label attendeeNameLabel = new Label(parent, SWT.NONE);
		attendeeNameLabel.setText("Nom : ");
		
		final Text attendeeNameValue = new Text(parent, SWT.BORDER);
		GridData myGridData = new GridData(GridData.FILL_HORIZONTAL);
		attendeeNameValue.setLayoutData(myGridData);
		
		Label companyNameLabel = new Label(parent, SWT.NONE);
		companyNameLabel.setText("Société : ");
		
		final Text companyNameValue = new Text(parent, SWT.BORDER);
		myGridData = new GridData(GridData.FILL_HORIZONTAL);
		companyNameValue.setLayoutData(myGridData);
		
		Button newAttendee = new Button(parent, SWT.FLAT);
		newAttendee.setText("Ajouter");		
		newAttendee.addSelectionListener(new SelectionListener() {			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Add
				Activator currentActivator = Activator.getDefault();
				IAttendee createAttendee = currentActivator.createAttendee(attendeeNameValue.getText(), 
						companyNameValue.getText());				
				Activator.getDefault().getAttendeesManager().addAttendee(createAttendee);
				
				attendeeNameValue.setText("");
				companyNameValue.setText("");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {		
			}
		});
		
		Button updateAttendee = new Button(parent, SWT.FLAT);
		updateAttendee.setText("Mise à jour");		
		updateAttendee.addSelectionListener(new SelectionListener() {			
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {		
			}
		});
	}

	@Override
	public void setFocus() {
	}
}
