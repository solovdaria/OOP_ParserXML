package candy;

import java.util.ArrayList;
import java.util.List;

public class CandyCollection {
	
	private List<Candy> candyList;
	
	public CandyCollection() {
		this.candyList = new ArrayList<Candy>();
	}
	
	public void add(Candy candy) {
		candyList.add(candy);
	}

	public List<Candy> getCandyList() {
		return candyList;
	}

	public void setCandyList(List<Candy> candyList) {
		this.candyList = candyList;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		
		int k = 1;
		for (Candy candy: candyList) {
			sb.append(k++ + ". " + candy.toString() + "\n\n\n");
		}
		
		return sb.toString();
	}
}
