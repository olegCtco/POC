package lv.ctco.student.studentsComparators;

import lv.ctco.student.Student;

import java.util.Comparator;

public class ComparatorByName implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (!(o1 instanceof Student) || !(o2 instanceof Student)) return -1;
        String o1StudentName = ((Student) o1).getName();
        String o2StudentName = ((Student) o2).getName();
        int sComp = o1StudentName.compareTo(o2StudentName);
        if (sComp != 0) return sComp;
        else {
            String o1StudentSurname = ((Student) o1).getSurname();
            String o2StudentSurname = ((Student) o2).getSurname();
            sComp = o1StudentSurname.compareTo(o2StudentSurname);
            if (sComp != 0) return sComp;
            else {
                String o1StudentUniversity = ((Student) o1).getUniversity();
                String o2StudentUniversity = ((Student) o2).getUniversity();
                return o1StudentUniversity.compareTo(o2StudentUniversity);
            }
        }
    }
}