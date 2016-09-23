package shadow.tablayoutviewpagerdemo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shadow on 2016/9/22.
 */
public class MyPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<DataBean> mDataBeanList;
    public static final String TAG = MyPagerAdapter.class.getSimpleName();

    public MyPagerAdapter(List<DataBean> List,Context context) {
        this.mContext = context;
        this.mDataBeanList = List;
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        DataBean bean = mDataBeanList.get(position);
        MyPagerView itemView = new MyPagerView(mContext);
        itemView.bindData(bean.getDataList());
        itemView.setTag(TAG + position);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        try {
            container.removeView((View) object);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getCount() {
        return mDataBeanList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
       return mDataBeanList.get(position).getTitle();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public View getTabView(Context context, int position) {
        View tab = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        TextView tv = (TextView) tab.findViewById(R.id.tv_custom);
        tv.setText(getPageTitle(position));
        return tab;
    }
}
