package com.java.assignment5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class DeserializationTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("rnning");
       ArrayList<Student> studentList=new ArrayList<Student>();
       FileInputStream file=new FileInputStream("output1");
       ObjectInputStream objects=new ObjectInputStream(file);
       System.out.println("rnning");
       
//       for(int i=0;i<4;i++) {
       studentList=((ArrayList<Student>) objects.readObject());  
//       }
      System.out.println(studentList);
    }
}
