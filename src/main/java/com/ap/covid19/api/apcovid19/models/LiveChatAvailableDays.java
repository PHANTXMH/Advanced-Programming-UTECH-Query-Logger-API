package com.ap.covid19.api.apcovid19.models;

import com.ap.covid19.api.apcovid19.enumerations.Day;
import com.ap.covid19.api.apcovid19.validators.LiveChatUniqueDayUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "days", uniqueConstraints = {@UniqueConstraint(columnNames = {"day", "available_day"}, name = "uniqueDayUserIDConstraint")})
public class LiveChatAvailableDays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "available_day")
    private LiveChatAvailability liveChatAvailability;

   // @LiveChatUniqueDayUser(message = "day already exists for user")
    @Column
    @Enumerated(EnumType.STRING)
    private Day day;


}
