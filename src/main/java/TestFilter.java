import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestFilter {
    public static void main(String[] args) {
        Student std1 = new Student("Ivan", 'm', 25, 2, 5.5);
        Student std2 = new Student("Petr", 'm', 22, 1, 5.8);
        Student std3 = new Student("Elena", 'f', 23, 1, 5.4);
        Student std4 = new Student("Andrey", 'm', 22, 1, 5.5);
        Student std5 = new Student("Mariy", 'f', 24, 3, 4.8);
        List<Student> students = new ArrayList<>();
        students.add(std1);
        students.add(std2);
        students.add(std3);
        students.add(std4);
        students.add(std5);
        //использование сортировки колекции
        students = students.stream().sorted(
                (x, y) -> x.getName().compareTo(y.getName())
        ).collect(Collectors.toList());
        // использование фильтара по параметрам
//        students = students.stream().filter(student -> student.getAge()>22 && student.getAvgGrade()>5)
//                .collect(Collectors.toList());
        System.out.println(students);
        // вариант создания стрима из стрима
        Stream<Student> studentStream = Stream.of(std1, std2, std3,std4,std5);
        studentStream.filter(student -> student.getAge()>22 && student.getAvgGrade()>5).collect(Collectors.toList());


    }

}

class Student {
    private String name;
    private char sex;
    private int age;
    private int course;
    private double avgGrade;

    public Student(String name, char sex, int age, int course, double avgGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", avgGrade=" + avgGrade +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }
}
