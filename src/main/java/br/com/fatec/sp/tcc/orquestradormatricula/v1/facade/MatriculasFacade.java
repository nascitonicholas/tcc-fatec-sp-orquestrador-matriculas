package br.com.fatec.sp.tcc.orquestradormatricula.v1.facade;

import br.com.fatec.sp.tcc.orquestradormatricula.v1.controller.response.ProtocolosMatriculasResponse;
import br.com.fatec.sp.tcc.orquestradormatricula.v1.integracao.response.OrquestradorBdMatriculasByUserResponse;
import br.com.fatec.sp.tcc.orquestradormatricula.v1.integracao.response.ProtocolosBdResponse;
import br.com.fatec.sp.tcc.orquestradormatricula.v1.integracao.service.OrquestradorBdService;
import br.com.fatec.sp.tcc.orquestradormatricula.v1.mapper.MatriculasBdMapper;
import br.com.fatec.sp.tcc.orquestradormatricula.v1.utils.DataUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class MatriculasFacade {

    @Autowired
    private OrquestradorBdService orquestradorBdService;

    private MatriculasBdMapper matriculasBdMapper = Mappers.getMapper(MatriculasBdMapper.class);

    public List<ProtocolosMatriculasResponse> getMatriculasByUser(Long numeroMatricula) {
        final OrquestradorBdMatriculasByUserResponse matriculasUser = orquestradorBdService.buscaMatriculasByUser(numeroMatricula);
        final List<ProtocolosBdResponse> protocolosUserSemestreAtual = filtraMatriculasAtualByUser(matriculasUser);
        if (Objects.nonNull(protocolosUserSemestreAtual) && !protocolosUserSemestreAtual.isEmpty()) {
            final List<ProtocolosMatriculasResponse> saida = mapToListaMatriculasResponse(protocolosUserSemestreAtual);
            return saida;
        }
        return new ArrayList<>();
    }

    private List<ProtocolosBdResponse> filtraMatriculasAtualByUser(OrquestradorBdMatriculasByUserResponse matriculasUser) {
        try {
            if (Objects.nonNull(matriculasUser)) {
                if(Objects.nonNull(matriculasUser.getResponseBody()) && !matriculasUser.getResponseBody().isEmpty()) {
                    return matriculasUser.getResponseBody().stream().filter(matricula ->
                            DataUtils.buscaAnoMesDoSemestreAtual().equalsIgnoreCase(matricula.getAnoSemestreRematricula())).collect(Collectors.toList());
                }
            }
            return new ArrayList<>();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "não foi possível filtrar as matriculas do semestre atual");
        }
    }

    private List<ProtocolosMatriculasResponse> mapToListaMatriculasResponse(List<ProtocolosBdResponse> protocolosUserSemestreAtual) {
        try {
            if (Objects.nonNull(protocolosUserSemestreAtual) && !protocolosUserSemestreAtual.isEmpty()) {
                List<ProtocolosMatriculasResponse> saida = new ArrayList<>();
                protocolosUserSemestreAtual.forEach(protocolo -> {
                    protocolo.getMaterias().forEach(protocoloMateria -> {
                        saida.add(matriculasBdMapper.mapProtocoloBdToListaProtocoloSaida(protocolo, protocoloMateria));
                    });
                });
                return saida;
            }
            return new ArrayList<>();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Não foi possível mapear para a saída");
        }
    }

}
