package com.example.demo.admin.reservation.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReservationEntity is a Querydsl query type for ReservationEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReservationEntity extends EntityPathBase<ReservationEntity> {

    private static final long serialVersionUID = 1451897727L;

    public static final QReservationEntity reservationEntity = new QReservationEntity("reservationEntity");

    public final DatePath<java.time.LocalDate> end = createDate("end", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> ord = createNumber("ord", Integer.class);

    public final DatePath<java.time.LocalDate> start = createDate("start", java.time.LocalDate.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath title = createString("title");

    public QReservationEntity(String variable) {
        super(ReservationEntity.class, forVariable(variable));
    }

    public QReservationEntity(Path<? extends ReservationEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReservationEntity(PathMetadata metadata) {
        super(ReservationEntity.class, metadata);
    }

}

