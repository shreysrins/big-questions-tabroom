package debate;

public class Round {
	private Judge j;
	private Team t1;
	private Team t2;
	private String room;
	
	public Round(Judge j, Team t1, Team t2, String room){
		this.j = j;
		this.t1 = t1;
		this.t2 = t2;
		this.room = room;
	}
	
	public String toString(){
		return "Judge " + j.toString() + ", Room " + room + ": " + t1.toString() + " vs " + t2.toString();
	}

}
