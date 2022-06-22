import java.math.BigInteger;
import java.util.*;

//runner class
public class Main {
    public static void main(String [] args){
        //path to input file
        String path = "G://Show_Case_Projects//AdventOfCode//Day10//Day_10_Input.txt";

        //Day 10 part 1
        //read input from file
        List<Integer> adapters = utils.readInput(path);
        //start the timer
        long startTime = System.nanoTime();
        //Sort List
        Collections.sort(adapters);
        //add phone adaptor value
        adapters.add(adapters.get(adapters.size()-1)+3);
        //run method
        int dayTenPart1 = DayTen.partOne(adapters);
        //stop timer
        long endTime = System.nanoTime();
        //calculate run time
        double duration = ((double) endTime - (double)startTime)/1000000;
        //print results
        System.out.println("Day 10 Part 1: " + dayTenPart1);
        System.out.println("Part 1 Duration: "+duration+"ms");

        //Day 10 part 2
        //reset the adaptor List to unsorted
        adapters = utils.readInput(path);

        //create root node of 0
        DayTen.Node root = new DayTen.Node(0);
        
        //start the timer
        startTime = System.nanoTime();
        //Sort List
        Collections.sort(adapters);
        //add phone adaptor value
        adapters.add(adapters.get(adapters.size()-1)+3);
        //run method
        BigInteger dayTenPart2 = DayTen.partTwo(root, adapters);
        //stop timer
        endTime = System.nanoTime();
        //calculate run time
        duration = ((double) endTime - (double)startTime)/1000000;
        //print results
        System.out.println("Day 10 Part 2: " + dayTenPart2);
        System.out.println("Part 2 Duration: " + duration+"ms");
    }
}
