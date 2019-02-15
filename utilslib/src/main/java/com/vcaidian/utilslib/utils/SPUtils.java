/*
 *   Copyright (C)  2016 android@19code.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.vcaidian.utilslib.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.List;

/**
 * Create by h4de5ing 2016/5/7 007
 */
public class SPUtils {

    private static SPUtils spUtils;
    private static SharedPreferences sp;

    private SPUtils(Context context, String name) {
        sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public static void getInstance(Context context, String name) {
        if (spUtils == null)
            spUtils = new SPUtils(context, name);
    }

    public static void setSP(String key, Object object) {
        String type = object.getClass().getSimpleName();
//        String packageName = context.getPackageName();
//        SharedPreferences sp = context.getSharedPreferences(packageName, Context.MODE_PRIVATE);
        Editor edit = sp.edit();
        if ("String".equals(type)) {
            edit.putString(key, (String) object);
        } else if ("Integer".equals(type)) {
            edit.putInt(key, (Integer) object);
        } else if ("Boolean".equals(type)) {
            edit.putBoolean(key, (Boolean) object);
        } else if ("Float".equals(type)) {
            edit.putFloat(key, (Float) object);
        } else if ("Long".equals(type)) {
            edit.putLong(key, (Long) object);
        }
        edit.apply();
    }

    public static Object getSp(String key, Object defaultObject) {
        String type = defaultObject.getClass().getSimpleName();
//        String packageName = context.getPackageName();
//        SharedPreferences sp = context.getSharedPreferences(packageName, Context.MODE_PRIVATE);
        if ("String".equals(type)) {
            return sp.getString(key, (String) defaultObject);
        } else if ("Integer".equals(type)) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if ("Boolean".equals(type)) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if ("Float".equals(type)) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if ("Long".equals(type)) {
            return sp.getLong(key, (Long) defaultObject);
        }
        return null;
    }

    public static void cleanAllSP(Context context) {
//        String packageName = context.getPackageName();
//        SharedPreferences sp = context.getSharedPreferences(packageName, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.clear();
        editor.apply();
    }


    public static void setSpList(String key, List<?> list) {
        String sList = null;
        try {
            sList = SceneList2String(list);
            setSP(key,sList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static  List getSpList(String key,String defaultObject) {
        List list = null;
        try {
            list = String2SceneList((String) getSp(key,defaultObject));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

//    /**
//     * 根据JSONArray String获取到List
//     * @param <T>
//     * @param <T>
//     * @param jArrayStr
//     * @return
//     */
//    public static <T> List<T> getListByArray(TypeToken<List<T>> typeOfT,String jArrayStr) {
//        Gson gson = new Gson();
//        List<T> list = gson.fromJson(jArrayStr, (Type) typeOfT);
//        return list;
//    }
//    /**
//     * 根据List获取到对应的JSONArray
//     *
//     * @param list
//     * @return
//     */
//    private static String getJSONArrayByList(List<?> list) {
//        Gson gson =  new Gson();
//        String s = gson.toJson(list);
//        return s;
//    }



    public static String SceneList2String(List SceneList)
            throws IOException {
        // 实例化一个ByteArrayOutputStream对象，用来装载压缩后的字节文件。
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // 然后将得到的字符数据装载到ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                byteArrayOutputStream);
        // writeObject 方法负责写入特定类的对象的状态，以便相应的 readObject 方法可以还原它
        objectOutputStream.writeObject(SceneList);
        // 最后，用Base64.encode将字节文件转换成Base64编码保存在String中
        String SceneListString = new String(Base64.encode(
                byteArrayOutputStream.toByteArray(), Base64.DEFAULT));
        // 关闭objectOutputStream
        objectOutputStream.close();
        return SceneListString;
    }

    @SuppressWarnings("unchecked")
    public static List String2SceneList(String SceneListString)
            throws StreamCorruptedException, IOException,
            ClassNotFoundException {
        byte[] mobileBytes = Base64.decode(SceneListString.getBytes(),
                Base64.DEFAULT);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                mobileBytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(
                byteArrayInputStream);
        List SceneList = (List) objectInputStream
                .readObject();
        objectInputStream.close();
        return SceneList;
    }
}
