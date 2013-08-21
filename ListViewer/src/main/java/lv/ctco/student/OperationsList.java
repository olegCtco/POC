package lv.ctco.student;

import lv.ctco.student.operations.Exit;
import lv.ctco.student.operations.Find;
import lv.ctco.student.operations.Remove;
import lv.ctco.student.operations.Sort;

import java.util.Arrays;
import java.util.List;

public interface OperationsList {
    List<Operations> listOfOperations = Arrays.asList(new Find(), new Remove(), new Sort(), new Exit());
}