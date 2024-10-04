import java.util.*;

class Heap {
  private static ArrayList<Integer> h;

  private static void swap(int i, int j) {
    int temp = h.get(i);
    h.set(i, h.get(j));
    h.set(j, temp);
  }

  private static void heapify(int i) {
    int smallest = i;
    int left = (i * 2) + 1;
    int right = (i * 2) + 2;
  
    System.out.println(i);

    if (left < h.size() && h.get(left) < h.get(smallest)) {
      smallest = left;
    }
    if (right < h.size() && h.get(right) < h.get(smallest)) {
      smallest = right;
    }
    if (smallest != i) {
      swap(smallest, i);
      heapify(smallest);
    }
  }

  private static void buildHeap(int n) {
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(i);
    }
  }

  public static void main(String[] args) {
    h = new ArrayList<>(Arrays.asList(7, 12, 6, 10, 17, 15, 2, 4));
    buildHeap(h.size());

    System.out.println(h);
  }
}