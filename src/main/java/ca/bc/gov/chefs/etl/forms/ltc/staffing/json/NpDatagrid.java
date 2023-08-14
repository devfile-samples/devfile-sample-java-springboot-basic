package ca.bc.gov.chefs.etl.forms.ltc.staffing.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NpDatagrid {

    public String np_other_mon;
    public String np_other_tue;
    public String np_other_wed;
    public String np_other_thu;
    public String np_other_fri;
    public String np_other_sat;
    public String np_other_sun;
    public String npPositionType;
    public String np_other_total;
    public String np_other_annual;

    public String getNp_other_fri() {
        return np_other_fri;
    }
    public void setNp_other_fri(String np_other_fri) {
        this.np_other_fri = np_other_fri;
    }
    public String getNp_other_mon() {
        return np_other_mon;
    }
    public void setNp_other_mon(String np_other_mon) {
        this.np_other_mon = np_other_mon;
    }
    public String getNp_other_sat() {
        return np_other_sat;
    }
    public void setNp_other_sat(String np_other_sat) {
        this.np_other_sat = np_other_sat;
    }
    public String getNp_other_sun() {
        return np_other_sun;
    }
    public void setNp_other_sun(String np_other_sun) {
        this.np_other_sun = np_other_sun;
    }
    public String getNp_other_thu() {
        return np_other_thu;
    }
    public void setNp_other_thu(String np_other_thu) {
        this.np_other_thu = np_other_thu;
    }
    public String getNp_other_tue() {
        return np_other_tue;
    }
    public void setNp_other_tue(String np_other_tue) {
        this.np_other_tue = np_other_tue;
    }
    public String getNp_other_wed() {
        return np_other_wed;
    }
    public void setNp_other_wed(String np_other_wed) {
        this.np_other_wed = np_other_wed;
    }
    public String getNpPositionType() {
        return npPositionType;
    }
    public void setNpPositionType(String npPositionType) {
        this.npPositionType = npPositionType;
    }
    public String getNp_other_total() {
        return np_other_total;
    }
    public void setNp_other_total(String np_other_total) {
        this.np_other_total = np_other_total;
    }
    public String getNp_other_annual() {
        return np_other_annual;
    }
    public void setNp_other_annual(String np_other_annual) {
        this.np_other_annual = np_other_annual;
    }
}
