package edu.cpp.cs580.data.provider;
import java.util.List;
import edu.cpp.cs580.data.TruckInfo;

public interface TruckInfoManager {

	public TruckInfo getTruckInfo(Integer truckId);
	public void updateTruckInfo(TruckInfo truck);
	public void deleteTruckInfo(Integer truckId);
	public List<TruckInfo> listAllTrucks();	
}
