package com.java.myapp;

import java.awt.Desktop;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;

public class URLConnection extends Dialog {

    private int Error = 0;

    public void CheckConnection(String web, String line, int lineNumber) {
        setLineNumber(lineNumber);
        try {
            URL url = new URL(web);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            int statusCode = http.getResponseCode();
            if (statusCode == 200) {
                System.out.println(line.split(",")[0]);
            }
        } catch (UnknownHostException ex) {
            LineURLError();
            Error++;
            System.exit(0);
        } catch (MalformedURLException | RuntimeException ex) {
            URLError();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public int getError() {
        return Error;
    }

    public void Login(URI login) {
        try {
            URL url = new URL(login.toString());
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            int statusCode = http.getResponseCode();
            Desktop d = Desktop.getDesktop();
            d.browse(login);
            login();
        } catch (UnknownHostException ex) {
            NoLAN();
            System.exit(0);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void Login(String httpnocweb02cactiportalLoginaspx) {

    }

}
