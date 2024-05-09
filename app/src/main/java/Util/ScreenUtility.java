package Util;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;

public class ScreenUtility {
    private Activity activity;
    private float dpWidth;
    private float dpHeight;

    public ScreenUtility(Activity activity){
        this.activity=activity;

        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float density = outMetrics.density;

        dpWidth = outMetrics.widthPixels/density;
        dpHeight = outMetrics.heightPixels/density;
    }

    public float getDpWidth() {
        return dpWidth;
    }

    public float getDpHeight() {
        return dpHeight;
    }
}
