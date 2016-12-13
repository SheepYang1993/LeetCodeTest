package me.sheepyang.leetcodetest.entity;

import java.util.List;

/**
 * Created by Administrator on 2016-12-12.
 */

public class ProblemList {
    private int type;
    private List<Problem> list;
    private String head;
    private String foot;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Problem> getList() {
        return list;
    }

    public void setList(List<Problem> list) {
        this.list = list;
    }
}
