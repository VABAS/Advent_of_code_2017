import java.math.BigInteger;

public class AOC2017D15P2 {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Not enough arguments!");
      System.out.println("Starting values for gen A and B are needed.");
      return;
    }
    int aStart = Integer.parseInt(args[0]);
    int bStart = Integer.parseInt(args[1]);
    BigInteger aFactor = new BigInteger("16807");
    BigInteger bFactor = new BigInteger("48271");
    BigInteger modulo = new BigInteger("2147483647");
    int count = 0;

    BigInteger aPrev = new BigInteger(Integer.toString(aStart));
    BigInteger bPrev= new BigInteger(Integer.toString(bStart));
    // Doing a total of 5 million iterations.
    for (int i = 0; i < 5000000; i++) {
      do {
        aPrev = aPrev.multiply(aFactor).mod(modulo);
      } while (aPrev.mod(new BigInteger("4")).compareTo(new BigInteger("0")) != 0);
      do {
        bPrev = bPrev.multiply(bFactor).mod(modulo);
      } while (bPrev.mod(new BigInteger("8")).compareTo(new BigInteger("0")) != 0);
      String aBin = aPrev.toString(2);
      String bBin = bPrev.toString(2);
      while (aBin.length() < 32) {
        aBin = "0" + aBin;
      }
      while (bBin.length() < 32) {
        bBin = "0" + bBin;
      }
      if (aBin.substring(aBin.length() - 16).equals(bBin.substring(bBin.length() - 16))) {
        count++;
      }
    }
    System.out.println(count);
  }
}
