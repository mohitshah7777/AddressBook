import java.util.*;

class Contact {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

    public Contact(String firstName, String lastName, String address, String city, String state, String zip, String phone, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {

        return "Details of: " + firstName+"\n"
        		+ "First Name: "+ firstName +"\n" 
        		+ "Last Name: " + lastName+"\n"
                + "Address: " + address + "\n"
                + "City: " + city + "\n"
                + "State: " + state + "\n"
                + "Zip: " + zip + "\n"
                + "Phone Number: " + phone + "\n"
                + "Email: " + email;
    }
}

class MultipleAddressBook {

    public static int indexNum;
    public static ArrayList<Contact> list = new ArrayList<Contact>();
    public String addressBookName;
    public String firstName, lastName, address, city, state, email, zip, phone;
    public Scanner input = new Scanner(System.in);

    public MultipleAddressBook(String addressBookName) {
        this.addressBookName = addressBookName;
    }

    public boolean checkName() {

        System.out.print("Enter First Name ");
        firstName = input.next();

        for (indexNum = 0; indexNum < list.size(); indexNum++) {
            if (firstName.equals(list.get(indexNum).getFirstName())) {
                System.out.println("Contact Name Exists");
                return true;
            }
        }
        return false;
    }

    public void addDetails() {

    	System.out.println("\n------< Add details >------");
    	if(!checkName()) {
	    	System.out.print("Enter Last Name ");
	    	lastName = input.next();
	    	System.out.print("Enter Address ");
	    	address = input.next();
	    	System.out.print("Enter City ");
	    	city = input.next();
	    	System.out.print("Enter State ");
	    	state = input.next();
	    	System.out.print("Enter Zip ");
	    	zip = input.next();
	    	System.out.print("Enter Phone Number ");
	    	phone = input.next();
	    	System.out.print("Enter Email ");
	    	email = input.next();
	        list.add(new Contact(firstName, lastName, address, city, state, zip, phone, email));
    	}
    }

    public void editDetails() {

    	System.out.println("\n------< Edit details >------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Details to be Edited: ");

        if (checkName()) {
            System.out.print("Enter First Name ");
            list.get(indexNum).setFirstName(sc.next());
            System.out.print("Enter Last Name ");
            list.get(indexNum).setLastName(sc.next());
            System.out.print("Enter Address ");
            list.get(indexNum).setAddress(sc.next());
            System.out.print("Enter City ");
            list.get(indexNum).setCity(sc.next());
            System.out.print("Enter State ");
            list.get(indexNum).setState(sc.next());
            System.out.print("Enter ZipCode ");
            list.get(indexNum).setZip(sc.next());
            System.out.print("Enter Phone Number ");
            list.get(indexNum).setPhone(sc.next());
            System.out.print("Enter Email ");
            list.get(indexNum).setEmail(sc.next());

            System.out.println("------Details Edited------");
        }
        else
        	System.out.println("Invalid name!");
    }

    public void deleteDetails() {

    	System.out.println("\n------< Delete details >------");
        System.out.println("Details to be Deleted");
        if (checkName()) {
            list.remove(indexNum);
            System.out.println("------Details Deleted------\n");
        }
        else
        	System.out.println("Invalid name!") ;
        
    }

    public void displayDetails() {

    	if(list.isEmpty())
    	{
    		System.out.println("------No details found------");
    	}
        for (Contact contactDetails : list) {
            System.out.println();
            System.out.println(contactDetails);
        }
    }

    @Override
    public String toString() {
        return addressBookName;
    }
}

public class AddressBook {

    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<MultipleAddressBook> addressBook = new ArrayList<>();
    private static int bookNumber = 0;
    private static String firstName,lastName,address,city,state,zip,phone,email;

    public static Map<String, String> dictionaryCity=new HashMap<>();
	public static Map<String, String> dictionaryState=new HashMap<>();

	public static List<String> cityCount = new ArrayList<>();
	public static List<String> stateCount = new ArrayList<>();

	
	public static ArrayList<MultipleAddressBook> addressBookDetails=new ArrayList<>();

    
    public static void addAddressBookDetails() {
        System.out.print("Enter Name of Address Book = ");
        String name = sc.next();
        addressBook.add(new MultipleAddressBook(name));
    }

    public static void pickAddressBook() {
        System.out.println("You are Currently in (" + addressBook.get(bookNumber) + ") AddressBook");
        if(addressBook.isEmpty())
        {
        	System.out.println("NO DETAILS FOUND!");
        }
        
        if (addressBook.size() > 0) {
   
        	for (int i = 0; i < addressBook.size(); i++)
            	System.out.println(i + ". " + addressBook.get(i));
            
            System.out.print("Pick Address Book Number = ");
            bookNumber = Integer.parseInt(sc.next());
        }
    }

    //Refactor : By using Stream functions 
    public static void personByState() {

		System.out.println("Enter State Name");
		state = sc.next();

		addressBook.forEach(address -> address.list.stream()
						.filter(contact -> contact.getState().equals(state))
						.forEach(System.out::println));
		}

	public static void personByCity() {
		System.out.println("Enter City Name");
		city = sc.next();

		addressBook.forEach(address -> address.list.stream()
						.filter(contact -> contact.getCity().equals(city))
						.forEach(System.out::println));
	}

	private static void cityPersonDict() {
		System.out.println("Enter City Name");
		city=sc.next();

		addressBook.forEach(address -> address.list.stream()
                  .filter(contact -> contact.getCity().equals(city))
                  .forEach(contact -> dictionaryCity.put((contact.getFirstName() + " " + contact.getLastName()), contact.getCity())));

		dictionaryCity.forEach((key, value) -> System.out.println("Name "+key));
	}

	private static void statePersonDict() {
		System.out.println("Enter State Name");
		state=sc.next();

		addressBook.forEach(address -> address.list.stream()
						.filter(contact -> contact.getState().equals(state))
						.forEach(contact -> dictionaryState.put((contact.getFirstName() + " " + contact.getLastName()), contact.getState())));

		dictionaryState.forEach((key, value) -> System.out.println("Name "+key));
	}

	public static void setCityCount() {
		addressBook.forEach(address -> address.list
				.forEach(contact -> cityCount.add(contact.getCity())));

		cityCount.stream().distinct()
						  .forEach(placeName -> System.out.println("Number of People from " + placeName + " is : " + cityCount.stream()
						  .filter(n1 -> n1.equals(placeName)).count()));
		}


	public static void setStateCount() {
		addressBook.forEach(address -> address.list
				.forEach(contact -> stateCount.add(contact.getState())));

		stateCount.stream().distinct()
						   .forEach(placeName -> System.out.println("Number of People from " + placeName + " is : " + stateCount.stream()
						   .filter(n1 -> n1.equals(placeName)).count()));
		}	
	
	public static void search() {

		System.out.println("Choose Option");
		System.out.println("1: By City Name" );
		System.out.println("2: By State Name");
		System.out.println("3: View Person in City");
		System.out.println("4: View Person in State");
		System.out.println("5: Total Persons in City");
		System.out.println("6: Total Persons in State");

		String choose=sc.next();
		switch (choose) {

			case "1" :
				personByCity();
				break;
			case "2":
				personByState();
				break;
			case "3" :
				cityPersonDict();
				break;
			case "4" :
				statePersonDict();
				break;
			case "5" :
				setCityCount();
				break;
			case "6" :
				setStateCount();
				break;
			default :
				System.out.println("Wrong Input");
		}
	}
    
     public static void option() {

        Scanner scan = new Scanner(System.in);

        String check = "y";
        while (check.equalsIgnoreCase("Y")) {

            System.out.println("Enter your choice");
            System.out.println("1: Add Contact");
            System.out.println("2: Edit Contact");
            System.out.println("3: Delete Contact");
            System.out.println("4: Display Contact");
            System.out.println("5: Exit");
            int choice = scan.nextInt();
            switch (choice) {
                case 1 :
                    addressBook.get(bookNumber).addDetails();
                    break;
                case 2 :
                	System.out.print("Do you want to Edit Contact ? (y/n)");
    				check=scan.next();
    				if (check.equals("y") || check.equals("Y")) {
    					addressBook.get(bookNumber).editDetails();
    				}
    				else
    				{
    					System.out.println("Nothing Edited");
    				}
                case 3 :
                	System.out.print("Do you want to Delete Contact ? (y/n)");
    				check=scan.next();
    				if (check.equals("y") || check.equals("Y")) {
    					addressBook.get(bookNumber).deleteDetails();
    				}
    				else{
    					System.out.println("Nothing Deleted");
    				}
                case 4 :
                    pickAddressBook();
                    addressBook.get(bookNumber).displayDetails();
                    break;
                case 5 :
                    System.out.println("Exit");
                    check = "n";
            }
            System.out.println("Want to Make More Changes in This Address Book? (y/n)");
            check=scan.next();
        }
    }

     public static void main(String[] args) {

        System.out.println("Welcome to Address Book");
        String check;
        while (true){
            addAddressBookDetails();
            option();
        
            System.out.println("Do You Want to Search Contacts by City, State?");
			System.out.println("Press y if You Want to Search");
			String searchInput=sc.next();
			if (searchInput.equalsIgnoreCase("y")) 
			{
				search();
			}else if(searchInput.equalsIgnoreCase("n")){ 
				System.out.println("You Can Proceed Further");
			}else {
				System.out.println("Wrong input! Proceed further" );
			}
			
            System.out.print("Want to Add More Address Book (y/n) ");
            check = sc.next();
            if(check.equalsIgnoreCase("n"))
            	System.out.println("Okay! Thank You !!!");
        }
    }
}