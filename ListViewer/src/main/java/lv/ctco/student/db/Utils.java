package lv.ctco.student.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Utils {
    public static List<String> parseToSql(String fileName) throws IOException {
        List<String> sqlQueries = new ArrayList<>();
        String line;
        String sqlString = "";
        FileReader sqlFile = new FileReader(fileName);
        BufferedReader br = new BufferedReader(sqlFile);
        while ((line = br.readLine()) != null) {
            sqlString += line;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(sqlString, ";");
        while (stringTokenizer.hasMoreTokens()) {
            sqlQueries.add(stringTokenizer.nextToken());
        }
        sqlFile.close();
        return sqlQueries;
    }
}