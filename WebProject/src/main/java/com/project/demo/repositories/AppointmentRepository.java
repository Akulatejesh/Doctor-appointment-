package com.project.demo.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.model.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
