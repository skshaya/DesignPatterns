package Prototype;


public class PrototypeTest {
    
    public static void main(String[] args) {
        
        User u = new User(1, "Amal","Colombo");
        u.viewDetails();
        
        try {
            User u_clone = (User)u.clone();
            u_clone.setCity("Kandy");
            
            u.viewDetails();
            u_clone.viewDetails();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

class User implements Cloneable{

    private int id;
    private String name;
    private String city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
        System.out.println("user constructor");
    }
    
    public User(){
        System.out.println("user empty constructor");
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public void viewDetails(){
        System.out.println(id+","+name+","+city);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
        
    }
    
}

