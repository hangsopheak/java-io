# java-io
Java IO

#IOUtils
```
maven dependency:

 <dependency>
      <groupId>commons-io</groupId>
      <artifactId>commons-io</artifactId>
      <version>2.5</version>
  </dependency>
  

//We can create an InputStream object from a String as follows
InputStream is=IOUtils.toInputStream("This is a String","utf-8");

//We can copy the contents of an InputStream object to an OutputStream object as follows
OutputStream o=new FileOutputStream("abc.txt");
int bytes=IOUtils.copy(is, o);
out.println("File Written with "+bytes+" bytes");
IOUtils.closeQuietly(o);

//We can convert a Reader object to a String using IOUtils.toString(Reader r) as below
FileReader fr3=new FileReader("abc.txt");
String st=IOUtils.toString(fr3);

//We can get the contents of an InputStream as a byte array as below
FileInputStream fin=new FileInputStream("abc.txt");
byte[] buf=new byte[100]
int len=IOUtils.read(fin,buf);
out.println("The Length of Input Stream : "+len);


//We can get the contents of an InputStream as a list of Strings as below
FileInputStream fin=new FileInputStream("abc.txt");
List ls=IOUtils.readLines(fin,"utf-8");

//We write lines from a collection to a Writer object as follows
Writer swr=new StringWriter();
IOUtils.writeLines(ls, IOUtils.LINE_SEPARATOR_WINDOWS, swr);   

//We can get the LineIterator for an InputStream as below
FileInputStream fin=new FileInputStream("D:\\Java_Workspace\\IOUtilsExample\\abc.txt");
LineIterator lt=IOUtils.lineIterator(fin, "utf-8");
while(lt.hasNext())
{
       String line=lt.nextLine();
       //Perform the Regular Processing with the String
}
//When you are done you have to close either the LineIterator object
lt.close();
//or the InputStream / Reader object.



```

#Load Resource as Stream
```
//load resource as string
//final InputStream resourceAsStream = WorkingWithFile.class.getResourceAsStream("config.properties");
final InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
System.out.println(IOUtils.toString(resourceAsStream, Charset.defaultCharset()));
```
