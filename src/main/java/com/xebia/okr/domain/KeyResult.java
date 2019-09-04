package com.xebia.okr.domain;

import javax.persistence.*;

@Entity
@Table(name = "key_results")
public class KeyResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int confidenceScore;
    private KeyResultStatus status;
    private int percentageCompleted;
    @ManyToOne
    @JoinColumn(name = "objective_id")
    private Objective objective;

    public KeyResult() {
    }

    public KeyResult(String title, int confidenceScore, KeyResultStatus status, int percentageCompleted) {
        this.title = title;
        this.confidenceScore = confidenceScore;
        this.status = status;
        this.percentageCompleted = percentageCompleted;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(int confidenceScore) {
        this.confidenceScore = confidenceScore;
    }

    public KeyResultStatus getStatus() {
        return status;
    }

    public void setStatus(KeyResultStatus status) {
        this.status = status;
    }

    public int getPercentageCompleted() {
        return percentageCompleted;
    }

    public void setPercentageCompleted(int percentageCompleted) {
        this.percentageCompleted = percentageCompleted;
    }
}
