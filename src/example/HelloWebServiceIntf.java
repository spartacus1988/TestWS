

package example;


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;




@WebService()

// говорим, что веб-сервис будет использоваться для вызова методов
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface HelloWebServiceIntf {
    // говорим, что этот метод можно вызывать удаленно
    @WebMethod
    public String getHelloString(String name);

    @WebMethod
    //целое неотрицательное число
    public String putUnsignedInteger(int number);

    @WebMethod
    //целое отрицательное число
    public String putSignedInteger(int number);

    @WebMethod
    //число с плавающей точкой
    public String putFloat(float number);

    @WebMethod
    //бинарныe данные  файла с именем FileName
    public String putFile(byte[] MassOfByte, String FileName, String PosNumber);

    @WebMethod
    public String putParam(String ParamName, String ParamValue, String PosNumber);

    @WebMethod
    public String putCodeParam(String ParamType, String ParamValue, String ParamUnits, String ParamQuality, String PosNumber);

}
