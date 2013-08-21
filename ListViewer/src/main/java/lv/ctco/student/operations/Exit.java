package lv.ctco.student.operations;

import lv.ctco.student.Operation;
import lv.ctco.student.Operations;

import java.util.List;

public class Exit implements Operations {
    @Override
    public String getOperation() {
        return Operation.EXIT.name();
    }

    @Override
    public Object doOperation(List<String> values) {
        if (values.size() > 1) System.exit(0);
        return null;
    }
}