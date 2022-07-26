/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myvillage.model;

import java.sql.SQLException;
import java.util.ArrayList;
import myvillage.Utility.DataBase;

/**
 *
 * @author ASUS
 */
public class Villager {

    private Object name;
    private Object imagePath;
    private Object dob;
    private Object mincome;
    private Object occupation;
    private Object eduStat;
    private Object gender;
    private Object bloodgroup;
    private Object email;
    private Object cell;
    private Object maritalStat;
    private Object healthStat;;
    private Object houseNo;

    public Villager(
            Object name,
            Object imagePath,
            Object dob,
            Object mincome,
            Object occupation,
            Object eduStat,
            Object gender,
            Object bloodgroup,
            Object email, 
            Object cell,
            Object maritalStat,
            Object healthStat,
            Object houseNo
    ) {
        this.name = name;
        this.imagePath = imagePath;
        this.dob = dob;
        this.mincome = mincome;
        this.occupation = occupation;
        this.eduStat = eduStat;
        this.gender = gender;
        this.bloodgroup = bloodgroup;
        this.email = email;
        this.cell = cell;
        this.maritalStat = maritalStat;
        this.healthStat = healthStat;
        this.houseNo = houseNo;
    }

    public ArrayList getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Object> list = new ArrayList<Object>();

        list.add(getName());
        list.add(getImagePath());
        list.add(getEmail());
        list.add(getCell());
        list.add(getDob());
        list.add(getGender());
        list.add(getBloodgroup());
        list.add(getEduStat());
        list.add(getOccupation());
        list.add(getMincome());
        list.add(getMaritalStat());
        list.add(getHealthStat());
        list.add(DataBase.getSingleCellData("No = "+getHouseNo(), "Id", "HouseNo"));
        
        return list;
    }

    public Object getHouseNo() {
        return houseNo;
    }
    

    public Object getEduStat() {
        return eduStat;
    }

    public Object getCell() {
        return cell;
    }

    public Object getImagePath() {
        return imagePath;
    }

    public Object getEmail() {
        return email;
    }

    public Object getGender() {
        return gender;
    }

    public Object getDob() {
        return dob;
    }

    public Object getBloodgroup() {
        return bloodgroup;
    }

    public Object getHealthStat() {
        return healthStat;
    }

    public Object getMaritalStat() {
        return maritalStat;
    }

    public Object getMincome() {
        return mincome;
    }

    public Object getName() {
        return name;
    }

    public Object getOccupation() {
        return occupation;
    }

    public void setBloodgroup(Object bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public void setHouseNo(Object houseNo) {
        this.houseNo = houseNo;
    }
    

    public void setCell(Object cell) {
        this.cell = cell;
    }

    public void setDob(Object dob) {
        this.dob = dob;
    }

    public void setEduStat(Object eduStat) {
        this.eduStat = eduStat;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public void setHealthStat(Object healthStat) {
        this.healthStat = healthStat;
    }

    public void setMaritalStat(Object maritalStat) {
        this.maritalStat = maritalStat;
    }

    public void setMincome(Object mincome) {
        this.mincome = mincome;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public void setOccupation(Object occupation) {
        this.occupation = occupation;
    }

    public void setImagePath(Object imagePath) {
        this.imagePath = imagePath;
    }


}
