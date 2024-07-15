package com.pixels.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixels.Repository.PortfolioRepository;
import com.pixels.Service.PortfolioService;
import com.pixels.models.PortfolioDetail;

@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	private PortfolioRepository repo;
	
	@Override
	public void add(PortfolioDetail portfoliodetail) {
		
		repo.save(portfoliodetail);
	}

	@Override
	public List<PortfolioDetail> getAllPortfolio() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
