package edu.cpp.cs580.data;

//import java.util.Date;

public class TruckInfo {
	private String id;
    private String name;
    private String type;
    private String zipCode;
    private int areaCode;
    private String phoneNumber;
	private String city;
    private String address;
	private double lat;
    private double lon;
    private String imageUrl;
    
    public String getImageUrl(){
    	return imageUrl;
    }
    public void setImageUrl(String imageUrl){
    	this.imageUrl = imageUrl;
    }
    
    public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
    public double getLat() {
		return lat;
	}

	public void setLat(double latitude) {
		this.lat = latitude;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double longitude) {
		this.lon = longitude;
	}


    //private String creationTime = new Date(System.currentTimeMillis()).toString();
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
//	public String getCreationTime() {
//		return creationTime;
//	}
//
//	public void setCreationTime(String creationTime) {
//		this.creationTime = creationTime;
//	}

//	public String[] getStartHour() {
//		return startHour;
//	}
//
//	public void setStartHour(String[] startHour) {
//		this.startHour = startHour;
//	}
//
//	public String[] getEndHour() {
//		return endHour;
//	}
//
//	public void setEndHour(String[] endHour) {
//		this.endHour = endHour;
//	}

//	public boolean[] getAmpmS() {
//		return ampmS;
//	}
//
//	public void setAmpmS(boolean[] ampmS) {
//		this.ampmS = ampmS;
//	}
//
//	public boolean[] getAmpmE() {
//		return ampmE;
//	}
//
//	public void setAmpmE(boolean[] ampmE) {
//		this.ampmE = ampmE;
//	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


//	public double getRating() {
//		return rating;
//	}
//
//	public void setRating(double rating) {
//		this.rating = rating;
//	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
