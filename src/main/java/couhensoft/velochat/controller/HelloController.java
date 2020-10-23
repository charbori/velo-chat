package couhensoft.velochat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

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

    @GetMapping("hello-video")
    public String helloVideo(){
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

    private void readAndWrite(final InputStream is, OutputStream os)
            throws IOException {
        byte[] data = new byte[2048];
        int read = 0;
        while ((read = is.read(data)) > 0) {
            os.write(data, 0, read);
        }
        os.flush();
    }

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
