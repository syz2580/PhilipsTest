package com.showeasy.philiptest.view.colorpicker;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

import com.showeasy.philiptest.R;

/**
 * Created by 邵一哲_Native on 2016/11/7.
 */

public class Test extends PreferenceActivity {
    /** Called when the activity is first created. */
    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
        ((ColorPickerPreference)findPreference("color2")).setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {

            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                preference.setSummary(ColorPickerPreference.convertToARGB(Integer.valueOf(String.valueOf(newValue))));
                return true;
            }

        });
        ((ColorPickerPreference)findPreference("color2")).setAlphaSliderEnabled(true);
    }
}
