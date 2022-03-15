package com.java.assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;


// Comparator class for name compare 
class nameCompare implements Comparator<Employee>
{
    @Override
    public int compare(Employee employee1, Employee employee2)
    {
        return employee1.getName().compareTo(employee2.getName());
    }
}


//Comparator class for age compare 
class ageCompare implements Comparator<Employee>
{
    @Override
    public int compare(Employee employee1, Employee employee2)
    {
        return employee2.getAge() - employee1.getAge();
    }
}
//Comparator class for age compare in descending  
class reverseAgeCompare implements Comparator<Employee>
{
    @Override
    public int compare(Employee employee1, Employee employee2)
    {
        return employee1.getAge() - employee2.getAge();
    }
}


public class EmployeeRecords{
    
    //Method for display ArrayList
    public static void display(ArrayList<Employee> employee) {
        for(Employee records:employee) {
            System.out.println(records.getId()+","+records.getName()+","+records.getAge()+","+records.getEmail()+","+records.getDateofBirth());
            
        }
    }
    
  //Main method start 
    public static void main(String[] args) throws IOException {
        
        
        byte choice=0,option=0;
        int age, id=1,count=0;;
        String name, email, dateOfBirth;
        BufferedWriter writer1=null,writer2=null;
        BufferedReader reader1=null ;
        Scanner sc= new Scanner(System.in);
        ArrayList<Employee> employeeList=new ArrayList<Employee>();
        
        
        try {
         reader1= new BufferedReader(new FileReader("EmployeeRecords.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
         writer1=  new BufferedWriter(new FileWriter("EmployeeRecords.txt",true));
           
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        // Records are fatched from text file and inserted into array list
         String currentline =reader1.readLine();
         while(currentline!=null) {
             String employeeDetail []= currentline.split(",");
             int empId= Integer.valueOf(employeeDetail[0]);
             String empName=employeeDetail[1];
             int empAge= Integer.valueOf(employeeDetail[2]);
             String empEmail=employeeDetail[3];
             String empDOB=employeeDetail[4];
             Employee employee= new Employee();
             employee.setId(empId);
             employee.setName(empName);
             employee.setAge(empAge);
             employee.setEmail(empEmail);
             employee.setDateofBirth(empDOB);
             
             currentline=reader1.readLine();
             count=empId;
             id= count;
             employeeList.add(employee);
            }
      
         
         
        System.out.println("***Welcome to employee Mangement System***");
        System.out.println("------------------------------------------");
        
        do {
            System.out.println("Enter option");
            System.out.println("1. Add new record");
            System.out.println("2. Delete record");
            System.out.println("3. Search record");
            option=sc.nextByte();
            
            switch(option) {
            // case 1 for add new records in text file 
            case 1:
            try {
                System.out.println("Enter Employee name: ");
                name=sc.next();
                System.out.println("Enter employee age: ");
                age=sc.nextInt();
                System.out.println("Enter employee email: ");
                email=sc.next();
                System.out.println("Enter employee date of birth: ");
                dateOfBirth=sc.next();
                id++;
                writer1.write(id+","+name+","+age+","+email+","+dateOfBirth);
                writer1.newLine();
                writer1.flush();
                Employee employee= new Employee();
                employee.setId(id);
                employee.setName(name);
                employee.setAge(age);
                employee.setEmail(email);
                employee.setDateofBirth(dateOfBirth);
               employeeList.add(employee);
              
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InputMismatchException e) {
                e.printStackTrace();
            }
                break;
                
                //case 2 for delete records into text file 
            case 2:
              System.out.println("Enter id: ");
              int deleteId= sc.nextInt();
              for(Employee record:employeeList) {
                  if(record.getId()==deleteId) {
                      employeeList.remove(record);
                      break;
                  }
              }
              display(employeeList);
               
                break;
                
                //case 3 for searching 
            case 3:
                ArrayList<Employee> searchList=new ArrayList<Employee>();
                System.out.println("1 .Search by Name:");
                System.out.println("2. serch by Age:");
                byte choice1=0;
                try {
                choice1=sc.nextByte();
                } catch(InputMismatchException e) {
                    e.printStackTrace();
                }
                
                
              //Switch inside case 3 
                switch(choice1) {
                
                case 1:
                    System.out.println("Search by name");
                    String searchName=sc.next();
                  
                     for(Employee emp:employeeList) {
                        String name2 =emp.getName();
                        if(searchName.equals(name2)) {
                            searchList.add(emp);
                        }
                     }
                  display(searchList);
                    
               break;
               
                case 2:
                    System.out.println("Search by age");
                    int  searchAge=sc.nextInt();
                  
                     for(Employee emp:employeeList) {
                        int age2 =emp.getAge();
                        if(searchAge==age2) {
                            searchList.add(emp);
                        }
                     }
                     System.out.println("Shorting assending/dessending");
                     System.out.println("1. Assending order ");
                     System.out.println("2. Dessending order");
                     int sortingOrder2=sc.nextInt(); 
                     if(sortingOrder2==1) {
                         Collections.sort(searchList, new nameCompare());
                         display(searchList);
                     }
                     if(sortingOrder2==2) {
                         Collections.sort(searchList, new nameCompare());
                         display(searchList);   
                     }
                  
                     break;
                     default:
                         System.out.println("Please enter valid option ");
            }// inside case 3 switch end here  
                
                break;
            default :
                System.out.println("Enter valid option ");
                break;
              
            } // switch end here
            
            
           System.out.println("Are you want to continue press 1 && press 0 for exit ");
           try { choice=sc.nextByte();
           } catch (InputMismatchException e) {
               e.printStackTrace();
           }
          
           System.out.println("------------------------------------------");
        }while(choice ==1);
        
        //for write updated list 
       reader1.close();
       writer1.close();
       try {
           writer2=  new BufferedWriter(new FileWriter("EmployeeRecords.txt"));
             
          } catch (IOException e) {
              e.printStackTrace();
          }

       for(Employee employee:employeeList) {
       writer2.write(employee.getId()+","+employee.getName()+","+employee.getAge()+","+employee.getEmail()+","+employee.getDateofBirth());
       writer2.newLine();
       writer2.flush();
       
       }
       writer2.close();
    }

}
