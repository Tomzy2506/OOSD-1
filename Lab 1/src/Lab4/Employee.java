package Lab4;

public class Employee {

	//Variables
	private String fname;
	private String lname;
	private Address address;
	private static int nextStaffNo = 1000;
	private int employeeNumber;
	private String empType;
	private String comCarType;


	//Constructors
	
	public Employee(String fname, String lname, Address address, String empType) {
		setFname(fname);
		setLname(lname);
		setAddress(address);
		setEmpType(empType);
		nextStaffNo ++;
	}
	
	//Getters & Setters

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public static int getNextStaffNo() {
		return nextStaffNo;
	}
	public static void setNextStaffNo(int nextStaffNo) {
		Employee.nextStaffNo = nextStaffNo;
	}
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
	public String getComCarType() {
		return comCarType;
	}
	public void setComCarType(String comCarType) {
		this.comCarType = comCarType;
	}

	
	//toString
	@Override
	public String toString() {
		if(empType.equalsIgnoreCase("Manager")) {
		return "Employee [fname=" + fname + ", lname=" + lname + ", address=" + address + ", employeeNumber="
				+ employeeNumber + ", empType=" + empType + ", comCarType=" + comCarType + "]";
		}
		else {
			return "Employee [fname=" + fname + ", lname=" + lname + ", address=" + address + ", employeeNumber="
					+ employeeNumber + ", empType=" + empType + "]";
		}
	}
	
	
}
