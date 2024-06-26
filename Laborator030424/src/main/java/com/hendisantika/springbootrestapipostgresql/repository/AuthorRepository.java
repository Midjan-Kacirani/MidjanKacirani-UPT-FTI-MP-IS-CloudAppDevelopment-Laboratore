package com.hendisantika.springbootrestapipostgresql.repository;

import com.hendisantika.springbootrestapipostgresql.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
