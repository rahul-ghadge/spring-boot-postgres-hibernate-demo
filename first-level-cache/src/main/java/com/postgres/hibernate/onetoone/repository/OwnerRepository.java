package com.postgres.hibernate.onetoone.repository;

import com.postgres.hibernate.models.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<OwnerEntity, Integer> {

}
