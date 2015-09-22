/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forloopstoaccumulate;

import static java.lang.Integer.signum;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.lang.Integer;

/**
 *
 * @author DSTIGANT
 */
public class ForLoopsToAccumulate
{


    public static void main(String[] args)
    {
//        testAddRange();
//        testAlternatingSumRange();
//        testSumOfSquaresRange();
//        testFactorial();
        testPower();
//        testCountPrimesInRange();
//        testAddPrimesInRange();
//        testReverseString();
//        testAltCap();
//        testRangeToString();
//        testGetVowels();
//        testCountNonVowels();
//        testAllVowels();
//        testPrimeGap();
//        testProductRange();
    }

    // ********************************************************
    // Number accumulators: sums and products over a range
    // ********************************************************

    // addRange
    // consumes two ints, A and B, which give the lower and upper bounds of the range
    // returns the sum of all the ints between A and B inclusive
    // for example, addRange( 5, 10 ) ==> 5 + 6 + 7 + 8 + 9 + 10 = 45
    public static int addRange( int A, int B )
    {
        return (A <= B) ? IntStream.rangeClosed(A, B).sum() : IntStream.rangeClosed(B, A).map( a -> -a).sum();
        
    }

    public static void testAddRange()
    {
        System.out.println( "addRange( 5, 10 ) ==> " + addRange(5, 10) );
        System.out.println( "addRange( 10, 5 ) ==> " + addRange( 10, 5) );
        System.out.println( "addRange( 10, 10) ==> " + addRange( 10, 10) );
    }

    // alternatingSumRange
    // consumes two ints A and B
    // returns an alternating sum of the integers between A and B, inclusive
    // example: alternatingSumRange( 5, 10 ) ==> 5 - 6 + 7 - 8 + 9 - 10 = -3
    // example: alternatingSumRange( 5, 11 ) ==> 5 - 6 + 7 - 8 + 9 - 10 + 11 = 8
    public static int alternatingSumRange( int A, int B )
    {
//        for (int i = 0; i <=B-A; i++)
//            sum += (i%2 == 0) ? A+i : -A-i;
        return (A <= B) ? IntStream
                .iterate(A, n -> (Integer.signum(n) == -1) ? -n+1 : -n-1)
                .limit(B-A).sum() 
                : 0;
    }

    public static void testAlternatingSumRange()
    {
        System.out.println( "alternatingSumRange( 5, 10 ) ==> " + alternatingSumRange( 5, 10) );
        System.out.println( "alternatingSumRange( 5, 11 ) ==> " + alternatingSumRange( 5, 11) );
        System.out.println( "alternatingSumRange( 5, 5 ) ==> " + alternatingSumRange( 5, 5) );
        System.out.println( "alternatingSumRange( 10, 5 ) ==> " + alternatingSumRange( 10, 5 ) );
    }

    // sumOfSquaresRang    // consumes two ints A and B
    // returns the sum of the squares of the numbers between A and B, inclusive
    // example: sumOfSquaresRange( 5, 10 ) ==> 5^2 + 6^2 + 7^2 + 8^2 + 9^2 + 10^2 = 355
    public static int sumOfSquaresRange( int A, int B )
    {
        return (Integer.signum(A) == 1 && Integer.signum(B) == 1 && A <=B) ? IntStream.rangeClosed(A, B).map(a -> a*a).sum() : 0;
    }

    public static void testSumOfSquaresRange()
    {
        System.out.println( "sumOfSquaresRange( 5, 10 ) ==> " + sumOfSquaresRange( 5, 10) );
        System.out.println( "sumOfSquaresRange( 10, 5 ) ==> " + sumOfSquaresRange( 10, 5) );
        System.out.println( "sumOfSquaresRange( 5, 5 ) ==> " + sumOfSquaresRange( 5, 5 ) );
    }

    // factorial
    // consumes one int n
    // returns n! = n * (n-1) * (n-2) * . . . * 1
    // for example: factorial(5) => 120
    // also, factorial( 0 ) ==> 1
    public static int factorial( int n )
    {
        return IntStream.iterate(n, a -> a-1).limit(n).reduce(1, (v1, v2) -> v1*v2);
    }

    // add some test cases for factorial here.  Make sure you test a good range of values
    public static void testFactorial()
    {
        System.out.println( "factorial(5) ==> " + factorial( 5) );
        System.out.println( "factorial(10) ==> " + factorial( 10) );
    }

    // power
    // consumes a doubles, A and and int, B
    // returns A^B
    // example: power( 3.0, 5 ) => 243.0
    // example: power( 3.0, 0 ) => 1.0
    // example: power( 3.0, -2 ) => 0.111111
    public static double power( double A, int B )
    {
        return 0.0;
    }

    public static double agm(double x, double y, double errorMargin) {
        double a_n = (x + y)/2.0;
        double g_n = babylonianSquareRoot(x*y, errorMargin);
        while ( a_n - g_n > errorMargin) {
            a_n = (a_n + g_n) /2.0;
            g_n = babylonianSquareRoot(a_n * g_n, errorMargin);
        }
        return a_n;
    }
    
    public static double babylonianSquareRoot(double S, double accuracy) {
        if ( S < 0) {
            System.out.println("Cannot square root negative values.");
            System.exit(0);
        }
        double x = S;
        double e = accuracy;
        for (double y = 1; x - y > e; x = (x + y)/2 ) y = S/x;
        return x;
    }
    public static void testBabylonianSquareRoot()
    {
        System.out.println("sqrt 2 = " +babylonianSquareRoot(2, 0.00000001));
    }
    // add some test cases for power here.  Make sure you test a good range of inputs
    public static void testPower()
    {
        System.out.println(
//                "power( 3.0, 5 ) => 243.0 = " + power( 3.0, 5) 
//                + "\npower( 3.0, 0 ) => 1.0 = " + power(3.0, 0) 
                 "\npower( 3.0, -2) => 0.111111 = " + power(3.0, -2));
    }

    // isPrime
    // consumes an int, n
    // returns true if n is a prime number, false otherwise
    public static boolean isPrime( int n )
    {
        for ( int i = 2; i <= Math.sqrt(n); i++ )
        {
            if ( n % i == 0 )
            {
                return false;
            }
        }

        return true;
    }

    // countPrimesInRange
    // consumes two ints, A and B,
    // returns the number of primes between A and B inclusive
    // for example, countPrimesInRange( 5, 10 ) ==> 2 (5 and 7)
    public static int countPrimesInRange( int A, int B )
    {
        return 0;
    }

    // add some test cases here
    public static void testCountPrimesInRange()
    {

    }

    // addPrimesInRange
    // consumes to ints, A and B,
    // returns the sum of the primes between A and B inclusive
    // for example: addPrimesInRange( 5, 10 ) ==> 12 (5 + 7)
    public static int addPrimesInRange( int A, int B )
    {
        return 0;
    }

    // add some test cases here
    public static void testAddPrimesInRange()
    {

    }

    // ********************************************************
    // String accumulators: building new Strings
    // ********************************************************

    // reverseString
    // consumes a String, s
    // returns a new String which consists of the characters of s in reverse
    // example: reverseString( "David Stigant" ) ==> "tnagitS divaD"
    public static String reverseString( String s )
    {
        return "";
    }

    // add some test cases here
    public static void testReverseString()
    {

    }

    // altCap
    // consumes a String, s
    // returns a new String which consists of the same characters as s but with every other character capitalized and the other
    // characters lowercase.
    // example: altCap( "Dave Stigant" ) ==> "DaVe sTiGaNt"
    public static String altCap( String s )
    {
        return "";
    }

    // add some test cases here
    public static void testAltCap()
    {

    }

    // rangeToString
    // consumes two ints, A and B
    // returns a String which is all the integers in that range, including A and B
    // example: rangeToString( 5, 10 ) ==> "5 6 7 8 9 10"
    public static String rangeToString( int A, int B)
    {
        return "";
    }

    // add some test cases here
    public static void testRangeToString()
    {

    }

    // isVowel
    // consumes a char, c
    // returns true if c is a vowel ('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o' or 'u' )
    public static boolean isVowel( char c )
    {
        return false;
    }

    // getVowels
    // consumes a String, s
    // returns a new String of all the vowels in s
    // example: getVowels( "Dave Stigant" ) ==> "aeia"
    public static String getVowels( String s )
    {
        return "";
    }

    // add some test cases here
    public static void testGetVowels()
    {

    }

    // countNonVowels
    // consumes a String, s
    // returns a count of all the non vowels in s
    // example: countNonVowels( "David Stigant" ) ==> 9
    public static int countNonVowels( String s )
    {
        return 0;
    }

    // add some test cases here
    public static void testCountNonVowels()
    {

    }

    // ********************************************************
    // Boolean accumulators: when to return early and when not to
    // ********************************************************

    // allVowels
    // consumes a String, s
    // returns true if all the characters in s are vowels
    // example: allVowels( "Dave Stigant" ) ==> false
    // example: allVowels( "aooooeeee" ) ==> true
    public static boolean allVowels( String s )
    {
        return false;
    }

    // add some test cases here
    public static void testAllVowels()
    {

    }

    // primeGap
    // consumes two ints A and B
    // returns true if A and B are prime but none of the integers between them are prime
    // example: primeGap( 5, 11 ) ==> false (since 7 is prime and between 5 and 11
    // example: primeGap( 13, 15 ) ==> false (since 15 is not prime)
    // example: primeGap( 15, 17 ) ==> false (since 15 is not prime)
    // example: primeGap( 7, 11 ) ==> true (since 7 and 11 are prime and the integers between them: 8, 9, 10 are not)
    public static boolean primeGap( int A, int B )
    {
        return false;
    }

    // add some test cases here
    public static void testPrimeGap()
    {

    }

    // productRange
    // consumes two ints A and B
    // returns the product of all the integers between A and B inclusive
    // example: productRange( 5, 10 ) ==> 151200 (5*6*7*8*9*10)
    // example: productRange( -5, 7 ) ==> 0
    // note: it may be possible in some situations to return early
    public static int productRange( int A, int B )
    {
        return 0;
    }

    // add some test cases here
    public static void testProductRange()
    {

    }
}
