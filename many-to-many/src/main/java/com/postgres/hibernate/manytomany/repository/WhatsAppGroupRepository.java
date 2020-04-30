package com.postgres.hibernate.manytomany.repository;

import com.postgres.hibernate.models.WhatsAppGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhatsAppGroupRepository extends JpaRepository<WhatsAppGroup, Integer> {

}
