package com.esmile.common.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("SYS_USER")
public class User {

    @TableId
    private Long userId;
    private String userName;
    private String password;
    private String email;
}
