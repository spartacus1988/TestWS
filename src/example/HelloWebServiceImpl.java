package example;


// таже аннотация, что и при описании интерфейса,
import javax.jws.WebService;

import java.io.*;

// но здесь используется с параметром endpointInterface,
// указывающим полное имя класса интерфейса нашего веб-сервиса
@WebService(endpointInterface = "example.HelloWebServiceIntf")


public class HelloWebServiceImpl implements HelloWebServiceIntf
{
    @Override
    public String getHelloString(String name)
    {
        // просто возвращаем приветствие
        return "Hello, " + name + "!";
    }




    @Override
    //целое неотрицательное число
    public String putUnsignedInteger(int number)
    {
        String tempStr = Integer.toString(number);

        try(FileOutputStream fosJournal = new FileOutputStream("$HOME/TempTestDir/Journal.txt"))
        {


            // перевод строки в байты
            byte[] buffer = tempStr.getBytes();

            fosJournal.write(buffer, 0, buffer.length);
        }
        catch(IOException ex)
        {
            //throw ex.getCause();
            System.out.println(ex.getMessage());
        }

        return "OK " + tempStr;
    }





    @Override
    //целое отрицательное число
    public String putSignedInteger(int number)
    {
        String tempStr = Integer.toString(number);

        try(FileOutputStream fosJournal = new FileOutputStream("$HOME/TempTestDir/Journal.txt"))
        {


            // перевод строки в байты
            byte[] buffer = tempStr.getBytes();

            fosJournal.write(buffer, 0, buffer.length);
        }
        catch(IOException ex)
        {
            //throw ex.getCause();
            System.out.println(ex.getMessage());
        }

        return "OK " + tempStr;
    }




    @Override
    //целое отрицательное число
    public String putFloat(float number)
    {
        String tempStr = Float.toString(number);

        try(FileOutputStream fosJournal = new FileOutputStream("$HOME/TempTestDir/Journal.txt"))
        {


            // перевод строки в байты
            byte[] buffer = tempStr.getBytes();

            fosJournal.write(buffer, 0, buffer.length);
        }
        catch(IOException ex)
        {
            //throw ex.getCause();
            System.out.println(ex.getMessage());
        }

        return "OK " + tempStr;
    }



    @Override
    public String putFile(String FileName)
    {

        try(FileInputStream fin = new FileInputStream(FileName);
            FileOutputStream fos = new FileOutputStream("$HOME/TempTestDir/Res.bin"))
        {
            byte[] buffer = new byte[fin.available()];
            // считываем буфер
            fin.read(buffer, 0, buffer.length);
            // записываем из буфера в файл
            fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex)
        {

            System.out.println(ex.getMessage());
        }


    }





 }


