package com.rupp.io.jsonconvertor;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaObjectToJson {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String [] args){
        Employee employee = new Employee("Sophea", "Mak", 35, "Phnom Penh");
        try {
            // Convert object to JSON string and pretty print
            String employeeAsPrettyString = mapper.writeValueAsString(employee);
            System.out.println("Pretty Printing JSON");
            System.out.println(employeeAsPrettyString);

            // Convert Object To JSON and Saving to file
            System.out.println("\nCreating File");
            mapper.writeValue(new File("employee.json"), employee);
            System.out.println("\nFile Created in the Directory");

            // Convert object to JSON string
            String employeeAsString = mapper.writeValueAsString(employee);
            System.out.println("\nPrinting JSON as String");
            System.out.println(employeeAsString);

            // no need to catch JsonProcessingException since JsonProcessingException extends IOException
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
