package couhensoft.velochat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-spring")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    @GetMapping("/hello-video")
    public String helloApi(){
        return "hello-video";
    }

//    @RequestMapping("/jsp")
//    public StreamingResponseBody stream(@PathVariable String video)
//            throws FileNotFoundException {
//        File videos = new File("C:\\Users\\jaehyeok\\Downloads\\sample.mp4");
//        final InputStream videoFileStream = new FileInputStream(videos);
//        return (os) -> {
//            readAndWrite(videoFileStream, os);
//        };
//    }

//
//    @RequestMapping("/jsp")
//    public ModelAndView jsp(){
//        ModelAndView model = new ModelAndView("video");
//        model.addObject("ROOT", "C:\\Users\\jaehyeok\\Downloads\\");
//        model.addObject("fileName", "sample.mp4");
//        model.setViewName("video");
//        return model;
//    }

    static class Hello {
        private String name;

        public String getName(){
            return this.name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
