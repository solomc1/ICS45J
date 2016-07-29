//Madeline Chan, 76439804
//Solomon Chan, 40786337

public class RosterManager {
	
	//private variables
	private Course [] courseList;
	private int courseNum;
	
	//default constructor
	public RosterManager(){
		courseList = new Course[10];
		courseNum = 0;
	}
	
	//constructor
	public RosterManager(Course[] c, int num){
		courseList = c;
		courseNum = num;
	}
	
	//main loop; loops through commands and executes accordingly
	public void run(){
		System.out.println("Welcome to Class Roster Manager!");
		System.out.println("Select an action based on the following menu:");
		while(true){
			try{
				ClassRosterUI.printMenu();
				String command = ClassRosterUI.getCommand();
				switch(command){
					case("ac"):
						addCourse(ClassRosterUI.getCourseInfo());
						break;
					case("dc"):
						deleteCourse(ClassRosterUI.getCourseCode());
						break;
					case("as"):
						addStudent(ClassRosterUI.getStudentCourseCode(),ClassRosterUI.getStudent());
						break;
					case("ds"):
						deleteStudent(ClassRosterUI.getStudentId(),ClassRosterUI.getStudentCourseCode());
						break;
					case("p"):
						printRoster();
						break;
					case("q"):
						return;
				}
			}catch(DuplicateCourseException e){
				System.out.println("ERROR: Course already on roster.");
			}catch(CourseLimitException e){
				System.out.println("ERROR: Roster is full");
			}catch(EmptyCourseListException e){
				System.out.println("ERROR: Roster is empty");
			}catch(CourseNotFoundException e){
				System.out.println("ERROR: Course not found");
			}catch(DuplicateStudentException e){
				System.out.println("ERROR: Student already in course");
			}catch(StudentLimitException e){
				System.out.println("ERROR: Course is full");
			}catch(StudentNotFoundException e){
				System.out.println("ERROR: Student not found");
			}catch(EmptyStudentListException e){
				System.out.println("ERROR: No students enrolled");
			}
		}
	}
	
	//adds course to roster
	public void addCourse(Course c) throws DuplicateCourseException, CourseLimitException{
		if(courseNum == 10){
			throw new CourseLimitException();
		}
		for(int i = 0; i<courseNum; i++){
			if(courseList[i].getCourseCode().toLowerCase().equals(c.getCourseCode().toLowerCase())){
				throw new DuplicateCourseException();
			}
		}
		courseList[courseNum] = c;
		courseNum++;
		
	}
	
	//deletes course from roster
	public void deleteCourse(String courseCode) throws CourseNotFoundException, EmptyCourseListException{
		if(courseNum == 0){
			throw new EmptyCourseListException();
		}
		for(int i = 0; i<courseNum; i++){
			if(courseList[i].getCourseCode().toLowerCase().equals(courseCode.toLowerCase())){
				courseList[i] = courseList[courseNum-1];
				courseNum--;
				return;
			}
		}
		throw new CourseNotFoundException();
	}
	
	
	//adds student to course on roster
	public void addStudent(String courseCode, Student s) throws StudentLimitException, DuplicateStudentException, CourseNotFoundException{
		for(int i = 0; i<courseNum; i++){
			if(courseList[i].getCourseCode().toLowerCase().equals(courseCode.toLowerCase())){
				courseList[i].addStudent(s);
				return;
			}
		}
		throw new CourseNotFoundException();
	}
	
	
	//deletes student from course on roster
	public void deleteStudent(int id, String courseCode) throws EmptyStudentListException, StudentNotFoundException, CourseNotFoundException{
		for(int i = 0; i<courseNum; i++){
			if(courseList[i].getCourseCode().toLowerCase().equals(courseCode.toLowerCase())){
				courseList[i].removeStudent(id);
				return;
			}
		}
		throw new CourseNotFoundException();
	}
	
	//prints out course and student information on roster
	public void printRoster(){
		System.out.println("**************");
		for(int i = 0; i< courseNum; i++){
			System.out.println(courseList[i].getCourseCode()+": "+courseList[i].getCourseName());
			System.out.println("Enrolled: "+courseList[i].getNumEnrolled());
			for(int j = 0; j<courseList[i].getNumEnrolled(); j++){
				//System.out.println(j);
				System.out.println("\t\t"+courseList[i].getEnrollment()[j].getId()+"\t| "+courseList[i].getEnrollment()[j].getLast()+", "+courseList[i].getEnrollment()[j].getFirst());
			}
		}
		System.out.println("**************");
	}
	
	//course array accessor
	public Course[] getCourseList(){
		return courseList;
	}
	
	//number of courses accessor
	public int getCourseNum(){
		return courseNum;
	}
}
