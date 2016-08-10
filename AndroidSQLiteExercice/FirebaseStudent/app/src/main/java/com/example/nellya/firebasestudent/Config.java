package com.example.nellya.firebasestudent;

import android.app.Application;

import com.firebase.client.Firebase;

    public class Config extends Application {
        @Override
        public void onCreate() {
            super.onCreate();
            Firebase.setAndroidContext(this);
        }
    }

