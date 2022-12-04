import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class TestMinMaxLimit {
    public static void main(String[] args) {
        Student std1 = new Student("Ivan", 'm', 25, 2, 5.5);
        Student std2 = new Student("Petr", 'm', 22, 1, 5.8);
        Student std3 = new Student("Elena", 'f', 23, 3, 5.4);
        Student std4 = new Student("Andrey", 'm', 22, 3, 5.5);
        Student std5 = new Student("Mariy", 'f', 24, 4, 4.8);
        List<Student> students = new ArrayList<>();
        students.add(std1);
        students.add(std2);
        students.add(std3);
        students.add(std4);
        students.add(std5);
        //максимальное число
        Student min = students.stream().min((x, y) -> x.getAge() - y.getAge()).get();
        Student max = students.stream().max((x, y) -> x.getAge() - y.getAge()).get();
      //  System.out.println(min +"\n" + max);
        //limit выводит только первые два еэелмента
        students.stream().filter(student -> student.getAge()>22).limit(2).forEach(System.out::println);
        System.out.println();
        //skip не пропускает первые два елемента
        students.stream().filter(student -> student.getAge()>22).skip(1).forEach(System.out::println);
        System.out.println();
        //mapToInt возвращант после себя не прсто стрим а int стрим, обязательно использовать метод boxed()
        // что бы перевести из int  в Integer имеет нескольео методов -sum, average(среднее арифмит), min, max
        List<Integer> integerList = students.stream().mapToInt(s -> s.getCourse())
                .boxed()
                .collect(Collectors.toList());
        System.out.println(integerList);

        int sum = students.stream().mapToInt(s -> s.getCourse()).sum();
        System.out.println(sum);
        double asDouble = students.stream().mapToDouble(s -> s.getCourse()).average().getAsDouble();
        System.out.println(asDouble);
        int asInt = students.stream().mapToInt(d -> d.getCourse()).max().getAsInt();
        System.out.println(asInt);
        int asInt1 = students.stream().mapToInt(d -> d.getCourse()).min().getAsInt();
        System.out.println(asInt1);

    }
}
