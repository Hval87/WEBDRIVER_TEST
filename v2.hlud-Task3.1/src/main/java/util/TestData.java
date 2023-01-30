package util;

import java.util.List;
import java.util.Objects;

public class TestData {
    private int stringLenght;
    private List<User> users;

    public TestData() {
    }

    public TestData(int stringLenght, List<User> users) {
        this.stringLenght = stringLenght;
        this.users = users;
    }

    public int getStringLenght() {
        return stringLenght;
    }

    public void setStringLenght(int stringLenght) {
        this.stringLenght = stringLenght;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestData testData = (TestData) o;
        return Objects.equals(users, testData.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    @Override
    public String toString() {
        return "TestData{" +
                "stringLenght=" + stringLenght +
                ", users=" + users +
                '}';
    }
}
