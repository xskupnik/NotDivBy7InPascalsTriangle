/**
 We can easily verify that none of the entries in the first seven rows of Pascal's triangle
 are divisible by 7:

         1
      1	   1
     1	 2	1
    1 3	   3 1
   1 4 	 6	4 1
  1	5  10 10 5 1
 1 6 15	20 15 6	1
 However, if we check the first one hundred rows, we will find that only 2361 of the 5050 entries
 are not divisible by 7.

 Find the number of entries which are not divisible by 7 in the first one billion (10^9) rows of Pascal's
 triangle.

 */
package com.dohnalovar;

import java.math.BigInteger;
import java.util.function.Predicate;

public class Main {

    public static final Predicate<BigInteger> notDivBy7 =
        (a) -> !(a.mod(BigInteger.valueOf(7)).equals(BigInteger.valueOf(0)));
    public static final Predicate<BigInteger> divBy7 =
        (a) -> a.mod(BigInteger.valueOf(7)).equals(BigInteger.valueOf(0));

    public static void main(String[] args) {
	// write your code here
        PascalTriangleCounter x = PascalTriangleCounter.getInstance();

        System.out.println("Count of 1's in 4-rows Pascal triangle: " +
            x.getCountPredicateInTriangle(4, (a) -> a.equals(BigInteger.valueOf(1))));
        System.out.println(x.toString());

        System.out.println("Count of members NOT divisible by 7 in 7-rows Pascal triangle: " +
            x.getCountPredicateInTriangle(7, notDivBy7));
        System.out.println(x.toString());


        //---------- 100

        System.out.println("Count of members NOT divisible by 7 in 100-rows Pascal triangle: " +
            x.getCountPredicateInTriangle(100, notDivBy7));
        System.out.println(x.toString());


        System.out.println("Count of members in 100-rows Pascal triangle: " +
            x.getCountPredicateInTriangle(100, (a) -> true));
        System.out.println(x.toString());

/*
        // it takes TOO LONG !!!

        // ---- 1 000 000 000
        System.out.println("Count of members NOT divisible by 7 in 1billion-rows Pascal triangle: " +
            x.getCountPredicateInTriangle(1000000000, notDivBy7));
        //System.out.println(x.toString());
*/
    }
}
