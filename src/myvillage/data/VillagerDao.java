/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myvillage.data;

import com.sun.corba.se.impl.util.Utility;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import myvillage.Utility.DataBase;
import myvillage.Utility.Misc;
import myvillage.model.Villager;

/**
 *
 * @author ASUS
 */
public class VillagerDao implements Dao<Villager> {
    
    @Override
    public Optional<Villager> get(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<Villager> getAll(String condition, String table) {
        ArrayList<Villager> list = new ArrayList<>();
        ArrayList<Villager> ref = list;
        ArrayList<Map<String, Object>> fetchedData ;
        
        try {
            fetchedData = DataBase.getAllDataList(condition,table);
            convertMapToObject(fetchedData, ref);
            
        } catch (Exception ex) {
            Logger.getLogger(VillagerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    @Override
    public void save(Villager t) {
        
        try {
            
            String query = "INSERT INTO Villagers "
                    + "VALUES"
                    + "("
                    + "'" + t.getAll().get(0) + "',"
                    + "'" + t.getAll().get(1) + "',"
                    + "'" + t.getAll().get(2) + "',"
                    + "'" + t.getAll().get(3) + "',"
                    + "'" + t.getAll().get(4) + "',"
                    + "'" + t.getAll().get(5) + "',"
                    + "'" + t.getAll().get(6) + "',"
                    + "'" + t.getAll().get(7) + "',"
                    + "'" + t.getAll().get(8) + "',"
                    + "" + t.getAll().get(9) + ","
                    + "'" + t.getAll().get(10) + "',"
                    + "'" + t.getAll().get(11) + "',"
                    + "'" + t.getAll().get(12) + "'"
                    + ")";
            DataBase.runQueryToModifyDataBase(query);
            
        } catch (Exception ex) {
            Logger.getLogger(VillagerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void update(Villager t, String[] params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void delete(Villager t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void convertMapToObject(ArrayList<Map<String, Object>> mList, ArrayList<Villager> list) throws SQLException, SQLException, SQLException, ClassNotFoundException {
        
        Villager temp = null;
        for (int i = 0; i < mList.size(); i++) {
            temp = null;
            System.out.println("vdao.java 94 "+mList.size());
        
            
            temp = new Villager(
                    mList.get(i).get("Name"),
                    mList.get(i).get("ImagePath"),
                    mList.get(i).get("DOB"),
                    mList.get(i).get("Mincome"),
                    mList.get(i).get("Occupation"),
                    mList.get(i).get("EduStat"),
                    mList.get(i).get("Gender"),
                    mList.get(i).get("Bloodgroup"),
                    mList.get(i).get("Email"),
                    mList.get(i).get("Cell"),
                    mList.get(i).get("MaritalStat"),
                    mList.get(i).get("HealthStat"),
                    DataBase.getInnerJointResultBetweenTwoRelatedTable(
                            "Villagers.Email = '"+mList.get(i).get("Email").toString()+"'",
                            "Houses",
                            "Villagers",
                            "HouseId",
                            "Id", 
                            "Number"
                    ).get("Number")
            );
            
            
            list.add(temp);
        }
    }
    
}
