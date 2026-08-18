package com.jesyai.comanderococina;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. PANTALLA SIEMPRE ENCENDIDA (para que no se apague en la cocina)
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        // 2. MODO PANTALLA COMPLETA (oculta barra de estado, navegación y marcos)
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

        setContentView(R.layout.activity_main);

        // 3. CONFIGURAR WEBVIEW Y COMPATIBILIDAD CON SUPABASE
        myWebView = findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();

        // Habilitar JavaScript (obligatorio para que la app de cocina funcione)
        webSettings.setJavaScriptEnabled(true);

        // Habilitar LocalStorage y almacenamiento en base de datos (para tokens/sesiones)
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);

        // Permite acceso a archivos de la app y peticiones de red
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);

        // Evita que los enlaces abran el navegador Chrome externo
        myWebView.setWebViewClient(new WebViewClient());

        // 4. CARGAR EL ARCHIVO index.html DE TU APP DE COCINA
        myWebView.loadUrl("file:///android_asset/index.html");
    }
}
