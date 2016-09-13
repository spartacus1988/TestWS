


package Client;


import java.io.*;

// нужно, чтобы получить wsdl описание и через него
// дотянуться до самого веб-сервиса
        import java.net.URL;
// такой эксепшн возникнет при работе с объектом URL
        import java.net.MalformedURLException;

// классы, чтобы пропарсить xml-ку c wsdl описанием
// и дотянуться до тега service в нем
        import javax.xml.namespace.QName;
        import javax.xml.ws.Service;

// интерфейс нашего веб-сервиса (нам больше и нужно)
        import example.HelloWebServiceIntf;



public class HelloWebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        // создаем ссылку на wsdl описание
        URL url = new URL("http://192.168.0.157:1986/ws?wsdl");

        // Параметры следующего конструктора смотрим в самом первом теге WSDL описания - definitions
        // 1-ый аргумент смотрим в атрибуте targetNamespace
        // 2-ой аргумент смотрим в атрибуте name
        QName qname = new QName("http://example/", "HelloWebServiceImplService");

        // Теперь мы можем дотянуться до тега service в wsdl описании,
        Service service = Service.create(url, qname);
        // а далее и до вложенного в него тега port, чтобы
        // получить ссылку на удаленный от нас объект веб-сервиса
        HelloWebServiceIntf hello = service.getPort(HelloWebServiceIntf.class);

        // Ура! Теперь можно вызывать удаленный метод
        System.out.println(hello.getHelloString("Mihail"));



           // String FileName = "c:/11.txt";
            String FileName = "/Users/mihail/TempTestDir/Soap_Test_picture.jpg";

            FileInputStream fis = null;
            byte[] b = null;


           //File file = new File(FileName);


        try
        {
            fis = new FileInputStream(FileName);
            b = new byte[fis.available()];

            //прочитаем наш файл в байтовый массив
            fis.read(b, 0, b.length);
        }
        catch(IOException ex)
        {

            System.out.println(ex.getMessage());
        }

        hello.putFile(b, FileName, FileName);

//        hw.getBinary(b);//вызовем операцию web сервиса и передадим ему бинарные данные
//        //System.out.println(hw.sayHi("World"));
//        System.exit(0);



    }
}