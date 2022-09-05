package hello.hellospring;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class HelloSpringApplicationTests {

	MemoryMemberRepository repository = new MemoryMemberRepository();

	@Test
	public void save(){
		Member member = new Member();
		member.setName("spring");

		repository.save(member);

		Member result = repository.findById(member.getId()).get();
		//System.out.println("(result == member) =  " + (result == member));
		assertThat(member).isEqualTo(result);
	}

}
