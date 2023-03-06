package src;

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
            } if (Integer.parseInt(str) >= 1 && Integer.parseInt(str) <= 1000) {
                numbers.add(Integer.parseInt(str));
            } else {
                System.out.println("Invalid input");
            }
        } while (true);
        CalculateDecile(numbers);
    }
    public static void CalculateDecile(List<Integer> args) {
        Collections.sort(args);
        int length = args.size();
        int secoundDecile = (int) 2*(length+1)/10;
        int thirdDecile = (int) 3*(length+1)/10;
        int fifthDecile = (int) 5*(length+1)/10;
        int sixthDecile = (int) 6*(length+1)/10;
        int thirdDecileCount = 0;
        List<Integer> third = new ArrayList<>();
        List<Integer> sixth = new ArrayList<>();
        int sixthDecileCount = 0;
        int sum = 0;
        int secoundDecileNumber = (int) args.get(secoundDecile);
        int thirdDecileNumber = (int) args.get(thirdDecile);
        int fifthDecileNumber = (int) args.get(fifthDecile);
        int sixthDecileNumber = (int) args.get(sixthDecile);
        for(int i = 0; i < length - 1; i++) {
            sum += args.get(i);
            if(i > secoundDecileNumber - 1 && i <= thirdDecileNumber - 1) {
                thirdDecileCount++;
                third.add(args.get(i));
            }
            if(i > fifthDecileNumber - 1 && i <= sixthDecileNumber) {
                sixthDecileCount++;
                sixth.add(args.get(i));
            }
        }
        System.out.println("3rd decile:");
        System.out.println(third);
        System.out.println("6th decile");
        System.out.println(sixth);
        System.out.println("Minumum:");
        System.out.println(args.get(0));
        System.out.println("Maximum:");
        System.out.println(args.get(length-1));
        System.out.println("Range:");
        System.out.println(args.get(length-1)-args.get(0));
        System.out.println("Sum:");
        System.out.println(sum);
    }
}