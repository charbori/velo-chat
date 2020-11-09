package couhensoft.velochat.controller;

import com.sun.istack.NotNull;
import couhensoft.velochat.domain.Member;
import couhensoft.velochat.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@NotNull MemberForm form) {
        int alarm = 0;
        int profile = 0;
        if (form.getOpenProfile()) profile = 1;
        if (form.getReceiveAlarm()) alarm = 1;

        String pw = Hash(form.getPassword());
        String phone = Hash(form.getPhone());

        if (pw == null || phone == null) {
            //회원 가입 에러나 다른 메시지 팝업
            //그리고 다른 데이터도 포괄 에러 처리 방법
            return "redirect:/";
        }

        Member member = new Member();
        member.setMem_name(form.getName());
        member.setMem_email(form.getEmail());
        member.setMem_password(pw);
        member.setMem_phone(phone);
        member.setMem_open_profile(profile);
        member.setMem_receive_alarm(alarm);

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMember();
        model.addAttribute("members", members);
        return "members/memberList";
    }

    @GetMapping("/members/login")
    public String loginPage(){
        return "members/login";
    }

    @PostMapping("/members/login")
    public String loginDataPost(@NotNull MemberLoginForm form){
        String email = form.getEmail();
        String password = form.getPassword();

        if(memberService.login(email, Hash(password))){
            return "home/veloChatHome";
        }else{
            //실패 메시지 알림.
            return "members/login";
        }
    }

    public String Hash(String data){

        String pre = data.substring(0, data.length()/2);
        String las = data.substring(data.length()/2);

        data = las + pre + "1234";

        try {
            MessageDigest sh = MessageDigest.getInstance("SHA-256");
            sh.update(data.getBytes());
            byte byteData[] = sh.digest();
            StringBuilder sb = new StringBuilder();

            for(int i = 0 ; i < byteData.length ; i++){
                sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

}
