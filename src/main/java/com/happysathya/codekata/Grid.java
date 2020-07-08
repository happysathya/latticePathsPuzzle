package com.happysathya.codekata;

public class Grid {

  private final int length;
  private final int width;

  public Grid(int length, int width) {
    this.length = length;
    this.width = width;
  }

  public long numberOfPaths() {
    return MathUtil.binomial_coefficient(length, width).longValueExact();
  }
}
