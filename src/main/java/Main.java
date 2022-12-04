import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // фильтрация
        List<Animal> animals = animalList().stream().filter(animal -> animal.getClassification()
                .equals(Classification.herbivores)).collect(Collectors.toList());
//        animals.forEach(System.out::println);
//        animalList().forEach(System.out::println);

        //сортиовка
        List<Animal> animals1 = animalList().stream().sorted(Comparator.comparing(Animal::getAge).thenComparing(Animal::getName))
                .collect(Collectors.toList());
 //       animals1.forEach(System.out::println);

        // если все старше 10
          boolean allMatch = animalList().stream().allMatch(animal -> animal.getAge()>10);
 //       System.out.println(allMatch);


        //если есть кто то старше 100
        boolean anyMatch = animalList().stream().anyMatch(animal -> animal.getAge()>100);
 //       System.out.println(anyMatch);

        //если нет совпадений
         boolean noneMatch = animalList().stream().noneMatch(animal -> animal.getName().equals("заячик"));
//        System.out.println(noneMatch);

        //  максимальное число по парметру
        /*
        animalList().stream().max(Comparator.comparing(Animal::getAge))
                .ifPresent(System.out::println);
        //  мимальное число по парметру
        animalList().stream().min(Comparator.comparing(Animal::getAge))
                .ifPresent(System.out::println);

         */

        //группировки
        /*
        Map<Classification, List<Animal>> collect = animals1.stream()
                .collect(Collectors.groupingBy(Animal::getClassification));
        collect.forEach((classification, animals2) -> {
            System.out.println(classification);
            animals2.forEach(System.out::println);
        });

         */

       animals1.stream().filter(animal -> animal.getClassification().equals(Classification.herbivores))
               .min(Comparator.comparing(Animal::getAge))
               .map(Animal::getName).ifPresent(System.out::println);



    }
    private static List<Animal> animalList () {
        return List.of(
                new Animal("слон", 25, Classification.herbivores),
                new Animal("тигр", 2, Classification.herbivores),
                new Animal("волк", 45, Classification.omnivores),
                new Animal("заяц", 68, Classification.omnivores),
                new Animal("черепаха", 5, Classification.predators),
                new Animal("дракон", 87, Classification.predators));
    }
}
