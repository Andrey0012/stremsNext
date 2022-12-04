import java.util.stream.Stream;

public class TestConcatDistinctCountPeek {
    public static void main(String[] args) {

        // использование метода concat склеивает два стрима
        Stream<Integer> stream = Stream.of(1,2,3,4,5);
        Stream<Integer> stream1 = Stream.of(6,7,8,9,10);
        Stream<Integer> stream3 = Stream.concat(stream1, stream);
        stream3.forEach(System.out::println);
    //вывовод униакльных занчение
        Stream<Integer> stream4 = Stream.of(1,2,3,1,2,3);
        stream4.distinct().forEach(System.out::println);

        //сколько элементов содердит стрим метод count
        //НЕЛЬЗЯ переиспользовать стримы
        System.out.println(stream4.count());
        System.out.println(stream4.distinct().count());

        //метод peek это аналог forEach но это не терминальный метод а Промежуточный

        System.out.println(stream4.distinct().peek(System.out::println).count());

    }
}
