package com.rafakob.utils;

import android.os.Environment;

import java.io.File;

public class SdcardUtils {
    public static boolean isWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    public static boolean isReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }

    public static boolean isDirCreated(File dir) {
        return dir.exists() || dir.mkdirs();
    }
}
