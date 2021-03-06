package com.example.multimedia.repository;

import antlr.LexerSharedInputState;
import com.example.multimedia.domain.ForumComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForumCommentRepository extends JpaRepository<ForumComment,Long> {
    ForumComment findById(long id);
    Page<ForumComment> findByForumid(long id, Pageable pageable);
    List<ForumComment> findByRcommentid(long id);
}
