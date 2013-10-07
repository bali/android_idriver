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

        MixpanelAPI mixpanelAPI = MixpanelAPI.getInstance(this, "e783771cfec7346 012345 0c057875dc7");
        MixpanelAPI.enableFallbackServer(this, true);

        final String DISTINCT_USER_ID = "driver-NYC1";
        mixpanelAPI.identify(DISTINCT_USER_ID);
        mixpanelAPI.getPeople().identify(DISTINCT_USER_ID);
        JSONObject properties = new JSONObject();
        try {
            properties.put("OS Driver ID", DISTINCT_USER_ID);
            mixpanelAPI.track("", properties);
            properties.put("$email", "harri.smatt@hailocab.com");
            mixpanelAPI.getPeople().set(properties);
        } catch (Exception ex) {
        }
        mixpanelAPI.flush();
    }

}
