package pe.cibertec.edu.pr_backend_morales.dto;

public record IntegranteDTO(String codigo, String nombres, String apellidos) {
    public String nombreCompleto() {
        return nombres + " " + apellidos;
    }
}