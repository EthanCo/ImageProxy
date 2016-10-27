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

### 圆形图 ###

		imageProxy.with(this).load(url1).transform(new CircleTransform(this)).into(img3);

