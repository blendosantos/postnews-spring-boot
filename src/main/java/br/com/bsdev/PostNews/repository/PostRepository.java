package br.com.bsdev.PostNews.repository;

import br.com.bsdev.PostNews.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("FROM Post p where p.isHighlight = true")
    List<Post> allIsHighlight();

    @Query("FROM Post p where p.isHighlight = false")
    List<Post> allNotIsHighlight();
}
