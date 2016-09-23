package shadow.tablayoutviewpagerdemo;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shadow on 16/9/22.
 */

public class RvAdapter extends RecyclerView.Adapter {

    List<String> mDataList = new ArrayList<>();

    Context mContext;


    public RvAdapter(List<String> list, Context context) {
        super();
        mDataList = list;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_card, parent, false);
        return new RvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RvViewHolder viewHolder = (RvViewHolder) holder;
        viewHolder.textView.setText(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


    public class RvViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textView;

        public RvViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
            textView = (TextView) itemView.findViewById(R.id.card_tv);
        }
    }

}
