package org.ling.springboot.tk.mybatis.domain;

import lombok.Data;

@Data
public class Page {
    public Integer pageNum = 1;
    public Integer pageSize = 10;
    public String orderBy;
}