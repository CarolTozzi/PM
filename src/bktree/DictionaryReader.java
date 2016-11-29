package bktree;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class DictionaryReader {

	public DictionaryReader(){
		
	}
	
	public static ArrayList<String> readDictionary() throws IOException{
		File file = new File("C:/Users/IBM_ADMIN/Desktop/Mine/Trabalho PM/dictionary_pt-br.zip");
		ArrayList<String> lines = new ArrayList<String>();
		
		ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();

        //reads every file that inside the .zip
        while(entries.hasMoreElements()){
            ZipEntry entry = entries.nextElement();
            InputStream stream = zipFile.getInputStream(entry);
            InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
            
           
            BufferedReader br = new BufferedReader(reader);
            
            String line = br.readLine();
            
            while(line != null){
            	lines.add(line);
            	line = br.readLine();
            }
            
           // System.out.println("line[0]: "+lines.get(0)+"\n");
           // System.out.println("line[1]: "+lines.get(1)+"\n");
            //inputStream.close();
            stream.close();
        }
        zipFile.close();
       /* for(String line : lines){
        	System.out.println(line+"\n");
        }*/
		
		
		
		return lines;
	}

	public static void main(String[] args) throws IOException {
		/*File file = new File("/Volumes/StorEDGE/UNIRIO/TCC/workspace/SpellChecker/src/Files/dictionary_pt-br.zip");
		ArrayList<String> lines = new ArrayList<String>();
		
		ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();

        //reads every file that inside the .zip
        while(entries.hasMoreElements()){
            ZipEntry entry = entries.nextElement();
            InputStream stream = zipFile.getInputStream(entry);
            InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
            
           
            BufferedReader br = new BufferedReader(reader);
            
            String line = br.readLine();
            
            while(line != null){
            	lines.add(line);
            	line = br.readLine();
            }
            
            System.out.println("line[0]: "+lines.get(0)+"\n");
            System.out.println("line[1]: "+lines.get(1)+"\n");
            //inputStream.close();
            stream.close();
        }
        zipFile.close();
        for(String line : lines){
        	System.out.println(line+"\n");
        }*/

	}

	public BurkhardKellerTree loadFromFile(String string, IDistanceCalculator calculator) {
		// TODO Auto-generated method stub
		return null;
	}

}
