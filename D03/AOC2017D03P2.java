import java.util.ArrayList;

public class AOC2017D03P2 {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed...");
      return;
    }
    int input = Integer.parseInt(args[0]);
    Matrix matrix = new Matrix();
    int posx = 0;
    int posy = 0;
    int curNum = 1;
    boolean plus = true;
    boolean xturn = true;
    int target = 1;
    int i = 1;
    while (true) {
      int sum;
      try {
        sum = matrix.get(posx + 1, posy)
            + matrix.get(posx - 1, posy)
            + matrix.get(posx, posy + 1)
            + matrix.get(posx, posy - 1)
            + matrix.get(posx + 1, posy + 1)
            + matrix.get(posx - 1, posy - 1)
            + matrix.get(posx - 1, posy + 1)
            + matrix.get(posx + 1, posy - 1);
      }
      catch (Exception e) {
        matrix.addDimension();
        continue;
      }
      if (posx != 0 || posy != 0){
        matrix.set(posx, posy, sum);
      }
      if (matrix.get(posx, posy) > input) {
        System.out.println(matrix.get(posx, posy));
        return;
      }
      if (plus) {
        if (xturn) {
          posx++;
          curNum++;
          if (posx >= target) {
            xturn = false;
          }
        }
        else {
          posy++;
          curNum++;
          if (posy >= target) {
            xturn = true;
            plus = false;
            i++;
            target -= i;
          }
        }
      }
      else {
        if (xturn) {
          posx--;
          curNum++;
          if (posx <= target) {
            xturn = false;
          }
        }
        else {
          posy--;
          curNum++;
          if (posy <= target) {
            xturn = true;
            plus = true;
            i++;
            target += i;
          }
        }
      }
    }
  }
}
