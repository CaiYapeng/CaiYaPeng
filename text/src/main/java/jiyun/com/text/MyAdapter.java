package jiyun.com.text;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.jude.rollviewpager.HintView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.jude.rollviewpager.hintview.IconHintView;

import java.util.List;

/**
 * Created by lenovo on 2017/9/5.
 */
public class MyAdapter extends StaticPagerAdapter {
    private List<Integer> data;
    private Context context;
    private ImageView img;
    private Button but;
    private ImageView img1;

    public MyAdapter(XQActivity xqActivity, List<Integer> data) {
        this.context = xqActivity;
        this.data = data;
    }

    @Override
    public View getView(ViewGroup container, int position) {
        View view = null;
        if (position == data.size() - 1) {
            XQActivity.rollviewpager.setHintView(null);
            XQActivity.rollviewpager.setPlayDelay(-1);
            XQActivity.rollviewpager.onPageScrollStateChanged(ViewPager.SCROLL_STATE_DRAGGING);
            view = View.inflate(context, R.layout.roll_item2, null);
            img = (ImageView) view.findViewById(R.id.img);
            but = (Button) view.findViewById(R.id.but);
            img.setImageResource(data.get(position));
            but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);
                }
            });

        }
        if (position < data.size() - 1) {
            view = View.inflate(context, R.layout.roll_item, null);
            img1 = (ImageView) view.findViewById(R.id.img);
            img1.setImageResource(data.get(position));
        }
        return view;
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }
}
