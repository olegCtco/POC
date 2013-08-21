package lv.ctco.student.operationsIO;

import lv.ctco.student.OperationsIO;

import java.io.BufferedReader;
import java.io.IOException;

public class SortIO implements OperationsIO {
    BufferedReader localBf;
    private String mnemonics;

    public SortIO(String mnemonics) {
        this.mnemonics = mnemonics;
        localBf = bf;
    }

    public String getMnemonics() {
        return mnemonics;
    }

    @Override
    public String[] doOperationIO() {
        String name;
        String surname = "";
        String university = "";
        String[] values = new String[4];
        try {
            System.out.println("Are you want to sort by name? (Y if yes)");
            name = localBf.readLine();
            values[0] = name;
            if (name.equalsIgnoreCase("Y")) {
                values[1] = surname;
                values[2] = university;
                return values;
            }
            System.out.println("Are you want to sort by surname? (Y if yes)");
            surname = localBf.readLine();
            values[1] = surname;
            if (surname.equalsIgnoreCase("Y")) {
                values[2] = university;
                return values;
            }
            System.out.println("Are you want to sort by university? (Y if yes)");
            university = localBf.readLine();
            values[2] = university;
        } catch (IOException e) {
        }
        return values;
    }
}