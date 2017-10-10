# ImageProxy #
图片加载包装代理，以实现不同的图片加载框架的快速替代，支持Glide和Picasso及自定义扩展。  

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
		compile 'com.github.EthanCo:ImageProxy:1.2.3-Glide-sol'
		//Picasso专版
		/compile 'com.github.EthanCo:ImageProxy:1.0.0-Picasso-sol'
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


### 圆形图 ###

		imageProxy.with(this).load(url1).transform(new CircleTransform(this)).into(img3);

## v1.2.3新增操作
### 1.使用起来更加便捷
无需再通过ImageProxyFactory.create获取实例  
	
	 ImageProxy.with(context)
        	.load(url)
        	.into(imageView);  

### 2.提升Glide版本
内部采用Glide4.0，除原先方法皆兼容可使用外，增加`apply()`方法，可进行扩展的使用。  

	ImageProxy.with(context)
        	.load(url)
			.apply(RequestOptions)
        	.into(imageView);

