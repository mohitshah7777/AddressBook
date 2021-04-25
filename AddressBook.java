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

//UC7 Ability to ensure there is no Duplicate Entry of the same Person in a particular Address Book
class MultipleAddressBook {

    public static int indexNum;
    public static ArrayList<Contact> list = new ArrayList<>();
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
    public static void addAddressBookDetails() {

        System.out.print("Enter Name of Address Book = ");
        String name = sc.next();
        addressBook.add(new MultipleAddressBook(name));
    }

    public static void pickAddressBook() {

        System.out.println("You are Currently in (" + addressBook.get(bookNumber) + ") AddressBook");
        if (addressBook.size() > 0) {
   
        	for (int i = 0; i < addressBook.size(); i++)
            	System.out.println(i + ". " + addressBook.get(i));
            
            System.out.print("Pick Address Book Number = ");
            bookNumber = Integer.parseInt(sc.next());
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
            System.out.print("Want to Add More Address Book (y/n) ");
            check = sc.next();
            if(check.equalsIgnoreCase("n"))
            	System.out.println("Okay! Thank You !!!");
        }
    }
}
