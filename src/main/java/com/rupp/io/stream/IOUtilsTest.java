/***/
package com.rupp.io.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.rupp.io.WorkingWithFile;

/**
 * @author Sophea <a href='mailto:smak@dminc.com'> sophea </a>
 * @version $id$ - $Revision$
 * @date 2017
 */
public class IOUtilsTest {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
      //We can create an InputStream object from a String as follows
       InputStream in=IOUtils.toInputStream("This is a String","utf-8");

       //write file
       //FilesUtil.writeFile("fileIo.txt", in);
       IOUtils.write(IOUtils.toByteArray(in), new FileOutputStream("fileIo.txt"));
       //or
       //IOUtils.copy(in, new FileOutputStream("fileIo.txt"));
       System.out.println("write to file fileIo.txt successfully");
       
      //We can convert a Reader object to a String using IOUtils.toString(Reader r) as below
        FileReader fileReader = new FileReader("fileIo.txt");
        String st = IOUtils.toString(fileReader);
        System.out.println("readfile fileIo.txt :" + st);
    
       
       
      //We write lines from a collection to a Writer object as follows
        Writer swr=new StringWriter();
        List<String> ls = IOUtils.readLines(new FileInputStream("out.txt"), "utf-8");
        IOUtils.writeLines(ls, IOUtils.LINE_SEPARATOR, swr);
        
        
        //load resource as string
        //final InputStream resourceAsStream = WorkingWithFile.class.getResourceAsStream("config.properties");
        final InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
        System.out.println(IOUtils.toString(resourceAsStream, Charset.defaultCharset()));
        
        
    }

    
}
