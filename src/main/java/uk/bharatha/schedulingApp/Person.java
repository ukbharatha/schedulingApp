package uk.bharatha.schedulingApp;

public class Person  {
    
    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    
     /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    public String getLastName() {
        return lastName;
    }
    
    private String email;

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getemail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setemail(String email) {
        this.email = email;
    }
    
    /**
     * This will be for the lists, as the list uses toString to display an Object
     * @return Name format of Person
     */
    @Override
    public String toString() {
        return String.format("%s %s", this.firstName, this.lastName); //To change body of generated methods, choose Tools | Templates.
    }
}
