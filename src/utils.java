import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Class containing utility class used across multiple classes
public class utils {
    //simple method to read Day_10_Input.txt to List<Integer>
    public static List<Integer> readInput(String path) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<Integer> result = new ArrayList<Integer>();
        while (scanner.hasNextInt()){
            result.add(scanner.nextInt());
        }
        return result;
    }
}
