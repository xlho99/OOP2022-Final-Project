
public class Orders {
	private int number;
	enum state{storeChecking, mealMaking, mealDelivering, mealArrived;}
	private state currentState;
	private int amount;
	private String orderTime;
	private String deliverTime;
	private String deliverAddress;
	private String customerName;
	private String deliveryManName;
	private String storeName;
	
	public int getNumber() {
		return number;
	}
	public state getCurrentState() {
		return currentState;
	}
	public int getAmount() {
		return amount;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public String getDeliverTime() {
		return deliverTime;
	}
	public String getDeliverAddress() {
		return deliverAddress;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getDeliveryManName() {
		return deliveryManName;
	}
	public String getStoreName() {
		return storeName;
	}
	
	
	
	public void setNumber(int number) {
		this.number = number;
	}
	public void setCurrentState(state currentstate) {
		this.currentState = currentstate;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public void setDeliverTime(String deliverTime) {
		this.deliverTime = deliverTime;
	}
	public void setDeliverAddress(String deliverAddress) {
		this.deliverAddress = deliverAddress;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setDeliveryManName(String deliveryManName) {
		this.deliveryManName = deliveryManName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
}
