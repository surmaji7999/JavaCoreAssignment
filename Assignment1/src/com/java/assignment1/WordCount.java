package com.java.assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WordCount {

    public static void main(String[] args) throws IOException {  
        HashMap<String, Integer> hasmap1 = new HashMap<String, Integer>();
       HashMap<String,Integer> finalHasMap= new HashMap<String,Integer>(); 
        BufferedReader reader1=null;
        BufferedReader reader2=null;
        String url=null;
        String word=null;
        String[] urlList=new String[3];
        
        
        try {
            reader1= new BufferedReader(new FileReader("url.txt"));
            reader2= new BufferedReader(new FileReader("word.txt"));
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        }
        
//   for reading and urls     
        while((url=reader1.readLine())!=null) {
         urlList=url.split(",");
    }
        
//        for reading words from file
        while((word=reader2.readLine())!=null) {
            String words[]=word.split(",");
            for(int i=0; i<words.length;i++) {
                hasmap1.put(words[i],0); 
                finalHasMap.put(words[i],0);
            }
       }
         
        
        for(String urls:urlList) {
            int count=0;
             Document doc=null;
             doc = Jsoup.connect(urls).get();
             String pageData = doc.body().text();
             String title = doc.title();
             String urldata []= pageData.split(" ");
             for(Entry<String, Integer> entry: hasmap1.entrySet()) {
             for(int i=0;i<urldata.length;i++) {
                 if(entry.getKey().equals(urldata[i])) {
                     count++;
                 }
                
                
             }
             hasmap1.put(entry.getKey(),count);
             }
             
      
             //sort files 
             System.out.println(title);
             Set<Entry<String,Integer>> entries = hasmap1.entrySet();
             ArrayList<Entry<String,Integer>> arr = new ArrayList<>(entries);
             Collections.sort(arr,(e1,e2)->{
                 return e2.getValue()-e1.getValue();
             });
             for(int i=0;i<3;i++) {
             System.out.println(arr.get(i));
              entries.getClass();
             }
             
//             merge hasmap1 to finalhasmap
             hasmap1.forEach((key, value) -> finalHasMap.merge(key, value, (v1, v2) -> v1+v2));
        }   
//        sort finalHashmap
            System.out.println("Total of all files");
            Set<Entry<String,Integer>> entries = finalHasMap.entrySet();
            ArrayList<Entry<String,Integer>> arr = new ArrayList<>(entries);
            Collections.sort(arr,(e1,e2)->{
                return e2.getValue()-e1.getValue();
            });
            for(int i=0;i<arr.size();i++) {
            System.out.println(arr.get(i));
             entries.getClass();
            
            }
       
    }

}
