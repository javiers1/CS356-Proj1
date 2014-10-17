package iClicker;
import java.util.*;

/**
 * iClickerService pieces together Questions and Students
 * Simluates a "Classroom"
 * @author Javier Sanchez
 *
 */
public class iClickerService {
	
	//Maps to hold the Student Answers, Answer Totals, and Question
	private HashMap<String, Set<String>> studentAnswers;
	private HashMap<String,Integer> answerTotals;
	private Question myQuestion;
	
	/**
	 * Constructor to set up a service with initial Question
	 * @param myQuestion - Question to be "presented"
	 */
	public iClickerService(Question myQuestion){
		this.myQuestion = myQuestion;
		this.studentAnswers  = new HashMap <String, Set<String>> ();
		this.answerTotals  = new HashMap <String,Integer> ();	
	}

	/**
	 * Re-Set the Question for the iClickerService session
	 * @param myQuestion - Question to be "presented"
	 */
	public void setQuestion(Question myQuestion) {
		this.myQuestion = myQuestion;
		studentAnswers.clear();
	}
	
	/**
	 * Adds the student's answer to the student answers Hash Map
	 * Must be proper answer type (Multiple or Single)
	 * Must be a valid candidate answer to be saved
	 * @param studentID - String
	 * @param answer - Answer in a set, ex. "A" "B" "C"
	 */
	public void addStudentAnswer(String studentID, Set<String> answer){
		//Only add if it is a valid answer choice and follows question type, single or multiple.
		if(!myQuestion.getCandidateAnswers().containsAll(answer)){
			System.out.println("Invalid Answer Submitted");
		} else if ((myQuestion.getQuestionType() == 1) && (answer.size() > 1)){
			System.out.println("Answer Submission is single choice");
		} else {
			//Because it is a HashMap, the Key, studentID, can only hold one Answer set, hence, last answer
			studentAnswers.put(studentID, answer);
		}
	}
	
	/**
	 * Calculates the Answer Totals based on the valid saved answers submitted by the students
	 * used only by iClickerService class when printing information!
	 */
	private void calculateTotals(){
		Set <String> temp = myQuestion.getCandidateAnswers();
		for(String ans: temp){
			answerTotals.put(ans, 0);
		}
		int count;
		for(String key: studentAnswers.keySet()){
			temp = studentAnswers.get(key);
			for(String answer: temp){
				count = answerTotals.get(answer);
				count++;
				answerTotals.put(answer, count);
			}
		}
	}
	
	/**
	 * Prints out every student ID and corresponding answer
	 * and also prints answer totals
	 */
	public void print(){
		calculateTotals();
		System.out.println("ID   Answer Submitted");
		System.out.println("-------------------");
		for (String student : studentAnswers.keySet()) {
	        System.out.printf("%-3.3s: " + studentAnswers.get(student) + "\n",student);
	    }
		
		System.out.println();
		System.out.println("Answer Totals");
		System.out.println("--------------");
		for (String answer : myQuestion.getCandidateAnswers()) {
	        System.out.println(answer + ": " + answerTotals.get(answer));
	    }
		System.out.println();
	}
	
}
