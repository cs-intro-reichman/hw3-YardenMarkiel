public class Dd {
	public static void main(String[] args){
		String str1 = args[0];
		String newStr = "";
		int n = str1.length();
		while (str1.length() != 0){
			double x = Math.random();
			x = 1 + ( x * n);	
			newStr = newStr + str1.charAt((int)x);
			str1 = str1.substring((int) x) + str1.substring( (int)x + 1);
			}
		System.out.println(newStr);

	}
}



