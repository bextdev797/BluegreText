package com.brandonang.bluegre;

import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import android.content.Context;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.view.View;

public class Bluegre extends AndroidNonvisibleComponent {
    private Context context;

    public Bluegre(ComponentContainer container) {
        super(container.$form());
        this.context = container.$context();
    }

    @SimpleFunction
    public void CreateBluegreText(AndroidViewComponent layout, String text){
        View view = layout.getView();
        WebView webView = new WebView(this.context);
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n");
        html.append("<html>\n");
        html.append("<head>\n");
        html.append("<style>\n");
        html.append(".blue { color: blue; }\n");
        html.append(".green { color: green; }\n");
        html.append("</style>\n"); 
        html.append("</head>\n");
        html.append("<body>\n");
        char[] characterArray = text.toCharArray();
        for (int i = 0; i < characterArray.length; i++) {
            if(i % 2 == 0){
                html.append("<span class=\"blue\">" + characterArray[i] + "</span>");
            } else{
                html.append("<span class=\"green\">" + characterArray[i] + "</span>");
            }
        }
        html.append("</body>\n"); 
        html.append("</html>\n");
        webView.loadDataWithBaseURL("", html.toString(), "text/html", "UTF-8", ""); 
        FrameLayout frameLayout = (FrameLayout) view;
        frameLayout.addView(webView);
    }
}
