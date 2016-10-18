package com.example.alexalves.vestibulapp.threads;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;

import com.example.alexalves.vestibulapp.Util.Service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Desenvolvedor on 17/10/2016.
 */

public class FileThread extends AsyncTask<Object, Object, String> {

    private Context context;
    private String file;

    public FileThread(Context _context, String _file){

        file = _file;
        context = _context;

    }

    @Override
    protected String doInBackground(Object... params) {

        if(Service.isOnline(context)){

            try {

                String urlstr = "/" + file;

                URL url = new URL(urlstr);
                int count = 0;

                if(context != null){

                    URLConnection connection = url.openConnection();
                    connection.connect();

                    int lingOfFile = connection.getContentLength();
                    InputStream inputStream = new BufferedInputStream(url.openStream(), 8192);

                    FileOutputStream outputStream = null;

                    if(inputStream != null) {

                        //verifica se a pasta existe
                        File dir = new File(Environment.getExternalStoragePublicDirectory("VestibularApp"),""); //verifica o diretorio
                        if (!dir.exists()) {
                            dir.mkdirs(); //cria o diretorio se não existir
                        }

                        File novoArquivo = new File(dir, file); //cria o arquivo no diretorio

                        outputStream = new FileOutputStream(novoArquivo);

                        if(outputStream != null) {

                            byte data[] = new byte[1024];

                            long total = 0;

                            while ((count = inputStream.read(data)) != -1) {

                                total += count;
                                publishProgress("" + (int) ((total * 100) / lingOfFile));

                                outputStream.write(data, 0, count);

                            }

                            outputStream.flush();

                            outputStream.close();
                            inputStream.close();

                        }

                    }

                }


            }catch (Exception e) {
                e.printStackTrace();
            }

        }

        return null;
    }

    @Override
    protected void onPostExecute (String result){

        if(context != null){

            //carrega o arquivo na tela do dispositivo


        }
    }
}
