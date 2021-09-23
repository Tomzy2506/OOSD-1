package ie.itcarlow.test;


import java.util.Scanner;

public class CarWashDriver {
	
	
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		int choice =0; 
		int noOfCars =0;
		car[] cars = new car[5];
				
		
		while(choice !=6) {
			
			
		System.out.println(" Please select a choices"); //Press 1 for now to enter your name and program and ignore 2,3,4,5 until the code is written for it.
		System.out.println("1.) List all the cars Waiting ");
		System.out.println("2.) Enter your name and pick a program ");
		System.out.println("3.) Size of Waiting Queue ");
		System.out.println("4.) Remove all Cars from a given program ");
		System.out.println("5.) Exit Car Wash Program ");
		choice = in.nextInt();
		
		if(choice == 1) {
			for(car c: cars) {
				if(c !=null)
					System.out.println(c.toString() );

			}	
		}
		
		else if(choice ==2) {
			if(noOfCars !=5) {
			Scanner clean = new Scanner(System.in);
			String name;
			String carType;
			int program;
			
			System.out.println("Please enter your name: ");
			name = clean.nextLine();
			
			System.out.println("Please enter your carType");
			carType = clean.nextLine();
			
			System.out.println("Please enter the program you want ");
			System.out.println("******************************");
			System.out.println("1.) Standard");
			System.out.println("2.) Premium");
			System.out.println("3.) Deluxe");
			program = clean.nextInt();
			if(program >3 ) {
				System.out.println("Number has to be between 1-3");
			}
			
			car c = new car(name,carType,program);
				
			cars[noOfCars]=c;
			noOfCars++;
			
			if(noOfCars > 5) {
				System.out.println("You can only have 5 cars in a queue!");
			}
			
			}
		}//Choice 2
		
		else if(choice ==3) {
			int Size = 0;
			Size = noOfCars;
			
			System.out.println("Size of the waiting queue is " + Size) ;
			
		}
		
		else if (choice ==4) {
			
			
			while(choice !=6) {
				
				
				System.out.println(" Please select a choices"); //Press 1 for now to enter your name and program and ignore 2,3,4,5 until the code is written for it.
				System.out.println("1.) List all the cars Waiting ");
				System.out.println("2.) Enter your name and pick a program ");
				System.out.println("3.) Size of Waiting Queue ");
				System.out.println("4.) Remove all Cars from a given program ");
				System.out.println("5.) Exit Car Wash Program ");
				choice = in.nextInt();
				
				if(choice == 1) {
					for(car d: cars) {
						if(d !=null)
							System.out.println("Empty...");

					}	
				}
				
				else if(choice ==2) {
					if(noOfCars !=5) {
						Scanner cleans = new Scanner(System.in);
					String name;
					String carType;
					int program;
					
					System.out.println("Please enter your name: ");
					name = cleans.nextLine();
					
					System.out.println("Please enter your carType");
					carType = cleans.nextLine();
					
					System.out.println("Please enter the program you want ");
					System.out.println("******************************");
					System.out.println("1.) Standard");
					System.out.println("2.) Premium");
					System.out.println("3.) Deluxe");
					program = cleans.nextInt();
					if(program >3 ) {
						System.out.println("Number has to be between 1-3");
					}
					
					car d = new car(name,carType,program);
						
					cars[noOfCars]=d;
					noOfCars++;
					
					if(noOfCars > 5) {
						System.out.println("You can only have 5 cars in a queue!");
					}
					
					}
				}//Choice 2
				
				else if(choice ==3) {
					int Size = 0;
					Size = noOfCars;
					
					System.out.println("Size of the waiting queue is " + Size) ;
					
				}
				
		}
		
		if (choice > 6) {
			
			System.out.println("Selected choices needs to be between 1-5 on the menu");
		}
	
		}
		
		
	}

	}
}
