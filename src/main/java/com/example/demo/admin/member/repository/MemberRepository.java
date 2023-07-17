package com.example.demo.admin.member.repository;

import com.example.demo.admin.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

//    @EntityGraph(attributePaths = {"roleSet"}, type=EntityGraph.EntityGraphType.LOAD)
//    @Query("select m from AdminMemberEntity m where m.fromSocial = :social and m.userId = :userId")
//    Optional<AdminMemberEntity> findByUserId(String userId, int social);
}
