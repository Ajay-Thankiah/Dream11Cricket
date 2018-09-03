package structures;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainClass {
	public static ArrayList<PlayerClass> players = new ArrayList<PlayerClass>();
	public static void main(String[] args) throws IOException {
		MainClass mainClass = new MainClass();
		
		//kohli, root,  - batsman
		//anderson, bumrah - bowler
		
		players.add(new PlayerClass("Bairstow", "Eng", 9.5, "keeper"));players.add(new PlayerClass("Pant", "Ind", 8.0, "keeper"));
		
		//kohli and root
		//players.add(new PlayerClass("Kohli", "Ind", 10.5, "batsman"));players.add(new PlayerClass("Root", "Eng", 10.0, "batsman"));
		players.add(new PlayerClass("Cook", "Eng", 9.5, "batsman"));players.add(new PlayerClass("Rahul", "Ind", 9.0, "batsman"));
		players.add(new PlayerClass("Rahane", "Ind", 9.0, "batsman"));players.add(new PlayerClass("Pujara", "Ind", 9.0, "batsman"));
		players.add(new PlayerClass("Jennings", "Eng", 8.5, "batsman"));players.add(new PlayerClass("Butler", "Eng", 8.5, "batsman"));
		players.add(new PlayerClass("Dhawan", "Ind", 8.5, "batsman"));players.add(new PlayerClass("Pope", "Eng", 8.0, "batsman"));
		
		players.add(new PlayerClass("Stokes", "Eng", 9.5, "allRounder"));players.add(new PlayerClass("Woakes", "Eng", 9.0, "allRounder"));
		players.add(new PlayerClass("Ashwin", "Ind", 9.0, "allRounder"));players.add(new PlayerClass("Pandya", "Ind", 8.5, "allRounder"));
		
		//anderson and bumrah
		//players.add(new PlayerClass("Anderson", "Eng", 9.0, "bowler"));players.add(new PlayerClass("Bumrah", "Ind", 9.0, "bowler"));
		players.add(new PlayerClass("Rashid", "Eng", 8.5, "bowler"));players.add(new PlayerClass("Broad", "Eng", 8.5, "bowler"));
		players.add(new PlayerClass("Sharma", "Ind", 8.5, "bowler"));players.add(new PlayerClass("Shami", "Ind", 8.0, "bowler"));
		
		/*players.add(10.5);players.add(10.0);players.add(9.5);players.add(9.0);players.add(9.0);players.add(9.0);players.add(8.5);players.add(8.5);players.add(8.5);players.add(8.0);
		players.add(9.5);players.add(9.0);players.add(9.0);players.add(8.5);
		players.add(9.0);players.add(9.0);players.add(8.5);players.add(8.5);players.add(8.0);*/
		ArrayList<ArrayList<PlayerClass>> result = mainClass.combine(players.size(), 7);
		Double total = 0.0;int count = 0;
		FileWriter fWriter = new FileWriter(new File("C:\\CSCI course docs\\CSCI Semester 4\\teams.txt"));
		for(ArrayList<PlayerClass> arrayList : result) {
			/*for(PlayerClass val : arrayList) {
				System.out.print(val+" ");
				//if conditions
				
				
				
				//total += val;
			}*/
			
			if(isValidTeam(arrayList)) {
				for(PlayerClass player : arrayList) {
					fWriter.write(player.name + ", ");
					//System.out.print(player.name + ", ");
					//if(player.name.equalsIgnoreCase("Cook")) System.out.print(player.name + ", "); 
				}
				fWriter.write(" Kohli, Root, Anderson, Bumrah\r\n");
				count += 1;
			}
			/*System.out.println();
			if(total < 100) count++;
			total = 0.0;*/
		}
		fWriter.write("Count is "+ count);
		fWriter.close();
		System.out.println(count);
	}
	
	private static boolean isValidTeam(ArrayList<PlayerClass> arrayList) {
		// TODO Auto-generated method stub
		boolean isKeeperFilled = false;
		boolean isBowlerFilled = false;
		boolean isBatsmanFilled = false;
		boolean isAllRounderFilled = false;
		int keeperCount = 0;
		int bowlerCount = 0;
		int batsmanCount = 0;
		int allRounderCount = 0;
		int country1Count = 0;
		int country2Count = 0;
		double total = 0;
		for(PlayerClass player : arrayList) {
			String role = player.role;
			String team = player.team;
			double cost = player.cost;
			total += cost;
			if(team.equalsIgnoreCase("Ind")) country1Count++;
			if(team.equalsIgnoreCase("Eng")) country2Count++;
			if(role.equals("keeper")) {
				if (isKeeperFilled) {
					return false;
				}
				else{
					keeperCount++;
					isKeeperFilled = true;
				}
			}
			
			if(role.equals("bowler")) {
				if (isBowlerFilled) return false;
				else {
					bowlerCount++;
					if(bowlerCount == 3) {
						isBowlerFilled = true;
					}
				}
			}
			
			if(role.equals("batsman")) {
				if (isBatsmanFilled) return false;
				else {
					batsmanCount++;
					if(batsmanCount == 3) {
						isBatsmanFilled = true;
					}
				}
			}
			
			if(role.equals("allRounder")) {
				if (isAllRounderFilled) return false;
				else {
					allRounderCount++;
					if(allRounderCount == 3) {
						isAllRounderFilled = true;
					}
				}
			}
		}
		//if(keeperCount < 1 || bowlerCount < 3 || batsmanCount < 3 || allRounderCount < 1 || country1Count > 7 || country2Count > 7) {
		if(keeperCount < 1 || bowlerCount < 1 || batsmanCount < 1 || allRounderCount < 1 || country1Count > 5 || country2Count > 5 || total > 61.5) {
			return false;
		}
		return true;
	}

	private static class PlayerClass{
		public String name;
		public String team;
		public Double cost;
		public String role;
		
		public PlayerClass(String name, String team, Double cost, String role) {
			this.name = name;
			this.team = team;
			this.cost = cost;
			this.role = role;
		}
	}
	
	public ArrayList<ArrayList<PlayerClass>> combine(int n, int k) {
		ArrayList<ArrayList<PlayerClass>> result = new ArrayList<ArrayList<PlayerClass>>();
	 
		if (n <= 0 || n < k)
			return result;
	 
		ArrayList<PlayerClass> item = new ArrayList<PlayerClass>();
		dfs(n, k, 0, item, result); // because it need to begin from 1
	 
		return result;
	}
	 
	private void dfs(int n, int k, int start, ArrayList<PlayerClass> item,
			ArrayList<ArrayList<PlayerClass>> res) {
		if (item.size() == k) {
			res.add(new ArrayList<PlayerClass>(item));
			return;
		}
	 
		//for(Double a : players) {
		for(int i=start;i<players.size();i++) {
			item.add(players.get(i));
			dfs(n, k, i+1, item, res);
			item.remove(item.size() - 1);
		}
		
		/*for (int i = start; i <= n; i++) {
			item.add(i);
			dfs(n, k, i + 1, item, res);
			item.remove(item.size() - 1);
		}*/
	}
}
