package com.example.demo.project.file.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFileMemberEntity is a Querydsl query type for FileMemberEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFileMemberEntity extends EntityPathBase<FileMemberEntity> {

    private static final long serialVersionUID = -47693759L;

    public static final QFileMemberEntity fileMemberEntity = new QFileMemberEntity("fileMemberEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath password = createString("password");

    public final EnumPath<com.example.demo.project.file.constrant.Role> role = createEnum("role", com.example.demo.project.file.constrant.Role.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedDate = _super.updatedDate;

    public QFileMemberEntity(String variable) {
        super(FileMemberEntity.class, forVariable(variable));
    }

    public QFileMemberEntity(Path<? extends FileMemberEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFileMemberEntity(PathMetadata metadata) {
        super(FileMemberEntity.class, metadata);
    }

}

