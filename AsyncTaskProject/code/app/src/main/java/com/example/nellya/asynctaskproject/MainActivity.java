package com.example.nellya.asynctaskproject;

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
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myButton = (Button) findViewById(R.id.myButton);


        myButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                new AfficheImage((ImageView) findViewById(R.id.imageView)).execute("https://raw.githubusercontent.com/nellyamaylis/M4SAndroidCourse/master/AsyncTaskProject/images.png");
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

    private class AfficheImage extends AsyncTask<String, Integer, Bitmap>
    {
        ImageView imageV;
        public AfficheImage(ImageView imageV){
            this.imageV = imageV;
            Toast.makeText(getApplicationContext(), "Début du chargement de l'image", Toast.LENGTH_LONG).show();

        }

        @Override
        protected Bitmap doInBackground(String... arg0) {
            Bitmap bitmap0 = null;
        try {

            URL url = new URL("https://raw.githubusercontent.com/nellyamaylis/M4SAndroidCourse/master/AsyncTaskProject/images.png");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new Exception("Failed to connect");
            }
            InputStream is = con.getInputStream();
             bitmap0 = BitmapFactory.decodeStream(is);
            is.close();
            return bitmap0;
        } catch (Exception e) {
            Log.e("Image", "Failed to load image", e);
            Log.e("error", e.getMessage());
        }
        return bitmap0;
    }
        @Override
        protected void onPostExecute(Bitmap result) {
            Toast.makeText(getApplicationContext(), "Le chargement de l'image est terminé", Toast.LENGTH_LONG).show();
            imageV.setImageBitmap(result);
        }
    }
}
