package iClicker;
import java.util.*;

/**
 * Question class. Holds candidate answer choices and the correct answer
 * Questions can be single choice or multiple choices
 * 
 * @author Javier Sanchez
 *
 */
public class Question {
	/**
	 * Linked Hash Sets used to keep the candidate answers in order with distinct
	 * elements i.e ("A", "B", "C" and not "B", "C", "A")
	 */
	private int questionType;
	private int numCanAnswers;
	private LinkedHashSet <String> candidateAnswers;
	private LinkedHashSet <String> correctAnswer;
	
	/**
	 * Optional constructor to instantiate with set of candidate and correct answer
	 * not used in this implementation
	 * 
	 * @param canAns - Linked Hash Set of Strings
	 * @param corAns - Linked Hash Set of Strings
	 */
	public Question(LinkedHashSet<String> canAns, LinkedHashSet<String> corAns){
		//1 for Single choice answer, 2 for Multiple choices
		if(corAns.size() > 1){
			questionType = 2;
		}
		else{
			questionType = 1;
		}
		this.candidateAnswers = canAns;
		this.correctAnswer = corAns;
	}
	
	/**
	 * default constructor
	 */
	public Question() {
		questionType = 0;
		numCanAnswers = 0;
		candidateAnswers = new LinkedHashSet<String>();
		correctAnswer = new LinkedHashSet <String>();
	}
    
	/**
	 * Takes a List of candidate answers and turns them into
	 * the field Linked Hash Set of candidate answer
	 * 
	 * @param list - List<String> of candidate answers
	 */
	public void setCandidateAnswers(List<String> list){
		candidateAnswers.clear();
		candidateAnswers.addAll(list);
		this.numCanAnswers = candidateAnswers.size();
	}
	
	/**
	 * Same as setCandidateAnswer, but, also sets the field
	 * to distinguish between multiple and single choice
	 * 
	 * @param cor - List of the one correct answer
	 */
	public void setCorrectAnswer(List<String> cor){
		if(cor.size() == 1){
			questionType = 1;
		} else {
			questionType = 2;
		}
		correctAnswer.clear();
		correctAnswer.addAll(cor);
	}
	
	/**
	 * @return candidate answers as a set for the Question
	 */
	public LinkedHashSet <String> getCandidateAnswers() {
		return candidateAnswers;
	}
	
	/**
	 * @return correct answer set
	 */
	public LinkedHashSet <String> getCorrectAnswer() {
		return correctAnswer;
	}
	
	/**
	 * @return number of candidate answers, used for printing purposes
	 */
	public int getNumCanAnswers() {
		return numCanAnswers;
	}
	
	/**
	 * Used to distinguish single.multiple choice answer for the question
	 * 
	 * @return 1 if single-choice, 2 if multiple choices
	 */
	public int getQuestionType(){
		return this.questionType;
	}
	
}
