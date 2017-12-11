import java.io.BufferedReader;
import java.io.FileReader;

public class AOC2017D11P1 {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed (file name)");
      return;
    }
    String input = "";
    try {
      BufferedReader file = new BufferedReader(new FileReader(args[0]));
      String row;
      while ((row = file.readLine()) != null) {
        input += row;
      }
    }
    catch (Exception e) {
      System.out.println("Exception occured:");
      e.printStackTrace();
      return;
    }
    int posx = 0;
    int posy = 0;
    for (String inst : input.split(",")) {
      switch (inst) {
        case "n":
          posx++;
          posy--;
          break;
        case "s":
          posx--;
          posy++;
          break;
        case "se":
          posy++;
          break;
        case "nw":
          posy--;
          break;
        case "sw":
          posx--;
          break;
        case "ne":
          posx++;
          break;
        default:
          return;
      }
    }
    int max = Math.abs(posx);
    if (max < Math.abs(posy)) {
      max = Math.abs(posy);
    }
    System.out.println(max);
  }
}
