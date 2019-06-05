package uk.bharatha.schedulingApp;

import javax.swing.DefaultListModel;

public class RoomListModel extends DefaultListModel<Room> {
    public void addRoom (Room room) {
        this.addElement(room);
    }
}
