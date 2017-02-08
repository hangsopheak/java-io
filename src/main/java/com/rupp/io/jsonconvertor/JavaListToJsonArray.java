package com.rupp.io.jsonconvertor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaListToJsonArray {
    private static ObjectMapper mapper = new ObjectMapper(); 

    public static void main(String [] args){ 
      Employee employee1 = new Employee("Sophea", "Mak", 35, "Phone Penh"); 
      Employee employee2 = new Employee("Kurt", "Angle", 38, "Las Vegas"); 
      try { 
        List<Employee> employees = new ArrayList<>(); 
        employees.add(employee1); 
        employees.add(employee2); 

        //write to json file
        mapper.writeValue(new FileOutputStream("employees.json"), employees);
        
        String jsonData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employees);
        System.out.println(jsonData);

        
      } catch (IOException e) { 
        e.printStackTrace(); 
      } 
    } 
}
