import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

public class Main {
    //instance memory  using a map
    private static Map<Integer,BigInteger> memory = new HashMap<Integer,BigInteger>();

    // list of adaptors to be read in from file using method
    private static List<Integer> adapters = new ArrayList<Integer>();

    //simple method to read input.txt to List<Integer>
    public static void readInput(String path) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextInt()){
            adapters.add(scanner.nextInt());
        }
    }

    //method for day 10 part 1
    public static int oneXThreeJolt(List<Integer> adapters){
        //defines the value of the last checked adaptor starts at 0
        int last = 0;
        //count of differences of 1
        int one = 0;
        //count of differences of 3
        int three = 0;

        for(int x = 0; x < adapters.size(); x++){
            //calculate current diff
            int curDiff = adapters.get(x) - last;
            //check if diff is 1
            if(curDiff == 1){
                one++;
            }
            //checks if diff is 3
            else if (curDiff == 3) {
                three++;
            }
            //sets the last
            last = adapters.get(x);
        }

        int result = one * three;

        return result;
    }

    //simple N-ary node implementation
    public static class Node{
        int data;
        List<Node> children;

        Node(int data){
            this.data = data;
            children = new ArrayList<Node>();
        }
    }

    //method for day 10 part 2
    public static BigInteger calculatePossibilities(Node root, List<Integer> chargers){
        //check if root is in memory
        if(memory.get(root.data) != null){
            return memory.get(root.data);
        }
        //check if at end of chain
        if(chargers.size() == 0){
            BigInteger one = new BigInteger("1");
            return one;
        }

        //define Bigint to store child return values
        BigInteger combos = new BigInteger("0");

        //for loop that breaks on 3(max ints away from root that are in range) or end of list
        for(int x =0; x < 3 && x < chargers.size(); x++){

            //check if adaptor is within 3
            if((chargers.get(x)- root.data) <= 3){

                //adds to root as child node
                root.children.add(new Node(chargers.get(x)));

                //generate subLIst of adaptors to pass to recursive calculations
                List<Integer> temp = chargers.subList(x+1,chargers.size());

                //adds result of recursion to BigInt
                combos = combos.add(calculatePossibilities(root.children.get(x),temp));
            }
        }

        //Adds to memory
        memory.put(root.data,combos);

        return combos;
    }

    public static void main(String [] args){

        //path to input.txt
        String path = "G://Show_Case_Projects//AdventOfCode//Day10//input.txt";

        //read input.txt into List
        readInput(path);

        //sort list in ascending order
        Collections.sort(adapters);

        //add the phones built in adaptor
        adapters.add(adapters.get(adapters.size()-1)+3);

        //Day 10 part 1

        int dayTenPart1 = oneXThreeJolt(adapters);

        System.out.println("Day 10 Part 1: " + dayTenPart1);

        //Day 10 part 2
        
        //create root node of 0
        Node root = new Node(0);
        
        //run the method
        BigInteger dayTenPart2 = calculatePossibilities(root, adapters);

        System.out.println("Day 10 Part 2: " + dayTenPart2);
    }
}
