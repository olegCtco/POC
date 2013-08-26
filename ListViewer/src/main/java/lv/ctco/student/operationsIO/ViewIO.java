package lv.ctco.student.operationsIO;

import lv.ctco.student.Student;

import java.util.List;

@SuppressWarnings("UnusedDeclaration")
class ViewIO {
    public void doOperationIO(List<Student> studentList) {
        int id = 0;
        if (studentList.size() != 0) {
            for (Student aStudentList : studentList) {
                System.out.println(++id + ". " + aStudentList);
            }
        } else {
            System.out.println("Student list now is empty");
        }
    }
}