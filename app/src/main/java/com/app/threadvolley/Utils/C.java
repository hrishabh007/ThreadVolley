package com.app.threadvolley.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by MyNew on 8/23/2017.
 */

public class C {


    public static boolean isEmpty(String str){
        return str == null || str.trim().equals("") || str.trim().toLowerCase().equalsIgnoreCase("null");
    }


    public static File getProfilePicFile(Context context, String name){
        File mydir1 = context.getDir("mydir", Context.MODE_PRIVATE); //Creating an internal dir;
        File instantFile1 = new File(mydir1, "Profile");
        if(!instantFile1.exists()){
            instantFile1.mkdir();
        }
        return new File(instantFile1, name);
    }

    public static File getGallaryPicFile(Context context, String name){
        File mydir1 = context.getDir("mydir", Context.MODE_PRIVATE); //Creating an internal dir;
        File instantFile1 = new File(mydir1, "Gallery");
        if(!instantFile1.exists()){
            instantFile1.mkdir();
        }
        return new File(instantFile1, name);
    }

    public static void storeBitmapToFile(File pictureFile, Bitmap image) {
        if (pictureFile == null) {
            return;
        }
        try {
            if(image == null){
                return;
            }
            FileOutputStream fos = new FileOutputStream(pictureFile);
            image.compress(Bitmap.CompressFormat.PNG, 90, fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteAllPrivateDir(Context context){
        try{
            File mydir = context.getDir("mydir", Context.MODE_PRIVATE);
            if(mydir.exists()){
                deleteRecursive(mydir);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteRecursive(File fileOrDirectory) {
        try{
            if (fileOrDirectory.isDirectory()) {
                for (File child : fileOrDirectory.listFiles()) {
                    deleteRecursive(child);
                }
            }

            fileOrDirectory.delete();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void hideKeyboard(View view) {
        try {
            if (view == null) {
                return;
            }
            InputMethodManager imm = (InputMethodManager) view.getContext()
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            if (!imm.isActive()) {
                return;
            }
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public static String getTempFilePath(Context context){
        File mydir1 = context.getDir("mydir", Context.MODE_PRIVATE); //Creating an internal dir;
        File instantFile1 = new File(mydir1, "VehicalImage");
        if(!instantFile1.exists()){
            instantFile1.mkdir();
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS")
                .format(new Date());
        return new File(instantFile1, "CROP_" + timeStamp + ".jpg").getAbsolutePath();
    }*/

    /*public static String getProfileFilePath(Context context){
        File mydir1 = context.getDir("mydir", Context.MODE_PRIVATE); //Creating an internal dir;
        File instantFile1 = new File(mydir1, "Profile");
        if(!instantFile1.exists()){
            instantFile1.mkdir();
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS")
                .format(new Date());
        return new File(instantFile1, timeStamp+".jpg").getAbsolutePath();
    }*/

    /*public static String getMyProfilePath(){
        return Prefs.getString(PrefKeys.PROFILE_PIC, "");
    }*/


    /*public static void deleteFile(String path){
        try{
            File file = new File(path);
            if(file.exists()){
                file.delete();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/


    /*public static void deleteProfileFilePath(){
        try{
            File file = new File(getMyProfilePath());
            if(file.exists()){
                file.delete();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

    /*public static File getDeleteFile(Context context){
        File mydir1 = context.getDir("mydir", Context.MODE_PRIVATE); //Creating an internal dir;
        File instantFile1 = new File(mydir1, "DeleteImage");
        if(!instantFile1.exists()){
            instantFile1.mkdir();
        }
        File deleteFile = new File(instantFile1, "onepx.png");
        return deleteFile;
    }*/

    /*public static String getDeleteImage(Context context){
        try{
            File out = getDeleteFile(context);

            if(out.exists()){
                return out.getAbsolutePath();
            }
            else{

                AssetManager assetManager = context.getAssets();
                InputStream is = assetManager.open("onepx.png");

                byte[] buffer = new byte[1024];
                FileOutputStream fos = new FileOutputStream(out);
                int read = 0;

                while ((read = is.read(buffer, 0, 1024)) >= 0) {
                    fos.write(buffer, 0, read);
                }

                fos.flush();
                fos.close();
                is.close();

                return out.getAbsolutePath();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }*/


    // public static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /*public static String getCurrentActualUTCDate() {
        ZonedDateTime nowUTC = ZonedDateTime.now( ZoneOffset.UTC );
        String utcDate = nowUTC.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(simpleDateFormat.parse(utcDate));
            long diff = Prefs.getLong(PrefKeys.TIME_DIFFERENCE, 0);
            calendar.add(Calendar.MILLISECOND, (int) diff);
            Date dateNew = calendar.getTime();
            utcDate = simpleDateFormat.format(dateNew);
        }catch (Exception e){
            e.printStackTrace();
        }
        return utcDate;
    }*/

    /*public static String getLocalTimeFromUTC(String utcDate) {
        String newDate = "";
        try{
            ZonedDateTime zdtDateUTC = ZonedDateTime.parse(utcDate);
            ZonedDateTime zdtCurrent = ZonedDateTime.ofInstant(zdtDateUTC.toInstant(), ZonedDateTime.now().getZone());

            newDate = zdtCurrent.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
        }catch (Exception e){
            e.printStackTrace();
        }
        return newDate;
    }*/

    /*public static String getDisplayTime(String inputString) {
        String reformattedStr = "";
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
            SimpleDateFormat myFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(simpleDateFormat.parse(inputString));
            long diff = Prefs.getLong(PrefKeys.TIME_DIFFERENCE, 0);
            calendar.add(Calendar.MILLISECOND, (((int) diff) * -1));
            Date dateNew = calendar.getTime();

            String pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
            SimpleDateFormat zonedDateTimeFormat = new SimpleDateFormat(pattern);
            String utcDate = zonedDateTimeFormat.format(dateNew);

            String msgTime =  C.getLocalTimeFromUTC(utcDate);

            reformattedStr = myFormat.format(simpleDateFormat.parse(msgTime));

        }catch (Exception e){
            e.printStackTrace();
        }
        return reformattedStr;
    }*/


    /*public static String convertToServerDate(String sourceD){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(simpleDateFormat.parse(sourceD));
            long diff = Prefs.getLong(PrefKeys.TIME_DIFFERENCE, 0);
            calendar.add(Calendar.MILLISECOND, (((int) diff)));
            Date dateNew = calendar.getTime();


            DateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            return  sdf.format(dateNew);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sourceD;
    }*/

    /*public static String convertToServerTime(String sourceD){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(simpleDateFormat.parse(sourceD));
            long diff = Prefs.getLong(PrefKeys.TIME_DIFFERENCE, 0);
            calendar.add(Calendar.MILLISECOND, (((int) diff)));
            Date dateNew = calendar.getTime();


            DateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
            sdf1.setTimeZone(TimeZone.getTimeZone("UTC"));
            return  sdf1.format(dateNew);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sourceD;
    }*/

    /*public static String showTripDate(String source){
        try{
            String pattern = "dd/MM/yyyy";
            DateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
            DateFormat sdfF = new SimpleDateFormat(pattern);
            Date date = sdf.parse(source);
            return sdfF.format(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        return source;
    }*/

    /*public static String showTripTime(String source){
        try{
            String pattern = "hh:mm a";
            DateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
            DateFormat sdfF = new SimpleDateFormat(pattern);
            Date date = sdf.parse(source);
            return sdfF.format(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        return source;
    }*/

}
