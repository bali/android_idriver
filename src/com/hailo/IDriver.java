// kopirait

package com.hailo;

import com.hailo.fragment.Driver5;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONObject;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

public class IDriver extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.idriver);

        getSupportFragmentManager().beginTransaction().replace(R.id.content, new Driver5(), "TESTING!").commit();

        // TODO: Clean me up later on
        MixpanelAPI mixpanelAPI = MixpanelAPI.getInstance(this, "e783771cfec73464151f00c057875dc7");
        MixpanelAPI.enableFallbackServer(this, true);

        final String DISTINCT_USER_ID = "e783771cfec73464151f00c057875dc7";
        mixpanelAPI.identify(DISTINCT_USER_ID);
        mixpanelAPI.getPeople().identify(DISTINCT_USER_ID);
        JSONObject properties = new JSONObject();
        try {
            properties.put("$email", "serensky@googlemail.com");
            properties.put("$first_name", "spam");
            properties.put("$last_name", "cristizmf@gmail.com");
            mixpanelAPI.track("", properties);
            mixpanelAPI.getPeople().set(properties);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        mixpanelAPI.flush();
    }
}
