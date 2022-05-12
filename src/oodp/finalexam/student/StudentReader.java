package oodp.finalexam.student;


import oodp.Keyboard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StudentReader {
	
	String fileName = "students.txt";	
	List<Student> students = new ArrayList<>();
	
	 public void setFileName(String fileName) {
		    this.fileName = fileName;
	}
	 
	public List<Student>getStudents() {
			return students;
	}
	
	public void start() {
    	
     // Load the movie data
        students = loadStudents(fileName);
        
     // Do some stuff with the data to check that its working
        printStudentsArray(students);
        
     // Searching highestGPA
        Student highestGPA = getHighestGPA(students);        
        printResults(highestGPA);
        System.out.println();
        
     // Searching student by ID
        System.out.print("Enter student ID: ");
        String id = Keyboard.readInput();
        System.out.print(searchByID(id, students));
       
		
	}
	
	

		/**
	  	 * Reads movies from a file.
	  	 *
	  	 * @param fileName
	  	 * @return
     */
      
    public List<Student> loadStudents(String fileName) {
    	    	
    	File myFile = new File(fileName);
    	//TODO: complete the method for loading data
    	// each line represent an information for 1 student
    	// then store each student object to ArrayList students
    	try  (Scanner scanner = new Scanner(myFile)){
			while (scanner.hasNext()){
				String[] data = scanner.nextLine().split(",");
				students.add(new Student(data[0], data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3])));
			}
    	
            return students;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
    	
    public void printStudentsArray(List<Student> students) {
    	  System.out.println("Student List");
    	  System.out.println("================");
		for (Student student : students) {
			System.out.println(student.toString());
		}
    }
    
    public Student getHighestGPA(List<Student> students) {
  		 //TODO:   Complete the getHighestGPA() method.
		Student highest = students.get(0);

		for (Student student: students){
			if (student.getGPA() > highest.getGPA()){
				highest = student;
			}
		}

		return highest;
	}
  	
    public void printResults(Student highestGPA) {
        System.out.println();
        System.out.println("The highest GPA student is: " + highestGPA.toString());
        
    }
  	
    public String searchByID(String studentID, List<Student> students) {
         //TODO: Complete the searchByID method
    	 // if find a student then return string as for example, "002 is Bee" 
    	 // if not find a student then return string as for example, "005 is not in the student list."
        for (Student student : students){
			if (student.getId().equals(studentID)){
				return studentID + " is " + student.getName();
			}
		}

		return studentID + " is not in the student list.";
     }    
    
  	 
  	public static void main(String[] args) {
  		new StudentReader().start();
    }

}
