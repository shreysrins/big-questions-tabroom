package debate;

import java.util.ArrayList;

public class Debater {
	private String firstName;
	private String lastName;
	private int score;
	
	public Debater(String f, String l){
		firstName = f;
		lastName = l;
		score = 0;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	
	public void addScore(int s){
		score += s;
	}
	
	public boolean equals(Debater d){
		if(firstName.equals(d.getFirstName()) && lastName.equals(d.getLastName()))
			return true;
		else
			return false;
	}
	
	public String toString(){
		return firstName + " " + lastName;
	}

}
