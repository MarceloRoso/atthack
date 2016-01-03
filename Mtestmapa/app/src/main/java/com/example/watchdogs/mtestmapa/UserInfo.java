package com.example.watchdogs.mtestmapa;


import com.google.android.gms.maps.model.LatLng;

public class UserInfo {
    private String mName;
    private LoginInfo mLoginInfo;
    private int mEdad;
    private String mSexo;
    private String mTelefono;
    private LatLng mLocation;

    public UserInfo(String name, int edad, String sexo, String telefono, LoginInfo loginInfo) {
        mName = name;
        mEdad = edad;
        mSexo = sexo;
        mTelefono = telefono;
        mLoginInfo = loginInfo;
    }

    public LoginInfo getLoginInfo() {
        return mLoginInfo;
    }

    public String getNombre() {
        return mName;
    }

    public int getEdad() {
        return mEdad;
    }

    public String getSexo() {
        return mSexo;
    }

    public String getTelefono() {
        return mTelefono;
    }

    public LatLng getLocation() {
        return mLocation;
    }

}
