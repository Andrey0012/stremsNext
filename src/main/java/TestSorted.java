import java.util.Arrays;

public class TestSorted {
    public static void main(String[] args) {
        int[]array = {3, 8, 12, 1 , 5 , 8 ,55 , 66};
        array = Arrays.stream(array).sorted().toArray();
        System.out.println(Arrays.toString(array));
    }
}
