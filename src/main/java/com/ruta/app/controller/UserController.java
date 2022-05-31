package com.ruta.app.controller;

import java.util.Optional;

import com.ruta.app.entity.User;
import com.ruta.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/app/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long userId) {
        Optional<User> oUser = userService.findById(userId);

        if (!oUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User userDetails, @PathVariable(value = "id") Long userId) {
        Optional<User> user = userService.findById(userId);

        if (!user.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        user.get().setNombres(userDetails.getNombres());
        user.get().setApellidos(userDetails.getApellidos());
        user.get().setTipoDocumento(userDetails.getTipoDocumento());
        user.get().setDocumento(userDetails.getDocumento());
        user.get().setEdad(userDetails.getEdad());
        user.get().setCiudadNacimiento(userDetails.getCiudadNacimiento());
        user.get().setImages(userDetails.getImages());

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId) {
        if (!userService.findById(userId).isPresent()) {
            return ResponseEntity.notFound().build();

        }

        userService.deleteById(userId);
        return ResponseEntity.ok().build();

    }
}


