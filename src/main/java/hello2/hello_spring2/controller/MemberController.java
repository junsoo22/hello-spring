package hello2.hello_spring2.controller;

import hello2.hello_spring2.domain.Member;
import hello2.hello_spring2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")   //등록 버튼 눌렀을떄, 여기로 넘어옴
    public String create(MemberForm form){
        Member member=new Member();
        member.setName(form.getName());
        System.out.println("member= "+member.getName());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping(value="/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }

//    @Autowired
//    public void setMemberService(MemberService memberService){  //setter injection->
//        this.memberService=memberService;
//    }
}
