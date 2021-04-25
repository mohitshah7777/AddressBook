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

public class AddressBook{

	public static void main(String[] args){

	}
}
