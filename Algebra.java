
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int y1 = x1;
		int y2 = x2;
		if ( ( y1 >= 0) && ( y2 >= 0 )){
			for (int i = 0; i < y2; i++){
				y1++;
			}
		} else if ( ( y1 < 0) && ( y2 < 0) ){
			for (int i = 0; i > y2 ; i--) {
				y1--;
			}
		} else if ( (y1 >= 0) ){
			for (int i = 0; i > y2 ; i--) {
				y1--;
			}
		} else {
			for (int i = 0; i < y2; i++){
				y1++;
			}
		}
		return y1;
}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int y1 = x1;
		int y2 = x2;
		if ( ( y1 >= 0 ) && ( y2 >= 0)){
			for (int i = 0; i < y2; i++) {
				y1--;
			}
		} else if ( ( y1 >= 0) ){
			y1 = plus(y1, y2);
		} else {
			for (int i = 0; i < y2; i++) {
				y1--;
			}
		}
		return y1;
		}
		
	

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int y1 = x1;
		int y2 = x2;
		int y3 = x1;
		if ( ( y1 == 1) && ( y2 == 1 ) ){
			return  1;
		}
		if ( ( y1 == 1) ) return  y2;
		if ( ( y2 == 1) ) return  y1;
		if ( ( y1 > 1 ) && ( y2 > 1 ) ){
			for (int i = 0; i < y2; i++) {
				y1 = plus(y3, y1);
			}
		} else if ( ( y1 < 0 ) && ( y2 < 0 )){
			for (int i = 0; i < y2; i++) {
				y1 = plus(y3, y1);
			}
		} else {
			for (int i = 0; i < y2; i++) {
				y1 = plus(y3, y1);
				y1 = 0 - y1;
			}
		}
		return y1;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int y1 = x;
		int n1 = n;
		int y3 = y1;
		if ( n1 == 0 ) return  1;
		if ( n1 == 1 ) return  y1;
		if ( n1 > 1){
			for(int i = 1; i < n ; i++ ){
				y3 = times(y3, y1);
			}
		} 
		return y3;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int y1 = x1;
		int y2 = x2;
		int negativeCheck = -1;
		int result = 0;
		int checker = 1;
		if ( ( y1 == 0 ) ) return 0;
		if ( ( y2 == 1 ) ) return 1; 
		if ( ( y1 > 0 ) && ( y2 > 0 ) ) negativeCheck = 1;
		if ( ( y1 < 0 ) && ( y2 < 0 ) ) negativeCheck = 1;
		while ( result == 0){
			int y3 = times(y1, checker);
			if (y3 >= y2 ){
				result = checker;
			}else{
				checker++;
			}
		}
		result = times(result, negativeCheck);
		return result;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int y1 = x1;
		int y2 = x2;
		int result = 0;
		int checker = div(y1, y2);
		if ( y2 == 1) return 0;
		if ( y1 == 0) return 0;
		checker = times(checker, y1);
		if(checker != y2){
			result = minus(y2, checker);
		}
		return result;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt( int x ) {
		int y = x;
		int y2 = div(x, 2);
		int checker = times(y2, y2);
		int counter = 0;
		if (y == 1 || y==0){
			return y;
		}
		while( counter == 0){
			if (checker == y){
				return y2;
			}
			else{
				y2++;
				checker = times(y2, y2);
			}
		}
		return y2;

	}
}
	


	
	


