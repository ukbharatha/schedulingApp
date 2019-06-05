package uk.bharatha.schedulingApp;

/**
 * The main class, this contains the main() function that initializes components of the program, adds sample data, and the GUI, 
 */
public class MeetingSchedulingSystem {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        init();
        initGUI();
    }
    
    /**
     * Initializes application
     */
    public static void init() {
        DataManager.init();
        
        // Some Sample data
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");
        Meeting sample1 = new Meeting("Weekly Meet", "Room 1", 9);
        Meeting sample2 = new Meeting("Agile Meet", "Room 2", 10);
        DataManager.addRoom(room1);
        DataManager.addRoom(room2);
        boolean x = DataManager.addMeeting(sample1);
        boolean y = DataManager.addMeeting(sample2);
        Person person1 = new Person("First", "person", "first@gmail.com");
        Person person2 = new Person("Second", "person", "second@gmail.com");
        DataManager.addPerson(person1);
        DataManager.addPerson(person2);
    }
    
    /**
     * Initializes GUI of application
     */
    public static void initGUI() {
       
        MainMenu main = new MainMenu();
    }
}
