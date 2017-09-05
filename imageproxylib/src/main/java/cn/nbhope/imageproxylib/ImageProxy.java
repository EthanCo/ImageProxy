package cn.nbhope.imageproxylib;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.View;

import cn.nbhope.imageproxylib.abs.IImageProxy;
import cn.nbhope.imageproxylib.abs.ILoader;
import cn.nbhope.imageproxylib.proxy.GlideProxy;

/**
 * ImageProxy
 *
 * @author EthanCo
 * @since 2017/9/5
 */

public class ImageProxy extends IImageProxy {
    private IImageProxy proxy = GlideProxy.getInstance();

    @Override
    public ILoader with(Fragment fragment) {
        return proxy.with(fragment);
    }

    @Override
    public ILoader with(android.support.v4.app.Fragment fragment) {
        return proxy.with(fragment);
    }

    @Override
    public ILoader with(Activity activity) {
        return proxy.with(activity);
    }

    @Override
    public ILoader with(Context context) {
        return proxy.with(context);
    }

    @Override
    public ILoader with(View view) {
        return proxy.with(view);
    }
}
