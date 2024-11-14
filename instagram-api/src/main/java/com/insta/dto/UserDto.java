package com.insta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String username;
    private String email;
    private String name;
    private String userImage;
}
