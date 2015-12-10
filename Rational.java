/*
Shantanu Jha
APCS1 pd5
HW45--Come Together
2015-12-09
*/

public class Rational implements Comparable {
public double numerator, denominator;
//Default is rational number 0/1
public Rational(){
this(0,1);
}
//Creates Rational object with numerator a and denominator b
public Rational(double a, double b){
numerator = a;
if(b == 0) b = 1;
denominator = b;
}

public String toString(){
return "" + numerator + "/" + denominator;
}

public double floatValue(){
if(denominator == 0) return 0;
return numerator/denominator;
}

public void  multiply(Rational foo){
numerator *= foo.numerator;
denominator *= foo.denominator;
}

public void divide(Rational foo){
if(foo.numerator == 0) {
System.out.println("Divide by zero error!");
}
else{ 
numerator *= foo.denominator;
denominator *= foo.numerator;
}}

//adds two rational numbers 
public void add (Rational r) {
		double c = this.denominator / r.denominator;
		r.numerator*=c;
		this.numerator+=r.numerator;
		this.reduce();
}
//subtracts two rational numbers
public void subtract (Rational r) {
		double c = this.denominator / r.denominator;
		r.numerator*=c;
		this.numerator-=r.numerator;
		this.reduce();
}

//Euler's Algorithm
//GCD-wrapper
public double gcd(){
return gcd(numerator, denominator);
}
//GCD helper - recursive
public static double gcd(double a, double b){
if (b == 0){
return a;
}
return gcd(b, a%b);
}

//Reduce To simplest terms function
public void reduce(){
double temp_gcd = gcd();
numerator /= temp_gcd;
denominator /= temp_gcd;
} 


/*
Takes a Rational as a parameter and compares it to the calling object
Returns 0 if the two numbers are equal
Returns a positive integer if the calling number is larger than the parameter
Returns a negative integer if the calling number is smaller than the parameter
*/
public int compareTo(Object other){
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

public boolean equals(Rational r){
return (compareTo(r) == 0);
}

public static void main(String [] args){
System.out.println("\tTest Cases");
Rational r = new Rational(2,3);
Rational s = new Rational(1,2);
Rational t = new Rational();
System.out.println("Rational Number r: " + r);
System.out.println("Rational Number s: " + s);
System.out.println("Rational Number t: " + t);
r.divide(s);
System.out.println("r/s = " + r + " ~= " + r.floatValue());
System.out.println("Rational Number r: " + r);
System.out.println("Rational Number s: " + s);
System.out.println("Rational Number t: " + t);
System.out.print("s/t = ");
s.divide(t);
s.multiply(t);
System.out.println("s/t = " + s + " ~= " + s.floatValue()); 

		
		Rational a = new Rational(4,8);
		Rational j = new Rational(1,4);

		System.out.println("numerator is:" + a.numerator + " denominator is:" + a.denominator);
		System.out.println("we are subtracring this fraction from it " + j.numerator + "/" + j.denominator);
		a.subtract(j);
		System.out.println("Now that we added, numerator is:" + a.numerator + " denominator is:" + a.denominator);
		
		Rational hub = new Rational (1,2);
		Rational flub = new Rational (2,3);
		Rational chub = new Rational (1,2);
		System.out.println(hub.equals(chub));
		System.out.println(hub.compareTo(flub));
		System.out.println(flub.compareTo(hub));
		System.out.println(hub.compareTo(chub));		
		   
}
} 
