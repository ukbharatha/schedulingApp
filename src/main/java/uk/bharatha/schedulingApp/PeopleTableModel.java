package uk.bharatha.schedulingApp;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * A table model for the PeopleTable used on the PeopleMenu. 
 * It is an extension of AbstractTableModel with extra functionality.
 */
public class PeopleTableModel extends AbstractTableModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String[] columnNames = {"First", "Last", "Email"};//same as before...
    private Object[][] data;
    private final ArrayList<Object[]> dataList = new ArrayList<Object[]>();
    private final ArrayList<Person> peopleList = new ArrayList<Person>();

    public PeopleTableModel() {
        this.data = new Object[][]{};
    }
    
    public void clearData() {
        peopleList.clear();
        dataList.clear();
        refreshTable();
    }
    
    public void addPerson(Person pers) {
        peopleList.add(pers);
        Object[] meetData = {pers.getFirstName(), pers.getLastName(), pers.getemail()};
        dataList.add(meetData);
        refreshTable();
    }
    
    public void removeMeeting(Person pers) {
        dataList.remove(peopleList.indexOf(pers));
        peopleList.remove(pers);
        refreshTable();
    }
    
    public Person getPersonAtIndex(int indx) {
        return peopleList.get(indx);
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

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
