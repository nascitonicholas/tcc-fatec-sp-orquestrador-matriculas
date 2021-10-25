package br.com.fatec.sp.tcc.orquestradormatricula.v1.integracao.service;

import br.com.fatec.sp.tcc.orquestradormatricula.v1.integracao.client.OrquestradorBdClient;
import br.com.fatec.sp.tcc.orquestradormatricula.v1.integracao.response.OrquestradorBdMatriculasByUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OrquestradorBdService {

    @Autowired
    private OrquestradorBdClient orquestradorBdClient;

    public OrquestradorBdMatriculasByUserResponse buscaMatriculasByUser(final Long numeroMatricula) {
        try {
            return orquestradorBdClient.getMatriculasByUsuario(numeroMatricula);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Não foi possível buscar as matriculas do usuário no orquestrador-bd");
        }
    }

}
