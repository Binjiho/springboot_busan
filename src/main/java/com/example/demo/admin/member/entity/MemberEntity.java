package com.example.demo.admin.member.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "admin_member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "user_id", length = 100, nullable = false)
    private String userId;

    @Column(name="user_pw", length = 255, nullable = false)
    private String userPw;

    @Column(length = 100, nullable = false)
    private String htel;

    @Column(name= "from_social", length = 1, columnDefinition = "tinyint(1)")
    @ColumnDefault("0")
    private Integer fromSocial;

    @Column(name = "delete_yn")
    @ColumnDefault("0")
    private Boolean deleteYn;

    @CreatedDate
    @Column(name="created_date", updatable=false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name="modified_date")
    private LocalDateTime modifiedDate;

//    @ElementCollection(fetch = FetchType.LAZY)
//    @Builder.Default
//    private Set<MemberRole> roleSet = new HashSet<>();

//    public void addMemberRole(MemberRole memberRole){
//        roleSet.add(memberRole);
//    }
}
