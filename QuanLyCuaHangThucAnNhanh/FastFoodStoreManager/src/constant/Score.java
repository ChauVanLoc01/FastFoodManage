package constant;

public class Score {
	public static int TARGET_SILVER = 300;
	public static int TARGET_GOLD = 1000;
	public static int TARGET_DIAMOND = 3000;
	
	public static double STRATEGY_NEW = 0.05;
	public static double STRATEGY_SILVER = 0.06;
	public static double STRATEGY_GOLD = 0.08;
	public static double STRATEGY_DIAMOND = 0.1;

	private static String SILVER = "SILVER";
	private static String GOLD = "GOLD";
	private static String DIAMOND = "DIAMOND";

	public static void changeScore(String type, int targetScore) {
		if (type.equalsIgnoreCase(SILVER)) {
			TARGET_SILVER = targetScore;
		} else if (type.equalsIgnoreCase(GOLD)) {
			TARGET_GOLD = targetScore;
		} else if (type.equalsIgnoreCase(DIAMOND)) {
			TARGET_DIAMOND = targetScore;
		}
	}
}
