import java.util.*;


public class ClosestPairOfPoint {
  private static final int INF = (int)1e9;

  static class Point {
    public int x, y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private static double distance(Point p1, Point p2) {
    int x = p1.x - p2.x;
    int y = p1.y - p2.y;
    return Math.sqrt(x*x + y*y);
  }

  private static double bruteForce(ArrayList<Point> points, int left, int right) {
    double min_dist = INF;
    for (int i = left; i < right; i++) {
      for (int j = i + 1; j < right; j++) {
        min_dist = Math.min(min_dist, distance(points.get(i), points.get(j)));
      }
    }
    return min_dist;
  }

  private static double stripClosest(ArrayList<Point> points, int left, int right, int mid, double dist_min) {
    Point point_mid = points.get(mid);
    ArrayList<Point> splitted_point = new ArrayList<>();
    for (int i = left; i < right; i++) {
      if (Math.abs(points.get(i).x - point_mid.x) <= dist_min) {
        splitted_point.add(points.get(i));
      }
    }

    Collections.sort(splitted_point, (o1, o2) -> Double.compare(o1.y, o2.y));
    double smallest = INF;
    for (int i = 0; i < splitted_point.size(); i++) {
      for (int j = i + 1; j < splitted_point.size() && (splitted_point.get(j).y - splitted_point.get(i).y) < dist_min; j++) {
        double d = distance(splitted_point.get(i), splitted_point.get(j));
        smallest = Math.min(smallest, d);
      }
    }

    return smallest;
  }

  private static double minimalDistance(ArrayList<Point> points, int left, int right) {
    if (right - left <= 3) {
      return bruteForce(points, left, right);
    }

    int mid = (right - left) / 2;
    double dist_left = minimalDistance(points, left, mid);
    double dist_right = minimalDistance(points, mid + 1, right);
    double dist_min = Math.min(dist_left, dist_right);
    return Math.min(dist_min, stripClosest(points, left, right, mid, dist_min));
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    while (n != 0) {
      ArrayList<Point> point_set = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        point_set.add(new Point(x, y));
      }
      Collections.sort(point_set, (p1, p2) -> Integer.compare(p1.x, p2.x));

      double ans = minimalDistance(point_set, 0, n);
  
      if (ans >= 10000) {
        System.out.println("INFINITY");
      } else {
        System.out.format("%.4f", ans);
      }

      n = sc.nextInt();
    }
  }
}
