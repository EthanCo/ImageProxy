package cn.nbhope.imageproxylib.proxy;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

import cn.nbhope.imageproxylib.abs.ICreator;
import cn.nbhope.imageproxylib.abs.IImageProxy;
import cn.nbhope.imageproxylib.abs.ILoader;

/**
 * @Description Glide代理
 * Created by EthanCo on 2016/6/23.
 */
public class GlideProxy extends IImageProxy {

    private GlideProxy() {
    }

    private static class SingleTonHolder {
        private static GlideProxy sInstance = new GlideProxy();
    }

    public static GlideProxy getInstance() {
        return SingleTonHolder.sInstance;
    }

    public ILoader with(Context context) {
        return new Loader(Glide.with(context));
    }

    @Override
    public ILoader with(View view) {
        return new Loader(Glide.with(view));
    }

    public ILoader with(Activity activity) {
        return new Loader(Glide.with(activity));
    }

    public ILoader with(Fragment fragment) {
        return new Loader(Glide.with(fragment.getActivity()));
    }

    public ILoader with(android.app.Fragment fragment) {
        return new Loader(Glide.with(fragment.getActivity()));
    }

    private static class Loader implements ILoader {

        private RequestManager proxy;

        public Loader(RequestManager proxy) {
            this.proxy = proxy;
        }

        @Override
        public ICreator load(String url) {
            RequestBuilder<Drawable> creator = proxy.load(url);
            return new Creator(creator);
        }

        @Override
        public ICreator load(Uri uri) {
            RequestBuilder<Drawable> creator = proxy.load(uri);
            return new Creator(creator);
        }

        @Override
        public ICreator load(File file) {
            RequestBuilder<Drawable> creator = proxy.load(file);
            return new Creator(creator);
        }

        @Override
        public ICreator load(Integer resourceId) {
            RequestBuilder<Drawable> creator = proxy.load(resourceId);
            return new Creator(creator);
        }

        @Override
        public ICreator load(byte[] model) {
            RequestBuilder<Drawable> creator = proxy.load(model);
            return new Creator(creator);
        }

        @Override
        public <V> ICreator load(V model) {
            RequestBuilder<Drawable> creator = proxy.load(model);
            return new Creator(creator);
        }

        @Override
        public void resumeRequests() {
            proxy.resumeRequests();
        }

        @Override
        public void pauseRequests() {
            proxy.pauseRequests();
        }

        @Override
        public void onStart() {
            proxy.onStart();
        }

        @Override
        public void onStop() {
            proxy.onStop();
        }

        @Override
        public void onDestroy() {
            proxy.onDestroy();
        }

        @Override
        public void onLowMemory() {
            proxy.onLowMemory();
        }
    }

    private static class Creator implements ICreator {
        private final RequestBuilder creator;

        public Creator(RequestBuilder creator) {
            this.creator = creator;
        }

        @Override
        public Creator crossFade() {
            creator.transition(DrawableTransitionOptions.withCrossFade());
            //.transition(new DrawableTransitionOptions().crossFade(2000));
            return this;
        }

        @Override
        public Creator centerCrop() {
            RequestOptions options = new RequestOptions().centerCrop();
            creator.apply(options);
            return this;
        }

        @Override
        public Creator override(int width, int height) {
            RequestOptions options = new RequestOptions().override(width, height);
            creator.apply(options);
            return this;
        }

        @Override
        public ICreator thumbnail(float sizeMultiplier) {
            creator.thumbnail(sizeMultiplier);
            return this;
        }

        @Override
        public ICreator placeholder(@DrawableRes int resourceId) {
            RequestOptions options = new RequestOptions().placeholder(resourceId);
            creator.apply(options);
            return this;
        }

        @Override
        public ICreator placeholder(Drawable drawable) {
            RequestOptions options = new RequestOptions().placeholder(drawable);
            creator.apply(options);
            return this;
        }

        @Override
        public ICreator error(@DrawableRes int resourceId) {
            RequestOptions options = new RequestOptions().placeholder(resourceId);
            creator.apply(options);
            return this;
        }

        @Override
        public ICreator error(Drawable drawable) {
            RequestOptions options = new RequestOptions().placeholder(drawable);
            creator.apply(options);
            return this;
        }

        @Override
        public ICreator transform(BitmapTransformation... transformations) {
            if (transformations.length > 1) {
                throw new IllegalArgumentException("Glide4.X 只支持一个参数");
            }
            RequestOptions options = new RequestOptions().transform(transformations[0]);
            creator.apply(options);
            return this;
        }

        @Override
        public ICreator bitmapTransform(Transformation<Bitmap>... bitmapTransformations) {
            if (bitmapTransformations.length > 1) {
                throw new IllegalArgumentException("Glide4.X 只支持一个参数");
            }
            RequestOptions options = new RequestOptions().bitmapTransform(bitmapTransformations[0]);
            creator.apply(options);
            return this;
        }

        @Override
        public ICreator apply(RequestOptions options) {
            creator.apply(options);
            return this;
        }

        @Override
        public void into(ImageView view) {
            creator.into(view);
        }
    }
}
