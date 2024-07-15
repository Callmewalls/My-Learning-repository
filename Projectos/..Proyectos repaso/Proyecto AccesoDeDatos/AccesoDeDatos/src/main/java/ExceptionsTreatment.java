public class ExceptionsTreatment {
    public static void main(String[] args) {

        int number1 = 1;
        int number2 = 0;

        try
        {
            int number3 = number1 / number2;
            System.out.print(number3);
        }
        catch(Exception e)
        {
            System.out.println("This is getMessage():  \n" + "                   "  + e.getMessage());
            System.out.println("-------------------------------------------------------------------");
            System.out.println("This is getCause():   \n" + "                   "  + e.getCause());
            System.out.println("-------------------------------------------------------------------");
            System.out.println("This is toString():   \n" + "                   " + e.toString());
            System.out.println("-------------------------------------------------------------------");
            System.out.print("This is printStackTrace() and must be alone:   \n");
            System.out.print("                   " ); e.printStackTrace();
            System.out.println(e.fillInStackTrace());
            System.out.println("-------------------------------------------------------------------");
            System.out.println(e.getStackTrace());
            System.out.println("-------------------------------------------------------------------");
        }
        finally
        {

        }
    }
}
