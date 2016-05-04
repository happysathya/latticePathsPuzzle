package com.happysathya.codekata;

import java.util.ArrayList;
import java.util.List;

class Journey {

    private PathAccumulator pathAccumulator;
    private final Grid grid;

    Journey(Grid grid) {
        this.grid = grid;
        this.pathAccumulator = new PathAccumulator();
    }

    List<List<Coordinate>> getPathList() {
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(new Coordinate(0, 0));
        startJourney(coordinates);
        return pathAccumulator.pathList;
    }

    private void startJourney(List<Coordinate> paths) {
        Coordinate lastCoordinate = paths.get(paths.size() - 1);
        List<Coordinate> nearbyRoutes = grid.giveNearbyRoutes(lastCoordinate);
        if (nearbyRoutes.isEmpty()) {
            pathAccumulator.addPaths(paths);
            return;
        }
        nearbyRoutes.forEach(coordinate -> {
            ArrayList<Coordinate> coordinates = new ArrayList<>();
            coordinates.addAll(paths);
            coordinates.add(coordinate);
            startJourney(coordinates);
        });
    }

    private static class PathAccumulator {
        private final List<List<Coordinate>> pathList = new ArrayList<>();

        void addPaths(List<Coordinate> paths) {
            pathList.add(paths);
        }
    }
}