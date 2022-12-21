/*
* https://leetcode.com/problems/course-schedule-ii/
* */

import java.util.ArrayList;

public class CourseScheduler2 {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList[] preMap = new ArrayList[numCourses];
        boolean[] visitSet = new boolean[numCourses];
        boolean[] memo = new boolean[numCourses];
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<preMap.length; i++)
            preMap[i] = new ArrayList();

        // build adjacency list of course -> pre-reqs
        for(int i=0; i < prerequisites.length; i++) {
            preMap[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for(int i=0; i<numCourses; i++) {
            if(!dfs(preMap, visitSet, i, memo, result))
                return new int[0];
        }

        //some weird conversion
        int[] arr = result.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }

    private static boolean dfs(ArrayList[] graph, boolean[] visitSet, int crs, boolean[] memo, ArrayList<Integer> result) {
        if(visitSet[crs])
            return false;
        if (memo[crs]) {
            return true;
        }
        visitSet[crs] = true;
        for(int i=0; i < graph[crs].size(); i++) {
            if(!dfs(graph, visitSet, (Integer) graph[crs].get(i), memo, result) )
                return false;
        }
        visitSet[crs] = false;
        memo[crs] = true;
        result.add(crs);
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,0}, {2,0}, {3,1}, {3,2}};
        int[] arr = findOrder(4, graph);
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + ", ");
    }
}
