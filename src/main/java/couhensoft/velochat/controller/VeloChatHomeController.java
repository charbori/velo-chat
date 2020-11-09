package couhensoft.velochat.controller;

import couhensoft.velochat.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VeloChatHomeController {

    private final MemberService memberService;

    @Autowired
    public VeloChatHomeController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/home/veloChatHome")
    public String veloChatHome(Model model){
        model.addAttribute("template", "home/content/welcome");
        return "home/veloChatHome";
    }

}
