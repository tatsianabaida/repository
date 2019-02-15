package lesson8hw.task2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task2Demo {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Smith", "Jack", 23, 8.35));
        studentList.add(new Student("Williams", "Jenifer", 24, 8.98));
        studentList.add(new Student("Johnson", "Martin", 20, 8.55));
        studentList.add(new Student("Williams", "Alexis", 24, 7.61));

        System.out.println(":: The most progressive student :: " + getTheMostProgressive(studentList));

        studentList.sort(new StudentLastFirstNameComparator());
        System.out.println("\n:: Students list sorted by Last then First name :: " + studentList);

        studentList.sort(new StudentAgeComparator().thenComparing(new StudentLastFirstNameComparator()));
        System.out.println("\n:: Students list sorted by age then by last, first name :: " + studentList);

        studentList.sort(new StudentAverageGradeComparator());
        System.out.println("\n:: Students list sorted by performance :: " + studentList);
    }

    private static Student getTheMostProgressive(List<Student> list) {
        Iterator<Student> iterator = list.iterator();
        Student resultStudent = iterator.next();
        Student currentStudent;
        while (iterator.hasNext()) {
            currentStudent = iterator.next();
            if (currentStudent.getAverageGrade() > resultStudent.getAverageGrade()) {
                resultStudent = currentStudent;
            }
        }
        return resultStudent;
    }
}
