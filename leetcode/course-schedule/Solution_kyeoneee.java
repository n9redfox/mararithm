class Solution {
    Map<Integer, List<Integer>> courses;
    int[] visited;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        courses = new HashMap<Integer, List<Integer>>();
        visited = new int[numCourses]; // 0: 방문 안함, 1: 방문, 2: edge
        
        for (int[] i : prerequisites) {
            if (courses.get(i[0]) == null) {
                courses.put(i[0], new ArrayList());
            }    
            courses.get(i[0]).add(i[1]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i))
                return false;
        }
        
        return true;
    }
    
    public boolean dfs(int edge) {
        if (visited[edge] == 1)
            return false;
        else if (visited[edge] == 2)
            return true;
        else if (courses.get(edge) == null) { // 해당 edge에서 연결된 edge가 없다는 것은 course의 마지막 지점이라는 것
            visited[edge] = 2;
            return true;
        }
        
        visited[edge] = 1;
        
        for (int a : courses.get(edge))  
// 애초에 a가 visited 1이면 dfs를 한번 더 안해줘도 될 것 같지만          
// 실질적으로 메모리에 변화가 없어서 굳이 해주진 않음
            if (!dfs(a))
                return false;
        
        visited[edge] = 2;
        return true;
    }
}
