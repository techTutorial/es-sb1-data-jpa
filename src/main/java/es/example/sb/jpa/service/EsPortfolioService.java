package es.example.sb.jpa.service;

import es.example.sb.jpa.entity.EsPortfolioEntity;

public interface EsPortfolioService {

	void save(EsPortfolioEntity port);

	void showData();

	void deleteAll();

}