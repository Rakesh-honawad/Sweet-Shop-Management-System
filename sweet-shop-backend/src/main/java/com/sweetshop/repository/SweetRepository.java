package com.sweetshop.repository;

import com.sweetshop.model.Sweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SweetRepository extends JpaRepository<Sweet, Long> {
}
