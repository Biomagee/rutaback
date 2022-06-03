package com.ruta.app.controller;

import java.util.Optional;

import com.ruta.app.dto.UserDTO;
import com.ruta.app.entity.User;
import com.ruta.app.handler.UserHandler;
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
    private UserHandler userHandler;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userHandler.save(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long userId) {
        Optional<UserDTO> oUser = userHandler.findById(userId);

        if (!oUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody UserDTO userDetails, @PathVariable(value = "id") Long userId) {
        Optional<UserDTO> user = userHandler.findById(userId);

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

        return ResponseEntity.status(HttpStatus.CREATED).body(userHandler.save(user.get()));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId) {
        if (!userHandler.findById(userId).isPresent()) {
            return ResponseEntity.notFound().build();

        }

        userHandler.deleteById(userId);
        return ResponseEntity.ok().build();

    }
}


