package com.example.alexalves.vestibulapp.threads;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.example.alexalves.vestibulapp.Mapa_Activity;
import com.example.alexalves.vestibulapp.R;
import com.example.alexalves.vestibulapp.Util.Rota;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;

/**
 * Created by araújo on 20/08/2015.
 */
public class RotasThread extends AsyncTask<Object, Object, String> {

        Mapa_Activity mActivity;
        List<LatLng> resultado;
        LatLng Origem, Destino;
        ProgressDialog pD;
        String tipoCaminho;

    public RotasThread(Mapa_Activity _context, LatLng _orig, LatLng _dest, ProgressDialog _pd, String _tipoCaminho){

        mActivity = _context;
        Origem = _orig;
        Destino = _dest;
        pD = _pd;
        tipoCaminho = _tipoCaminho;

    }

    @Override
    protected String doInBackground(Object... params) {

        if(tipoCaminho == null){
            tipoCaminho = "walking";
        }

        resultado = new Rota().GetRotaGoogle(Origem, Destino,tipoCaminho);//driving

        return null;
    }

    @Override
    protected void onPostExecute (String result){

        if(mActivity != null){
            ImprimeRota(mActivity.getMapa());
        }
    }

    private void ImprimeRota(GoogleMap _mapa){

        if(resultado != null){

            PolylineOptions polylineOptions = new PolylineOptions();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();

            for (LatLng ponto : resultado) {

                polylineOptions.add(ponto);
                builder.include(ponto);
            }

            polylineOptions.color(mActivity.getResources().getColor(R.color.corCaminho));

            if(mActivity != null) {
                mActivity.setLinhaCaminho(_mapa.addPolyline(polylineOptions));
            }

            LatLngBounds bounds = builder.build();
            int padding = 0; // offset from edges of the map in pixels
            CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
            _mapa.animateCamera(cu);

        }

        pD.dismiss();

    }
}
