package com.xebia.okr.domain;

import org.hibernate.annotations.Target;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.List;


@Entity
@Access(AccessType.FIELD)
@Table(name = "plan")
@NamedQuery(name = "Plan.findByTitle", query = "SELECT p FROM Plan p")
public class Plan {

    @Id
    @SequenceGenerator(name = "",allocationSize = 100,sequenceName = "")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    private Date endDate;
    @OneToMany(mappedBy = "plan")
    private List<Objective> objective;

    Plan() {
    }

    public Plan(String title, Date startDate, Date endDate) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", objective=" + objective +
                '}';
    }
}
