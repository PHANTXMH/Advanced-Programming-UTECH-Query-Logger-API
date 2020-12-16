package com.ap.covid19.api.apcovid19.models;

import com.ap.covid19.api.apcovid19.converters.StringAttributeConverter;
import com.ap.covid19.api.apcovid19.enumerations.ComplainStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
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

    @Valid
    @NotNull
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services services;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(15) DEFAULT 'NEW'")
    private ComplainStatus complainStatus;

    @NotNull
    @Column(columnDefinition = "TEXT")
    @Size(min = 6, max = 5000)
    @Convert(converter = StringAttributeConverter.class)
    private String query;

    @JsonManagedReference // https://www.appsdeveloperblog.com/infinite-recursion-in-objects-with-bidirectional-relationships/
    @OneToMany(mappedBy = "complaints")
    private List<ComplaintResponses> responses = new ArrayList<ComplaintResponses>();

  //  @Column(columnDefinition = "tinyint(1) default 0") this is for mysql
  //  @Column(columnDefinition = "boolean default true")
    @Transient
    private Boolean read;

    @Column
    private String isRead;

    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    private Date readDate;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(nullable = true)
//    private List<User> readBy;


}
