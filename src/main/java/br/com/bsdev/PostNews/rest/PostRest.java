package br.com.bsdev.PostNews.rest;

import br.com.bsdev.PostNews.entity.Post;
import br.com.bsdev.PostNews.repository.PostRepository;
import br.com.bsdev.PostNews.request.PostRequest;
import br.com.bsdev.PostNews.response.MessageResponse;
import br.com.bsdev.PostNews.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "posts")
public class PostRest {

    @Autowired
    PostRepository postRepository;
    @Autowired
    StorageService storageService;

    @GetMapping
    public ResponseEntity<List<Post>> allNotIsHighlight(){
        List<Post> postsHighlight = postRepository.allNotIsHighlight();
        return ResponseEntity.ok(postsHighlight);
    }

    @GetMapping("/highlights")
    public ResponseEntity<List<Post>> allIsHighlight(){
        List<Post> postsHighlight = postRepository.allIsHighlight();
        return ResponseEntity.ok(postsHighlight);
    }

    @PostMapping
    public ResponseEntity<MessageResponse> addPost(PostRequest postRequest) {
        MessageResponse messageResponse = new MessageResponse();
        if (postRequest.getFile().isEmpty()) {
            messageResponse.setCode(404);
            messageResponse.setMessage("Image not found!");
        }

        if (postRequest.getTitle().length() <= 0 || postRequest.getDescription().length() <= 0 || postRequest.getHighlight() == null) {
            messageResponse.setCode(500);
            messageResponse.setMessage("Fill in all the service fields!");
        }

        String pathImage = storageService.uploadFile(postRequest.getFile());

        try {
            Post post = new Post();
            post.setPathImage(pathImage);
            post.setTitle(postRequest.getTitle());
            post.setDescription(postRequest.getDescription());
            post.setHighlight(postRequest.getHighlight());

            postRepository.save(post);

            messageResponse.setCode(200);
            messageResponse.setMessage("Post saved successfully!");
        } catch (Exception error) {
            messageResponse.setCode(500);
            messageResponse.setMessage(error.getMessage());
        }

        return ResponseEntity.ok(messageResponse);
    }

    @PutMapping
    public ResponseEntity<MessageResponse> putPost(PostRequest postRequest) {
        MessageResponse messageResponse = new MessageResponse();

        if (postRequest.getId() == null) {
            messageResponse.setCode(404);
            messageResponse.setMessage("Post not registered!");
        }

        if (postRequest.getTitle().length() <= 0 || postRequest.getDescription().length() <= 0 || postRequest.getHighlight() == null) {
            messageResponse.setCode(500);
            messageResponse.setMessage("Fill in all the service fields!");
        }

        String pathImage = null;
        if (!postRequest.getFile().isEmpty()) {
            pathImage = storageService.uploadFile(postRequest.getFile());
        }

        try {
            Post post = postRepository.getOne(postRequest.getId());
            if (pathImage != null) {
                post.setPathImage(pathImage);
            }
            post.setTitle(postRequest.getTitle());
            post.setDescription(postRequest.getDescription());
            post.setHighlight(postRequest.getHighlight());

            postRepository.save(post);

            messageResponse.setCode(200);
            messageResponse.setMessage("Post saved successfully!");
        } catch (Exception error) {
            messageResponse.setCode(500);
            messageResponse.setMessage(error.getMessage());
        }

        return ResponseEntity.ok(messageResponse);
    }

}
