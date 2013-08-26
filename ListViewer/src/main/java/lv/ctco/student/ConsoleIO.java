package lv.ctco.student;

import lv.ctco.student.operationsIO.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConsoleIO {
    private final BufferedReader bf;
    private final Checker checker = new Checker();
    private final List<OperationsIO> operationsIO;

    public ConsoleIO() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        bf = new BufferedReader(inputStreamReader);
        operationsIO = Arrays.asList(new AddIO(Operation.ADD.name()), new ExitIO(Operation.EXIT.name()), new RemoveIO(Operation.REMOVE.name()), new FindIO(Operation.FIND.name()), new SortIO(Operation.SORT.name()));
    }

    void menu() {
        System.out.println("Hi User" +
                "\n Choose what you want to do:" +
                "\n ADD    -> AddServlet student to list" +
                "\n REMOVE -> remove student form list" +
                "\n VIEW   -> View students list" +
                "\n FIND   -> FindServlet students" +
                "\n SORT   -> Sort students list" +
                "\n EXIT   -> Quit application");
    }

    @SuppressWarnings("UnusedDeclaration")
    public List<String> readFromConsole() {
        String operation;
        List<String> values = new ArrayList<>();
        String operationMnemonic;
        while (true) try {
            menu();
            operation = bf.readLine();
            values.add(operation);
            if (checker.checkOperation(operation)) {
                for (OperationsIO anOperationsIO : operationsIO) {
                    operationMnemonic = anOperationsIO.getMnemonics();
                    if (operationMnemonic.equalsIgnoreCase(operation)) {
                        String[] returnedValues = anOperationsIO.doOperationIO();
                        if (returnedValues != null) {
                            Collections.addAll(values, returnedValues);
                        }
                    }
                }
            } else if (operation.equalsIgnoreCase(Operation.VIEW.name())) {
                return values;
            } else {
                System.out.println("No such command!!!");
            }
            return values;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}