package cn.nbhope.imageproxylib.proxy;

import cn.nbhope.imageproxylib.abs.IImageProxy;

/**
 * @Description ImageProxy 工厂
 * @deprecated  现在使用ImageProxy即可
 * Created by EthanCo on 2016/8/12.
 *
 */
@Deprecated
public class ImageProxyFactory {
    @Deprecated
    public static IImageProxy create(Type type) {
        if (type == Type.GLIDE) {
            return GlideProxy.getInstance();
        }
//      else
//      if (type == Type.PICASSO) {
//          return PicassoProxy.getInstace();
//      }
        throw new IllegalArgumentException("not found type:" + type);
    }
}
