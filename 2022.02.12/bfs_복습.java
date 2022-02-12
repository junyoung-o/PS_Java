// 입력
// n m v
// graph

// 풀임
// 1. visit 초기화
// 2. graph 생성
// 3. bfs

// 출력
// bfs


import java.util.*;


public class bfs {
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
        visit = new boolean[n+1];
        for(int i = 0; i < n + 1; i++) {
            visit[i] = false;
        }

        // graph 생성
        graph = new ArrayList[n+1];
        for(int i = 0; i < n+ 1; i++) {
            graph[i] = new ArrayList();
        }

        // graph 초기화
        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x);
        }
        
        for(int i = 0; i < n + 1; i++) {
            Collections.sort(graph[i]);
        }


        bfs(v);
    }

    public static void bfs(int vertex) {
        if(visit[vertex]) {
            return;
        }

        Deque<Integer> q = new ArrayDeque<>();
        
        q.addLast(vertex);
        visit[vertex] = true;
        System.out.println("Visit : " + vertex);

        while(!q.isEmpty()) {
            int currentVertex = q.removeFirst();

            Iterator<Integer> iter = graph[currentVertex].iterator();
            while(iter.hasNext()) {
                int nextVertex = iter.next();
                if(!visit[nextVertex]) {
                    q.addLast(nextVertex);
                    System.out.println("Visit : " + nextVertex);
                    visit[nextVertex] = true;
                }
            }
            
        }



    }


}