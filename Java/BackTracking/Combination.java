/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class Combination {
  private static void printInt(List<Integer> arrsInt) {
    System.out.println(arrsInt);
  }

  private static void combination(List<Integer> arrs, int n, int l, int k) {
    if (k == 0) {
      printInt(arrs);
    } else {
      for (int i = l; i <= n; i++) {
        arrs.add(i);
        combination(arrs, n, i + 1, k - 1);
        arrs.remove(arrs.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    int n = 6;
    int k = 4;
    List<Integer> arrs = new ArrayList<>();
    combination(arrs, n, 1, k);
  }
}
