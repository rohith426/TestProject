/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.File;
import java.io.FileOutputStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.jdom.transform.JDOMResult;
import org.jdom.transform.JDOMSource;

/**
 *
 * @author user
 */
public class XMLNS1 {

    public static void main(String[] args) throws Exception {

        File f = new File("C:\\Test\\20161201080622.xml");
        File f1 = processStyleSheets(f);

        System.out.println("neww file ..." + f1.getName());
    }

    /*
 * Helper function to serialize a XML document.
     */
    private static File processStyleSheets(File _currFile) {
        String OutputDir = null;
        String styleSheetPath = null;
        File currOutFile = null;
        SAXBuilder _xmlBuilder = null;
        org.jdom.Document doc = null;
        try {
//            _configList = ConfigValuesList.getInstance();
//            OutputDir = _configList.getConfigValue("Bunnings_PO_Outfolder");
//            styleSheetPath = _configList.getConfigValue("Bunnings_PO_Stylesheet");
//            System.out.println("Starting transformation for file: " + _currFile.getName() + "...OutputDir=" + OutputDir + "..styleSheetPath=" + styleSheetPath);
            _xmlBuilder = new SAXBuilder();
            _xmlBuilder.setReuseParser(false);
            doc = _xmlBuilder.build(_currFile);
            OutputDir = "C:\\Test\\";
            styleSheetPath = "C:\\Test\\Scania_PO.xsl";
            XMLOutputter _xmlWriter = new XMLOutputter();
            Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(new File((String) styleSheetPath)));
            JDOMSource source = new JDOMSource(doc);
            JDOMResult result = new JDOMResult();
            transformer.transform(source, result);
            try {
                currOutFile = new File(OutputDir + "/" + "Scania_" + _currFile.getName().substring(0, _currFile.getName().lastIndexOf(".")) + ".xml");
                FileOutputStream f = new FileOutputStream(currOutFile);
                _xmlWriter.output(result.getResult(), f);
                System.out.println("currOutFile=" + currOutFile.getAbsolutePath());
                f.close();
                f = null;
                _currFile=null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currOutFile;
    }

}
