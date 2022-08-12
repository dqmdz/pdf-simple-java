/**
 * 
 */
package ar.edu.etec.programacion4.pdfsimplejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.etec.programacion4.pdfsimplejava.model.Licencia;

/**
 * @author daniel
 *
 */
@Repository
public interface LicenciaRepository extends JpaRepository<Licencia, Long> {

	public Licencia findByLegajoId(Long legajoId);

}
