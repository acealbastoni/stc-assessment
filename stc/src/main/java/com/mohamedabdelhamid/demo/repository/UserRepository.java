package com.mohamedabdelhamid.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohamedabdelhamid.demo.domains.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}