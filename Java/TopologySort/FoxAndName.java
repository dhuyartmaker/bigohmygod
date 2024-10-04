import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FoxAndName {
  final static PriorityQueue<Integer> zeroIndegree = new PriorityQueue<>();

  private static boolean topolpgySort(ArrayList<ArrayList<String>> graph, ArrayList<Integer> result) {
    int V = graph.size();
    int[] indegree = new int[V];
    
    for (int u = 0; u < V; u++) {
      for (String v : graph.get(u)) {
        indegree[v.charAt(0) - 97]++;
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
      for (String v : graph.get(u)) {
        int parseCharToInt = v.charAt(0) - 97;
        indegree[parseCharToInt]--;
        if (indegree[parseCharToInt] == 0) {
          zeroIndegree.add(parseCharToInt);
        }
      }
    }

    return result.size() == V;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int lines = sc.nextInt();
    sc.nextLine();

    ArrayList<String> names = new ArrayList<>();
    for (int i = 0; i < lines; i++) {
      String name = sc.nextLine();
      names.add(name);
    }

    ArrayList<ArrayList<String>> countStr = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
      countStr.add(new ArrayList<>());
    }

    boolean isImpossible = false;

    for (int i = 0; i < names.size() - 1; i++) {
      String name1 = names.get(i);
      String name2 = names.get(i + 1);
      boolean isDiff = false;
      for (int j = 0; j < Math.min(name1.length(), name2.length()); j++) {

        if (name1.charAt(j) != name2.charAt(j)) {
          char[] parseChar = { name2.charAt(j) };
          String chName2 = new String(parseChar);
          countStr.get(name1.charAt(j) - 97).add(chName2);
          isDiff = true;
          break;
        }
      }

      if (isDiff == false && name1.length() > name2.length()) {
        isImpossible = true;
        break;
      }
    }

    ArrayList<Integer> result = new ArrayList<>();
    if (isImpossible == false && topolpgySort(countStr, result)) {
      for (int i = 0; i < result.size(); i++) {
        System.out.print((char) (result.get(i) + 97));
      }
    } else {
      System.out.println("Impossible");
    }
  }
}
