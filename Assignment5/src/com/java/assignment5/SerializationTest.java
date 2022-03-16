package com.java.assignment5;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class SerializationTest  {

    public static void main(String[] args) throws Exception {
        Student student1=new Student("Abhishek","18/10/1999","indore","madhya pradesh",452020,"india");
        Student student2=new Student("Akash","25/12/1999","harda","madhya pradesh",461331,"india");
        Student student3=new Student("Yash","28/10/2000","indore","madhya pradesh",452120,"india");
        Student student4=new Student("Ayan","15/11/1998","indore","madhya pradesh",452220,"india");
        ArrayList<Student> studentList=new ArrayList<Student>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        FileOutputStream file1=new FileOutputStream("output2");
        ObjectOutputStream object=new ObjectOutputStream(file1);
//        for(Student records:studentList) {
            object.writeObject(studentList);
            object.flush();
           
//        }
        object.close();
        System.out.println("Serialization successfully....");

    }

}
