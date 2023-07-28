package com.example.demo.admin.notice.dto;

import com.example.demo.admin.notice.entity.NoticeEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class NoticeDto {
    private Long id;
    private String title;
    private String writer;
    private String content;
    private int ord;
    private int deleteYn;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public static NoticeDto toDto(final NoticeEntity noticeEntity){
        return NoticeDto.builder()
                .id(noticeEntity.getId())
                .title(noticeEntity.getTitle())
                .writer(noticeEntity.getWriter())
                .content(noticeEntity.getContent())
                .ord(noticeEntity.getOrd())
                .deleteYn(noticeEntity.getDeleteYn())
                .startDate(noticeEntity.getStartDate())
                .endDate(noticeEntity.getEndDate())
                .build();
    }
}
