package pe.cibertec.edu.pr_backend_morales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.edu.pr_backend_morales.dto.AuthRequestDTO;
import pe.cibertec.edu.pr_backend_morales.dto.IntegranteDTO;
import pe.cibertec.edu.pr_backend_morales.service.AuthService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/autenticar")
    public boolean autenticar(@RequestBody AuthRequestDTO request) {
        return authService.autenticar(request.codigo(), request.password());
    }

    @GetMapping("/get-integrantes")
    public List<IntegranteDTO> getIntegrantes() {
        return authService.obtenerIntegrantes();
    }
}
