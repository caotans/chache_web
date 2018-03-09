package com.ct.entity;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class QuestionByUser implements Serializable {

    @Id
    public  String id;
    public String  userId;
    public String  questionId;
    public String  userAnswer;

    public QuestionByUser() {
    }

    public QuestionByUser(String id, String userId, String questionId, String userAnswer) {
        this.id = id;
        this.userId = userId;
        this.questionId = questionId;
        this.userAnswer = userAnswer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
}
