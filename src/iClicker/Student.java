package iClicker;
import java.util.*;

/**
 * The Student class simulates a student in class
 * For this implementation, a Student only needs an ID
 * @author Javier Sanchez
 *
 */
public class Student {

	private String student_id;
	
	/**
	 * Constructor, by default a random ID is created
	 * from 100 - 1000. Used to keep track of student submissions 
	 */
	public Student(){
		int temp = 10 * (int) Math.round(Math.random()*1000);
		this.student_id = Double.toString(temp);
	}
	
	/**
	 * 
	 * @return String - Student_ID
	 */
	public String getStudent_id() {
		return student_id;
	}
	
	/**
	 * Takes in the answer as a List of Strings and sends it to the iClickerService
	 * specified. Before sending to the iClickerService, it is converted into a set
	 * so that there are no repeated String answers.
	 * 
	 * @param iClickerService - classSession
	 * @param List <String> - answer strings i.e. "A", "C", "D"
	 */
	public void submitAnswer(iClickerService classSession, List <String> answer){
		Set <String> temp = new HashSet <String> ();
		temp.addAll(answer);
		classSession.addStudentAnswer(student_id,temp);
	}
	
}
