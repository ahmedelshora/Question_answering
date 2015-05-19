package com.mkyong;

import arab.Seach;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import javax.swing.text.html.parser.DTD;

public class Myclass {

    public static void main(String[] args) throws IOException {
        String address = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
        String query = "ما هو طول الزرافة ";
        String charset = "UTF-8";
        BufferedWriter bfw ;
        File page=new File("D:\\index.html");
        if (!page.exists()) {
            page.createNewFile();
        }

        URL url = new URL(address + URLEncoder.encode(query, charset));

        BufferedReader in = new BufferedReader(new InputStreamReader(
                url.openStream()));
        String str = in.readLine();
        System.out.println("all links : "+str);
        int in1 = str.indexOf("\"unescapedUrl\":\"");
        int in2 = str.indexOf("\",\"url\":\"");
        String ur = str.substring(in1 + 16, in2);
        System.out.println("the url is <<<<======>>>>" + ur + "\n");

        URL oracle = new URL(ur);
        BufferedReader input = new BufferedReader(
                new InputStreamReader(oracle.openStream()));
        
        String inputline;
        bfw=new BufferedWriter(new FileWriter(page));
        while((inputline=input.readLine())!=null){
            
            bfw.write(inputline);
            System.out.println(inputline+"\n");
        }
        System.out.println(inputline);
        bfw.flush();
        in.close();
        input.close();
    }
}
