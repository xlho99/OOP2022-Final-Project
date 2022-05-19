package food_delivery_platform;

public class Customer {
    protected String name;
    protected String id;
    protected String home;
    protected String email;

    public Customer(){}

    public Customer(String id, String name, String home, String email){
        this.id = id;
        this.name = name;
        this.home = home;
        this.email = email;
    }

}
