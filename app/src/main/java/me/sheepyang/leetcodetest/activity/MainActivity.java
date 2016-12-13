package me.sheepyang.leetcodetest.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import me.sheepyang.leetcodetest.R;
import me.sheepyang.leetcodetest.entity.Problem;
import me.sheepyang.leetcodetest.util.ProblemUtil;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_detail)
    TextView tvDetail;
    @BindView(R.id.edt_in_put)
    EditText edtInPut;
    @BindView(R.id.tv_out_put)
    TextView tvOutPut;
    @BindView(R.id.in_put_wrapper)
    TextInputLayout inPutWrapper;
    private Problem mProblem;

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProblem = (Problem) getIntent().getSerializableExtra("Problem");
        if (mProblem == null) {
            showToast("没有获取到问题");
            finish();
            return;
        }
        setBarTitle("问题：" + mProblem.getTitle());
        initData();
    }

    private void initData() {
        if (!TextUtils.isEmpty(mProblem.getTitle())) {
            tvTitle.setText(mProblem.getTitle());
        }
        if (!TextUtils.isEmpty(mProblem.getDetail())) {
            tvDetail.setText(mProblem.getDetail());
        }
        if (!TextUtils.isEmpty(mProblem.getHint())) {
            inPutWrapper.setHint(mProblem.getHint());
        }
    }

    @Override
    @OnClick({R.id.btn_calculate})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_calculate:
                if (!TextUtils.isEmpty(edtInPut.getText().toString())) {
                    String result = ProblemUtil.Calculate(mContext, mProblem.getTitle(), edtInPut.getText().toString());
                    if (!TextUtils.isEmpty(result)) {
                        tvOutPut.setText(result);
                    } else {
                        tvOutPut.setText("计算出错了！");
                    }
                } else {
                    showToast("输入不能为空");
                }
                break;
            default:
                break;
        }
    }
}
