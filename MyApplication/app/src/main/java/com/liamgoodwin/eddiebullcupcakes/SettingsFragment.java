package com.liamgoodwin.eddiebullcupcakes;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import java.util.Locale;

public class SettingsFragment extends PreferenceFragment {
    Locale myLocale;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        Preference langPreference = getPreferenceScreen().findPreference(
                "language");
        langPreference.setOnPreferenceChangeListener(languageChangeListener);
    }

    Preference.OnPreferenceChangeListener languageChangeListener = new Preference.OnPreferenceChangeListener() {

        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {

            switch (newValue.toString()) {
                case "en":
                    setLocale("en");
                    //Toast.makeText(getApplicationContext(), "Locale in English!", Toast.LENGTH_LONG).show();
                    break;

                case "fr":
                    setLocale("fr");
                    //Toast.makeText(getApplicationContext(), "Locale in French!", Toast.LENGTH_LONG).show();
                    break;
            }
            return false;
        }
    };

    //* manually changing current locale/
    public void setLocale(String lang) {
        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        //Intent refresh = new Intent(this, SettingsActivity.class);
        //finish();
        //startActivity(refresh);
    }
    }
