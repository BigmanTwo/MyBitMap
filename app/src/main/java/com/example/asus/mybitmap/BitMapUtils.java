package com.example.asus.mybitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Asus on 2016/5/9.
 */
public class BitMapUtils {
    public static Bitmap zipBitMap(String file){
        BitmapFactory.Options options=new BitmapFactory.Options();
        //只得到图片的宽高
        options.inJustDecodeBounds=true;
        //得到具体的信息
        BitmapFactory.decodeFile(file,options);
        //设置图片压缩比例
        options.inSampleSize=computsampleSize(options,100,100);
        options.inJustDecodeBounds=false;
        return  BitmapFactory.decodeFile(file,options);
    }

    private static int computsampleSize(BitmapFactory.Options options, int reqHeight, int reqWidth) {
        int w=options.outWidth;
        int h=options.outHeight;
        int inSampleSize=1;
        if(reqHeight < h || reqWidth < w){
            int heightR=Math.round(h/reqHeight);
            int wightR=Math.round(w/reqWidth);
            inSampleSize=heightR<wightR ? heightR:wightR;
        }
        return inSampleSize;
    }

}
