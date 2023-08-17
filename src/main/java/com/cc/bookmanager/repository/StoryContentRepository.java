package com.cc.bookmanager.repository;

import com.cc.bookmanager.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface StoryContentRepository extends JpaRepository<Genre, UUID>, JpaSpecificationExecutor<UUID> {
}
