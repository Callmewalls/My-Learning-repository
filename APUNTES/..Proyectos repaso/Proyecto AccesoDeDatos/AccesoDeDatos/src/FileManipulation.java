import sun.rmi.runtime.Log;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileManipulation {

    public static void main(String[] args) {

        Scanner kbd = new Scanner(System.in);
        int choice = 0;
        File file = new File("TestFile.txt");

        File origin = new File("TestFile.txt");
        File destiny = new File("TestingFolder\\TestFile.txt");
        System.out.println("What do you want to do?: \n1. Create file \n2. Delete file \n3. Move file \n4. Move back \n5. Restart");

        while(choice == 0)
        {
            choice = kbd.nextInt();
            try
            {
                switch(choice)
                {
                    case 1: if(!file.exists())
                            {
                                file.createNewFile();
                                System.out.println("TestFile created!!!!");
                                break;
                            }
                            else
                            {
                                System.out.println("TestFile is already created");
                                break;
                            }
                    case 2: file.delete();
                            System.out.println("TestFile deleted!!!!");
                            break;
                    case 3: if(origin.renameTo(destiny))
                            {
                                System.out.println("File moved!!!");
                                break;
                            }
                            else
                            {
                                System.out.println("File couldn't be moved!!!");
                                break;
                            }
                    case 4:  if(destiny.renameTo(origin))
                            {
                                System.out.println("File moved!!!");
                                break;
                            }
                            else
                            {
                                System.out.println("File couldn't be moved!!!");
                                break;
                            }
                    case 5: choice = 0;
                            break;
                }

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
