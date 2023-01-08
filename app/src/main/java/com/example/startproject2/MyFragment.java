package com.example.startproject2;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {

    TextView txtmain;
    TextView edit1,edit2,edit3,edit4,edit5,edit6,edit7,edit8,edit9,edit10;


    String search;
    int searchcount;
    int a;




    public void searchlist(){
        a++;
        searchcount=((MainActivity)MainActivity.context_MainActivity).searchcount;
        search=((MainActivity)MainActivity.context_MainActivity).searchrecord;
        switch (a%10){
            case 1:
                edit1.setText(search);
                break;
            case 2:
                edit2.setText(search);
                break;
            case 3:
                edit3.setText(search);
                break;
            case 4:
                edit4.setText(search);
                break;
            case 5:
                edit5.setText(search);
                break;
            case 6:
                edit6.setText(search);
                break;
            case 7:
                edit7.setText(search);
                break;
            case 8:
                edit8.setText(search);
                break;
            case 9:
                edit9.setText(search);
                break;
            case 0:
                edit10.setText(search);
                break;
        }
    }
    public MyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {    //기생충
        super.onResume();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_my, container, false);


        txtmain=rootView.findViewById(R.id.txtmain);


        searchcount=((MainActivity)MainActivity.context_MainActivity).searchcount;
        search=((MainActivity)MainActivity.context_MainActivity).searchrecord;


        edit1 = rootView.findViewById(R.id.editText);
        edit1.setText(search);

        edit2 = rootView.findViewById(R.id.editText2);
        edit3 = rootView.findViewById(R.id.editText3);
        edit4 = rootView.findViewById(R.id.editText4);
        edit5 = rootView.findViewById(R.id.editText5);
        edit6 = rootView.findViewById(R.id.editText6);
        edit7 = rootView.findViewById(R.id.editText7);
        edit8 = rootView.findViewById(R.id.editText8);
        edit9 = rootView.findViewById(R.id.editText9);
        edit10 = rootView.findViewById(R.id.editText10);


        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("sFile", Context.MODE_PRIVATE);

        String str_edit1 = sharedPreferences.getString("edit1","");
        String str_edit2 = sharedPreferences.getString("edit2","");
        String str_edit3 = sharedPreferences.getString("edit3","");
        String str_edit4 = sharedPreferences.getString("edit4","");
        String str_edit5 = sharedPreferences.getString("edit5","");
        String str_edit6 = sharedPreferences.getString("edit6","");
        String str_edit7 = sharedPreferences.getString("edit7","");
        String str_edit8 = sharedPreferences.getString("edit8","");
        String str_edit9 = sharedPreferences.getString("edit9","");
        String str_edit10 = sharedPreferences.getString("edit10","");
        a=sharedPreferences.getInt("count",0);


        edit1.setText(str_edit1);
        edit2.setText(str_edit2);
        edit3.setText(str_edit3);
        edit4.setText(str_edit4);
        edit5.setText(str_edit5);
        edit6.setText(str_edit6);
        edit7.setText(str_edit7);
        edit8.setText(str_edit8);
        edit9.setText(str_edit9);
        edit10.setText(str_edit10);


        return rootView;
    }




    @Override
    public void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("sFile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit(); //사용자가 입력한 데이터 저장
        //sharedPreferences.edit().clear().commit(); //초기화

        String str_edit1 = edit1.getText().toString();
        String str_edit2 = edit2.getText().toString();
        String str_edit3 = edit3.getText().toString();
        String str_edit4 = edit4.getText().toString();
        String str_edit5 = edit5.getText().toString();
        String str_edit6 = edit6.getText().toString();
        String str_edit7 = edit7.getText().toString();
        String str_edit8 = edit8.getText().toString();
        String str_edit9 = edit9.getText().toString();
        String str_edit10 = edit10.getText().toString();
        int count=a;

        editor.putString("edit1", str_edit1);
        editor.putString("edit2", str_edit2);
        editor.putString("edit3", str_edit3);
        editor.putString("edit4", str_edit4);
        editor.putString("edit5", str_edit5);
        editor.putString("edit6", str_edit6);
        editor.putString("edit7", str_edit7);
        editor.putString("edit8", str_edit8);
        editor.putString("edit9", str_edit9);
        editor.putString("edit10", str_edit10);
        editor.putInt("count", count);

        editor.commit();
    }
}
