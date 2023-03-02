import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
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
        int secoundDecile = (int) 2*(length+1)/10;
        int thirdDecile = (int) 3*(length+1)/10;
        int fifthDecile = (int) 5*(length+1)/10;
        int sixthDecile = (int) 6*(length+1)/10;
        int thirdDecileCount = 0;
        List<Integer> third = new ArrayList<>();
        List<Integer> sixth = new ArrayList<>();
        int sixthDecileCount = 0;
        int sum = 0;
        int secoundDecileNumber = (int) numbers.get(Math.round(secoundDecile));
        int thirdDecileNumber = (int) numbers.get(Math.round(thirdDecile));
        int fifthDecileNumber = (int) numbers.get(Math.round(fifthDecile));
        int sixthDecileNumber = (int) numbers.get(Math.round(sixthDecile));
        for(int i = 0; i < length - 1; i++) {
            sum += numbers.get(i);
            if(i > secoundDecileNumber - 1 && i <= thirdDecileNumber - 1) {
                thirdDecileCount++;
                third.add(numbers.get(i));
            }
            if(i > fifthDecileNumber - 1 && i <= sixthDecileNumber) {
                sixthDecileCount++;
                sixth.add(numbers.get(i));
            }
        }
        System.out.println("3rd decile:");
        System.out.println(third);
        System.out.println("6th decile");
        System.out.println(sixth);
        System.out.println("Minumum:");
        System.out.println(numbers.get(0));
        System.out.println("Maximum:");
        System.out.println(numbers.get(length-1));
        System.out.println("Range:");
        System.out.println(numbers.get(length-1)-numbers.get(0));
        System.out.println("Sum:");
        System.out.println(sum);
    }
}