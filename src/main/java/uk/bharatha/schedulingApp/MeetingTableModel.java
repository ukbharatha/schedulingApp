package uk.bharatha.schedulingApp;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class MeetingTableModel extends AbstractTableModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String[] columnNames = {"Title", "Room", "Time", "Attendees"};//same as before...
    private Object[][] data;
    private final ArrayList<Object[]> dataList = new ArrayList<Object[]>();
    private final ArrayList<Meeting> meetingsList = new ArrayList<Meeting>();

    public MeetingTableModel() {
        this.data = new Object[][]{};
    }
    
    public void clearData() {
        meetingsList.clear();
        dataList.clear();
        refreshTable();
    }
    
    public void addMeeting(Meeting meet) {
        meetingsList.add(meet);
        Object[] meetData = {meet.getTitle(), meet.getRoomID(), meet.getFormattedTimeSlot(), meet.getAttendees().size()};
        dataList.add(meetData);
        refreshTable();
    }
    
    public void removeMeeting(Meeting meet) {
        dataList.remove(meetingsList.indexOf(meet));
        meetingsList.remove(meet);
        refreshTable();
    }
    
    public Meeting getMeetingAtIndex(int indx) {
        return meetingsList.get(indx);
    }
    
    public void refreshTable() {
        data = dataList.toArray(new Object[dataList.size()][]);
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    @SuppressWarnings("unchecked")
	@Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
