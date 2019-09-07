package URLSamples;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import static java.nio.charset.StandardCharsets.UTF_8;

/*
* 获取资源：源代码
* */
public class URLDemo02 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com:80");

        /*有乱码
        //Get resource
        InputStream is = url.openStream();
        byte[] buffer = new byte[1024];
        int load = 0;
        while(-1 != (load = is.read(buffer))){
            System.out.println(new String(buffer,0,load,UTF_8));
        }
        is.close();
        */

        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"),UTF_8));
        String line = null;
        while (null!=(line = reader.readLine())){
            writer.write(line);
            writer.newLine();
        }
        writer.flush();
        writer.close();
        reader.close();
    }
}
