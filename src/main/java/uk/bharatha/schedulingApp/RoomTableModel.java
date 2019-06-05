package uk.bharatha.schedulingApp;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class RoomTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Room", "Number of Meetings", "Slots taken"}; //same as before...
    private Object[][] data = {{}};//same as before...
    private ArrayList<Object[]> dataList = new ArrayList<Object[]>();
    private ArrayList<Room> roomsList = new ArrayList<Room>();

    public RoomTableModel() {
    }
    
    public void clearData() {
        roomsList.clear();
        dataList.clear();
        refreshTable();
    }
    
    public void addRoom(Room room) {
        roomsList.add(room);
        int meetingNum = room.getMeetings().size();
        Object[] roomData = {room.getID(), meetingNum, String.format("   %d/8", meetingNum)};
        dataList.add(roomData);
        refreshTable();
    }
    
    public void removeRoom(Room room) {
        dataList.remove(roomsList.indexOf(room));
        roomsList.remove(room);
        refreshTable();
    }
    
    public Room getRoomAtIndex(int indx) {
        return roomsList.get(indx);
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


    public String getColumnName(int col) {
        return columnNames[col];
    }


    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
