import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestCollection {
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

        Map<Integer, List<Student>>  map =students.stream().map(student -> {
            student.setName(student.getName().toUpperCase());
            return student;
        }).collect(Collectors.groupingBy(course-> course.getCourse()));
        for (Map.Entry<Integer,List<Student>> ent : map.entrySet()) {
            System.out.println(ent.getKey() +": " + ent.getValue().toString());
        }

        Map<Boolean, List<Student>> booleanListMap = students.stream()
                .collect(Collectors.partitioningBy(grade -> grade.getAvgGrade() < 5));
        for (Map.Entry <Boolean, List<Student>> entry: booleanListMap.entrySet()) {
            System.out.println(entry.getKey() + " :" + entry.getValue());
        }

    }
}
