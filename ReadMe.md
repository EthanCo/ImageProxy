# ImageProxy #
图片加载包装代理，以实现不同的图片加载框架的快速替代  

## 添加依赖 ##

### Step 1. Add the JitPack repository to your build file ###
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}

### Step 2. Add the dependency ###

		dependencies {
			//Glide专版
	        compile 'com.github.EthanCo:ImageProxy:1.0.0-Glide-sol'
			//Picasso专版
			//compile 'com.github.EthanCo:ImageProxy:1.0.0-Picasso-sol'
			//集成了Glide和Picasso
			//compile 'com.github.EthanCo:ImageProxy:1.0.0'
	}

## 使用 ##

	    //ImageProxy imageProxy = ImageProxyFactory.create(Type.PICASSO);
        ImageProxy imageProxy = ImageProxyFactory.create(Type.GLIDE);

		imageProxy.with(this).load(url1).into(img1);  
		
### 其他操作 ###

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
     * 先加载缩略图，再加载完整的图片
     *
     * @param sizeMultiplier 缩略图比例 0-1
     * @return
     */
    ICreator thumbnail(float sizeMultiplier);

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
     * 将图片加载到ImageView
     *
     * @param view
     */
    void into(ImageView view);

    /**
     * 取得Bitmap进行处理
     *
     * @param simpleTarget
     */
    void into(SimpleTarget<Bitmap> simpleTarget);


### 圆形图 ###

		imageProxy.with(this).load(url1).transform(new CircleTransform(this)).into(img3);

