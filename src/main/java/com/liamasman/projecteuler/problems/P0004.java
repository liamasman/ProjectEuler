package com.liamasman.projecteuler.problems;

import com.liamasman.projecteuler.framework.annotation.Problem;
import com.liamasman.projecteuler.framework.annotation.ProblemCase;
import com.liamasman.projecteuler.framework.annotation.TestCase;
import com.liamasman.projecteuler.util.NumberUtil;

public class P0004 {

    @Problem(id=4)
    @ProblemCase(input = "3")
    @TestCase(input = "2", solution = "9009")
    public int largestPalindromeProduct(final String[] input) {
        final int productDigitsLength = Integer.parseInt(input[0]);
        final int maxValue = NumberUtil.POWERS_OF_TEN[productDigitsLength] - 1;
        final int minValue = NumberUtil.POWERS_OF_TEN[productDigitsLength - 1];

        int largestPalindrome = 0;
        for (int a = maxValue; a >= minValue; a--)
        {
            for (int b = a; b >= minValue; b--)
            {
                final int product = a *  b;
                if (product < largestPalindrome) {
                    break;
                }
                if (isPalindrome(product))
                {
                    largestPalindrome = product;
                }
            }
        }

        return largestPalindrome;
    }

    private boolean isPalindrome(final int number) {
        int reversed = 0;
        int original = number;
        while (original > 0) {
            reversed = reversed * 10 + original % 10;
            original /= 10;
        }
        return number == reversed;
    }
}
