import java.util.*;
import java.util.stream.Collectors;

public class TestMAP {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("привет");
        list.add("как дела");
        list.add("ok");
        list.add("пока");
        //перевожу длину строки
        List<Integer> collect = list.stream().map(element -> element.length()).collect(Collectors.toList());
        System.out.println(collect);

        int [] array = {5, 9, 3, 8, 27, 7};
        array = Arrays.stream(array).map(
                element -> {
                    if (element%3==0) {
                        element=element/3;
                    }
                    return element;
                }
        ).toArray();
        System.out.println(Arrays.toString(array));

        Set<String> set = new TreeSet<>();
        set.add("привет");
        set.add("как дела");
        set.add("ok");
        set.add("пока");
        //перевожу длину строки
        Set<Integer> collect1 = set.stream().map(e -> e.length()).collect(Collectors.toSet());
        List<Integer> collect2 = set.stream().map(e -> e.length()).collect(Collectors.toList());

        System.out.println(collect1);
        System.out.println(collect2);

    }
}
