package es.example.sb.jpa.service.impl;

import static java.lang.System.out;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.example.sb.jpa.entity.EsFinAssetEntity;
import es.example.sb.jpa.repository.EsFinAssetRepository;
import es.example.sb.jpa.service.EsFinAssetService;

@Service
public class EsFinAssetServiceImpl implements EsFinAssetService {
	
	@Autowired
    EsFinAssetRepository assetRepo;
	
	@Override
	public void save(EsFinAssetEntity finAsset){
		assetRepo.save(finAsset);
	}
	
	@Override
	@Transactional
	public void showData(){
		out.println("\n=====================Retrieve Financial Asset from Database:====================");
		List<EsFinAssetEntity> assetList = assetRepo.findAll();
		out.println("\n=====================Print All Financial Asset on console:====================");
        assetList.forEach(out::println);
	}
	
	@Override
	public void deleteAll(){
		assetRepo.deleteAll();
	}
	
}
