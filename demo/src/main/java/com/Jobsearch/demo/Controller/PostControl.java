package com.Jobsearch.demo.Controller;

import com.Jobsearch.demo.model.Post;
import com.Jobsearch.demo.Service.PostService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class PostControl {

    @Autowired
    PostService service;


    @Hidden
    @RequestMapping("/")
    public void viewpage(HttpServletResponse response) throws IOException {

        response.sendRedirect("/swagger-ui/index.html");
    }

    @GetMapping("/posts")
    public List<Post> getPosts (){

        return service.getPosts();
    }

    @PostMapping("post")
    public Post setPost(Post p ){

        return service.setPost(p);
    }

    @GetMapping("/post")
    public List<Post> getPost(String text ){

        return service.SearchPost(text) ;
    }
}
