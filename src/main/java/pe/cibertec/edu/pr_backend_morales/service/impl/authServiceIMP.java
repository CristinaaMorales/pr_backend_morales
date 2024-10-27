package pe.cibertec.edu.pr_backend_morales.service.impl;

import org.springframework.stereotype.Service;
import pe.cibertec.edu.pr_backend_morales.dto.IntegranteDTO;
import pe.cibertec.edu.pr_backend_morales.service.AuthService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class authServiceIMP implements AuthService {
    private static final String FILE_PATH = "src/main/resources/integrantes.txt";

    @Override
    public boolean autenticar(String codigo, String password) {
        try {
            return Files.lines(Paths.get(FILE_PATH))
                    .anyMatch(line -> {
                        String[] parts = line.split(";");
                        return parts[0].equals(codigo) && parts[1].equals(password);
                    });
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<IntegranteDTO> obtenerIntegrantes() {
        try {
            return Files.lines(Paths.get(FILE_PATH))
                    .map(line -> line.split(";"))
                    .filter(parts -> parts.length == 4)  // Validar que haya 4 partes
                    .map(parts -> new IntegranteDTO(parts[0], parts[2], parts[3]))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
