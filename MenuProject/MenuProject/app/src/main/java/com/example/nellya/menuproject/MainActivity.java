package com.example.nellya.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button sms = (Button) findViewById(R.id.sms);
        Button phone = (Button) findViewById(R.id.phone);
        Button web = (Button) findViewById(R.id.web);
        Button map = (Button) findViewById(R.id.map);
        Button share = (Button) findViewById(R.id.share);
        Button new_activity = (Button) findViewById(R.id.new_activity);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hi Nellya ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        sms.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final Intent sms = new Intent(Intent.ACTION_SENDTO);
                sms.setData(Uri.parse("smsto:"+ Uri.encode("00221781167745")));
                sms.putExtra("sms_body", "Nellya ZOHOUN");
                startActivity(sms);
            }


        });
        phone.setOnClickListener(new View.OnClickListener()

        {

            public void onClick(View view) {
                final Intent phone = new Intent(Intent.ACTION_DIAL);
                phone.setData(Uri.parse("tel:781167745"));
                startActivity(phone);
            }
        });

        web.setOnClickListener(new View.OnClickListener()

        {

            public void onClick(View view){
                final Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));

                startActivity(websiteIntent);
            }
        });

        map.setOnClickListener(new View.OnClickListener()

        {

            public void onClick(View view){
                String geoUri = String.format("geo:12.384480,-1.506944");
                Uri geo = Uri.parse(geoUri);
                Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);

                startActivity(geoMap);
            }
        });


        share.setOnClickListener(new View.OnClickListener()

        {

            public void onClick(View view) {
                final Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT,"MenuProject");
                share.putExtra(Intent.EXTRA_TEXT,"Join MenuProject");

                startActivity(Intent.createChooser(share, "Share the love"));
            }
        });

        new_activity.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                final Intent intent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(intent);
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
            Toast t = Toast.makeText(this , "Settings", Toast.LENGTH_SHORT);
            t.show();
            return true;
        }
        else if (id == R.id.action_help) {
            final Intent intent = new Intent(MainActivity.this, HelpActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
