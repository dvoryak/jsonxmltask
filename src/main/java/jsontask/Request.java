package jsontask;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Request {
    private URL url;

    public Request(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void getJSON(String file) throws IOException {
        getJSON(new File(file));
    }

    public void getJSON(File file) throws IOException {
        if(!file.exists()) {
            file.createNewFile();
        }

        URLConnection connection = url.openConnection();

        try(FileOutputStream out = new FileOutputStream(file);
            InputStream in = connection.getInputStream()) {
            while(in.available() > 0) {
                out.write(in.read());
            }
        }

    }



}
