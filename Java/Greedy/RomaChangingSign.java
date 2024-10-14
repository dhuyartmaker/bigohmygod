import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RomaChangingSign {
  private static int theNumber(ArrayList<Integer> arrs, int ops) {
    int total = 0;
    int countOps = ops;
    Collections.sort(arrs, (a,b) -> Integer.compare(a, b));
    ArrayList<Integer> arrPos = new ArrayList<>();
    ArrayList<Integer> arrZero = new ArrayList<>();
    ArrayList<Integer> arrNeg = new ArrayList<>();

    int i = 0;
    while (i < arrs.size() && arrs.get(i) < 0) {
      arrNeg.add(arrs.get(i));
      i++;
    }
    while (i < arrs.size() && arrs.get(i) == 0) {
      arrZero.add(arrs.get(i));
      i++;
    }
    while (i < arrs.size()) {
      arrPos.add(arrs.get(i));
      i++;
    }

    i = 0;
    while(i < arrNeg.size()) {
      if (countOps > 0) {
        total -= arrNeg.get(i);
        countOps--;
      } else {
        total += arrNeg.get(i);
      }
      i++;
    }

    if ((countOps > 0 && !arrZero.isEmpty()) || countOps == 0) { // Case: Have 0, after change all sign of negative , can change sign of 0 to get Max Val.
      for (int j = 0; j < arrPos.size(); j++) {
        total += arrPos.get(j);
      }

      return total;
    } else if (countOps > 0 && arrZero.isEmpty()) {
      boolean isOdd = countOps % 2 == 1;
      int minOfNeg = (int) (!arrNeg.isEmpty() ? arrNeg.get(arrNeg.size() - 1) : -Math.pow(10,5) + 1);
      int minOfPos = (int) (!arrPos.isEmpty() ? arrPos.get(0) : Math.pow(10, 5) + 1);

      if (-minOfNeg <= minOfPos) {
        total = total + (isOdd ? minOfNeg * 2 : 0);

        for (int j = 0; j < arrPos.size(); j++) {
          total += arrPos.get(j);
        }
      } else {
        total = total + (isOdd ? -(minOfPos * 1) : (minOfPos * 1));

        for (int j = 1; j < arrPos.size(); j++) {
          total += arrPos.get(j);
        }
      }
    }

    return total;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int k = sc.nextInt();
    int ops = sc.nextInt();

    ArrayList<Integer> arrs = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      arrs.add(sc.nextInt());
    }

    int res = theNumber(arrs, ops);
    System.out.println(res);
  }
}