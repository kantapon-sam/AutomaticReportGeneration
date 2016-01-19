package com.java.myapp;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            Process p = Runtime.getRuntime().exec(new String[]{"cmd", "/c", "FTYPE"});
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                if (line.contains("chrome.exe") || line.contains("Chrome.exe")) {
                    count++;
                }
            }
            if (count == 0) {
                GoogleChrome();
                System.exit(0);
            }
            p = Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start chrome.exe " + login});
            login();
        } catch (UnknownHostException ex) {
            NoLAN();
            System.exit(0);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
