package br.com.gabriel.hr_worker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabriel.hr_worker.entities.Worker;

public interface WorkerRepositorie extends JpaRepository<Worker, Long>{

}
