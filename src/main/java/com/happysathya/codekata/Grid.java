package com.happysathya.codekata;

import java.util.ArrayList;
import java.util.List;

class Grid {

    private final Coordinate maxCoordinate;

    Grid(int size) {
        maxCoordinate = new Coordinate(size, size);
    }

    private boolean canGoRight(Coordinate given) {
        return given.getX() < maxCoordinate.getX();
    }

    private boolean canGoDown(Coordinate given) {
        return given.getY() < maxCoordinate.getY();
    }

    List<Coordinate> giveNearbyRoutes(Coordinate given) {
        List<Coordinate> routes = new ArrayList<>();
        if (canGoRight(given)) {
            routes.add(new Coordinate(given.getX() + 1, given.getY()));
        }
        if (canGoDown(given)) {
            routes.add(new Coordinate(given.getX(), given.getY() + 1));
        }
        return routes;
    }

}
