package com.example.alexalves.vestibulapp.Util;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.alexalves.vestibulapp.Mapa_Activity;
import com.example.alexalves.vestibulapp.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;


/**
 * Created by araújo on 20/08/2015.
 */
public class InfoWindowCustomAdapter implements GoogleMap.InfoWindowAdapter {
    LayoutInflater inflater=null;
    TextView txtInfoExtra;

    private Mapa_Activity telaMapa;

    public InfoWindowCustomAdapter(LayoutInflater inflater, Mapa_Activity _gpsParada) {
        this.inflater=inflater;
        telaMapa = _gpsParada;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return(null);
    }

    @Override
    public View getInfoContents(Marker marker) {

        if(marker != null) {

            View v = inflater.inflate(R.layout.marker_infos, null);

            TextView txtTitulo = (TextView) v.findViewById(R.id.txtInfoTitle);
            txtInfoExtra = (TextView) v.findViewById(R.id.txtInfoDescricao);

            TextView txtPosicao = (TextView) v.findViewById(R.id.txtInfoLatLng);

            ImageView imgFoto = (ImageView) v.findViewById(R.id.imgInfoFoto);
            RelativeLayout layoutImage = (RelativeLayout) v.findViewById(R.id.layoutInfoImagem);

            if (telaMapa != null) {

                txtTitulo.setText("Universidade de Itaúna");

                txtPosicao.setText(marker.getPosition().latitude + "," + marker.getPosition().longitude);

            }


            return v;
        }

        return null;

    }

    public void SetExtraText(String _text){
        txtInfoExtra.setText(_text);
    }
}

