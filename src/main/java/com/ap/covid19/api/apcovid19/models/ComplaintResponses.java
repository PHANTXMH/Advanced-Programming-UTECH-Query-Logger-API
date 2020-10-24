package com.ap.covid19.api.apcovid19.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "complaints_responses")
@Where(clause = "deleted_at is null")
public class ComplaintResponses extends TimeStamp{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column
    private String response;

    @Column
    private Boolean read;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date readDate;

    @JoinColumn(name = "complaint_id")
    @ManyToOne
    private Complaints complaints;

}
