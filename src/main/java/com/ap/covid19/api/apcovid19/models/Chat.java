package com.ap.covid19.api.apcovid19.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false, insertable = false, nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @OneToOne
    private User to;

    @OneToOne
    private User from;

    @JsonManagedReference
    @OneToMany(mappedBy = "chat")
    List<ChatMessages> chatMessagesList = new ArrayList<>();

    public Chat(User to, User from) {
        this.to = to;
        this.from = from;
    }
}
