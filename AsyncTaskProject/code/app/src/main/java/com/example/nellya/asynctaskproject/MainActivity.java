package com.example.nellya.asynctaskproject;

import java.lang.Void;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.util.Log;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ProgressBar myProgressBar;
    private Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myProgressBar = (ProgressBar) findViewById(R.id.myProgressBar);
        myButton = (Button) findViewById(R.id.myButton);


        myButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                AfficheImage affich=new AfficheImage();
                affich.execute();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class AfficheImage extends AsyncTask<Void, Integer, Void>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getApplicationContext(), "Début du chargement de l'image", Toast.LENGTH_LONG).show();

        }

        @Override
        protected void onProgressUpdate(Integer... values){
            super.onProgressUpdate(values);
            // Mise à jour de la ProgressBar
            ImageView image;
            myProgressBar.setProgress(values[0]);
            image = (ImageView) findViewById(R.id.imageView);

        }

        @Override
        protected Void doInBackground(Void... arg0) {

            int progress;
            for (progress=0;progress<=100;progress++)
            {
                for (int i=0; i<1000000; i++){}
                //la méthode publishProgress met à jour l'interface en invoquant la méthode onProgressUpdate
                publishProgress(progress);
                progress++;
                downloadImage();
                }
            return null;
        }

    private Bitmap downloadImage() {
        try {
            Bitmap bitmap = null;
            URL url = new URL("https://github.com/nellyamaylis/M4SAndroidCourse/blob/master/AsyncTaskProject/images.png");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new Exception("Failed to connect");
            }
            InputStream is = con.getInputStream();
            publishProgress(0);
            Bitmap bitmap1 = BitmapFactory.decodeStream(is);
            is.close();
            return bitmap1;
        } catch (Exception e) {
            Log.e("Image", "Failed to load image", e);
            Log.e("error", e.getMessage());
        }
        return null;
    }
        @Override
        protected void onPostExecute(Void result) {
            Toast.makeText(getApplicationContext(), "Le chargement de l'image est terminé", Toast.LENGTH_LONG).show();
        }
    }
}
