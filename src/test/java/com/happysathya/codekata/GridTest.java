package com.happysathya.codekata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GridTest {

  /*
  http://joaoff.com/2008/01/20/a-square-grid-path-problem/

  Binomial coefficient
  (m n) => (m+n)!/ (m! * n!)
   */

  @Test
  public void shouldCalculateNumberOfPossiblePathsInAGrid() {
    assertEquals(6L, new Grid(2, 2).numberOfPaths());
    assertEquals(126L, new Grid(5, 4).numberOfPaths());
    assertEquals(126L, new Grid(5, 4).numberOfPaths());
    assertEquals(137846528820L, new Grid(20, 20).numberOfPaths());
  }
}
