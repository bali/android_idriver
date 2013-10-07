// kopirait

package com.hailo;

import com.hailo.fragment.Driver5;

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
    }

}
