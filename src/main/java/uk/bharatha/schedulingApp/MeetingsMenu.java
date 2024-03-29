package uk.bharatha.schedulingApp;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * The menu that appears when you click "Meetings" on main menu.
 * Provides all the functionality regarding meetings.
 */
public class MeetingsMenu extends javax.swing.JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MeetingTableModel mtm = new MeetingTableModel();
    private ListSelectionModel lsm;
    /**
     * Creates new form MeetingsMenu
     */
    public MeetingsMenu() {
        initComponents();
        initTable();
        initSettings();
        initSelectionModel();
        updateModel();
        initListenerUpdate();
    }
    
    private void initSelectionModel() {
        lsm = meetingTable.getSelectionModel();
        lsm.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                lsm.getMinSelectionIndex();
            }
        });
    }
    
    private void showNoMeetingSelected() {
        JOptionPane.showMessageDialog(this,
                "Please select a meeting first.",
                "Meeting not selected",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void initSettings() {
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(this);
    }
    
    private void initTable() {
        meetingTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        meetingTable.getTableHeader().setReorderingAllowed(false);
    }
    
    /**
     * Updates table every time it is somehow changed/affected/focused on etc.
     */
    private void initListenerUpdate() {
        this.addWindowStateListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                updateModel();
            }
            @Override
            public void windowStateChanged(WindowEvent e) {
                updateModel();
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                updateModel();
            }
            
            @Override
            public void windowDeactivated(WindowEvent e) {
                updateModel();
            }
            
            @Override
            public void windowActivated(WindowEvent e) {
                updateModel();
            }
            
            @Override
            public void windowOpened(WindowEvent e) {
                updateModel();
            }
            
        });
    }
    
    private void updateModel() {
        mtm.clearData();
        for (Meeting meet : DataManager.getMeetings()) {
            mtm.addMeeting(meet);
        }
        mtm.refreshTable();
        meetingTable.setModel(mtm);
        meetingTable.getTableHeader().resizeAndRepaint();
        meetingTable.updateUI();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        meetingTable = new javax.swing.JTable();
        addNewButton = new javax.swing.JButton();
        delSelButton = new javax.swing.JButton();
        showSelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Meetings");

        meetingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title", "Room", "Time", "# Attendees"
            }
        ) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        meetingTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        meetingTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(meetingTable);

        addNewButton.setText("Add New");
        addNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewButtonActionPerformed(evt);
            }
        });

        delSelButton.setText("Delete All Selected");
        delSelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delSelButtonActionPerformed(evt);
            }
        });

        showSelButton.setText("Show First Selected");
        showSelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addNewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(delSelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(showSelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addNewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showSelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delSelButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void addNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewButtonActionPerformed
        AddMeetingDialog addDialog = new AddMeetingDialog(this, true);
        addDialog.setVisible(true);
        addDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                updateModel();
            }
        });
    }//GEN-LAST:event_addNewButtonActionPerformed
    
    private void delSelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delSelButtonActionPerformed
        if (meetingTable.getSelectedRows().length == 0){
            showNoMeetingSelected();
            return;
        }
        int [] selectedRows = meetingTable.getSelectedRows();
        int confirmCancel = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to cancel the selected meeting(s)?"
                        + "\nAll attendees will be removed from these meeting.",
                "Canceling Meeting", JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (confirmCancel == JOptionPane.YES_OPTION) {
            for (int rowindx: selectedRows) {
                Meeting selectedMeeting = mtm.getMeetingAtIndex(rowindx);
                DataManager.removeMeeting(selectedMeeting);
            }
            updateModel();
            JOptionPane.showMessageDialog(this, "Meeting(s) canceled succesfully.");
        }
        meetingTable.clearSelection();
    }//GEN-LAST:event_delSelButtonActionPerformed
    
    private void showSelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showSelButtonActionPerformed
        if (meetingTable.getSelectedRow() < 0){
            showNoMeetingSelected();
            return;
        }
        int selectedRow = meetingTable.getSelectedRow();
        Meeting selectedMeeting = mtm.getMeetingAtIndex(selectedRow);
        ShowMeetingDialog showmeetingd = new ShowMeetingDialog(selectedMeeting);
        showmeetingd.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e); //To change body of generated methods, choose Tools | Templates.
                updateModel();
            }
        });
        showmeetingd.setVisible(true);
        meetingTable.clearSelection();
    }//GEN-LAST:event_showSelButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewButton;
    private javax.swing.JButton delSelButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable meetingTable;
    private javax.swing.JButton showSelButton;
    // End of variables declaration//GEN-END:variables
}
