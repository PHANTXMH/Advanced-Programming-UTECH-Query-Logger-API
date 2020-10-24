package com.ap.covid19.api.apcovid19.models;

import com.ap.covid19.api.apcovid19.enumerations.ComplainStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "complaints")
@Where(clause = "deleted_at is null")
public class Complaints extends TimeStamp{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services services;

    @Enumerated(EnumType.STRING)
    @Column
    private ComplainStatus complainStatus;

    @Lob
    @Column
    private String query;

    @OneToMany(mappedBy = "complaints")
    private List<ComplaintResponses> responses;

    @Column
    private Boolean read;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date readDate;

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(nullable = true)
//    private List<User> readBy;


}
