package com.pixels.Service;

import java.util.List;

import com.pixels.models.PortfolioDetail;

public interface PortfolioService {
	
	void add(PortfolioDetail portfoliodetail);

	List<PortfolioDetail> getAllPortfolio();
}
