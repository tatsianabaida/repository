package lesson8hw.task2;

public class Student {

    private String firstName;
    private String lastName;
    private int age;
    private double averageGrade;

    @Override
    public String toString() {
        return "\nStudent{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", averageGrade=" + averageGrade + '}';
    }

    public Student(String lastName, String firstName, int age, double averageGrade) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}
