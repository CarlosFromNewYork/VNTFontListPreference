/*
 * Copyright (C) 2014-2015 Vanniktech - Niklas Baudy <http://vanniktech.de/Imprint>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vanniktech.vntfontlistpreference.sample;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_main);

        final TextView checkItOutOnGitHubTextView = (TextView) this.findViewById(R.id.check_it_out_on_github);
        checkItOutOnGitHubTextView.setMovementMethod(LinkMovementMethod.getInstance());
        checkItOutOnGitHubTextView.setText(Html.fromHtml(this.getString(R.string.check_it_out_on_github)));

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        final TextView fontTextView = (TextView) this.findViewById(R.id.font);
        final String font = sharedPreferences.getString(this.getString(R.string.preference_font_face), this.getString(R.string.font_face_default_value));
        fontTextView.setTypeface(Typeface.createFromAsset(this.getAssets(), font));

        final TextView fontTextView2 = (TextView) this.findViewById(R.id.font_2);
        final String font2 = sharedPreferences.getString("preference_font_face_2", "fonts_2/GNUTypeWriter.ttf");
        fontTextView2.setTypeface(Typeface.createFromAsset(this.getAssets(), font2));
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        this.getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        final int id = item.getItemId();

        if (id == R.id.action_settings) {
            this.startActivity(SettingsActivity.start(this));
        } else {
            return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
