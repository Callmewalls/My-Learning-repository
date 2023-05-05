import sun.rmi.runtime.Log;

import java.io.File;
import java.io.IOException;

public class FileManipulation {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\fer_p\\OneDrive\\Desktop\\Fernando\\Informática\\APUNTES\\..Proyectos repaso\\Proyecto AccesoDeDatos\\TestFile.txt");

        try
        {
            file.createNewFile();
            System.out.println("TestFile created!!!!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }



}
