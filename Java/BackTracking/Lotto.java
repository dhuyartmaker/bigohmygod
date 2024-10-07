
/**
 *
 * @author Huy
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Lotto {
  private static void lotto(ArrayList<Integer> numbers, int index, int depth, int[] result) {
    // System.out.format("depth: %d, indeX: %d \n", depth, index);
    if (depth == 6) {
      System.out.print(result[0]);
      for (int i = 1; i < depth; i++) {
        System.out.format(" %d", result[i]);
      }
      System.out.println();
      return;
    }

    for (int i = index; i < numbers.size(); i++) {
      result[depth] = numbers.get(i);
      lotto(numbers, i + 1, depth + 1, result);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int isFirst = 0;
    while (true) {
      int size = sc.nextInt();
      if (size == 0) {
        break;
      }
      ArrayList<Integer> numbers = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        int nextInt = sc.nextInt();
        numbers.add(nextInt);
      }
      int[] results = new int[6];

      lotto(numbers, 0, 0, results);
      if (size != 0 && isFirst != 0) {
        System.out.println();
      }
      isFirst++;
    }
  }
}
