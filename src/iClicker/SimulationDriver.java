package iClicker;
import java.util.*;

/**
 * Simulation of simple iClicker application
 * 
 * @author Javier Sanchez
 * For CS 356 - Object Oriented Design
 * Dr. Yu Sun
 * Fall 2014
 */


public class SimulationDriver {
	/**
	 * Main method will run a simulation of the iClicker program.
	 * 
	 * First Simulation: 
	 * Creates 5-30 random students with random multiple choice answers and outputs 
	 * the ID and answer, then calculates the answer totals for the class
	 * 	
	 * Second Simulation:
	 * Demonstrates single choice answers where each student can only submit one
	 * answer, their latest submission.
	 * 
	 * One iClickerService loaded with two different questions. Students submit to the iClickerService
	 * 
	 */
	public static void main(String [] args){
		//Create new Questions, Multiple Choices
		Question q1 = new Question();
		q1.setCandidateAnswers(Arrays.asList("A", "B", "C","D","E"));
		q1.setCorrectAnswer(Arrays.asList("B","D"));
		
		//Single Choice T/F
		Question q2 = new Question();
		q2.setCandidateAnswers(Arrays.asList("True", "False"));
		q2.setCorrectAnswer(Arrays.asList("False"));		
		
		//Create iClickerService, instantiate it with q1, question can be changed
		iClickerService cs356 = new iClickerService(q1);
		
		//Random Number of Students from 0 to 30 students possible
		int numStudents = 5 + (int) (Math.round(Math.random()*1000)) % 25;
		int numChoices, choiceSelect;
		String tempAns = null;
		Student aStudent;	
		List<String> tempAnswerSubmission = new ArrayList<String>();
		
		//For n students, create a new Student with ID, populate their answer, and submit it 
		for(int i = 0; i < numStudents; i++){
			aStudent = new Student();
			numChoices = 1 + ((int) (Math.round(Math.random()*10000)) % 4);
			for(int j = 0; j < numChoices; j++){
				choiceSelect = (int) (Math.round(Math.random()*10000)) % 5;
				switch (choiceSelect) {
				case 0:
					tempAns = "A";
					break;
				case 1:
					tempAns = "B";
					break;
				case 2:
					tempAns = "C";
					break;
				case 3:
					tempAns = "D";
					break;
				case 4:
					tempAns = "E";
					break;
				default:
					break;
				}
				tempAnswerSubmission.add(tempAns);
			}
			aStudent.submitAnswer(cs356, tempAnswerSubmission);
			tempAnswerSubmission.clear();
		}
		
		//Print n random student answers
		cs356.print();
		
		//Simulation 2: Set the class to a new Question, single choice, T/F
		cs356.setQuestion(q2);

		//Create 3 students for this example
		Student javier = new Student();
		Student chris = new Student();
		Student mark = new Student();
		
		//Javier and Chris, at the end, only will have one submission
		javier.submitAnswer(cs356, Arrays.asList("False"));
		chris.submitAnswer(cs356, Arrays.asList("False"));
		chris.submitAnswer(cs356, Arrays.asList("True"));
		chris.submitAnswer(cs356, Arrays.asList("False"));
		javier.submitAnswer(cs356, Arrays.asList("True"));
		mark.submitAnswer(cs356, Arrays.asList("True"));
		
		//Print second example
		cs356.print();
	}
}
