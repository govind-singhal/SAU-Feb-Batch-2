import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class Merge2XML {
	public static void main(String[] args) {
		try {
			File License1 = new File("License1.XML");
			File License2 = new File("License2.XML");
			
			DocumentBuilderFactory dbFactory1 = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder1 = dbFactory1.newDocumentBuilder();
			Document doc1 = dBuilder1.parse(License1);
			doc1.getDocumentElement().normalize();
			
			DocumentBuilderFactory dbFactory2 = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder2 = dbFactory2.newDocumentBuilder();
			Document doc2 = dBuilder2.parse(License2);
			doc2.getDocumentElement().normalize();
			
			
			NodeList nList1 = doc1.getElementsByTagName("CSR_Producer");
			NodeList nList2 = doc2.getElementsByTagName("CSR_Producer");
			
			for(int temp1=0;temp1<nList1.getLength();temp1++) {
				for(int temp2=0;temp2<nList2.getLength();temp2++) {
					Node nNode1 = nList1.item(temp1);
					Node nNode2 = nList2.item(temp2);
					Element eElement1 = (Element) nNode1;
					Element eElement2 = (Element) nNode2;
					if(eElement1.getAttribute("NIPR_Number").equals(eElement2.getAttribute("NIPR_Number"))) {
						NodeList nList3 = eElement1.getElementsByTagName("License");
						NodeList nList4 = eElement2.getElementsByTagName("License");
						for(int temp3=0;temp3<nList3.getLength();temp3++) {
							for(int temp4=0;temp4<nList4.getLength();temp4++) {
								Node nNode3 = nList3.item(temp3);
								Node nNode4 = nList4.item(temp4);
								Element eElement3 = (Element) nNode3;
								Element eElement4 = (Element) nNode4;
								if(eElement3.getAttribute("State_Code").equals(eElement4.getAttribute("State_Code")) && eElement3.getAttribute("License_Number").equals(eElement4.getAttribute("License_Number")) && eElement3.getAttribute("Date_Status_Effective").equals(eElement4.getAttribute("Date_Status_Effective"))){
									NodeList nList5 = eElement4.getElementsByTagName("LOA");
									Document ownerDocument = nNode3.getOwnerDocument();
									for(int temp5=0;temp5<nList5.getLength();temp5++) {
										Node nNode5 = nList5.item(temp5);
										Node firstDocImportedNode = ownerDocument.importNode(nNode5, true);
										nNode3.appendChild(firstDocImportedNode);
										
									}
								}
							}
						}
						
					}
				}
			}
			Transformer tf = TransformerFactory.newInstance().newTransformer();
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			tf.setOutputProperty(OutputKeys.METHOD, "xml");
			tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

			DOMSource domSource = new DOMSource(doc1);
			StreamResult sr = new StreamResult(new File("Data.xml"));
			tf.transform(domSource, sr);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
