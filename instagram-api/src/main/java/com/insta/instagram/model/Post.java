package com.insta.instagram.model;

import com.insta.instagram.dto.UserDto;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String caption;
    private String image;
    private String location;
    private LocalDateTime createdAt;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="id", column=@Column(name="user_id")),
            @AttributeOverride(name="email", column=@Column(name="user_email"))
    })
    private UserDto user;
}
