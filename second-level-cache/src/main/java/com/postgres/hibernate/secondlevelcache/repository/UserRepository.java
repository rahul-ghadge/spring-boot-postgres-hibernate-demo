package com.postgres.hibernate.secondlevelcache.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postgres.hibernate.entities.secondlevelcache.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
