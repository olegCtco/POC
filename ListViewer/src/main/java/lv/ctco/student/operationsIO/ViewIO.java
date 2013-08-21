package lv.ctco.student.operationsIO;

import lv.ctco.student.Student;

import java.util.List;

public class ViewIO {
    public void doOperationIO(List<Student> studentList) {
        int id = 0;
        if (studentList.size() != 0)
            for (int i = 0; i < studentList.size(); i++) System.out.println(++id + ". " + studentList.get(i));
        else System.out.println("Student list now is empty");
    }
}