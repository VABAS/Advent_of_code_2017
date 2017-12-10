public class AOC2017D10P1 {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed...");
      return;
    }
    String[] args0 = args[0].split(",");
    int[] input = new int[args0.length];
    for (int i = 0; i < args0.length; i++) {
      input[i] = Integer.parseInt(args0[i]);
    }
    int skipSize = 0;
    int[] list = new int[256];
    //int[] list = new int[5];
    for (int i = 0; i < list.length; i++) {
      list[i] = i;
    }
    int index = 0;
    for (int length : input) {
      for (int i = 0; i < (length - (length % 2)) / 2; i++) {
        list[(index + i) % list.length] ^= list[(index + length - 1 - i) % list.length];
        list[(index + length - 1 - i) % list.length] ^= list[(index + i) % list.length];
        list[(index + i) % list.length] ^= list[(index + length - 1 - i) % list.length];
      }
      index = (index + length + skipSize) % list.length;
      skipSize++;
    }
    System.out.println(list[0] * list[1]);
  }
}
