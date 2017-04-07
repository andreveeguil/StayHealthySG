package com.example.ajinkya.stayhealthysg;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

/**
 * Created by Idea pad on 04/04/2017.
 */

public class SettingsActivity extends PreferenceActivity{
    SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
    ListPreference myPref = (ListPreference) findPreference("font_list_value");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();

        myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                ListPreference lp = (ListPreference) findPreference("font_list_value");
                String currentValue = lp.getValue();
                SharedPreferences.Editor editor = sharedPref.edit();

                if(currentValue.equals("Small")){
                    editor.putString("FONT_SIZE", "Small");
                    editor.commit();
                }
                else if(currentValue.equals("Large")){
                    editor.putString("FONT_SIZE", "Large");
                    editor.commit();
                }
                else{
                    editor.putString("FONT_SIZE", "Medium");
                    editor.commit();
                }
            }
        });
    }
}
