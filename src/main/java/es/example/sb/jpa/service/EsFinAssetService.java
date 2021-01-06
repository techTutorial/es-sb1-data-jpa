package es.example.sb.jpa.service;

import es.example.sb.jpa.entity.EsFinAssetEntity;

public interface EsFinAssetService {

	void save(EsFinAssetEntity asset);

	void showData();

	void deleteAll();

}