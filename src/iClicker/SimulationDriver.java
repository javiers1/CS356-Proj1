package iClicker;
import java.util.*;
//import java.math.*;

public class SimulationDriver {
	
	public static void main(String [] args){
		//Create new Question, set the Candidate and Correct Answers
		Question q1 = new Question();
		q1.setCandidateAnswers(Arrays.asList("A", "B", "C","D","E"));
		q1.setCorrectAnswer(Arrays.asList("B","D"));
		
		//Create iClickerService, instantiate it with q1, question can be changed
		iClickerService cs356 = new iClickerService(q1);
		
		//Rand Number of Students
		Student javier = new Student();
		javier.submitAnswer(cs356, Arrays.asList("B","D"));
		cs356.print();
	}
}
