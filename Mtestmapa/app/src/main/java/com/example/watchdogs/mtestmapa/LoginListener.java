package com.example.watchdogs.mtestmapa;

import android.os.AsyncTask;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Marce on 02/01/2016.
 */
public class LoginListener implements View.OnClickListener {
    private LoginActivity mMainActivity;

    public LoginListener() {

    }

    public LoginListener(LoginActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        LoginInfo loginInfo = mMainActivity.getLoginInfo();
        new LoginTask().execute(loginInfo);
    }

    public class LoginTask extends AsyncTask<LoginInfo,String,String> {

        @Override
        protected void onPostExecute(String result) {

            if(result.equals("1")) {
                mMainActivity.loginSuccesful();
            }
            else {
                mMainActivity.showMessage(result);
            }
        }

        @Override
        protected String doInBackground(LoginInfo... params) {
            LoginInfo loginInfo = params[0];

            String url = "http://www.talkmefriendsapp.esy.es/services/login.php";

            String parametros = "correo="+loginInfo.getCorreo();
            parametros += "&";
            parametros += "password="+loginInfo.getPassword();

            try {
                String respuesta = ServerConnection.sendHttpRequest(url, parametros);

                JSONObject obj = new JSONObject(respuesta);
                String status = obj.getString("status");
                if(status.equals("1")) {
                    MapsActivity.userId = obj.getString("id");
                    return "1";
                }
                else {
                    return obj.getString("mensaje");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return e.getMessage();
            } catch (JSONException e) {
                e.printStackTrace();
                return e.getMessage();
            }
        }
    }
}
