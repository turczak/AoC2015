package solutions.day9;

import java.util.*;

public class Day9 {
    private final HashMap<String, HashMap<String, Integer>> graph;
    private final List<String> cities;
    private List<String> shortestRoute;
    private int shortestDistance;

    public Day9(List<String> inputList) {
        graph = new HashMap<>();
        shortestRoute = new ArrayList<>();
        for (String line :
                inputList) {
            readLine(line);
        }
        shortestDistance = Integer.MAX_VALUE;
        cities = new ArrayList<>(graph.keySet());
    }

    public void run(){
        for (String city : cities) {
            List<String> path = new ArrayList<>();
            Set<String> visited = new HashSet<>();
            path.add(city);
            visited.add(city);
            findShortestRoute(path, visited, 0);
        }
    }

    private void findShortestRoute(List<String> path, Set<String> visited, int distance){
        if(path.size() == cities.size()){
            if(distance < shortestDistance){
                shortestDistance = distance;
                shortestRoute = new ArrayList<>(path);
            }
            return;
        }
        String city = path.get(path.size() - 1);
        HashMap<String, Integer> neighbors = graph.get(city);
        if(neighbors == null) return;

        for (String neighbor :
                neighbors.keySet()){
            if(!visited.contains(neighbor)){
                path.add(neighbor);
                visited.add(neighbor);
                findShortestRoute(path,visited,distance+ neighbors.get(neighbor));
                path.remove(path.size() - 1);
                visited.remove(neighbor);
            }
        }
    }
    private void readLine(String line) {
        String[] split = line.split("\\s*(to|=)\\s*");
        graph.computeIfAbsent(split[0], k -> new HashMap<>())
                .put(split[1], Integer.parseInt(split[2]));
        graph.computeIfAbsent(split[1], k -> new HashMap<>())
                .put(split[0], Integer.parseInt(split[2]));
    }

    public String getShortestRoute() {
        return "Shortest route = " + shortestRoute +
                ", shortestDistance = " + shortestDistance +
                '}';
    }
}
