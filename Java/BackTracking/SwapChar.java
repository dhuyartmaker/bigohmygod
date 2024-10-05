
public class SwapChar {
  private static void premutation(StringBuilder s, int l, int r) {
    if (l==r) {
      System.out.println(s);
    } else {
      for (int i = l; i < r; i++) {
        System.out.format("Swap %s %s \n", s.charAt(i), s.charAt(l));
        char temp = s.charAt(l);
        s.setCharAt(l, s.charAt(i));
        s.setCharAt(i, temp);
        premutation(s, l + 1, r);
        temp = s.charAt(l);
        s.setCharAt(l, s.charAt(i));
        s.setCharAt(i, temp);
      }
    }
  }

  public static void main(String[] args) {
    StringBuilder s = new StringBuilder("ABCD");
    premutation(s, 0, s.length());
  }
}
