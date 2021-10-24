package br.com.fatec.sp.tcc.orquestradormatricula.v1.integracao.client;

import br.com.fatec.sp.tcc.orquestradormatricula.v1.integracao.response.OrquestradorBdMatriculasByUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "orquestradorBdClient", url = "${orquestrador.bd.url}")
public interface OrquestradorBdClient {

    @GetMapping(value="/protocoloRematricula/usuario/{nrMatricula}", consumes = MediaType.APPLICATION_JSON_VALUE)
    OrquestradorBdMatriculasByUserResponse getMatriculasByUsuario(@PathVariable(name = "nrMatricula") Long numeroMatricula);

}
