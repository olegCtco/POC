package lv.ctco.student;

import java.util.ArrayList;
import java.util.List;

public class ListViewer implements OperationsList {
    Checker checker;
    private List<Student> resultList;
    private ConsoleIO consoleIO;
    private List<String> values;

    public ListViewer() {
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
        StudentsList.getStudentList().add(student);
//        } catch (NullPointerException ex) {
//            return false;
//        }
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
                studentList.remove(i);
                return true;
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