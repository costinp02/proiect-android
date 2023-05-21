package com.example.proiect;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.proiect.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityMapsBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng bucharest = new LatLng(44.427525479353804, 26.10217379802539);
        LatLng location1 = new LatLng(44.42858614316653, 26.10430564827487);
        LatLng location2 = new LatLng(44.41971201741826, 26.137004344473837);
        LatLng location3 = new LatLng(44.444515319072, 26.09831616353506);

        Marker markerLocation1 = mMap.addMarker(new MarkerOptions().position(location1).title("Unirii").snippet("Piața Unirii 1, București 030119"));
        mMap.addMarker(new MarkerOptions().position(location2).title("Dristor").snippet("Șoseaua Mihai Bravu 307, București 030307"));
        mMap.addMarker(new MarkerOptions().position(location3).title("Romana").snippet("Bulevardul General Gheorghe Magheru 24A, București 010335"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bucharest));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(10));
        mMap.setInfoWindowAdapter(new InfoWindowAdapter(MapsActivity.this));
    }
}