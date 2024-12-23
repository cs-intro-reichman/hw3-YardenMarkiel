
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		double loan1 = loan;
		double rate1 =  rate / 100;
		int n1 = n;
		for( int i = 0 ; i < n1 ; i++){
			loan1 = loan1 - payment;
			loan1 = ( loan1 ) * (1 + rate1);
		}
		return loan1;
	}

	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		double loan1 = loan;
		double rate1 = rate;
		int n1 = n;
		double payment = loan1 / n1;
		double epsilon1 = epsilon;
		double checker = endBalance(loan1, rate1, n1, payment);
		while( (checker >= epsilon1)){ //the range between epsilon and 0
			payment += epsilon1;
			checker = endBalance(loan1, rate1, n1, payment);
			iterationCounter++;
		}
		return payment;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon)
	 {  
		double lowest = 1 ;  
		double highest = loan ; 
		double payment = (lowest + highest) / 2 ; 
		iterationCounter = 0;
		while ( (( highest - lowest ) > epsilon)) {  
			if ((endBalance(loan, rate, n, payment) * endBalance(loan, rate, n, lowest) < 0)) highest = payment;
			else lowest = payment;
			payment = ( highest + lowest ) / 2;
			iterationCounter++;
		}
		return payment;  
		}
    }

	
		
	
		
	