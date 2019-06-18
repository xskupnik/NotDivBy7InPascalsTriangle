package com.dohnalovar;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
/**
 * Created by dohnalovar on 6/18/2019
 */
public class PascalTriangleCounter {
    /** row of Pascal's triangle, initially the 1st one */
    List<BigInteger> row;

    /** returns n, when n-th row is stored in row list */
    private int getRowNumber() {
        return row.size();
    }

    private void initializeRow() {
        row = new ArrayList<BigInteger>();
        row.add(BigInteger.valueOf(1));
    }

    @Override
    public String toString() {
        return "PascalTriangleCounter{" +
            "row=" + row +
            '}';
    }

    private int produceNextRowAndCount(Predicate<BigInteger> f) {

        int result = 0;
        BigInteger oldPrev = BigInteger.valueOf(1);
        int size = row.size();
        //System.out.println("row: " + (size+1));

        for (int i = 0; i <= size; i++) {
            // create i-th element of (row.size()+1)-th row
            BigInteger newCurrent;
            if (i == 0 ) {
                newCurrent = BigInteger.valueOf(1);
            } else if (i == row.size()) {
                row.add(i, BigInteger.valueOf(1));
                newCurrent = BigInteger.valueOf(1);
            } else {
                BigInteger oldCurrent = row.get(i);
                newCurrent = oldPrev.add(oldCurrent);
                oldPrev = oldCurrent;
                row.set(i, newCurrent);
            }

            // test f predicate and increment result in case true;
            if (f.test(newCurrent))
                result++;
        }
        return result;
    }

    /** returns count of members, which satisfies predicate in Pascal triangle with sizeOfTriangle rows */
    public int getCountPredicateInTriangle(int sizeOfTringle, Predicate<BigInteger> f) {

        initializeRow();
        //initialize result with the member of 1st row, i. e. f(1)
        int result = 0;
        if (f.test(BigInteger.valueOf(1)));
            result++;

        for (int i = 1; i < sizeOfTringle; i++) {
            result += produceNextRowAndCount(f);
        }

        return result;
    }


    private static PascalTriangleCounter ourInstance = new PascalTriangleCounter();

    public static PascalTriangleCounter getInstance() {
        return ourInstance;
    }

    private PascalTriangleCounter() {
    }
}
