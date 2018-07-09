package com.example.a16022706.p08_locatingaplace;

import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    TextView tvPlace,tvInfo;
    Button btn1, btn2, btn3;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPlace = (TextView) findViewById(R.id.tvPlace);
        tvInfo = (TextView) findViewById(R.id.tvInfo);


        tvPlace.setText("ABC Pte Ltd");
        tvInfo.setText("We now have 3 branches.Look below for the address and info");


        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)
                fm.findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                LatLng singapore = new LatLng(1.353956, 103.864227);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(singapore,
                        15));



                UiSettings ui = map.getUiSettings();
                ui.setZoomControlsEnabled(true);
                ui.setCompassEnabled(true);


                LatLng poi_admiralty = new LatLng(1.461446, 103.813392);

                Marker north = map.addMarker(new
                        MarkerOptions()
                        .position(poi_admiralty)
                        .title("HQ - North")
                        .snippet("Block 333, Admiralty Ave 3, 765654 Operating hours: 10am-5pm\n" +
                                "Tel:65433456\n")
                        .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.star_on)));


                LatLng orchard = new LatLng(1.3015829, 103.83827050000002);


                Marker central = map.addMarker(new
                        MarkerOptions()
                        .position(orchard)
                        .title("Central")
                        .snippet("Block 3A, Orchard Ave 3, 134542 \n" +
                                "Operating hours: 11am-8pm\n" +
                                "Tel:67788652\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));



                LatLng tampines = new LatLng(1.351612, 103.950045);


                Marker east = map.addMarker(new
                        MarkerOptions()
                        .position(tampines)
                        .title("East")
                        .snippet("Block 555, Tampines Ave 3, 287788 \n" +
                                "Operating hours: 9am-5pm\n" +
                                "Tel:66776677\"\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));




            }

        });

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null) {
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
                LatLng poi_admiralty = new LatLng(1.461446, 103.813392);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_admiralty,
                        15));

                Marker north = map.addMarker(new
                        MarkerOptions()
                        .position(poi_admiralty)
                        .title("HQ - North")
                        .snippet("Block 333, Admiralty Ave 3, 765654 Operating hours: 10am-5pm\n" +
                                "Tel:65433456\n")
                        .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.star_on)));

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null) {
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
                LatLng orchard = new LatLng(1.3015829, 103.83827050000002);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(orchard,
                        15));

                Marker central = map.addMarker(new
                        MarkerOptions()
                        .position(orchard)
                        .title("Central")
                        .snippet("Block 3A, Orchard Ave 3, 134542 \n" +
                                "Operating hours: 11am-8pm\n" +
                                "Tel:67788652\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null) {
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
                LatLng tampines = new LatLng(1.351612, 103.950045);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(tampines,
                        15));

                Marker east = map.addMarker(new
                        MarkerOptions()
                        .position(tampines)
                        .title("East")
                        .snippet("Block 555, Tampines Ave 3, 287788 \n" +
                                "Operating hours: 9am-5pm\n" +
                                "Tel:66776677\"\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
            }
        });

    }




    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

        int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                android.Manifest.permission.ACCESS_FINE_LOCATION);

        if (permissionCheck == PermissionChecker.PERMISSION_GRANTED) {
            map.setMyLocationEnabled(true);
        } else {
            Log.e("GMap - Permission", "GPS access has not been granted");
        }




    }

}
