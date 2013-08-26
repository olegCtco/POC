package lv.ctco.student;

import java.util.ArrayList;
import java.util.List;

public class StudentsList {
    private static final List<Student> studentList = new ArrayList<>();
    private static final List<Student> tmpList = new ArrayList<>();
    private static int id = 1;

    public static List<Student> getTmpList() {
        return tmpList;
    }

    public static List<Student> getStudentList() {
        return studentList;
    }

    public static int idGenerator() {
        return id++;
    }

    public static void setId(int id1) {
        id = ++id1;
    }
}