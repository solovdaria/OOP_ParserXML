package candy;

public class Candy implements Comparable {
	
	
	private String id;
	private String production;
	private String name;
	private int energy;
	private Type type;
	private Ingridients ingridients;
	private Value value;
	
	
	public Candy() {}
	
	public Candy(String id, String production, String name, int energy, Type type, Ingridients ingridients, Value value) {
		this.id = id;
		this.production = production;
		this.name = name;
		this.energy = energy;
		this.type = type;
		this.ingridients = ingridients;
		this.value = value;
	}

	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Ingridients getIngridients() {
		return ingridients;
	}

	public void setIngridients(Ingridients ingridients) {
		this.ingridients = ingridients;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.name + " [ID: " + this.id + "] \n");
		sb.append("\tProduction: " + this.production + "\n");
		sb.append("\tEnergy: " + this.energy + "\n");
		sb.append("\tType: " + this.type + "\n");
		sb.append("\tIngridients: \n" + this.ingridients.toString());
		sb.append("\tValue: \n" + this.value.toString());
		
		return sb.toString();
	}

	@Override
	public int compareTo(Object arg0) {
		Candy candy = (Candy) arg0;
		
		String left = this.id;
		String right = candy.getId();
		
		return left.compareTo(right);
	}
	
	
}
