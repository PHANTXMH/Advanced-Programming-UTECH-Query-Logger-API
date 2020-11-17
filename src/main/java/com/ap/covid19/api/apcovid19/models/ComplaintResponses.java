package com.ap.covid19.api.apcovid19.models;


import com.ap.covid19.api.apcovid19.converters.StringAttributeConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotNull
    @Column(columnDefinition = "TEXT")
    @Size(min = 25, max = 5000)
    @Convert(converter = StringAttributeConverter.class)
    private String response;

    @Column
    private Boolean read;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date readDate;

    @JsonIgnore
    @JoinColumn(name = "complaint_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Complaints complaints;

}
