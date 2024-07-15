package com.pixels.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pixels.models.PortfolioDetail;

public interface PortfolioRepository extends JpaRepository<PortfolioDetail, Integer>{

}
