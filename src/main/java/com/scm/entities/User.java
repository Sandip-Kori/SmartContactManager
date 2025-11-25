package com.scm.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    private String userId;
    @Column(name = "user_name",nullable = false)
    private String name;
    @Column(unique = true,nullable = false)
    private String email;
    private String password;
    @Transient            // 👈 NOT Stored in DB
    private String confirmPassword;
//    @Lob
//    @Column(columnDefinition = "TEXT")
    @Column(length = 1000)
    private String about;

//    @Lob
//    @Column(columnDefinition = "TEXT")
    @Column(length = 1000)
    private String profilePic;

    private String phoneNumber;

    private boolean enabled=false;
    private boolean emailVerified=false;
    private boolean phoneVerified=false;

//    @Enumerated(value = EnumType.STRING)
//    // SELF, GOOGLE, FACEBOOK , GITHUB etc
//    private Providers provider=Providers.SELF;
//    private String providerUserId;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Providers provider = Providers.SELF;

    private String providerUserId;

    @PrePersist
    public void prePersist() {
        if (this.provider == null) {
            this.provider = Providers.SELF;
        }
    }

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();



}
