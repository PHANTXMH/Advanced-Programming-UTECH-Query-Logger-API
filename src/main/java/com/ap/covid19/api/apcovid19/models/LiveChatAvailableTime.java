package com.ap.covid19.api.apcovid19.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "live_chat_available_time")
public class LiveChatAvailableTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "available_day")
    private LiveChatAvailability liveChatAvailability;

    @Column
    private Time startTime;

    @Column
    private Time endTime;

}
