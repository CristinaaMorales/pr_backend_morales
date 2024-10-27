package pe.cibertec.edu.pr_backend_morales.service;

import pe.cibertec.edu.pr_backend_morales.dto.IntegranteDTO;

import java.util.List;

public interface AuthService {
    boolean autenticar(String codigo, String password);
    List<IntegranteDTO> obtenerIntegrantes();
}
