package com.example.basic.repository;

import com.example.basic.domain.entity.Member;
import com.example.basic.domain.entity.type.MemberType;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional //필드 안에 있는 모든 메소드에 트랜잭션이 각각 생긴다.
@Rollback(false)
@SpringBootTest
@Slf4j
public class MemberDaoTests {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private  MemberDAO memberDAO;

    @Test
    public void saveTest() {
        Member member = new Member();
        member.setMemberEmail("tadhan111@gmail.com");
        member.setMemberName("박정호");
        member.setMemberAge(33);
        member.setMemberPassword("2346");

         memberDAO.save(member);


    }


    @Test
    public void setMemberAgeTest(){
        Member member = new Member();
        member.setMemberName("한동석");
        member.setMemberEmail("tedhan1204@gmail.com");
        member.setMemberPassword("1234");
        member.setMemberType(MemberType.MEMBER);
        member.setMemberAge(20);

        memberDAO.save(member);
        member.setMemberAge(99);
    }

    @Test
    public void deleteTest(){
        Member member = new Member();
        member.setMemberName("한동석");
        member.setMemberEmail("tedhan1204@gmail.com");
        member.setMemberPassword("1234");
        member.setMemberType(MemberType.MEMBER);
        member.setMemberAge(20);

        memberDAO.save(member);
        memberDAO.delete(member);
    }


    @Test
    public void findByIdTest(){
        Optional<Member> optionalMember = memberDAO.findById(10L);
            // 값을 가져올때는 orelse로 가져오기
        //        Member member = optionalMember.orElse(new Member());
//        Member member = optionalMember.orElseGet(Member::new);

//        if(optionalMember.isPresent()){
//            optionalMember.get();
//        }
            // 값이 있을때만
//        optionalMember.ifPresent(member -> assertThat(member.getMemberName()).isEqualTo("한동석"));
    }

    @Test
    public void findAllTest(){
        memberDAO.findAll().stream().map(Member::getMemberName).forEach(log::info);
    }

    @Test
    public void findAllWithPagingTest(){
        memberDAO.findAllWithPaging(11, 10).stream().map(Member::getMemberName).forEach(log::info);
    }

    @Test
    public void findByMemberNameTest(){
//        memberDAO.findByMemberName("user99").stream().map(Member::getMemberName).forEach(log::info);
        assertThat(memberDAO.findByMemberName("user99").stream().map(Member::getMemberAge).map(String::valueOf).collect(Collectors.joining())).isEqualTo("99");
    }

    @Test
    public void updateByMemberAgeLessThanEqualTest(){
        memberDAO.findAll();
        memberDAO.updateByMemberAgeLessThanEqual(20);
        memberDAO.findAll().stream().map(Member::getMemberType).map(Enum::toString).forEach(log::info);
    }



}