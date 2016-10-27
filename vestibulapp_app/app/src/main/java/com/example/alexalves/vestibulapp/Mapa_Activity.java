package com.example.alexalves.vestibulapp;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.alexalves.vestibulapp.Util.Constants;
import com.example.alexalves.vestibulapp.Util.DialogTipoCaminhoMapa;
import com.example.alexalves.vestibulapp.Util.Gps;
import com.example.alexalves.vestibulapp.Util.InfoWindowCustomAdapter;
import com.example.alexalves.vestibulapp.Util.Service;
import com.example.alexalves.vestibulapp.threads.RotasThread;
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
    LatLng posicaoLatLng;

    RotasThread threadRota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //carrega o fragment do mapa
        mapaFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.MapaFragment);

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

    public GoogleMap getMapa(){
        return this.mapa;
    }

    public void setLinhaCaminho(Polyline polylines) {
        this.LinhaCaminho = polylines;
    }

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

            mapa.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {

                    markerUniversidade.hideInfoWindow();

                }
            });

            mapa.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {

                    if (marker != null) {

                            double corr =(double)190/Math.pow(2, 17);
                            LatLng infoPosition = new LatLng(marker.getPosition().latitude + corr, marker.getPosition().longitude);

                            if(infoPosition != null){
                                mapa.animateCamera(CameraUpdateFactory.newLatLngZoom(infoPosition, (17)));
                            }

                            marker.showInfoWindow();



                    }

                    return true;
                }
            });

            mapa.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {

                    ClearPolyline(null);

                    marker.hideInfoWindow();

                    if (Service.isOnline(Mapa_Activity.this)) {

                        //verifica se ja foi definido uma opçao padrao para o tipo de transporte

                        markerUniversidade = marker;
                        //chama a cx de dialogo para o usuario definir como ele vai chegar a igreja
                        DialogTipoCaminhoMapa dialogOpcoes = new DialogTipoCaminhoMapa(Mapa_Activity.this, true);
                        dialogOpcoes.show();



                    } else {
                        Toast.makeText(Mapa_Activity.this, getResources().getText(R.string.internetConexao), Toast.LENGTH_SHORT).show();
                    }


                }
            });

            mapa.setInfoWindowAdapter(new InfoWindowCustomAdapter(this.getLayoutInflater(), this));
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

                    options.position(Constants.getPosicaoUniversidade()).title("Universidade de Itaúna").draggable(false);
                    //options.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_icone_igreja)); //esse codigo altera o icone do marcador
                    options.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));

                    mapa.addMarker(options);

                }

            }catch (Exception err){
                Log.e(this.getResources().getString(R.string.app_name),err.getMessage());
            }

            //vai centralizar a igreja selecionada no mapa no inicio
            CameraPosition cameraPosition = new CameraPosition.Builder().target(Constants.getPosicaoUniversidade()).zoom(17).build();
            CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);

            mapa.animateCamera(cameraUpdate);



    }

    public void ClearPolyline(View v){

        if(LinhaCaminho != null){

            LinhaCaminho.remove();
            LinhaCaminho = null;
        }

    }

    public void GetRota(LatLng _posicaoDestino, String _tipoCaminho){

        if(threadRota == null || !threadRota.getStatus().equals(AsyncTask.Status.RUNNING)) {

            if (_posicaoDestino == null && this.markerUniversidade != null) {
                _posicaoDestino = this.markerUniversidade.getPosition();
            }

            //recupera a posicao atual do usuario
            if (posicaoLatLng == null) {
                Gps.GetMyLocalizacao(mapa, this);
            }

            if (posicaoLatLng != null) {

                progressDialog = ProgressDialog.show(this, "Aguarde", "Carregando caminho...");
                threadRota = new RotasThread(this, posicaoLatLng, _posicaoDestino, progressDialog, _tipoCaminho);
                if (threadRota != null) {
                    threadRota.execute();//
                }

            }
        }

    }
}
