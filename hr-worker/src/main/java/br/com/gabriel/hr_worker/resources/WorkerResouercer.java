package br.com.gabriel.hr_worker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.hr_worker.entities.Worker;
import br.com.gabriel.hr_worker.repositories.WorkerRepositorie;


@RestController
@RequestMapping("worker")
public class WorkerResouercer {
	@Autowired
	WorkerRepositorie workerRepositorie;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> lista = workerRepositorie.findAll();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		
		Worker worker = workerRepositorie.findById(id).get();
		return ResponseEntity.ok(worker);
		
	}

}
