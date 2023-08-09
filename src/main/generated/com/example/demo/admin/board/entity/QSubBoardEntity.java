package com.example.demo.admin.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSubBoardEntity is a Querydsl query type for SubBoardEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubBoardEntity extends EntityPathBase<SubBoardEntity> {

    private static final long serialVersionUID = -59103693L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSubBoardEntity subBoardEntity = new QSubBoardEntity("subBoardEntity");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> deleteYn = createNumber("deleteYn", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMainBoardEntity mainBoardEntity;

    public final DateTimePath<java.time.LocalDateTime> modifiedDate = createDateTime("modifiedDate", java.time.LocalDateTime.class);

    public final StringPath name = createString("name");

    public final StringPath originalName = createString("originalName");

    public final StringPath saveName = createString("saveName");

    public final StringPath uploadPath = createString("uploadPath");

    public final StringPath userPw = createString("userPw");

    public QSubBoardEntity(String variable) {
        this(SubBoardEntity.class, forVariable(variable), INITS);
    }

    public QSubBoardEntity(Path<? extends SubBoardEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSubBoardEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSubBoardEntity(PathMetadata metadata, PathInits inits) {
        this(SubBoardEntity.class, metadata, inits);
    }

    public QSubBoardEntity(Class<? extends SubBoardEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mainBoardEntity = inits.isInitialized("mainBoardEntity") ? new QMainBoardEntity(forProperty("mainBoardEntity")) : null;
    }

}

