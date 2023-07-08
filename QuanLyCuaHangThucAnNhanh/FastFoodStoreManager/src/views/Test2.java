package views;

import java.util.Date;

public class Test2 {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.getYear() + 1900);
		System.out.println(date.getDate());
		System.out.println(date.getMonth() + 1);
	}

}
