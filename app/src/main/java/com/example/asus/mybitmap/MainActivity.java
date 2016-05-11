package com.example.asus.mybitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mButton1,mButton2;
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1=(Button)findViewById(R.id.get_img);
        mButton2=(Button)findViewById(R.id.zip_img);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mImageView=(ImageView)findViewById(R.id.img);
    }

    @Override
    public void onClick(View v) {
        Bitmap bitmap;
        switch(v.getId()){
            case R.id.get_img:
                 bitmap= BitmapFactory.decodeFile(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+"/a2343072_144742005720317.jpg");
                Log.d("size",bitmap.getByteCount()+"");
                mImageView.setImageBitmap(bitmap);
                break;
            case R.id.zip_img:
                bitmap=BitMapUtils.zipBitMap(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+"/a2343072_144742005720317.jpg");
                Log.d("size",bitmap.getByteCount()+"");
                mImageView.setImageBitmap(bitmap);
                break;
        }
    }
}
