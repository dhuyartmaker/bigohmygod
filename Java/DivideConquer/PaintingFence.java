import java.util.Scanner;

public class PaintingFence {

  public static int minStrokes(int[] a, int left, int right, int minHeight) {
    if (left > right)
      return 0;

    int minIndex = left;
    for (int i = left; i <= right; i++) {
      if (a[i] < a[minIndex]) {
        minIndex = i;
      }
    }

    int strokes = a[minIndex] - minHeight;

    strokes += minStrokes(a, left, minIndex - 1, a[minIndex]);
    strokes += minStrokes(a, minIndex + 1, right, a[minIndex]);

    return Math.min(strokes, right - left + 1);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int[] a = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }

    int result = minStrokes(a, 0, n - 1, 0);
    System.out.println(result);

    scanner.close();
  }
}
