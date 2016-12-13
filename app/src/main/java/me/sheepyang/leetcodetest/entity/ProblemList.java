package me.sheepyang.leetcodetest.entity;

import java.util.List;

/**
 * Created by Administrator on 2016-12-12.
 */

public class ProblemList {
    private int type;
    private List<Problem> list;
    private String header;
    private String footer;
    private boolean isOpen;// 是否打开列表

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
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
