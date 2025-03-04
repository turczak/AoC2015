package com.adventofcode.day09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day09 {
    private static final String SEPARATOR = "\\s*(to|=)\\s*";
    private final Map<String, HashMap<String, Integer>> graph = new HashMap<>();
    private List<String> cities;
    private List<String> resultRoute = new ArrayList<>();
    private int resultDistance = 0;

    public int getResultDistance(List<String> inputList, SearchType searchType) {
        inputList.forEach(line -> {
            String[] split = line.split(SEPARATOR);
            graph.computeIfAbsent(split[0], k -> new HashMap<>())
                    .put(split[1], Integer.parseInt(split[2]));
            graph.computeIfAbsent(split[1], k -> new HashMap<>())
                    .put(split[0], Integer.parseInt(split[2]));
        });
        this.cities = new ArrayList<>(graph.keySet());
        if (searchType.equals(SearchType.SHORTEST)) {
            resultDistance = Integer.MAX_VALUE;
        }
        for (String city : cities) {
            List<String> path = new ArrayList<>();
            Set<String> visited = new HashSet<>();
            path.add(city);
            visited.add(city);
            findRoute(path, visited, 0, searchType);
        }
        return resultDistance;
    }

    private void findRoute(List<String> path, Set<String> visited, int distance, SearchType searchType) {
        if (path.size() == cities.size()) {
            if (searchType.equals(SearchType.SHORTEST) && distance < resultDistance ||
                    searchType.equals(SearchType.LONGEST) && distance > resultDistance) {
                resultDistance = distance;
                resultRoute = new ArrayList<>(path);
            }
            return;
        }
        String city = path.getLast();
        Map<String, Integer> neighbors = graph.get(city);
        if (neighbors == null) {
            return;
        }

        for (String neighbor : neighbors.keySet()) {
            if (!visited.contains(neighbor)) {
                path.add(neighbor);
                visited.add(neighbor);
                findRoute(path, visited, distance + neighbors.get(neighbor), searchType);
                path.removeLast();
                visited.remove(neighbor);
            }
        }
    }

    public String getResultRoute(SearchType searchType) {
        if (searchType.equals(SearchType.SHORTEST)) {
            return String.format("Shortest route = %s, shortestDistance = %d",
                    resultRoute,
                    resultDistance
            );
        } else {
            return String.format("Longest route = %s, longestDistance = %d",
                    resultRoute,
                    resultDistance
            );
        }
    }
}
