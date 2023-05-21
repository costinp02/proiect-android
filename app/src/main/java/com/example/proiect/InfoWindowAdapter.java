package com.example.proiect;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class InfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    private final View mWindow;
    private Context mContext;

    public InfoWindowAdapter(Context mContext) {
        this.mContext = mContext;
        this.mWindow = LayoutInflater.from(mContext).inflate(R.layout.info_window_layout, null);
    }

    private void renderWindowText(Marker marker, View view){
        String title = marker.getTitle();
        TextView textViewTitle = (TextView) view.findViewById(R.id.info_window_title);

        if(!title.equals("")){
//            Log.d("INFOWINDOW", title);
            textViewTitle.setText(title);
        }

        String snippet = marker.getSnippet();
        TextView textViewSnippet = (TextView) view.findViewById(R.id.info_window_snippet);

        if(!title.equals("")){
//            Log.d("INFOWINDOW", snippet);
            textViewSnippet.setText(snippet);
        }
    }

    @Nullable
    @Override
    public View getInfoContents(@NonNull Marker marker) {
        renderWindowText(marker, mWindow);
        return mWindow;
    }

    @Nullable
    @Override
    public View getInfoWindow(@NonNull Marker marker) {
        renderWindowText(marker, mWindow);
        return mWindow;
    }
}
