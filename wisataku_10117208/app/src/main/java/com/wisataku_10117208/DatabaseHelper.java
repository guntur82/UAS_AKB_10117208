package com.wisataku_10117208;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "AKB.db";
    public static final String TABLE_NAME = "WISATA";
    public static final String COL_1 = "Nama";
    public static final String COL_2 = "Alamat";

    public DatabaseHelper(@Nullable Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Biodata (nim text,nama text,kelas text)");
        db.execSQL("INSERT INTO Biodata (nim, nama, kelas) VALUES ('10117208','Guntur Prakasa Irwan','IF-7')");

        db.execSQL("CREATE TABLE "+TABLE_NAME+"("+COL_1+" TEXT PRIMARY KEY, "+COL_2+" TEXT, lat REAL,lng REAL)");

        db.execSQL("INSERT INTO "+TABLE_NAME+" ("+COL_1+", "+COL_2+", lat, lng) VALUES ('Gunung Tangkuban Parahu','Jl. Tangkuban Perahu,Cikahuripan, Lembang, Kabupaten Bandung Barat, Jawa Barat','-6.759621','107.609775')");
        db.execSQL("INSERT INTO "+TABLE_NAME+" ("+COL_1+", "+COL_2+", lat, lng) VALUES ('Jalan Braga','Jl. Braga 58-46, Braga, Kec. Sumur Bandung, Kota Bandung, Jawa Barat 40111','-6.917500', '107.609355')");
        db.execSQL("INSERT INTO "+TABLE_NAME+" ("+COL_1+", "+COL_2+", lat, lng) VALUES ('Gedung Sate','Jl. Diponegoro No.22, Citarum, Kec. Bandung Wetan, Kota Bandung, Jawa Barat 40115','-6.902462', '107.618810')");

        db.execSQL("INSERT INTO "+TABLE_NAME+" ("+COL_1+", "+COL_2+", lat, lng) VALUES ('Kawah Putih','Sugihmukti, Kec. Pasirjambu, Bandung, Jawa Barat','-7.166186', '107.402107')");
        db.execSQL("INSERT INTO "+TABLE_NAME+" ("+COL_1+", "+COL_2+", lat, lng) VALUES ('Gunung Puntang','Mekarjaya, Kec. Banjaran, Bandung, Jawa Barat','-7.122634', '107.620414')");
        db.execSQL("INSERT INTO "+TABLE_NAME+" ("+COL_1+", "+COL_2+", lat, lng) VALUES ('Glamping Lake Side','Jl. Raya Ciwidey - Patengan No.Km. 39, Situ, Patengan, Kec. Rancabali, Bandung, Jawa Barat 40973','-7.157554', '107.365162')");

        db.execSQL("INSERT INTO "+TABLE_NAME+" ("+COL_1+", "+COL_2+", lat, lng) VALUES ('Puncak Eurad Pingping','Cibodas-Ciater, Wangunharja, Lembang, Kabupaten Bandung Barat, Jawa Barat 40391','-6.791334', '107.681780')");
        db.execSQL("INSERT INTO "+TABLE_NAME+" ("+COL_1+", "+COL_2+", lat, lng) VALUES ('Sungai Cikahuripan','Cihideung, Kec. Parongpong, Kabupaten Bandung Barat, Jawa Barat 40559','-6.790982', '107.612820\n')");
        db.execSQL("INSERT INTO "+TABLE_NAME+" ("+COL_1+", "+COL_2+", lat, lng) VALUES ('Sanghyang Heuleut','Kp, Cipanas, Rajamandala Kulon, Kec. Cipatat, Kabupaten Bandung Barat, Jawa Barat 40554','-6.876460', '107.342208')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return data;
    }

}
