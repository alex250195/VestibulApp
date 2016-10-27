package com.example.alexalves.vestibulapp.Util;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.KeyEvent;

import com.example.alexalves.vestibulapp.Mapa_Activity;
import com.example.alexalves.vestibulapp.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import java.util.List;

/**
 * Created by araújo on 10/06/2015.
 */
public class Gps {

    ///Metodo para verificar se o GPS está ativo ou não.
    public static Boolean CheckGP(Activity activity) {

        String provider = Settings.Secure.getString(activity.getContentResolver(),
                Settings.Secure.LOCATION_PROVIDERS_ALLOWED);

        if (provider != null && provider.length() > 0) {

            return true;

        } else {

            return false;

        }
    }

    public static Boolean CheckGPS(final Context _activity) {

        LocationManager locationManager = null;

        Boolean gps_enabled = false;
        Boolean net_enabled = false;

        if (locationManager == null) {

            locationManager = (LocationManager) _activity.getSystemService(Context.LOCATION_SERVICE);

            try {

                gps_enabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
                net_enabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            } catch (Exception err) {

            }

            if (!gps_enabled && !net_enabled) {// vai mostrar as opções para abilitar o gps

                final AlertDialog.Builder dialog = new AlertDialog.Builder(_activity);
                dialog.setMessage(_activity.getResources().getString(R.string.gpsDesabilitado));
                dialog.setPositiveButton(_activity.getResources().getString(R.string.btnHabilitarGPS), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent gpsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        _activity.startActivity(gpsIntent);
                    }
                });

                dialog.setNegativeButton(_activity.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                dialog.show();

                dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    @Override
                    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                        if (keyCode == KeyEvent.KEYCODE_BACK) {
                            dialog.dismiss();
                        }
                        return false;
                    }
                });

            } else {

                return true;

            }

        }

        return false;

    }

    public static double GetDistance(LatLng startP, LatLng endP) {

        if (startP != null && endP != null) {

            float pk = (float) (180 / 3.14169);

            float splat1 = (float) startP.latitude / pk;
            float splon1 = (float) startP.longitude / pk;
            float splat2 = (float) endP.latitude / pk;
            float splon2 = (float) endP.longitude / pk;

            float t1 = (float) (Math.cos(splat1) * Math.cos(splon1) * Math.cos(splat2) * Math.cos(splon2));
            float t2 = (float) (Math.cos(splat1) * Math.sin(splon1) * Math.cos(splat2) * Math.sin(splon2));
            float t3 = (float) (Math.sin(splat1) * Math.sin(splat2));

            double tt = Math.acos(t1 + t2 + t3);

            return 6366000 * tt;
        }

        return 0;

    }

    public static double distance(LatLng StartP, LatLng EndP) {
        double lat1 = StartP.latitude;
        double lat2 = EndP.latitude;
        double lon1 = StartP.longitude;
        double lon2 = EndP.longitude;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return 6366000 * c;
    }

    public static String GetLocalizacao(LatLng ponto, Context cont, Boolean _internet) {

        if (ponto != null && _internet) {

            try {

                Geocoder gc = new Geocoder(cont);
                List<Address> endereco = gc.getFromLocation(ponto.latitude, ponto.longitude, 1);

                String end = endereco.get(0).getThoroughfare() + "\n";
                end += endereco.get(0).getSubAdminArea() + "\n";
                end += endereco.get(0).getAdminArea();

                return end;

            } catch (Exception err) {
                return err.getMessage();
            }
        }

        return "";

    }

    public static List<Address> GetLocalizacaoCidade(LatLng ponto, Context cont) {

        if (ponto != null) {

            try {

                Geocoder gc = new Geocoder(cont);
                List<Address> endereco = gc.getFromLocation(ponto.latitude, ponto.longitude, 1);

                return endereco;

            } catch (Exception err) {
                Log.d(cont.getResources().getString(R.string.app_name), err.getMessage());
            }
        }

        return null;

    }

    public static void GetMyLocalizacao(GoogleMap _mapa, Mapa_Activity _context) {
        //verifica se tem conexao com a internet
        if (_context != null && CheckGPS(_context)) {

            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                if (ActivityCompat.checkSelfPermission(_context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(_context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.

                    Dialog.Show(_context, "Altere a permisssão do MissaApp para usar o GPS.", "Atenção.");

                    return;
                }
            }

            _mapa.setMyLocationEnabled(true);

            LocationManager locationManager = (LocationManager) _context.getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();

            if(locationManager != null) {

                String provider = locationManager.getBestProvider(criteria, true);

                Location location = locationManager.getLastKnownLocation(provider);

                if (location != null) {

                    if (_context != null) {
                        _context.onLocationChanged(location);

                    }
                }

                locationManager.requestLocationUpdates(provider, 20000, 0, _context);

            }
        }
    }

    public static LatLng getCenter(LatLngBounds bounds) {
        double n = bounds.northeast.latitude;
        double e = bounds.northeast.longitude;
        double s = bounds.southwest.latitude;
        double w = bounds.southwest.longitude;

        double lat = ((n + s) / 2.0);
        double lon = ((e + w) / 2.0);

        if (lat != 0 && lon != 0) {
            return new LatLng(lat, lon);
        }

        return null;

    }
}
