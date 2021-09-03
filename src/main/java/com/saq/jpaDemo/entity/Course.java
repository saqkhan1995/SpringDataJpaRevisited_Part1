package com.saq.jpaDemo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
//@Table(name = "CourseDetails") // table name is course_details
//@NamedQuery(name = "query_get_all_courses", query = "Select c From Course c")             //For single Named Query
@NamedQueries(value = {                                                                     //For Multiple Named Queries
        @NamedQuery(name = "query_get_all_courses", query = "Select c From Course c"),
        @NamedQuery(name = "query_courses_where", query = "Select c From Course c where name like '%100 steps'")
})
public class Course {

    @Id                    // primary key
    @GeneratedValue        // JPA will generate value for this
    private long id;

//    @Column(name = "fullname", nullable = false)      to map to a table column with a different name from the entity
    private String name;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    protected Course() {            //JPA mandates a default constructor
    }

    public Course(String name) {        //No ID field in constructor as it's a @GeneratedValue from JPA
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {            //No setter for ID as it's a @GeneratedValue from JPA
        return id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
