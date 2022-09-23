package br.com.alurafood.pagamentos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


//associa a classe ao DB
//Pelo Entity procurar a table pagamentos
//getters automatico sem codigo
//getters automatico sem codigo
//Setters automatico sem codigo

@Entity
@Table(name = "pagamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {
	
	@Id //id unico na tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Como os ids serão criados
	private Long id;
	
	 @NotNull
	 @Positive
	 private BigDecimal valor;

	    @NotBlank
	    @Size(max=100)
	    private String nome;

	    @NotBlank
	    @Size(max=19)
	    private String numero;

	    @NotBlank
	    @Size(max=7)
	    private String expiracao;

	    @NotBlank
	    @Size(min=3, max=3)
	    private String codigo;

	    @NotNull
	    @Enumerated(EnumType.STRING)
	    private Status status;

	    @NotNull
	    private Long pedidoId;

	    @NotNull
	    private Long formaDePagamentoId;

	

}
