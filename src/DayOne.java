import java.util.List;

//Class containing methods for Day 1 part 1 and 2
public class DayOne {
    //ignore for now not done
    public static int partOne(int a, int b, List<Integer> input){
        if(input.get(a)+input.get(b) == 2020){
            return input.get(a)*input.get(b);
        }
        if(b == input.size()-1){
            a++;
            b = a+1;
        }
        return partOne(a,b+1,input);
    }

    //ignore for now not done
    public static int partTwo(List<Integer> input){
        for(int x = 0; x < input.size()-2; x++){
            System.out.println("running");
            for(int y = 1; y < input.size()-1;y++){
                for(int z = 2; z < input.size(); z++){
                    System.out.println("X:"+x+", Y:"+y+",Z: "+z);
                    if(input.get(x) + input.get(y) + input.get(z) == 2020){
                        return input.get(x) * input.get(y) * input.get(z);
                    }
                }
            }
        }
        return 0;
    }
}
