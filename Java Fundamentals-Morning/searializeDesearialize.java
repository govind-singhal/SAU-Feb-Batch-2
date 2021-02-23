import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class searializeDesearialize {
	public static void main(String[] args) {
		try {
			File stu = new File("student.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(stu);
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName("student");
			
			student studentObject[] = new student[nList.getLength()];
			
			for(int temp=0;temp<nList.getLength();temp++) {
				Node nNode = nList.item(temp);
				Element eElement = (Element) nNode;
				studentObject[temp] = new student();
				
				int roll = Integer.parseInt(eElement.getElementsByTagName("roll").item(0).getTextContent());
				int marks = Integer.parseInt(eElement.getElementsByTagName("marks").item(0).getTextContent());
				String subject = eElement.getElementsByTagName("subject").item(0).getTextContent();
				studentObject[temp].setRollno(roll);
				studentObject[temp].setMarks(marks);
				studentObject[temp].setSubject(subject);
			}
			ArrayList<students> studentsObject = new ArrayList<students>();
			studentsObject.add(new students());
			studentsObject.get(0).setroll(studentObject[0].getRollno());
			studentsObject.get(0).setTotalMarks(studentObject[0].getMarks());
			
			
			for(int i=1;i<studentObject.length;i++) {
				int len = studentsObject.size();
				int m=0,flag=0;
				for(int j=0;j<len;j++) {
					if(studentObject[i].getRollno() == studentsObject.get(j).getroll()) {
						studentsObject.get(j).setTotalMarks(studentObject[i].getMarks());
						flag=1;
					}
					m=j;
				}
				if(flag==0) {
					studentsObject.add(new students());
					studentsObject.get(m+1).setroll(studentObject[i].getRollno());
					studentsObject.get(m+1).setTotalMarks(studentObject[i].getMarks());
				}
			}
			int rank=1;
			 for(int i=0;i<studentsObject.size();i++) {
				 int max=-1,index=0;
				 for(int j=0;j<studentsObject.size();j++) {
					 if(studentsObject.get(j).getRank() == -1) {
						 if(studentsObject.get(j).getTotalMarks() > max ) {
							 max = studentsObject.get(j).getTotalMarks();
							 index = j;
						 }
					 }
				 }
				 studentsObject.get(index).setRank(rank);
				 rank = rank+1;
			 }
			
			writeTxt(studentsObject);
			readTxtWriteCSV();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void writeTxt(ArrayList<students> studentsObject) {//write file into txt formate
		try{
            FileOutputStream writeData = new FileOutputStream("studentdata.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(studentsObject);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
	}
	public static void readTxtWriteCSV() {//Function to read txt file, desearialize it and write back to csv file
		 try{
	            FileInputStream readData = new FileInputStream("studentdata.txt");
	            ObjectInputStream readStream = new ObjectInputStream(readData);

	            @SuppressWarnings("unchecked")
				ArrayList<students> student2 = (ArrayList<students>) readStream.readObject();
	            readStream.close();
	            
	            FileOutputStream writeData = new FileOutputStream("studentdata.csv");
	            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
	            //writeStream.writeObject(student2.toString());
	            writeStream.flush();
	            writeStream.close();
	            
	            System.out.println(student2.toString());
	        }catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	}
}
