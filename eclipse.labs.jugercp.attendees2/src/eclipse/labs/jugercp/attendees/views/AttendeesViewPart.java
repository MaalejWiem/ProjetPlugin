package eclipse.labs.jugercp.attendees.views;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.part.ViewPart;

import eclipse.labs.jugercp.attendees.Activator;
import eclipse.labs.jugercp.attendees.IAttendee;
import eclipse.labs.jugercp.attendees.IAttendeeListener;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 * 
 * Date : september 2009
 */
public class AttendeesViewPart extends ViewPart {

	public AttendeesViewPart() {
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, true));

		final TableViewer viewer = new TableViewer(parent, SWT.FULL_SELECTION);
		viewer.setUseHashlookup(true);
		viewer.setContentProvider(new MyStructuredContentProvider());

		TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
		column.setLabelProvider(new ColumnLabelProvider() {
			public Color getBackground(Object element) {
				return Display.getDefault().getSystemColor(SWT.COLOR_WHITE);
			}

			public String getText(Object element) {
				IAttendee currentAttendee = (IAttendee) element;
				return Integer.toString(currentAttendee.getId());
			}
		});
		column.getColumn().setText("Id");

		
		column = new TableViewerColumn(viewer, SWT.NONE);
		column.setLabelProvider(new ColumnLabelProvider() {
			public Color getBackground(Object element) {
				return Display.getDefault().getSystemColor(SWT.COLOR_WHITE);
			}

			public String getText(Object element) {
				IAttendee currentAttendee = (IAttendee) element;
				return currentAttendee.getName();
			}
		});
		column.getColumn().setText("Nom");

		column = new TableViewerColumn(viewer, SWT.NONE);
		column.setLabelProvider(new ColumnLabelProvider() {
			public Color getBackground(Object element) {
				return Display.getDefault().getSystemColor(SWT.COLOR_WHITE);
			}

			public String getText(Object element) {
				IAttendee currentAttendee = (IAttendee) element;
				return currentAttendee.getCompany();
			}

		});
		column.getColumn().setText("Société");

		GridData myGridData = new GridData(GridData.FILL_BOTH);
		viewer.getControl().setLayoutData(myGridData);
		viewer.setInput(Activator.getDefault().getAttendeesManager().getAllAttendees());

		Table table = viewer.getTable();
		table.setLayoutData(new GridData(GridData.FILL_BOTH));

		for (int i = 0, n = table.getColumnCount(); i < n; i++) {
			table.getColumn(i).setWidth(100);
		}

		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		Activator.getDefault().getAttendeesManager().addAttendeeListener(new IAttendeeListener() {			
			@Override
			public void attendeeRemoved(IAttendee p) {
				viewer.refresh(p);
			}
			
			@Override
			public void attendeeAdded(IAttendee p) {
				viewer.refresh();				
			}
			
			@Override
			public void allAttendeeRemoved() {
				viewer.refresh();				
			}

			@Override
			public void attendedUpdated(IAttendee p) {
				viewer.refresh(p);				
			}
		});
	}

	@Override
	public void setFocus() {
	}

	static class MyStructuredContentProvider implements
			IStructuredContentProvider {
		@SuppressWarnings("unchecked")
		public Object[] getElements(Object inputElement) {
			ArrayList<IAttendee> localInputElement = (ArrayList<IAttendee>) inputElement;
			return localInputElement.toArray();
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}
}
