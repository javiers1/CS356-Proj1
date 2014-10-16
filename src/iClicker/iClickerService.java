package iClicker;
import java.util.*;

public class iClickerService {

	private HashMap<String, Set<String>> studentAnswers = new HashMap <String, Set<String>> ();
	private Question myQuestion;
	
	public iClickerService(Question myQuestion){
		this.setQuestion(myQuestion);
	}

	public Question getQuestion() {
		return myQuestion;
	}

	public void setQuestion(Question myQuestion) {
		this.myQuestion = myQuestion;
		studentAnswers.clear();
	}
	
	public void addStudentAnswer(String studentID, Set<String> answer){
		
		if(!myQuestion.getCandidateAnswers().containsAll(answer)){
			System.out.println("Invalid Answer Submitted");
		} else {
			//Because it is a HashMap, the Key, studentID, can only hold one Answer set, hence, last answer
			studentAnswers.put(studentID, answer);
		}
	}
	
	public void print(){
		for (String students : studentAnswers.keySet()) {
	        System.out.println(students + " " + studentAnswers.get(students));
	    }
	}
	
}
