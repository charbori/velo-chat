package couhensoft.velochat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class StaticVideoController {

    private final static File MP4_FILE = new File("C:\\Users\\jaehyeok\\Downloads\\sample.mp4");

    @Autowired
    private StaticVideoControllerHandler handler;

    @GetMapping("staticVideo")
    public void staticVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(StaticVideoControllerHandler.ATTR_FILE, MP4_FILE);
        handler.handleRequest(request, response);
    }

    @Component
    final static class StaticVideoControllerHandler extends ResourceHttpRequestHandler {
        private final static String ATTR_FILE = StaticVideoControllerHandler.class.getName() + ".file";

        @Override
        protected Resource getResource(HttpServletRequest request) throws IOException{
            final File file = (File) request.getAttribute(ATTR_FILE);
            return new FileSystemResource(file);
        }
    }
}
