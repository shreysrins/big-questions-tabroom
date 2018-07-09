package debate;

public class Team {
	private Debater d1;
	private Debater d2;
	private int wins;

	public Team(Debater d) {
		this.d1 = d;
		d2 = null;
		wins = 0;
	}

	public void addD2(Debater d2) {
		this.d2 = d2;
	}

	/**
	 * @return the d1
	 */
	public Debater getD1() {
		return d1;
	}

	/**
	 * @return the d2
	 */
	public Debater getD2() {
		return d2;
	}

	/**
	 * @return the wins
	 */
	public int getWins() {
		return wins;
	}

	public int getScore() {
		if (d2 != null)
			return (d1.getScore() + d2.getScore());
		else
			return d1.getScore() * 2;
	}

	public void addWin() {
		wins++;
	}

	public boolean equals(Team t) {
		if (d1.equals(t.getD1()) && (d2 != null) && d2.equals(t.getD2()))
			return true;
		else if (d1.equals(t.getD1()) && (d2 == null) && (t.getD2() == null))
			return true;
		else
			return false;
	}

	public String toString() {
		if (d2 == null)
			return d1.getLastName();
		else
			return d1.getLastName() + "/" + d2.getLastName();
	}

}
