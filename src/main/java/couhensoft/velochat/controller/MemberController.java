package couhensoft.velochat.controller;

import com.sun.istack.NotNull;
import couhensoft.velochat.domain.Member;
import couhensoft.velochat.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {

    private final MemberService memberService;
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public MemberController(MemberService memberService, RedisTemplate<String, Object> redisTemplate){
        this.memberService = memberService;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 회원 가입
     * @return
     */
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

    /**
     * 회원 로그인
     * @return
     */
    @GetMapping("/members/login")
    public String loginPage(){
        return "members/login";
    }

    @PostMapping("/members/login")
    public String loginDataPost(@NotNull MemberLoginForm form){
        String email = form.getEmail();
        String password = form.getEmail();

        if(checkMemberSession(email)){
            return "redirect:/home/veloChatHome";
        }else{
            Optional<Member> member = memberService.login(email, Hash(password));
            member.ifPresent(member1 -> {
                setMemberSession(member1);
            });
            return "redirect:/home/veloChatHome";
        }
    }

    /**
     * redis 세션 생성
     * @param member
     * @return
     */
    public void setMemberSession(Member member){
        ValueOperations<String, Object> vop = redisTemplate.opsForValue();
        vop.set((member.getMem_email()), Hash(member.getMem_email()));
    }

    /**
     * redis 세션 조회
     * @param email
     * @return
     */
    public boolean checkMemberSession(String email){
        boolean result = true;

        ValueOperations<String, Object> vop = redisTemplate.opsForValue();
        String str = (String) vop.get(email);

        if(str != null){
            return true;
        }else{
            return false;
        }

    }
    /**
     * 민감정보 해싱
     * @param data
     * @return
     */
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
