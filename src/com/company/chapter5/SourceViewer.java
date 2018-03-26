package com.company.chapter5;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * download web page
 */

public class SourceViewer {

    public static void main(String[] args) {
        String url = "https://www.oreilly.com";
        InputStream in = null;
        try {
            URL u = new URL(url);
            in = u.openStream();
            in = new BufferedInputStream(in);
            Reader r = new InputStreamReader(in);
            int c;
            while ((c = r.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (MalformedURLException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {

                }
            }
        }
    }
}
