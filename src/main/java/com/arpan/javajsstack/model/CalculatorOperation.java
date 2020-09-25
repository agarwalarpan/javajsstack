package com.arpan.javajsstack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class CalculatorOperation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer seq;
    private String type;
    private Integer b;
    private Integer a;
    private Integer result;

    @JsonIgnore
    @Transient
    private String secretField = "SECRET_EXPOSED";

    public CalculatorOperation() {
    }

    public CalculatorOperation(Integer a, Integer b, Integer result) {
        this.a = a;
        this.b = b;
        this.result = result;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getSecretField() {
        return secretField;
    }

    public void setSecretField(String secretField) {
        this.secretField = secretField;
    }
}
