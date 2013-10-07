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
        // TODO: Pairing failed
        mixpanelAPI.identify("HarriSmatt");
        mixpanelAPI.getPeople().identify("HarriSmatt");
        JSONObject properties = new JSONObject();
        try {
            properties.put("gender", "male");
            properties.put("age", 37);
            mixpanelAPI.track("we miss you jay", properties);
            properties.put("$email", "harism@gmail.com");
            properties.put("$first_name", "Harri");
            properties.put("$last_name", "Smatt");
            mixpanelAPI.getPeople().set(properties);
        } catch (Exception ex) {
        }
        mixpanelAPI.flush();
    }

}
