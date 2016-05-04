package com.happysathya.codekata;

import java.util.List;

class JourneyWithoutPathList {

    private long pathCount = 0;
    private final Grid grid;

    JourneyWithoutPathList(Grid grid) {
        this.grid = grid;
    }

    long getPathCount() {
        startJourney(new Coordinate(0, 0));
        return pathCount;
    }

    private void startJourney(Coordinate coordinate) {
        List<Coordinate> nearbyRoutes = grid.giveNearbyRoutes(coordinate);
        if (nearbyRoutes.isEmpty()) {
            pathCount++;
            return;
        }
        nearbyRoutes.forEach(this::startJourney);
    }
}