// import java.io.*;

class Date{
	// public boolean b_year;
	// public int DayinM;
	// public boolean b_ValidDate;

	private int month;
	private int day;
	private int year;

	// Date Constructor I
	public Date(int month, int day, int year)	{
		if(isValidDate(month, day, year)){
			this.month = month;
			this.day = day;
			this.year = year;
		}
		else {
			System.out.println("The date is NOT Valid. This program will halt.");
			System.exit(0);
		}
	}

	// Date Constructor II
	public Date(String s){
		String[] str_date = s.split("/");
		this.month = Integer.parseInt(str_date[0]);
		this.day = Integer.parseInt(str_date[1]);
		this.year = Integer.parseInt(str_date[2]);
		// public Date(date[0], date[1], date[2]);
		if(isValidDate(month, day, year)){
			this.month = month;
			this.day = day;
			this.year = year;
		}
		else {
			System.out.println("The date is NOT Valid. This program will halt.");
			System.exit(0);
		}
	}

	// Date Constructor III
	public Date(){}


public static boolean isLeapYear(int year) {
    // boolean is return type
    if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
		// System.out.println("The year " + year + " is a Leap Year.");
        return true;
    }
    else {
		// System.out.println("The year " + year + " is NOT a Leap Year.");
        return false;
    }
}

public static int daysInMonth(int month, int year) {
if( (month == 1)||(month == 3)||(month == 5)||
		(month == 7)||(month == 8)||(month == 10)||(month == 12) ) {
    // System.out.println("There are 31 days in this month.");
    return 31;
}
else {
    if (month != 2) {
        // System.out.println("There are 30 days in this month.");
        return 30;
    }
    else {
        if (isLeapYear(year) == true) {
            // System.out.println("There are 29 days in this month.");
            return 29;
        }
        else {
			// System.out.println("There are 28 days in this month.");
        return 28;
    }
    }
}
}

public static boolean isValidDate(int month, int day, int year) {
	// boolean is return type
	if ( year >=1 && month >= 1 && month <= 12 && day >=1 && day <= daysInMonth(month, year)) {
		// System.out.println("The date is Valid.");
	    return true;
	}
	else {
		System.out.println("The date is NOT Valid. This program will halt.");
		return false;
	}
	}

public String toString() {
    return this.month + "/" + this.day + "/" + this.year;
    }



// int Date_d_month = 8;
// int Date_d_day = 1;
// int Date_d_year = 1995;
// // Still Confused with "Class" and "Main";
// // Here, just create a primitive/direct data example to achieve the function

public boolean isBefore(Date d) {
	if ( (this.year < d.year)||(this.year == d.year && this.month < d.month )
				||(this.year == d.year && this.month == d.month && this.day<d.day ))
	 {
		return true;

	} else {return false;}
}

public boolean isAfter(Date d) {
	if (!isBefore(d) && !(this.year == d.year && this.month == d.month && this.day == d.day ))
	{return true;}
	else {return false;}
}

public int dayInYear(int month, int day, int year){
	int num_date = 0 + day;

	for (int m = 1; m < month; m++) {
		num_date += daysInMonth(month, year);
	}
	return num_date;
}



public int difference(Date d){
    int dff;
	Date minD = new Date();
	Date maxD = new Date();
	if (isBefore(d))
	{dff = - ab_dff(this, d);}
	else if(this.year == d.year && this.month == d.month
				&& this.day == d.day ){
		dff = 0;}
	else {dff = ab_dff(d, this);}
	return dff;
}
	// 建立两个新的Date类变量，分别接受 较小值 和较大值（年月日）。
	// 后面建立一个mehtod 计算 天数差 的绝对值；其中只调用 新的变量；
	// 最后通过判断，确定天数值的正负。

	public int ab_dff(Date minD, Date maxD){
		int int_ab_dff = 0;
		for(int yy = minD.year; yy < maxD.year; yy ++){
			if (isLeapYear(yy) == true){
				int_ab_dff +=366;
			}else{int_ab_dff +=365;}
			// System.out.println("year"+ yy +"the int_ab_dff" + int_ab_dff);
		}
		int_ab_dff += dayInYear(maxD.month, maxD.day, maxD.year);
		int_ab_dff -= dayInYear(minD.month, minD.day, minD.year);
	return int_ab_dff;
	} // end ab_dff


// From LPJ

public int difference(Date d) {

	int difDay = 0;
	int numOfMonth = 12;

	int difYear = year - d.year;

	if (difYear >= 0){
		for(int i = 0; i < difYear; i++)
			for(int j = 1; j <= numOfMonth; j++)
				difDay = difDay + daysInMonth(j, d.year+i);

		difDay = difDay - dayInYear(d.month, d.day, d.year);
		difDay = difDay + dayInYear(this.month, this.day, this.year);
	}
	else{
		difDay = -d.difference(this);
	}

	return difDay;
	// return 0;                           // replace this line with your solution
}





// public static void main(String[] args) throws Exception{
// 	System.out.println("Please input the Month:");
// 	BufferedReader kb1 =
// 		new BufferedReader(new InputStreamReader(System.in));
// 	String str_month = kb1.readLine();
// 	int month1 = Integer.parseInt(str_month);
//
// 	System.out.println("Please input the Day:");
// 	BufferedReader kb2 =
// 		new BufferedReader(new InputStreamReader(System.in));
// 	String str_day = kb2.readLine();
// 	int day1 = Integer.parseInt(str_day);
//
//
// 	System.out.println("Please input the Year:");
// 	BufferedReader kb3 =
// 		new BufferedReader(new InputStreamReader(System.in));
// 	String str_year = kb3.readLine();
// 	int year1 = Integer.parseInt(str_year);
//
// 	System.out.println("The date is:" + month1 + "/" + day1 + "/" + year1);
//
// 	Date this_date = new Date(month1, day1, year1);
//
// 	// b_year = isLeapYear(year1);
// 	// DayinM = daysInMonth(month1, year1);
// 	// b_ValidDate = isValidDate(month1, day1, year1);
// 	// 在main函数里面调用
// }


public static void main(String[] argv) {
  System.out.println("\nTesting constructors.");
  Date d1 = new Date(1, 1, 1);
  System.out.println("Date should be 1/1/1: " + d1);
  d1 = new Date("2/4/2");
  System.out.println("Date should be 2/4/2: " + d1);
  d1 = new Date("2/29/2000");
  System.out.println("Date should be 2/29/2000: " + d1);
  d1 = new Date("2/29/1904");
  System.out.println("Date should be 2/29/1904: " + d1);

  d1 = new Date(12, 31, 1975);
  System.out.println("Date should be 12/31/1975: " + d1);
  Date d2 = new Date("1/1/1976");
  System.out.println("Date should be 1/1/1976: " + d2);
  Date d3 = new Date("1/2/1976");
  System.out.println("Date should be 1/2/1976: " + d3);

  Date d4 = new Date("2/27/1977");
  Date d5 = new Date("8/31/2110");

  /* I recommend you write code to test the isLeapYear function! */

  System.out.println("\nTesting before and after.");
  System.out.println(d2 + " after " + d1 + " should be true: " +
					 d2.isAfter(d1));
  System.out.println(d3 + " after " + d2 + " should be true: " +
					 d3.isAfter(d2));
  System.out.println(d1 + " after " + d1 + " should be false: " +
					 d1.isAfter(d1));
  System.out.println(d1 + " after " + d2 + " should be false: " +
					 d1.isAfter(d2));
  System.out.println(d2 + " after " + d3 + " should be false: " +
					 d2.isAfter(d3));

  System.out.println(d1 + " before " + d2 + " should be true: " +
					 d1.isBefore(d2));
  System.out.println(d2 + " before " + d3 + " should be true: " +
					 d2.isBefore(d3));
  System.out.println(d1 + " before " + d1 + " should be false: " +
					 d1.isBefore(d1));
  System.out.println(d2 + " before " + d1 + " should be false: " +
					 d2.isBefore(d1));
  System.out.println(d3 + " before " + d2 + " should be false: " +
					 d3.isBefore(d2));

  System.out.println("\nTesting difference.");
  System.out.println(d1 + " - " + d1  + " should be 0: " +
					 d1.difference(d1));
  System.out.println(d2 + " - " + d1  + " should be 1: " +
					 d2.difference(d1));
  System.out.println(d3 + " - " + d1  + " should be 2: " +
					 d3.difference(d1));
  System.out.println(d3 + " - " + d4  + " should be -422: " +
					 d3.difference(d4));
  System.out.println(d5 + " - " + d4  + " should be 48762: " +
					 d5.difference(d4));
}
}
