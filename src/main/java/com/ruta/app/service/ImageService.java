package com.ruta.app.service;

import com.ruta.app.entity.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface ImageService {
    public Iterable<Image> findAll();

    public Page<Image> findAll(Pageable pageable);

    public Optional<Image> findById(Long id);

    public Image save(Image image);

    public void deleteById(Long id);


}
