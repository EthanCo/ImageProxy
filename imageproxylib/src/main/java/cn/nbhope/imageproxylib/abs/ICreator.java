package cn.nbhope.imageproxylib.abs;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.widget.ImageView;

import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.RequestOptions;

/**
 * @Description 图片建造者
 * Created by EthanCo on 2016/6/23.
 */
public interface ICreator {
    /**
     * 设置淡入淡出效果
     *
     * @return
     */
    ICreator crossFade();

    /**
     * ScaleType - centerCrop
     *
     * @return
     */
    ICreator centerCrop();

    /**
     * 指定大小
     *
     * @param width
     * @param height
     * @return
     */
    ICreator override(int width, int height);

    /**
     * 加载缩略图(预览图)
     *
     * @param sizeMultiplier 缩略图比例 0-1
     * @return
     */
    ICreator thumbnail(@FloatRange(from = 0, to = 1) float sizeMultiplier);

    /**
     * 设置占位图
     *
     * @param resourceId
     * @return
     */
    ICreator placeholder(@DrawableRes int resourceId);

    /**
     * 设置占位图
     *
     * @param drawable
     * @return
     */
    ICreator placeholder(Drawable drawable);

    /**
     * 设置加载错误时显示的图片
     *
     * @param resourceId
     * @return
     */
    ICreator error(@DrawableRes int resourceId);

    /**
     * 设置加载错误时显示的图片
     *
     * @param drawable
     * @return
     */
    ICreator error(Drawable drawable);


    /**
     * 变换
     *
     * @param transformations
     * @return
     */
    ICreator transform(BitmapTransformation... transformations);

    /**
     * Bitmap 变换
     *
     * @param bitmapTransformations
     * @return
     */
    ICreator bitmapTransform(Transformation<Bitmap>... bitmapTransformations);

    /**
     * apply
     *
     * @param options
     * @return
     */
    ICreator apply(RequestOptions options);

    /**
     * 将图片加载到ImageView
     *
     * @param view
     */
    void into(ImageView view);
}
