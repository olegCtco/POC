package lv.ctco.student.operations;

import lv.ctco.student.Operation;
import lv.ctco.student.Operations;
import lv.ctco.student.Student;
import lv.ctco.student.StudentsList;
import lv.ctco.student.studentsComparators.ComparatorByName;
import lv.ctco.student.studentsComparators.ComparatorBySurname;
import lv.ctco.student.studentsComparators.ComparatorByUniversity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort implements Operations {
    @Override
    public String getOperation() {
        return Operation.SORT.name();
    }

    @Override
    public List<Student> doOperation(List<String> values) {
        String choice = values.get(0);
//        String surname = values.get(2);
//        String university = values.get(3);
        List<Student> result = new ArrayList<Student>(StudentsList.getStudentList());
        StudentsList.getTmpList().clear();
//        if (!name.equalsIgnoreCase("Y") && !surname.equalsIgnoreCase("Y") && !university.equalsIgnoreCase("Y")) {
//            return result;
//        }
        if (choice.equalsIgnoreCase("name")) {
            Collections.sort(result, new ComparatorByName());
            StudentsList.getTmpList().addAll(result);
            return result;
        }
        if (choice.equalsIgnoreCase("surname")) {
            Collections.sort(result, new ComparatorBySurname());
            StudentsList.getTmpList().addAll(result);
            return result;
        }
        if (choice.equalsIgnoreCase("university")) {
            Collections.sort(result, new ComparatorByUniversity());
            StudentsList.getTmpList().addAll(result);
            return result;
        }
        return null;
    }
}