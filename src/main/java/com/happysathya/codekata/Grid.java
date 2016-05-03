package com.happysathya.codekata;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private final Coordinate maxCoordinate;
    private final List<Coordinate> visitedCoordinates;
    private final List<Journey> journeyList;

    public Grid(int size) {
        maxCoordinate = new Coordinate(size, size);
        visitedCoordinates = new ArrayList<>();
        journeyList = new ArrayList<>();
    }

    private boolean canGoRight(Coordinate given) {
        return given.getX() < maxCoordinate.getX();
    }

    private boolean canGoDown(Coordinate given) {
        return given.getY() < maxCoordinate.getY();
    }

    public List<Coordinate> giveNearbyRoutes(Coordinate given) {
        List<Coordinate> routes = new ArrayList<>();
        if (canGoRight(given)) {
            routes.add(new Coordinate(given.getX() + 1, given.getY()));
        }
        if (canGoDown(given)) {
            routes.add(new Coordinate(given.getX(), given.getY() + 1));
        }
        return routes;
    }

    public void addVisit(Coordinate given) {
        if (canVisitAgain(given)) {
            visitedCoordinates.add(given);
        }
    }

    public boolean canVisitAgain(Coordinate given) {
        return !visitedCoordinates.contains(given);
    }

    public void addJourney(Journey journey) {
        journeyList.add(journey);
    }

    public List<Journey> getJourneyList() {
        return journeyList;
    }
}
