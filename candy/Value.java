package candy;

public class Value {
	
	private int proteins;
	private int fats;
	private int carbohydrates;
	
	public Value() {}

	public Value(int proteins, int fats, int carbohydrates) {
		this.proteins = proteins;
		this.fats = fats;
		this.carbohydrates = carbohydrates;
	}

	public int getProteins() {
		return proteins;
	}

	public void setProteins(int proteins) {
		this.proteins = proteins;
	}

	public int getFats() {
		return fats;
	}

	public void setFats(int fats) {
		this.fats = fats;
	}

	public int getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(int carbohydrates) {
		this.carbohydrates = carbohydrates;
	};
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\t\tProteins: " + this.proteins + "\n");
		sb.append("\t\tFats: " + this.fats + "\n");
		sb.append("\t\tCarbohydrates: " + this.carbohydrates + "\n");
		
		return sb.toString();
	}
		
	
}
