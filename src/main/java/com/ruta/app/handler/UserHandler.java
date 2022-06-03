package com.ruta.app.handler;

import com.ruta.app.dto.UserDTO;
import com.ruta.app.entity.User;
import com.ruta.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserHandler {

    @Autowired
    private UserService userService;

    public User userDtoToUser(UserDTO userDTO){

        return User.builder()
                .nombres(userDTO.getNombres())
                .apellidos(userDTO.getApellidos())
                .ciudadNacimiento(userDTO.getCiudadNacimiento())
                .documento(userDTO.getDocumento())
                .tipoDocumento(userDTO.getTipoDocumento())
                .edad(userDTO.getEdad())
                .images(userDTO.getImages())
                .build();
    }
    public UserDTO userToUserDTO(User user){

        return UserDTO.builder()
                .nombres(user.getNombres())
                .apellidos(user.getApellidos())
                .ciudadNacimiento(user.getCiudadNacimiento())
                .documento(user.getDocumento())
                .tipoDocumento(user.getTipoDocumento())
                .edad(user.getEdad())
                .images(user.getImages())
                .build();
    }

    public UserDTO save(UserDTO userDTO) {
        return this.userToUserDTO(userService.save(this.userDtoToUser(userDTO)));
    }

    public Optional<UserDTO> findById(Long id) {
        UserDTO userDTO = this.userToUserDTO(userService.findById(id).get());
        return Optional.of(userDTO);
    }

    public void deleteById(Long id) {
        userService.deleteById(id);
    }
}
