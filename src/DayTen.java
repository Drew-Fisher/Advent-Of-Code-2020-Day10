import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Class containing methods for Day 10
public class DayTen {
    //instance memory  using a map
    private static Map<Integer,BigInteger> memory = new HashMap<Integer,BigInteger>();

    //method for day 10 part 1
    public static int partOne(List<Integer> adapters){

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

        return one * three;
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
    public static BigInteger partTwo(Node root, List<Integer> chargers){
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
                combos = combos.add(partTwo(root.children.get(x),temp));
            }
        }

        //Adds to memory
        memory.put(root.data,combos);

        //returns
        return combos;
    }
}
