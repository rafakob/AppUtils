package com.rafakob.utils.holder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.rafakob.utils.ColorUtils;


public class ColorHolder {
    private int mColorInt = 0;
    private int mColorRes = -1;
    private int mColorAttr = -1;

    public ColorHolder() {
    }

    public static ColorHolder fromInt(@ColorInt int colorInt) {
        ColorHolder colorHolder = new ColorHolder();
        colorHolder.mColorInt = colorInt;
        return colorHolder;
    }

    public static ColorHolder fromRes(@ColorRes int colorRes) {
        ColorHolder colorHolder = new ColorHolder();
        colorHolder.mColorRes = colorRes;
        return colorHolder;
    }

    public static ColorHolder fromAttr(@AttrRes int colorInt) {
        ColorHolder colorHolder = new ColorHolder();
        colorHolder.mColorAttr = colorInt;
        return colorHolder;
    }

    public static int color(ColorHolder colorHolder, Context ctx, @AttrRes int colorStyle, @ColorRes int colorDefault) {
        if (colorHolder == null) {
            return ColorUtils.getFromAttrOrRes(ctx, colorStyle, colorDefault);
        } else {
            return colorHolder.color(ctx, colorStyle, colorDefault);
        }
    }

    public static int color(ColorHolder colorHolder, Context ctx) {
        if (colorHolder == null) {
            return 0;
        } else {
            return colorHolder.color(ctx);
        }
    }

    public static void applyToOr(ColorHolder colorHolder, TextView textView, ColorStateList colorDefault) {
        if (colorHolder != null && textView != null) {
            colorHolder.applyToOr(textView, colorDefault);
        } else if (textView != null) {
            textView.setTextColor(colorDefault);
        }
    }

    public static void applyToOrTransparent(ColorHolder colorHolder, Context ctx, GradientDrawable gradientDrawable) {
        if (colorHolder != null && gradientDrawable != null) {
            colorHolder.applyTo(ctx, gradientDrawable);
        } else if (gradientDrawable != null) {
            gradientDrawable.setColor(Color.TRANSPARENT);
        }
    }

    public int getColor(Context context) {
        if (mColorInt != 0) {
            return mColorInt;
        }

        if (mColorRes != -1) {
            return ColorUtils.getFromRes(context, mColorRes);
        }

        if (mColorAttr != -1) {
            return ColorUtils.getFromAttr(context, mColorAttr);
        }

        return 0;
    }

    public int getColorInt() {
        return mColorInt;
    }

    public void setColorInt(int mColorInt) {
        this.mColorInt = mColorInt;
    }

    public int getColorRes() {
        return mColorRes;
    }

    public void setColorRes(int mColorRes) {
        this.mColorRes = mColorRes;
    }

    public int getColorAttr() {
        return mColorAttr;
    }

    public void setColorAttr(@AttrRes int colorAttr) {
        mColorAttr = colorAttr;
    }

    public void applyTo(Context ctx, GradientDrawable drawable) {
        if (mColorInt != 0) {
            drawable.setColor(mColorInt);
        } else if (mColorRes != -1) {
            drawable.setColor(ContextCompat.getColor(ctx, mColorRes));
        }
    }

    public void applyToBackground(View view) {
        if (mColorInt != 0) {
            view.setBackgroundColor(mColorInt);
        } else if (mColorRes != -1) {
            view.setBackgroundResource(mColorRes);
        }
    }

    public void applyToOr(TextView textView, ColorStateList colorDefault) {
        if (mColorInt != 0) {
            textView.setTextColor(mColorInt);
        } else if (mColorRes != -1) {
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), mColorRes));
        } else if (colorDefault != null) {
            textView.setTextColor(colorDefault);
        }
    }

    public void applyTo(TextView textView) {
        if (mColorInt != 0) {
            textView.setTextColor(mColorInt);
        } else if (mColorRes != -1) {
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), mColorRes));
        }
    }

    public int color(Context ctx, @AttrRes int colorStyle, @ColorRes int colorDefaultRes) {
        //get the color from the holder else from the theme
        int color = color(ctx);
        if (color == 0) {
            return ColorUtils.getFromAttrOrRes(ctx, colorStyle, colorDefaultRes);
        } else {
            return color;
        }
    }

    public int color(Context ctx) {
        if (mColorInt == 0 && mColorRes != -1) {
            mColorInt = ContextCompat.getColor(ctx, mColorRes);
        }
        return mColorInt;
    }
}