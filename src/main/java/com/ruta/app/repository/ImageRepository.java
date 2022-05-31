package com.ruta.app.repository;

import com.ruta.app.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository <Image, Long> {
}
