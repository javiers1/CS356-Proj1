package iClicker;
import java.util.*;

public class Student {

	private String student_id;

	public Student(){
		int temp = (int) Math.round(Math.random()*1000);
		this.student_id = Double.toString(temp);
	}
	
	public String getStudent_id() {
		return student_id;
	}
	
	public void submitAnswer(iClickerService classSession, List <String> answer){
		Set <String> temp = new HashSet <String> ();
		temp.addAll(answer);
		classSession.addStudentAnswer(student_id,temp);
	}
	
}
