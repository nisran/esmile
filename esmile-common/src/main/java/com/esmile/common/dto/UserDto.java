package com.esmile.common.dto;

import lombok.Data;

/**
 * @Classname UserDto
 * @Description TODO
 * @Version 1.0.0
 * @Date 11/3/2023 下午10:13
 * @Created by nisran
 */
@Data
public class UserDto {
    private Long userId;
    private String userName;
    private String password;
    private String email;
}
