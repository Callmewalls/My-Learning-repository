import java.io.*;
import java.util.Scanner;

/**
 * @version 1.0
 * @author fernando
 */
public class FileManipulation {

    public static void main(String[] args) {

        Scanner kbd = new Scanner(System.in);
        int choice;

        File file = new File("TestFile.txt");
        String filePath;
        File origin = new File("TestFile.txt");
        File destiny = new File("TestingFolder\\TestFile.txt");

        do
        {
            System.out.println("What do you want to do?: \n1. Create file \n2. Delete file \n3. Move file \n4. Move back \n5.Write \n6.Read \n7. Exit");
            choice = kbd.nextInt();
            kbd.nextLine();

            try
            {
                switch(choice)
                {
                    case 1: // =============================================================================  file.createNewFile()
                            if(!file.exists()) // Creating a file in case it doesnt exists
                            {
                                file.createNewFile();
                                System.out.println("TestFile created!!!!");
                                break;
                            }
                            else // If it exists nothing happens
                            {
                                System.out.println("TestFile is already created");
                                break;
                            }
                    case 2: // =============================================================================  file.delete()
                            file.delete(); // Deleting the file
                            System.out.println("TestFile deleted!!!!");
                            break;
                    case 3: // =============================================================================  origin.renameTo(destiny)
                            if(origin.renameTo(destiny)) // Moving the file
                            {
                                System.out.println("File moved!!!");
                                break;
                            }
                            else  // Advising it couldnt be moved
                            {
                                System.out.println("File couldn't be moved!!!");
                                break;
                            }
                    case 4: // =============================================================================  destiny.renameTo(origin)
                            if(destiny.renameTo(origin)) // Getting the file back to the same path
                            {
                                System.out.println("File moved!!!");
                                break;
                            }
                            else
                            {
                                System.out.println("File couldn't be moved!!!");
                                break;
                            }
                    case 5: // =============================================================================  file.exists(), FileOutputStream.write()
                            if(file.exists())
                            {
                                filePath = file.getAbsolutePath();
                                FileOutputStream fos = new FileOutputStream(filePath);

                                System.out.println("Write the message: ");

                                String message = kbd.nextLine();
                                byte[] bytesArray = message.getBytes();

                                fos.write(bytesArray);
                                fos.close();
                                break;
                            }
                            else
                            {
                                System.out.println("file wasnt found");
                                break;
                            }


                    case 6: // =============================================================================  file.exists(), FileInputStream.read()
                            if(file.exists())
                            {
                                filePath = file.getAbsolutePath();
                                FileInputStream fis = new FileInputStream(filePath);
                                int i = 0;
                                while((i=fis.read())!=-1){
                                    System.out.print((char)i);
                                }
                                System.out.println("");
                                break;
                            }

                    case 7: choice = 0; // Leaving the loop
                            System.out.println("Leaving...");
                            break;
                }

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }while(choice != 0);
    }
}
