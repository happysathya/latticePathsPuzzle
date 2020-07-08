package com.happysathya.codekata;

import java.math.BigInteger;

public class MathUtil {

  public static BigInteger binomial_coefficient(int length, int width) {
    return factorial(length + width).divide(factorial(length)).divide(factorial(width));
  }

  private static BigInteger factorial(int n) {
    return factorial2(n, BigInteger.ONE);
  }

  private static BigInteger factorial2(int n, BigInteger accumulator) {
    if (n == 0) return accumulator;
    else return factorial2(n - 1, accumulator.multiply(BigInteger.valueOf(n)));
  }
}
