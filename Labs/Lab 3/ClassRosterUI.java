//Madeline Chan, 76439804
//Solomon Chan, 40786337

import java.util.Scanner;

public class ClassRosterUI {
	//class to store static methods to get user input
	
	//prints the menu for the user
	public static void printMenu(){
		System.out.println("--------------");
		System.out.println("ac: Add Course");
		System.out.println("dc: Drop Course");
		System.out.println("as: Add Student");
		System.out.println("ds: Drop Student");
		System.out.println(" p: Print Class Roster");
		System.out.println(" q: Quit Program");
		System.out.println("--------------");
	}
	
	//gets a valid command from user
	public static String getCommand(){
		System.out.print("Enter Command: ");
		Scanner s = new Scanner(System.in);
		String in = s.nextLine().toLowerCase();
		while(!(in.equals("ac") || in.equals("dc") || in.equals("as") ||in.equals("ds") ||in.equals("p") ||in.equals("q"))){
			System.out.print("Invalid Input.");
			System.out.print("Enter Command: ");
			in = s.nextLine().toLowerCase();
		}
		return in;
	}
	
	//gets valid input to create a course
	public static Course getCourseInfo(){
		System.out.print("Enter Course Code: ");
		Scanner s = new Scanner(System.in);
		String code = s.nextLine();
		System.out.print("Enter Course Name: ");
		String name = s.nextLine();
		return new Course(code, name, 0, new Student[50]);
	}
	
	//gets valid input for a student's course code
	public static String getStudentCourseCode(){
		System.out.print("Enter course code for Student: ");
		Scanner s = new Scanner(System.in);
		return s.nextLine();
	}
	
	//gets valid input for a student's id
	public static int getStudentId(){
		Scanner s = new Scanner(System.in);
		int i;
		while(true){
			try{
			System.out.print("Enter StudentID: ");
			i = Integer.parseInt(s.nextLine());
			break;
			}catch(Exception e){
				System.out.print("Invalid input. ");
			}
		}
		return i;
	}
	
	//gets valid input for a course code
	public static String getCourseCode(){
		System.out.print("Enter course code: ");
		Scanner s = new Scanner(System.in);
		return s.nextLine();
	}
	
	//gets valid input to create a student
	public static Student getStudent(){
		Scanner s = new Scanner(System.in);
		int id;
		while(true){
			try{
			System.out.print("Enter StudentID: ");
			id = Integer.parseInt(s.nextLine());
			break;
			}catch(Exception e){
				System.out.print("Invalid input. ");
			}
		}
		System.out.print("Enter last name: ");
		String last = s.nextLine();
		System.out.print("Enter first name: ");
		String first = s.nextLine();
		return new Student(id, first, last);
	}
}
