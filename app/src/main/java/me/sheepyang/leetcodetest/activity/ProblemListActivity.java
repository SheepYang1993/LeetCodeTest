package me.sheepyang.leetcodetest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.sheepyang.leetcodetest.R;
import me.sheepyang.leetcodetest.adapter.ProblemAdapter;
import me.sheepyang.leetcodetest.entity.Problem;
import me.sheepyang.leetcodetest.entity.ProblemList;
import me.sheepyang.leetcodetest.util.ProblemUtil;
import me.sheepyang.leetcodetest.widget.recyclerview.DividerItemDecoration;
import me.sheepyang.leetcodetest.widget.recyclerview.NoAlphaItemAnimator;

/**
 * Created by Administrator on 2016-12-12.
 */

public class ProblemListActivity extends BaseActivity {

    @BindView(R.id.rv_problem)
    RecyclerView rvProblem;
    @BindView(R.id.refresh_layout)
    TwinklingRefreshLayout refreshLayout;
    private ProblemAdapter mAdapter;
    private List<ProblemList> mData;

    @Override
    public int setLayoutId() {
        return R.layout.activity_problem_list;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBarTitle("题库列表");
        initView();
        initListener();
        initData();
    }

    private void initListener() {
        refreshLayout.setEnableLoadmore(false);
        refreshLayout.setEnableRefresh(false);
    }

    private void initData() {
        ProblemList allList1 = new ProblemList();
        List<Problem> problemList1 = ProblemUtil.getUnSolved(mContext);
        allList1.setList(problemList1);
        allList1.setHeader("待解决");

        ProblemList allList2 = new ProblemList();
        List<Problem> problemList2 = ProblemUtil.getSolved();
        allList2.setList(problemList2);
        allList2.setHeader("已解决");

        mData.add(allList1);
        mData.add(allList2);

        mAdapter.updata(mData);
    }

    private void initView() {
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvProblem.setLayoutManager(linearLayoutManager);
        rvProblem.addItemDecoration(new DividerItemDecoration(mContext,
                DividerItemDecoration.VERTICAL_LIST));
        // 解决notifyItem闪烁的问题
        rvProblem.setItemAnimator(new NoAlphaItemAnimator());
        mData = new ArrayList<>();
        //设置适配器
        mAdapter = new ProblemAdapter(mContext, mData);
        rvProblem.setAdapter(mAdapter);
    }
}
