import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class AOC2017D07P1 {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed (file name)");
      return;
    }
    ArrayList<String> input = new ArrayList<>();
    try {
      BufferedReader file = new BufferedReader(new FileReader(args[0]));
      String row;
      while ((row = file.readLine()) != null) {
        input.add(row.replace("(", "").replace(")", ""));
      }
    }
    catch (Exception e) {
      System.out.println("Exception occured:");
      e.printStackTrace();
      return;
    }
    ArrayList<Program> programs = new ArrayList<>();
    // Finding out all the programs.
    for (String row : input) {
      String name = row.split(" ")[0];
      int weight = Integer.parseInt(row.split(" ")[1]);
      programs.add(new Program(name, weight));
    }
    // Next finding out the parents.
    for (String row : input) {
      String[] rowA = row.split(" -> ");
      if (rowA.length > 1) {
        String name = rowA[0].split(" ")[0];
        Program current = null;
        for (Program p : programs) {
          if (name.equals(p.getName())) {
            current = p;
            break;
          }
        }
        if (current == null) {
          continue;
        }
        for (String child : rowA[1].split(", ")) {
          for (Program p : programs) {
            if (child.equals(p.getName())) {
              p.addParent(current);
              current.addChildren(p);
            }
          }
        }
      }
    }
    Program root = null;
    // Finding out the root node.
    for (Program p : programs) {
      if (p.getParent() == null) {
        root = p;
        break;
      }
    }
    if (root == null) {
      System.out.println("No root node found!");
      return;
    }
    System.out.println(root.getName());
  }
}
