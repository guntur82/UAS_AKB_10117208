package com.wisataku_10117208;

import android.os.Parcel;
import android.os.Parcelable;

public class Wisata implements Parcelable {
    private String nama;
    private String tempat;
    private double lat,lng;
    //private int image;


    public Wisata(String nama, String tempat, double lat, double lng){
        this.nama = nama;
        this.tempat = tempat;
        this.lat = lat;
        this.lng = lng;
        //this.image = image;
    }

    protected Wisata(Parcel in){
        nama = in.readString();
        tempat = in.readString();
        lat = in.readDouble();
        lng = in.readDouble();

    }

    public static final Parcelable.Creator<Wisata> CREATOR = new Parcelable.Creator<Wisata>() {
        @Override
        public Wisata createFromParcel(Parcel in) {
            return new Wisata(in);
        }

        @Override
        public Wisata[] newArray(int size) {
            return new Wisata[size];
        }
    };
/*
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


 */
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getTempat() {
        return tempat;
    }
    public void setTempat(String alamat) {
        this.tempat = alamat;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }
    public int describeContents() { return 0;}

    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(nama);
        dest.writeString(tempat);
        dest.writeDouble(lat);
        dest.writeDouble(lng);
    }
}
