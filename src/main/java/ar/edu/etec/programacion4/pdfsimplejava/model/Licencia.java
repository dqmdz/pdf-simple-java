package ar.edu.etec.programacion4.pdfsimplejava.model;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Licencia implements Serializable {

	private static final long serialVersionUID = 5952876573856001490L;
	
	@Id
	private Long legajoId;
	private String nombre;
	private String apellido;
	private OffsetDateTime fechaDesde;
	private OffsetDateTime fechaHasta;
	
}
