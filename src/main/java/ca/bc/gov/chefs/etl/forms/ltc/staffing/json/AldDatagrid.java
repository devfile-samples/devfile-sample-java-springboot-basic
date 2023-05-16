package ca.bc.gov.chefs.etl.forms.ltc.staffing.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AldDatagrid {

    public String ald_other_fri;
    public String ald_other_mon;
    public String ald_other_sat;
    public String ald_other_sun;
    public String ald_other_thu;
    public String ald_other_tue;
    public String ald_other_wed;
    public String aldPositionType;
    public String ald_other_total;
    public String ald_other_annual;
    
    public String getAld_other_fri() {
        return ald_other_fri;
    }
    public void setAld_other_fri(String ald_other_fri) {
        this.ald_other_fri = ald_other_fri;
    }
    public String getAld_other_mon() {
        return ald_other_mon;
    }
    public void setAld_other_mon(String ald_other_mon) {
        this.ald_other_mon = ald_other_mon;
    }
    public String getAld_other_sat() {
        return ald_other_sat;
    }
    public void setAld_other_sat(String ald_other_sat) {
        this.ald_other_sat = ald_other_sat;
    }
    public String getAld_other_sun() {
        return ald_other_sun;
    }
    public void setAld_other_sun(String ald_other_sun) {
        this.ald_other_sun = ald_other_sun;
    }
    public String getAld_other_thu() {
        return ald_other_thu;
    }
    public void setAld_other_thu(String ald_other_thu) {
        this.ald_other_thu = ald_other_thu;
    }
    public String getAld_other_tue() {
        return ald_other_tue;
    }
    public void setAld_other_tue(String ald_other_tue) {
        this.ald_other_tue = ald_other_tue;
    }
    public String getAld_other_wed() {
        return ald_other_wed;
    }
    public void setAld_other_wed(String ald_other_wed) {
        this.ald_other_wed = ald_other_wed;
    }
    public String getAldPositionType() {
        return aldPositionType;
    }
    public void setAldPositionType(String aldPositionType) {
        this.aldPositionType = aldPositionType;
    }
    public String getAld_other_total() {
        return ald_other_total;
    }
    public void setAld_other_total(String ald_other_total) {
        this.ald_other_total = ald_other_total;
    }
    public String getAld_other_annual() {
        return ald_other_annual;
    }
    public void setAld_other_annual(String ald_other_annual) {
        this.ald_other_annual = ald_other_annual;
    }
    
}
