package test.java.oodp.finalexam.test;

import oodp.finalexam.student.Student;
import oodp.finalexam.student.StudentReader;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestStudent {
	StudentReader sr;
	Student student;
	List<Student> students = new ArrayList<>();
	String fileName = "students.txt";
	
	
	@Before
	public void setup() {
		sr = new StudentReader();
	}
	
	@Test
	public void testLoadStudent() {
		students = sr.loadStudents(fileName);
		Student st;
		
		st = students.get(0);
		assertEquals("001", st.getId());
		assertEquals("Anna", st.getName());
		assertEquals(1, st.getYear());
		assertEquals(3.00, st.getGPA(), 0.0);
		
		st = students.get(1);
		assertEquals("002", st.getId());
		assertEquals("Bee", st.getName());
		assertEquals(2, st.getYear());
		assertEquals(3.02, st.getGPA(), 0.0);
		
		st = students.get(2);
		assertEquals("003", st.getId());
		assertEquals("Cat", st.getName());
		assertEquals(3, st.getYear());
		assertEquals(3.03, st.getGPA(), 0.0);

	}
	@Test
	public void testPrintStudentsArray() {
		//List<Student> students
		students = sr.loadStudents(fileName);
		Student st = sr.getHighestGPA(students);
		assertEquals("003", st.getId());
	}
	
	@Test
	public void testSearchByID() {
		
		students = sr.loadStudents(fileName);
		String temp = sr.searchByID("002",students);
		assertEquals("002 is Bee", temp);
		
		temp = sr.searchByID("005",students);
		assertEquals("005 is not in the student list.", temp);
	}
	
	@Test
	public void testToString() {
		student =  new Student("David", "004", 4, 3.05);
		
		String temp = student.toString();

		assertEquals("Student ID:004, name:David, year:4 ,GPA:3.05", temp);
	}
	
}
