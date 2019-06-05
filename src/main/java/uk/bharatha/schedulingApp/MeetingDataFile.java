package uk.bharatha.schedulingApp;

import java.io.Serializable;
import java.util.ArrayList;

public class MeetingDataFile implements Serializable {
    private final ArrayList<Room> rooms;
    private final ArrayList<Person> people;
    private final ArrayList<Meeting> meetings;

    public MeetingDataFile(ArrayList<Room> rooms, ArrayList<Person> people, ArrayList<Meeting> meetings) {
        this.rooms = rooms;
        this.people = people;
        this.meetings = meetings;
    }
    
    /**
     * Returns Rooms
     * @return 
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /**
     * Returns people
     * @return 
     */
    public ArrayList<Person> getPeople() {
        return people;
    }

    /**
     * Returns meetings
     * @return 
     */
    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }
    
}
