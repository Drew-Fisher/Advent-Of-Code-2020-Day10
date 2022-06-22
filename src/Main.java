import java.math.BigInteger;
import java.util.*;

//runner class
public class Main {
    public static void main(String [] args){

        //path to Day_10_Input.txt
        String dayOneInputPath = "ABSOLUTE_PATH";
        //create List from input for day 1
        List<Integer> dayOneInput = utils.readInput(dayOneInputPath);

        //run day 1 part 1
        int day1Part1 = DayOne.partOne(0,1,dayOneInput);
        //print
        System.out.println("Day 1 Part 1: " + day1Part1);

        //don't runt very slow
        //int day1Part2 = DayOne.partTwo(dayOneInput);

        String path = "ABSOLUTE_PATH";

        List<Integer> adapters = utils.readInput(path);

        //read Day_10_Input.txt into List
        adapters = utils.readInput(path);

        //sort list in ascending order
        Collections.sort(adapters);

        //add the phones built in adaptor
        adapters.add(adapters.get(adapters.size()-1)+3);

        //Day 10 part 1

        int dayTenPart1 = DayTen.partOne(adapters);

        System.out.println("Day 10 Part 1: " + dayTenPart1);

        //Day 10 part 2
        
        //create root node of 0
        DayTen.Node root = new DayTen.Node(0);
        
        //run the method
        BigInteger dayTenPart2 = DayTen.partTwo(root, adapters);

        System.out.println("Day 10 Part 2: " + dayTenPart2);
    }
}
