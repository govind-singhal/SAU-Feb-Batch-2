import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class validInvalidLicense {
	public static void main(String[] args) {
		try {
			File Data = new File("Data.XML");
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(Data);
			doc.getDocumentElement().normalize();
			
			
			NodeList nList = doc.getElementsByTagName("License");
			
			ArrayList<String> validLicense = new ArrayList<String>();
			ArrayList<String> invalidLicense = new ArrayList<String>();
			
			for(int temp=0;temp<nList.getLength();temp++) {
				Node nNode = nList.item(temp);
				Element eElement = (Element) nNode;
				
				String date = eElement.getAttribute("License_Expiration_Date");
				String LicenseClass = eElement.getAttribute("License_Number");
				
				String[] s1 =  date.split("/");
				int day = Integer.parseInt(s1[0]);
				int month = Integer.parseInt(s1[1]);
				int year = Integer.parseInt(s1[2]);
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
				LocalDateTime now = LocalDateTime.now();  
				String sysdate = dtf.format(now);
				String[] s2 =  sysdate.split("/");
				int sysyear = Integer.parseInt(s2[0]);
				int sysmonth = Integer.parseInt(s2[1]);
				int sysday = Integer.parseInt(s2[2]);
				
				
				
				if(year > sysyear) {
					validLicense.add(LicenseClass);
				}
				else if(year == sysyear) {
					if(month > sysmonth) {
						validLicense.add(LicenseClass);
					}
					else if(month == sysmonth) {
						if(day >= sysday) {
							validLicense.add(LicenseClass);
						}
						else {
							invalidLicense.add(LicenseClass);
						}
					}
					else {
						invalidLicense.add(LicenseClass);
					}
				}
				else {
					invalidLicense.add(LicenseClass);
				}
			    
			}
			System.out.println("List of Valid License: "+validLicense);
			System.out.println("List of Invalid Lisence: "+invalidLicense);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
