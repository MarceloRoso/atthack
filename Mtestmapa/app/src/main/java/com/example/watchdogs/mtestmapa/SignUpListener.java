package com.example.watchdogs.mtestmapa;

import android.os.AsyncTask;
import android.view.View;

import com.example.watchdogs.mtestmapa.LoginActivity;
import com.example.watchdogs.mtestmapa.LoginInfo;
import com.example.watchdogs.mtestmapa.ServerConnection;

import java.io.IOException;

public class SignUpListener implements View.OnClickListener {
    private registro mMainActivity;

    public SignUpListener() {

    }

    public SignUpListener(registro mainActivity) {
        mMainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        UserInfo userInfo = mMainActivity.getUserInfo();
        new SignUpTask().execute(userInfo);
    }

    public class SignUpTask extends AsyncTask<UserInfo,String,String> {

        @Override
        protected void onPostExecute(String result) {
            mMainActivity.showMessage(result);
        }

        @Override
        protected String doInBackground(UserInfo... params) {
            UserInfo userInfo = params[0];

            String url = "http://www.talkmefriendsapp.esy.es/services/registro.php";

            String parametros = "correo="+userInfo.getLoginInfo().getCorreo();
            parametros += "&";
            parametros += "password="+userInfo.getLoginInfo().getPassword();
            parametros += "&";
            parametros += "nombre="+userInfo.getNombre();
            parametros += "&";
            parametros += "edad="+userInfo.getEdad();
            parametros += "&";
            parametros += "telefono="+userInfo.getTelefono();
            parametros += "&";
            parametros += "sexo="+userInfo.getSexo();

            try {
                String respuesta = ServerConnection.sendHttpRequest(url, parametros);
                return respuesta;
            } catch (IOException e) {
                e.printStackTrace();
                return e.getMessage();
            } catch(Exception ex) {
                return ex.getMessage();
            }
        }
    }
}
