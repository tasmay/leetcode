/*
* https://leetcode.com/problems/course-schedule/
* */

import java.util.ArrayList;

public class CourseScheduler {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] preMap = new ArrayList[numCourses];
        boolean[] visitSet = new boolean[numCourses];
        boolean[] memo = new boolean[numCourses];

        for(int i=0; i<preMap.length; i++)
            preMap[i] = new ArrayList();

        for(int i=0; i < prerequisites.length; i++) {
            preMap[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for(int i=0; i<numCourses; i++) {
            if(!dfs(preMap, visitSet, i, memo))
                return false;
        }
        return true;
    }

    private static boolean dfs(ArrayList[] graph, boolean[] visitSet, int crs, boolean[] memo) {
        if(visitSet[crs])
            return false;
        if (memo[crs]) {
            return true;
        }
        visitSet[crs] = true;
        for(int i=0; i < graph[crs].size(); i++) {
            if(!dfs(graph, visitSet, (Integer) graph[crs].get(i), memo) )
                return false;
        }
        visitSet[crs] = false;
        memo[crs] = true;
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,0}, {2,0}, {3,1}, {3,2}};
        System.out.println(canFinish(4, graph));
    }
}
