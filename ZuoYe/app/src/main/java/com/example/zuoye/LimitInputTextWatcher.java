package com.example.zuoye;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by 黄黄k on 2017-10-04.
 */

public class LimitInputTextWatcher implements TextWatcher {

    private EditText et = null;
    private String regex;//筛选条件

    private String DEFAULT_REGEX = "[^\u4E00-\u9FA5]";//正则表达式:只能输入中文；a-zA-Z0-9是英文范围

    public LimitInputTextWatcher(EditText et) {
        this.et = et;
        this.regex = DEFAULT_REGEX;
    }

    public LimitInputTextWatcher(EditText et, String regex) {
        this.et = et;
        this.regex = regex;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void afterTextChanged(Editable editable) {
        String str = editable.toString();
        String inputStr = clearLimitStr(regex, str);
        et.removeTextChangedListener(this);
        editable.replace(0, editable.length(), inputStr.trim());//et.setText方法可能会引起键盘变化,所以用editable.replace来显示内容
        et.addTextChangedListener(this);
    }

    //清除不符合条件的内容
    private String clearLimitStr(String regex, String str) {
        return str.replaceAll(regex, "");
    }
}
