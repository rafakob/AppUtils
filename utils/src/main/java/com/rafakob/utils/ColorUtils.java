package com.rafakob.utils;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;

public class ColorUtils {
    @ColorInt
    public static int getFromAttr(@NonNull final Context context, @AttrRes final int colorAttr) {
        final TypedValue value = new TypedValue();
        if (context.getTheme().resolveAttribute(colorAttr, value, true)) {
            return value.data;
        }
        return 0;
    }

    @ColorInt
    public static int getFromRes(@NonNull final Context context, @ColorRes final int colorRes) {
        return ContextCompat.getColor(context, colorRes);
    }

    @ColorInt
    public static int getFromAttrOrRes(@NonNull final Context context, @AttrRes int colorAttr, @ColorRes int colorRes) {
        int color = getFromAttr(context, colorAttr);
        if (color == 0) {
            color = getFromRes(context, colorRes);
        }
        return color;
    }
}
