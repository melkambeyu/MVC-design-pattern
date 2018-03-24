  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Engineer Melkam Beyu
 */
public class User {
    private String firstName;
    private int id;
    private String lastName;
    private String department;

    public User(int ID, String FirstName, String LastName, String Department) {
        //To change body of generated methods, choose Tools | Templates.
        this.id=ID;
        this.firstName=FirstName;
        this.lastName=LastName;
        this.department=Department;
    }

    public int getId() {
        return id;
    }
    public String getfirstname(){
        return firstName;
    }
    public String getlastname(){
        return lastName;
    }
    
    public String getdepa(){
        return department;
               
    }
   
}
