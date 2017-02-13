package com.example.tr.greenfuel;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.LatLng;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MapView mapView=null;
    Button route;
    private AMap aMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapView= (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);

        route  = (Button) findViewById(R.id.route);
        route.setOnClickListener(this);
        aMap = mapView.getMap();
        LatLng desLatLng = new LatLng(30.765207,103.989339);
        aMap.moveCamera(CameraUpdateFactory.changeLatLng(desLatLng));
        aMap.moveCamera(CameraUpdateFactory.zoomTo(12));
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.route:
                Intent i = new Intent(MainActivity.this,GPSNaviActivity.class);
                startActivity(i);
                break;
        }
    }
}
