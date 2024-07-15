import java.io.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;

public class Streams {

    File file = new File("TestStream.txt");

    // ========================= ByteBuffer ============================================
    public void bufferByte() throws IOException {
        int bufferSize = 4 * 1024;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        String message = "Hola Mundo!";

            try
            {
                bos = new BufferedOutputStream(new FileOutputStream("src/test/java/BufferTest.bin"), bufferSize);
                bis = new BufferedInputStream(new FileInputStream("src/test/java/BufferTest.bin"), bufferSize);

                bos.write(message.getBytes(StandardCharsets.UTF_8));
                bos.flush();

                int info;
                info = bis.read();

                while(info != -1){
                    System.out.print(((char) info));
                    info = bis.read();
                }
                System.out.println("");

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                if(bos != null)
                {
                    bos.close();
                }
                if(bis != null)
                {
                    bis.close();
                }
            }
    }
    // ========================= CharBuffer ============================================
    public void bufferChar()
    {
        BufferedReader br;
        BufferedWriter bw;
        String message = "Hola Mundo 2!";

        try
        {
            bw = new BufferedWriter(new FileWriter("src/test/java/BufferTest.txt"));
            bw.write(message);
            bw.flush();
            bw.close();

            br = new BufferedReader(new FileReader("src/test/java/BufferTest.txt"));
            int info;
            do
            {
                info = br.read();
                System.out.print((char) info);
            }while(info != -1);
            System.out.println("");
            br.close();
        }  catch (IOException e) {e.printStackTrace();}
    }
    // ========================= PipedByteStreams ============================================
    public void pipedByteStream()
    {
        try
        {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);
            String message = "Hola mundo 3!";

            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run()
                {
                    try
                    {
                        pos.write(message.getBytes());
                        pos.flush();
                        pos.close();
                    }
                    catch (IOException e) {e.printStackTrace();}
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run()
                {
                    try
                    {
                        int info;
                        do
                        {
                           info = pis.read();
                            System.out.print((char) info);
                        }while(info != -1);
                        pis.close();
                        System.out.println("");
                    }
                    catch (IOException e) {e.printStackTrace();}
                }
            });
            thread1.start();
            thread2.start();
        }
        catch (IOException e) {e.printStackTrace();}
    }
    // ========================= PipedCharStreams ============================================
    public void pipedCharStream()
    {
        try
        {
            PipedWriter pw = new PipedWriter();
            PipedReader pr = new PipedReader(pw);
            String message = "Hola mundo 4!";

            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run()
                {
                    try
                    {
                        pw.write(message);
                        pw.flush();
                        pw.close();
                    }
                    catch (IOException e) {e.printStackTrace();}
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run()
                {
                    try
                    {
                        int info;
                        do
                        {
                            info = pr.read();
                            System.out.print((char) info);
                        }while(info != -1);
                        pr.close();
                        System.out.println();
                    }
                    catch (IOException e) {e.printStackTrace();}
                }
            });
            thread1.start();
            thread2.start();
        }
        catch (IOException e) {e.printStackTrace();}
    }
    // ========================= CharArray ============================================
    public void charArray()
    {
        /*
        CharArrayWriter caw = new CharArrayWriter();
        caw.write("Hola Mundo 5!");
        FileWriter fw = new FileWriter("ruta.txt");
        caw.writeTo(fw);
        fw.close();
         */
        char[] chars = "Hola Mundo 5!".toCharArray();
        CharArrayReader car = new CharArrayReader(chars);

        int data;
        try {
            data = car.read();
            while(data != -1) {
                System.out.print((char)data);
                data = car.read();
            }
            System.out.println();
        } catch (IOException e) {e.printStackTrace();}
        car.close();
    }
    // ========================= PushBackReader ============================================
    public void pushBackReader()
    {
        try
        {
            PushbackReader pushbackReader = new PushbackReader(
                    new FileReader("src/test/java/pushBackReader.txt")
	        );
            int data = pushbackReader.read();
            System.out.print((char)data);
            System.out.println("   PushBackReader");
            pushbackReader.unread(data);
            data = pushbackReader.read();
            System.out.print((char)data);
            System.out.println("   PushBackReader");
            pushbackReader.close();
        }
        catch (IOException e) {e.printStackTrace();}
    }
    // ========================= StreamTokenizer ============================================
    public void streamTokenizer()
    {

        try {
            StreamTokenizer streamTokenizer = new StreamTokenizer(
                    new FileInputStream("src/test/java/streamTokenizer.txt"));
            streamTokenizer.eolIsSignificant(true);
            while(streamTokenizer.nextToken() != StreamTokenizer.TT_EOF)
            {
                if(streamTokenizer.ttype == StreamTokenizer.TT_WORD)
                {
                    System.out.print(streamTokenizer.sval);
                }
                else if(streamTokenizer.ttype == StreamTokenizer.TT_NUMBER)
                {
                    System.out.print(streamTokenizer.nval);
                }
                else if(streamTokenizer.ttype == StreamTokenizer.TT_EOL)
                {
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println("-----------------");
            System.out.println("-----------------");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    // ========================= LineNumberReader ============================================
    public void lineNumberReader()
    {
        try
        {
            LineNumberReader lineNumberReader =new LineNumberReader(
                    new FileReader("src/test/java/streamTokenizer.txt")
	);
            String line = lineNumberReader.readLine();
            while(line != null) {
                System.out.println("Contenido de la linea numero: " + lineNumberReader.getLineNumber());
                System.out.println(line);
                line = lineNumberReader.readLine();
            }
            lineNumberReader.close();
        }
        catch (IOException e) { e.printStackTrace();}
    }
    // ========================= DataIn/OutputStream ============================================
    public void dataStream()
    {
        try
        {
            DataOutputStream dos = new DataOutputStream(
                    new FileOutputStream("src/test/java/dataStream.bin")
	        );
            dos.write(222);
            dos.writeInt(123);
            dos.writeFloat(123.45F);
            dos.writeLong(789);
            dos.close();

            DataInputStream dis = new DataInputStream(
                    new FileInputStream("src/test/java/dataStream.bin")
	        );
            int aByte = dis.read();
            System.out.println(aByte);
            int anInt = dis.readInt();
            System.out.println(anInt);
            float aFloat = dis.readFloat();
            System.out.println(aFloat);
            long aDouble = dis.readLong();
            System.out.println(aDouble);
            dis.close();
        }
        catch(IOException e){e.printStackTrace();}
    }
}
