package cn.nbhope.imageproxysample;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.TintContextWrapper;
import android.util.Log;
import android.widget.ImageView;

import cn.nbhope.imageproxylib.ImageProxy;
import cn.nbhope.imageproxylib.transform.CircleTransform;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropTransformation;

public class MainActivity extends AppCompatActivity {

    private ImageView img1;
    private ImageView img2;
    private ImageView img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);

        Context context = img1.getContext();
        Context baseContext = null;
        Log.i("Z-Context", "context:" + context.toString() + " isActivity" + (context instanceof Activity));
        if (context instanceof TintContextWrapper) {
            baseContext = ((TintContextWrapper) context).getBaseContext(); //获取Activity
            Log.i("Z-Context", "baseContext:" + context.toString() + " isActivity" + (baseContext instanceof Activity));
        }

        String url1 = "http://imgsrc.baidu.com/image/c0%3Dshijue%2C0%2C0%2C245%2C40/sign=626e96b8c711728b24208461a095a9bb/0eb30f2442a7d9337bfbfd5aa74bd11373f00143.jpg";
        Object url2 = Uri.parse("http://img1.3lian.com/2015/w2/10/d/64.jpg");

        //Glide.with(this).load("").into(img1);
        //Picasso.with(this).load("").into(img2);

        //ImageProxy imageProxy = ImageProxyFactory.create(Type.PICASSO);
        //IImageProxy imageProxy = ImageProxyFactory.create(Type.GLIDE);

        //ImageProxy.with(this).load(url1).into(img1);
        ImageProxy.with(this).load(url2).into(img2);
        loadBlur(img1, this, url1);

        ImageProxy.with(this).load(url1).transform(new CircleTransform()).into(img3);

        /*Glide.with(this).resumeRequests();
        Glide.with(this).pauseRequests();
        Glide.with(this).onTrimMemory(1);
        Glide.with(this).onLowMemory();
        Glide.with(this).onStart();
        Glide.with(this).onStop();
        Glide.with(this).onDestroy();*/
    }

    private void loadBlur(ImageView imageView, Context context, Object url) {
        ImageProxy.with(context)
                .load(url)
                //.placeholder(imageView.getDrawable())
                .bitmapTransform(
                        new BlurTransformation(23, 1),
                        new CropTransformation(imageView.getWidth(), imageView.getHeight()))
                .into(imageView);
    }
}
