package br.com.bsdev.PostNews.repository;

import br.com.bsdev.PostNews.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
