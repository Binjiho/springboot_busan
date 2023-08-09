package com.example.demo.admin.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberEntity is a Querydsl query type for MemberEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberEntity extends EntityPathBase<MemberEntity> {

    private static final long serialVersionUID = -1241019507L;

    public static final QMemberEntity memberEntity = new QMemberEntity("memberEntity");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> deleteYn = createNumber("deleteYn", Integer.class);

    public final NumberPath<Integer> fromSocial = createNumber("fromSocial", Integer.class);

    public final StringPath htel = createString("htel");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedDate = createDateTime("modifiedDate", java.time.LocalDateTime.class);

    public final StringPath name = createString("name");

    public final EnumPath<com.example.demo.admin.member.config.Role> role = createEnum("role", com.example.demo.admin.member.config.Role.class);

    public final StringPath userId = createString("userId");

    public final StringPath userPw = createString("userPw");

    public QMemberEntity(String variable) {
        super(MemberEntity.class, forVariable(variable));
    }

    public QMemberEntity(Path<? extends MemberEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberEntity(PathMetadata metadata) {
        super(MemberEntity.class, metadata);
    }

}

