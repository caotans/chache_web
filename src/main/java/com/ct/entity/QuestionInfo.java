package com.ct.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class QuestionInfo implements Serializable{

    @Id
    public String id;

    public String title;
    public String selecttion;
    public String  answer;
    public int type;
    public int status;
    public int questionId;

    public QuestionInfo() {
    }

    public QuestionInfo(String id, String title, String selecttion, String answer, int type, int status, int questionId) {
        this.id = id;
        this.title = title;
        this.selecttion = selecttion;
        this.answer = answer;
        this.type = type;
        this.status = status;
        this.questionId = questionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSelecttion() {
        return selecttion;
    }

    public void setSelecttion(String selecttion) {
        this.selecttion = selecttion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}