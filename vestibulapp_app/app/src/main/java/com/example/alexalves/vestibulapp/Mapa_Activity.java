package com.example.alexalves.vestibulapp;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;

import java.util.List;

public class Mapa_Activity extends AppCompatActivity implements LocationListener, OnMapReadyCallback {

    private SupportMapFragment mapaFragment;
    private GoogleMap mapa;
    //private Marker infoWindowsMarquer;

    MarkerOptions markerOptions;
    Marker markerUniversidade;
    Polyline LinhaCaminho;
    ProgressDialog progressDialog;
    LatLng posicaoUniversidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //carrega o fragment do mapa
        mapaFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.MapaFragment);

        posicaoUniversidade = new LatLng(-20.055901, -44.571345); //posicao geografica da universidade

        if (mapaFragment != null) {

            showProgressDialog("Carregando");
            //carrega o mapa
            mapaFragment.getMapAsync(this);

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //region Mapa


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mapa = googleMap;

        if (mapa != null) {


            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }

            mapa.setMyLocationEnabled(true);
            mapa.getUiSettings().setZoomControlsEnabled(true);

            //carrega os metodos do mapa
            loadUniversidadePosition();

            if(progressDialog != null){
                progressDialog.dismiss();
            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    //endregion

    private void showProgressDialog(String _mensagem){

        if(progressDialog == null || !progressDialog.isShowing()) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage(_mensagem);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setCancelable(false);

            progressDialog.show();
        }
    }

    public void loadUniversidadePosition(){


            //remove as igrejas que ja estiverem carregadas
            markerOptions = null;
            mapa.clear();

            try {

                MarkerOptions options = new MarkerOptions();

                if (options != null) {

                    BitmapDrawable bitmapdraw = (BitmapDrawable) getResources().getDrawable(R.drawable.university_icon);

                    Bitmap b = bitmapdraw.getBitmap();
                    Bitmap smallMarker = Bitmap.createScaledBitmap(b, 50, 50, false);

                    options.position(posicaoUniversidade).title("Universidade de Itaúna").draggable(false);
                    //options.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_icone_igreja)); //esse codigo altera o icone do marcador
                    options.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));


                }

            }catch (Exception err){
                Log.e(this.getResources().getString(R.string.app_name),err.getMessage());
            }

            //vai centralizar a igreja selecionada no mapa no inicio
            CameraPosition cameraPosition = new CameraPosition.Builder().target(posicaoUniversidade).zoom(17).build();
            CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);

            mapa.animateCamera(cameraUpdate);



    }

}
