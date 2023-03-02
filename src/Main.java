import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<Integer>();
        do {
            System.out.println("Enter a number from 1 to 1000 ('END' to stop):");
            String str = input.nextLine();
            if (str.equals("END")) {
                break;
            }
            int number = Integer.parseInt(str);
            try {
                if (number >= 1 && number <= 1000) {
                    numbers.add(number);
                } else {
                    System.out.println("Invalid input");
                }
            } catch (NumberFormatException e) {
                System.out.println("Insert string value");
            }
        } while (true);
        Collections.sort(numbers);
        int length = numbers.size();
        int thirdDecile = (int) Math.ceil(length * 0.3) - 1;
        int sixthDecile = (int) Math.ceil(length * 0.6) - 1;
        int thirdDecileCount = 0;
        int sixthDecileCount = 0;
        System.out.println(thirdDecile);
        System.out.println(sixthDecile);
        for (int i = 0; i < length; i++) {
            int numAtIndex = numbers.get(i);
            if (i == thirdDecile) {
                thirdDecileCount++;
            } else if (i == sixthDecile) {
                sixthDecileCount++;
            } else if (numAtIndex > numbers.get(thirdDecile) && numAtIndex <= numbers.get(sixthDecile)) {
                thirdDecileCount++;
                sixthDecileCount++;
            }
        }

        System.out.printf("Total numbers entered: %d\n", length);
        System.out.printf("Numbers in the 3rd decile: %d\n", thirdDecileCount);
        System.out.printf("Numbers in the 6th decile: %d\n", sixthDecileCount);
    }
}