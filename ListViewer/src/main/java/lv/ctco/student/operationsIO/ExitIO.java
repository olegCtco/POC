package lv.ctco.student.operationsIO;

import lv.ctco.student.Operation;
import lv.ctco.student.OperationsIO;

import java.io.BufferedReader;
import java.io.IOException;

public class ExitIO implements OperationsIO {
    private final String mnemonics;
    private final BufferedReader localBf;

    public ExitIO(String mnemonics) {
        this.mnemonics = mnemonics;
        localBf = bf;
    }

    public String getMnemonics() {
        return mnemonics;
    }

    @Override
    public String[] doOperationIO() {
        String[] exit = new String[1];
        while (true) try {
            System.out.println("Are you sure you want exit?('Y' if yes)");
            String choice = localBf.readLine();
            if (choice.equalsIgnoreCase("Y")) {
                exit[0] = Operation.EXIT.name();
                return exit;
            } else return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}