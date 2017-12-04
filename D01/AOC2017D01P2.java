public class AOC2017D01P2 {
    public static void main(String[] args) {
        if (args.length < 1) {
          System.out.println("Not enough arguments! Input string is needed...");
          return;
        }
        String input = args[0];
        int total = 0;
        // Initializing previous to a character half way through the string..
        int previous = input.length()/2;
        for (int i = 0; i < input.length(); i++) {
          if (input.charAt(i) == input.charAt(previous)) {
            total += (int)(input.charAt(i) - '0');
          }
          previous = (previous + 1) % input.length();
        }
        System.out.println(total);
    }
}
