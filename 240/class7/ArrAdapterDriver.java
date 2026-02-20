package class7;
import java.util.Arrays;
import java.util.List;

public class ArrAdapterDriver {
    public static void main(String[] args) {
        String [] names = {"Alice", "Bob", "Charlie"};

        List<String> namesList = Arrays.asList(names);

        System.out.println(namesList);
    }

}
