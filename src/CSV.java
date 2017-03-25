import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class CSV {
	public static String[][] testData;
	
    public static List<String> importCsv(File file){
        List<String> dataList=new ArrayList<String>();
        
        BufferedReader br=null;
        try { 
            br = new BufferedReader(new FileReader(file));
            String line = ""; 
            while ((line = br.readLine()) != null) { 
                dataList.add(line);
            }
        }catch (Exception e) {
        }finally{
            if(br!=null){
                try {
                    br.close();
                    br=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        dataList.remove(0);
        return dataList;
    }
    
    public static void getData(){
    	List<String> dataList=importCsv(new File("D:/inputgit.csv"));
        if(dataList!=null && !dataList.isEmpty()){
        	int size = dataList.size();
        	testData = new String[size][2];
        	
            for(int i = 0; i < size; i++){
            	String data = dataList.get(i);
                String[] qq = data.split(",");
                testData[i] = new String[]{qq[0], qq[2]};
            }
        }
    }
}