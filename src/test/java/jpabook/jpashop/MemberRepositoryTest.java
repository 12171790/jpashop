package jpabook.jpashop;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    // Transactional 어노테이션은 테스트가 끝나면 데이터를 롤백해버림.
    @Test
    @Transactional
//    @Rollback(false) : 데이터 롤백하는 것을 막을 수 있음.
    public void testMember() {
        // given
        Member member = new Member();
        member.setUserName("memberA");

        // when
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        // then
        assertEquals(member.getId(), findMember.getId());
    }
}