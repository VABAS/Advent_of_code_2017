public class AOC2017D10P2 {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed...");
      return;
    }
    int[] input = new int[args[0].length() + 5];
    input[args[0].length()] = 17;
    input[args[0].length() + 1] = 31;
    input[args[0].length() + 2] = 73;
    input[args[0].length() + 3] = 47;
    input[args[0].length() + 4] = 23;
    for (int i = 0; i < args[0].length(); i++) {
      input[i] = args[0].charAt(i);
    }
    int skipSize = 0;
    int[] list = new int[256];
    //int[] list = new int[5];
    for (int i = 0; i < list.length; i++) {
      list[i] = i;
    }
    int index = 0;
    for (int round = 0; round < 64; round++) {
      for (int length : input) {
        for (int i = 0; i < (length - (length % 2)) / 2; i++) {
          list[(index + i) % list.length] ^= list[(index + length - 1 - i) % list.length];
          list[(index + length - 1 - i) % list.length] ^= list[(index + i) % list.length];
          list[(index + i) % list.length] ^= list[(index + length - 1 - i) % list.length];
        }
        index = (index + length + skipSize) % list.length;
        skipSize++;
      }
    }
    String dense = "";
    for (int i = 0; i < list.length; i += 16) {
      int cur = 0;
      for (int l = 0; l < 16; l++) {
        cur ^= list[i +l];
      }
      dense += Integer.toHexString(cur);
    }
    System.out.println(dense);
  }
}
