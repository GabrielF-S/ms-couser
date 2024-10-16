package br.com.gabriel.hr_worker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.hr_worker.entities.Worker;
import br.com.gabriel.hr_worker.repositories.WorkerRepositorie;

@RefreshScope
@RestController
@RequestMapping("workers")
public class WorkerResouercer {

	@Value("${test.config}")
	private String testConfig;

	@Autowired
	private Environment env;

	@Autowired
	private static Logger log = LoggerFactory.getLogger(Worker.class);

	@Autowired
	WorkerRepositorie workerRepositorie;

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> lista = workerRepositorie.findAll();
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		log.info("Port = " + env.getProperty("local.server.port"));
		Worker worker = workerRepositorie.findById(id).get();
		return ResponseEntity.ok(worker);
	}

	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs() {
		log.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();
	}

}
