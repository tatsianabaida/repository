package lesson8hw.task2;

import java.util.Comparator;

public class StudentAverageGradeComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return Double.compare(student2.getAverageGrade(), student1.getAverageGrade());
    }
}
