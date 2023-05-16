package ca.bc.gov.chefs.etl.forms.ltc.staffing.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AldNopDatagrid {

    public String aldnop_other_fri;
    public String aldnop_other_mon;
    public String aldnop_other_sat;
    public String aldnop_other_sun;
    public String aldnop_other_thu;
    public String aldnop_other_tue;
    public String aldnop_other_wed;
    public String aldnopPositionType;
    public String aldnop_other_total;
    public String aldnop_other_annual;
    
    public String getAldnop_other_fri() {
        return aldnop_other_fri;
    }
    public void setAldnop_other_fri(String aldnop_other_fri) {
        this.aldnop_other_fri = aldnop_other_fri;
    }
    public String getAldnop_other_mon() {
        return aldnop_other_mon;
    }
    public void setAldnop_other_mon(String aldnop_other_mon) {
        this.aldnop_other_mon = aldnop_other_mon;
    }
    public String getAldnop_other_sat() {
        return aldnop_other_sat;
    }
    public void setAldnop_other_sat(String aldnop_other_sat) {
        this.aldnop_other_sat = aldnop_other_sat;
    }
    public String getAldnop_other_sun() {
        return aldnop_other_sun;
    }
    public void setAldnop_other_sun(String aldnop_other_sun) {
        this.aldnop_other_sun = aldnop_other_sun;
    }
    public String getAldnop_other_thu() {
        return aldnop_other_thu;
    }
    public void setAldnop_other_thu(String aldnop_other_thu) {
        this.aldnop_other_thu = aldnop_other_thu;
    }
    public String getAldnop_other_tue() {
        return aldnop_other_tue;
    }
    public void setAldnop_other_tue(String aldnop_other_tue) {
        this.aldnop_other_tue = aldnop_other_tue;
    }
    public String getAldnop_other_wed() {
        return aldnop_other_wed;
    }
    public void setAldnop_other_wed(String aldnop_other_wed) {
        this.aldnop_other_wed = aldnop_other_wed;
    }
    public String getAldnopPositionType() {
        return aldnopPositionType;
    }
    public void setAldnopPositionType(String aldnopPositionType) {
        this.aldnopPositionType = aldnopPositionType;
    }
    public String getAldnop_other_total() {
        return aldnop_other_total;
    }
    public void setAldnop_other_total(String aldnop_other_total) {
        this.aldnop_other_total = aldnop_other_total;
    }
    public String getAldnop_other_annual() {
        return aldnop_other_annual;
    }
    public void setAldnop_other_annual(String aldnop_other_annual) {
        this.aldnop_other_annual = aldnop_other_annual;
    }
}
