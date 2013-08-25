package lv.ctco.student;

import lv.ctco.student.db.DBOperations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListViewer implements OperationsList {
    DBOperations dbOperations;
    Checker checker;
    private List<Student> resultList;
    private ConsoleIO consoleIO;
    private List<String> values;

    public ListViewer() {
        dbOperations = new DBOperations();
        resultList = new ArrayList<Student>();
        consoleIO = new ConsoleIO();
        checker = new Checker();

    }

    public boolean add(List<String> values) throws NullPointerException {
//        try{
        String name = values.get(0);
        String surname = values.get(1);
        String university = values.get(2);
        int idForStudent = StudentsList.idGenerator();
        if (name.isEmpty() || surname.isEmpty() || university.isEmpty())
            return false;
        Student student = new Student(name, surname, university, idForStudent);
        try {
            dbOperations.insert(name, surname, university);
            StudentsList.getStudentList().add(student);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean remove(String id) throws NullPointerException {
        List<Student> studentList = StudentsList.getStudentList();
        String idToRemove = id;
        if (id.isEmpty() || checker.notAnInteger(id)) {
            return false;
        }
        int intIdToRemove = Integer.parseInt(idToRemove);
        if (checker.outOfBound(studentList, intIdToRemove)) {
            return false;
        }
        for (int i = 0; i <= studentList.size(); i++) {
            if (studentList.get(i).getId() == intIdToRemove) {
                try {
                    dbOperations.delete(intIdToRemove);
                    studentList.remove(i);
                } catch (SQLException e) {
                    return false;
                }
                return true;
            }
        }

        return false;
    }

    public Student getStudentById(String id) throws NullPointerException {
        List<Student> studentList = StudentsList.getStudentList();
        if (id.isEmpty() || checker.notAnInteger(id) || studentList.isEmpty()) {
            return null;
        }
        int intIdToRemove = Integer.parseInt(id);
//        if (checker.outOfBound(studentList, intIdToRemove)) {
//            return null;
//        }

        for (Student student : studentList) {
            if (student.getId() == intIdToRemove) {
                return student;
            }
        }

        return null;
    }

    public boolean update(String id, String name, String surname, String university) throws NullPointerException {
        Student studentToChange = getStudentById(id);
        if (!studentToChange.equals(null)) {
            int idToChange = studentToChange.getId();
            try {
                dbOperations.update(idToChange, name, surname, university);
                studentToChange.setName(name);
                studentToChange.setSurname(surname);
                studentToChange.setUniversity(university);
                return true;
            } catch (SQLException ignored) {
            }
        }
        return false;
    }

    public List<Student> find(List<String> values) throws NullPointerException {
        String name = values.get(0);
        String surname = values.get(1);
        String university = values.get(2);
        List<Student> result = new ArrayList<Student>();
        if ((name.equals("") && surname.equals("") && university.equals(""))) return result;
        else
            for (Student student : StudentsList.getStudentList()) {
                if (name.equals("") && student.getSurname().equals(surname) && student.getUniversity().equals(university)) {
                    result.add(student);
                    continue;
                }
                if (student.getName().equals(name) && surname.equals("") && student.getUniversity().equals(university)) {
                    result.add(student);
                    continue;
                }
                if (student.getName().equals(name) && student.getSurname().equals(surname) && university.equals("")) {
                    result.add(student);
                    continue;
                }
                if (name.equals("") && surname.equals("") && student.getUniversity().equals(university)) {
                    result.add(student);
                    continue;
                }
                if (student.getName().equals(name) && surname.equals("") && university.equals("")) {
                    result.add(student);
                    continue;
                }
                if (name.equals("") && student.getSurname().equals(surname) && university.equals("")) {
                    result.add(student);
                    continue;
                }
                if (student.getName().equals(name) && student.getSurname().equals(surname) && student.getUniversity().equals(university)) {
                    result.add(student);
                    continue;
                }
            }
        StudentsList.getTmpList().clear();
        StudentsList.getTmpList().addAll(result);
        return result;
    }

    public void start() {
//        while (true) {
//        resultList = StudentsList.getStudentList();
//            values = consoleIO.readFromConsole();
//            String operation = values.get(0);
//            if (operation.equalsIgnoreCase(Operation.VIEW.name()))
//                new ViewIO().doOperationIO(resultList);
//            for (int i = 0; i < listOfOperations.size(); i++)
//                if (listOfOperations.get(i).getOperation().equalsIgnoreCase(operation))
//                    resultList = (List<Student>) listOfOperations.get(i).doOperation(values);
//            if (operation.equalsIgnoreCase("find") || operation.equalsIgnoreCase("sort"))
//                new ViewIO().doOperationIO(resultList);
    }
//    }
}