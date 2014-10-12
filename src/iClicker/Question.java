package iClicker;
import java.util.*;

public class Question {

	private int questionType;
	private Set <String> candidateAnswers;
	private Set <String> correctAnswer;

	public Question(Set<String> canAns, Set<String> corAns){
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

	public Set <String> getCandidateAnswers() {
		return candidateAnswers;
	}

	public Set <String> getCorrectAnswer() {
		return correctAnswer;
	}
	
}
