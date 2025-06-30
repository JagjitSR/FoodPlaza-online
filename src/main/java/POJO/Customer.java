package POJO;

public class Customer 
{
	//Data Members

	private String custName;
	private String emailId;
	private String custPassword;
	private String custAddress;
	private String contactNo;
	private String custLocation;

	//Constructor with fields and zero para.

	public Customer()
	{

	}

	public Customer(String custName, String emailId, String custPassword, String custAddress, String contactNo,
			String custLocation) 
	{
		super();
		this.custName = custName;
		this.emailId = emailId;
		this.custPassword = custPassword;
		this.custAddress = custAddress;
		this.contactNo = contactNo;
		this.custLocation = custLocation;
	}

	//Getters and Setters

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getCustLocation() {
		return custLocation;
	}

	public void setCustLocation(String custLocation) {
		this.custLocation = custLocation;
	}

	//toString method for display records

	@Override
	public String toString() {
		return "Customer [custName=" + custName + ", emailId=" + emailId + ", custPassword=" + custPassword
				+ ", custAddress=" + custAddress + ", contactNo=" + contactNo + ", custLocation=" + custLocation + "]";
	}




}
