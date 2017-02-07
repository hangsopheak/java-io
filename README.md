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

# Java System Properties
- JRE related system properties

java.home    JRE home directory, e.g., “C:\Program Files\Java\jdk1.7.0_09\jre”.
java.library.path   JRE library search path for search native libraries. It is usually but not necessarily taken from the environment variable PATH.
java.class.path JRE CLASSPATH, e.g., . (for current working directory).
java.ext.dirs   JRE extension library path(s), e.g, “C:\Program Files\Java\jdk1.7.0_09\jre\lib\ext;C:\Windows\Sun\Java\lib\ext”.
java.version    JRE version, e.g., 1.7.0_09.
java.runtime.version    JRE version, e.g. 1.7.0_09-b05.

- File related system properties

file.separator  symbol for file directory separator such as d:\test\test.java. The default is \ for windows or / for Unix/Mac.
path.separator  symbol for separating path entries, e.g., in PATH or CLASSPATH. The default is ; for windows or : for Unix/Mac.
line.separator  symbol for end-of-line (or new line). The default is “\r\n” for windows or “\n” for Unix/Mac OS X.

- User related system properties

user.name   the user’s name.
user.home   the user’s home directory.
user.dir    the user’s current working directory.

- OS related system properties

os.name the OS’s name, e.g., “Windows 7”.
os.version  the OS’s version, e.g., “6.1”.
os.arch the OS’s architecture, e.g., “x86”.
