public class AOC2017D03P1 {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed...");
      return;
    }
    int input = Integer.parseInt(args[0]);
    int posx = 0;
    int posy = 0;
    int curNum = 1;
    boolean plus = true;
    for (int i = 1; true; i++) {
      if (plus) {
        int target = posx + i;
        for (; posx < target || posx > target; posx++) {
          if (curNum == input) {
            System.out.println(Math.abs(posx) + Math.abs(posy));
            return;
          }
          curNum++;
        }
        for (; posy < target || posy > target; posy++) {
          if (curNum == input) {
            System.out.println(Math.abs(posx) + Math.abs(posy));
            return;
          }
          curNum++;
        }
      }
      else {
        int target = posx - i;
        for (; posx < target || posx > target; posx--) {
          if (curNum == input) {
            System.out.println(Math.abs(posx) + Math.abs(posy));
            return;
          }
          curNum++;
        }
        for (; posy < target || posy > target; posy--) {
          if (curNum == input) {
            System.out.println(Math.abs(posx) + Math.abs(posy));
            return;
          }
          curNum++;
        }
      }
      plus = !plus;
    }
  }
}
