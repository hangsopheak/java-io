package com.rupp.io;

import java.io.FileInputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class ParseStudentTest {

    public static void main(String[] args) throws Exception {
        //read file student.txt
        //List<String> list = FilesUtil.readTextFileByLines("student.txt");
        List<String> list = IOUtils.readLines(new FileInputStream("student.txt"), "utf-8");
        int i =0;
        for (String item : list) {
            
            //id;name;score;subject
            String array[] = item.split(";"); //spilt into array by ;
            //skip header
            if (i++>0) {
                Student stu = new Student();
                stu.setId(Long.parseLong(array[0]));
                stu.setName(array[1]);
                stu.setScore(Double.parseDouble(array[2]));
                stu.setSubject(array[3]);
                System.out.println(String.format("%d - %s",stu.getId(),stu.getName()) );
            }
        }

    }

}
