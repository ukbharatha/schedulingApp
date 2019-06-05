
package uk.bharatha.schedulingApp;

import javax.swing.table.DefaultTableModel;

/**
 * The table model used to manage data in the MeetingScheduleTable that is used on the MainMenu.
 * It is an extension of the DefaultTableModel, but with added custom functionality to ease it's use.
 */
public class MeetingScheduleTableModel extends DefaultTableModel {

    public MeetingScheduleTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return false; //To change body of generated methods, choose Tools | Templates.
    }
}
