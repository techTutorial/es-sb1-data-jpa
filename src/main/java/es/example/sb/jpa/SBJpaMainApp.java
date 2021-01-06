package es.example.sb.jpa;

import static java.lang.System.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.example.sb.jpa.entity.EsFinAssetEntity;
import es.example.sb.jpa.entity.EsPortfolioEntity;
import es.example.sb.jpa.service.EsFinAssetService;
import es.example.sb.jpa.service.impl.EsPortfolioServiceImpl;


@SpringBootApplication
public class SBJpaMainApp implements CommandLineRunner {
	
	@Autowired
	EsPortfolioServiceImpl portService;
	
	@Autowired
	EsFinAssetService assetService;

	
    public static void main(String[] args) {
    	SpringApplication.run(SBJpaMainApp.class, args);
    }
 
    
    @Override
    public void run(String... arg0) throws Exception {
    	saveData();
    	showData();
    }
        
    // Shift into repository class using static initialization block > Pending
    private void saveData(){
    	//out.println("\n\n=================== Save DATA =======================");
    	EsFinAssetEntity asset11 = new EsFinAssetEntity("ASSET-11");
        EsFinAssetEntity asset12 = new EsFinAssetEntity("ASSET-12");
        
        EsFinAssetEntity asset21 = new EsFinAssetEntity("ASSET-21");
        EsFinAssetEntity asset22 = new EsFinAssetEntity("ASSET-22");
         
        EsPortfolioEntity port11 = new EsPortfolioEntity("PORT-11");
        EsPortfolioEntity port21 = new EsPortfolioEntity("PORT-21");
        
        // set portfolio for financial asset
        asset11.setPortAssetEntity(port11);
        asset12.setPortAssetEntity(port11);
        
        asset21.setPortAssetEntity(port21);
        asset22.setPortAssetEntity(port21);
        
        // save PORTFOLIO
        portService.save(port11);
        portService.save(port21);
         
        // save financial asset
        assetService.save(asset11);
        assetService.save(asset12);
        
        assetService.save(asset21);
        assetService.save(asset22);
    }
    
    private void showData(){
    	out.println("\n\n=================== PORTFOLIO =======================");
        portService.showData();
        
        out.println("\n\n=================== FinancialAsset =======================");
        assetService.showData();
    }
    
}