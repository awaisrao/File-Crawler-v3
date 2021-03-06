/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filecrawler;
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author awais
 */
public class FileCrawler {
    //saves collection of files
   public static void addTree(File file, Collection<File> all) {
        File[] children = file.listFiles();
        if (children != null) {
            for (File child : children) {
                addTree(child, all);
            }
        }else{
            all.add(file);
        }
    }

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Map<String, String> allEntries = new HashMap<String, String>();
        Scanner console = new Scanner(System.in);
        
        Collection<File> all = new ArrayList<File>();
    //build file list
    System.out.println("COLLECTING");
    //put your own path here
    addTree(new File("C:\\Users\\awais\\Documents\\NetBeansProjects\\FileCrawler"), all);
    //result file
    try {
        //result file stream
        FileWriter fstream = null;
        fstream = new FileWriter("result.txt");
        //result file writer
        BufferedWriter out = new BufferedWriter(fstream);

        System.out.println("SAVING STARTED");

        //loop - find size and extension (lowercase)
        Iterator itr = all.iterator();
        while(itr.hasNext()){
            //get file
            File tested = (File) itr.next();
            //get ext
            String name = tested.getName();
            String path = tested.getPath();
            String[] splitted = tested.getName().split("\\.");
            String ext = splitted[splitted.length-1];
            //get size
            long size = tested.length();
            //put into file
            //if(size!=0){
                out.write(name + " " +path);
                allEntries.put(name, path);
                out.newLine();
            //}
        } 
        out.close();
        
        System.out.println("Search keyword: ");
        String search = console.nextLine();
        //iterating over keys only
        for (String key : allEntries.keySet()) {
            
            //if(key.contains(search)){
            Pattern patt = Pattern.compile(".*"+search+".*");
            Matcher m = patt.matcher(key);
            if(m.find())
            System.out.println( key +" : "+ allEntries.get(key));
        //}
            String line = null;
            String[] splitted = key.split("\\.");
            String ext = splitted[splitted.length-1];
            if(ext.equals("txt")){
                
               
                //File fjkg = new File(allEntries.get(key));
                FileReader fileReader = 
                new FileReader(key);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                //if(line.contains(search)){
                    Pattern p1 = Pattern.compile(".*"+search+".*");
                    Matcher m2 = p1.matcher(line);
                    if(m2.find()){
                    System.out.println(key +":"+ allEntries.get(key));
                    break;
                    }
                //}
            }   

            // Always close files.
            bufferedReader.close();             
               
            }
           /* for (Map.Entry<String, String> entry : AllEntries.entrySet()) {
                String key1 = entry.getKey().toString();
                Integer value1 = entry.getValue();
                System.out.println("key, " + key1 + " value " + value1);
            }*/
           // for (String key1 : allEntries.keySet()) {
              //  System.out.println(key1 + " " + allEntries.get(key1));
           // }

     }
       
        

        //close file / save
        
    }catch(IOException ex){}
        
        
    }

    
}
