package food_delivery_platform;

public class Customer {
	
	//規格定義
	protected String id; 
	protected String password; 
	protected String phoneNum; 
	protected String email; 
    protected String name; 
    protected String address; 
    protected String memberShipValidUntil; 
    protected Boolean member; // is member or not
     

    public Customer(String id, String password, String phoneNum, String email, String name, String address){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum;
        this.address = address;
    }
   
    //Getters
    public String getId() {
    	return id;
    }
    public String getPassword() {
    	return password;
    }
    public String getPhoneNum() {
		return phoneNum;
	}
    public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public boolean isMember() {
		return this.member;
	}
	public String memberShipValidUntil() {
		return memberShipValidUntil;
	}
	 
    //  Setters
    public void setId(String id) {
    	this.id = id;
    }
    public void setPassword(String password) {
    	this.password = password;
    }
    public void setPhoneNum(String phoneNum) {
    	this.phoneNum = phoneNum;
    }
    public void setEmail(String email) {
    	this.email = email;
    }
    public void SetName(String name) {
    	this.name = name;
    }
    public void setAddress(String address) {
    	this.address = address;
    }
    public void setMember(boolean member) {
    	this.member = member;
    }
    public void setMemberShipValidUntil(String memberShipValidUntil) {
    	this.memberShipValidUntil = memberShipValidUntil;
    }
    
}


