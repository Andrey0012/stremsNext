import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestReduce {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(2);
        list.add(4);
        list.add(3);
        int result = list.stream().reduce((a, e) -> a*e).get();
        System.out.println(result);
        //5, 8, 2, 4 , 3
        //a = 5   40   80  320  960
        //e = 8    2    4   3

        // в данном случае значение ьудет точно не null  и поэтому метод get не используеться
        int result2 = list.stream().reduce(1,(a, e) -> a*e);
        System.out.println(result2);
        //5, 8, 2, 4 , 3
        //a = 1    5   40   80  320  960
        //e = 5    8    2    4   3

//расмотри случай с пустой коллекцией и созаданием стрима на пустую колекцию
        List<Integer> list1 = new ArrayList<>();
        Optional<Integer> result1 = list1.stream().reduce((a, e) -> a*e);
        if (result1.isPresent()) System.out.println(result1.get());
        else System.out.println("Not present");
// расмотрим сооедение строковых величин
        List<String> list2 = new ArrayList<>();
        list2.add("привет");
        list2.add("как дела?");
        list2.add("ok");
        list2.add("пока");
        String result4 = list2.stream().reduce((a,e)->a+ " "+ e).get();
        System.out.println(result4);

    }
}
