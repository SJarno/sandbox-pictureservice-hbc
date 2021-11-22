package com.jarno.pictureservice.repositories;

import com.jarno.pictureservice.models.ImageObject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageObjectRepository extends JpaRepository<ImageObject, Long> {
    
}
