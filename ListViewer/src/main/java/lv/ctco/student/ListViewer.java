package lv.ctco.student;

import java.util.ArrayList;
import java.util.List;

public class ListViewer implements OperationsList {
    private List<Student> resultList;
    private ConsoleIO consoleIO;
    private List<String> values;
    Checker checker;

    public ListViewer() {
        resultList = new ArrayList<Student>();
        consoleIO = new ConsoleIO();
        checker=new Checker();
    }
    public boolean add(List<String> values) throws NullPointerException{
//        try{
            String name = values.get(0);
            String surname = values.get(1);
            String university = values.get(2);
            if(name.isEmpty()||surname.isEmpty()||university.isEmpty())
                return false;
            Student student = new Student(name, surname, university);
            StudentsList.getStudentList().add(student);
//        } catch (NullPointerException ex) {
//            return false;
//        }
        return true;
    }

    public boolean remove(int index) throws NullPointerException{
        try {
            List<Student> studentList = StudentsList.getStudentList();
            int indexDelete = index - 1;
            if (!checker.outOfBound(studentList, indexDelete)) {
                StudentsList.getStudentList().remove(indexDelete);
            } else {
                return false;
            }
        } catch (NullPointerException ex) {
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public List<Student> find(List<String> values) throws NullPointerException{
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