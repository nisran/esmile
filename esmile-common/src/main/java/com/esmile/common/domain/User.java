package com.esmile.common.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.esmile.common.base.BaseDomain;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@TableName("SYS_USER")
public class User extends BaseDomain {

    @TableId
    private Long userId;
    private String userName;
    private String password;

}
