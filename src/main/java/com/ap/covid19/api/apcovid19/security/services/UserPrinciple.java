package com.ap.covid19.api.apcovid19.security.services;

import com.ap.covid19.api.apcovid19.enumerations.Role;
import com.ap.covid19.api.apcovid19.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

@Setter
@Getter
public class UserPrinciple implements UserDetails {

    private static final long serialVersionID = 1L;

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String username;

    private Role role;

    @JsonIgnore
    private String password;


    public UserPrinciple(Long id, String firstName, String lastName, String email, String password, String username, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
    }

    public static UserPrinciple build(User user) {

        return new UserPrinciple(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getUserName(),
                user.getRole()
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }


}
