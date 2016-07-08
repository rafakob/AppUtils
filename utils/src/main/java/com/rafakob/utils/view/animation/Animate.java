package com.rafakob.utils.view.animation;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.rafakob.utils.R;


public class Animate {
    /**
     * Animate height of a ViewGroup object.
     *
     * @param target ViewGroup
     * @return Builder
     */
    public static ValueAnimatorBuilder viewGroupHeight(ViewGroup target) {
        return new ValueAnimatorBuilder<ViewGroup>(target) {
            @Override
            protected void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams lp = target.getLayoutParams();
                lp.height = (int) valueAnimator.getAnimatedValue();
                target.setLayoutParams(lp);
            }
        };
    }

    /**
     * Animate height of a View object.
     *
     * @param target View
     * @return Builder
     */
    public static ValueAnimatorBuilder viewHeight(View target) {
        return new ValueAnimatorBuilder<View>(target) {
            @Override
            protected void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams lp = target.getLayoutParams();
                lp.height = (int) valueAnimator.getAnimatedValue();
                target.setLayoutParams(lp);
            }
        };
    }

    /**
     * Fade in animation
     *
     * @param target
     * @return
     */
    public static ValueAnimatorBuilder fadeIn(final View target) {
        return fadeIn(target, 0);
    }

    public static ValueAnimatorBuilder fadeIn(final View target, float initialAlpha) {
        ValueAnimatorBuilder builder = new ValueAnimatorBuilder<View>(target) {
            @Override
            protected void onAnimationUpdate(ValueAnimator valueAnimator) {
                target.setAlpha((float) valueAnimator.getAnimatedValue());
                if (target.getParent() != null) {
                    ((View) target.getParent()).postInvalidate();
                }
            }
        };

        target.setAlpha(initialAlpha);
        if (initialAlpha == 0 && target.getVisibility() != View.VISIBLE) {
            target.setVisibility(View.VISIBLE);
        }
        return builder.withFloatValues(target.getAlpha(), 1)
                .duration((int) (200 * (1 - target.getAlpha())))
                .interpolator(new DecelerateInterpolator());
    }

    /**
     * Fade out animation
     *
     * @param target
     * @return
     */
    public static ValueAnimatorBuilder fadeOut(final View target) {
        ValueAnimatorBuilder builder = new ValueAnimatorBuilder<View>(target) {
            @Override
            protected void onAnimationUpdate(ValueAnimator valueAnimator) {
                target.setAlpha((Float) valueAnimator.getAnimatedValue());
                if (target.getParent() != null) {
                    ((View) target.getParent()).postInvalidate();
                }
            }
        };

        return builder.withFloatValues(target.getAlpha(), 0)
                .duration((int) (200 * target.getAlpha()))
                .interpolator(new DecelerateInterpolator());
    }

    /**
     * Pop in animation
     *
     * @param target
     * @return
     */
    public static ValueAnimatorBuilder popIn(final View target) {
        return popIn(target, 0);
    }

    public static ValueAnimatorBuilder popIn(final View target, float initialAlpha) {
        ValueAnimatorBuilder builder = new ValueAnimatorBuilder<View>(target) {
            @Override
            protected void onAnimationUpdate(ValueAnimator valueAnimator) {
                target.setAlpha((Float) valueAnimator.getAnimatedValue());
                target.setScaleX((Float) valueAnimator.getAnimatedValue());
                target.setScaleY((Float) valueAnimator.getAnimatedValue());
                if (target.getParent() != null) {
                    ((View) target.getParent()).postInvalidate();
                }
            }
        };

        target.setAlpha(initialAlpha);
        if (initialAlpha == 0 && target.getVisibility() != View.VISIBLE) {
            target.setVisibility(View.VISIBLE);
        }
        return builder.withFloatValues(target.getAlpha(), 1)
                .duration((int) (200 * (1 - target.getAlpha())))
                .interpolator(new DecelerateInterpolator());
    }

    /**
     * Pop out animation
     *
     * @param target
     * @return
     */
    public static ValueAnimatorBuilder popOut(final View target) {
        ValueAnimatorBuilder builder = new ValueAnimatorBuilder<View>(target) {
            @Override
            protected void onAnimationUpdate(ValueAnimator valueAnimator) {
                target.setAlpha((Float) valueAnimator.getAnimatedValue());
                target.setScaleX((Float) valueAnimator.getAnimatedValue());
                target.setScaleY((Float) valueAnimator.getAnimatedValue());
                if (target.getParent() != null) {
                    ((View) target.getParent()).postInvalidate();
                }
            }
        };

        return builder.withFloatValues(target.getAlpha(), 0)
                .duration((int) (200 * target.getAlpha()))
                .interpolator(new DecelerateInterpolator());
    }


    /**
     * Fly in animation
     *
     * @param target
     * @return
     */
    public static ValueAnimatorBuilder flyIn(final View target) {
        return flyIn(target, 0);
    }

    public static ValueAnimatorBuilder flyIn(final View target, float initialAlpha) {
        ValueAnimatorBuilder builder = new ValueAnimatorBuilder<View>(target) {
            @Override
            protected void onAnimationUpdate(ValueAnimator valueAnimator) {
                target.setAlpha((Float) valueAnimator.getAnimatedValue());
                target.setTranslationY(Math.min(target.getHeight() / 2, target.getResources().getDimension(R.dimen.ref_1dp) * 50.0f) * (1 - (Float) valueAnimator.getAnimatedValue()));
                if (target.getParent() != null) {
                    ((View) target.getParent()).postInvalidate();
                }
            }
        };

        target.setAlpha(initialAlpha);
        if (initialAlpha == 0 && target.getVisibility() != View.VISIBLE) {
            target.setVisibility(View.VISIBLE);
        }
        return builder.withFloatValues(target.getAlpha(), 1)
                .duration((int) (200 * (1 - target.getAlpha())))
                .interpolator(new DecelerateInterpolator());
    }

    /**
     * Fly out animation
     *
     * @param target
     * @return
     */
    public static ValueAnimatorBuilder flyOut(final View target) {
        ValueAnimatorBuilder builder = new ValueAnimatorBuilder<View>(target) {
            @Override
            protected void onAnimationUpdate(ValueAnimator valueAnimator) {
                target.setAlpha((Float) valueAnimator.getAnimatedValue());
                target.setTranslationY(Math.min(target.getHeight() / 2, target.getResources().getDimension(R.dimen.ref_1dp) * 50.0f) * (1 - (Float) valueAnimator.getAnimatedValue()));
                if (target.getParent() != null) {
                    ((View) target.getParent()).postInvalidate();
                }
            }
        };

        return builder.withFloatValues(target.getAlpha(), 0)
                .duration((int) (200 * target.getAlpha()))
                .interpolator(new DecelerateInterpolator());
    }

    /**
     * BrightnessSaturationFadeIn
     *
     * @param target
     * @return
     */
    public static ValueAnimatorBuilder brightnessSaturationFadeIn(final ImageView target) {
        final AccelerateDecelerateInterpolator interpolator = new AccelerateDecelerateInterpolator();
        ValueAnimatorBuilder builder = new ValueAnimatorBuilder<ImageView>(target) {
            ColorMatrix saturationMatrix = new ColorMatrix();
            ColorMatrix brightnessMatrix = new ColorMatrix();

            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fraction = animator.getAnimatedFraction();

                saturationMatrix.setSaturation((Float) animator.getAnimatedValue());

                float scale = 2 - interpolator.getInterpolation(Math.min(fraction * 4 / 3, 1));
                brightnessMatrix.setScale(scale, scale, scale, interpolator.getInterpolation(Math.min(fraction * 2, 1)));

                saturationMatrix.preConcat(brightnessMatrix);
                target.setColorFilter(new ColorMatrixColorFilter(saturationMatrix));
                if (target.getParent() != null) {
                    ((View) target.getParent()).postInvalidate();
                }
            }
        };

        return builder.withFloatValues(0, 1)
                .duration(800)
                .interpolator(interpolator);
    }

    /**
     * BrightnessSaturationFadeOut
     *
     * @param target
     * @return
     */
    public static ValueAnimatorBuilder brightnessSaturationFadeOut(final ImageView target) {
        final AccelerateDecelerateInterpolator interpolator = new AccelerateDecelerateInterpolator();
        ValueAnimatorBuilder builder = new ValueAnimatorBuilder<ImageView>(target) {
            ColorMatrix saturationMatrix = new ColorMatrix();
            ColorMatrix brightnessMatrix = new ColorMatrix();

            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fraction = animator.getAnimatedFraction();

                saturationMatrix.setSaturation((Float) animator.getAnimatedValue());

                float scale = 2 - interpolator.getInterpolation(Math.min((1 - fraction) * 4 / 3, 1));
                brightnessMatrix.setScale(scale, scale, scale, interpolator.getInterpolation(Math.min((1 - fraction) * 2, 1)));

                saturationMatrix.preConcat(brightnessMatrix);
                target.setColorFilter(new ColorMatrixColorFilter(saturationMatrix));
                if (target.getParent() != null) {
                    ((View) target.getParent()).postInvalidate();
                }
            }
        };

        return builder.withFloatValues(1, 0)
                .duration(800)
                .interpolator(interpolator);
    }

    public static float lerp(float interpolation, float val1, float val2) {
        return val1 * (1 - interpolation) + val2 * interpolation;
    }

    public static int lerpColor(float interpolation, int val1, int val2) {
        int a = (int) lerp(interpolation, val1 >> 24, val2 >> 24);
        int r = (int) lerp(interpolation, (val1 >> 16) & 0xff, (val2 >> 16) & 0xff);
        int g = (int) lerp(interpolation, (val1 >> 8) & 0xff, (val2 >> 8) & 0xff);
        int b = (int) lerp(interpolation, val1 & 0xff, val2 & 0xff);
        return Color.argb(a, r, g, b);
    }


}
