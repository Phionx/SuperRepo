/*
Shantanu Jha
APCS1 pd5
HW45--Come Together
2015-12-09
*/

//skeleton file for class Binary

public class Binary implements Comparable{
    public int numerator;
    public int denominator = 1;
    private int _decNum;
    public String _binNum;


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Binary() { 
	/****** YOUR IMPLEMENTATION HURRR ******/   
	numerator = _decNum = 0;
	_binNum = "0";
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Binary( int n ) {
	/****** YOUR IMPLEMENTATION HURRR ******/   
	numerator = _decNum = n;
	_binNum = decToBin(n);
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _binNum to input, _decNum to decimal equiv
      =====================================*/
    public Binary( String s ) {
	_binNum = s;
	numerator = _decNum = binToDec(s);
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	/****** YOUR IMPLEMENTATION HURRR ******/   
	return _binNum;
    }


    /*=====================================
      String decToBin(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of bits
      eg  decToBin(0) -> "0"
      decToBin(1) -> "1"
      decToBin(2) -> "10"
      decToBin(3) -> "11"
      decToBin(14) -> "1110"
      =====================================*/
    public static String decToBin( int n ) {
	/****** YOUR IMPLEMENTATION HURRR ******/   
	String ans = "";
	int temp = 0;
	while(n > 0){
		temp =  n%2;
		n = n/2;
		ans = "" + temp + ans;
	}
	return ans;
    }


    /*=====================================
      String decToBinR(int) -- converts base-10 input to binary, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToBinR(0) -> "0"
      decToBinR(1) -> "1"
      decToBinR(2) -> "10"
      decToBinR(3) -> "11"
      decToBinR(14) -> "1110"
      =====================================*/
    public static String decToBinR( int n ) { 
	/****** YOUR IMPLEMENTATION HURRR ******/   
	if(n==0) return "";
	return decToBinR(n/2) + n%2; 
    }


    /*=====================================
      String binToDec(String) -- converts base-10 input to binary
      pre:  s represents non-negative binary number
      post: returns String of bits
      eg  
      binToDec("0") -> 0
      binToDec("1") -> 1
      binToDec("10") -> 2
      binToDec("11") -> 3
      binToDec("1110") -> 14
      =====================================*/
    public static int binToDec( String s ) {
	/****** YOUR IMPLEMENTATION HURRR ******/   
    	int temp = Integer.parseInt(s);
	int n = 0;
	int ans = 0;
	while(temp > 0){
		ans += (temp%10)*Math.pow(2,n);
		temp = temp/10;
		n += 1;
	}
	return ans;
    }


    /*=====================================
      String binToDecR(String) -- converts base-10 input to binary, recursively
      pre:  s represents non-negative binary number
      post: returns String of bits
      eg  
      binToDecR("0") -> 0
      binToDecR("1") -> 1
      binToDecR("10") -> 2
      binToDecR("11") -> 3
      binToDecR("1110") -> 14
      =====================================*/
    public static int binToDecR( String s ) { 
	/****** YOUR IMPLEMENTATION HURRR ******/   
	int temp = Integer.parseInt(s);
	if(temp == 0) return 0;
	return 2*binToDecR("" + temp/10) + (temp)%10;
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) { 
	/****** YOUR IMPLEMENTATION HURRR ******/   
	return (compareTo(other) == 0);
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Binary objects is greater
      pre:  other is instance of class Binary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
	/****** YOUR IMPLEMENTATION HURRR ******/ 
    double numOther = 0; //numerator of other
    double denOther = 1; //denominator of other
    if(other instanceof Binary){
        Binary temp;
        temp = (Binary)other;
        numOther = temp.numerator;
    } else if(other instanceof Hexadecimal){
        Hexadecimal temp;
        temp = (Hexadecimal)other;
        numOther = temp.numerator;
    } else if (other instanceof Rational){
        Rational temp;
        temp = (Rational)other;
        numOther = temp.numerator;
        denOther = temp.denominator;
    } else {
        throw new ClassCastException("Input is not valid. Please enter either a Binary, Hexadecimal, or Rational number.");
    }
    
    if(numerator*denOther > numOther*denominator){
        return 1;
    } else if (numerator*denOther < numOther*denominator){
        return -1;
    } else {
        return 0;
    }
    }


    //main method for testing
    public static void main( String[] args ) throws NullPointerException {

	System.out.println();
	System.out.println( "Testing ..." );

	Binary b1 = new Binary(5);
	Binary b2 = new Binary(5);
	Binary b3 = b1;
	Binary b4 = new Binary(7);

	System.out.println( b1 );
	System.out.println( b2 );
	System.out.println( b3 );       
	System.out.println( b4 );       

	System.out.println( "\n==..." );
	System.out.println( b1 == b2 ); //should be false
	System.out.println( b1 == b3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( b1.equals(b2) ); //should be true
	System.out.println( b1.equals(b3) ); //should be true
	System.out.println( b3.equals(b1) ); //should be true
	System.out.println( b4.equals(b2) ); //should be false
	System.out.println( b1.equals(b4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( b1.compareTo(b2) ); //should be 0
	System.out.println( b1.compareTo(b3) ); //should be 0
	System.out.println( b1.compareTo(b4) ); //should be neg
	System.out.println( b4.compareTo(b1) ); //should be pos
    }//end main()

} //end class
