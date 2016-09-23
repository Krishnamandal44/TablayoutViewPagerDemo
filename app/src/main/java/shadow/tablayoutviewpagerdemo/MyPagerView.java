package shadow.tablayoutviewpagerdemo;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by shadow on 2016/9/23.
 */
public class MyPagerView extends LinearLayout {

    private Activity mActivity;

    private RecyclerView mRecyclerView;

    public MyPagerView(Context context) {
        super(context);
        mActivity = (Activity) context;
        initView();
    }

    public MyPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mActivity = (Activity) context;
        initView();
    }

    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(mActivity);
        View view = inflater.inflate(R.layout.item_rv, this);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.item_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    public void bindData(List<String> list) {
        RvAdapter adapter = new RvAdapter(list, mActivity);
        mRecyclerView.setAdapter(adapter);

    }


}
