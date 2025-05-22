package com.example.BigganGlopo.features.bolg.repository;

import com.example.BigganGlopo.features.bolg.entity.Blog;
import com.example.BigganGlopo.generic.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    List<Blog> findAllByOrderByCreatedAtDesc();

}
