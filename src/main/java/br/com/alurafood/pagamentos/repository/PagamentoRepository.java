package br.com.alurafood.pagamentos.repository;

import br.com.alurafood.pagamentos.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository CRUD automatico
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
	//DTO Patter (Data Transfer Object): será criado um package para não devolvet tudo sem necessidade.

}
