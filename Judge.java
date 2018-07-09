package debate;

public class Judge {
	private String firstName;
	private String lastName;
	
	public Judge(String f, String l){
		firstName = f;
		lastName = l;
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
	
	public boolean equals(Judge j){
		if(firstName.equals(j.getFirstName()) && lastName.equals(j.getLastName()))
			return true;
		else
			return false;
	}
	
	public String toString(){
		return firstName + " " + lastName;
	}

}
