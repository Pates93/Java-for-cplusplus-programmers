/*
    Student.java
    Topic: equals and interface Comparable

*/

public class Student implements Comparable<Student> {
    public Student(String aName, String aPnr) {
        this.iName=aName;
        this.iPnr=aPnr;
    }

    public String getPnr(){return iPnr;}


    public String toString() {
        return iName+", "+iPnr;
    }

    public boolean equals(Object o) {
        Student s=(Student)o;  // Necessary typecast
                               // overrides Object.equals(Object o)
        boolean b=iPnr.equals(s.getPnr());
        return (b);
    }

    public int compareTo(Student s) { // generic
        int i=iPnr.compareTo(s.getPnr());
        return (i);
    }

    private String iName;
    private String iPnr;
}