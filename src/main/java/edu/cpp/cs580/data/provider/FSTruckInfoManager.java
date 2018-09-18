package edu.cpp.cs580.data.provider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.cpp.cs580.data.TruckInfo;
import edu.cpp.cs580.data.TruckMap;
import edu.cpp.cs580.util.ResourceResolver;
import edu.cpp.cs580.data.provider.TruckInfoManager;


public class FSTruckInfoManager implements TruckInfoManager{
	private static final ObjectMapper JSON = new ObjectMapper();
	/**
	 * https://halexv.blogspot.mx/2015/07/java-geocoding-using-google-maps-api.html
	 * Given an address asks google for geocode
	 * 
	 * If ssl is true API_KEY should be a valid developer key (given by google)
	 *
	 * @param address the address to find
	 * @param ssl defines if ssl should be used
	 * @return the GoogleGeoCode found
	 * @throws Exception in case of any error
	 *="AIzaSyDW9iStuk-FiFCHBu8teQ5H5NlJ0sa-WLA"
	 */
	    
    

	public TruckMap getTruckMap(){
		TruckMap truckMap = null;
		File truckFile = ResourceResolver.getTruckFile();
		if(truckFile.exists()){
			try{
				truckMap = JSON.readValue(truckFile, TruckMap.class);
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			truckMap = new TruckMap();
		}
		return truckMap;
	}
	
	private void persistTruckMap(TruckMap truckMap){
		try{
			JSON.writeValue(ResourceResolver.getTruckFile(), truckMap);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	

	@Override
	public TruckInfo getTruckInfo(Integer truckId){
		TruckMap truckMap = getTruckMap();
		return truckMap.get(truckId);
	}
	@Override
	public void updateTruckInfo(TruckInfo truck){
	    TruckMap truckMap = getTruckMap();
		truckMap.put(truck.getId(), truck);
		persistTruckMap(truckMap);
	}
	@Override
	public void deleteTruckInfo(Integer truckId){
		TruckMap truckMap = getTruckMap();
		truckMap.remove(truckId);
		persistTruckMap(truckMap);
	}
	@Override
	public List<TruckInfo> listAllTrucks(){
		TruckMap truckMap = getTruckMap();
		return new ArrayList<TruckInfo>(truckMap.values());
	}

//	@Override
//	public List<TruckInfo> searchGoogleResult() throws IOException {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}
