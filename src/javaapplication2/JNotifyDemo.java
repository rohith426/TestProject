/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author user
 */
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.contentobjects.jnotify.JNotify;
import net.contentobjects.jnotify.JNotifyListener;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Jigar
 */
public class JNotifyDemo {

    public void sample() throws Exception {
        // path to watch
        String path = "C:\\Test\\vijay\\";
        System.out.println("path==="+path);
        System.out.println("path=="+System.getProperty("library.path"));

        // watch mask, specify events you care about,
        // or JNotify.FILE_ANY for all events.
        int mask = JNotify.FILE_CREATED;
//                | JNotify.FILE_DELETED
//                | JNotify.FILE_MODIFIED
//                | JNotify.FILE_RENAMED;

        // watch subtree?
        boolean watchSubtree = true;

        // add actual watch
        int watchID = JNotify.addWatch(path, mask, watchSubtree, new Listener());

        // sleep a little, the application will exit if you
        // don't (watching is asynchronous), depending on your
        // application, this may not be required
        Thread.sleep(Long.MAX_VALUE);

        // to remove watch the watch
        boolean res = JNotify.removeWatch(watchID);
        if (!res) {
            // invalid watch ID specified.
        }
    }

    class Listener implements JNotifyListener {

        public void fileRenamed(int wd, String rootPath, String oldName,
                String newName) {
            print("renamed " + rootPath + " : " + oldName + " -> " + newName);
        }

        public void fileModified(int wd, String rootPath, String name) {
            print("modified " + rootPath + " : " + name);
        }

        public void fileDeleted(int wd, String rootPath, String name) {
            print("deleted " + rootPath + " : " + name);
        }

        public void fileCreated(int wd, String rootPath, String name) {
            print("created " + rootPath + " : " + name);
            File srcFile=new File(rootPath+name);
            File destDir=new File("C:\\Test\\vijay1\\");
            try {
                FileUtils.copyFileToDirectory(srcFile, destDir);
            } catch (IOException ex) {
                Logger.getLogger(JNotifyDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        void print(String msg) {
            System.err.println(msg);
        }
    }
    public static void main(String[] args) throws Exception {
        new JNotifyDemo().sample();
    }
}