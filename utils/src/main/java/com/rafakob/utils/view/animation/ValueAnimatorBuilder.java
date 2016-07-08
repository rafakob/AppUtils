package com.rafakob.utils.view.animation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.animation.Interpolator;

public abstract class ValueAnimatorBuilder<T> {
    protected ValueAnimator animator;
    protected T target;
    protected int[] valuesInt;
    protected int[] valuesArgb;
    protected float[] valuesFloat;
    protected int from;
    protected int to;
    protected int duration = 200;
    protected int delay = 0;
    protected Interpolator interpolator;
    protected Animator.AnimatorListener animatorListener;

    public ValueAnimatorBuilder(T target) {
        this.target = target;
    }

    public ValueAnimatorBuilder withIntValues(int... valuesInt) {
        this.valuesInt = valuesInt;
        return this;
    }

    public ValueAnimatorBuilder withArgbValues(int... valuesArgb) {
        this.valuesArgb = valuesArgb;
        return this;
    }

    public ValueAnimatorBuilder withFloatValues(float... valuesFloat) {
        this.valuesFloat = valuesFloat;
        return this;
    }

    public ValueAnimatorBuilder duration(int duration) {
        this.duration = duration;
        return this;
    }

    public ValueAnimatorBuilder delay(int delay) {
        this.delay = delay;
        return this;
    }

    public ValueAnimatorBuilder interpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
        return this;
    }

    public ValueAnimatorBuilder listener(Animator.AnimatorListener animatorListener) {
        this.animatorListener = animatorListener;
        return this;
    }

    public ValueAnimator build() {
         /* Create */
        if (valuesInt != null && valuesInt.length > 0) {
            animator = ValueAnimator.ofInt(valuesInt);
        }
        if (valuesArgb != null && valuesArgb.length > 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                animator = ValueAnimator.ofArgb(valuesArgb);
            }
        }
        if (valuesFloat != null && valuesFloat.length > 0) {
            animator = ValueAnimator.ofFloat(valuesFloat);
        }
        if (animator == null) {
            throw new NullPointerException("ValueAnimatorBuilder - animator object has not been initialized!");
        }
        /* Target */
        animator.setTarget(target);
        /* Duration */
        animator.setDuration(duration);
        /* Delay */
        animator.setStartDelay(delay);
        /* Interpolator */
        if (interpolator != null) {
            animator.setInterpolator(interpolator);
        }
        /* Animation OnPositiveListener */
        if (animatorListener != null) {
            animator.addListener(animatorListener);
        }
        /* Update OnPositiveListener */
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ValueAnimatorBuilder.this.onAnimationUpdate(valueAnimator);
            }
        });
        /* Start */
        animator.start();
        return animator;
    }

    public void start() {
        if (animator == null) {
            build().start();
        } else {
            animator.start();
        }
    }

    protected abstract void onAnimationUpdate(ValueAnimator valueAnimator);
}
