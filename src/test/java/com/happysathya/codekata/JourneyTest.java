package com.happysathya.codekata;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class JourneyTest {

    /*
    http://joaoff.com/2008/01/20/a-square-grid-path-problem/

    Binomial coefficient
    (2n n) = (2n)!/(n! * n!)
     */

    @Test
    public void test_factorial() {
        assertEquals(1, factorial(0));
        assertEquals(1, factorial(1));
        assertEquals(2, factorial(2));
        assertEquals(6, factorial(3));
        assertEquals(24, factorial(4));
        assertEquals(120, factorial(5));
    }

    @Test
    public void test_binomial_coefficient() {
        assertEquals(6, binomial_coefficient(2));
        assertEquals(252, binomial_coefficient(5));
    }

    @Test
    public void should_test_a_basic_grid_journey() {
        List<List<Coordinate>> pathList = new Journey(new Grid(1)).getPathList();

        assertEquals(binomial_coefficient(1), pathList.size());
        printVisualJourney(pathList);
    }

    @Test
    public void should_test_a_simple_grid_journey() {
        List<List<Coordinate>> pathList = new Journey(new Grid(2)).getPathList();

        assertEquals(binomial_coefficient(2), pathList.size());
        printVisualJourney(pathList);
    }

    @Test
    public void should_test_a_complex_grid_journey() {
        List<List<Coordinate>> pathList = new Journey(new Grid(5)).getPathList();

        assertEquals(binomial_coefficient(5), pathList.size());
        printVisualJourney(pathList);
    }

    private void printVisualJourney(List<List<Coordinate>> pathList) {
        System.out.println(pathList.size());
        pathList.forEach(paths -> {
            paths.forEach(coordinate -> {
                System.out.print("(" + coordinate.getX() + "," + coordinate.getY() + "), ");
            });
            System.out.println();
        });
        System.out.println();
    }

    private long binomial_coefficient(long n) {
        return (factorial(2 * n)) / (factorial(n) * factorial(n));
    }

    private long factorial(long n) {
        return n <= 1 ? 1 : n * factorial(n - 1);
    }
}
