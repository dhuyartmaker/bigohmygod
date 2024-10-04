
import java.util.*;

public class Hirerachy {
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
    int wish = sc.nextInt();

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < wish; i++) {
      int countStaffWish = sc.nextInt();
      for (int iStaff = 0; iStaff < countStaffWish; iStaff++) {
        int staffIndex = sc.nextInt() - 1;
        graph.get(i).add(staffIndex);
      }
    }

    System.out.println(graph);

    ArrayList<Integer> result = new ArrayList<>();
    if (topolpgySort(graph, result)) {
      System.out.println(result);
      
      int[] finalArr = new int[V + 1];
      finalArr[result.get(0) + 1] = 0;

      for (int i = 1; i < result.size(); i++) {
        finalArr[result.get(i) + 1] = result.get(i - 1) + 1;
      }

      for (int i = 1; i < finalArr.length; i++) {
        System.out.println(finalArr[i]);
      }
    }
  }
}
