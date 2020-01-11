package com.forest.android;

import java.io.Serializable;
import java.util.List;

public class SvgBean implements Serializable {

    //svg名称
    public String name;
    //svg资源Id
    public int resId;
    //当前的填充的base64图
    public String img64;
    //总步数
    public int totalStepNum;
    //已经填充的步数
    public int alreadyStepNum;



    public SvgBean(String name, int resId) {
        this.name = name;
        this.resId = resId;
    }
}
