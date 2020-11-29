package com.ap.covid19.api.apcovid19.models;

import com.ap.covid19.api.apcovid19.converters.StringAttributeConverter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "chat_messages")
public class ChatMessages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    @Size(min = 1, max = 5000)
    @Convert(converter = StringAttributeConverter.class)
    private String message;

    @Column(updatable = false, insertable = false, nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column
    private Boolean read;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date readDate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @OneToOne
    private User sendBy;

    public ChatMessages(String message, Boolean read) {
        this.message = message;
        this.read = read;
    }
}
