import java.util.Properties;

public class ClasspathChecker {
  public static void main(String[] args) {
    Properties properties = System.getProperties();
    String classPath = properties.getProperty("java.class.path");
    System.out.println("Classpath is: " + classPath);
  }
}
