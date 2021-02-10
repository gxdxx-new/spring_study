package hello.studyspring.controller;

import hello.studyspring.domain.Member;
import hello.studyspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /* home.html에서 회원가입 버튼을 누르면 /members/new로 이동함.
       -> createMemberForm.html이 실행되고 사용자가 이름을 입력하면
          /members/new에 Post방식으로 넘어옴.
     */
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        //createMemberForm.html에서 저장된 name을 입력받아서 memberform에 저장
        member.setName(form.getName());

        //회원가입
        memberService.join(member);

        //홈 화면으로 이동
        return "redirect:/";
    }

    @GetMapping("/members")
    public String List(Model model) {
        List<Member> members = memberService.findMember();
        model.addAttribute("members", members); //members 리스트를 model에 담아서 화면으로 넘김
        return "members/memberList";
    }
}
