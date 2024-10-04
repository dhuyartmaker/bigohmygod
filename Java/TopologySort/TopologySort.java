
import java.util.*;
import java.util.stream.Collectors;

public class TopologySort {
  final static PriorityQueue<Integer> zeroIndegree = new PriorityQueue<>();

  private static boolean topolpgySort(ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> result) {
    int V = graph.size();
    int[] indegree = new int[V];
    
    for (int u = 0; u < V; u++) {
      for (int v : graph.get(u)) {
        indegree[v]++;
      }
    }

    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        zeroIndegree.add(i);
      }
    }

    while(!zeroIndegree.isEmpty()) {
      int u = zeroIndegree.poll();
      result.add(u);
      for (int v : graph.get(u)) {
        indegree[v]--;
        if (indegree[v] == 0) {
          zeroIndegree.add(v);
        }
      }
    }

    return result.size() == V;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int V = sc.nextInt();
    int E = sc.nextInt();

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < E; i++) {
      int u = sc.nextInt() - 1;
      int v = sc.nextInt() - 1;

      graph.get(u).add(v);
    }
    ArrayList<Integer> result = new ArrayList<>();
    if (topolpgySort(graph, result)) {
      System.out.print(String.join(" ",
        result.stream()
        .map(item -> item + 1)
        .map(String::valueOf)
        .collect(Collectors.joining(" "))
      ));
    } else {
      System.out.println("Sandro fails.");
    }
  }
}
