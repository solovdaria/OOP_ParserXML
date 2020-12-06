package candy;

public class Ingridients {
	
	private int water;
	private int sugar;
	private int fructose;
	
	
	public Ingridients() {}


	public Ingridients(int water, int sugar, int fructose) {
		this.water = water;
		this.sugar = sugar;
		this.fructose = fructose;
	}


	public int getWater() {
		return water;
	}


	public void setWater(int water) {
		this.water = water;
	}


	public int getSugar() {
		return sugar;
	}


	public void setSugar(int sugar) {
		this.sugar = sugar;
	}


	public int getFructose() {
		return fructose;
	}


	public void setFructose(int fructose) {
		this.fructose = fructose;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		if (this.water != 0)sb.append("\t\tWater: " + this.water + "\n");
		if (this.sugar != 0)sb.append("\t\tSugar: " + this.sugar + "\n");
		if (this.fructose != 0) sb.append("\t\tFructose: " + this.fructose + "\n");
		
		return sb.toString();
	}
	
}
