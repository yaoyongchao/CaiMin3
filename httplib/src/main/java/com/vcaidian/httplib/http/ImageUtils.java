/*
package com.vcaidian.httplib.http;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.TypedValue;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ImageUtils {

	public static String getImageViewData(ImageView imageView){
		BitmapDrawable drawable =(BitmapDrawable)imageView.getDrawable();
		if(drawable==null) return null;
    	Bitmap bitmap = drawable.getBitmap(); 
    	ByteArrayOutputStream stream = new ByteArrayOutputStream();
    	bitmap.compress(Bitmap.CompressFormat.PNG, 40, stream);
    	byte[] byteArray = stream.toByteArray();
    	return Coder.encryptBASE64(byteArray);

	}

	public static byte[] getImageViewData(Bitmap bitmap){
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
		byte[] byteArray = stream.toByteArray();
		return byteArray;
	}
	public static String getImageViewDataBase64(Bitmap bitmap){
		byte[] byteArray = getImageViewData(bitmap);
		return Coder.encryptBASE64(byteArray);
	}

	public static byte[] bitmap2bmp(Bitmap bitmap){
		
		int w = bitmap.getWidth(), h = bitmap.getHeight();
		int[] pixels=new int[w*h];
		bitmap.getPixels(pixels, 0, w, 0, 0, w, h);
		
		byte[] rgb = addBMP_RGB_888(pixels,w,h);
		byte[] header = addBMPImageHeader(rgb.length);
		byte[] infos = addBMPImageInfosHeader(w, h);


		byte[] buffer = new byte[54 + rgb.length];
		System.arraycopy(header, 0, buffer, 0, header.length);
		System.arraycopy(infos, 0, buffer, 14, infos.length);
		System.arraycopy(rgb, 0, buffer, 54, rgb.length);
		return buffer;
	}
	
	private static byte[] addBMPImageHeader(int size) {
		byte[] buffer = new byte[14];
		buffer[0] = 0x42;
		buffer[1] = 0x4D;
		buffer[2] = (byte) (size >> 0);
		buffer[3] = (byte) (size >> 8);
		buffer[4] = (byte) (size >> 16);
		buffer[5] = (byte) (size >> 24);
		buffer[6] = 0x00;
		buffer[7] = 0x00;
		buffer[8] = 0x00;
		buffer[9] = 0x00;
		buffer[10] = 0x36;
		buffer[11] = 0x00;
		buffer[12] = 0x00;
		buffer[13] = 0x00;
		return buffer;
	}

	
	private static byte[] addBMPImageInfosHeader(int w, int h) {
		byte[] buffer = new byte[40];
		buffer[0] = 0x28;
		buffer[1] = 0x00;
		buffer[2] = 0x00;
		buffer[3] = 0x00;
		buffer[4] = (byte) (w >> 0);
		buffer[5] = (byte) (w >> 8);
		buffer[6] = (byte) (w >> 16);
		buffer[7] = (byte) (w >> 24);
		buffer[8] = (byte) (h >> 0);
		buffer[9] = (byte) (h >> 8);
		buffer[10] = (byte) (h >> 16);
		buffer[11] = (byte) (h >> 24);
		buffer[12] = 0x01;
		buffer[13] = 0x00;
		buffer[14] = 0x18;
		buffer[15] = 0x00;
		buffer[16] = 0x00;
		buffer[17] = 0x00;
		buffer[18] = 0x00;
		buffer[19] = 0x00;
		buffer[20] = 0x00;
		buffer[21] = 0x00;
		buffer[22] = 0x00;
		buffer[23] = 0x00;
		buffer[24] = (byte) 0xE0;
		buffer[25] = 0x01;
		buffer[26] = 0x00;
		buffer[27] = 0x00;
		buffer[28] = 0x02;
		buffer[29] = 0x03;
		buffer[30] = 0x00;
		buffer[31] = 0x00;
		buffer[32] = 0x00;
		buffer[33] = 0x00;
		buffer[34] = 0x00;
		buffer[35] = 0x00;
		buffer[36] = 0x00;
		buffer[37] = 0x00;
		buffer[38] = 0x00;
		buffer[39] = 0x00;
		return buffer;
	}
	
	private static byte[] addBMP_RGB_888(int[] b,int w, int h) {
		int len = b.length;
		byte[] buffer = new byte[w*h * 3];
		int offset=0;
		for (int i = len-1; i>=w; i-=w) {
			//DIB文件格式最后一行为第一行，每行按从左到右顺序
			int end=i,start=i-w+1;
			for(int j=start;j<=end;j++){
				buffer[offset]=(byte)(b[j]>>0);
				buffer[offset+1]=(byte)(b[j]>>8);
				buffer[offset+2]=(byte)(b[j]>>16);
				offset += 3;
			}
		}
		return buffer;
	}



	//使用Bitmap加Matrix来缩放
	public static Bitmap resizeImage(Bitmap bitmap, int w, int h)
	{
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();

		float scaleWidth = ((float) w) / width;
		float scaleHeight = ((float) h) / height;

		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width,
				height, matrix, true);
		return resizedBitmap;
	}
	public static Bitmap decodeResource(Resources resources, int id) {
		TypedValue value = new TypedValue();
		resources.openRawResource(id, value);
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inTargetDensity = value.density;
		return BitmapFactory.decodeResource(resources, id, opts);
	}

	public static Bitmap toConformBitmap(Bitmap background, Bitmap foreground) {
		Bitmap temp_bitmap = background.copy(Bitmap.Config.ARGB_8888, true);//
		Paint paint = new Paint();
		Canvas cv = new Canvas(temp_bitmap);
		//draw fg into
		cv.drawBitmap(foreground, 50, 0, paint);//在 0，0坐标开始画入fg ，可以从任意位置画入
		//save all clip
//		cv.save(Canvas.ALL_SAVE_FLAG)//保存
//store
		cv.restore();//存储
		return temp_bitmap;
	}

	private static List<MyColor> colors= new ArrayList<MyColor>();


	static class MyColor{
		public MyColor(int minNum,int maxNum,int bgColor,int textColor){
			this.maxNum = maxNum;
			this.minNum = minNum;
			this.textColor = textColor;
			this.bgColor = bgColor;
		}
		int maxNum = 0;
		int minNum = 0;
		int textColor = 0xFF000000;
		int bgColor = 0xFF999999;
	}
	static {
		colors.add(new MyColor(-1,-1,0xFF000000,0xFFFFFFFF));
		colors.add(new MyColor(0,0,0xFFCAE8C1,0xFF000000));
		colors.add(new MyColor(1,1,0xFF5AAF6B,0xFF000000));
		colors.add(new MyColor(2,5,0xFF00FF00,0xFF000000));
		colors.add(new MyColor(6,10,0xFFE34017,0xFFFFFFFF));
		colors.add(new MyColor(11,20,0xFF3F7832,0xFFFFFFFF));
		colors.add(new MyColor(21,1000000,0xFF2529DA,0xFFFFFFFF));
	}

	public static Bitmap createImage(Context context,int imageSize,int number) {
		if(number>99){
			number = 99;
		}

		Bitmap output = Bitmap.createBitmap(imageSize,imageSize, Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(output);
		Paint paint = new Paint();

		paint.setAntiAlias(true);
		paint.setFilterBitmap(true);
		paint.setDither(true);
		paint.setColor(Color.BLACK);
		canvas.drawCircle(imageSize / 2, imageSize / 2, imageSize / 2, paint);

		MyColor myColor = null;
		for(MyColor c :colors){
			if(c.minNum<=number && c.maxNum>=number){
				myColor = c;
				break;
			}
		}
		if(myColor==null) myColor = colors.get(0);
		paint.setColor(myColor.bgColor);
		canvas.drawCircle(imageSize / 2, imageSize / 2, imageSize / 2-1, paint);

		if (number < 10) {
			paint.setTextSize(Utils.dp2px(context, 20));
		} else {
			paint.setTextSize(Utils.dp2px(context, 16));
		}
		paint.setColor(myColor.textColor);

		Rect rect = new Rect(0, 0, imageSize,imageSize);
		paint.getTextBounds(String.valueOf(number), 0, String.valueOf(number).length(), rect);
		int w = rect.width();
		int textHeight = rect.bottom - rect.top;
		canvas.drawText(String.valueOf(number), (imageSize - w) / 2, (imageSize + textHeight)/ 2,
				paint);
		return output;
	}

	public static Bitmap createConsumerImage(Context context,int imageSize,int number) {
		if(number>99){
			number = 99;
		}

		Bitmap output = Bitmap.createBitmap(imageSize,imageSize, Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		MyColor myColor = null;
		for(MyColor c :colors){
			if(c.minNum<=number && c.maxNum>=number){
				myColor = c;
				break;
			}
		}
		if(myColor==null) myColor = colors.get(0);
		canvas.drawColor(myColor.bgColor);
		Paint paint = new Paint();

		if (number < 10) {
			paint.setTextSize(Utils.dp2px(context, 20));
		} else {
			paint.setTextSize(Utils.dp2px(context, 16));
		}
		paint.setColor(myColor.textColor);

		Rect rect = new Rect(0, 0, imageSize,imageSize);
		paint.getTextBounds(String.valueOf(number), 0, String.valueOf(number).length(), rect);
		int w = rect.width();
		int textHeight = rect.bottom - rect.top;
		canvas.drawText(String.valueOf(number), (imageSize - w) / 2, (imageSize + textHeight) / 2,
				paint);
		return output;
	}

	private void drawCircleBorder(Canvas canvas,int size, int radius, int color) {
		Paint paint = new Paint();
        */
/* 去锯齿 *//*

		paint.setAntiAlias(true);
		paint.setFilterBitmap(true);
		paint.setDither(true);
		paint.setColor(color);
        */
/* 设置paint的　style　为STROKE：空心 *//*

		paint.setStyle(Paint.Style.STROKE);
        */
/* 设置paint的外框宽度 *//*

		paint.setStrokeWidth(1);
		canvas.drawCircle(size / 2, size / 2, radius, paint);
	}

	private static void drawMaskBitmap(Bitmap mask) {
		Canvas canvas_m = new Canvas(mask);
		Paint paint_m = new Paint();
		Path path = new Path();

		path.addCircle(500, 400, 270, Path.Direction.CCW);
		paint_m.setAntiAlias(true);
		paint_m.setAlpha(0xff);
		canvas_m.drawPath(path, paint_m);
	}

	*/
/**
	 * 根据原图和变长绘制圆形图片
	 *
	 * @param source
	 * @param min
	 * @return
	 *//*

	public static Bitmap createCircleImage(Bitmap source, int min)
	{
		Bitmap bitmap = ImageUtils.resizeImage(source, min-1, min-1);

		Paint paint = new Paint();
		paint.setAntiAlias(true);
		Bitmap target = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);


		*/
/**
		 * 产生一个同样大小的画布
		 *//*

		Canvas canvas = new Canvas(target);
		canvas.drawCircle(min / 2, min / 2, min / 2, paint);
		*/
/**
		 * 使用SRC_IN
		 *//*

		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
		*/
/**
		 * 绘制图片
		 *//*

		canvas.drawBitmap(bitmap, 1, 1, paint);
		paint.setAntiAlias(true);
		paint.setFilterBitmap(true);
		paint.setDither(true);
		paint.setColor(Color.BLACK);
        */
/* 设置paint的　style　为STROKE：空心 *//*

		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(1);
		canvas.drawCircle(min / 2, min / 2, min/2, paint);

		return target;
	}
	*/
/**
	 * 根据路径获得图片信息并按比例压缩，返回bitmap
	 *//*

	public static Bitmap getSmallBitmap(Bitmap image) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.JPEG, 60, baos);// 质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
		int options = 30;

		while (baos.toByteArray().length / 1024 > 100) { // 循环判断如果压缩后图片是否大于100kb,大于继续压缩
			baos.reset(); // 重置baos即清空baos
			image.compress(Bitmap.CompressFormat.JPEG, options, baos);// 这里压缩options%，把压缩后的数据存放到baos中
			options -= 10;// 每次都减少10
		}
		ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());// 把压缩后的数据baos存放到ByteArrayInputStream中
		Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);// 把ByteArrayInputStream数据生成图片
		return bitmap;
	}
	*/
/**
	 * 根据路径获得图片信息并按比例压缩，返回bitmap
	 *//*

	public static Bitmap getSmallBitmap(String filePath) {
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;//只解析图片边沿，获取宽高
		BitmapFactory.decodeFile(filePath, options);
		// 计算缩放比
		options.inSampleSize = calculateInSampleSize(options, 800, 400);
		// 完整解析图片返回bitmap
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeFile(filePath, options);
	}

	public static int calculateInSampleSize(BitmapFactory.Options options,
											int reqWidth, int reqHeight) {
		final int height = options.outHeight;
		final int width = options.outWidth;

		System.out.println("height   " +height);
		System.out.println("width   " +width);

		int inSampleSize = 1;
		if (height > reqHeight || width > reqWidth) {
			final int heightRatio = Math.round((float) height / (float) reqHeight);
			final int widthRatio = Math.round((float) width / (float) reqWidth);
			inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
		}
		return inSampleSize;
	}


	public static String getRealFilePath( final Context context, final Uri uri ) {
		if ( null == uri ) return null;
		final String scheme = uri.getScheme();
		String data = null;
		if ( scheme == null )
			data = uri.getPath();
		else if ( ContentResolver.SCHEME_FILE.equals( scheme ) ) {
			data = uri.getPath();
		} else if ( ContentResolver.SCHEME_CONTENT.equals( scheme ) ) {
			Cursor cursor = context.getContentResolver().query( uri, new String[] { MediaStore.Images.ImageColumns.DATA }, null, null, null );
			if ( null != cursor ) {
				if ( cursor.moveToFirst() ) {
					int index = cursor.getColumnIndex( MediaStore.Images.ImageColumns.DATA );
					if ( index > -1 ) {
						data = cursor.getString( index );
					}
				}
				cursor.close();
			}
		}
		return data;
	}

	public static byte[] bmpToByteArray(final Bitmap bmp, final boolean needRecycle) {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		bmp.compress(Bitmap.CompressFormat.PNG, 100, output);
		if (needRecycle) {
			bmp.recycle();
		}

		byte[] result = output.toByteArray();
		try {
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}


	public static byte[] getCompressedImage(Bitmap bitmap,int size){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
		int options = 100;
		while (baos.toByteArray().length / 1024 > size) {  //循环判断如果压缩后图片是否大于100kb,大于继续压缩
			baos.reset();//重置baos即清空baos
			//第一个参数 ：图片格式 ，第二个参数： 图片质量，100为最高，0为最差  ，第三个参数：保存压缩后的数据的流
			bitmap.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
			options -= 10;//每次都减少10
		}

		byte[] byteArray = baos.toByteArray();
		return byteArray;
	}
	public static Bitmap getScaledBitmap(Context context,Uri uri,int ww,int hh){
		try {
			InputStream input = context.getContentResolver().openInputStream(uri);
			BitmapFactory.Options onlyBoundsOptions = new BitmapFactory.Options();
			onlyBoundsOptions.inJustDecodeBounds = true;
			onlyBoundsOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
			BitmapFactory.decodeStream(input, null, onlyBoundsOptions);
			input.close();
			int originalWidth = onlyBoundsOptions.outWidth;
			int originalHeight = onlyBoundsOptions.outHeight;
			//图片分辨率以480x800为标准
			//缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
			int be = 1;//be=1表示不缩放
			if (originalWidth > originalHeight && originalWidth > ww) {//如果宽度大的话根据宽度固定大小缩放
				be = (int) (originalWidth / ww);
			} else if (originalWidth < originalHeight && originalHeight > hh) {//如果高度高的话根据宽度固定大小缩放
				be = (int) (originalHeight / hh);
			}
			if (be <= 0)
				be = 1;
			//比例压缩
			BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
			bitmapOptions.inSampleSize = be;//设置缩放比例
			bitmapOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
			input = context.getContentResolver().openInputStream(uri);
			Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);
			input.close();
			return bitmap;
		}
		catch (Exception e){
			return null;
		}
	}

	public static Bitmap getScaledBitmap(File file,int ww,int hh){
		BitmapFactory.Options onlyBoundsOptions = new BitmapFactory.Options();
		onlyBoundsOptions.inJustDecodeBounds = true;
		onlyBoundsOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
		BitmapFactory.decodeFile(file.getPath(), onlyBoundsOptions);
		int originalWidth = onlyBoundsOptions.outWidth;
		int originalHeight = onlyBoundsOptions.outHeight;
		//图片分辨率以480x800为标准
		//缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
		int be = 1;//be=1表示不缩放
		if (originalWidth > originalHeight && originalWidth > ww) {//如果宽度大的话根据宽度固定大小缩放
			be = (int) (originalWidth / ww);
		} else if (originalWidth < originalHeight && originalHeight > hh) {//如果高度高的话根据宽度固定大小缩放
			be = (int) (originalHeight / hh);
		}
		if (be <= 0)
			be = 1;
		//比例压缩
		BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
		bitmapOptions.inSampleSize = be;//设置缩放比例
		bitmapOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
		Bitmap bitmap = BitmapFactory.decodeFile(file.getPath(), bitmapOptions);
		return bitmap;
	}
}
*/
