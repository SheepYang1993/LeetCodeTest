package me.sheepyang.leetcodetest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.ButterKnife;
import me.sheepyang.leetcodetest.R;
import me.sheepyang.leetcodetest.entity.Problem;
import me.sheepyang.leetcodetest.entity.ProblemList;

/**
 * Created by Administrator on 2016-12-12.
 */

public class ProblemAdapter extends RecyclerView.Adapter {
    private static final int TYPE_HEAD = 0;
    private static final int TYPE_CONTENT = 1;
    private static final int TYPE_FOOTER = 2;
    private List<ProblemList> mData;
    private Context mContext;

    public ProblemAdapter(Context context, List<ProblemList> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        switch (viewType) {
            case TYPE_HEAD:
                ViewGroup vGroup = (ViewGroup) mInflater.inflate(R.layout.item_problem_header, parent, false);
                ViewHeadHolder vhGroup = new ViewHeadHolder(vGroup);
                return vhGroup;
            case TYPE_CONTENT:
                ViewGroup vImage = (ViewGroup) mInflater.inflate(R.layout.item_problem_content, parent, false);
                ViewContentHolder vhImage = new ViewContentHolder(vImage);
                return vhImage;
            case TYPE_FOOTER:
                ViewGroup footer = (ViewGroup) mInflater.inflate(R.layout.item_problem_footer, parent, false);
                ViewFooterHolder vhfooter = new ViewFooterHolder(footer);
                return vhfooter;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int count = 0;
        for (int i = 0; i < mData.size(); i++) {
            ProblemList allList = mData.get(i);
            if (!TextUtils.isEmpty(allList.getHead())) {
                if (position == count) {
                    ViewHeadHolder vGroup = (ViewHeadHolder) holder;
//                vGroup.textView_head.setText(bean.getHeader());
                }
                count++;
            }

            List<Problem> problemList = allList.getList();
            if (problemList != null) {
                for (int j = 0; j < problemList.size(); j++) {
                    if (position == count) {
                        ViewContentHolder vhImage = (ViewContentHolder) holder;
//                    vhImage.textView_content.setText(dataList.get(j));
                    }
                    count++;
                }
            }

            if (!TextUtils.isEmpty(allList.getFoot())) {
                if (position == count) {
                    ViewFooterHolder vhImage = (ViewFooterHolder) holder;
//                vhImage.textView_footer.setText(bean.getFooter());
                }
                count++;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        int count = 0;
        for (int i = 0; i < mData.size(); i++) {
            ProblemList allList = mData.get(i);
            if (!TextUtils.isEmpty(allList.getHead())) {
                if (position == count) {
                    return TYPE_HEAD;
                } else {
                    count++;
                }
            }

            List<Problem> problemList = allList.getList();
            if (problemList != null) {
                for (int j = 0; j < problemList.size(); j++) {
                    if (position == count) {
                        return TYPE_CONTENT;
                    } else {
                        count++;
                    }
                }
            }

            if (!TextUtils.isEmpty(allList.getFoot())) {
                if (position == count) {
                    return TYPE_FOOTER;
                } else {
                    count++;
                }
            }
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (mData != null && mData.size() > 0) {
            for (int i = 0; i < mData.size(); i++) {
                if (!TextUtils.isEmpty(mData.get(i).getHead())) {
                    count++;
                }
                ProblemList allList = mData.get(i);
                List<Problem> problemList = allList.getList();
                if (problemList != null) {
                    count += problemList.size();
                }
                if (!TextUtils.isEmpty(mData.get(i).getFoot())) {
                    count++;
                }
            }
        }
        return count;
    }

    static class ViewHeadHolder extends RecyclerView.ViewHolder {

        public ViewHeadHolder(View rootView) {
            super(rootView);
            ButterKnife.bind(this, rootView);
        }
    }

    static class ViewContentHolder extends RecyclerView.ViewHolder {

        public ViewContentHolder(View rootView) {
            super(rootView);
            ButterKnife.bind(this, rootView);
        }
    }

    static class ViewFooterHolder extends RecyclerView.ViewHolder {

        public ViewFooterHolder(View rootView) {
            super(rootView);
            ButterKnife.bind(this, rootView);
        }
    }

    public void updata(List<ProblemList> data) {
        mData = data;
        notifyDataSetChanged();
    }
}
