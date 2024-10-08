package br.com.agendamento.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade que representa um usário
 * 
 * @author moriartynho
 *
 */
@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;

	@NotBlank(message = "Nome não pode ser nulo")
	@Size(max = 50, message = "Nome não pode ter mais que 50 caracteres")
	private String nome;

	@Email(message = "Insira um email válido")
	@Size(max = 100, message = "Email não pode ter mais que 100 caracteres")
	private String email;

	@NotBlank(message = "Insira uma senha válida")
	@Size(max = 100, message = "Senha não pode ter mais que 100 caracteres")
	private String senha;

	@ManyToOne
	@JoinColumn(name = "id_status", referencedColumnName = "id_status")
	private Status status;

}
