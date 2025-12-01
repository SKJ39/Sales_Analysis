package ec2;

public class Store {
	private float salesbyweek[][];
	private float[] totalsalesforweek = new float[5];
	private float avgsalesforweek[] = new float[5];
	private float totalSalesForAllWeek;
	private float averageweeklysales;
	private int weekHigh;
	private int weekLow;
	

	Store() {
		this.salesbyweek = new float[5][7];
	}

	// getter and setters
	public void setsaleforweekdayintersection(int week, int day, float sale) {
		this.salesbyweek[week][day] = sale;
	}

	public float [] getWeekSales(int week) {
		return this.salesbyweek[week];
	}
	
	public float getDaySales(int week, int day) {
		return this.salesbyweek[week][day];
	}
	
	// printer
	public void printdata() {
		for (float[] week : this.salesbyweek) {
			for (float day : week) {
				System.out.printf("$%.2f ", day);
			}
			System.out.printf("\n");
		}
	}
	
	//a. Total sales for each week
	public void totalWeekSales() {
		int index = 0;
		float sum;
		
		for (float[] week : this.salesbyweek) {
			sum = 0;
			for (float day : week) {
				sum += day;
			}
			this.totalsalesforweek[index] = sum;
			index++;
		}
	}
	
	//b. Average daily sales for each week
	public void avgDailySalesForWeek() {
		int index = 0;
		
		totalWeekSales();
		for (float week : this.totalsalesforweek) {
			this.avgsalesforweek[index] = week / 7;
			index++;
		}
	}
	
	//c. Total sales for all 5 weeks
	public void totalAllSales() {
		this.totalSalesForAllWeek = 0;
		
		totalWeekSales();
		for (float week : this.totalsalesforweek) {
			this.totalSalesForAllWeek += week;
		}
	}
	
	//d. Average weekly sales
	public void avgWeeklySales() {
		this.averageweeklysales = 0;
		
		avgDailySalesForWeek();
		for (float week : this.avgsalesforweek) {
			this.averageweeklysales += week;
		}
		
		this.averageweeklysales /= 5;
	}
	
	//e. The week with the highest amount in sales
	public void mostSalesWeek() {
		totalWeekSales();
		this.weekHigh = 0;
		float high = 0;
		
		for (int week = 0; week < this.totalsalesforweek.length; week++) {
			if (this.totalsalesforweek[week] > high) {
				this.weekHigh = week;
				high = this.totalsalesforweek[week];
			}
		}
	}
	
	//f. The week with the lowest amount in sales
	public void leastSalesWeek() {
		totalWeekSales();
		this.weekLow = 0;
		float low = this.totalsalesforweek[0];
		
		for (int week = 0; week < this.totalsalesforweek.length; week++) {
			if (this.totalsalesforweek[week] < low) {
				this.weekLow = week;
				low = this.totalsalesforweek[week];
			}
		}
	}
	
	//All analytical data
	public void analyzeresults() {
		totalWeekSales();
		avgDailySalesForWeek();
		totalAllSales();
		avgWeeklySales();
		mostSalesWeek();
		leastSalesWeek();
	}
	
	//Print analytical data
	public void print(int x) {
		switch (x) {
			case 1: printdata(); break;
			case 2: printa(); break;
			case 3: printb(); break;
			case 4: 
				System.out.printf("%-45s$%.2f\n", "Total sales for all 5 weeks:", this.totalSalesForAllWeek);
				break;
			case 5:
				System.out.printf("%-45s$%.2f\n", "Average weekly sales:", this.averageweeklysales);
				break;
			case 6: 
				System.out.printf("%-45s%s%d\n", "Week # with the highest amount in sales:", "Week ", this.weekHigh+1);
				break;
			case 7:
				System.out.printf("%-45s%s%d\n", "Week # with the lowest amount in sales:", "Week ", this.weekLow+1);
				break;
			case 8:
				printa();
				printb();
				System.out.printf("%-45s$%.2f\n", "Total sales for all 5 weeks:", this.totalSalesForAllWeek);
				System.out.printf("%-45s$%.2f\n", "Average weekly sales:", this.averageweeklysales);
				System.out.printf("%-45s%s%d\n", "Week # with the highest amount in sales:", "Week ", this.weekHigh+1);
				System.out.printf("%-45s%s%d\n", "Week # with the lowest amount in sales:", "Week ", this.weekLow+1);
				break;
			default:
				System.out.printf("Affirmative. Thank you for choosing our app! Have a nice day.");
				break;
		}
	}
	
	//Print total sales for each week
	public void printa() {
		System.out.printf("%-45s", "Total sales for each week:");
		for (float sales : this.totalsalesforweek) {
				System.out.printf("$%.2f\t", sales);
		}
		System.out.printf("\n");
	}
	
	//Print average daily sales for each week
	public void printb() {
		System.out.printf("%-45s", "Average daily sales for each week:");
		for (float sales : this.avgsalesforweek) {
			System.out.printf("$%.2f\t", sales);
		}
		System.out.printf("\n");
	}
}
