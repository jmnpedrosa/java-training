package factory.factorymethod;

/* 
 * The intent of the Factory Method pattern is to define an interface for creating an
 * object but let subclasses decide which class to instantiate. The Factory Method pattern
 * lets a class defer instantiation to its subclasses.
 */

interface App {
  void open(String filename);
}

class WordProcessor implements App {
  public void open(String filename) {
    System.out.println("Launch WordProcessor using " + filename);
  }
}

class TextEditor implements App {
  public void open(String filename) {
    System.out.println("Launch TextEditor using " + filename);
  }
}

abstract class AppFactory {
  public App getAppInstance() {
    App appln = getApp();
    return appln;
  }
  public abstract App getApp();
}

class WordAppFactory extends AppFactory {
  public App getApp() {
    return new WordProcessor();
  }
}

class TextEditAppFactory extends AppFactory {
  public App getApp() {
    return new TextEditor();
  }
}

class Client {
  public static void main(String args[]) {
    AppFactory factory = new WordAppFactory();
    App app = factory.getAppInstance();
    app.open("Hello.doc");
    app = new TextEditAppFactory().getAppInstance();
    app.open("Hello.xml");
  }
}