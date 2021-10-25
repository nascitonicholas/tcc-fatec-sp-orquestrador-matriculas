package br.com.fatec.sp.tcc.orquestradormatricula.v1.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProtocolosMatriculasResponse {

    private String id;
    private String codigoMateria;
    private String nomeProfessor;

}
