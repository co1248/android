package org.techtown.webpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import java.util.Stack;


public class MainActivity extends AppCompatActivity {

    Button button;
    WebView webView;
    EditText editText;
    Button backButton;
    Button forwardButton;

    public static Stack back = new Stack();
    public static Stack forward = new Stack();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        webView = findViewById(R.id.webView);
        button = findViewById(R.id.button);
        backButton = findViewById(R.id.backButton);
        forwardButton = findViewById(R.id.forwardButton);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(editText.getText().toString());
                back.push(editText.getText().toString());
                if(!forward.empty()) {
                    forward.clear();
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                webView.goBack();
                if(!back.empty()) {
                    forward.push(back.pop());
                }
                webView.loadUrl((String) back.peek());
            }
        });

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                webView.goForward();
                if(!forward.empty()) {
                    back.push(forward.pop());
                }
                webView.loadUrl(String.valueOf((String) back.peek()));
            }
        });

    }
}