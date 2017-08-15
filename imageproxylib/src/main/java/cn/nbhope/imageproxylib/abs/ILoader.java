package cn.nbhope.imageproxylib.abs;

import android.net.Uri;

import java.io.File;

/**
 * @Description 装载者
 * Created by EthanCo on 2016/6/27.
 */
public interface ILoader {
    /**
     * 加载图片
     *
     * @param url 图片URL
     * @return
     */
    ICreator load(String url);

    ICreator load(Uri uri);

    ICreator load(File file);

    ICreator load(Integer resourceId);

    ICreator load(byte[] model);

    <V> ICreator load(V model);

    void pauseRequests();
}
