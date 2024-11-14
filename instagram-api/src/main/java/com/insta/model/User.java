package com.insta.model;

import com.insta.dto.UserDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String email;
    private String mobile;
    private String website;
    private String bio;
    private String gender;
    private String image;
    private String name;

    private String password;

    @Embedded
    @ElementCollection
    private Set<UserDto> followers = new HashSet<>();

    @Embedded
    @ElementCollection
    private Set<UserDto> following = new HashSet();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Story> stories = new ArrayList();

    @ManyToMany
    private List<Post> savedPosts = new ArrayList();
}
