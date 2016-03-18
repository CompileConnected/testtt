
public abstract class Vehicle {
	
	String vechicleCategory, nomorPolisi;
	int price, id;
	
	public Vehicle(int id, String vechicleCategory, String nomorPolisi) {
		this.id = id;
		this.vechicleCategory = vechicleCategory;
		this.nomorPolisi = nomorPolisi;
	}
	
	public Vehicle() {
		this(0, "", "");
	}

	public int getId() {
		return id;
	}

	public String getVechicleCategory() {
		return vechicleCategory;
	}

	public String getNomorPolisi() {
		return nomorPolisi;
	}
}
