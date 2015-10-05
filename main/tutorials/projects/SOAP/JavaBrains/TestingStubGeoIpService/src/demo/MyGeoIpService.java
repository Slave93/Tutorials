package demo;

import net.webservicex.*;

public class MyGeoIpService {
	public static void main(String[] args) {
		String ipAdress = "212.58.246.103";
		GeoIPService ipSrvc = new GeoIPService();
		GeoIPServiceSoap geoIpSrvcSoap = ipSrvc.getGeoIPServiceSoap();
		GeoIP geoIP = geoIpSrvcSoap.getGeoIP(ipAdress);
		System.out.println(geoIP.getCountryName());
		
	}
}
