import java.util.ArrayList;
import java.util.Scanner;

class Contact{
	
	//UC1 Ability to create a Contacts in Address Book
	Scanner scan = new Scanner(System.in);
	private ArrayList<String> Firstname = new ArrayList<String>();	
	private ArrayList<String> Lastname = new ArrayList<String>();
	private ArrayList<String> Address = new ArrayList<String>();
	private ArrayList<String> City = new ArrayList<String>();
	private ArrayList<String> State = new ArrayList<String>();
	private ArrayList<String> Zip = new ArrayList<String>();
	private ArrayList<String> Phone = new ArrayList<String>();
	private ArrayList<String> Emailid = new ArrayList<String>();
	
	public String firstName()
	{
		System.out.println("------< Create Contact >------");  
	    System.out.print("Enter Firstname: ");
	    String firstname=scan.nextLine();
	    return firstname;
	      
	}
	public String lastName()
	{
		System.out.print("Enter Lastname: ");
	    String lastname=scan.nextLine();
	    return lastname;
	}
	
	public String address()
	{
		System.out.print("Enter Address: ");
	    String address=scan.nextLine();
	    return address;
	}
	public String city()
	{
		System.out.print("Enter City: ");
	    String city=scan.nextLine();
	    return city;
	}
	public String state()
	{
	    System.out.print("Enter State: ");
	    String state=scan.nextLine();
	    return state;
	}
	
	public String zip()
	{
		System.out.print("Enter Zip Code: ");
		String zip=scan.nextLine();
	    return zip;
	}
	
	public String phone()
	{
		System.out.print("Enter Phone number: ");
	    String phone=scan.nextLine();
	    return phone;
	}
	
	public String email()
	{
		System.out.print("Enter Email: ");
	    String emailid=scan.nextLine();
	    return emailid;
	}
	
	//UC2 Ability to add a new Contact to Address Book
	public void addDetails() 
	{	
		Firstname.add(firstName());
		Lastname.add(lastName());
		Address.add(address());
		City.add(city());
		State.add(state());
		Zip.add(zip());
		Phone.add(phone());
		Emailid.add(email());
		System.out.println("\nYou have successfully added a new person!");
		
	}

	//UC3 Ability to edit existing contact person using their name
	public String usingEditName()
	{
		System.out.println("\n------< Edit details >------");
		System.out.println("Enter Name to edit the details = ");
		String editName=scan.nextLine();
		return editName;
	}

	public int usingPosition(String editName)
	{
		int editPosition=Firstname.indexOf(editName);
		return editPosition;
	}
	
	public void editDetails() 
	{
			String nameEdit=usingEditName();
			int editPos=usingPosition(nameEdit);
		
			if(Firstname.contains(nameEdit)==true)
			{	
				Firstname.set(editPos, firstName());
				Lastname.set(editPos, lastName());
				Address.set(editPos, address());
				City.set(editPos, city());
				State.set(editPos,state());
				Zip.set(editPos,zip());
				Phone.set(editPos,phone());
				Emailid.set(editPos,email());
				System.out.println("\nYou have successfully Edited the person Details!");
			}
	}
	
	//UC4 Ability to delete a person using person's name
	public String usingDeleteName()
	{
		System.out.println("\n------< Delete details >------");
		System.out.println("Enter Name to Delete the details = ");
		String editName=scan.nextLine();
		return editName;
	}

	public void deleteDetails()
	{
		String nameDelete=usingDeleteName();
		int deletePos=usingPosition(nameDelete);
	
		if(Firstname.contains(nameDelete)==true)
		{	
			Firstname.remove(deletePos);
			Lastname.remove(deletePos);
			Address.remove(deletePos);
			City.remove(deletePos);
			State.remove(deletePos);
			Emailid.remove(deletePos);
			Zip.remove(deletePos);
			Phone.remove(deletePos);
			System.out.println("\nYou have successfully Deleted the person Details!");	
		}
	}

	public void display()
	{
		System.out.println("AddressBook [First name=" + Firstname + ", Last name=" + Lastname + ", Address= " + Address + ", City=" + City + ", State="+ State + ", Zip=" + Zip + ", Phone=" + Phone+ ", Email=" + Emailid + "]");
	}

}
public class AddressBook {

	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		Contact contact=new Contact(); 
		
		while(true)
        {
	        System.out.println("\nAddress Book Menu");
	        System.out.println("Enter 1 to Add Person ");
	        System.out.println("Enter 2 to Edit Person");
	        System.out.println("Enter 3 to Delete Person");
	        System.out.print("\nPlease enter your choice: ");
	        int choice=scan.nextInt();
	        scan.nextLine();

	        switch (choice) 
	        {
		        case 1 :
		        	contact.addDetails();
		        	contact.display();
		        	break;
			
		        case 2 :
		        	contact.editDetails();
		        	contact.display();
		        	break;
	
		        case 3 :
		        	contact.deleteDetails();
		        	contact.display();
		        	break;
		        default:
		        	break;
	
	        }
	    }
	}
}
