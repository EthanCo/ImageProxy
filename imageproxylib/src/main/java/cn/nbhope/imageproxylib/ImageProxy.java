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

public class ImageProxy {
    private static IImageProxy proxy = GlideProxy.getInstance();

    public static ILoader with(Fragment fragment) {
        return proxy.with(fragment);
    }

    public static ILoader with(android.support.v4.app.Fragment fragment) {
        return proxy.with(fragment);
    }

    public static ILoader with(Activity activity) {
        return proxy.with(activity);
    }

    public static ILoader with(Context context) {
        return proxy.with(context);
    }

    public static ILoader with(View view) {
        return proxy.with(view);
    }
}
