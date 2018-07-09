package debate;

import java.util.Comparator;

public class TeamComparator implements Comparator<Team> {

	public int compare(Team t1, Team t2) {
		if (t1.getWins() > t2.getWins())
			return 1;
		else if ((t1.getWins() == t2.getWins())
				&& (t1.getScore() > t2.getScore()))
			return 1;
		else if ((t1.getWins() == t2.getWins())
				&& (t1.getScore() == t2.getScore()))
			return 0;
		else
			return -1;
	}
}
