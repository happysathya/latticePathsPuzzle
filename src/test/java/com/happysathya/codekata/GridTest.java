package com.happysathya.codekata;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GridTest {

    @Test
    public void should_test_grid_capabilities() {
        Grid size2Grid = new Grid(2);

        List<Coordinate> c00 = size2Grid.giveNearbyRoutes(new Coordinate(0, 0));
        assertEquals(2, c00.size());
        assertEquals(new Coordinate(1, 0), c00.get(0));
        assertEquals(new Coordinate(0, 1), c00.get(1));

        List<Coordinate> c01 = size2Grid.giveNearbyRoutes(new Coordinate(0, 1));
        assertEquals(2, c01.size());
        assertEquals(new Coordinate(1, 1), c01.get(0));
        assertEquals(new Coordinate(0, 2), c01.get(1));

        List<Coordinate> c02 = size2Grid.giveNearbyRoutes(new Coordinate(0, 2));
        assertEquals(1, c02.size());
        assertEquals(new Coordinate(1, 2), c02.get(0));

        List<Coordinate> c10 = size2Grid.giveNearbyRoutes(new Coordinate(1, 0));
        assertEquals(2, c10.size());
        assertEquals(new Coordinate(2, 0), c10.get(0));
        assertEquals(new Coordinate(1, 1), c10.get(1));

        List<Coordinate> c11 = size2Grid.giveNearbyRoutes(new Coordinate(1, 1));
        assertEquals(2, c11.size());
        assertEquals(new Coordinate(2, 1), c11.get(0));
        assertEquals(new Coordinate(1, 2), c11.get(1));

        List<Coordinate> c12 = size2Grid.giveNearbyRoutes(new Coordinate(1, 2));
        assertEquals(1, c12.size());
        assertEquals(new Coordinate(2, 2), c12.get(0));

        List<Coordinate> c20 = size2Grid.giveNearbyRoutes(new Coordinate(2, 0));
        assertEquals(1, c20.size());
        assertEquals(new Coordinate(2, 1), c20.get(0));

        List<Coordinate> c21 = size2Grid.giveNearbyRoutes(new Coordinate(2, 1));
        assertEquals(1, c21.size());
        assertEquals(new Coordinate(2, 2), c21.get(0));

        List<Coordinate> c22 = size2Grid.giveNearbyRoutes(new Coordinate(2, 2));
        assertEquals(0, c22.size());
    }
}
