package couhensoft.velochat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class RedisController {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/{id}")
    @ResponseBody
    public String test(@PathVariable long id, Model model){
        ValueOperations<String, Object> vop = redisTemplate.opsForValue();
        String user_id = String.valueOf(id);
        vop.set("jdk", user_id);
        String result = (String) vop.get("jdk");
        model.addAttribute("result", result);
        return "/redis";
    }
}
