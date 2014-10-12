package iClicker;
import java.util.*;

public class SimulationDriver {
	
	public static void main(String [] args){
		Set<String> candidateAnswers = new TreeSet<String>();
		Set<String>	correctAnswers = new TreeSet<String>();
		
		//Possible Choices A,B,C,D,E
		candidateAnswers.add("A");
		candidateAnswers.add("B");
		candidateAnswers.add("C");
		candidateAnswers.add("D");
		candidateAnswers.add("E");
		
		//Correect Answers are B and D
		correctAnswers.add("B");
		correctAnswers.add("D");
		Question q1 = new Question(candidateAnswers,correctAnswers);
		
		
	}
}
