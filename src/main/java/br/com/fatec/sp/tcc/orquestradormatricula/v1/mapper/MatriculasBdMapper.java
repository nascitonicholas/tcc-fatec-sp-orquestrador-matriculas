package br.com.fatec.sp.tcc.orquestradormatricula.v1.mapper;

import br.com.fatec.sp.tcc.orquestradormatricula.v1.controller.response.ProtocolosMatriculasResponse;
import br.com.fatec.sp.tcc.orquestradormatricula.v1.integracao.response.MateriasResponse;
import br.com.fatec.sp.tcc.orquestradormatricula.v1.integracao.response.ProtocolosBdResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface MatriculasBdMapper {

    @Mappings({
            @Mapping(target = "id", source = "protocoloBd.id"),
            @Mapping(target = "codigoMateria", expression = "java(materia.getCodMateria())"),
            @Mapping(target = "nomeProfessor", expression = "java(materia.getProfessores().get(0).getNome())"),
    })
    ProtocolosMatriculasResponse mapProtocoloBdToListaProtocoloSaida(ProtocolosBdResponse protocoloBd, MateriasResponse materia);

}
