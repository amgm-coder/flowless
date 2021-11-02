package cn.pat.engine.repository;

import java.util.Date;

public interface Model {

    String getId();

    String getName();

    void setName(String name);

    String getKey();

    void setKey(String key);

    String getCategory();

    void setCategory(String category);

    Date getCreateTime();

    Date getLastUpdateTime();

    Integer getVersion();

    void setVersion(Integer version);

    String getMetaInfo();

    void setMetaInfo(String metaInfo);

    String getDeploymentId();

    void setDeploymentId(String deploymentId);

    void setTenantId(String tenantId);

    String getTenantId();

    String getEditorSource();

    void setEditorSource(String editorSource);

}
