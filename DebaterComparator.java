package debate;

import java.util.Comparator;

public class DebaterComparator implements Comparator<Debater> {
    
	public int compare(Debater d1, Debater d2) {
        return (d1.getScore() - d2.getScore());
    }
}
