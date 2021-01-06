package es.example.sb.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.json.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ES_FINASSET")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class EsFinAssetEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_FINASSET")
	private int assetId;
    
	@Column(name = "NAME_FINASSET")
	private String assetName;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PORTFOLIO_FINASSET")
    private EsPortfolioEntity portAssetEntity;
    
    public EsFinAssetEntity() {}
    
    public EsFinAssetEntity(String assetName){
    	this.assetName = assetName;
    }
    
    // replacement of below getter-setter with lombok > StackOverflowError > Pending
    public String getAssetName() {
        return assetName;
    }
    
    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }
    
    public void setPortAssetEntity(EsPortfolioEntity esPortfolioEntity){
    	this.portAssetEntity = esPortfolioEntity;
    }
    
    public EsPortfolioEntity getPortAssetEntity(){
    	return this.portAssetEntity;
    }
    
    // optional: customize it like proper JSON > Pending;
    public String toString(){
    	String info = "";	
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("assetName",this.assetName);

        if(this.getPortAssetEntity() != null){
        	JSONObject portJsonObj = new JSONObject();
            portJsonObj.put("portName", this.getPortAssetEntity().getPortName());
            jsonInfo.put("portfolio", portJsonObj);
            info = jsonInfo.toString();
        }
        return info;
    }
    
}
