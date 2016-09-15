package example;

// класс, для запуска веб-сервера с веб-сервисами
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import java.net.URL;
import javax.xml.namespace.QName;

public class HelloWorld {


  public static void main(String[] argv) {
    // запускаем веб-сервер на порту 1986
    // и по адресу, указанному в первом аргументе,
    // запускаем веб-сервис, передаваемый во втором аргументе


   // Endpoint.publish("http://localhost:1986/wss/hello", new HelloWebServiceImpl());

    //Endpoint.publish("http://127.0.0.1:9876/ws", new HelloWebServiceImpl());


    Endpoint.publish("http://192.168.0.157:1986/ws", new HelloWebServiceImpl());



//    URL url = new URL("http://localhost:9876/hw?wsdl");
//    QName qname = new QName("http://thejavageek.com/", "HelloWorldServerImplService");
//    Service service = Service.create(url, qname);
//    HelloWebServiceIntf server = service.getPort(HelloWebServiceIntf.class);

  }
}



