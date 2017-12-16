import java.io.BufferedReader;
import java.io.FileReader;

public class AOC2017D16P2 {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed (file name)");
      return;
    }
    //String input = "abcde";
    String input = "abcdefghijklmnop";
    String put = "";
    try {
      BufferedReader file = new BufferedReader(new FileReader(args[0]));
      String row;
      while ((row = file.readLine()) != null) {
        put += row;
      }
    }
    catch (Exception e) {
      System.out.println("Exception occured:");
      e.printStackTrace();
    }
    int neededRounds = 1000000000;
    for (int l = 0; l < neededRounds; l++) {
      for (String in : put.split(",")) {
        String cmd = in.substring(0, 1);
        String instruction = in.substring(1);
        switch(cmd) {
          case "s":
            int amount = Integer.parseInt(instruction);
            input = input.substring(input.length() - amount, input.length())
                  + input.substring(0, input.length() - amount);
            break;
          case "x":
            int pos1 = Integer.parseInt(instruction.split("/")[0]);
            int pos2 = Integer.parseInt(instruction.split("/")[1]);
            String tmp = "";
            for (int i = 0; i < input.length(); i++) {
              if (i == pos1) {
                tmp += input.charAt(pos2);
              }
              else if (i == pos2) {
                tmp += input.charAt(pos1);
              }
              else {
                tmp += input.charAt(i);
              }
            }
            input = tmp;
            break;
          case "p":
            char prog1 = instruction.split("/")[0].charAt(0);
            char prog2 = instruction.split("/")[1].charAt(0);
            String tmp2 = "";
            for (int i = 0; i < input.length(); i++) {
              if (input.charAt(i) == prog1) {
                tmp2 += prog2;
              }
              else if (input.charAt(i) == prog2) {
                tmp2 += prog1;
              }
              else {
                tmp2 += input.charAt(i);
              }
            }
            input = tmp2;
            break;
        }
        // If we are at starting point again, lets get only the remainder of
        // billion modulo round (l+1) and start over. No need to actually  make
        // a billion rounds...
        if (input.equals("abcdefghijklmnop")) {
          neededRounds = (neededRounds % (l + 1));
          l = -1;
        }
      }
    }
    System.out.println(input);
  }
}
