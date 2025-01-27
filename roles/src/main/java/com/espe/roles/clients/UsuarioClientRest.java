//CONEXIÓN DEL MICROSERVICIO CON EL URL

package com.espe.roles.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.espe.roles.model.Usuario;

@FeignClient(name = "usuario", url = "localhost:8002/api/usuarios")
public interface UsuarioClientRest {
    @GetMapping("/{id}")
    Usuario findById(@PathVariable Long id);
}
