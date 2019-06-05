package uk.bharatha.schedulingApp;

import org.junit.Test;

public class DataTest {

	@Test
	public void test() {
		
	
		
		Room room1 = new Room("Room 1");
		Room room2 = new Room("Room 2");
		Person person1 = new Person("First", "person", "first@gmail.com");
	    Person person2 = new Person("Second", "person", "first@gmail.com");
	    Meeting meeting1 = new Meeting("Weekly Meet", "Room 1", 9);
        Meeting meeting2 = new Meeting("Agile Meet", "Room 2", 5);
        
        DataManager.init();
        
        DataManager.addRoom(room1);
		DataManager.addRoom(room2);
		
		DataManager.addMeeting(meeting1);
		DataManager.addMeeting(meeting2);
		
		DataManager.addPerson(person1);
		DataManager.addPerson(person2);

		
		
		
	}

}
