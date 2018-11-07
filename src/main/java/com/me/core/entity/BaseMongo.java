package com.me.core.entity;

import com.me.core.constant.fields.BaseMongoFields;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "baseBuilder")
public class BaseMongo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Field(value = BaseMongoFields.ID)
    private String id;

    @Version
    @Field(value = BaseMongoFields.VERSION)
    private Long version;

    @CreatedDate
    @Field(value = BaseMongoFields.CREATED_DATE)
    private Date createdDate;

    @CreatedBy
    @Field(value = BaseMongoFields.CREATED_BY)
    private String createdBy;

    @LastModifiedDate
    @Field(value = BaseMongoFields.UPDATED_DATE)
    private Date updatedDate;

    @LastModifiedBy
    @Field(value = BaseMongoFields.UPDATED_BY)
    private String updatedBy;

    @Field(value = BaseMongoFields.IS_DELETED)
    private boolean isDeleted;

    private boolean isActive;

    private Date syncTime;

    private String timestamp;
}
