import java.util.Arrays;

public class TestForEach {
    public static void main(String[] args) {
        int [] array = {5, 4 , 8 , 9, 6};
        Arrays.stream(array).forEach(element -> {
            element*=2;
            System.out.println(element);
        });
        Arrays.stream(array).forEach(e-> System.out.println(e));
        Arrays.stream(array).forEach(System.out::println);
        Arrays.stream(array).forEach(Utils::myMethod);
    }
}
class Utils {
    public static void myMethod (int a){
         a+=5;
        System.out.println("Element = " + a);

    }
}
