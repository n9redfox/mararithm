from collections import defaultdict
from typing import List


class Solution:

    def dfs(self, node, graph, visited):

        if node not in graph:
            return True

        for n in graph[node]:
            if n in visited:
                return visited[n] == 2
            visited[n] = 1
            if not self.dfs(n, graph, visited):
                return False
            visited[n] = 2

        return True

    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = defaultdict(list)

        for p in prerequisites:
            graph[p[1]].append(p[0])

        visited = defaultdict(int)

        for node in graph:
            visited[node] = 1
            if not self.dfs(node, graph, visited):
                return False
            visited[node] = 2

        return True
