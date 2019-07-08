package com.example.indoor_app;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

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
    private static final String[] roomsnumber=new String[]{"C6.304","C6.305","C6.306","C7.301","C7.302","C7.303","C7.304","C7.305","C7.306","C7.307","C7.308","C7.309","C7.310","C7.311","C7.312","C7.313"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        AutoCompleteTextView pickup=findViewById(R.id.pickup);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,roomsnumber);
        pickup.setAdapter(adapter1);

        AutoCompleteTextView whereto=findViewById(R.id.whereto);
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,roomsnumber);
        whereto.setAdapter(adapter2);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }



    public void onMapReady( final GoogleMap googleMap) {

        mMap = googleMap;
        final int blue = 0xff4392B6;
        final int brown = 0xffff0000;
        final int white = 0xfffffff0;
        final int grey=0xffbebebe;
        BitmapDescriptor icon=BitmapDescriptorFactory.fromResource(R.drawable.amu_bubble_shadow);


        mMap.addMarker(new MarkerOptions().position(new LatLng(8.72,-2))
                .title("C6.304").icon(icon));

        mMap.addMarker(new MarkerOptions().position(new LatLng(0.07,-2))
                .title("C6.305").icon(icon));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2,1.61))
                .title("C6.306").icon(icon));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2,3.7))
                .title("C7.313").icon(icon));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2,8.51))
                .title("C7.312").icon(icon));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2,10.6))
                .title("C7.311").icon(icon));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2,15.405))
                .title("C7.310").icon(icon));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2,17.505))
                .title("C7.309").icon(icon));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2,22.42))
                .title("C7.308").icon(icon));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2,24.485))
                .title("C7.307").icon(icon));
        mMap.addMarker(new MarkerOptions().position(new LatLng(1.52,3.7))
                .title("C7.301").icon(icon));
        mMap.addMarker(new MarkerOptions().position(new LatLng(1.52,8.51))
                .title("C7.302").icon(icon));
        mMap.addMarker(new MarkerOptions().position(new LatLng(1.52,10.6))
                .title("C7.303").icon(icon));
        mMap.addMarker(new MarkerOptions().position(new LatLng(1.52,15.405))
                .title("C7.304").icon(icon));
        mMap.addMarker(new MarkerOptions().position(new LatLng(1.52,17.505))
                .title("C7.305").icon(icon));
        mMap.addMarker(new MarkerOptions().position(new LatLng(1.52,23.58))
                .title("C7.306").icon(icon));




        Polygon outdoor=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(10,25.65),
                new LatLng(10,-2),
                new LatLng(-2,-2),
                new LatLng(-2,25.65),
                new LatLng(10,25.65)));
        Polygon indoor1=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(10,2.67),
                new LatLng(10,0),
                new LatLng(0,0),
                new LatLng(0,25.65),
                new LatLng(1.52,25.65),
                new LatLng(1.52   ,2.64),
                new LatLng(10,2.67)));
        //Polygon indoor2=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
         //       new LatLng(1.52,2.67),
           //     new LatLng(3.52,2.67),
             //   new LatLng(3.52,25.65),
               // new LatLng(1.52,25.65)));

        Polygon room1=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(10,0),
                new LatLng(10,-2),
                new LatLng(8.72,-2),
                new LatLng(8.72,0)));

        Polygon room2=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(1.35,0),
                new LatLng(1.35,-2),
                new LatLng(0.07,-2),
                new LatLng(0.07,0)));

        Polygon room3=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(0,2.67),
                new LatLng(0,1.61),
                new LatLng(-2,1.57),
                new LatLng(-2,2.67)));

        Polygon room4=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(0,4.792),
                new LatLng(0,3.7),
                new LatLng(-2,3.7),
                new LatLng(-2,4.792)));

        Polygon room5=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(0,9.6),
                new LatLng(0,8.51),
                new LatLng(-2,8.51),
                new LatLng(-2,9.6)));
        Polygon room6=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(0,11.675),
                new LatLng(0,10.6),
                new LatLng(-2,10.6),
                new LatLng(-2,11.675)));
        Polygon room7=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(0,16.58),
                new LatLng(0,15.405),
                new LatLng(-2,15.405),
                new LatLng(-2,16.58)));
        Polygon room8=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(0,18.66),
                new LatLng(0,17.505),
                new LatLng(-2,17.505),
                new LatLng(-2,18.66)));
        Polygon room9=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(0,23.58),
                new LatLng(0,22.42),
                new LatLng(-2,22.42),
                new LatLng(-2,23.58)));
        Polygon room10=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(0,25.65),
                new LatLng(0,24.485),
                new LatLng(-2,24.485),
                new LatLng(-2,25.65)));
        Polygon room11=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(3.52,4.792),
                new LatLng(3.52,3.7),
                new LatLng(1.52,3.7),
                new LatLng(1.52,4.792)));
        Polygon room12=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(3.52,9.6),
                new LatLng(3.52,8.51),
                new LatLng(1.52,8.51),
                new LatLng(1.52,9.6)));
        Polygon room13=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(3.52,11.675),
                new LatLng(3.52,10.6),
                new LatLng(1.52,10.6),
                new LatLng(1.52,11.675)));
        Polygon room14=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(3.52,16.585),
                new LatLng(3.52,15.405),
                new LatLng(1.52,15.405),
                new LatLng(1.52,16.585)));
        Polygon room15=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(3.52,18.66),
                new LatLng(3.52,17.505),
                new LatLng(1.52,17.505),
                new LatLng(1.52,18.66)));
        Polygon room16=googleMap.addPolygon(new PolygonOptions().clickable(true).add(
                new LatLng(3.52,23.58),
                new LatLng(3.52,22.42),
                new LatLng(1.52,22.42),
                new LatLng(1.52,23.58)));











        outdoor.setFillColor(grey);
        indoor1.setFillColor(white);
        room1.setFillColor(brown);
        room2.setFillColor(blue);
        room3.setFillColor(brown);
        room4.setFillColor(brown);
        room5.setFillColor(blue);
        room6.setFillColor(brown);
        room7.setFillColor(brown);
        room8.setFillColor(blue);
        room9.setFillColor(brown);
        room10.setFillColor(brown);
        room11.setFillColor(brown);
        room12.setFillColor(brown);
        room13.setFillColor(blue);
        room14.setFillColor(brown);
        room15.setFillColor(brown);
        room16.setFillColor(blue);











        LatLng GUC = new LatLng(5,13);
      mMap.addMarker(new MarkerOptions().position(GUC).title("German University in Cairo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(GUC));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(GUC,3));
        mMap.setMapType(mMap.MAP_TYPE_NONE);
         mMap.setMinZoomPreference(4);
         mMap.setMaxZoomPreference(16);


    }
}
