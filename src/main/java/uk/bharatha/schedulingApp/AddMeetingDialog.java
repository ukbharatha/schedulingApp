package uk.bharatha.schedulingApp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * The dialog used for adding a meeting
 * 
 */
public class AddMeetingDialog extends javax.swing.JDialog {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private RoomListModel rlm = new RoomListModel();
    
    /*
     * Constants for use with dialog
     */
    private final int MULTIPLE_INVALID = 0;
    private final int TITLE_INVALID = 1;
    private final int ROOM_INVALID = 2;
    private final int TIMESLOT_INVALID = 3;
    private final int TIMEOUTOFBOUNDS_INVALID = 4;
    /**
     * Creates new form AddMeetingDialog
     * @param parent parent of the dialog
     * @param modal if true, locks all other windows until this dialog is closed
     */
    public AddMeetingDialog(java.awt.Frame parent, boolean modal) {
        super(parent, true);
        initComponents();
        initSettings();
        initRoomList();
        initAttendeeList();
    }
    
    /**
     * Initialize Room List
     */
    private void initRoomList() {
        rlm.clear();
        for (Room room : DataManager.getRooms()) {
            rlm.addRoom(room);
        }
        roomList.setModel(rlm);
    }
    
    /**
     * Initialize Attendee List
     */
    private void initAttendeeList() {
        DefaultListModel<Person> attndlm = new DefaultListModel<Person>();
        for (Person pers : DataManager.getPersons()) {
            attndlm.addElement(pers);
        }
        attendeeList.setModel(attndlm);
    }
    
    /**
     * Initialize settings
     */
    private void initSettings() {
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        String values[] = new String[] {
            "9 AM", 
            "10 AM", 
            "11 AM", 
            "12 PM", 
            "1 PM", 
            "2 PM", 
            "3 PM", 
            "4 PM"
            };
        timeSpinner.setModel(new javax.swing.SpinnerListModel(values));
        timeSpinner.setToolTipText("The meeting time.");
    }
    
    /**
     * Creates a meeting
     * @param title
     * @param room
     * @param timeSlot
     * @return 
     */
    private boolean createMeeting(String title, Room room, int timeSlot) {
        Meeting createdMeeting = new Meeting(title, room.getID(), timeSlot);
        List<Person> selectedattnds = attendeeList.getSelectedValuesList();
        if (!selectedattnds.isEmpty()) {
            for (Person pers : selectedattnds) {
                ArrayList<Meeting> meets = DataManager.getPersonMeetings(pers);
                boolean personBusy = false;
                for (Meeting meet : meets){
                    if (meet.getTimeSlot() == timeSlot){
                        personBusy = true; break;
                    }
                }
                if (!personBusy){
                    createdMeeting.addAttendee(pers);
                    continue;
                }
                JOptionPane.showMessageDialog(this,pers.getFirstName()+" is busy at that time.\n"
                        + "Cannot schedule him at that time.", 
                        "Scheduling Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        boolean success = DataManager.addMeeting(createdMeeting);
        return success;
    }
    
    /**
     * Checks validity of form
     * @return 
     */
    private boolean isDataValid() {
        String spinnerVal = timeSpinner.getValue().toString().substring(0, 2);
        spinnerVal = spinnerVal.trim();
        int spinnerTime = Integer.parseInt(spinnerVal);
        if (subjectField.getText().equals("") || subjectField.getText() == null) {
            showDataInvalidDialog(TITLE_INVALID);
            return false;
        } else if (roomList.isSelectionEmpty()) {
            showDataInvalidDialog(ROOM_INVALID);
            return false;
        } else if (spinnerTime < 9 && spinnerTime > 5) {
            showDataInvalidDialog(TIMEOUTOFBOUNDS_INVALID);
            return false;
        }
        return true;
    }
    
    /**
     * Shows dialog for invalid
     * @param type 
     */
    private void showDataInvalidDialog(int type) {
        String errmsg;
        
        switch (type) {
            case MULTIPLE_INVALID: errmsg = "Multiple invalid data."; break;
            case TITLE_INVALID: errmsg = "Meeting title is missing."; break;
            case ROOM_INVALID: errmsg = "Room not selected."; break;
            case TIMESLOT_INVALID: errmsg = "Timeslot is taken.";break;
            case TIMEOUTOFBOUNDS_INVALID: errmsg = "Time is out of range 9AM-4PM."; break;
            default: errmsg = "Data is invalid.";
        }
        
        JOptionPane.showMessageDialog(this, 
                errmsg, "Invalid Data", 
                JOptionPane.WARNING_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subjectField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        attendeeList = new javax.swing.JList<Person>();
        jLabel4 = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        timeSpinner = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        roomList = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        subjectField.setToolTipText("");

        jLabel1.setText("Subject");

        jLabel2.setText("Time");

        jLabel3.setText("Select Attendees");

        jScrollPane1.setViewportView(attendeeList);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Add Meeting");

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        timeSpinner.setModel(new javax.swing.SpinnerListModel(new String[] {"9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "1:00 AM", "2:00 AM", "3:00 PM", "4:00 PM"}));

        roomList.setModel(new javax.swing.AbstractListModel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] strings = { "Room 1", "Room 2", "Room 3", "Room 4", "Room 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(roomList);

        jLabel5.setText("Room");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(subjectField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(154, 154, 154)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton)
                    .addComponent(CancelButton))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        if (isDataValid()) {
            String spinnerVal = timeSpinner.getValue().toString().substring(0, 2);
            spinnerVal = spinnerVal.trim();
            int spinnerTime = Integer.parseInt(spinnerVal);
            int selectedIndex = roomList.getSelectedIndex();
            System.out.println(selectedIndex);
            Room selectedRoom = rlm.get(selectedIndex);
            boolean success = createMeeting(subjectField.getText(),selectedRoom, spinnerTime);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(AddMeetingDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!success) {
                showDataInvalidDialog(TIMESLOT_INVALID);
                return;
            }
            this.dispose();
        }
    }//GEN-LAST:event_AddButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton CancelButton;
    private javax.swing.JList<Person> attendeeList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList roomList;
    private javax.swing.JTextField subjectField;
    private javax.swing.JSpinner timeSpinner;
    // End of variables declaration//GEN-END:variables
}
