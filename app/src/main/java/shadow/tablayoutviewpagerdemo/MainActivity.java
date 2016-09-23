package shadow.tablayoutviewpagerdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    private MyPagerAdapter mPagerAdapter;

    private TabLayout mTabLayout;

    private int mLastScrollPosition = -1;

    private int mLastSelectedIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        init();

    }


    private void init() {
        mViewPager = (ViewPager) findViewById(R.id.my_viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.my_tabLayout);

        mPagerAdapter = new MyPagerAdapter(getData(), this);
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setScrollBarSize(4);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
//                mViewPager.reMeasureCurrentPage(mViewPager.findViewWithTag(MyPagerAdapter.TAG + tab.getPosition()));

                if (null != tab.getCustomView()) {
                    TextView tv = (TextView) tab.getCustomView().findViewById(R.id.tv_custom);
                    tv.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorPrimaryDark));
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (null != tab.getCustomView()) {
                    TextView tv = (TextView) tab.getCustomView().findViewById(R.id.tv_custom);
                    tv.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorPrimary));
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (null != tab.getCustomView()) {
                    TextView tv = (TextView) tab.getCustomView().findViewById(R.id.tv_custom);
                    tv.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorPrimaryDark));
                }
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mLastSelectedIndex = position;
//                mViewPager.reMeasureCurrentPage(mViewPager.findViewWithTag(MyPagerAdapter.TAG + position));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private List<DataBean> getData() {
        List<DataBean> dataBeanList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DataBean bean = new DataBean();
            bean.setTitle("hello");
            bean.setDataList(getList(10));
        }
        return dataBeanList;
    }

    private List<String> getList(int max) {
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            dataList.add("hh");
        }
        return dataList;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
