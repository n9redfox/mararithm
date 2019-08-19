const unvisited = 0
const nowVisited = 1
const visitedDone = 2

func canFinish(numCourses int, prerequisites [][]int) bool {

	if prerequisites == nil {
		return true
	}

	adjacencySlice := make([][]int, numCourses)
	for idx:=0; idx <numCourses; idx++ {
		adjacencySlice[idx] = make([]int, 0, numCourses)
	}

	for _, prerequisite := range prerequisites {
		pre:= prerequisite[1]
		after := prerequisite[0]
		adjacencySlice[pre] = append(adjacencySlice[pre], after)
	}

	visitedSlice := make([]int, numCourses)

	for idx:=0; idx < numCourses; idx ++ {
		if visitedSlice[idx] == unvisited {
			if !dfs(&adjacencySlice, &visitedSlice, idx, numCourses) {
				return false
			}
		}
	}

	return true
}

func dfs(adjacencySlice *[][]int, visitedSlice *[]int, index int, numCourse int) bool{

	if (*visitedSlice)[index] == nowVisited {
		return false
	}

	(*visitedSlice)[index] = nowVisited

	for _, neiborhood := range (*adjacencySlice)[index] {
		if (*visitedSlice)[neiborhood] != visitedDone && !dfs(adjacencySlice, visitedSlice, neiborhood, numCourse) {
			return false
		}
	}

	(*visitedSlice)[index] = visitedDone
	return true
}
