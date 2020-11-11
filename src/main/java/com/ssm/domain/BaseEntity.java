package com.ssm.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类，包含uuid、创建时间和修改时间
 *
 * @author wqy
 * @version 1.0 2020/11/11
 */
public abstract class BaseEntity implements Serializable {

    private String id;

    private Date createAt;

    private Date updateAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
