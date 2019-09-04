package com.xebia.okr.domain;

import javax.persistence.*;
import java.lang.annotation.Inherited;
import java.util.List;

@Entity
@Table(name = "objectives")
public class Objective {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String status;
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;
    @OneToMany(mappedBy = "objective")
    private List<KeyResult> keyResults;

    Objective() {
    }

    public Objective(String title, String status) {
        this.title = title;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
