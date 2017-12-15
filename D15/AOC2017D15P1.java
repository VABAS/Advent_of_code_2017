import java.math.BigInteger;

public class AOC2017D15P1 {
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
    // Doing a total of 40 million iterations.
    for (int i = 0; i < 40000000; i++) {
      aPrev = aPrev.multiply(aFactor).mod(modulo);
      bPrev = bPrev.multiply(bFactor).mod(modulo);
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
