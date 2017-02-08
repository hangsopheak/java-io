package com.rupp.io.jsonconvertor;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileToJavaObjectList {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        try {
            String jsonStringArray = IOUtils.toString(new FileInputStream("employees.json"), StandardCharsets.UTF_8);
            // System.out.println(jsonStringArray);
            final List<Employee> employees = Arrays.asList(mapper.readValue(jsonStringArray, Employee[].class));

            System.out.println(employees);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
