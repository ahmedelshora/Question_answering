package arab;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
public class Seach {
    String str;
    String ur;
    BufferedReader input;
    String inputline;

    public String answer(String query) {
        try {
            String address = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
            String charset = "UTF-8";
            URL url = new URL(address + URLEncoder.encode(query, charset));
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    url.openStream()));
            str = in.readLine();
            int in1 = str.indexOf("\"unescapedUrl\":\"");
            int in2 = str.indexOf("\",\"url\":\"");
            ur = str.substring(in1 + 16, in2);
            System.out.println("the url is <<<<======>>>>" + ur + "\n");

            in.close();

        } catch (Exception e) {
        }
        return ur;

    }
}
