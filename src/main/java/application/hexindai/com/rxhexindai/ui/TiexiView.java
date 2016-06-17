package application.hexindai.com.rxhexindai.ui;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import application.hexindai.com.rxhexindai.R;
import application.hexindai.com.rxhexindai.util.UIUtils;

/**
 * Created by zry on 2015/12/30.
 */
public class TiexiView extends LinearLayout {

    private TextView tianxiView, tiexiwenzi;


    public TiexiView(Context context) {
        this(context, null);
    }

    public TiexiView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TiexiView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        addView(View.inflate(context,R.layout.tiexi_view,null));
        tianxiView = (TextView) findViewById(R.id.tianxi);
        tiexiwenzi = (TextView) findViewById(R.id.tiexiwenzi);
    }

    public void setUpStytle(String jiangli, String is_plus_rate) {
        if (jiangli == null || "0".equals(jiangli)) {
            setVisibility(GONE);
            return;
        }
        float jiangliFloat = Float.parseFloat(jiangli);
        String builderStr = "";
        if ("1".equals(is_plus_rate)) {
            builderStr = "+" + jiangliFloat + "%";
            tianxiView.setBackgroundResource(R.drawable.shouyetiexibaifenbi);
            tiexiwenzi.setText("贴息");
            tiexiwenzi.setBackgroundResource(R.drawable.shouyetiexi);

            tiexiwenzi.setTextColor(getContext().getResources().getColor(R.color.color_00b8c3));
        } else{
            builderStr = "+" + jiangli + "%";
            tianxiView.setBackgroundResource(R.drawable.shouyejianglibaifenbi);
            tiexiwenzi.setText("奖励");

            tiexiwenzi.setTextColor(getContext().getResources().getColor(R.color.f15353));
            tiexiwenzi.setBackgroundResource(R.drawable.shouyejiangli);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(builderStr);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(UIUtils.dip2px(11)), 0, builderStr.length() - 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(UIUtils.dip2px(10)), builderStr.length() - 1, builderStr.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tianxiView.setText(spannableStringBuilder);
        setVisibility(View.VISIBLE);
    }

    public void setUpStytleZhanwei(String jiangli) {

        if (jiangli == null || "0".equals(jiangli)) {
            setVisibility(GONE);
        } else {
            setVisibility(View.INVISIBLE);
        }
    }
}