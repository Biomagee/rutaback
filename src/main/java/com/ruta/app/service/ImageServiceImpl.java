package com.ruta.app.service;

import com.ruta.app.entity.Image;
import com.ruta.app.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImageRepository imageRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Image> findAll(Pageable pageable) {
        return imageRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Image> findById(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    @Transactional
    public Image save(Image image) {
        return imageRepository.save(image);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        imageRepository.deleteById(id);
    }
}
