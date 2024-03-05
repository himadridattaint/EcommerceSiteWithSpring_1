package com.INTStore.EcommerceSiteWithSpring.application.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="user")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String mail;
    private String password;
    private String role;

    @ManyToMany
    @JoinTable(name="user_address",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="address_id"))
    private Set<Address> addresses = new HashSet<>();
}
