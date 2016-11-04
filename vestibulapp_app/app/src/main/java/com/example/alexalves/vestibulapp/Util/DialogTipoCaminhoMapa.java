package com.example.alexalves.vestibulapp.Util;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.alexalves.vestibulapp.Mapa_Activity;
import com.example.alexalves.vestibulapp.R;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Araújo on 01/09/2016.
 */
public class DialogTipoCaminhoMapa extends android.app.Dialog implements View.OnClickListener {

    private RelativeLayout btnCaminhando, btnDirigindo, btnHorarios;
    private CheckBox opPadrao;
    private Mapa_Activity context;
    private Boolean getRota = true;
    private LatLng posicaoDestino;

    public DialogTipoCaminhoMapa(Mapa_Activity _context, Boolean _buscarRota, LatLng _posicaoDestino){
        super(_context);
        context = _context;
        getRota = _buscarRota;
        posicaoDestino = _posicaoDestino;
    }

    public DialogTipoCaminhoMapa(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_mapa_rota_tipo_layout);

        btnCaminhando = (RelativeLayout) findViewById(R.id.opMapaDialogTipoCaminhoPe);
        btnCaminhando.setOnClickListener(this);

        btnDirigindo = (RelativeLayout) findViewById(R.id.opMapaDialogTipoCaminhoCarro);
        btnDirigindo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.opMapaDialogTipoCaminhoCarro:
                setaCaminho("driving");
                break;
            case R.id.opMapaDialogTipoCaminhoPe:
                setaCaminho("walking");
                break;

        }

    }

    private void setaCaminho(String _tipo){

        if(Gps.CheckGPS(context)) { //verifica se o gps esta ativo

            if(getRota) {
                context.GetRota(posicaoDestino, _tipo);
            }

        }else{
            Toast.makeText(context, context.getText(R.string.gpsDesabilitado), Toast.LENGTH_SHORT).show();
        }

        dismiss();
    }
}
