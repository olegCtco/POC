package lv.ctco.student;

import java.util.ArrayList;
import java.util.List;

public class StudentsList {
    private static List<Student> studentList = new ArrayList<Student>();
//    private static List<Student> studentList ;
    private static List<Student> tmpList = new ArrayList<Student>();

    public static List<Student> getTmpList() {
        return tmpList;
    }
//    private static List<Student> studentList;

    public static List<Student> getStudentList() {
        return studentList;
    }
}