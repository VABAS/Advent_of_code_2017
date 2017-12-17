public class AOC2017D17P2 {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed");
      return;
    }
    int input = Integer.parseInt(args[0]);
    int target = 50000000;
    int pos = 0;
    int size = 1;
    int cur = -1;
    for (int i = 1; i < target; i++) {
      pos = ((pos + input) % size) + 1;
      if (pos == 1) {
        cur = i;
      }
      size++;
    }
    System.out.println(cur);
  }
}
