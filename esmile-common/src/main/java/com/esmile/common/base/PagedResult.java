package com.esmile.common.base;

import com.esmile.common.constant.HttpCode;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PagedResult<T> {

    private Boolean success;

    private String code;
    private String msg;
    private Long pageNo;
    private Long pageSize;
    private Long total;
    private List<T> records;

    public PagedResult(Long total, List<T> records) {
        this.success = Boolean.TRUE;
        this.code = HttpCode.SUCCESS;
        this.total = total;
        this.records = records;
    }
}
