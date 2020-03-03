package hr.unidu.kz.gradivniblokovi;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Metoda prikazSlike je deklarativno navedena u XML datoteci aktivnosti uz
    // tipku PRIKAŽI SLIKU.
    public void prikazSlike(View v) {
        ImageView iv = findViewById(R.id.imageView);
        iv.setImageResource(R.drawable.s2);
    }

    public void prikazWeba(View v) {
        String url = "https://www.google.com/";
        WebView webview = findViewById(R.id.webView);
        //webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(url);


    }

    public void svirajGlazbu(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.bach);
        mp.start();
    }

    public void posaljiSms(View v){
        String broj = "1234567";
        String tekstPoruke = "Dobar dan, hocemo li na kavu?";
        // implicitna namjera - pokreće se standardna aplikacija za slanje poruka
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + broj));
        intent.putExtra("sms_body", tekstPoruke);
        startActivity(intent);
    }
}
