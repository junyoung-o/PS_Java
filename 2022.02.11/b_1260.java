import java.util.*;

public class b_1260 {
    private static int n;
    private static int m;
    private static int v;

    private static boolean[] visit;
    private static ArrayList<Integer>[] graph;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        visit = new boolean[n+1];
        graph = new ArrayList[n+1];

        // init visit
        for(int i = 0; i < n + 1; i ++) {
            visit[i] = false;
        }
        visit[0] = true;

        // init graph
        for(int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x);
        }

        sc.close();

        for(int i = 0; i < n + 1; i++) {
            Collections.sort(graph[i]);
        }

        dfs(v);

        System.out.println();

        // init visit
        for(int i = 0; i < n + 1; i ++) {
            visit[i] = false;
        }
        visit[0] = true;

        bfs(v);
    }

    public static void dfs(int vertex) {
        if(visit[vertex]) {
            return;
        }

        visit[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> iter = graph[vertex].iterator();

        while(iter.hasNext()) {
            int nextVertex = iter.next();

            if(!visit[nextVertex]) {
                dfs(nextVertex);
            }
        }
    }


    public static void bfs(int vertex) {
        if(visit[vertex]) {
            return;
        }

        Deque<Integer> q = new ArrayDeque<Integer>();
        q.addLast(vertex);
        visit[vertex] = true;

        while(!q.isEmpty()) {
            int currentVertex = q.removeFirst();
            System.out.print(currentVertex + " ");

            Iterator<Integer> iter = graph[currentVertex].iterator();

            while(iter.hasNext()) {
                int nextVertex = iter.next();

                if(!visit[nextVertex]) {
                    q.addLast(nextVertex);
                    visit[nextVertex] = true;
                }
            }
        }
    }
}
