
package uk.bharatha.schedulingApp;

import java.io.Serializable;
import java.util.ArrayList;

public class Meeting implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
        Private Properties
    */
    private final long ID;
    private final String title;
    private String roomID;
    private ArrayList<Person> attendees;
    private int timeSlot;

    public Meeting(String title,String roomID, int timeSlot) {
        this.ID = System.currentTimeMillis() % 1000; // setting unique ID by time
        this.roomID = roomID;
        this.title = title;
        this.attendees = new ArrayList<Person>(10);
        this.timeSlot = timeSlot;
    }
    
    /**
     * Get the value of roomID
     *
     * @return the value of roomID
     */
    public String getRoomID() {
        return roomID;
    }

    /**
     * Set the value of roomID
     *
     * @param roomID new value of roomID
     */
    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    /**
     * Get the value of timeSlot
     *
     * @return the value of timeSlot
     */
    public int getTimeSlot() {
        return timeSlot;
    }

    /**
     * Set the value of timeSlot
     *
     * @param timeSlot new value of timeSlot
     */
    public void setTimeSlot(int timeSlot) {
        this.timeSlot = timeSlot;
    }
    
    /**
     * Adds an attendee
     * @param attnd Person object
     */
    public void addAttendee(Person attnd) {
        attendees.add(attnd);
    }
    
    /**
     * Remove an attendee
     * @param attnd Person object
     * @return boolean true if person existed in attendee list
     */
    public boolean removeAttendee(Person attnd) {
        boolean remove = attendees.remove(attnd);
        return remove;
    }

    /**
     * Return the ID
     * @return 
     */
    public long getID() {
        return ID;
    }

    /**
     * Return the title
     * @return 
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Returns all attendees
     * @return 
     */
    public ArrayList<Person> getAttendees() {
        return attendees;
    }
    
    /**
     * Formats and returns the time slot
     * @return String of the time formated nicely
     */
    public String getFormattedTimeSlot(){
        int tempTime = timeSlot%12;
        if (timeSlot == 12) tempTime = 12;
        return String.format("%s:00 %s", tempTime, ((timeSlot < 9) || (timeSlot == 12) ? "PM": "AM"));
    }

    @Override
    public String toString() {
        return this.title+" at "+this.getFormattedTimeSlot();
    }
    
    /**
     * Returns a formatted string will more data
     * @return 
     */
    public String fullString() {
        return this.toString()+" in room "+this.roomID;
    }
}
