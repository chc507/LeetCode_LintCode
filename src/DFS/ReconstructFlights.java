package DFS;

import java.util.*;

public class ReconstructFlights {
    ReconstructFlights(){};
    public List<String> findItinerary(String[][] tickets) {
        List<String> path = new ArrayList<>();
        if (tickets == null || tickets.length == 0) {
            return path;
        }

        Map<String, PriorityQueue<String>> map = new HashMap<>();
        //construct directed graph
        for(String[] ticket : tickets) {
            String depart = ticket[0];
            String arrival = ticket[1];
            if (!map.containsKey(depart)) {
                map.put(depart, new PriorityQueue<String>());
            }

            map.get(depart).add(arrival);
        }

        helper(map, path, "JFK");
        return path;
    }

    //dfs
    private void helper(Map<String, PriorityQueue<String>> map, List<String>path, String depart) {
        //get the arrivals of the departutre
        //traverse all the arrivals
        PriorityQueue<String> arrivals = map.get(depart);
        while(arrivals != null && !arrivals.isEmpty()) {
            String arrival = arrivals.poll();
            helper(map, path, arrival);
        }
        //once all the neighbor are visited, add to the path
        path.add(depart);
    }
}
