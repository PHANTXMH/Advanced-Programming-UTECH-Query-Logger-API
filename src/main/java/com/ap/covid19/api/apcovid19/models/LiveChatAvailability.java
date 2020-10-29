package com.ap.covid19.api.apcovid19.models;

import com.ap.covid19.api.apcovid19.enumerations.Day;
import com.ap.covid19.api.apcovid19.validators.LiveChatUniqueDayUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "live_chat_availability",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"day", "user_id"}, name = "uniqueDayUserIDConstraint")})
public class LiveChatAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @LiveChatUniqueDayUser(message = "day already exists for user")
    @Column
    @Enumerated(EnumType.STRING)
    private Day day;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
