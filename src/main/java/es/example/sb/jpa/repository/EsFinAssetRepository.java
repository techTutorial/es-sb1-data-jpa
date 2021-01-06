package es.example.sb.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.example.sb.jpa.entity.EsFinAssetEntity;

@Repository
public interface EsFinAssetRepository extends JpaRepository<EsFinAssetEntity, Integer>{
}
