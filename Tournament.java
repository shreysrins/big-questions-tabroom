package debate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.StringTokenizer;

public class Tournament {
	private static ArrayList<Debater> debaters;
	private static ArrayList<Judge> judges;
	private static ArrayList<Team> teams;
	private static ArrayList<String> rooms;

	public static void main(String[] args) throws IOException {
		addJudges("C://Users//Shreyas//Documents//Hobbies//Debate//ISDT//judges.in");
		teams = new ArrayList<Team>();
		debaters = new ArrayList<Debater>();
		BufferedReader r1 = new BufferedReader(new FileReader("C://Users//Shreyas//Documents//Hobbies//Debate//ISDT//teams.in"));
		StringTokenizer st;

		while (r1.ready()) {
			String tNames = r1.readLine();
			st = new StringTokenizer(tNames);
			Debater d1 = new Debater(st.nextToken(), st.nextToken());
			Team t = new Team(d1);
			if (st.hasMoreTokens()) {
				Debater d2 = new Debater(st.nextToken(), st.nextToken());
				t.addD2(d2);
				debaters.add(d2);
			}
			debaters.add(d1);
			teams.add(t);
		}
		r1.close();

		rooms = new ArrayList<String>();
		BufferedReader r2 = new BufferedReader(new FileReader("C://Users//Shreyas//Documents//Hobbies//Debate//ISDT//rooms.in"));
		String room = r2.readLine();
		while (room != null) {
			st = new StringTokenizer(room);
			rooms.add(st.nextToken());
			room = r2.readLine();
		}
		r2.close();

		//makeRound("C://Users//Shreyas//Documents//Hobbies//Debate//ISDT//round1.out");
		//makeRound("C://Users//Shreyas//Documents//Hobbies//Debate//ISDT//round2.out");
		//inputRound("C://Users//Shreyas//Documents//Hobbies//Debate//ISDT//round1.in");
		//inputRound("C://Users//Shreyas//Documents//Hobbies//Debate//ISDT//round2.in");
		outputBreak();
		System.out.println();
		outputSpeakers();
	}

	public static void addJudges(String fileName) throws IOException {
		judges = new ArrayList<Judge>();
		BufferedReader r = new BufferedReader(new FileReader(fileName));
		StringTokenizer st;

		String jName = r.readLine();
		while (jName != null) {
			st = new StringTokenizer(jName);
			judges.add(new Judge(st.nextToken(), st.nextToken()));
			jName = r.readLine();
		}

		r.close();
	}

	public static void makeRound(String fileName) throws IOException {
		PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter(
				fileName)));
		Collections.shuffle(teams, new Random());
		Collections.shuffle(judges, new Random());
		int n = teams.size() / 2;
		for (int i = 0; i < n; i++) {
			Round r = new Round(judges.get(i), teams.get(2 * i),
					teams.get(2 * i + 1), rooms.get(i));
			w.print(r);
		}
		w.close();
	}

	public static void inputRound(String fileName) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader(fileName));
		StringTokenizer st;
		while (r.ready()) {
			String line = r.readLine();
			st = new StringTokenizer(line);
			boolean win = st.nextToken().equals("T");
			Debater d1 = new Debater(st.nextToken(), st.nextToken());
			Team t = new Team(d1);
			for (int i = 0; i < debaters.size(); i++) {
				Debater curr = debaters.get(i);
				if (curr.equals(d1))
					curr.addScore(Integer.parseInt(st.nextToken()));
			}
			if (st.hasMoreTokens()) {
				Debater d2 = new Debater(st.nextToken(), st.nextToken());
				for (int i = 0; i < debaters.size(); i++) {
					Debater curr = debaters.get(i);
					if (curr.equals(d2))
						curr.addScore(Integer.parseInt(st.nextToken()));
				}
				t.addD2(d2);
			}
			if (win) {
				for (int i = 1; i < teams.size(); i++) {
					Team curr = teams.get(i);
					if (curr.equals(t))
						curr.addWin();
				}
			}
		}
		r.close();
	}

	public static void outputBreak() {
		Collections.sort(teams, new TeamComparator());
		Collections.reverse(teams);
		int i = 0;
		for (int j = 0; j < teams.size(); j++) {
			if (j == 0 || (j > 0 && teams.get(j).getScore() != teams.get(j - 1).getScore()))
				i++;
			System.out.println(i + ". " + teams.get(j));
		}
	}

	public static void outputSpeakers() {
		Collections.sort(debaters, new DebaterComparator());
		Collections.reverse(debaters);
		int i = 0;
		for (int j = 0; j < debaters.size(); j++) {
			if (j == 0 || (j > 0 && debaters.get(j).getScore() != debaters.get(j - 1).getScore()))
				i++;
			System.out.println(i + ". " + debaters.get(j));
		}
	}

}
