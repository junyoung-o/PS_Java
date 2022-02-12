import java.util.*;

// 입력
// n m v
// graph

// 풀이
// 1. visit 초기화
// 2. graph 생성
// 3. dfs
// 4. bfs

// 출력
// dfs
// bfs


public class dfs {
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

        // visit 초기화
        visit = new boolean[n + 1];
        for(int i = 1; i < n + 1; i++) {
            visit[i] = false;
        }
        visit[0] = true;


        // graph 생성
        graph = new ArrayList[n+1];
        for(int i = 1; i < n+1;i++) {
            graph[i] = new ArrayList<>();
        }

        // graph 초기화
        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x);
        }

        for(int i = 0; i < n + 1; i ++) {
            Collections.sort(graph[i]);
        }

        // dfs
        dfs(v);        
    }

    public static void dfs(int vertex) {
        if(visit[vertex]) {
            return;
        }

        visit[vertex] = true;
        System.out.println("Visit : " + vertex);


        Iterator<Integer> iter = graph[vertex].iterator();
        while(iter.hasNext()) {
            int nextVertex = iter.next();

            if(!visit[nextVertex]) {
                dfs(nextVertex);
            }

        }

    }



}