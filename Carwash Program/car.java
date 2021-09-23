package ie.itcarlow.test;



public class car {
	//Variables
	 private String name;
	 private int program;
	 private String carType;
	int noOfCars =0;
	
	

	
	//Constructors
 {
	}
		public car(String name, String carType, int program) {
			setName(name);
			setCarType(carType);
			setProgram(program);
			
	}
		
		//Getters & Setters
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getProgram() {
			return program;
		}
		public void setProgram(int program) {
			this.program = program;
		}
		public String getCarType() {
			return carType;
		}
		public void setCarType(String carType) {
			this.carType = carType;
		}
		public int getNoOfCars() {
			return noOfCars;
		}
		public void setNoOfCars(int noOfCars) {
			this.noOfCars = noOfCars;
		}
		
		
		//toString
		@Override
		public String toString() {
			return "[Name:" + name + ", Program:" + program + ", CarType:" + carType + "]";
		}
		
		

}