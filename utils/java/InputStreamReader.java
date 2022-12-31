package utils.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class InputStreamReader extends Reader {
    private final java.io.InputStreamReader streamReader;

    public InputStreamReader(InputStream in) throws IOException {
        String filePath = getClass().getClassLoader()
                .getResource(System.getProperty("sun.java.command").replaceAll("\\.", "/") + ".txt").getFile();

        FileInputStream fileInputStream = new FileInputStream(getAbsoluteResourceFile(filePath));
        streamReader = new java.io.InputStreamReader(fileInputStream);
    }

    private File getAbsoluteResourceFile(String filePath) throws IOException {
        File file = new File(filePath);
        if(!file.exists()){
            file.createNewFile();
        }
        return file;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return streamReader.read(cbuf, off, len);
    }

    @Override
    public void close() throws IOException {
        streamReader.close();
    }
}
