package com.wisataku_10117208;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/*
tgl : 10/8/2020
nim : 10117208
nama : guntur prakasa irwan
 */
public class HomeFragment extends Fragment {
    public static final String DATABASE_NAME = "UNIKOM.db";
    public static final String TABLE_NAME = "Mahasiswa";
    public static final String COL_1 = "NIM";
    public static final String COL_2 = "Nama";
    public static final String COL_3 = "Kelas";
    public static final String COL_4 = "Telepon";
    public static final String COL_5 = "Email";
    public static final String COL_6 = "SocialMedia";
    ImageView myImage;

    TextView nimm,namaa,kelass;
    DatabaseHelper myDb;
    protected Cursor cursor;
    private static final int REQUEST_CALL = 1;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_home, container, false);
        myDb = new DatabaseHelper(getContext());

        nimm = rootView.findViewById(R.id.anim);
        namaa = rootView.findViewById(R.id.anama);
        kelass = rootView.findViewById(R.id.akelas);

        SQLiteDatabase db = myDb.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM Biodata", null);
        cursor.moveToFirst();
        String NIM = cursor.getString(0);
        String Nama = cursor.getString(1);
        String Kelas = cursor.getString(2);

        myImage = rootView.findViewById(R.id.pict);
        myImage.setImageResource(R.drawable.face);
        nimm.setText(NIM);
        namaa.setText(Nama);
        kelass.setText(Kelas);
        return rootView;
    }
}
