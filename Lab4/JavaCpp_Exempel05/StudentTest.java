/*
  StudentTest.java
  Topic: use of interface Comparable

*/

public class StudentTest {

    void compareAndPrint(Student stud1, Student stud2) {

        if(stud1.compareTo(stud2)==0) // Student is a Comparable
            System.out.println(stud1 + " lika med " + stud2);
        else if(stud1.compareTo(stud2)<0)
            System.out.println(stud1 + " mindre �n " + stud2);
        else
            System.out.println(stud1 + " st�rre �n " + stud2);
    }

    public static void main (String args[]) {

        Student s1 = new Student("Pelle Plugg","890413-8213");
        Student s2 = new Student("Nisse N�rd","900313-8117");
        Student s3 = new Student("Sandra Skarp","870202-8243");
        Student s4 = new Student("Pelle Plugg","890413-8213");

        StudentTest test = new StudentTest();
        test.compareAndPrint(s1,s2);
        test.compareAndPrint(s1,s3);
        test.compareAndPrint(s1,s4);
        test.compareAndPrint(s2,s3);
        test.compareAndPrint(s2,s4);
        test.compareAndPrint(s3,s4);
    }
}


/*
 Utskrifter:

 Pelle Plugg, 890413-8213 mindre �n Nisse N�rd, 900313-8117
 Pelle Plugg, 890413-8213 st�rre �n Sandra Skarp, 870202-8243
 Pelle Plugg, 890413-8213 lika med Pelle Plugg, 890413-8213
 Nisse N�rd, 900313-8117 st�rre �n Sandra Skarp, 870202-8243
 Nisse N�rd, 900313-8117 st�rre �n Pelle Plugg, 890413-8213
 Sandra Skarp, 870202-8243 mindre �n Pelle Plugg, 890413-8213
*/