/***/
package com.rupp.io.jsonconvertor;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Sophea <a href='mailto:smak@dminc.com'> sophea </a>
 * @version $id$ - $Revision$
 * @date 2017
 */
public class JsonToJavaObject {
    private static ObjectMapper mapper = new ObjectMapper(); 
    
    public static void main(String [] args){ 
      try { 
            // Converting JSON string from file to Object
            Employee employee = mapper.readValue(new File("employee.json"), Employee.class);
            System.out.println(employee);
            // Converting JSON string to Object
            String jsonString = "{\"firstName\":\"Kurt\",\"lastName\":\"Angle\",\"age\":38,\"address\":\"Las Vegas\"}";
            Employee employee2 = mapper.readValue(jsonString, Employee.class);
            System.out.println(employee2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
}
