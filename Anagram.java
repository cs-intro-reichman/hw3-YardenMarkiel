/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String str1Check = preProcess(str1);
		String str2Check = preProcess(str2);
		int checker = 0;
		for (int i = 0; i < str2Check.length() ; i++){
			for (int j = 0; j < str1Check.length() ; j++){
				if (str2Check.charAt(i) == str1Check.charAt(j)){
					checker++;
				}
			}
			if (checker == 0){
				return  false;
			}
			checker = 0;
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String str1 = str;
		String newStr = "";
		for ( int i = 0; i < str1.length() ; i++){
			char x = str1.charAt(i);
			if ( (x >= 'A') && ( x <= 'Z') ){
				x = (char)(str1.charAt(i) + 32);
				newStr = newStr + x;
			}else if ( (x >= 'a') && (x <= 'z')) {
				newStr = newStr + x;
			}		
		}
		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String str1 = preProcess(str);
		String newStr = "";
		while (str1.length() != 0){
			double x = Math.random();
			x = 1 + ( x * str1.length());	
			newStr = newStr + str1.charAt((int)x);
			str1 = str1.substring((int) x) + str1.substring( (int)x + 1);
			}
		return newStr;
	}
	}

