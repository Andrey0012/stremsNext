import java.util.ArrayList;
import java.util.List;

public class TestParallelStream {
    public static void main(String[] args) {
        List<Double> doubles = new ArrayList<>();
        doubles.add(10.0);
        doubles.add(5.0);
        doubles.add(1.0);
        doubles.add(0.25);
        Double aDouble = doubles.stream().reduce((x, y) -> x + y).get();
        System.out.println(aDouble);
        Double aDouble1 = doubles.parallelStream().reduce((x, y) -> x + y).get();
        System.out.println(aDouble1);
        System.out.println();

        // парральные стримы можно использовать только когда порялдок не имеет значения

        Double aDouble2 = doubles.stream().reduce((x, y) -> x / y).get();
        System.out.println(aDouble2);
        Double aDouble3 = doubles.parallelStream().reduce((x, y) -> x / y).get();
        System.out.println(aDouble3);


    }
}
