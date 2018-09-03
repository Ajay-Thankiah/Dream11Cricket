package structures;

import java.util.Arrays;

public class Team {
	public Player [] keeper;
	public Player [] bowler;
	public Player [] batsman;
	public Player [] allRounder;
	public boolean isKeeperFilled = false;
	public boolean isBowlerFilled = false;
	public boolean isBatsmanFilled = false;
	public boolean isAllRounderFilled = false;
	
	public boolean addPlayer(Player player) {
		String role = player.role;
		String team = player.team;
		double cost = player.cost;
		if(role.equals("keeper")) {
			if (isKeeperFilled) return false;
		}
		
		if(role.equals("bowler")) {
			if (isBowlerFilled) return false;
		}
		
		if(role.equals("batsman")) {
			if (isBatsmanFilled) return false;
		}
		
		if(role.equals("allRounder")) {
			if (isAllRounderFilled) return false;
		}
		return true;
	}
	
	public Team() {
		keeper = new Player[1];
		bowler = new Player[5];
		batsman = new Player[5];
		allRounder = new Player[3];
	}
	
	public Team(Player[] keeper, Player[] bowler, Player[] batsman, Player[] allRounder) {
		super();
		this.keeper = keeper;
		this.bowler = bowler;
		this.batsman = batsman;
		this.allRounder = allRounder;
	}

	public Player[] getKeeper() {
		return keeper;
	}
	public void setKeeper(Player[] keeper) {
		this.keeper = keeper;
	}
	public Player[] getBowler() {
		return bowler;
	}
	public void setBowler(Player[] bowler) {
		this.bowler = bowler;
	}
	public Player[] getBatsman() {
		return batsman;
	}
	public void setBatsman(Player[] batsman) {
		this.batsman = batsman;
	}
	public Player[] getAllRounder() {
		return allRounder;
	}
	public void setAllRounder(Player[] allRounder) {
		this.allRounder = allRounder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(allRounder);
		result = prime * result + Arrays.hashCode(batsman);
		result = prime * result + Arrays.hashCode(bowler);
		result = prime * result + Arrays.hashCode(keeper);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (!Arrays.equals(allRounder, other.allRounder))
			return false;
		if (!Arrays.equals(batsman, other.batsman))
			return false;
		if (!Arrays.equals(bowler, other.bowler))
			return false;
		if (!Arrays.equals(keeper, other.keeper))
			return false;
		return true;
	}
	
	//keeper - bairstow, pant
	//batsman - kohli, root, cook, rahul, rahane, pujara, jennings, butler, dhawan, pope
	//allRounder - stokes, woakes, ashwin, pandya
	//bowler - anderson, bumrah, broad, sharma, shami
	
	//while(!complete) 
	//
	//addPlayer()
	
/*	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
		if (n <= 0 || n < k)
			return result;
	 
		ArrayList<Integer> item = new ArrayList<Integer>();
		dfs(n, k, 1, item, result); // because it need to begin from 1
	 
		return result;
	}
	 
	private void dfs(int n, int k, int start, ArrayList<Integer> item,
			ArrayList<ArrayList<Integer>> res) {
		if (item.size() == k) {
			res.add(new ArrayList<Integer>(item));
			return;
		}
	 
		for (int i = start; i <= n; i++) {
			item.add(i);
			dfs(n, k, i + 1, item, res);
			item.remove(item.size() - 1);
		}
	}*/
	
}
