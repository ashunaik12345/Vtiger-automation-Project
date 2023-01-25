package practice;

import java.util.Random;

public class RandomClassPracties {
	public static void main(String[] args) {
		Random rad=new Random();
		int random = rad.nextInt(1000);
		System.out.println(random);
	}
}
