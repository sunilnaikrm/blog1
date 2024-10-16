package com.blog.controller;

import com.blog.payload.PostDto;
import com.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apipost")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<PostDto>> listAllPost(
            @RequestParam(value = "pageNo",defaultValue = "0",required = false) int pageNo,
            @RequestParam(value= "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = "id",required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ){
        List<PostDto> postDtos = postService.listAllPost(pageNo,pageSize,sortBy,sortDir);
        return new ResponseEntity<>(postDtos,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id") long id){
        PostDto dto = postService.getPostById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable("id") long id){
        PostDto dto = postService.updatePost(id, postDto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }


}
