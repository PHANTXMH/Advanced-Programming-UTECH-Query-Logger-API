package com.ap.covid19.api.apcovid19.models;

import com.ap.covid19.api.apcovid19.enumerations.Day;
import com.ap.covid19.api.apcovid19.validators.LiveChatUniqueDayUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "live_chat_availability")
public class LiveChatAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private Time startTime;

    @Column
    private Time endTime;

    @JsonManagedReference
    @OneToMany(mappedBy = "liveChatAvailability", cascade = CascadeType.ALL)
    List<LiveChatAvailableDays> liveChatAvailableDays;


}
