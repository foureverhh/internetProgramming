package URLSamples;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://nackademin.se/utbildningar-kurser/?category=it");
        System.out.println("Protocol is: "+url.getProtocol());
        System.out.println("Host is: "+url.getHost());
        System.out.println("Port is: "+url.getPort());
        System.out.println("Resource is: "+url.getFile());
        System.out.println("Relative Path is: "+url.getPort());
        System.out.println("Ref 锚点： "+url.getRef());
        System.out.println("Query 参数: "+url.getQuery());
    }
}
