package hr.unidu.kz.gradivniblokovi;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import hr.unidu.kz.gradivniblokovi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // View binding: Potrebno ako se koristi view binding
    private ActivityMainBinding bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // View binding: Referenca na komponente layouta
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        // View binding: Referenca na "korijen" komponente
        View view = bind.getRoot();
        // View binding: povezivanje s viewom
        setContentView(view);
        // Ako se ne koristi view binding - povezivanje s viewom
        /*
        setContentView(R.layout.activity_main);
         */
    }

    // Metoda prikazSlike je deklarativno navedena u XML datoteci aktivnosti uz
    // tipku PRIKAŽI SLIKU.
    public void prikazSlike(View v) {
        // View binding: Pristup komponentama
        bind.imageView.setImageResource(R.drawable.s2);
        // Pristup komponentama BEZ korištenja view bindinga
        /*
        ImageView iv = findViewById(R.id.imageView);
        iv.setImageResource(R.drawable.s2);
         */
    }

    public void prikazWeba(View v) {
        String url = "https://www.google.com/";
        // View binding: Pristup komponentama
        bind.webView.loadUrl(url);
        // Pristup komponentama BEZ korištenja view bindinga
        /*
        WebView webview = findViewById(R.id.webView);
        //webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(url);
         */


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
