import java.util.ArrayList;

public class Matrix {
  ArrayList<ArrayList<Integer>> matrix;

  public Matrix () {
    matrix = new ArrayList<>();
    // Adding first dimension and setting middle cell value to 1.
    matrix.add(0, new ArrayList<Integer>());
    matrix.get(0).add(0, 1);
  }

  public void addDimension() {
    matrix.add(0, new ArrayList<Integer>());
    matrix.get(0).add(0, 0);
    matrix.add(matrix.size(), new ArrayList<Integer>());
    matrix.get(matrix.size() - 1).add(0, 0);
    for (ArrayList row : matrix) {
      row.add(0, 0);
      row.add(row.size(), 0);
    }
  }

  public int get(int x, int y) {
    int half = (matrix.size() - 1) / 2;
    return matrix.get(half + x).get(half + y);
  }

  public void set(int x, int y, int value) {
    int half = (matrix.size() - 1) / 2;
    matrix.get(half + x).set(half + y, value);
  }
}
