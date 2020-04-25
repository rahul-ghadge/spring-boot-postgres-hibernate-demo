package com.postgres.hibernate.eagerlazy.repository;

import com.postgres.hibernate.models.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Integer> {

}
