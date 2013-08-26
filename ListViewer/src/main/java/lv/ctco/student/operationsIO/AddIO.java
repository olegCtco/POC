package lv.ctco.student.operationsIO;

import lv.ctco.student.Checker;
import lv.ctco.student.OperationsIO;

import java.io.BufferedReader;
import java.io.IOException;

public class AddIO implements OperationsIO {
    private final Checker checker;
    private final String mnemonics;
    private final BufferedReader localBf;

    public AddIO(String mnemonics) {
        this.mnemonics = mnemonics;
        checker = new Checker();
        localBf = bf;
    }

    public String getMnemonics() {
        return mnemonics;
    }

    @Override
    public String[] doOperationIO() {
        String name;
        String surname;
        String university;
        String[] values = new String[4];
        try {
            do {
                System.out.println("Input name:");
                name = localBf.readLine();
            } while (checker.isEmptyString(name));
            values[0] = name;
            do {
                System.out.println("Input surname:");
                surname = localBf.readLine();
            } while (checker.isEmptyString(surname));
            values[1] = surname;
            do {
                System.out.println("Input university");
                university = localBf.readLine();
            } while (checker.isEmptyString(university));
            values[2] = university;
        } catch (IOException ignored) {
        }
        return values;
    }
}