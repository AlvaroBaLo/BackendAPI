package com.gestion.users.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.users.model.Post;

@Repository("postRepository")
public interface PostRepository extends JpaRepository<Post, Serializable> {

	public List<Post> findByAlias(String alias);
}
