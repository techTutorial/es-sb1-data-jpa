package es.example.sb.jpa.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.json.JSONArray;
import org.json.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ES_PORTFOLIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EsPortfolioEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_PORTFOLIO")
	private int portId;
	
	@Column(name="NAME_PORTFOLIO")
    private String portName;
    
    @OneToMany(mappedBy="portAssetEntity", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<EsFinAssetEntity> assetEntity;
    
    public EsPortfolioEntity(String portName){
    	this.portName = portName;
    }
    
    public EsPortfolioEntity(int portId, String portName){
    	this.portId = portId;
    	this.portName = portName;
    }
    
    public String toString(){
    	String info = "";
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("portName",this.portName);
        
        JSONArray assetArray = new JSONArray();
        if(this.getAssetEntity() != null){
            this.getAssetEntity().forEach(asset->{
                JSONObject subJson = new JSONObject();
                subJson.put("assetName", asset.getAssetName());
                assetArray.put(subJson);
            });
        }
        jsonInfo.put("assets", assetArray);
        
        info = jsonInfo.toString();
        return info;
        // OR
        //return String.format("Portfolio [%d %s]", portId, portName);
    }
    
}
