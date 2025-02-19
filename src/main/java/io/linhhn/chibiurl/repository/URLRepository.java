package io.linhhn.chibiurl.repository;

import io.linhhn.chibiurl.model.URLModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URLRepository extends JpaRepository<URLModel, String> {
}
