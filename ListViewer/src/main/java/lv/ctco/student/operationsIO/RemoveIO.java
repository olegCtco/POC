package lv.ctco.student.operationsIO;

import lv.ctco.student.Checker;
import lv.ctco.student.OperationsIO;

import java.io.BufferedReader;
import java.io.IOException;

public class RemoveIO implements OperationsIO {
    private final Checker checker;
    private final BufferedReader localBf;
    private final String mnemonics;

    public RemoveIO(String mnemonics) {
        checker = new Checker();
        this.mnemonics = mnemonics;
        localBf = bf;
    }

    @Override
    public String[] doOperationIO() {
        String[] deleteItemIndex = new String[1];
        System.out.println("Input number of element, what you want to delete:");
        try {
            while (true) {
                deleteItemIndex[0] = localBf.readLine();
                if (checker.notAnInteger(deleteItemIndex[0])) {
                    System.out.println("Input correct number");
                    deleteItemIndex[0] = "-1";
                } else break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deleteItemIndex;
    }

    @Override
    public String getMnemonics() {
        return mnemonics;
    }
}