package iClicker;
import java.util.*;

public class iClickerService {

	private Set<String> studentAnswers;
	private Question myQuestion;
	
	public iClickerService(Question myQuestion){
		this.setMyQuestion(myQuestion);
	}

	public Question getMyQuestion() {
		return myQuestion;
	}

	public void setMyQuestion(Question myQuestion) {
		this.myQuestion = myQuestion;
	}
	
}
