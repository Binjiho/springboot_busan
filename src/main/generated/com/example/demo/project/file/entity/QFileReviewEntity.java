package com.example.demo.project.file.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFileReviewEntity is a Querydsl query type for FileReviewEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFileReviewEntity extends EntityPathBase<FileReviewEntity> {

    private static final long serialVersionUID = -795629953L;

    public static final QFileReviewEntity fileReviewEntity = new QFileReviewEntity("fileReviewEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Integer> deleteYn = createNumber("deleteYn", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> isFile = createNumber("isFile", Integer.class);

    public final NumberPath<Integer> ord = createNumber("ord", Integer.class);

    public final StringPath password = createString("password");

    public final NumberPath<Integer> secretYn = createNumber("secretYn", Integer.class);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedDate = _super.updatedDate;

    public final StringPath writer = createString("writer");

    public QFileReviewEntity(String variable) {
        super(FileReviewEntity.class, forVariable(variable));
    }

    public QFileReviewEntity(Path<? extends FileReviewEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFileReviewEntity(PathMetadata metadata) {
        super(FileReviewEntity.class, metadata);
    }

}

