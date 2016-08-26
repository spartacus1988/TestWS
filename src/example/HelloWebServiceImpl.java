package example;


// таже аннотация, что и при описании интерфейса,
import javax.jws.WebService;

import java.io.*;
import java.io.IOException;


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


        //FileOutputStream fosJournal = null;
        FileWriter writer = null;
        try
        {
            //fosJournal = new FileOutputStream("/Users/mihail/TempTestDir/Journal.rtf");
            writer = new FileWriter("/Users/mihail/TempTestDir/Journal.txt", true);

            // перевод строки в байты
            char[] buffer = tempStr.toCharArray();
           // byte[] buffer = tempStr.getBytes();

            //fosJournal.write(buffer, 0, buffer.length);
            writer.write(buffer, 0, buffer.length);
            writer.append("   UnsignedInteger value");
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex)
        {
            //throw ex.getCause();
            System.out.println(ex.getMessage());
        }
        finally
        {
            if (writer != null)
            {
               // writer.close();
            }
        }


        return "OK " + tempStr;
    }





    @Override
    //целое отрицательное число
    public String putSignedInteger(int number)
    {
        String tempStr = Integer.toString(number);


        FileWriter writer = null;
        //FileOutputStream fosJournal = null;
        try
        {
            //fosJournal = new FileOutputStream("/Users/mihail/TempTestDir/Journal.rtf");
            writer = new FileWriter("/Users/mihail/TempTestDir/Journal.txt", true);

            // перевод строки в байты
            char[] buffer = tempStr.toCharArray();
           // byte[] buffer = tempStr.getBytes();

            //fosJournal.write(buffer, 0, buffer.length);
            writer.write(buffer, 0, buffer.length);
            writer.append("   SignedInteger value");
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex)
        {
            //throw ex.getCause();
            System.out.println(ex.getMessage());
        }
        finally
        {
            if (writer != null)
            {
               // writer.close();
            }
        }

        return "OK " + tempStr;
    }




    @Override
    //число с плавающей точкой
    public String putFloat(float number)
    {
        String tempStr = Float.toString(number);


        //FileOutputStream fosJournal = null;
        FileWriter writer = null;

        try
        {
            //fosJournal = new FileOutputStream("/Users/mihail/TempTestDir/Journal.txt");
            writer = new FileWriter("/Users/mihail/TempTestDir/Journal.txt", true);

            // перевод строки в байты
            char[] buffer = tempStr.toCharArray();
            //byte[] buffer = tempStr.getBytes();

            //fosJournal.write(buffer, 0, buffer.length);
            //fosJournal.close();
            //fosJournal.
            writer.write(buffer, 0, buffer.length);
            writer.append("   float value");
            writer.append('\n');
            writer.flush();


        }
        catch(IOException ex)
        {
            //throw ex.getCause();
            System.out.println(ex.getMessage());
        }
        finally
        {
            if (writer != null)
            {
                //writer.close();
            }
        }

        return "OK " + tempStr;
    }



//    @Override
//    public void getBinary(byte[] b)
//    {
//        try
//        {
//            System.out.write(b);
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//    }


    @Override
    public String putFile(byte[] MassOfByte, String FileName )
    {

        long currentTime = System.currentTimeMillis();
        String curTime = Long.toString(currentTime);
        String FileNameExpansion = null;
        String FileNameCopy = null;
        FileWriter writer = null;

        int dotIdx = FileName.lastIndexOf(".");
        int lengthIdx = FileName.length();
        //int bslashIdx = FileName.lastIndexOf("/");
        int bslashIdx = FileName.lastIndexOf("\\");
        if (dotIdx != -1 && lengthIdx != -1 && bslashIdx != -1)
        {
             FileNameExpansion = FileName.substring(dotIdx, lengthIdx);
             FileNameCopy = FileName.substring(bslashIdx + 1, dotIdx);
        }



        //FileInputStream fin = null;
        FileOutputStream fos = null;

        try
        {
            writer = new FileWriter("/Users/mihail/TempTestDir/Journal.txt", true);

            // перевод строки в байты
            char[] buffer_ch = FileNameCopy.toCharArray();

            writer.write(buffer_ch, 0, buffer_ch.length);
            writer.append("   name of file");
            writer.append("   " + curTime);
            writer.append('\n');
            writer.flush();

            //fin = new FileInputStream(FileName);
            //fos = new FileOutputStream("/Users/mihail/TempTestDir/COPY_Res.jpg", true);
            fos = new FileOutputStream("/Users/mihail/TempTestDir/COPY_" + curTime + "_" + FileNameCopy + FileNameExpansion  , true);
            //printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("/Users/mihail/TempTestDir/COPY_Res.jpg", true), "UTF-8"));

            //определяем размер буфера
           // byte[] buffer = new byte[fin.available()];


            // считываем буфер
            //fin.read(MassOfByte, 0, MassOfByte.length);

            // записываем из буфера в файл
            fos.write(MassOfByte, 0, MassOfByte.length);


        }
        catch(IOException ex)
        {

            System.out.println(ex.getMessage());
        }
        finally
        {
//            if (fin != null)
//            {
//               // fin.close();
//            }

            if (fos != null)
            {
                //fos.close();
            }

        }


        return "OK ";

    }





 }


