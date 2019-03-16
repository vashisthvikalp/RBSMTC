package com.example.vikalpvashisth.rbsmtc;

import android.app.Activity;
import android.app.DownloadManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class UniversityResult extends AppCompatActivity {
    WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_result);

        //WebView webView = (WebView)findViewById(R.id.webView);

        //webView.getSettings().setJavaScriptEnabled(true);
        // load AKTU One View URL
        //webView.loadUrl("https://erp.aktu.ac.in/WebPages/OneView/OneView.aspx");

        // find the WebView by name in the main.xml of step 2
        browser = (WebView) findViewById(R.id.webView);

        // Enable javascript
        browser.getSettings().setJavaScriptEnabled(true);

        // Set WebView client
        browser.setWebChromeClient(new WebChromeClient());

        browser.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        // Load the webpage
        browser.loadUrl("https://erp.aktu.ac.in/WebPages/OneView/OneView.aspx");


        browser.setDownloadListener(new DownloadListener() {

            @Override
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                DownloadManager.Request request = new DownloadManager.Request(
                        Uri.parse(url));

                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); //Notify client once download is completed!
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Name of your downloadble file goes here, example: Mathematics II ");
                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);
                Toast.makeText(getApplicationContext(), "Downloading File", //To notify the Client that the file is being downloaded
                        Toast.LENGTH_LONG).show();

            }
        });

    }
}
