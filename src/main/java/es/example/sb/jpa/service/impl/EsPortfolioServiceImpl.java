package es.example.sb.jpa.service.impl;

import static java.lang.System.out;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.example.sb.jpa.entity.EsPortfolioEntity;
import es.example.sb.jpa.repository.EsPortfolioRepository;
import es.example.sb.jpa.service.EsPortfolioService;

@Service
public class EsPortfolioServiceImpl implements EsPortfolioService {
	
	@Autowired
    EsPortfolioRepository portRepo;
	
	@Override
	public void save(EsPortfolioEntity port){
		portRepo.save(port);
	}
	
	@Override
	@Transactional
	public void showData(){
		out.println("\n=====================Retrieve Portfolio from Database:====================");
		List<EsPortfolioEntity> portList = portRepo.findAll();
		out.println("\n=====================Print All Portfolio on console:====================");
		portList.forEach(out::println);;
	}
	
	@Override
	public void deleteAll(){
		portRepo.deleteAll();
	}
	
}
