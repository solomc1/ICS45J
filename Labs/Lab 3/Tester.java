//Madeline Chan, 76439804
//Solomon Chan, 40786337

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class Tester{
	
	//constructed courses and students to use in tests
	RosterManager r;
	Course a = new Course("0","0",0,new Student[50]);
	Course b = new Course("1","0",0,new Student[50]);
	Course c = new Course("2","0",0,new Student[50]);
	Course d = new Course("3","0",0,new Student[50]);
	Course e = new Course("4","0",0,new Student[50]);
	Course f = new Course("5","0",0,new Student[50]);
	Course g = new Course("6","0",0,new Student[50]);
	Course h = new Course("7","0",0,new Student[50]);
	Course i = new Course("8","0",0,new Student[50]);
	Course j = new Course("9","0",0,new Student[50]);
	Student a1 = new Student(1, "a", "a");
	Student b1 = new Student(2, "b", "b");
	Student c1 = new Student(3, "c", "c");
	
	//resets roster to blank slate for each test
	@Before
	public void executeBeforeEachTest(){
		r = new RosterManager();
	}

	//ensures that the course limit is 10 courses
	@Test(expected=CourseLimitException.class)
	public void testAddCourse() throws CourseLimitException, DuplicateCourseException {
		assertEquals(0,r.getCourseNum());
		r.addCourse(a);
		assertEquals(1,r.getCourseNum());
		r.addCourse(b);
		r.addCourse(c);
		r.addCourse(d);
		r.addCourse(e);
		r.addCourse(f);
		r.addCourse(g);
		r.addCourse(h);
		r.addCourse(i);
		r.addCourse(j);
		assertEquals(10,r.getCourseNum());
		r.addCourse(new Course());
	}
	
	//ensures that duplicate courses cannot be added
	@Test(expected=DuplicateCourseException.class)
	public void testAddCourseAgain() throws CourseLimitException, DuplicateCourseException {
		assertEquals(0,r.getCourseNum());
		r.addCourse(a);
		r.addCourse(a);
	}

	//ensures that you can't delete a course from an empty roster
	@Test(expected=EmptyCourseListException.class)
	public void testDeleteCourseOne() throws CourseNotFoundException, EmptyCourseListException {
		r.deleteCourse("1");
	}
	
	//ensures that you can't delete a course that's not on the roster
	@Test(expected=CourseNotFoundException.class)
	public void testDeleteCourse() throws DuplicateCourseException, CourseLimitException, CourseNotFoundException, EmptyCourseListException {
		r.addCourse(a);
		r.addCourse(b);
		assertEquals(2,r.getCourseNum());
		r.deleteCourse("0");
		r.deleteCourse("0");
	}

	//ensures that you can't add a student to a course not on the roster
	@Test(expected=CourseNotFoundException.class)
	public void testAddStudent() throws DuplicateCourseException, CourseLimitException, StudentLimitException, DuplicateStudentException, CourseNotFoundException {
		r.addCourse(a);
		r.addStudent("2", a1);
	}
	
	//ensures that you can't add the same student to the same course twice
	@Test(expected=DuplicateStudentException.class)
	public void testAddStudentTwo() throws DuplicateCourseException, CourseLimitException, StudentLimitException, DuplicateStudentException, CourseNotFoundException {
		r.addCourse(a);
		r.addStudent("0", a1);
		assertEquals(1,r.getCourseList()[0].getNumEnrolled());
		r.addStudent("0", a1);
	}
	
	//ensures that each course has a student limit of 50
	@Test(expected=StudentLimitException.class)
	public void testAddStudentThree() throws DuplicateCourseException, CourseLimitException, StudentLimitException, DuplicateStudentException, CourseNotFoundException {
		r.addCourse(a);
		assertEquals(0,r.getCourseList()[0].getNumEnrolled());
		for(int i = 0; i<50; i++){
			r.addStudent("0", new Student(i, Integer.toString(i), Integer.toString(i)));
		}
		assertEquals(50,r.getCourseList()[0].getNumEnrolled());
		r.addStudent("0",b1);
	}

	//ensures that you can't delete a student that's not on the roster for the course
	@Test(expected=StudentNotFoundException.class)
	public void testDeleteStudent() throws DuplicateCourseException, CourseLimitException, StudentLimitException, DuplicateStudentException, CourseNotFoundException, EmptyStudentListException, StudentNotFoundException {
		r.addCourse(a);
		assertEquals(0,r.getCourseList()[0].getNumEnrolled());
		r.addStudent("0", b1);
		r.addStudent("0", a1);
		assertEquals(1,r.getCourseList()[0].getEnrollment()[0].getId());
		r.deleteStudent(1, "0");
		r.deleteStudent(1, "0");
	}
	
	//ensures that you can't delete a student from a course not on the roster
	@Test(expected=CourseNotFoundException.class)
	public void testDeleteStudentTwo() throws CourseNotFoundException, EmptyStudentListException, StudentNotFoundException {
		r.deleteStudent(1, "0");
	}
	
	//ensures that you can't delete a student from an empty roster
	@Test(expected=EmptyStudentListException.class)
	public void testDeleteStudentThree() throws CourseNotFoundException, EmptyStudentListException, StudentNotFoundException, DuplicateCourseException, CourseLimitException {
		r.addCourse(a);
		r.deleteStudent(1, "0");
	}

}
