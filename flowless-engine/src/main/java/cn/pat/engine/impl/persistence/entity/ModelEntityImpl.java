package cn.pat.engine.impl.persistence.entity;

import cn.pat.engine.repository.Model;
import lombok.Data;

import java.util.Date;

@Data
public class ModelEntityImpl implements Model {

    private static final long serialVersionUID = 1L;

    protected String id;
    protected String name;
    protected String key;
    protected String category;
    protected Date createTime;
    protected Date lastUpdateTime;
    protected Integer version = 1;
    protected String metaInfo;
    protected String deploymentId;
    protected String tenantId;
    protected String editorSource;
}
