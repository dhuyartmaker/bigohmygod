
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TheNumberOfTheBoard {

  private static int theNumber(ArrayList<Integer> arrs, int k, int total) {
    int result = 0;
    int sum = total;
    int i = 0;
    while (sum < k && i < arrs.size() && arrs.get(i) != 9) {
      sum += (9 - arrs.get(i));

      result++;
      i++;
    }

    if (sum < k) return 0;
    return result;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String ks = sc.nextLine();
    String ns = sc.nextLine();

    int k = Integer.parseInt(ks.trim());

    ArrayList<Integer> arrNumber = new ArrayList<>();
    int total = 0;
    for (int i = 0; i < ns.length(); i++) {
      char[] charArr = { ns.charAt(i) };
      String strArI = new String(charArr);
      Integer numAtoi = Integer.valueOf(strArI);
      arrNumber.add(numAtoi);
      total += numAtoi;
    }

    Collections.sort(arrNumber, (a,b) -> Long.compare(a, b));

    if (total > k) {
      System.out.print(0);
      return;
    }

    int res = theNumber(arrNumber, k, total);
    System.out.print(res);
  }
}
