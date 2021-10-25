package br.com.fatec.sp.tcc.orquestradormatricula.v1.controller;

import br.com.fatec.sp.tcc.orquestradormatricula.v1.config.AbstractController;
import br.com.fatec.sp.tcc.orquestradormatricula.v1.config.SaidaDefault;
import br.com.fatec.sp.tcc.orquestradormatricula.v1.controller.response.ProtocolosMatriculasResponse;
import br.com.fatec.sp.tcc.orquestradormatricula.v1.facade.MatriculasFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculasController implements AbstractController<SaidaDefault> {

    @Autowired
    private MatriculasFacade matriculasFacade;

    @GetMapping("/semestre-atual/{nrMatricula}")
    public ResponseEntity<?> getMatriculasSemestreAtualByUser (@PathVariable(name = "nrMatricula") final Long numeroMatricula) {
        List<ProtocolosMatriculasResponse> response = matriculasFacade.getMatriculasByUser(numeroMatricula);
        return saidaSimplificada(SaidaDefault.builder().responseBody(response).message("Lista de Matriculas retornado com sucesso").build(), HttpStatus.OK);
    }

}
