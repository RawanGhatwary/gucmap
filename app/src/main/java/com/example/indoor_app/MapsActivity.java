package com.example.indoor_app;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.maps.android.data.geojson.GeoJsonLayer;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private GeoJsonLayer layer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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
    public void onMapReady( final GoogleMap googleMap) {

        mMap = googleMap;
        final int blue = 0xffb0e0e6;
        final int brown = 0xffdb7093;
        final int white = 0xfffffff0;
        final int grey=0xffbebebe;
        BitmapDescriptor icon=BitmapDescriptorFactory.fromResource(R.drawable.amu_bubble_shadow);

        Marker ROOM1=mMap.addMarker(new MarkerOptions().position(new LatLng(9.3,-0.7))
                .title("C6: 1").icon(icon));

        mMap.addMarker(new MarkerOptions().position(new LatLng(0.71,-0.7))
                .title("C6: 2").icon(icon));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-0.7,2))
                .title("C6: 3").icon(icon));


        //JSONObject json=new JSONObject();
        //layer=new GeoJsonLayer(mMap,json);

          //  try {
            //    layer =new GeoJsonLayer(mMap,R.raw.geojsonn,getApplicationContext());
            //} catch (IOException e) {
              //  e.printStackTrace();
            //} catch (JSONException e) {
              //  e.printStackTrace();
            //}
            //layer.addLayerToMap();


        Polygon outdoor=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(10,10),
                new LatLng(10,-1.57),
                new LatLng(-1.57,-1.57),
                new LatLng(-1.57,10),
                new LatLng(10,10)));
        Polygon indoor=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(10,2.67),
                new LatLng(10,0),
                new LatLng(0,0),
                new LatLng(0,10),
                new LatLng(2.67,10),
                new LatLng(2.67   ,2.67),
                new LatLng(10,2.67)));

        Polygon room1=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(10,0),
                new LatLng(10,-1.57),
                new LatLng(8.72,-1.57),
                new LatLng(8.72,0)));

        Polygon room2=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(1.35,0),
                new LatLng(1.35,-1.57),
                new LatLng(0.07,-1.57),
                new LatLng(0.07,0)));

        Polygon room3=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(0,2.67),
                new LatLng(0,1.57),
                new LatLng(-1.57,1.57),
                new LatLng(-1.57,2.67)));







        outdoor.setFillColor(grey);
        indoor.setFillColor(white);
        room1.setFillColor(brown);
        room2.setFillColor(blue);
        room3.setFillColor(brown);









        // Add a marker in Sydney and move the camera
        LatLng GUC = new LatLng(0,0);
    //    mMap.addMarker(new MarkerOptions().position(GUC).title("German University in Cairo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(GUC));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(GUC,6));
        mMap.setMapType(mMap.MAP_TYPE_NONE); // Here is where you set the map type
         mMap.setMinZoomPreference(5);
         mMap.setMaxZoomPreference(12);


    }
}
