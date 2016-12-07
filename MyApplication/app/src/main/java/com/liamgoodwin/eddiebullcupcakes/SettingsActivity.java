package com.liamgoodwin.eddiebullcupcakes;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.util.DisplayMetrics;
import android.widget.Toast;

import java.util.Locale;

public class SettingsActivity extends PreferenceActivity {

    Locale myLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                    Toast.makeText(getApplicationContext(), "Locale in English!", Toast.LENGTH_LONG).show();
                    break;

                case "fr":
                    setLocale("fr");
                    Toast.makeText(getApplicationContext(), "Locale in French!", Toast.LENGTH_LONG).show();
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
        Intent refresh = new Intent(this, SettingsActivity.class);
        finish();
        startActivity(refresh);
    }
}

