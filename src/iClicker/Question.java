package iClicker;
import java.util.*;

public class Question {

	private int numCanAnswers;
	private HashSet <String> candidateAnswers;
	private HashSet <String> correctAnswer;

	public Question(HashSet<String> canAns, HashSet<String> corAns){
		//1 for Single choice answer, 2 for Multiple choices
		//if(corAns.size() > 1){
		//	questionType = 2;
		//}
		//else{
		//	questionType = 1;
		//}
		this.candidateAnswers = canAns;
		this.correctAnswer = corAns;
		this.setNumCanAnswers(candidateAnswers.size());
	}
	
	public Question() {
		numCanAnswers = 0;
		candidateAnswers = new HashSet<String>();
		correctAnswer = new HashSet <String>();
	}

	public void setCandidateAnswers(List<String> list){
		candidateAnswers.clear();
		candidateAnswers.addAll(list);
		this.numCanAnswers = candidateAnswers.size();
		System.out.println("Candidate Answers: " + candidateAnswers);
	}
	
	public void setCorrectAnswer(List<String> cor){
		correctAnswer.clear();
		correctAnswer.addAll(cor);
	}

	public HashSet <String> getCandidateAnswers() {
		return candidateAnswers;
	}

	public HashSet <String> getCorrectAnswer() {
		return correctAnswer;
	}

	public int getNumCanAnswers() {
		return numCanAnswers;
	}

	public void setNumCanAnswers(int numCanAnswers) {
		this.numCanAnswers = numCanAnswers;
	}
	
}
