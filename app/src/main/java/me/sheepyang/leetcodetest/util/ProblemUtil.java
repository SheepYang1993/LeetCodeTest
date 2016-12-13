package me.sheepyang.leetcodetest.util;

import android.content.Context;
import android.text.TextUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import me.sheepyang.leetcodetest.R;
import me.sheepyang.leetcodetest.entity.Problem;

/**
 * Created by Administrator on 2016-12-13.
 */

public class ProblemUtil {
    public static List<Problem> getUnSolved(Context context) {
        List<Problem> problemList = new ArrayList<>();
        problemList.add(new Problem(context, R.string.problem_title_82, R.string.problem_detail_82, R.string.problem_hint_82));
        return problemList;
    }

    public static List<Problem> getSolved() {
        List<Problem> problemList = new ArrayList<>();
        return problemList;
    }

    public static String Calculate(Context context, String title, String input) {
        if (context.getString(R.string.problem_title_82).equals(title)) {
            return Calculate82(input);
        }/* else if (context.getString(R.string.problem_title_82).equals(title)) {

        } else if (context.getString(R.string.problem_title_82).equals(title)) {

        } else if (context.getString(R.string.problem_title_82).equals(title)) {

        } else if (context.getString(R.string.problem_title_82).equals(title)) {

        } else if (context.getString(R.string.problem_title_82).equals(title)) {

        }*/
        return null;
    }

    private static String Calculate82(String input) {
        String[] a = input.split(",");
        List<BigDecimal> bdList = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (!TextUtils.isEmpty(a[i])) {
                try {
                    bdList.add(new BigDecimal(a[i]));
                    LogUtils.i("Calculate82 input" + i + " -> " + a[i]);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "输入格式不正确，请重新输入";
                }
            }
        }

        // 开始计算
        BigDecimal temp = null;
        List<BigDecimal> resultList = new ArrayList<>();
        for (int i = 0; i < bdList.size(); i++) {
            BigDecimal bd = bdList.get(i);
            if (i != 0) {
                temp = bdList.get(i - 1);
            }

            if (temp != null && bd.compareTo(temp) == 0) {// 两个数字相等
                continue;
            }
            resultList.add(bd);
        }
        // 计算结束

        StringBuffer sbResult = new StringBuffer(256);
        sbResult.append("计算结果是:");
        for (int i = 0; i < resultList.size(); i++) {
            if (i == 0) {
                sbResult.append("[ ");
            }
            sbResult.append(resultList.get(i).toString());
            if (i == resultList.size() - 1) {
                sbResult.append(" ]");
            } else {
                if (resultList.size() != 1) {
                    sbResult.append(" , ");
                }
            }
        }
        return sbResult.toString();
    }
}
