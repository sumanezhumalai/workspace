import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

class BFS {

    ArrayList<ArrayList<Integer>> arr;
    int v;

    void bfs(int start) {
        boolean[] visited = new boolean[v];

        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {

            int cur = q.poll();
            System.out.print(cur + " ");

            for (int i = 0; i < arr.get(cur).size(); i++) {

                int next = arr.get(cur).get(i);

                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}