public class mainTesting {
    public static void main(String[] args) {
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
