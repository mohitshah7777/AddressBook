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

//UC6 Refactor to add multiple Address Book to the System, Each Address Book has a unique Name
public class AddressBook {
	static ArrayList<Contact> list = new ArrayList<Contact>();
	static Map<String,AddressBook> map = new HashMap<>();
	static int number=0;
	static int a;

	static Scanner sc = new Scanner(System.in);
	public static String check = "Y";

	public static void addDetails(){

		check = "Y";
		while((check.equals("Y")) || (check.equals("y"))) {

			System.out.println("------< Create Contact >------\n");
			System.out.print("Enter First Name ");
			String firstName=sc.next();
			System.out.print("Enter LastName ");
			String lastName=sc.next();
			System.out.print("Enter Address ");
			String area=sc.next();
			System.out.print("Enter City ");
			String city=sc.next();
			System.out.print("Enter State ");
			String state=sc.next();
			System.out.print("Enter Zip ");
			String zip=sc.next();
			System.out.print("Enter Phone Number ");
			String phoneNumber=sc.next();
			System.out.print("Enter Email ");
			String email=sc.next();

			System.out.println("Want To Add Another Contact ? Yes(y)/No(n)");
			check=sc.next();

			list.add( new Contact(firstName, lastName, area, city, state, zip, phoneNumber, email));
		}
	}

	public static void editDetails() {

		String nameEdit;
		System.out.println("\n------< Edit details >------");
		System.out.println("Enter Name to edit the details = ");
		nameEdit = sc.next();

			for(int i=0; i<list.size(); i++) {

				if (nameEdit.equals(list.get(i).getFirstName())) {

					System.out.print("Enter First Name ");
					list.get(i).setFirstName(sc.next());
					System.out.print("Enter Last Name ");
					list.get(i).setLastName(sc.next());
					System.out.print("Enter Arddress ");
					list.get(i).setAddress(sc.next());
					System.out.print("Enter City ");
					list.get(i).setCity(sc.next());
					System.out.print("Enter State ");
					list.get(i).setState(sc.next());
					System.out.print("Enter Zip ");
					list.get(i).setZip(sc.next());
					System.out.print("Enter Phone Number ");
					list.get(i).setPhone(sc.next());
					System.out.print("Enter Email ");
					list.get(i).setEmail(sc.next());

					System.out.println(list.get(i));
					System.out.println("Details Edited!\n");
				}
				else {
					System.out.println("Invalid name!");
				}
			}
	}

	public static void deleteDetails() { 
		String nameDelete;
		System.out.println("------< Delete Contact >------\n");
		System.out.print("Enter FirstName");
		nameDelete =sc.next();

		for(int i=0; i<list.size(); i++) {
			if (nameDelete.equals(list.get(0).getFirstName())) {
				list.remove(0);
         	System.out.println("Details Deleted!\n");
			}
			else {
				System.out.println("Invalid name!");
			}
		}
		
	}

	public static String multipleAddressBook() {

		System.out.print("Enter Name of Address Book = ");
		String name=sc.next();
		AddressBook addressBook = new AddressBook();
		map.put(name, addressBook);
		System.out.println("New Address Book: " +name);
		return name;
	}

	public static void main(String[] args){
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Welcome To Address Book");
		check = "Y";
		while((check.equals("Y")) || (check.equals("y"))) {

			String name=multipleAddressBook();
			System.out.println("\nAddress Book Menu");
			System.out.println("Enter 1 to Add Person ");
			System.out.println("Enter 2 to Edit Person");
			System.out.println("Enter 3 to Delete Person");
			System.out.println("Enter 4 to Display");
			System.out.println("Enter 5 to Add Multiple");
			System.out.print("\nPlease enter your choice: ");
			int choice=scan.nextInt();
			scan.nextLine(); 
			switch (choice) 
			{
			case 1 :
				addDetails();
			case 2 :
				System.out.print("Do you want to Edit Contact ? (y/n)");
				check=sc.next();
				if (check.equals("y") || check.equals("Y")) {
					editDetails();
				}
				else{
					System.out.println("Done");
				}
			case 3 :
				System.out.print("Do you want to Delete Contact ? (y/n)");
				check=sc.next();
				if (check.equals("y") || check.equals("Y")) {
					deleteDetails();
				}
				else{
					System.out.println("Done");
				}
			case 4 :
				System.out.println("Contacts in "+name+" AddressBook are: ");
				if(list.isEmpty())
				{
					System.out.println("NO DETAILS FOUND!!");
				}
				for(a=number; a<list.size(); a++) {
					System.out.println(list.get(a));
					a++;
				}
				number=list.size();
			case 5 :
				System.out.println("Do You Want to Add More Address Book? (y/n)");
				check=sc.next();
				if(check.equalsIgnoreCase("n"))
					System.out.println("Thank you!!!");
			}
		}
	}
}
