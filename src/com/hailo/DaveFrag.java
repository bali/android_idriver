// kopirait

package com.hailo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DaveFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View titlebarLayout = inflater.inflate(R.layout.titlebarrrr, null);
        ((TextView)titlebarLayout.findViewById(R.id.title)).setText("Hello Dave -->");
        ((ImageView)titlebarLayout.findViewById(R.id.icon)).setBackgroundColor(0xFF80FF10);
        ((TextView)titlebarLayout.findViewById(R.id.action)).setText("TEXT");
        return titlebarLayout;
    }

}
