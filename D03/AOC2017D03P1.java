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
    boolean xturn = true;
    int target = 1;
    int i = 1;
    while (true) {
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
      if (curNum == input) {
        System.out.println(Math.abs(posx) + Math.abs(posy));
        return;
      }
    }
  }
}
