package com.rupp.io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.apache.commons.io.IOUtils;

/**
 * FilesUtil
 * 
 * @author Sophea <a href='mailto:smak@dminc.com'> sophea </a>
 * @version $id$ - $Revision$
 * @date 2016
 */
public class FilesUtil {
    private final static Charset UTF_8 = StandardCharsets.UTF_8;
    /**
     * 
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String readTextFile(String fileName) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        return content;
    }
    /**
     * @param fileName
     * @return
     * @throws IOException
     */
    public static List<String> readTextFileByLines(String fileName) throws IOException {
        //List<String> lines = Files.readAllLines(Paths.get(fileName));
        List<String> lines = Files.readAllLines(Paths.get(fileName), UTF_8);
        return lines;
    }

    /**
     * @param fileName
     * @param content
     * @throws IOException
     */
    public static void writeToTextFile(String fileName, String content) throws IOException {
        Files.write(Paths.get(fileName), content.getBytes(), StandardOpenOption.CREATE);
    }
    /**
     * @param aFileName
     * @param aLines
     * @throws IOException
     */
    public static void writeTextFile(String aFileName, List<String> aLines) throws IOException {
        Path path = Paths.get(aFileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path,  UTF_8)){
          for(String line : aLines){
            writer.write(line);
            writer.newLine();
          }
        }
      }

    /**/
    public static void writeFile(String fileName, InputStream in) throws IOException {
        IOUtils.write(IOUtils.toByteArray(in), new FileOutputStream(fileName));
    }

}
