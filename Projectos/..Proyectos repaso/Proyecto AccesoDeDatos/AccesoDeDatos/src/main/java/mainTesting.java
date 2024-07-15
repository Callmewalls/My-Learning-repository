import java.io.IOException;

public class mainTesting {
    public static void main(String[] args) throws IOException {
        Streams s = new Streams();

        s.bufferByte();
        s.bufferChar();
        //s.pipedByteStream();
        //s.pipedCharStream();
        s.charArray();
        s.pushBackReader();
        s.streamTokenizer();
        s.lineNumberReader();
        s.dataStream();
    }
}
