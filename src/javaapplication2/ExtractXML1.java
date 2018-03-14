/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author user
 */
public class ExtractXML1 {
    private SAXBuilder _xmlBuilder;
    boolean status = false;

    public synchronized void processFile(File f) {
        _xmlBuilder = new SAXBuilder();
        Document doc = null;
        List<Element> list = new ArrayList<Element>();
        StringBuffer scania_order_date = new StringBuffer();
        try {
            _xmlBuilder.setReuseParser(false);
            doc = _xmlBuilder.build(f);
            Element root = doc.getRootElement();
            String docroot = root.getName();
//            System.out.println("docroot==" + docroot);

            String dealerId = root.getChild("serviceArgument").getChild("sppOrder").getAttributeValue("dealerId").trim();
            String customerNo = root.getChild("serviceArgument").getChild("sppOrder").getAttributeValue("customerNo").trim();
            String eMail = root.getChild("serviceArgument").getChild("sppOrder").getAttributeValue("eMail").trim();
            String orderId = root.getChild("serviceArgument").getChild("sppOrder").getAttributeValue("orderId").trim();
            String orderDate = root.getChild("serviceArgument").getChild("sppOrder").getAttributeValue("orderDate").trim();
            scania_order_date.append(orderDate.split("T")[0]);
            scania_order_date.append(" ");
            scania_order_date.append(orderDate.split("T")[1].substring(0, 8));
//            System.out.println("dealerId==" + dealerId + "...customerNo==" + customerNo + "..eMail==" + eMail + "..orderId==" + orderId + "..orderDate==" + orderDate);
            
            String orderSQL = "insert into scania_order(scania_order_id,dealer_id,customer_no,scania_order_date,email,STATUS) values('" + orderId + "'," + dealerId + "," + customerNo + ",'" + scania_order_date + "','" + eMail + "'," + 1 + ")";
            WriteToDB(orderSQL);
            int order_row_id = 0;
            String itemSQL = null;
            int item_inserted = 0;
            String selectSQL = "Select id from scania_order where dealer_id = " + dealerId + " and status = 1 and customer_no = '" + customerNo + "' and scania_ORDER_DATE = '" + scania_order_date + "' and email='"+eMail+"'";
            order_row_id = SelectFromDB(selectSQL);
            if (order_row_id > 0) {
                list = root.getChild("serviceArgument").getChild("sppOrder").getChild("parts").getChildren();
                int itemcount = list.size();
                for (Element lineItem : list) {
                    if (lineItem.getName().equals("part")) {
                        String partNo = lineItem.getAttributeValue("partNo");
                        String quantity = lineItem.getAttributeValue("quantity");
                        String amount = lineItem.getChild("price").getAttributeValue("amount");
                        String desc = "Vijay Thumma";
//                        System.out.println("partNo value=" + partNo + "....quantity==" + quantity + "..amount==" + amount);
                        itemSQL = "insert into SCANIA_ORDER_LINE_ITEMS(Scania_ORDER_ID,PART_NUM,DESCRIPTION,QTY,PRICE) values(" + order_row_id + ",'" + partNo + "','" + desc + "'," + quantity + "," + amount + ")";
                        WriteToDB(itemSQL);
                        item_inserted++;
                    }
                    if (item_inserted == itemcount) {
                        String updateStatusSQL = "";
                        updateStatusSQL = "update scania_order set status = 2 where status = 1 and id = " + order_row_id;
                        WriteToDB(updateStatusSQL);
                        status = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void WriteToDB(String sql) {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/auto", "root", "in");
            Statement stmt = connection.createStatement();
            int result2 = (stmt.executeUpdate(sql));
            if (result2 > 0) {
                stmt.close();
                stmt = null;
            }

        } catch (Exception e1) {

        }
    }
      
     public int SelectFromDB(String sql) {
        Connection connection = null;
        int result = 0;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/auto", "root", "in");
            Statement stmt = connection.createStatement();
            ResultSet rs_new = stmt.executeQuery(sql);
            while (rs_new.next()) {
                result = rs_new.getInt(1);
            }
            stmt.close();
            stmt = null;
        } catch (Exception w) {

        }
        return result;
    }
      
      public static void main(String args[]) throws Exception {
        try {

            ExtractXML1 p = new ExtractXML1();

            File f = new File("C:\\Test\\vijay\\inamspp74581.xml");
            p.processFile(f);

            //System.out.println("Done...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
    
}
