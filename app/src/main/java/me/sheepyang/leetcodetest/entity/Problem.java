package me.sheepyang.leetcodetest.entity;

import android.content.Context;
import android.support.annotation.StringRes;

import java.io.Serializable;

/**
 * Created by Administrator on 2016-12-12.
 */

public class Problem implements Serializable {
    private String title;
    private String detail;
    private String hint;

    public Problem(Context contect, @StringRes int titleId, @StringRes int detailId, @StringRes int hintId) {
        this.title = contect.getString(titleId);
        this.detail = contect.getString(detailId);
        this.hint = contect.getString(hintId);
    }

    public Problem(String title, String detail, String hint) {
        this.title = title;
        this.detail = detail;
        this.hint = hint;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
