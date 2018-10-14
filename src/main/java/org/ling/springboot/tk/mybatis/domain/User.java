package org.ling.springboot.tk.mybatis.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "T_USER")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * UNID账号
     */
    @Id
    private String unid;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 状态
     */
    private String status;
    /**
     * 有效标志:Y 有效；N 无效
     */
    private String validFlag;
    /**
     * 创建人
     */
    private String createdUser;
    /**
     * 创建时间
     */
    private Date createdDate;
    /**
     * 修改人
     */
    private String updatedUser;
    /**
     * 修改时间
     */
    private Date updatedDate;
}   