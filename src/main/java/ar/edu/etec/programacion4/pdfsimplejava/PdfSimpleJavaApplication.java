package ar.edu.etec.programacion4.pdfsimplejava;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.etec.programacion4.pdfsimplejava.model.Licencia;
import ar.edu.etec.programacion4.pdfsimplejava.service.LicenciaService;

@SpringBootApplication
public class PdfSimpleJavaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PdfSimpleJavaApplication.class, args);
	}

	@Autowired
	private LicenciaService licenciaService;

	@Override
	public void run(String... args) throws Exception {
		Licencia licencia = new Licencia(1L, "Alberto", "Fernandez",
				OffsetDateTime.of(2022, 8, 12, 0, 0, 0, 0, ZoneOffset.UTC),
				OffsetDateTime.of(2023, 8, 12, 0, 0, 0, 0, ZoneOffset.UTC));
		licenciaService.save(licencia);
		licencia = new Licencia(100L, "Kristina", "Corazon",
				OffsetDateTime.of(2022, 8, 12, 0, 0, 0, 0, ZoneOffset.UTC),
				OffsetDateTime.of(2023, 8, 12, 0, 0, 0, 0, ZoneOffset.UTC));
		licenciaService.save(licencia);

	}

}
