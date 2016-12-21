package yzj.badu.com.tablaouticon;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/17.
 *
 * @projectName ${}
 */
public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> titles;
    private List<Fragment> fragments;
    private int[] tabIcons = {
            R.mipmap.rd_home_off,
            R.mipmap.rd_live_off,
            R.mipmap.rd_mine_off
    };
    private int[] tabIconsPressed = {
            R.mipmap.rd_home_on,
            R.mipmap.rd_live_on,
            R.mipmap.rd_mine_on
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
        initValue();
        initEvent();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
    }

    private void initValue() {
        fragments = new ArrayList<>();
        fragments.add(OneFragment.newInstance("One"));
        fragments.add(OneFragment.newInstance("Two"));
        fragments.add(OneFragment.newInstance("Three"));
        titles = new ArrayList<>();
        titles.add("One");
        titles.add("Two");
        titles.add("Three");
        FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void initEvent() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                changeTabSelect(tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                changeTabNormal(tab);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void changeTabSelect(TabLayout.Tab tab) {
        View view = tab.getCustomView();
        ImageView img_title = (ImageView) view.findViewById(R.id.img_title);
        TextView txt_title = (TextView) view.findViewById(R.id.txt_title);
        txt_title.setTextColor(Color.GREEN);
        if (txt_title.getText().toString().equals("One")) {
            img_title.setImageResource(tabIconsPressed[0]);
            viewPager.setCurrentItem(0);
        } else if (txt_title.getText().toString().equals("Two")) {
            img_title.setImageResource(tabIconsPressed[1]);
            viewPager.setCurrentItem(1);
        } else {
            img_title.setImageResource(tabIconsPressed[2]);
            viewPager.setCurrentItem(2);
        }
    }

    private void changeTabNormal(TabLayout.Tab tab) {
        View view = tab.getCustomView();
        ImageView img_title = (ImageView) view.findViewById(R.id.img_title);
        TextView txt_title = (TextView) view.findViewById(R.id.txt_title);
        txt_title.setTextColor(Color.WHITE);
        if (txt_title.getText().toString().equals("One")) {
            img_title.setImageResource(tabIcons[0]);
        } else if (txt_title.getText().toString().equals("Two")) {
            img_title.setImageResource(tabIcons[1]);
        } else {
            img_title.setImageResource(tabIcons[2]);
        }
    }


    private void setupTabIcons() {
        tabLayout.getTabAt(0).setCustomView(getTabView(0));
        tabLayout.getTabAt(1).setCustomView(getTabView(1));
        tabLayout.getTabAt(2).setCustomView(getTabView(2));
    }


    public View getTabView(int position) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_customer, null);
        TextView txt_title = (TextView) view.findViewById(R.id.txt_title);
        txt_title.setText(titles.get(position));
        ImageView img_title = (ImageView) view.findViewById(R.id.img_title);
        img_title.setImageResource(tabIcons[position]);

        if (position == 0) {
            txt_title.setTextColor(Color.YELLOW);
            img_title.setImageResource(tabIconsPressed[position]);
        } else {
            txt_title.setTextColor(Color.WHITE);
            img_title.setImageResource(tabIcons[position]);
        }
        return view;
    }

}
