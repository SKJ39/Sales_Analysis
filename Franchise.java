package ec2;

public class Franchise {
	private Store stores[];				//Containment (arrays of (object) arrays)
	
	public Franchise() {
		//Default Constructor
	}
	
	public Franchise(int num) {
		stores = new Store[num];
	}

	public Store getStores(int i) {
		return stores[i];
	}

	public void setStores(Store stores, int i) {
		this.stores[i] = stores;
	}
	public int numberofstores()
	{
		return stores.length;
	}
	
	public void calc() {
		for (int i = 0; i < stores.length; i++ ) {
			stores[i].analyzeresults();
		}
	}
	
	public void printNum() {
		System.out.printf("Number of stores: %d\n", stores.length);
	}
	
	public void printStore(int x, int op) {
		stores[x].print(op);
	}
	
}
