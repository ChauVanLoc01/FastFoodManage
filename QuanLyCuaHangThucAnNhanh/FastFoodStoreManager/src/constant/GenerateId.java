package constant;

import java.util.Date;
import java.util.Random;

public class GenerateId {
	public static String generateId() {
		Random random = new Random();
		String s1 = CHARACTERS.substring(random.nextInt(CHARACTERS.length()));
		String s2 = CHARACTERS.substring(random.nextInt(CHARACTERS.length()));
		return new Date().toString() + s1 + s2;
	}

	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
}
