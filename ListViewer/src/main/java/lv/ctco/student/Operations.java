package lv.ctco.student;

import java.util.List;

public interface Operations {
    public String getOperation();

    public Object doOperation(List<String> values);
}