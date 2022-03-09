class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preReq = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preReq.put(i, new ArrayList<>());
        }
        // Populate the preReq table to generate the
        // Adjecency list
        for (int i = 0; i < prerequisites.length; i++) {
            preReq.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            // if dfs returns false, no need to continue iterating
            if (!dfs(i, preReq, visited))
                return false;
        }
        return true;
        
    }
    
    private boolean dfs(int course,Map<Integer, List<Integer>> preReq, Set<Integer> visited) {
        // Checking for loops in the graph
        if (visited.contains(course)) {
            return false;
        }
        
        if (preReq.get(course).size() == 0) {
            return true;
        }
        
        visited.add(course);
        for (int reqs : preReq.get(course)) {
            if (!dfs(reqs, preReq, visited)) 
                return false;
        }
        
        // As all the node coming out of the course node is visited, we can remove it
        // and Update the map to indicate that all nodes are visited
        visited.remove(course);
        preReq.put(course, new ArrayList<Integer>());
        
        return true;
    }
}
