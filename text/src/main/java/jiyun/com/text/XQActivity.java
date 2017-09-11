package jiyun.com.text;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.jude.rollviewpager.RollPagerView;

import java.util.ArrayList;
import java.util.List;

public class XQActivity extends AppCompatActivity {

    public static RollPagerView rollviewpager;
    private List<Integer> data = new ArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xq);
        initView();
        initData();

    }

    private void initData() {
        data.add(R.mipmap.a);
        data.add(R.mipmap.b);
        data.add(R.mipmap.c);
        data.add(R.mipmap.d);
        data.add(R.mipmap.e);
        data.add(R.mipmap.f);
        data.add(R.mipmap.g);
        data.add(R.mipmap.h);
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        rollviewpager = (RollPagerView) findViewById(R.id.rollviewpager);
        adapter = new MyAdapter(this, data);
        rollviewpager.onPageScrollStateChanged(ViewPager.SCROLL_STATE_DRAGGING);
        rollviewpager.setAdapter(adapter);
    }
}
