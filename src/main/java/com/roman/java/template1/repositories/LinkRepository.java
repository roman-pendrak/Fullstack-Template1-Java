package com.roman.java.template1.repositories;

import com.roman.java.template1.entities.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
