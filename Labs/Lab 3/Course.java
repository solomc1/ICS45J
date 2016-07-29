//Madeline Chan, 76439804
//Solomon Chan, 40786337

public class Course {

	//private variables
	private String courseCode;
	private String courseName;
	private int numEnrolled;
	private Student enrollment[];
	private int maxEnrolled = 50;
	
	//default constructor
	public Course(){
		courseCode = "0";
		courseName = "Solomon";
		numEnrolled = 0;
		enrollment = new Student[maxEnrolled];
	}
	
	//constructor
	public Course(String code, String name, int e, Student[] s){
		courseCode = code;
		courseName = name;
		numEnrolled = e;
		enrollment = s;
	}
	
	//adds student to course
	public void addStudent(Student s) throws StudentLimitException, DuplicateStudentException{
		if(numEnrolled == maxEnrolled){
			throw new StudentLimitException();
		}
		for(int i = 0; i < numEnrolled; i++){
			if(enrollment[i].getId() == s.getId()){
				throw new DuplicateStudentException();
			}
		}
		int index = numEnrolled;
		for(int i = 0; i < numEnrolled; i++){
			if(s.getLast().toLowerCase().compareTo(enrollment[i].getLast().toLowerCase()) < 0){
				index = i;
			}else if(s.getLast().toLowerCase().equals(enrollment[i].getLast().toLowerCase())){
				if(s.getId() < enrollment[i].getId()){
					index = i;
				}else{
					index = i+1;
				}
			}
		}
		Student[] newList = new Student[50];
		for(int i = 0; i<index; i++){
			newList[i] = enrollment[i];
		}
		newList[index] = s;
		for(int i = index+1;i<numEnrolled+1;i++){
			newList[i] = enrollment[i-1];
		}
		enrollment = newList;
		numEnrolled++;
	}
	
	//removes student from course
	public void removeStudent(int id) throws EmptyStudentListException, StudentNotFoundException{
		if(numEnrolled == 0){
			throw new EmptyStudentListException();
		}
		Student [] newlist = new Student[maxEnrolled];
		int index = -1;
		for(int i = 0; i < numEnrolled; i++){
			if(enrollment[i].getId() == id){
				index = i;
				break;
			}
		}
		if(index == -1){
			throw new StudentNotFoundException();
		}
		else{
			for(int i = 0; i<index; i++){
				newlist[i] = enrollment[i];
			}
			for(int i = index+1;i<numEnrolled;i++){
				newlist[i-1] = enrollment[i];
			}
			enrollment = newlist;
			numEnrolled--;
		}
	}

	
	//course code accessor
	public String getCourseCode(){
		return courseCode;
	}
	
	//course name accessor
	public String getCourseName(){
		return courseName;
	}
	
	//number enrolled accessor
	public int getNumEnrolled(){
		return numEnrolled;
	}
	
	//maximum capacity accessor
	public int getMaxEnrolled(){
		return maxEnrolled;
	}
	
	//student array accessor
	public Student[] getEnrollment(){
		return enrollment;
	}
}
