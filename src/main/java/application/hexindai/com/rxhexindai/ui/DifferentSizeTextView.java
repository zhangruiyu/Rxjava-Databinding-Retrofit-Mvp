package application.hexindai.com.rxhexindai.ui;

import android.databinding.BindingAdapter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.widget.TextView;

import application.hexindai.com.rxhexindai.util.UIUtils;

/**
 * Created by zhangruiyu on 16/5/20.
 */
public class DifferentSizeTextView {

    @BindingAdapter({"android:large","android:small","android:index","android:strtext"})
    public static void setDifferentSize(TextView textView, int large, int small,int index, String strtext) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strtext);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(UIUtils.dip2px(large)), 0, index, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(UIUtils.dip2px(small)), index, strtext.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableStringBuilder);
    }

}
