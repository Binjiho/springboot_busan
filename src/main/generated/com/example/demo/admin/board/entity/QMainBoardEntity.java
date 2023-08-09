package com.example.demo.admin.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMainBoardEntity is a Querydsl query type for MainBoardEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMainBoardEntity extends EntityPathBase<MainBoardEntity> {

    private static final long serialVersionUID = -778003962L;

    public static final QMainBoardEntity mainBoardEntity = new QMainBoardEntity("mainBoardEntity");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> deleteYn = createNumber("deleteYn", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedDate = createDateTime("modifiedDate", java.time.LocalDateTime.class);

    public final StringPath name = createString("name");

    public final StringPath userPw = createString("userPw");

    public QMainBoardEntity(String variable) {
        super(MainBoardEntity.class, forVariable(variable));
    }

    public QMainBoardEntity(Path<? extends MainBoardEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMainBoardEntity(PathMetadata metadata) {
        super(MainBoardEntity.class, metadata);
    }

}

