package com.rupp.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WorkingWithFile {

    public static void main(String[] args) throws IOException {
        //String fileName = "/home/sophea/58.txt";
        // somewhere in your code - read content from a file
       // String content = new String(Files.readAllBytes(Paths.get(fileName)));
        //System.out.println(content);
        
        //To read a text file line by line into a List of type String structure you can use the Files.readAllLines method.
        //Files.readAllLines uses UTF-8 character encoding. It also ensures that file is closed after all bytes are read or in case an exception occurred
//        List<String> lines = Files.readAllLines(Paths.get(fileName));
//        for (String line : lines) {
//            System.out.println("------" + line);
//        }
        
        
        String input = FilesUtil.readTextFile("file.txt");
        System.out.println(input);
        FilesUtil.writeToTextFile("copy.txt", input);

        System.out.println(FilesUtil.readTextFile("copy.txt"));

        List<String> list = FilesUtil.readTextFileByLines("file.txt");
        Path path = Paths.get("file.txt");        
        System.out.println(path.toAbsolutePath().toString());
     
        FilesUtil.writeTextFile("newFile.txt", list);
        
        
    }
}
