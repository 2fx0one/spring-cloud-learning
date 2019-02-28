package com.tfx0one;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @projectName: base-web
 * @author: 2fx0one
 * @date: 2019/1/23 09:17
 * @Version: 1.0
 */
@Data
@Accessors(chain = true)
public class BaseEntity implements Serializable {

    private String id;
    /**
     * 创建者
     */

    private String createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 删除标记
     */
    private String delFlag;

    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
}
