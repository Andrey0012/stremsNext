import java.util.ArrayList;
import java.util.List;

public class TestFlatMap {
    public static void main(String[] args) {
        Student std1 = new Student("Ivan", 'm', 25, 2, 5.5);
        Student std2 = new Student("Petr", 'm', 22, 1, 5.8);
        Student std3 = new Student("Elena", 'f', 23, 1, 5.4);
        Student std4 = new Student("Andrey", 'm', 22, 1, 5.5);
        Student std5 = new Student("Mariy", 'f', 24, 3, 4.8);
        Faculty f1 = new Faculty("Economics");
        Faculty f2 = new Faculty("Matematica");
        f1.addStudentToFaculty(std1);
        f1.addStudentToFaculty(std2);
        f1.addStudentToFaculty(std3);
        f2.addStudentToFaculty(std4);
        f2.addStudentToFaculty(std5);
        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(f1);
        facultyList.add(f2);
        facultyList.stream().flatMap(faculty -> faculty.getStudentsOnFaculty().stream())
                .forEach(student -> System.out.println(student.getName()));
    }
}
class Faculty {
    private String name;
    List<Student> studentsOnFaculty;

    public Faculty(String name) {
        this.name = name;
        studentsOnFaculty = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudentsOnFaculty() {
        return studentsOnFaculty;
    }
    public void addStudentToFaculty (Student student) {
        studentsOnFaculty.add(student);
    }
}
