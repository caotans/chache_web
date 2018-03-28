package com.ct.entity;

import java.io.Serializable;

/**
 * @Author:ct
 * @Date:2018-3-28,11:57
 * @Description:  分类字典表
 */
public class ClassifyDic implements Serializable{
    public String classifyName;
    public String classifyType;

    public ClassifyDic() {
    }

    public ClassifyDic(String classifyName, String clsssifyType) {
        this.classifyName = classifyName;
        this.classifyType = clsssifyType;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public String getClsssifyType() {
        return classifyType;
    }

    public void setClsssifyType(String clsssifyType) {
        this.classifyType = clsssifyType;
    }
}
