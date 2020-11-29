package com.ap.covid19.api.apcovid19.models;


import com.ap.covid19.api.apcovid19.enumerations.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
@ToString
@Entity
@Table(name = "Users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        })
})
@Where(clause = "deleted_at is null")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 7, max = 7)
    @Column(name = "username")
    private String userName;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "email")
    private String email;

    @Size(min = 7, max = 10)
    @Column(name = "contact")
    private Long contact;

    @NotBlank
    @Size(min = 6, max = 100)
    @Column(name = "password")
    @JsonIgnore
    private String password;

    @NotBlank
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;


    @Column(
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            nullable = false,
            insertable = false,
            updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<LiveChatAvailability> liveChatAvailabilities;

    public User(Long id, String email){
        this.id = id;
        this.email = email;
    }

    public User(Long id){
        this.id = id;
    }

}
