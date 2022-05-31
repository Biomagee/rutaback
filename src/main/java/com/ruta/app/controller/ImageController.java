package com.ruta.app.controller;

import java.util.Optional;

import com.ruta.app.entity.Image;
import com.ruta.app.entity.User;
import com.ruta.app.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/app/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping
    public ResponseEntity<?> create(@RequestParam String user,@RequestBody Image image ) {
        User user1 = new User();
        user1.setId(Long.valueOf(user));
        image.setUser(user1);
       return ResponseEntity.status(HttpStatus.CREATED).body(imageService.save(image));

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long imageId) {
        Optional<Image> oImage = imageService.findById(imageId);

        if (!oImage.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oImage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Image imageDetails, @PathVariable(value = "id") Long imageId) {
        Optional<Image> image = imageService.findById(imageId);

        if (!image.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        image.get().setImg(imageDetails.getImg());
        image.get().setUser(imageDetails.getUser());

        return ResponseEntity.status(HttpStatus.CREATED).body(imageService.save(image.get()));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long imageId) {
        if (!imageService.findById(imageId).isPresent()) {
            return ResponseEntity.notFound().build();

        }

        imageService.deleteById(imageId);
        return ResponseEntity.ok().build();

    }
}
