package com.example.demo.admin.review.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReviewEntity is a Querydsl query type for ReviewEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewEntity extends EntityPathBase<ReviewEntity> {

    private static final long serialVersionUID = -1256746103L;

    public static final QReviewEntity reviewEntity = new QReviewEntity("reviewEntity");

    public final NumberPath<Integer> cCode = createNumber("cCode", Integer.class);

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> deleteYn = createNumber("deleteYn", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> isFile = createNumber("isFile", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedDate = createDateTime("modifiedDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> ord = createNumber("ord", Integer.class);

    public final StringPath password = createString("password");

    public final NumberPath<Integer> secretYn = createNumber("secretYn", Integer.class);

    public final StringPath title = createString("title");

    public final StringPath writer = createString("writer");

    public QReviewEntity(String variable) {
        super(ReviewEntity.class, forVariable(variable));
    }

    public QReviewEntity(Path<? extends ReviewEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReviewEntity(PathMetadata metadata) {
        super(ReviewEntity.class, metadata);
    }

}

