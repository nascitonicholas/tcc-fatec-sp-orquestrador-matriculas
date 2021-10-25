package br.com.fatec.sp.tcc.orquestradormatricula.v1.integracao.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrquestradorBdMatriculasByUserResponse {

    @JsonProperty("data")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private List<ProtocolosBdResponse> responseBody;

    @JsonProperty("message")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String  message;

    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String  description;

}
