package com.happysathya.codekata;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Journey {

    private List<Coordinate> paths;
    private final Grid grid;

    Journey(Grid grid) {
        this.grid = grid;
    }

    private Journey(List<Coordinate> paths, Grid grid) {
        this.paths = paths;
        this.grid = grid;
    }

    void startJourney() {
        if (!Optional.ofNullable(paths).isPresent()) {
            paths = new ArrayList<>();
            paths.add(new Coordinate(0, 0));
        }
        Coordinate lastCoordinate = paths.get(paths.size() - 1);
        List<Coordinate> nearbyRoutes = grid.giveNearbyRoutes(lastCoordinate);
        if (nearbyRoutes.isEmpty()) {
            grid.addJourney(this);
            return;
        }
        nearbyRoutes.forEach(coordinate -> {
            ArrayList<Coordinate> coordinates = new ArrayList<>();
            coordinates.addAll(paths);
            coordinates.add(coordinate);
            grid.addVisit(coordinate);
            new Journey(coordinates, grid).startJourney();
        });
    }

    List<Coordinate> getPaths() {
        return paths;
    }
}