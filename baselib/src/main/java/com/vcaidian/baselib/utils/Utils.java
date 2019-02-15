package com.vcaidian.baselib.utils;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityManager;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class Utils {
	public static final int PULSE_ANIMATOR_DURATION = 544;

	public static int getDaysInMonth(int month, int year) {
		switch (month) {
			case Calendar.JANUARY:
			case Calendar.MARCH:
			case Calendar.MAY:
			case Calendar.JULY:
			case Calendar.AUGUST:
			case Calendar.OCTOBER:
			case Calendar.DECEMBER:
				return 31;
			case Calendar.APRIL:
			case Calendar.JUNE:
			case Calendar.SEPTEMBER:
			case Calendar.NOVEMBER:
				return 30;
			case Calendar.FEBRUARY:
				return (year % 4 == 0) ? 29 : 28;
			default:
				throw new IllegalArgumentException("Invalid Month");
		}
	}

	public static ObjectAnimator getPulseAnimator(View labelToAnimate, float decreaseRatio, float increaseRatio) {
		Keyframe k0 = Keyframe.ofFloat(0f, 1f);
		Keyframe k1 = Keyframe.ofFloat(0.275f, decreaseRatio);
		Keyframe k2 = Keyframe.ofFloat(0.69f, increaseRatio);
		Keyframe k3 = Keyframe.ofFloat(1f, 1f);

		PropertyValuesHolder scaleX = PropertyValuesHolder.ofKeyframe("scaleX", k0, k1, k2, k3);
		PropertyValuesHolder scaleY = PropertyValuesHolder.ofKeyframe("scaleY", k0, k1, k2, k3);
		ObjectAnimator pulseAnimator = ObjectAnimator.ofPropertyValuesHolder(labelToAnimate, scaleX, scaleY);
		pulseAnimator.setDuration(PULSE_ANIMATOR_DURATION);

		return pulseAnimator;
	}

	public static boolean isJellybeanOrLater() {
		return Build.VERSION.SDK_INT >= 16;
	}

	/**
	 * Try to speak the specified text, for accessibility. Only available on JB or later.
	 * @param text Text to announce.
	 */
	@SuppressLint("NewApi")
	public static void tryAccessibilityAnnounce(View view, CharSequence text) {
		if (isJellybeanOrLater() && view != null && text != null) {
			view.announceForAccessibility(text);
		}
	}

	public static boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
		if (Build.VERSION.SDK_INT >= 14) {
			return accessibilityManager.isTouchExplorationEnabled();
		} else {
			return false;
		}
	}

	
    public static boolean isOnline(Context mContext)
    {
        ConnectivityManager cm = (ConnectivityManager)mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(cm.getActiveNetworkInfo() != null &&
           cm.getActiveNetworkInfo().isAvailable() &&
           cm.getActiveNetworkInfo().isConnected())
        {
            return true;
        }

        return false;
    }
    
	/**
	 * 查看某Activity是否存在
	 * @param context
	 * @param className
	 * @return
	 */
	public static boolean isExitActivity(Context context,String className){
		ActivityManager am = (ActivityManager) context  
		        .getSystemService(Context.ACTIVITY_SERVICE);  
		List<RunningTaskInfo> tasks = am.getRunningTasks(100);    
		
		Iterator<RunningTaskInfo> l = tasks.iterator();    
		while (l.hasNext()) {
			RunningTaskInfo si = (RunningTaskInfo) l.next();  
			if(si.topActivity.getClassName().equals(className))
			{
				return true;
			}
        }    
		return false;    
	}
	
	/**
	 * 查看某服务是否运行
	 * @param context
	 * @param className
	 * @return
	 */
	public static boolean isServiceRunning(Context context,String className) {     
		final ActivityManager activityManager = (ActivityManager) context    
                        .getSystemService(Context.ACTIVITY_SERVICE);    
		List<RunningServiceInfo> services = activityManager.getRunningServices(100);    

		Iterator<RunningServiceInfo> l = services.iterator();    
		while (l.hasNext()) {
			RunningServiceInfo si = (RunningServiceInfo) l.next();    
			if(si.service.getClassName().equals(className))
			{
				return true;
			}
        }    
		return false;    
	 } 
	
	/**
	 * 处理字符串，超过长多用户省略号代替
	 * @param text
	 * @param length
	 * @return
	 */
	public static String ellipsText(String text,int length){
		if(text.length()<=length){
			return text;
		}
		else{
			return String.format("%s...", text.substring(0, length));
		}
	}
	
    public static int dp2px(Context paramContext, float paramFloat) {
        float density = paramContext.getResources().getDisplayMetrics().density;
        return (int) (0.5F + paramFloat * density);
    }
	public final static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;

		return (int) (pxValue / scale + 0.5f);
	}
	public static int px2sp(Context context, float pxValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxValue / fontScale + 0.5f);
	}


	public static boolean hasOption(int options,int option){
		if( (options & option)  == option){
			return true;
		}
		return false;
	}


	public static String getPrintceptorSn(String url){
		if(!url.startsWith("http:")&&!url.startsWith("https:")){
			return null;
		}
		int lass = url.lastIndexOf("/");
		if(lass<=0){
			return null;
		}
		return url.substring(lass + 1);
	}

	public static long getLastDateTime(int date){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH,-date);
		return calendar.getTimeInMillis();
	}
	/**
	 * get the width of the device screen
	 *
	 * @param context
	 * @return
	 */
	public static int getScreenWidth(Context context) {
		return context.getResources().getDisplayMetrics().widthPixels;
	}

	/**
	 * get the height of the device screen
	 *
	 * @param context
	 * @return
	 */
	public static int getScreenHeight(Context context) {
		return context.getResources().getDisplayMetrics().heightPixels;
	}

	public static String encryText(String text,int preLength,int aftLength){
		if(text==null||text.length()<preLength+aftLength){
			return text;
		}
		StringBuilder builder = new StringBuilder();
		builder.append(text.substring(0,preLength));
		for(int i = preLength;i<text.length()-aftLength;i++){
			builder.append("*");
		}
		builder.append(text.substring(text.length() - aftLength));
		return builder.toString();
	}

	public static String encryptMac(String mac){
		StringBuilder strBuilder = new StringBuilder();
		String ms[] = mac.split(":");
		if(ms.length!=6){
			return null;
		}
		int ab = 0;
		for(String m : ms) {
			long lg = Long.parseLong(m, 16);
			ab += lg;
			String v = Long.toHexString(lg + 5);
			if(v.length()==1){
				strBuilder.append("0");
			}
			strBuilder.append(v);
		}
		strBuilder.append(Long.toHexString(ab % 256));
		return strBuilder.toString();
	}

	public static String decryptMac(String mac){
		if(mac.length()!=14){
			return null;
		}
		StringBuilder strBuilder = new StringBuilder();
		for(int i=0;i<6;i++) {
			if(i!=0){
				strBuilder.append(":");
			}
			String mc = mac.substring(i * 2, (i + 1) * 2);
			long lg = Long.parseLong(mc, 16);
			String v = Long.toHexString(lg - 5);
			if(v.length()==1){
				strBuilder.append("0");
			}
			strBuilder.append(v);
		}
		return strBuilder.toString();
	}

	public static void main(String args[]) {
		String mac = "98:6c:f5:67:3a:22";

		System.out.println(encryptMac(mac));

		int width = 611;

		float p = (float)width /90000;
		int moveImageTime = (int)(31/p);
		System.out.println(31/p);

	}



	public static boolean isWeixinAvilible(Context context) {
		final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
		List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
		if (pinfo != null) {
			for (int i = 0; i < pinfo.size(); i++) {
				String pn = pinfo.get(i).packageName;
				if (pn.equals("com.tencent.mm")) {
					return true;
				}
			}
		}

		return false;
	}

}
