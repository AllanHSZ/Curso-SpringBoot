package com.allanhsz.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.allanhsz.cursomc.domain.enums.TipoCliente;
import com.allanhsz.cursomc.dto.ClienteNewDTO;
import com.allanhsz.cursomc.resources.exceptions.FieldMessage;
import com.allanhsz.cursomc.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();
		
		// inclua os testes aqui, inserindo erros na lista
		if (objDto.getTipo().equals(TipoCliente.PESSOA_FISICA.getCod())) {
			if (!BR.isValidCPF(objDto.getCpfOuCnpj()))
					list.add(new FieldMessage("CpfOuCnpj", "CPF inválido"));
		}else if (objDto.getTipo().equals(TipoCliente.PESSOA_JURIDICA.getCod())) {
			if (!BR.isValidCNPJ(objDto.getCpfOuCnpj()))
				list.add(new FieldMessage("CpfOuCnpj", "CNPJ inválido"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}