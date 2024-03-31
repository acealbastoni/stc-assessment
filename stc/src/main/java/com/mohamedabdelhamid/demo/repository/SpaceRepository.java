package com.mohamedabdelhamid.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohamedabdelhamid.demo.domains.Space;

@Repository
public interface SpaceRepository extends JpaRepository<Space, Long> {
}