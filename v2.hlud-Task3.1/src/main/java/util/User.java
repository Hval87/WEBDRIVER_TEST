package util;

import java.util.Objects;

public class User {
    private String FirstName;
    private String LastName;
    private String email;
    private int age;
    private int salary;
    private String department;

    public User() {
    }
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                salary == user.salary &&
                Objects.equals(FirstName, user.FirstName) &&
                Objects.equals(LastName, user.LastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(department, user.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FirstName, LastName, email, age, salary, department);
    }

    @Override
    public String toString() {
        return "User{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
