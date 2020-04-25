package com.postgres.hibernate.secondlevelcache.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postgres.hibernate.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
