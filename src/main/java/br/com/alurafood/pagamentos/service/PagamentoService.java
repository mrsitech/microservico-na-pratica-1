package br.com.alurafood.pagamentos.service;

import br.com.alurafood.pagamentos.dto.PagamentoDto;
import br.com.alurafood.pagamentos.model.Pagamento;
import br.com.alurafood.pagamentos.model.Status;
import br.com.alurafood.pagamentos.repository.PagamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


@Service
public class PagamentoService {
	
	@Autowired //Dependency ejection
	private PagamentoRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//Bring all payments and set to DTO class
	 public Page<PagamentoDto> obterTodos(Pageable paginacao) {
	        return repository
	                .findAll(paginacao)
	                .map(p -> modelMapper.map(p, PagamentoDto.class));
	    }
	 
	 //Bring Payment by id
	 public PagamentoDto obterPorId(Long id) {
	        Pagamento pagamento = repository.findById(id)
	                .orElseThrow(() -> new EntityNotFoundException());

	        return modelMapper.map(pagamento, PagamentoDto.class);
	    }
	 
	 //Criate pay. Bring Json
	 public PagamentoDto criarPagamento(PagamentoDto dto) {
	        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
	        pagamento.setStatus(Status.CRIADO);
	        repository.save(pagamento);

	        return modelMapper.map(pagamento, PagamentoDto.class);
	    }
	 	
	//Atualization pay.
	 public PagamentoDto atualizarPagamento(Long id, PagamentoDto dto) {
	        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
	        pagamento.setId(id);
	        pagamento = repository.save(pagamento);
	        return modelMapper.map(pagamento, PagamentoDto.class);
	    }
	  
	  //Delete
	  public void excluirPagamento(Long id) {
		  repository.deleteById(id);
	  }
}
