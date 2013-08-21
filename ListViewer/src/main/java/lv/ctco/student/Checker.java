package lv.ctco.student;

import java.util.List;

public class Checker implements OperationsList {
    public boolean checkOperation(String operation) {
        for (int i = 0; i < listOfOperations.size(); i++)
            if (listOfOperations.get(i).getOperation().equalsIgnoreCase(operation)) return true;
        return false;
    }

    public boolean isEmptyString(String value) {
        try {
            if (value.equals("") || value.equals(null)) return true;
            return false;
        } catch (NullPointerException e) {
            return true;
        }
    }

    public boolean notAnInteger(String index) {
        try {
            Integer.parseInt(index);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public boolean outOfBound(List<Student> studentList, int id) {
        for(Student student: studentList) {
            if (student.getId() == id)
                return false;
        }
        return true;
    }

}