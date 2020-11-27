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
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "liveChatAvailability")
    List<LiveChatAvailableTime> liveChatAvailableTimes;


}
