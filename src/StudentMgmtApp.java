import java.util.List;
import java.util.Scanner;

import com.example.studentmgmtapp.Student;
import com.example.studentmgmtapp.StudentDBService;

public class StudentMgmtApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int ch = -1;
		StudentDBService sdb = new StudentDBService();
		boolean res;
		int id = -1;
		String name,city,stream,year,phone,email,field,value;
		List<Student> resList;
		Student stu;
		System.out.println("Welcome to Student Management App");

		while (ch != 0) {
			System.out.println("Press 1 to ADD");
			System.out.println("Press 2 to DELETE");
			System.out.println("Press 3 to QUERY");
			System.out.println("Press 4 to UPDATE");
			System.out.println("Press 0 to QUIT");
			System.out.print("Enter option: ");
			if (sc.hasNextInt()) {
				ch = sc.nextInt();
				sc.nextLine();
			}
			switch(ch) {
				case 1:
					System.out.print("Enter name: ");
					name = sc.nextLine();
					System.out.print("Enter city: ");
					city = sc.nextLine();
					System.out.print("Enter stream: ");
					stream = sc.nextLine();
					System.out.print("Enter year: ");
					year = sc.nextLine();
					System.out.print("Enter phone: ");
					phone = sc.nextLine();
					System.out.print("Enter email: ");
					email = sc.nextLine();
					stu = new Student(name,city,stream,year,phone,email);
					res = sdb.insertStudentToDB(stu);
					System.out.println(res?"Successful":"Failure");
					break;
				case 2:
					System.out.print("Enter id: ");
					if (sc.hasNextInt()) {
						id = sc.nextInt();
						sc.nextLine();
					}
					res = sdb.deleteStudentFromDB(id);
					System.out.println(res?"Successful":"Failure");
					break;
				case 3:
					System.out.print("Enter field: ");
					field = sc.nextLine();
					System.out.print("Enter value: ");
					value = sc.nextLine();
					resList = sdb.fetchStudentsFromDB(field, value);
					for (Student st: resList) {
						System.out.println(st);
					}
					break;
				case 4:
					System.out.print("Enter id: ");
					if (sc.hasNextInt()) {
						id = sc.nextInt();
						sc.nextLine();
					}
					System.out.print("Enter field: ");
					field = sc.nextLine();
					System.out.print("Enter value: ");
					value = sc.nextLine();
					res = sdb.updateStudentInDB(id, field, value);
					System.out.println(res?"Successful":"Failure");
					break;
				case 0:
					break;
				default:
					System.out.println("Wrong Input!");
			}
		}
		sc.close();
		sdb.close();
		System.out.println("Application closes");
	}

}
