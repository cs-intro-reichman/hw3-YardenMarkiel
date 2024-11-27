
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
		if ( ( y2 >= 0) ){ //y2 is positive
			for (int i = 0; i < y2; i++) {
				y1--;
			}
		} 
		else y1 = plus(y1, y2);
		return y1;
		}
		
		
	
	

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int y1 = x1;
		int y2 = x2;
		int y3 = x1;
		if ( ( y1 == 0 ) || ( y2 == 0 ) ) return  0;
		if ( ( y1 == 1) ) return  y2;
		if ( ( y2 == 1) ) return  y1;
		if ( ( y1 > 0) && ( y2 > 0 )){ 
			for ( int i = 0 ; i < y2 ; i++ ){
				y1 = plus(y1, y3);
			}
		}
			else if ( ( y2 < 0 ) ) {  // x2 is negative
				for ( int i = 0 ; i > y2 ; i -- ) {
					y1 = plus(y1, y3);
				}
				y1 = minus(0, y1);
			} else { //x1 is negative
				for ( int i = 0 ; i < y2 ; i++){
					y1 = minus(y1, y3);
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
		for ( int i = 0 ; i < n1 ; i++){
				y1 = times( y1, y3 );
			}
		return y1;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int y1 = x1;
		int y2 = x2;
		int negativeCheck = 1;
		int result = 0;
	
		if (y1 < 0 && y2 > 0 || y1 > 0 && y2 < 0) {
			negativeCheck = -1;
		}	
		y1 = y1 < 0 ? -y1 : y1;
		y2 = y2 < 0 ? -y2 : y2;
	
		while (y1 >= y2) {
			y1 = minus(y1, y2);
			result = plus(result, 1);
		}
	
		return times(result, negativeCheck);
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int divider = div(x1, x2);
		int Mod1 = times(divider, x2);
		return  minus(x1, Mod1);
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt( int x ) {
		int m = 2;
		if ( x == 0 ) return 0;
		if ( x == 1 ) return  1;
		while ( m != 0){
			m = times(m, m);
			if ( m == x) return m;
			else m++;
		}
		return 0;
	}
}
	


	
	


