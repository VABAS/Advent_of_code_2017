public class AOC2017D14P1 {
  private static String knotHash (String in) {
    int[] input = new int[in.length() + 5];
    input[in.length()] = 17;
    input[in.length() + 1] = 31;
    input[in.length() + 2] = 73;
    input[in.length() + 3] = 47;
    input[in.length() + 4] = 23;
    for (int i = 0; i < in.length(); i++) {
      input[i] = in.charAt(i);
    }
    int skipSize = 0;
    int[] list = new int[256];
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
      String hex = Integer.toHexString(cur);
      if (hex.length() < 2) {
        dense += "0" + hex;
      }
      else {
        dense += hex;
      }
    }
    return dense;
  }
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed");
      return;
    }
    String input = args[0];

    int count = 0;
    for (int i = 0; i < 128; i++) {
      String hash = knotHash(input + "-" + i);
      for (int j = 0; j < hash.length(); j++){
        String bin = Integer.toBinaryString(Character.digit(hash.charAt(j), 16));
        for (int l = 0; l < bin.length(); l++) {
          if (bin.charAt(l) == '1') {
            count++;
          }
        }
      }
    }
    System.out.println(count);
  }
}
