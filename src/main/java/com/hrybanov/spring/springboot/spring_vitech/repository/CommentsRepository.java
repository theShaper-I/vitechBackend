package com.hrybanov.spring.springboot.spring_vitech.repository;

import com.hrybanov.spring.springboot.spring_vitech.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CommentsRepository extends JpaRepository<Comment, Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into my_db.comments (text, data, patient_id) VALUES (:text, :data, :id)", nativeQuery = true)
    void setPatientComment(@Param("text") String text, @Param("data") String data, @Param("id") Long id);
}
