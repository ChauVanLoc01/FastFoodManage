package constant;

public class Password {
	public static String DEFAULT_PASSWORD = "12345";

	public static String changeDefaultPassword(String newDefaultPassword) {
		DEFAULT_PASSWORD = newDefaultPassword;
		return DEFAULT_PASSWORD;
	}
}
