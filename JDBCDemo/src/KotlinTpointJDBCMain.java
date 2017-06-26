import java.util.ArrayList;
import java.util.Scanner;

public class KotlinTpointJDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		UserDAO userDAO=UserDAO.getInstance();
		User user;
		int choice, count;
		do{
			System.out.println("1. Insert User");
			System.out.println("2. Update User");
			System.out.println("3. Delete User");
			System.out.println("4. Fetch User");
			System.out.print("Enter Choice : ");
			choice=scanner.nextInt();
			switch(choice)
			{
			case 1:
				user=new User();
				System.out.print("Enter Name : ");
				user.setName(scanner.next());
				System.out.print("Enter Mobile : ");
				user.setMobile(scanner.nextLong());
				System.out.print("Enter Email : ");
				user.setEmail(scanner.next());
				count=userDAO.saveUser(user);
				if(count>0)
					System.out.println("Inserted Successfully!!!");
				else
					System.out.println("Insertion Fail!!!");
				break;
			case 2:
				user=new User();
				System.out.print("Enter ID : ");
				user.setId(scanner.nextInt());
				System.out.print("Enter Name : ");
				user.setName(scanner.next());
				System.out.print("Enter Mobile : ");
				user.setMobile(scanner.nextLong());
				System.out.print("Enter Email : ");
				user.setEmail(scanner.next());
				count=userDAO.updateUser(user);
				if(count>0)
					System.out.println("Updated Successfully!!!");
				else
					System.out.println("Update Fail!!!");
				break;
			case 3:
				System.out.print("Enter ID : ");
				int id=scanner.nextInt();
				count=userDAO.deleteUser(id);
				if(count>0)
					System.out.println("Deleted Successfully!!!");
				else
					System.out.println("Delete Fail!!!");
				break;
			case 4:
				ArrayList<User> users=userDAO.allUsers();
				System.out.println(users);
				break;
			case 5:
				System.out.println("Thank you!!!");
				break;
			default:
				System.out.println("Enter Valid Choice");
				break;
			}
		}while(choice!=5);
		scanner.close();
	}

}
