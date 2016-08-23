package com.example.nellya.stateslistproject;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.location.Criteria;
import android.location.LocationManager;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

        public MainActivityFragment() {
        }
        private LocationManager stateLocationManager;
        public static String getBestProvider(LocationManager locationManager){
            Criteria criteria = new Criteria();
            criteria.setAccuracy(Criteria.ACCURACY_COARSE);
            criteria.setPowerRequirement(Criteria.POWER_LOW);
            criteria.setCostAllowed(true);
            return locationManager.getBestProvider(criteria,true);
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            String[] state = {"Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"};
            List<String> states = new ArrayList<String>(Arrays.asList(state));

            ArrayAdapter<String> stateAdapter = new ArrayAdapter<String>(getActivity(),
                    R.layout.listviewitem,
                    R.id.textviewitem,
                    states);

            ListView lv = (ListView) rootView.findViewById(R.id.StateslistView);
            lv.setAdapter(stateAdapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0){
                      Log.i("Hello","Click on New york to see it on the map");
                        Toast.makeText(getActivity(), "Click on New york to see it on the map ", Toast.LENGTH_LONG).show();
                    }
                    else if (position <= 30) {
                        Log.i("Hello","Click on New york to see it on the map");
                        Toast.makeText(getActivity(), "Click on New york to see it on the map ", Toast.LENGTH_LONG).show();
                    }
                    else if (position == 31) {
                        Intent intent = new Intent(getActivity(), MapsActivity.class);
                        startActivity(intent);
                    }
                    else if (position >= 32) {
                        Log.i("Hello","Click on New york to see it on the map");
                        Toast.makeText(getActivity(), "Click on New york to see it on the map ", Toast.LENGTH_LONG).show();
                    }
                }
            });
            return rootView;
        }

}




