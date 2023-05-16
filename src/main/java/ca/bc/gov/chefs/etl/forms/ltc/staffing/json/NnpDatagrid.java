package ca.bc.gov.chefs.etl.forms.ltc.staffing.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NnpDatagrid {
    
    public String nnp_other_fri;
    public String nnp_other_mon;
    public String nnp_other_sat;
    public String nnp_other_sun;
    public String nnp_other_thu;
    public String nnp_other_tue;
    public String nnp_other_wed;
    public String nnpPositionType;
    public String nnp_other_total;
    public String nnp_other_annual;

    public String getNnp_other_fri() {
        return nnp_other_fri;
    }
    public void setNnp_other_fri(String nnp_other_fri) {
        this.nnp_other_fri = nnp_other_fri;
    }
    public String getNnp_other_mon() {
        return nnp_other_mon;
    }
    public void setNnp_other_mon(String nnp_other_mon) {
        this.nnp_other_mon = nnp_other_mon;
    }
    public String getNnp_other_sat() {
        return nnp_other_sat;
    }
    public void setNnp_other_sat(String nnp_other_sat) {
        this.nnp_other_sat = nnp_other_sat;
    }
    public String getNnp_other_sun() {
        return nnp_other_sun;
    }
    public void setNnp_other_sun(String nnp_other_sun) {
        this.nnp_other_sun = nnp_other_sun;
    }
    public String getNnp_other_thu() {
        return nnp_other_thu;
    }
    public void setNnp_other_thu(String nnp_other_thu) {
        this.nnp_other_thu = nnp_other_thu;
    }
    public String getNnp_other_tue() {
        return nnp_other_tue;
    }
    public void setNnp_other_tue(String nnp_other_tue) {
        this.nnp_other_tue = nnp_other_tue;
    }
    public String getNnp_other_wed() {
        return nnp_other_wed;
    }
    public void setNnp_other_wed(String nnp_other_wed) {
        this.nnp_other_wed = nnp_other_wed;
    }
    public String getNnpPositionType() {
        return nnpPositionType;
    }
    public void setNnpPositionType(String nnpPositionType) {
        this.nnpPositionType = nnpPositionType;
    }
    public String getNnp_other_total() {
        return nnp_other_total;
    }
    public void setNnp_other_total(String nnp_other_total) {
        this.nnp_other_total = nnp_other_total;
    }
    public String getNnp_other_annual() {
        return nnp_other_annual;
    }
    public void setNnp_other_annual(String nnp_other_annual) {
        this.nnp_other_annual = nnp_other_annual;
    }
}
