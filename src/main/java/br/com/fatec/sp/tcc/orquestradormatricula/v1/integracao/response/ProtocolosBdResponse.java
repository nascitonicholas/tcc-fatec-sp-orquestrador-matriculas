package br.com.fatec.sp.tcc.orquestradormatricula.v1.integracao.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProtocolosBdResponse {

    @JsonProperty("id_protocolo_rematricula")
    private Long id;
    @JsonProperty("cod_protocolo")
    private String codProtrocolo;
    @JsonProperty("materias")
    private List<MateriasResponse> materias;
    @JsonProperty("aluno")
    private UsuarioResponseSimples aluno;
    @JsonProperty("ano_semestre_rematricula")
    private String anoSemestreRematricula;
    @JsonProperty("dt_criacao")
    private String dataCriacao;
    @JsonProperty("dt_ultima_alteracao")
    private String dataUltimaAlteracao;
}
