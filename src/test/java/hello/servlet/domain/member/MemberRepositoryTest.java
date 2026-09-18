package hello.servlet.domain.member;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearstore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("yoo", 31);

        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        Assertions.assertThat(findMember).isEqualTo(savedMember);

    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("kwangyeol", 31);
        Member member2 = new Member("minha", 33);
        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> memberList = memberRepository.findAll();

        //then
        Assertions.assertThat(memberList.size()).isEqualTo(2);
        Assertions.assertThat(memberList).contains(member1,member2);
    }
}
