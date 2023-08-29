package ca.bc.gov.chefs.etl.forms.ltc.staffing.json;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import ca.bc.gov.chefs.etl.core.json.Form;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    public Form form;
    public String admin;
    @JsonProperty("DCH_q1-1")
    public String DCH_q11;
    @JsonProperty("DCH_q2-1")
    public String DCH_q21;
    @JsonProperty("DCH_q3-1")
    public String DCH_q31;
    @JsonProperty("DCH_q4-1")
    public String DCH_q41;
    @JsonProperty("DCH_q1-2")
    public String DCH_q12;
    @JsonProperty("DCH_q2-2")
    public String DCH_q22;
    @JsonProperty("DCH_q3-2")
    public String DCH_q32;
    @JsonProperty("DCH_q4-2")
    public String DCH_q42;
    @JsonProperty("DCH_q1-3")
    public String DCH_q13;
    @JsonProperty("DCH_q2-3")
    public String DCH_q23;
    @JsonProperty("DCH_q3-3")
    public String DCH_q33;
    @JsonProperty("DCH_q4-3")
    public String DCH_q43;
    @JsonProperty("DCH_q1-4")
    public String DCH_q14;
    @JsonProperty("DCH_q2-4")
    public String DCH_q24;
    @JsonProperty("DCH_q3-4")
    public String DCH_q34;
    @JsonProperty("DCH_q4-4")
    public String DCH_q44;
    @JsonProperty("DCH_q1-5")
    public String DCH_q15;
    @JsonProperty("DCH_q2-5")
    public String DCH_q25;
    @JsonProperty("DCH_q3-5")
    public String DCH_q35;
    @JsonProperty("DCH_q4-5")
    public String DCH_q45;
    public String ccimsid;
    public String fiscalYear;
    public String lateEntry;
    public String np_label1;
    public String np_label2;
    public String np_label3;
    public String np_label4;
    public String np_label5;
    public String DCH_total1;
    public String DCH_total2;
    public String DCH_total3;
    public String DCH_total4;
    public String DCH_total5;
    public String fri_total1;
    public String fri_total2;
    public String fri_total3;
    public String fri_total4;
    public String fri_total5;
    public String minimumRN1;
    public String minimumRN2;
    public String minimumRN3;
    public String minimumRN4;
    public String minimumRN5;
    public String mon_total1;
    public String mon_total2;
    public String mon_total3;
    public String mon_total4;
    public String mon_total5;
    public String nnp_label1;
    public String nnp_label2;
    public String nnp_label3;
    public String nnp_label4;
    public String nnp_label5;
    public String other_mon1;
    public String other_mon2;
    public String other_mon3;
    public String other_mon4;
    public String other_mon5;
    public String sat_total1;
    public String sat_total2;
    public String sat_total3;
    public String sat_total4;
    public String sat_total5;
    public String sun_total1;
    public String sun_total2;
    public String sun_total3;
    public String sun_total4;
    public String sun_total5;
    public String thu_total1;
    public String thu_total2;
    public String thu_total3;
    public String thu_total4;
    public String thu_total5;
    public String tue_total1;
    public String tue_total2;
    public String tue_total3;
    public String tue_total4;
    public String tue_total5;
    public String wed_total1;
    public String wed_total2;
    public String wed_total3;
    public String wed_total4;
    public String wed_total5;
    public String HPRD_total1;
    public String HPRD_total2;
    public String HPRD_total3;
    public String HPRD_total4;
    public String HPRD_total5;
    public String ald_dt_fri1;
    public String ald_dt_fri2;
    public String ald_dt_fri3;
    public String ald_dt_fri4;
    public String ald_dt_fri5;
    public String ald_dt_mon1;
    public String ald_dt_mon2;
    public String ald_dt_mon3;
    public String ald_dt_mon4;
    public String ald_dt_mon5;
    public String ald_dt_sat1;
    public String ald_dt_sat2;
    public String ald_dt_sat3;
    public String ald_dt_sat4;
    public String ald_dt_sat5;
    public String ald_dt_sun1;
    public String ald_dt_sun2;
    public String ald_dt_sun3;
    public String ald_dt_sun4;
    public String ald_dt_sun5;
    public String ald_dt_thu1;
    public String ald_dt_thu2;
    public String ald_dt_thu3;
    public String ald_dt_thu4;
    public String ald_dt_thu5;
    public String ald_dt_tue1;
    public String ald_dt_tue2;
    public String ald_dt_tue3;
    public String ald_dt_tue4;
    public String ald_dt_tue5;
    public String ald_dt_wed1;
    public String ald_dt_wed2;
    public String ald_dt_wed3;
    public String ald_dt_wed4;
    public String ald_dt_wed5;
    public String ald_ot_fri1;
    public String ald_ot_fri2;
    public String ald_ot_fri3;
    public String ald_ot_fri4;
    public String ald_ot_fri5;
    public String ald_ot_mon1;
    public String ald_ot_mon2;
    public String ald_ot_mon3;
    public String ald_ot_mon4;
    public String ald_ot_mon5;
    public String ald_ot_sat1;
    public String ald_ot_sat2;
    public String ald_ot_sat3;
    public String ald_ot_sat4;
    public String ald_ot_sat5;
    public String ald_ot_sun1;
    public String ald_ot_sun2;
    public String ald_ot_sun3;
    public String ald_ot_sun4;
    public String ald_ot_sun5;
    public String ald_ot_thu1;
    public String ald_ot_thu2;
    public String ald_ot_thu3;
    public String ald_ot_thu4;
    public String ald_ot_thu5;
    public String ald_ot_tue1;
    public String ald_ot_tue2;
    public String ald_ot_tue3;
    public String ald_ot_tue4;
    public String ald_ot_tue5;
    public String ald_ot_wed1;
    public String ald_ot_wed2;
    public String ald_ot_wed3;
    public String ald_ot_wed4;
    public String ald_ot_wed5;
    public String ald_pt_fri1;
    public String ald_pt_fri2;
    public String ald_pt_fri3;
    public String ald_pt_fri4;
    public String ald_pt_fri5;
    public String ald_pt_mon1;
    public String ald_pt_mon2;
    public String ald_pt_mon3;
    public String ald_pt_mon4;
    public String ald_pt_mon5;
    public String ald_pt_sat1;
    public String ald_pt_sat2;
    public String ald_pt_sat3;
    public String ald_pt_sat4;
    public String ald_pt_sat5;
    public String ald_pt_sun1;
    public String ald_pt_sun2;
    public String ald_pt_sun3;
    public String ald_pt_sun4;
    public String ald_pt_sun5;
    public String ald_pt_thu1;
    public String ald_pt_thu2;
    public String ald_pt_thu3;
    public String ald_pt_thu4;
    public String ald_pt_thu5;
    public String ald_pt_tue1;
    public String ald_pt_tue2;
    public String ald_pt_tue3;
    public String ald_pt_tue4;
    public String ald_pt_tue5;
    public String ald_pt_wed1;
    public String ald_pt_wed2;
    public String ald_pt_wed3;
    public String ald_pt_wed4;
    public String ald_pt_wed5;
    public String ald_rt_fri1;
    public String ald_rt_fri2;
    public String ald_rt_fri3;
    public String ald_rt_fri4;
    public String ald_rt_fri5;
    public String ald_rt_mon1;
    public String ald_rt_mon2;
    public String ald_rt_mon3;
    public String ald_rt_mon4;
    public String ald_rt_mon5;
    public String ald_rt_sat1;
    public String ald_rt_sat2;
    public String ald_rt_sat3;
    public String ald_rt_sat4;
    public String ald_rt_sat5;
    public String ald_rt_sun1;
    public String ald_rt_sun2;
    public String ald_rt_sun3;
    public String ald_rt_sun4;
    public String ald_rt_sun5;
    public String ald_rt_thu1;
    public String ald_rt_thu2;
    public String ald_rt_thu3;
    public String ald_rt_thu4;
    public String ald_rt_thu5;
    public String ald_rt_tue1;
    public String ald_rt_tue2;
    public String ald_rt_tue3;
    public String ald_rt_tue4;
    public String ald_rt_tue5;
    public String ald_rt_wed1;
    public String ald_rt_wed2;
    public String ald_rt_wed3;
    public String ald_rt_wed4;
    public String ald_rt_wed5;
    public String ald_sp_fri1;
    public String ald_sp_fri2;
    public String ald_sp_fri3;
    public String ald_sp_fri4;
    public String ald_sp_fri5;
    public String ald_sp_mon1;
    public String ald_sp_mon2;
    public String ald_sp_mon3;
    public String ald_sp_mon4;
    public String ald_sp_mon5;
    public String ald_sp_sat1;
    public String ald_sp_sat2;
    public String ald_sp_sat3;
    public String ald_sp_sat4;
    public String ald_sp_sat5;
    public String ald_sp_sun1;
    public String ald_sp_sun2;
    public String ald_sp_sun3;
    public String ald_sp_sun4;
    public String ald_sp_sun5;
    public String ald_sp_thu1;
    public String ald_sp_thu2;
    public String ald_sp_thu3;
    public String ald_sp_thu4;
    public String ald_sp_thu5;
    public String ald_sp_tue1;
    public String ald_sp_tue2;
    public String ald_sp_tue3;
    public String ald_sp_tue4;
    public String ald_sp_tue5;
    public String ald_sp_wed1;
    public String ald_sp_wed2;
    public String ald_sp_wed3;
    public String ald_sp_wed4;
    public String ald_sp_wed5;
    public String ald_sw_fri1;
    public String ald_sw_fri2;
    public String ald_sw_fri3;
    public String ald_sw_fri4;
    public String ald_sw_fri5;
    public String ald_sw_mon1;
    public String ald_sw_mon2;
    public String ald_sw_mon3;
    public String ald_sw_mon4;
    public String ald_sw_mon5;
    public String ald_sw_sat1;
    public String ald_sw_sat2;
    public String ald_sw_sat3;
    public String ald_sw_sat4;
    public String ald_sw_sat5;
    public String ald_sw_sun1;
    public String ald_sw_sun2;
    public String ald_sw_sun3;
    public String ald_sw_sun4;
    public String ald_sw_sun5;
    public String ald_sw_thu1;
    public String ald_sw_thu2;
    public String ald_sw_thu3;
    public String ald_sw_thu4;
    public String ald_sw_thu5;
    public String ald_sw_tue1;
    public String ald_sw_tue2;
    public String ald_sw_tue3;
    public String ald_sw_tue4;
    public String ald_sw_tue5;
    public String ald_sw_wed1;
    public String ald_sw_wed2;
    public String ald_sw_wed3;
    public String ald_sw_wed4;
    public String ald_sw_wed5;
    public String rn_day_fri1;
    public String rn_day_fri2;
    public String rn_day_fri3;
    public String rn_day_fri4;
    public String rn_day_fri5;
    public String rn_day_mon1;
    public String rn_day_mon2;
    public String rn_day_mon3;
    public String rn_day_mon4;
    public String rn_day_mon5;
    public String rn_day_sat1;
    public String rn_day_sat2;
    public String rn_day_sat3;
    public String rn_day_sat4;
    public String rn_day_sat5;
    public String rn_day_sun1;
    public String rn_day_sun2;
    public String rn_day_sun3;
    public String rn_day_sun4;
    public String rn_day_sun5;
    public String rn_day_thu1;
    public String rn_day_thu2;
    public String rn_day_thu3;
    public String rn_day_thu4;
    public String rn_day_thu5;
    public String rn_day_tue1;
    public String rn_day_tue2;
    public String rn_day_tue3;
    public String rn_day_tue4;
    public String rn_day_tue5;
    public String rn_day_wed1;
    public String rn_day_wed2;
    public String rn_day_wed3;
    public String rn_day_wed4;
    public String rn_day_wed5;
    public String rn_eve_fri1;
    public String rn_eve_fri2;
    public String rn_eve_fri3;
    public String rn_eve_fri4;
    public String rn_eve_fri5;
    public String rn_eve_mon1;
    public String rn_eve_mon2;
    public String rn_eve_mon3;
    public String rn_eve_mon4;
    public String rn_eve_mon5;
    public String rn_eve_sat1;
    public String rn_eve_sat2;
    public String rn_eve_sat3;
    public String rn_eve_sat4;
    public String rn_eve_sat5;
    public String rn_eve_sun1;
    public String rn_eve_sun2;
    public String rn_eve_sun3;
    public String rn_eve_sun4;
    public String rn_eve_sun5;
    public String rn_eve_thu1;
    public String rn_eve_thu2;
    public String rn_eve_thu3;
    public String rn_eve_thu4;
    public String rn_eve_thu5;
    public String rn_eve_tue1;
    public String rn_eve_tue2;
    public String rn_eve_tue3;
    public String rn_eve_tue4;
    public String rn_eve_tue5;
    public String rn_eve_wed1;
    public String rn_eve_wed2;
    public String rn_eve_wed3;
    public String rn_eve_wed4;
    public String rn_eve_wed5;
    public String week_total1;
    public String week_total2;
    public String week_total3;
    public String week_total4;
    public String week_total5;
    public String facilityName;
    public String hca_day_fri1;
    public String hca_day_fri2;
    public String hca_day_fri3;
    public String hca_day_fri4;
    public String hca_day_fri5;
    public String hca_day_mon1;
    public String hca_day_mon2;
    public String hca_day_mon3;
    public String hca_day_mon4;
    public String hca_day_mon5;
    public String hca_day_sat1;
    public String hca_day_sat2;
    public String hca_day_sat3;
    public String hca_day_sat4;
    public String hca_day_sat5;
    public String hca_day_sun1;
    public String hca_day_sun2;
    public String hca_day_sun3;
    public String hca_day_sun4;
    public String hca_day_sun5;
    public String hca_day_thu1;
    public String hca_day_thu2;
    public String hca_day_thu3;
    public String hca_day_thu4;
    public String hca_day_thu5;
    public String hca_day_tue1;
    public String hca_day_tue2;
    public String hca_day_tue3;
    public String hca_day_tue4;
    public String hca_day_tue5;
    public String hca_day_wed1;
    public String hca_day_wed2;
    public String hca_day_wed3;
    public String hca_day_wed4;
    public String hca_day_wed5;
    public String hca_eve_fri1;
    public String hca_eve_fri2;
    public String hca_eve_fri3;
    public String hca_eve_fri4;
    public String hca_eve_fri5;
    public String hca_eve_mon1;
    public String hca_eve_mon2;
    public String hca_eve_mon3;
    public String hca_eve_mon4;
    public String hca_eve_mon5;
    public String hca_eve_sat1;
    public String hca_eve_sat2;
    public String hca_eve_sat3;
    public String hca_eve_sat4;
    public String hca_eve_sat5;
    public String hca_eve_sun1;
    public String hca_eve_sun2;
    public String hca_eve_sun3;
    public String hca_eve_sun4;
    public String hca_eve_sun5;
    public String hca_eve_thu1;
    public String hca_eve_thu2;
    public String hca_eve_thu3;
    public String hca_eve_thu4;
    public String hca_eve_thu5;
    public String hca_eve_tue1;
    public String hca_eve_tue2;
    public String hca_eve_tue3;
    public String hca_eve_tue4;
    public String hca_eve_tue5;
    public String hca_eve_wed1;
    public String hca_eve_wed2;
    public String hca_eve_wed3;
    public String hca_eve_wed4;
    public String hca_eve_wed5;
    public String lpn_day_fri1;
    public String lpn_day_fri2;
    public String lpn_day_fri3;
    public String lpn_day_fri4;
    public String lpn_day_fri5;
    public String lpn_day_mon1;
    public String lpn_day_mon2;
    public String lpn_day_mon3;
    public String lpn_day_mon4;
    public String lpn_day_mon5;
    public String lpn_day_sat1;
    public String lpn_day_sat2;
    public String lpn_day_sat3;
    public String lpn_day_sat4;
    public String lpn_day_sat5;
    public String lpn_day_sun1;
    public String lpn_day_sun2;
    public String lpn_day_sun3;
    public String lpn_day_sun4;
    public String lpn_day_sun5;
    public String lpn_day_thu1;
    public String lpn_day_thu2;
    public String lpn_day_thu3;
    public String lpn_day_thu4;
    public String lpn_day_thu5;
    public String lpn_day_tue1;
    public String lpn_day_tue2;
    public String lpn_day_tue3;
    public String lpn_day_tue4;
    public String lpn_day_tue5;
    public String lpn_day_wed1;
    public String lpn_day_wed2;
    public String lpn_day_wed3;
    public String lpn_day_wed4;
    public String lpn_day_wed5;
    public String lpn_eve_fri1;
    public String lpn_eve_fri2;
    public String lpn_eve_fri3;
    public String lpn_eve_fri4;
    public String lpn_eve_fri5;
    public String lpn_eve_mon1;
    public String lpn_eve_mon2;
    public String lpn_eve_mon3;
    public String lpn_eve_mon4;
    public String lpn_eve_mon5;
    public String lpn_eve_sat1;
    public String lpn_eve_sat2;
    public String lpn_eve_sat3;
    public String lpn_eve_sat4;
    public String lpn_eve_sat5;
    public String lpn_eve_sun1;
    public String lpn_eve_sun2;
    public String lpn_eve_sun3;
    public String lpn_eve_sun4;
    public String lpn_eve_sun5;
    public String lpn_eve_thu1;
    public String lpn_eve_thu2;
    public String lpn_eve_thu3;
    public String lpn_eve_thu4;
    public String lpn_eve_thu5;
    public String lpn_eve_tue1;
    public String lpn_eve_tue2;
    public String lpn_eve_tue3;
    public String lpn_eve_tue4;
    public String lpn_eve_tue5;
    public String lpn_eve_wed1;
    public String lpn_eve_wed2;
    public String lpn_eve_wed3;
    public String lpn_eve_wed4;
    public String lpn_eve_wed5;
    public String total_label1;
    public String total_label2;
    public String total_label3;
    public String total_label4;
    public String total_label5;
    public String ald_dt_label1;
    public String ald_dt_label2;
    public String ald_dt_label3;
    public String ald_dt_label4;
    public String ald_dt_label5;
    public String ald_dt_total1;
    public String ald_dt_total2;
    public String ald_dt_total3;
    public String ald_dt_total4;
    public String ald_dt_total5;
    public String ald_ot_label1;
    public String ald_ot_label2;
    public String ald_ot_label3;
    public String ald_ot_label4;
    public String ald_ot_label5;
    public String ald_ot_total1;
    public String ald_ot_total2;
    public String ald_ot_total3;
    public String ald_ot_total4;
    public String ald_ot_total5;
    public String ald_pt_label1;
    public String ald_pt_label2;
    public String ald_pt_label3;
    public String ald_pt_label4;
    public String ald_pt_label5;
    public String ald_pt_total1;
    public String ald_pt_total2;
    public String ald_pt_total3;
    public String ald_pt_total4;
    public String ald_pt_total5;
    public String ald_rt_label1;
    public String ald_rt_label2;
    public String ald_rt_label3;
    public String ald_rt_label4;
    public String ald_rt_label5;
    public String ald_rt_total1;
    public String ald_rt_total2;
    public String ald_rt_total3;
    public String ald_rt_total4;
    public String ald_rt_total5;
    public String ald_sp_label1;
    public String ald_sp_label2;
    public String ald_sp_label3;
    public String ald_sp_label4;
    public String ald_sp_label5;
    public String ald_sp_total1;
    public String ald_sp_total2;
    public String ald_sp_total3;
    public String ald_sp_total4;
    public String ald_sp_total5;
    public String ald_sw_label1;
    public String ald_sw_label2;
    public String ald_sw_label3;
    public String ald_sw_label4;
    public String ald_sw_label5;
    public String ald_sw_total1;
    public String ald_sw_total2;
    public String ald_sw_total3;
    public String ald_sw_total4;
    public String ald_sw_total5;
    public String allied_label1;
    public String allied_label2;
    public String allied_label3;
    public String allied_label4;
    public String allied_label5;
    public String annual_total1;
    public String annual_total2;
    public String annual_total3;
    public String annual_total4;
    public String annual_total5;
    public String hprdTotalTue1;
    public String hprdTotalTue2;
    public String hprdTotalTue3;
    public String hprdTotalTue4;
    public String hprdTotalTue5;
    public String nnp_other_mon;
    public String np_fri_total1;
    public String np_fri_total2;
    public String np_fri_total3;
    public String np_fri_total4;
    public String np_fri_total5;
    public String np_mon_total1;
    public String np_mon_total2;
    public String np_mon_total3;
    public String np_mon_total4;
    public String np_mon_total5;
    public String np_sat_total1;
    public String np_sat_total2;
    public String np_sat_total3;
    public String np_sat_total4;
    public String np_sat_total5;
    public String np_sun_total1;
    public String np_sun_total2;
    public String np_sun_total3;
    public String np_sun_total4;
    public String np_sun_total5;
    public String np_thu_total1;
    public String np_thu_total2;
    public String np_thu_total3;
    public String np_thu_total4;
    public String np_thu_total5;
    public String np_tue_total1;
    public String np_tue_total2;
    public String np_tue_total3;
    public String np_tue_total4;
    public String np_tue_total5;
    public String np_wed_total1;
    public String np_wed_total2;
    public String np_wed_total3;
    public String np_wed_total4;
    public String np_wed_total5;
    public String revisionDate1;
    public String revisionDate2;
    public String revisionDate3;
    public String revisionDate4;
    public String revisionDate5;
    public String rn_day_label;
    public String rn_day_label1;
    public String rn_day_label2;
    public String rn_day_label3;
    public String rn_day_label4;
    public String rn_day_label5;
    public String rn_day_total1;
    public String rn_day_total2;
    public String rn_day_total3;
    public String rn_day_total4;
    public String rn_day_total5;
    public String rn_eve_label;
    public String rn_eve_label1;
    public String rn_eve_label2;
    public String rn_eve_label3;
    public String rn_eve_label4;
    public String rn_eve_label5;
    public String rn_eve_total1;
    public String rn_eve_total2;
    public String rn_eve_total3;
    public String rn_eve_total4;
    public String rn_eve_total5;
    public String rn_fri_total1;
    public String rn_fri_total2;
    public String rn_fri_total3;
    public String rn_fri_total4;
    public String rn_fri_total5;
    public String rn_mon_total1;
    public String rn_mon_total2;
    public String rn_mon_total3;
    public String rn_mon_total4;
    public String rn_mon_total5;
    public String rn_night_fri1;
    public String rn_night_fri2;
    public String rn_night_fri3;
    public String rn_night_fri4;
    public String rn_night_fri5;
    public String rn_night_mon1;
    public String rn_night_mon2;
    public String rn_night_mon3;
    public String rn_night_mon4;
    public String rn_night_mon5;
    public String rn_night_sat1;
    public String rn_night_sat2;
    public String rn_night_sat3;
    public String rn_night_sat4;
    public String rn_night_sat5;
    public String rn_night_sun1;
    public String rn_night_sun2;
    public String rn_night_sun3;
    public String rn_night_sun4;
    public String rn_night_sun5;
    public String rn_night_thu1;
    public String rn_night_thu2;
    public String rn_night_thu3;
    public String rn_night_thu4;
    public String rn_night_thu5;
    public String rn_night_tue1;
    public String rn_night_tue2;
    public String rn_night_tue3;
    public String rn_night_tue4;
    public String rn_night_tue5;
    public String rn_night_wed1;
    public String rn_night_wed2;
    public String rn_night_wed3;
    public String rn_night_wed4;
    public String rn_night_wed5;
    public String rn_sat_total1;
    public String rn_sat_total2;
    public String rn_sat_total3;
    public String rn_sat_total4;
    public String rn_sat_total5;
    public String rn_sun_total1;
    public String rn_sun_total2;
    public String rn_sun_total3;
    public String rn_sun_total4;
    public String rn_sun_total5;
    public String rn_thu_total1;
    public String rn_thu_total2;
    public String rn_thu_total3;
    public String rn_thu_total4;
    public String rn_thu_total5;
    public String rn_tue_total1;
    public String rn_tue_total2;
    public String rn_tue_total3;
    public String rn_tue_total4;
    public String rn_tue_total5;
    public String rn_wed_total1;
    public String rn_wed_total2;
    public String rn_wed_total3;
    public String rn_wed_total4;
    public String rn_wed_total5;
    public String ald_dt_annual1;
    public String ald_dt_annual2;
    public String ald_dt_annual3;
    public String ald_dt_annual4;
    public String ald_dt_annual5;
    public String ald_fri_total1;
    public String ald_fri_total2;
    public String ald_fri_total3;
    public String ald_fri_total4;
    public String ald_fri_total5;
    public String ald_mon_total1;
    public String ald_mon_total2;
    public String ald_mon_total3;
    public String ald_mon_total4;
    public String ald_mon_total5;
    public String ald_ot_annual1;
    public String ald_ot_annual2;
    public String ald_ot_annual3;
    public String ald_ot_annual4;
    public String ald_ot_annual5;
    public String ald_pt_annual1;
    public String ald_pt_annual2;
    public String ald_pt_annual3;
    public String ald_pt_annual4;
    public String ald_pt_annual5;
    public String ald_rt_annual1;
    public String ald_rt_annual2;
    public String ald_rt_annual3;
    public String ald_rt_annual4;
    public String ald_rt_annual5;
    public String ald_sat_total1;
    public String ald_sat_total2;
    public String ald_sat_total3;
    public String ald_sat_total4;
    public String ald_sat_total5;
    public String ald_sp_annual1;
    public String ald_sp_annual2;
    public String ald_sp_annual3;
    public String ald_sp_annual4;
    public String ald_sp_annual5;
    public String ald_sun_total1;
    public String ald_sun_total2;
    public String ald_sun_total3;
    public String ald_sun_total4;
    public String ald_sun_total5;
    public String ald_sw_annual1;
    public String ald_sw_annual2;
    public String ald_sw_annual3;
    public String ald_sw_annual4;
    public String ald_sw_annual5;
    public String ald_thu_total1;
    public String ald_thu_total2;
    public String ald_thu_total3;
    public String ald_thu_total4;
    public String ald_thu_total5;
    public String ald_tue_total1;
    public String ald_tue_total2;
    public String ald_tue_total3;
    public String ald_tue_total4;
    public String ald_tue_total5;
    public String ald_wed_total1;
    public String ald_wed_total2;
    public String ald_wed_total3;
    public String ald_wed_total4;
    public String ald_wed_total5;
    public String aldnop_at_fri1;
    public String aldnop_at_fri2;
    public String aldnop_at_fri3;
    public String aldnop_at_fri4;
    public String aldnop_at_fri5;
    public String aldnop_at_mon1;
    public String aldnop_at_mon2;
    public String aldnop_at_mon3;
    public String aldnop_at_mon4;
    public String aldnop_at_mon5;
    public String aldnop_at_sat1;
    public String aldnop_at_sat2;
    public String aldnop_at_sat3;
    public String aldnop_at_sat4;
    public String aldnop_at_sat5;
    public String aldnop_at_sun1;
    public String aldnop_at_sun2;
    public String aldnop_at_sun3;
    public String aldnop_at_sun4;
    public String aldnop_at_sun5;
    public String aldnop_at_thu1;
    public String aldnop_at_thu2;
    public String aldnop_at_thu3;
    public String aldnop_at_thu4;
    public String aldnop_at_thu5;
    public String aldnop_at_tue1;
    public String aldnop_at_tue2;
    public String aldnop_at_tue3;
    public String aldnop_at_tue4;
    public String aldnop_at_tue5;
    public String aldnop_at_wed1;
    public String aldnop_at_wed2;
    public String aldnop_at_wed3;
    public String aldnop_at_wed4;
    public String aldnop_at_wed5;
    public String aldnop_aw_fri1;
    public String aldnop_aw_fri2;
    public String aldnop_aw_fri3;
    public String aldnop_aw_fri4;
    public String aldnop_aw_fri5;
    public String aldnop_aw_mon1;
    public String aldnop_aw_mon2;
    public String aldnop_aw_mon3;
    public String aldnop_aw_mon4;
    public String aldnop_aw_mon5;
    public String aldnop_aw_sat1;
    public String aldnop_aw_sat2;
    public String aldnop_aw_sat3;
    public String aldnop_aw_sat4;
    public String aldnop_aw_sat5;
    public String aldnop_aw_sun1;
    public String aldnop_aw_sun2;
    public String aldnop_aw_sun3;
    public String aldnop_aw_sun4;
    public String aldnop_aw_sun5;
    public String aldnop_aw_thu1;
    public String aldnop_aw_thu2;
    public String aldnop_aw_thu3;
    public String aldnop_aw_thu4;
    public String aldnop_aw_thu5;
    public String aldnop_aw_tue1;
    public String aldnop_aw_tue2;
    public String aldnop_aw_tue3;
    public String aldnop_aw_tue4;
    public String aldnop_aw_tue5;
    public String aldnop_aw_wed1;
    public String aldnop_aw_wed2;
    public String aldnop_aw_wed3;
    public String aldnop_aw_wed4;
    public String aldnop_aw_wed5;
    public String aldnop_mt_fri1;
    public String aldnop_mt_fri2;
    public String aldnop_mt_fri3;
    public String aldnop_mt_fri4;
    public String aldnop_mt_fri5;
    public String aldnop_mt_mon1;
    public String aldnop_mt_mon2;
    public String aldnop_mt_mon3;
    public String aldnop_mt_mon4;
    public String aldnop_mt_mon5;
    public String aldnop_mt_sat1;
    public String aldnop_mt_sat2;
    public String aldnop_mt_sat3;
    public String aldnop_mt_sat4;
    public String aldnop_mt_sat5;
    public String aldnop_mt_sun1;
    public String aldnop_mt_sun2;
    public String aldnop_mt_sun3;
    public String aldnop_mt_sun4;
    public String aldnop_mt_sun5;
    public String aldnop_mt_thu1;
    public String aldnop_mt_thu2;
    public String aldnop_mt_thu3;
    public String aldnop_mt_thu4;
    public String aldnop_mt_thu5;
    public String aldnop_mt_tue1;
    public String aldnop_mt_tue2;
    public String aldnop_mt_tue3;
    public String aldnop_mt_tue4;
    public String aldnop_mt_tue5;
    public String aldnop_mt_wed1;
    public String aldnop_mt_wed2;
    public String aldnop_mt_wed3;
    public String aldnop_mt_wed4;
    public String aldnop_mt_wed5;
    public String aldnop_ra_fri1;
    public String aldnop_ra_fri2;
    public String aldnop_ra_fri3;
    public String aldnop_ra_fri4;
    public String aldnop_ra_fri5;
    public String aldnop_ra_mon1;
    public String aldnop_ra_mon2;
    public String aldnop_ra_mon3;
    public String aldnop_ra_mon4;
    public String aldnop_ra_mon5;
    public String aldnop_ra_sat1;
    public String aldnop_ra_sat2;
    public String aldnop_ra_sat3;
    public String aldnop_ra_sat4;
    public String aldnop_ra_sat5;
    public String aldnop_ra_sun1;
    public String aldnop_ra_sun2;
    public String aldnop_ra_sun3;
    public String aldnop_ra_sun4;
    public String aldnop_ra_sun5;
    public String aldnop_ra_thu1;
    public String aldnop_ra_thu2;
    public String aldnop_ra_thu3;
    public String aldnop_ra_thu4;
    public String aldnop_ra_thu5;
    public String aldnop_ra_tue1;
    public String aldnop_ra_tue2;
    public String aldnop_ra_tue3;
    public String aldnop_ra_tue4;
    public String aldnop_ra_tue5;
    public String aldnop_ra_wed1;
    public String aldnop_ra_wed2;
    public String aldnop_ra_wed3;
    public String aldnop_ra_wed4;
    public String aldnop_ra_wed5;
    public String aldnop_rt_fri1;
    public String aldnop_rt_fri2;
    public String aldnop_rt_fri3;
    public String aldnop_rt_fri4;
    public String aldnop_rt_fri5;
    public String aldnop_rt_mon1;
    public String aldnop_rt_mon2;
    public String aldnop_rt_mon3;
    public String aldnop_rt_mon4;
    public String aldnop_rt_mon5;
    public String aldnop_rt_sat1;
    public String aldnop_rt_sat2;
    public String aldnop_rt_sat3;
    public String aldnop_rt_sat4;
    public String aldnop_rt_sat5;
    public String aldnop_rt_sun1;
    public String aldnop_rt_sun2;
    public String aldnop_rt_sun3;
    public String aldnop_rt_sun4;
    public String aldnop_rt_sun5;
    public String aldnop_rt_thu1;
    public String aldnop_rt_thu2;
    public String aldnop_rt_thu3;
    public String aldnop_rt_thu4;
    public String aldnop_rt_thu5;
    public String aldnop_rt_tue1;
    public String aldnop_rt_tue2;
    public String aldnop_rt_tue3;
    public String aldnop_rt_tue4;
    public String aldnop_rt_tue5;
    public String aldnop_rt_wed1;
    public String aldnop_rt_wed2;
    public String aldnop_rt_wed3;
    public String aldnop_rt_wed4;
    public String aldnop_rt_wed5;
    public String hca_day_label1;
    public String hca_day_label2;
    public String hca_day_label3;
    public String hca_day_label4;
    public String hca_day_label5;
    public String hca_day_total1;
    public String hca_day_total2;
    public String hca_day_total3;
    public String hca_day_total4;
    public String hca_day_total5;
    public String hca_eve_label1;
    public String hca_eve_label2;
    public String hca_eve_label3;
    public String hca_eve_label4;
    public String hca_eve_label5;
    public String hca_eve_total1;
    public String hca_eve_total2;
    public String hca_eve_total3;
    public String hca_eve_total4;
    public String hca_eve_total5;
    public String hca_fri_total1;
    public String hca_fri_total2;
    public String hca_fri_total3;
    public String hca_fri_total4;
    public String hca_fri_total5;
    public String hca_mon_total1;
    public String hca_mon_total2;
    public String hca_mon_total3;
    public String hca_mon_total4;
    public String hca_mon_total5;
    public String hca_night_fri1;
    public String hca_night_fri2;
    public String hca_night_fri3;
    public String hca_night_fri4;
    public String hca_night_fri5;
    public String hca_night_mon1;
    public String hca_night_mon2;
    public String hca_night_mon3;
    public String hca_night_mon4;
    public String hca_night_mon5;
    public String hca_night_sat1;
    public String hca_night_sat2;
    public String hca_night_sat3;
    public String hca_night_sat4;
    public String hca_night_sat5;
    public String hca_night_sun1;
    public String hca_night_sun2;
    public String hca_night_sun3;
    public String hca_night_sun4;
    public String hca_night_sun5;
    public String hca_night_thu1;
    public String hca_night_thu2;
    public String hca_night_thu3;
    public String hca_night_thu4;
    public String hca_night_thu5;
    public String hca_night_tue1;
    public String hca_night_tue2;
    public String hca_night_tue3;
    public String hca_night_tue4;
    public String hca_night_tue5;
    public String hca_night_wed1;
    public String hca_night_wed2;
    public String hca_night_wed3;
    public String hca_night_wed4;
    public String hca_night_wed5;
    public String hca_sat_total1;
    public String hca_sat_total2;
    public String hca_sat_total3;
    public String hca_sat_total4;
    public String hca_sat_total5;
    public String hca_sun_total1;
    public String hca_sun_total2;
    public String hca_sun_total3;
    public String hca_sun_total4;
    public String hca_sun_total5;
    public String hca_thu_total1;
    public String hca_thu_total2;
    public String hca_thu_total3;
    public String hca_thu_total4;
    public String hca_thu_total5;
    public String hca_tue_total1;
    public String hca_tue_total2;
    public String hca_tue_total3;
    public String hca_tue_total4;
    public String hca_tue_total5;
    public String hca_wed_total1;
    public String hca_wed_total2;
    public String hca_wed_total3;
    public String hca_wed_total4;
    public String hca_wed_total5;
    public String lpn_day_label1;
    public String lpn_day_label2;
    public String lpn_day_label3;
    public String lpn_day_label4;
    public String lpn_day_label5;
    public String lpn_day_total1;
    public String lpn_day_total2;
    public String lpn_day_total3;
    public String lpn_day_total4;
    public String lpn_day_total5;
    public String lpn_eve_label1;
    public String lpn_eve_label2;
    public String lpn_eve_label3;
    public String lpn_eve_label4;
    public String lpn_eve_label5;
    public String lpn_eve_total1;
    public String lpn_eve_total2;
    public String lpn_eve_total3;
    public String lpn_eve_total4;
    public String lpn_eve_total5;
    public String lpn_fri_total1;
    public String lpn_fri_total2;
    public String lpn_fri_total3;
    public String lpn_fri_total4;
    public String lpn_fri_total5;
    public String lpn_mon_total1;
    public String lpn_mon_total2;
    public String lpn_mon_total3;
    public String lpn_mon_total4;
    public String lpn_mon_total5;
    public String lpn_night_fri1;
    public String lpn_night_fri2;
    public String lpn_night_fri3;
    public String lpn_night_fri4;
    public String lpn_night_fri5;
    public String lpn_night_mon1;
    public String lpn_night_mon2;
    public String lpn_night_mon3;
    public String lpn_night_mon4;
    public String lpn_night_mon5;
    public String lpn_night_sat1;
    public String lpn_night_sat2;
    public String lpn_night_sat3;
    public String lpn_night_sat4;
    public String lpn_night_sat5;
    public String lpn_night_sun1;
    public String lpn_night_sun2;
    public String lpn_night_sun3;
    public String lpn_night_sun4;
    public String lpn_night_sun5;
    public String lpn_night_thu1;
    public String lpn_night_thu2;
    public String lpn_night_thu3;
    public String lpn_night_thu4;
    public String lpn_night_thu5;
    public String lpn_night_tue1;
    public String lpn_night_tue2;
    public String lpn_night_tue3;
    public String lpn_night_tue4;
    public String lpn_night_tue5;
    public String lpn_night_wed1;
    public String lpn_night_wed2;
    public String lpn_night_wed3;
    public String lpn_night_wed4;
    public String lpn_night_wed5;
    public String lpn_sat_total1;
    public String lpn_sat_total2;
    public String lpn_sat_total3;
    public String lpn_sat_total4;
    public String lpn_sat_total5;
    public String lpn_sun_total1;
    public String lpn_sun_total2;
    public String lpn_sun_total3;
    public String lpn_sun_total4;
    public String lpn_sun_total5;
    public String lpn_thu_total1;
    public String lpn_thu_total2;
    public String lpn_thu_total3;
    public String lpn_thu_total4;
    public String lpn_thu_total5;
    public String lpn_tue_total1;
    public String lpn_tue_total2;
    public String lpn_tue_total3;
    public String lpn_tue_total4;
    public String lpn_tue_total5;
    public String lpn_wed_total1;
    public String lpn_wed_total2;
    public String lpn_wed_total3;
    public String lpn_wed_total4;
    public String lpn_wed_total5;
    public String nnp_fri_total1;
    public String nnp_fri_total2;
    public String nnp_fri_total3;
    public String nnp_fri_total4;
    public String nnp_fri_total5;
    public String nnp_mon_total1;
    public String nnp_mon_total2;
    public String nnp_mon_total3;
    public String nnp_mon_total4;
    public String nnp_mon_total5;
    public String nnp_sat_total1;
    public String nnp_sat_total2;
    public String nnp_sat_total3;
    public String nnp_sat_total4;
    public String nnp_sat_total5;
    public String nnp_sun_total1;
    public String nnp_sun_total2;
    public String nnp_sun_total3;
    public String nnp_sun_total4;
    public String nnp_sun_total5;
    public String nnp_thu_total1;
    public String nnp_thu_total2;
    public String nnp_thu_total3;
    public String nnp_thu_total4;
    public String nnp_thu_total5;
    public String nnp_tue_total1;
    public String nnp_tue_total2;
    public String nnp_tue_total3;
    public String nnp_tue_total4;
    public String nnp_tue_total5;
    public String nnp_wed_total1;
    public String nnp_wed_total2;
    public String nnp_wed_total3;
    public String nnp_wed_total4;
    public String nnp_wed_total5;
    public String np_week_total1;
    public String np_week_total2;
    public String np_week_total3;
    public String np_week_total4;
    public String np_week_total5;
    public String nursing_label1;
    public String nursing_label2;
    public String nursing_label3;
    public String nursing_label4;
    public String nursing_label5;
    public String periodEndDate1;
    public String periodEndDate2;
    public String periodEndDate3;
    public String periodEndDate4;
    public String periodEndDate5;
    public String rn_day_annual1;
    public String rn_day_annual2;
    public String rn_day_annual3;
    public String rn_day_annual4;
    public String rn_day_annual5;
    public String rn_eve_annual1;
    public String rn_eve_annual2;
    public String rn_eve_annual3;
    public String rn_eve_annual4;
    public String rn_eve_annual5;
    public String rn_week_total1;
    public String rn_week_total2;
    public String rn_week_total3;
    public String rn_week_total4;
    public String rn_week_total5;
    public String HPRD_total_fri1;
    public String HPRD_total_fri2;
    public String HPRD_total_fri3;
    public String HPRD_total_fri4;
    public String HPRD_total_fri5;
    public String HPRD_total_mon1;
    public String HPRD_total_mon2;
    public String HPRD_total_mon3;
    public String HPRD_total_mon4;
    public String HPRD_total_mon5;
    public String HPRD_total_sat1;
    public String HPRD_total_sat2;
    public String HPRD_total_sat3;
    public String HPRD_total_sat4;
    public String HPRD_total_sat5;
    public String HPRD_total_sun1;
    public String HPRD_total_sun2;
    public String HPRD_total_sun3;
    public String HPRD_total_sun4;
    public String HPRD_total_sun5;
    public String HPRD_total_thu1;
    public String HPRD_total_thu2;
    public String HPRD_total_thu3;
    public String HPRD_total_thu4;
    public String HPRD_total_thu5;
    public String HPRD_total_wed1;
    public String HPRD_total_wed2;
    public String HPRD_total_wed3;
    public String HPRD_total_wed4;
    public String HPRD_total_wed5;
    public String ald_week_total1;
    public String ald_week_total2;
    public String ald_week_total3;
    public String ald_week_total4;
    public String ald_week_total5;
    public String alliedNP_label1;
    public String alliedNP_label2;
    public String alliedNP_label3;
    public String alliedNP_label4;
    public String alliedNP_label5;
    public String hca_day_annual1;
    public String hca_day_annual2;
    public String hca_day_annual3;
    public String hca_day_annual4;
    public String hca_day_annual5;
    public String hca_eve_annual1;
    public String hca_eve_annual2;
    public String hca_eve_annual3;
    public String hca_eve_annual4;
    public String hca_eve_annual5;
    public String hca_week_total1;
    public String hca_week_total2;
    public String hca_week_total3;
    public String hca_week_total4;
    public String hca_week_total5;
    public String lpn_day_annual1;
    public String lpn_day_annual2;
    public String lpn_day_annual3;
    public String lpn_day_annual4;
    public String lpn_day_annual5;
    public String lpn_eve_annual1;
    public String lpn_eve_annual2;
    public String lpn_eve_annual3;
    public String lpn_eve_annual4;
    public String lpn_eve_annual5;
    public String lpn_week_total1;
    public String lpn_week_total2;
    public String lpn_week_total3;
    public String lpn_week_total4;
    public String lpn_week_total5;
    public String nnp_week_total1;
    public String nnp_week_total2;
    public String nnp_week_total3;
    public String nnp_week_total4;
    public String nnp_week_total5;
    public String revisionReason1;
    public String revisionReason2;
    public String revisionReason3;
    public String revisionReason4;
    public String revisionReason5;
    public String rn_night_label;
    public String rn_night_label1;
    public String rn_night_label2;
    public String rn_night_label3;
    public String rn_night_label4;
    public String rn_night_label5;
    public String rn_night_total1;
    public String rn_night_total2;
    public String rn_night_total3;
    public String rn_night_total4;
    public String rn_night_total5;
    public String summary_annual1;
    public String summary_annual2;
    public String summary_annual3;
    public String summary_annual4;
    public String summary_annual5;
    public String HPRD_allied_fri1;
    public String HPRD_allied_fri2;
    public String HPRD_allied_fri3;
    public String HPRD_allied_fri4;
    public String HPRD_allied_fri5;
    public String HPRD_allied_mon1;
    public String HPRD_allied_mon2;
    public String HPRD_allied_mon3;
    public String HPRD_allied_mon4;
    public String HPRD_allied_mon5;
    public String HPRD_allied_sat1;
    public String HPRD_allied_sat2;
    public String HPRD_allied_sat3;
    public String HPRD_allied_sat4;
    public String HPRD_allied_sat5;
    public String HPRD_allied_sun1;
    public String HPRD_allied_sun2;
    public String HPRD_allied_sun3;
    public String HPRD_allied_sun4;
    public String HPRD_allied_sun5;
    public String HPRD_allied_thu1;
    public String HPRD_allied_thu2;
    public String HPRD_allied_thu3;
    public String HPRD_allied_thu4;
    public String HPRD_allied_thu5;
    public String HPRD_allied_tue1;
    public String HPRD_allied_tue2;
    public String HPRD_allied_tue3;
    public String HPRD_allied_tue4;
    public String HPRD_allied_tue5;
    public String HPRD_allied_wed1;
    public String HPRD_allied_wed2;
    public String HPRD_allied_wed3;
    public String HPRD_allied_wed4;
    public String HPRD_allied_wed5;
    public String aldnop_at_label1;
    public String aldnop_at_label2;
    public String aldnop_at_label3;
    public String aldnop_at_label4;
    public String aldnop_at_label5;
    public String aldnop_at_total1;
    public String aldnop_at_total2;
    public String aldnop_at_total3;
    public String aldnop_at_total4;
    public String aldnop_at_total5;
    public String aldnop_aw_label1;
    public String aldnop_aw_label2;
    public String aldnop_aw_label3;
    public String aldnop_aw_label4;
    public String aldnop_aw_label5;
    public String aldnop_aw_total1;
    public String aldnop_aw_total2;
    public String aldnop_aw_total3;
    public String aldnop_aw_total4;
    public String aldnop_aw_total5;
    public String aldnop_mt_label1;
    public String aldnop_mt_label2;
    public String aldnop_mt_label3;
    public String aldnop_mt_label4;
    public String aldnop_mt_label5;
    public String aldnop_mt_total1;
    public String aldnop_mt_total2;
    public String aldnop_mt_total3;
    public String aldnop_mt_total4;
    public String aldnop_mt_total5;
    public String aldnop_ra_label1;
    public String aldnop_ra_label2;
    public String aldnop_ra_label3;
    public String aldnop_ra_label4;
    public String aldnop_ra_label5;
    public String aldnop_ra_total1;
    public String aldnop_ra_total2;
    public String aldnop_ra_total3;
    public String aldnop_ra_total4;
    public String aldnop_ra_total5;
    public String aldnop_rt_label1;
    public String aldnop_rt_label2;
    public String aldnop_rt_label3;
    public String aldnop_rt_label4;
    public String aldnop_rt_label5;
    public String aldnop_rt_total1;
    public String aldnop_rt_total2;
    public String aldnop_rt_total3;
    public String aldnop_rt_total4;
    public String aldnop_rt_total5;
    public String hca_night_label1;
    public String hca_night_label2;
    public String hca_night_label3;
    public String hca_night_label4;
    public String hca_night_label5;
    public String hca_night_total1;
    public String hca_night_total2;
    public String hca_night_total3;
    public String hca_night_total4;
    public String hca_night_total5;
    public String lpn_night_label1;
    public String lpn_night_label2;
    public String lpn_night_label3;
    public String lpn_night_label4;
    public String lpn_night_label5;
    public String lpn_night_total1;
    public String lpn_night_total2;
    public String lpn_night_total3;
    public String lpn_night_total4;
    public String lpn_night_total5;
    public String np_annual_total1;
    public String np_annual_total2;
    public String np_annual_total3;
    public String np_annual_total4;
    public String np_annual_total5;
    public String periodStartDate1;
    public String periodStartDate2;
    public String periodStartDate3;
    public String periodStartDate4;
    public String periodStartDate5;
    public String providerName_AT1;
    public String providerName_AT2;
    public String providerName_AT3;
    public String providerName_AT4;
    public String providerName_AT5;
    public String providerName_AW1;
    public String providerName_AW2;
    public String providerName_AW3;
    public String providerName_AW4;
    public String providerName_AW5;
    public String providerName_DT1;
    public String providerName_DT2;
    public String providerName_DT3;
    public String providerName_DT4;
    public String providerName_DT5;
    public String providerName_MT1;
    public String providerName_MT2;
    public String providerName_MT3;
    public String providerName_MT4;
    public String providerName_MT5;
    public String providerName_OT1;
    public String providerName_OT2;
    public String providerName_OT3;
    public String providerName_OT4;
    public String providerName_OT5;
    public String providerName_PT1;
    public String providerName_PT2;
    public String providerName_PT3;
    public String providerName_PT4;
    public String providerName_PT5;
    public String providerName_RA1;
    public String providerName_RA2;
    public String providerName_RA3;
    public String providerName_RA4;
    public String providerName_RA5;
    public String providerName_RN1;
    public String providerName_RN2;
    public String providerName_RN3;
    public String providerName_RN4;
    public String providerName_RN5;
    public String providerName_RT1;
    public String providerName_RT2;
    public String providerName_RT3;
    public String providerName_RT4;
    public String providerName_RT5;
    public String providerName_SL1;
    public String providerName_SL2;
    public String providerName_SL3;
    public String providerName_SL4;
    public String providerName_SL5;
    public String providerName_SW1;
    public String providerName_SW2;
    public String providerName_SW3;
    public String providerName_SW4;
    public String providerName_SW5;
    public String rn_annual_total1;
    public String rn_annual_total2;
    public String rn_annual_total3;
    public String rn_annual_total4;
    public String rn_annual_total5;
    public String rn_night_annual1;
    public String rn_night_annual2;
    public String rn_night_annual3;
    public String rn_night_annual4;
    public String rn_night_annual5;
    public String summary_inHouse1;
    public String summary_inHouse2;
    public String summary_inHouse3;
    public String summary_inHouse4;
    public String summary_inHouse5;
    public String HPRD_nursing_fri1;
    public String HPRD_nursing_fri2;
    public String HPRD_nursing_fri3;
    public String HPRD_nursing_fri4;
    public String HPRD_nursing_fri5;
    public String HPRD_nursing_mon1;
    public String HPRD_nursing_mon2;
    public String HPRD_nursing_mon3;
    public String HPRD_nursing_mon4;
    public String HPRD_nursing_mon5;
    public String HPRD_nursing_sat1;
    public String HPRD_nursing_sat2;
    public String HPRD_nursing_sat3;
    public String HPRD_nursing_sat4;
    public String HPRD_nursing_sat5;
    public String HPRD_nursing_sun1;
    public String HPRD_nursing_sun2;
    public String HPRD_nursing_sun3;
    public String HPRD_nursing_sun4;
    public String HPRD_nursing_sun5;
    public String HPRD_nursing_thu1;
    public String HPRD_nursing_thu2;
    public String HPRD_nursing_thu3;
    public String HPRD_nursing_thu4;
    public String HPRD_nursing_thu5;
    public String HPRD_nursing_tue1;
    public String HPRD_nursing_tue2;
    public String HPRD_nursing_tue3;
    public String HPRD_nursing_tue4;
    public String HPRD_nursing_tue5;
    public String HPRD_nursing_wed1;
    public String HPRD_nursing_wed2;
    public String HPRD_nursing_wed3;
    public String HPRD_nursing_wed4;
    public String HPRD_nursing_wed5;
    public String ald_annual_total1;
    public String ald_annual_total2;
    public String ald_annual_total3;
    public String ald_annual_total4;
    public String ald_annual_total5;
    public String aldnop_at_annual1;
    public String aldnop_at_annual2;
    public String aldnop_at_annual3;
    public String aldnop_at_annual4;
    public String aldnop_at_annual5;
    public String aldnop_aw_annual1;
    public String aldnop_aw_annual2;
    public String aldnop_aw_annual3;
    public String aldnop_aw_annual4;
    public String aldnop_aw_annual5;
    public String aldnop_fri_total1;
    public String aldnop_fri_total2;
    public String aldnop_fri_total3;
    public String aldnop_fri_total4;
    public String aldnop_fri_total5;
    public String aldnop_mon_total1;
    public String aldnop_mon_total2;
    public String aldnop_mon_total3;
    public String aldnop_mon_total4;
    public String aldnop_mon_total5;
    public String aldnop_mt_annual1;
    public String aldnop_mt_annual2;
    public String aldnop_mt_annual3;
    public String aldnop_mt_annual4;
    public String aldnop_mt_annual5;
    public String aldnop_ra_annual1;
    public String aldnop_ra_annual2;
    public String aldnop_ra_annual3;
    public String aldnop_ra_annual4;
    public String aldnop_ra_annual5;
    public String aldnop_rt_annual1;
    public String aldnop_rt_annual2;
    public String aldnop_rt_annual3;
    public String aldnop_rt_annual4;
    public String aldnop_rt_annual5;
    public String aldnop_sat_total1;
    public String aldnop_sat_total2;
    public String aldnop_sat_total3;
    public String aldnop_sat_total4;
    public String aldnop_sat_total5;
    public String aldnop_sun_total1;
    public String aldnop_sun_total2;
    public String aldnop_sun_total3;
    public String aldnop_sun_total4;
    public String aldnop_sun_total5;
    public String aldnop_thu_total1;
    public String aldnop_thu_total2;
    public String aldnop_thu_total3;
    public String aldnop_thu_total4;
    public String aldnop_thu_total5;
    public String aldnop_tue_total1;
    public String aldnop_tue_total2;
    public String aldnop_tue_total3;
    public String aldnop_tue_total4;
    public String aldnop_tue_total5;
    public String aldnop_wed_total1;
    public String aldnop_wed_total2;
    public String aldnop_wed_total3;
    public String aldnop_wed_total4;
    public String aldnop_wed_total5;
    public String alliedProf_label1;
    public String alliedProf_label2;
    public String alliedProf_label3;
    public String alliedProf_label4;
    public String alliedProf_label5;
    public String allied_fri_total1;
    public String allied_fri_total2;
    public String allied_fri_total3;
    public String allied_fri_total4;
    public String allied_fri_total5;
    public String allied_mon_total1;
    public String allied_mon_total2;
    public String allied_mon_total3;
    public String allied_mon_total4;
    public String allied_mon_total5;
    public String allied_sat_total1;
    public String allied_sat_total2;
    public String allied_sat_total3;
    public String allied_sat_total4;
    public String allied_sat_total5;
    public String allied_sun_total1;
    public String allied_sun_total2;
    public String allied_sun_total3;
    public String allied_sun_total4;
    public String allied_sun_total5;
    public String allied_thu_total1;
    public String allied_thu_total2;
    public String allied_thu_total3;
    public String allied_thu_total4;
    public String allied_thu_total5;
    public String allied_tue_total1;
    public String allied_tue_total2;
    public String allied_tue_total3;
    public String allied_tue_total4;
    public String allied_tue_total5;
    public String allied_wed_total1;
    public String allied_wed_total2;
    public String allied_wed_total3;
    public String allied_wed_total4;
    public String allied_wed_total5;
    public String contractedOut_AT1;
    public String contractedOut_AT2;
    public String contractedOut_AT3;
    public String contractedOut_AT4;
    public String contractedOut_AT5;
    public String contractedOut_AW1;
    public String contractedOut_AW2;
    public String contractedOut_AW3;
    public String contractedOut_AW4;
    public String contractedOut_AW5;
    public String contractedOut_DT1;
    public String contractedOut_DT2;
    public String contractedOut_DT3;
    public String contractedOut_DT4;
    public String contractedOut_DT5;
    public String contractedOut_MT1;
    public String contractedOut_MT2;
    public String contractedOut_MT3;
    public String contractedOut_MT4;
    public String contractedOut_MT5;
    public String contractedOut_OT1;
    public String contractedOut_OT2;
    public String contractedOut_OT3;
    public String contractedOut_OT4;
    public String contractedOut_OT5;
    public String contractedOut_PT1;
    public String contractedOut_PT2;
    public String contractedOut_PT3;
    public String contractedOut_PT4;
    public String contractedOut_PT5;
    public String contractedOut_RA1;
    public String contractedOut_RA2;
    public String contractedOut_RA3;
    public String contractedOut_RA4;
    public String contractedOut_RA5;
    public String contractedOut_RN1;
    public String contractedOut_RN2;
    public String contractedOut_RN3;
    public String contractedOut_RN4;
    public String contractedOut_RN5;
    public String contractedOut_RT1;
    public String contractedOut_RT2;
    public String contractedOut_RT3;
    public String contractedOut_RT4;
    public String contractedOut_RT5;
    public String contractedOut_SL1;
    public String contractedOut_SL2;
    public String contractedOut_SL3;
    public String contractedOut_SL4;
    public String contractedOut_SL5;
    public String contractedOut_SW1;
    public String contractedOut_SW2;
    public String contractedOut_SW3;
    public String contractedOut_SW4;
    public String contractedOut_SW5;
    public String hca_annual_total1;
    public String hca_annual_total2;
    public String hca_annual_total3;
    public String hca_annual_total4;
    public String hca_annual_total5;
    public String hca_night_annual1;
    public String hca_night_annual2;
    public String hca_night_annual3;
    public String hca_night_annual4;
    public String hca_night_annual5;
    public String lpn_annual_total1;
    public String lpn_annual_total2;
    public String lpn_annual_total3;
    public String lpn_annual_total4;
    public String lpn_annual_total5;
    public String lpn_night_annual1;
    public String lpn_night_annual2;
    public String lpn_night_annual3;
    public String lpn_night_annual4;
    public String lpn_night_annual5;
    public String nnp_annual_total1;
    public String nnp_annual_total2;
    public String nnp_annual_total3;
    public String nnp_annual_total4;
    public String nnp_annual_total5;
    public String percentageOut_AT1;
    public String percentageOut_AT2;
    public String percentageOut_AT3;
    public String percentageOut_AT4;
    public String percentageOut_AT5;
    public String percentageOut_AW1;
    public String percentageOut_AW2;
    public String percentageOut_AW3;
    public String percentageOut_AW4;
    public String percentageOut_AW5;
    public String percentageOut_DT1;
    public String percentageOut_DT2;
    public String percentageOut_DT3;
    public String percentageOut_DT4;
    public String percentageOut_DT5;
    public String percentageOut_MT1;
    public String percentageOut_MT2;
    public String percentageOut_MT3;
    public String percentageOut_MT4;
    public String percentageOut_MT5;
    public String percentageOut_OT1;
    public String percentageOut_OT2;
    public String percentageOut_OT3;
    public String percentageOut_OT4;
    public String percentageOut_OT5;
    public String percentageOut_PT1;
    public String percentageOut_PT2;
    public String percentageOut_PT3;
    public String percentageOut_PT4;
    public String percentageOut_PT5;
    public String percentageOut_RA1;
    public String percentageOut_RA2;
    public String percentageOut_RA3;
    public String percentageOut_RA4;
    public String percentageOut_RA5;
    public String percentageOut_RN1;
    public String percentageOut_RN2;
    public String percentageOut_RN3;
    public String percentageOut_RN4;
    public String percentageOut_RN5;
    public String percentageOut_RT1;
    public String percentageOut_RT2;
    public String percentageOut_RT3;
    public String percentageOut_RT4;
    public String percentageOut_RT5;
    public String percentageOut_SL1;
    public String percentageOut_SL2;
    public String percentageOut_SL3;
    public String percentageOut_SL4;
    public String percentageOut_SL5;
    public String percentageOut_SW1;
    public String percentageOut_SW2;
    public String percentageOut_SW3;
    public String percentageOut_SW4;
    public String percentageOut_SW5;
    public String providerName_LPN1;
    public String providerName_LPN2;
    public String providerName_LPN3;
    public String providerName_LPN4;
    public String providerName_LPN5;
    public String staffingPlanType1;
    public String staffingPlanType2;
    public String staffingPlanType3;
    public String staffingPlanType4;
    public String staffingPlanType5;
    public String HPRD_allied_total1;
    public String HPRD_allied_total2;
    public String HPRD_allied_total3;
    public String HPRD_allied_total4;
    public String HPRD_allied_total5;
    public String aldnop_week_total1;
    public String aldnop_week_total2;
    public String aldnop_week_total3;
    public String aldnop_week_total4;
    public String aldnop_week_total5;
    public String allied_week_total1;
    public String allied_week_total2;
    public String allied_week_total3;
    public String allied_week_total4;
    public String allied_week_total5;
    public String alliednp_other_mon;
    public String contractedOut_HCA1;
    public String contractedOut_HCA2;
    public String contractedOut_HCA3;
    public String contractedOut_HCA4;
    public String contractedOut_HCA5;
    public String contractedOut_LPN1;
    public String contractedOut_LPN2;
    public String contractedOut_LPN3;
    public String contractedOut_LPN4;
    public String contractedOut_LPN5;
    public String numberOfTotalBeds1;
    public String numberOfTotalBeds2;
    public String numberOfTotalBeds3;
    public String numberOfTotalBeds4;
    public String numberOfTotalBeds5;
    public String nursing_fri_total1;
    public String nursing_fri_total2;
    public String nursing_fri_total3;
    public String nursing_fri_total4;
    public String nursing_fri_total5;
    public String nursing_mon_total1;
    public String nursing_mon_total2;
    public String nursing_mon_total3;
    public String nursing_mon_total4;
    public String nursing_mon_total5;
    public String nursing_other_mon1;
    public String nursing_other_mon2;
    public String nursing_other_mon3;
    public String nursing_other_mon4;
    public String nursing_other_mon5;
    public String nursing_sat_total1;
    public String nursing_sat_total2;
    public String nursing_sat_total3;
    public String nursing_sat_total4;
    public String nursing_sat_total5;
    public String nursing_sun_total1;
    public String nursing_sun_total2;
    public String nursing_sun_total3;
    public String nursing_sun_total4;
    public String nursing_sun_total5;
    public String nursing_thu_total1;
    public String nursing_thu_total2;
    public String nursing_thu_total3;
    public String nursing_thu_total4;
    public String nursing_thu_total5;
    public String nursing_tue_total1;
    public String nursing_tue_total2;
    public String nursing_tue_total3;
    public String nursing_tue_total4;
    public String nursing_tue_total5;
    public String nursing_wed_total1;
    public String nursing_wed_total2;
    public String nursing_wed_total3;
    public String nursing_wed_total4;
    public String nursing_wed_total5;
    public String percentageOut_HCA1;
    public String percentageOut_HCA2;
    public String percentageOut_HCA3;
    public String percentageOut_HCA4;
    public String percentageOut_HCA5;
    public String percentageOut_LPN1;
    public String percentageOut_LPN2;
    public String percentageOut_LPN3;
    public String percentageOut_LPN4;
    public String percentageOut_LPN5;
    public String providerName_HCA21;
    public String providerName_HCA22;
    public String providerName_HCA23;
    public String providerName_HCA24;
    public String providerName_HCA25;
    public String providerName_resp1;
    public String providerName_resp2;
    public String providerName_resp3;
    public String providerName_resp4;
    public String providerName_resp5;
    public String summary_annual_AT1;
    public String summary_annual_AT2;
    public String summary_annual_AT3;
    public String summary_annual_AT4;
    public String summary_annual_AT5;
    public String summary_annual_AW1;
    public String summary_annual_AW2;
    public String summary_annual_AW3;
    public String summary_annual_AW4;
    public String summary_annual_AW5;
    public String summary_annual_DT1;
    public String summary_annual_DT2;
    public String summary_annual_DT3;
    public String summary_annual_DT4;
    public String summary_annual_DT5;
    public String summary_annual_MT1;
    public String summary_annual_MT2;
    public String summary_annual_MT3;
    public String summary_annual_MT4;
    public String summary_annual_MT5;
    public String summary_annual_OT1;
    public String summary_annual_OT2;
    public String summary_annual_OT3;
    public String summary_annual_OT4;
    public String summary_annual_OT5;
    public String summary_annual_PT1;
    public String summary_annual_PT2;
    public String summary_annual_PT3;
    public String summary_annual_PT4;
    public String summary_annual_PT5;
    public String summary_annual_RA1;
    public String summary_annual_RA2;
    public String summary_annual_RA3;
    public String summary_annual_RA4;
    public String summary_annual_RA5;
    public String summary_annual_RN1;
    public String summary_annual_RN2;
    public String summary_annual_RN3;
    public String summary_annual_RN4;
    public String summary_annual_RN5;
    public String summary_annual_RT1;
    public String summary_annual_RT2;
    public String summary_annual_RT3;
    public String summary_annual_RT4;
    public String summary_annual_RT5;
    public String summary_annual_SL1;
    public String summary_annual_SL2;
    public String summary_annual_SL3;
    public String summary_annual_SL4;
    public String summary_annual_SL5;
    public String summary_annual_SW1;
    public String summary_annual_SW2;
    public String summary_annual_SW3;
    public String summary_annual_SW4;
    public String summary_annual_SW5;
    public String HPRD_nursing_total1;
    public String HPRD_nursing_total2;
    public String HPRD_nursing_total3;
    public String HPRD_nursing_total4;
    public String HPRD_nursing_total5;
    public String alliedNP_fri_total1;
    public String alliedNP_fri_total2;
    public String alliedNP_fri_total3;
    public String alliedNP_fri_total4;
    public String alliedNP_fri_total5;
    public String alliedNP_mon_total1;
    public String alliedNP_mon_total2;
    public String alliedNP_mon_total3;
    public String alliedNP_mon_total4;
    public String alliedNP_mon_total5;
    public String alliedNP_sat_total1;
    public String alliedNP_sat_total2;
    public String alliedNP_sat_total3;
    public String alliedNP_sat_total4;
    public String alliedNP_sat_total5;
    public String alliedNP_sun_total1;
    public String alliedNP_sun_total2;
    public String alliedNP_sun_total3;
    public String alliedNP_sun_total4;
    public String alliedNP_sun_total5;
    public String alliedNP_thu_total1;
    public String alliedNP_thu_total2;
    public String alliedNP_thu_total3;
    public String alliedNP_thu_total4;
    public String alliedNP_thu_total5;
    public String alliedNP_tue_total1;
    public String alliedNP_tue_total2;
    public String alliedNP_tue_total3;
    public String alliedNP_tue_total4;
    public String alliedNP_tue_total5;
    public String alliedNP_wed_total1;
    public String alliedNP_wed_total2;
    public String alliedNP_wed_total3;
    public String alliedNP_wed_total4;
    public String alliedNP_wed_total5;
    public String contractedOut_resp1;
    public String contractedOut_resp2;
    public String contractedOut_resp3;
    public String contractedOut_resp4;
    public String contractedOut_resp5;
    public String nursing_week_total1;
    public String nursing_week_total2;
    public String nursing_week_total3;
    public String nursing_week_total4;
    public String nursing_week_total5;
    public String percentageOut_resp1;
    public String percentageOut_resp2;
    public String percentageOut_resp3;
    public String percentageOut_resp4;
    public String percentageOut_resp5;
    public String summary_annual_HCA1;
    public String summary_annual_HCA2;
    public String summary_annual_HCA3;
    public String summary_annual_HCA4;
    public String summary_annual_HCA5;
    public String summary_annual_LPN1;
    public String summary_annual_LPN2;
    public String summary_annual_LPN3;
    public String summary_annual_LPN4;
    public String summary_annual_LPN5;
    public String summary_contracted1;
    public String summary_contracted2;
    public String summary_contracted3;
    public String summary_contracted4;
    public String summary_contracted5;
    public String summary_inHouse_AT1;
    public String summary_inHouse_AT2;
    public String summary_inHouse_AT3;
    public String summary_inHouse_AT4;
    public String summary_inHouse_AT5;
    public String summary_inHouse_AW1;
    public String summary_inHouse_AW2;
    public String summary_inHouse_AW3;
    public String summary_inHouse_AW4;
    public String summary_inHouse_AW5;
    public String summary_inHouse_DT1;
    public String summary_inHouse_DT2;
    public String summary_inHouse_DT3;
    public String summary_inHouse_DT4;
    public String summary_inHouse_DT5;
    public String summary_inHouse_MT1;
    public String summary_inHouse_MT2;
    public String summary_inHouse_MT3;
    public String summary_inHouse_MT4;
    public String summary_inHouse_MT5;
    public String summary_inHouse_OT1;
    public String summary_inHouse_OT2;
    public String summary_inHouse_OT3;
    public String summary_inHouse_OT4;
    public String summary_inHouse_OT5;
    public String summary_inHouse_PT1;
    public String summary_inHouse_PT2;
    public String summary_inHouse_PT3;
    public String summary_inHouse_PT4;
    public String summary_inHouse_PT5;
    public String summary_inHouse_RA1;
    public String summary_inHouse_RA2;
    public String summary_inHouse_RA3;
    public String summary_inHouse_RA4;
    public String summary_inHouse_RA5;
    public String summary_inHouse_RN1;
    public String summary_inHouse_RN2;
    public String summary_inHouse_RN3;
    public String summary_inHouse_RN4;
    public String summary_inHouse_RN5;
    public String summary_inHouse_RT1;
    public String summary_inHouse_RT2;
    public String summary_inHouse_RT3;
    public String summary_inHouse_RT4;
    public String summary_inHouse_RT5;
    public String summary_inHouse_SL1;
    public String summary_inHouse_SL2;
    public String summary_inHouse_SL3;
    public String summary_inHouse_SL4;
    public String summary_inHouse_SL5;
    public String summary_inHouse_SW1;
    public String summary_inHouse_SW2;
    public String summary_inHouse_SW3;
    public String summary_inHouse_SW4;
    public String summary_inHouse_SW5;
    public String aldnop_annual_total1;
    public String aldnop_annual_total2;
    public String aldnop_annual_total3;
    public String aldnop_annual_total4;
    public String aldnop_annual_total5;
    public String alliedNP_week_total1;
    public String alliedNP_week_total2;
    public String alliedNP_week_total3;
    public String alliedNP_week_total4;
    public String alliedNP_week_total5;
    public String allied_annual_total1;
    public String allied_annual_total2;
    public String allied_annual_total3;
    public String allied_annual_total4;
    public String allied_annual_total5;
    public String summary_annual_resp1;
    public String summary_annual_resp2;
    public String summary_annual_resp3;
    public String summary_annual_resp4;
    public String summary_annual_resp5;
    public String summary_inHouse_HCA1;
    public String summary_inHouse_HCA2;
    public String summary_inHouse_HCA3;
    public String summary_inHouse_HCA4;
    public String summary_inHouse_HCA5;
    public String summary_inHouse_LPN1;
    public String summary_inHouse_LPN2;
    public String summary_inHouse_LPN3;
    public String summary_inHouse_LPN4;
    public String summary_inHouse_LPN5;
    public String alliedProf_fri_total1;
    public String alliedProf_fri_total2;
    public String alliedProf_fri_total3;
    public String alliedProf_fri_total4;
    public String alliedProf_fri_total5;
    public String alliedProf_mon_total1;
    public String alliedProf_mon_total2;
    public String alliedProf_mon_total3;
    public String alliedProf_mon_total4;
    public String alliedProf_mon_total5;
    public String alliedProf_sat_total1;
    public String alliedProf_sat_total2;
    public String alliedProf_sat_total3;
    public String alliedProf_sat_total4;
    public String alliedProf_sat_total5;
    public String alliedProf_sun_total1;
    public String alliedProf_sun_total2;
    public String alliedProf_sun_total3;
    public String alliedProf_sun_total4;
    public String alliedProf_sun_total5;
    public String alliedProf_thu_total1;
    public String alliedProf_thu_total2;
    public String alliedProf_thu_total3;
    public String alliedProf_thu_total4;
    public String alliedProf_thu_total5;
    public String alliedProf_tue_total1;
    public String alliedProf_tue_total2;
    public String alliedProf_tue_total3;
    public String alliedProf_tue_total4;
    public String alliedProf_tue_total5;
    public String alliedProf_wed_total1;
    public String alliedProf_wed_total2;
    public String alliedProf_wed_total3;
    public String alliedProf_wed_total4;
    public String alliedProf_wed_total5;
    public String nursing_annual_total1;
    public String nursing_annual_total2;
    public String nursing_annual_total3;
    public String nursing_annual_total4;
    public String nursing_annual_total5;
    public String summary_inHouse_resp1;
    public String summary_inHouse_resp2;
    public String summary_inHouse_resp3;
    public String summary_inHouse_resp4;
    public String summary_inHouse_resp5;
    public String alliedNP_annual_total1;
    public String alliedNP_annual_total2;
    public String alliedNP_annual_total3;
    public String alliedNP_annual_total4;
    public String alliedNP_annual_total5;
    public String alliedProf_week_total1;
    public String alliedProf_week_total2;
    public String alliedProf_week_total3;
    public String alliedProf_week_total4;
    public String alliedProf_week_total5;
    public String prof_staff_percentage1;
    public String prof_staff_percentage2;
    public String prof_staff_percentage3;
    public String prof_staff_percentage4;
    public String prof_staff_percentage5;
    public String summary_contracted_AT1;
    public String summary_contracted_AT2;
    public String summary_contracted_AT3;
    public String summary_contracted_AT4;
    public String summary_contracted_AT5;
    public String summary_contracted_AW1;
    public String summary_contracted_AW2;
    public String summary_contracted_AW3;
    public String summary_contracted_AW4;
    public String summary_contracted_AW5;
    public String summary_contracted_DT1;
    public String summary_contracted_DT2;
    public String summary_contracted_DT3;
    public String summary_contracted_DT4;
    public String summary_contracted_DT5;
    public String summary_contracted_MT1;
    public String summary_contracted_MT2;
    public String summary_contracted_MT3;
    public String summary_contracted_MT4;
    public String summary_contracted_MT5;
    public String summary_contracted_OT1;
    public String summary_contracted_OT2;
    public String summary_contracted_OT3;
    public String summary_contracted_OT4;
    public String summary_contracted_OT5;
    public String summary_contracted_PT1;
    public String summary_contracted_PT2;
    public String summary_contracted_PT3;
    public String summary_contracted_PT4;
    public String summary_contracted_PT5;
    public String summary_contracted_RA1;
    public String summary_contracted_RA2;
    public String summary_contracted_RA3;
    public String summary_contracted_RA4;
    public String summary_contracted_RA5;
    public String summary_contracted_RN1;
    public String summary_contracted_RN2;
    public String summary_contracted_RN3;
    public String summary_contracted_RN4;
    public String summary_contracted_RN5;
    public String summary_contracted_RT1;
    public String summary_contracted_RT2;
    public String summary_contracted_RT3;
    public String summary_contracted_RT4;
    public String summary_contracted_RT5;
    public String summary_contracted_SL1;
    public String summary_contracted_SL2;
    public String summary_contracted_SL3;
    public String summary_contracted_SL4;
    public String summary_contracted_SL5;
    public String summary_contracted_SW1;
    public String summary_contracted_SW2;
    public String summary_contracted_SW3;
    public String summary_contracted_SW4;
    public String summary_contracted_SW5;
    public String prof_staff_explanation1;
    public String prof_staff_explanation2;
    public String prof_staff_explanation3;
    public String prof_staff_explanation4;
    public String prof_staff_explanation5;
    public String summary_contracted_HCA1;
    public String summary_contracted_HCA2;
    public String summary_contracted_HCA3;
    public String summary_contracted_HCA4;
    public String summary_contracted_HCA5;
    public String summary_contracted_LPN1;
    public String summary_contracted_LPN2;
    public String summary_contracted_LPN3;
    public String summary_contracted_LPN4;
    public String summary_contracted_LPN5;
    public String RN_LPN_staff_percentage1;
    public String RN_LPN_staff_percentage2;
    public String RN_LPN_staff_percentage3;
    public String RN_LPN_staff_percentage4;
    public String RN_LPN_staff_percentage5;
    public String alliedProf_annual_total1;
    public String alliedProf_annual_total2;
    public String alliedProf_annual_total3;
    public String alliedProf_annual_total4;
    public String alliedProf_annual_total5;
    public String summary_annual_nursingP1;
    public String summary_annual_nursingP2;
    public String summary_annual_nursingP3;
    public String summary_annual_nursingP4;
    public String summary_annual_nursingP5;
    public String summary_contracted_resp1;
    public String summary_contracted_resp2;
    public String summary_contracted_resp3;
    public String summary_contracted_resp4;
    public String summary_contracted_resp5;
    public String RN_LPN_staff_explanation1;
    public String RN_LPN_staff_explanation2;
    public String RN_LPN_staff_explanation3;
    public String RN_LPN_staff_explanation4;
    public String RN_LPN_staff_explanation5;
    public String summary_annual_nursingNP1;
    public String summary_annual_nursingNP2;
    public String summary_annual_nursingNP3;
    public String summary_annual_nursingNP4;
    public String summary_annual_nursingNP5;
    public String summary_inHouse_nursingP1;
    public String summary_inHouse_nursingP2;
    public String summary_inHouse_nursingP3;
    public String summary_inHouse_nursingP4;
    public String summary_inHouse_nursingP5;
    public String summary_annual_alliedProf1;
    public String summary_annual_alliedProf2;
    public String summary_annual_alliedProf3;
    public String summary_annual_alliedProf4;
    public String summary_annual_alliedProf5;
    public String summary_inHouse_nursingNP1;
    public String summary_inHouse_nursingNP2;
    public String summary_inHouse_nursingNP3;
    public String summary_inHouse_nursingNP4;
    public String summary_inHouse_nursingNP5;
    public String providerName_otherNursingP1;
    public String providerName_otherNursingP2;
    public String providerName_otherNursingP3;
    public String providerName_otherNursingP4;
    public String providerName_otherNursingP5;
    public String summary_annual_alliedNProf1;
    public String summary_annual_alliedNProf2;
    public String summary_annual_alliedNProf3;
    public String summary_annual_alliedNProf4;
    public String summary_annual_alliedNProf5;
    public String summary_inHouse_alliedProf1;
    public String summary_inHouse_alliedProf2;
    public String summary_inHouse_alliedProf3;
    public String summary_inHouse_alliedProf4;
    public String summary_inHouse_alliedProf5;
    public String contractedOut_otherNursingP1;
    public String contractedOut_otherNursingP2;
    public String contractedOut_otherNursingP3;
    public String contractedOut_otherNursingP4;
    public String contractedOut_otherNursingP5;
    public String percentageOut_otherNursingP1;
    public String percentageOut_otherNursingP2;
    public String percentageOut_otherNursingP3;
    public String percentageOut_otherNursingP4;
    public String percentageOut_otherNursingP5;
    public String providerName_otherNursingNP1;
    public String providerName_otherNursingNP2;
    public String providerName_otherNursingNP3;
    public String providerName_otherNursingNP4;
    public String providerName_otherNursingNP5;
    public String summary_contracted_nursingP1;
    public String summary_contracted_nursingP2;
    public String summary_contracted_nursingP3;
    public String summary_contracted_nursingP4;
    public String summary_contracted_nursingP5;
    public String summary_inHouse_alliedNProf1;
    public String summary_inHouse_alliedNProf2;
    public String summary_inHouse_alliedNProf3;
    public String summary_inHouse_alliedNProf4;
    public String summary_inHouse_alliedNProf5;
    public String contractedOut_otherNursingNP1;
    public String contractedOut_otherNursingNP2;
    public String contractedOut_otherNursingNP3;
    public String contractedOut_otherNursingNP4;
    public String contractedOut_otherNursingNP5;
    public String percentageOut_otherNursingNP1;
    public String percentageOut_otherNursingNP2;
    public String percentageOut_otherNursingNP3;
    public String percentageOut_otherNursingNP4;
    public String percentageOut_otherNursingNP5;
    public String providerName_otherAlliedProf1;
    public String providerName_otherAlliedProf2;
    public String providerName_otherAlliedProf3;
    public String providerName_otherAlliedProf4;
    public String providerName_otherAlliedProf5;
    public String summary_annual_otherNursingP1;
    public String summary_annual_otherNursingP2;
    public String summary_annual_otherNursingP3;
    public String summary_annual_otherNursingP4;
    public String summary_annual_otherNursingP5;
    public String summary_contracted_nursingNP1;
    public String summary_contracted_nursingNP2;
    public String summary_contracted_nursingNP3;
    public String summary_contracted_nursingNP4;
    public String summary_contracted_nursingNP5;
    public String contractedOut_otherAlliedProf1;
    public String contractedOut_otherAlliedProf2;
    public String contractedOut_otherAlliedProf3;
    public String contractedOut_otherAlliedProf4;
    public String contractedOut_otherAlliedProf5;
    public String percentageOut_otherAlliedProf1;
    public String percentageOut_otherAlliedProf2;
    public String percentageOut_otherAlliedProf3;
    public String percentageOut_otherAlliedProf4;
    public String percentageOut_otherAlliedProf5;
    public String providerName_otherAlliedNProf1;
    public String providerName_otherAlliedNProf2;
    public String providerName_otherAlliedNProf3;
    public String providerName_otherAlliedNProf4;
    public String providerName_otherAlliedNProf5;
    public String summary_annual_otherNursingNP1;
    public String summary_annual_otherNursingNP2;
    public String summary_annual_otherNursingNP3;
    public String summary_annual_otherNursingNP4;
    public String summary_annual_otherNursingNP5;
    public String summary_contracted_alliedProf1;
    public String summary_contracted_alliedProf2;
    public String summary_contracted_alliedProf3;
    public String summary_contracted_alliedProf4;
    public String summary_contracted_alliedProf5;
    public String summary_inHouse_otherNursingP1;
    public String summary_inHouse_otherNursingP2;
    public String summary_inHouse_otherNursingP3;
    public String summary_inHouse_otherNursingP4;
    public String summary_inHouse_otherNursingP5;
    public String contractedOut_otherAlliedNProf1;
    public String contractedOut_otherAlliedNProf2;
    public String contractedOut_otherAlliedNProf3;
    public String contractedOut_otherAlliedNProf4;
    public String contractedOut_otherAlliedNProf5;
    public String percentageOut_otherAlliedNProf1;
    public String percentageOut_otherAlliedNProf2;
    public String percentageOut_otherAlliedNProf3;
    public String percentageOut_otherAlliedNProf4;
    public String percentageOut_otherAlliedNProf5;
    public String summary_annual_otherAlliedProf1;
    public String summary_annual_otherAlliedProf2;
    public String summary_annual_otherAlliedProf3;
    public String summary_annual_otherAlliedProf4;
    public String summary_annual_otherAlliedProf5;
    public String summary_contracted_alliedNProf1;
    public String summary_contracted_alliedNProf2;
    public String summary_contracted_alliedNProf3;
    public String summary_contracted_alliedNProf4;
    public String summary_contracted_alliedNProf5;
    public String summary_inHouse_otherNursingNP1;
    public String summary_inHouse_otherNursingNP2;
    public String summary_inHouse_otherNursingNP3;
    public String summary_inHouse_otherNursingNP4;
    public String summary_inHouse_otherNursingNP5;
    public String summary_annual_otherAlliedNProf1;
    public String summary_annual_otherAlliedNProf2;
    public String summary_annual_otherAlliedNProf3;
    public String summary_annual_otherAlliedNProf4;
    public String summary_annual_otherAlliedNProf5;
    public String summary_inHouse_otherAlliedProf1;
    public String summary_inHouse_otherAlliedProf2;
    public String summary_inHouse_otherAlliedProf3;
    public String summary_inHouse_otherAlliedProf4;
    public String summary_inHouse_otherAlliedProf5;
    public String summary_contracted_otherNursingP1;
    public String summary_contracted_otherNursingP2;
    public String summary_contracted_otherNursingP3;
    public String summary_contracted_otherNursingP4;
    public String summary_contracted_otherNursingP5;
    public String summary_inHouse_otherAlliedNProf1;
    public String summary_inHouse_otherAlliedNProf2;
    public String summary_inHouse_otherAlliedNProf3;
    public String summary_inHouse_otherAlliedNProf4;
    public String summary_inHouse_otherAlliedNProf5;
    public String summary_contracted_otherNursingNP1;
    public String summary_contracted_otherNursingNP2;
    public String summary_contracted_otherNursingNP3;
    public String summary_contracted_otherNursingNP4;
    public String summary_contracted_otherNursingNP5;
    public String summary_contracted_otherAlliedProf1;
    public String summary_contracted_otherAlliedProf2;
    public String summary_contracted_otherAlliedProf3;
    public String summary_contracted_otherAlliedProf4;
    public String summary_contracted_otherAlliedProf5;
    public String summary_contracted_otherAlliedNProf1;
    public String summary_contracted_otherAlliedNProf2;
    public String summary_contracted_otherAlliedNProf3;
    public String summary_contracted_otherAlliedNProf4;
    public String summary_contracted_otherAlliedNProf5;
    public String doesTheStaffingPatternProvideNote1;
    public String doesTheStaffingPatternProvideNote2;
    public String doesTheStaffingPatternProvideNote3;
    public String doesTheStaffingPatternProvideNote4;
    public String doesTheStaffingPatternProvideNote5;
    public String rn_label1;
    public String lpn_label1;
    public String hca_label1;
    public String[] doesTheStaffingPatternProvide1;
    public String[] doesTheStaffingPatternProvide2;
    public String[] doesTheStaffingPatternProvide3;
    public String[] doesTheStaffingPatternProvide4;
    public String[] doesTheStaffingPatternProvide5;
    public ArrayList<NpDatagrid> npDatagrid1;
    public ArrayList<NpDatagrid> npDatagrid2;
    public ArrayList<NpDatagrid> npDatagrid3;
    public ArrayList<NpDatagrid> npDatagrid4;
    public ArrayList<NpDatagrid> npDatagrid5;
    public ArrayList<NnpDatagrid> nnpDatagrid1;
    public ArrayList<NnpDatagrid> nnpDatagrid2;
    public ArrayList<NnpDatagrid> nnpDatagrid3;
    public ArrayList<NnpDatagrid> nnpDatagrid4;
    public ArrayList<NnpDatagrid> nnpDatagrid5;
    public ArrayList<AldDatagrid> aldDatagrid1;
    public ArrayList<AldDatagrid> aldDatagrid2;
    public ArrayList<AldDatagrid> aldDatagrid3;
    public ArrayList<AldDatagrid> aldDatagrid4;
    public ArrayList<AldDatagrid> aldDatagrid5;
    public ArrayList<AldNopDatagrid> aldnopDatagrid1;
    public ArrayList<AldNopDatagrid> aldnopDatagrid2;
    public ArrayList<AldNopDatagrid> aldnopDatagrid3;
    public ArrayList<AldNopDatagrid> aldnopDatagrid4;
    public ArrayList<AldNopDatagrid> aldnopDatagrid5;
    public Form getForm() {
        return form;
    }
    public void setForm(Form form) {
        this.form = form;
    }
    public String getAdmin() {
        return admin;
    }
    public void setAdmin(String admin) {
        this.admin = admin;
    }
    public String getDCH_q11() {
        return DCH_q11;
    }
    public void setDCH_q11(String dCH_q11) {
        DCH_q11 = dCH_q11;
    }
    public String getDCH_q12() {
        return DCH_q12;
    }
    public void setDCH_q12(String dCH_q12) {
        DCH_q12 = dCH_q12;
    }
    public String getDCH_q13() {
        return DCH_q13;
    }
    public void setDCH_q13(String dCH_q13) {
        DCH_q13 = dCH_q13;
    }
    public String getDCH_q14() {
        return DCH_q14;
    }
    public void setDCH_q14(String dCH_q14) {
        DCH_q14 = dCH_q14;
    }
    public String getDCH_q15() {
        return DCH_q15;
    }
    public void setDCH_q15(String dCH_q15) {
        DCH_q15 = dCH_q15;
    }
    public String getDCH_q21() {
        return DCH_q21;
    }
    public void setDCH_q21(String dCH_q21) {
        DCH_q21 = dCH_q21;
    }
    public String getDCH_q22() {
        return DCH_q22;
    }
    public void setDCH_q22(String dCH_q22) {
        DCH_q22 = dCH_q22;
    }
    public String getDCH_q23() {
        return DCH_q23;
    }
    public void setDCH_q23(String dCH_q23) {
        DCH_q23 = dCH_q23;
    }
    public String getDCH_q24() {
        return DCH_q24;
    }
    public void setDCH_q24(String dCH_q24) {
        DCH_q24 = dCH_q24;
    }
    public String getDCH_q25() {
        return DCH_q25;
    }
    public void setDCH_q25(String dCH_q25) {
        DCH_q25 = dCH_q25;
    }
    public String getDCH_q31() {
        return DCH_q31;
    }
    public void setDCH_q31(String dCH_q31) {
        DCH_q31 = dCH_q31;
    }
    public String getDCH_q32() {
        return DCH_q32;
    }
    public void setDCH_q32(String dCH_q32) {
        DCH_q32 = dCH_q32;
    }
    public String getDCH_q33() {
        return DCH_q33;
    }
    public void setDCH_q33(String dCH_q33) {
        DCH_q33 = dCH_q33;
    }
    public String getDCH_q34() {
        return DCH_q34;
    }
    public void setDCH_q34(String dCH_q34) {
        DCH_q34 = dCH_q34;
    }
    public String getDCH_q35() {
        return DCH_q35;
    }
    public void setDCH_q35(String dCH_q35) {
        DCH_q35 = dCH_q35;
    }
    public String getDCH_q41() {
        return DCH_q41;
    }
    public void setDCH_q41(String dCH_q41) {
        DCH_q41 = dCH_q41;
    }
    public String getDCH_q42() {
        return DCH_q42;
    }
    public void setDCH_q42(String dCH_q42) {
        DCH_q42 = dCH_q42;
    }
    public String getDCH_q43() {
        return DCH_q43;
    }
    public void setDCH_q43(String dCH_q43) {
        DCH_q43 = dCH_q43;
    }
    public String getDCH_q44() {
        return DCH_q44;
    }
    public void setDCH_q44(String dCH_q44) {
        DCH_q44 = dCH_q44;
    }
    public String getDCH_q45() {
        return DCH_q45;
    }
    public void setDCH_q45(String dCH_q45) {
        DCH_q45 = dCH_q45;
    }
    public String getCcimsid() {
        return ccimsid;
    }
    public void setCcimsid(String ccimsid) {
        this.ccimsid = ccimsid;
    }
    public String getFiscalYear() {
        return fiscalYear;
    }
    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
    public String getLateEntry() {
        return lateEntry;
    }
    public void setLateEntry(String lateEntry) {
        this.lateEntry = lateEntry;
    }
    public String getRn_label1() {
        return rn_label1;
    }
    public void setRn_label1(String rn_label1) {
        this.rn_label1 = rn_label1;
    }
    public String getLpn_label1() {
        return lpn_label1;
    }
    public void setLpn_label1(String lpn_label1) {
        this.lpn_label1 = lpn_label1;
    }
    public String getHca_label1() {
        return hca_label1;
    }
    public void setHca_label1(String hca_label1) {
        this.hca_label1 = hca_label1;
    }
    public String getNp_label1() {
        return np_label1;
    }
    public void setNp_label1(String np_label1) {
        this.np_label1 = np_label1;
    }
    public String getNp_label2() {
        return np_label2;
    }
    public void setNp_label2(String np_label2) {
        this.np_label2 = np_label2;
    }
    public String getNp_label3() {
        return np_label3;
    }
    public void setNp_label3(String np_label3) {
        this.np_label3 = np_label3;
    }
    public String getNp_label4() {
        return np_label4;
    }
    public void setNp_label4(String np_label4) {
        this.np_label4 = np_label4;
    }
    public String getNp_label5() {
        return np_label5;
    }
    public void setNp_label5(String np_label5) {
        this.np_label5 = np_label5;
    }
    public String getDCH_total1() {
        return DCH_total1;
    }
    public void setDCH_total1(String dCH_total1) {
        DCH_total1 = dCH_total1;
    }
    public String getDCH_total2() {
        return DCH_total2;
    }
    public void setDCH_total2(String dCH_total2) {
        DCH_total2 = dCH_total2;
    }
    public String getDCH_total3() {
        return DCH_total3;
    }
    public void setDCH_total3(String dCH_total3) {
        DCH_total3 = dCH_total3;
    }
    public String getDCH_total4() {
        return DCH_total4;
    }
    public void setDCH_total4(String dCH_total4) {
        DCH_total4 = dCH_total4;
    }
    public String getDCH_total5() {
        return DCH_total5;
    }
    public void setDCH_total5(String dCH_total5) {
        DCH_total5 = dCH_total5;
    }
    public String getFri_total1() {
        return fri_total1;
    }
    public void setFri_total1(String fri_total1) {
        this.fri_total1 = fri_total1;
    }
    public String getFri_total2() {
        return fri_total2;
    }
    public void setFri_total2(String fri_total2) {
        this.fri_total2 = fri_total2;
    }
    public String getFri_total3() {
        return fri_total3;
    }
    public void setFri_total3(String fri_total3) {
        this.fri_total3 = fri_total3;
    }
    public String getFri_total4() {
        return fri_total4;
    }
    public void setFri_total4(String fri_total4) {
        this.fri_total4 = fri_total4;
    }
    public String getFri_total5() {
        return fri_total5;
    }
    public void setFri_total5(String fri_total5) {
        this.fri_total5 = fri_total5;
    }
    public String getMinimumRN1() {
        return minimumRN1;
    }
    public void setMinimumRN1(String minimumRN1) {
        this.minimumRN1 = minimumRN1;
    }
    public String getMinimumRN2() {
        return minimumRN2;
    }
    public void setMinimumRN2(String minimumRN2) {
        this.minimumRN2 = minimumRN2;
    }
    public String getMinimumRN3() {
        return minimumRN3;
    }
    public void setMinimumRN3(String minimumRN3) {
        this.minimumRN3 = minimumRN3;
    }
    public String getMinimumRN4() {
        return minimumRN4;
    }
    public void setMinimumRN4(String minimumRN4) {
        this.minimumRN4 = minimumRN4;
    }
    public String getMinimumRN5() {
        return minimumRN5;
    }
    public void setMinimumRN5(String minimumRN5) {
        this.minimumRN5 = minimumRN5;
    }
    public String getMon_total1() {
        return mon_total1;
    }
    public void setMon_total1(String mon_total1) {
        this.mon_total1 = mon_total1;
    }
    public String getMon_total2() {
        return mon_total2;
    }
    public void setMon_total2(String mon_total2) {
        this.mon_total2 = mon_total2;
    }
    public String getMon_total3() {
        return mon_total3;
    }
    public void setMon_total3(String mon_total3) {
        this.mon_total3 = mon_total3;
    }
    public String getMon_total4() {
        return mon_total4;
    }
    public void setMon_total4(String mon_total4) {
        this.mon_total4 = mon_total4;
    }
    public String getMon_total5() {
        return mon_total5;
    }
    public void setMon_total5(String mon_total5) {
        this.mon_total5 = mon_total5;
    }
    public String getNnp_label1() {
        return nnp_label1;
    }
    public void setNnp_label1(String nnp_label1) {
        this.nnp_label1 = nnp_label1;
    }
    public String getNnp_label2() {
        return nnp_label2;
    }
    public void setNnp_label2(String nnp_label2) {
        this.nnp_label2 = nnp_label2;
    }
    public String getNnp_label3() {
        return nnp_label3;
    }
    public void setNnp_label3(String nnp_label3) {
        this.nnp_label3 = nnp_label3;
    }
    public String getNnp_label4() {
        return nnp_label4;
    }
    public void setNnp_label4(String nnp_label4) {
        this.nnp_label4 = nnp_label4;
    }
    public String getNnp_label5() {
        return nnp_label5;
    }
    public void setNnp_label5(String nnp_label5) {
        this.nnp_label5 = nnp_label5;
    }
    public String getOther_mon1() {
        return other_mon1;
    }
    public void setOther_mon1(String other_mon1) {
        this.other_mon1 = other_mon1;
    }
    public String getOther_mon2() {
        return other_mon2;
    }
    public void setOther_mon2(String other_mon2) {
        this.other_mon2 = other_mon2;
    }
    public String getOther_mon3() {
        return other_mon3;
    }
    public void setOther_mon3(String other_mon3) {
        this.other_mon3 = other_mon3;
    }
    public String getOther_mon4() {
        return other_mon4;
    }
    public void setOther_mon4(String other_mon4) {
        this.other_mon4 = other_mon4;
    }
    public String getOther_mon5() {
        return other_mon5;
    }
    public void setOther_mon5(String other_mon5) {
        this.other_mon5 = other_mon5;
    }
    public String getSat_total1() {
        return sat_total1;
    }
    public void setSat_total1(String sat_total1) {
        this.sat_total1 = sat_total1;
    }
    public String getSat_total2() {
        return sat_total2;
    }
    public void setSat_total2(String sat_total2) {
        this.sat_total2 = sat_total2;
    }
    public String getSat_total3() {
        return sat_total3;
    }
    public void setSat_total3(String sat_total3) {
        this.sat_total3 = sat_total3;
    }
    public String getSat_total4() {
        return sat_total4;
    }
    public void setSat_total4(String sat_total4) {
        this.sat_total4 = sat_total4;
    }
    public String getSat_total5() {
        return sat_total5;
    }
    public void setSat_total5(String sat_total5) {
        this.sat_total5 = sat_total5;
    }
    public String getSun_total1() {
        return sun_total1;
    }
    public void setSun_total1(String sun_total1) {
        this.sun_total1 = sun_total1;
    }
    public String getSun_total2() {
        return sun_total2;
    }
    public void setSun_total2(String sun_total2) {
        this.sun_total2 = sun_total2;
    }
    public String getSun_total3() {
        return sun_total3;
    }
    public void setSun_total3(String sun_total3) {
        this.sun_total3 = sun_total3;
    }
    public String getSun_total4() {
        return sun_total4;
    }
    public void setSun_total4(String sun_total4) {
        this.sun_total4 = sun_total4;
    }
    public String getSun_total5() {
        return sun_total5;
    }
    public void setSun_total5(String sun_total5) {
        this.sun_total5 = sun_total5;
    }
    public String getThu_total1() {
        return thu_total1;
    }
    public void setThu_total1(String thu_total1) {
        this.thu_total1 = thu_total1;
    }
    public String getThu_total2() {
        return thu_total2;
    }
    public void setThu_total2(String thu_total2) {
        this.thu_total2 = thu_total2;
    }
    public String getThu_total3() {
        return thu_total3;
    }
    public void setThu_total3(String thu_total3) {
        this.thu_total3 = thu_total3;
    }
    public String getThu_total4() {
        return thu_total4;
    }
    public void setThu_total4(String thu_total4) {
        this.thu_total4 = thu_total4;
    }
    public String getThu_total5() {
        return thu_total5;
    }
    public void setThu_total5(String thu_total5) {
        this.thu_total5 = thu_total5;
    }
    public String getTue_total1() {
        return tue_total1;
    }
    public void setTue_total1(String tue_total1) {
        this.tue_total1 = tue_total1;
    }
    public String getTue_total2() {
        return tue_total2;
    }
    public void setTue_total2(String tue_total2) {
        this.tue_total2 = tue_total2;
    }
    public String getTue_total3() {
        return tue_total3;
    }
    public void setTue_total3(String tue_total3) {
        this.tue_total3 = tue_total3;
    }
    public String getTue_total4() {
        return tue_total4;
    }
    public void setTue_total4(String tue_total4) {
        this.tue_total4 = tue_total4;
    }
    public String getTue_total5() {
        return tue_total5;
    }
    public void setTue_total5(String tue_total5) {
        this.tue_total5 = tue_total5;
    }
    public String getWed_total1() {
        return wed_total1;
    }
    public void setWed_total1(String wed_total1) {
        this.wed_total1 = wed_total1;
    }
    public String getWed_total2() {
        return wed_total2;
    }
    public void setWed_total2(String wed_total2) {
        this.wed_total2 = wed_total2;
    }
    public String getWed_total3() {
        return wed_total3;
    }
    public void setWed_total3(String wed_total3) {
        this.wed_total3 = wed_total3;
    }
    public String getWed_total4() {
        return wed_total4;
    }
    public void setWed_total4(String wed_total4) {
        this.wed_total4 = wed_total4;
    }
    public String getWed_total5() {
        return wed_total5;
    }
    public void setWed_total5(String wed_total5) {
        this.wed_total5 = wed_total5;
    }
    public String getHPRD_total1() {
        return HPRD_total1;
    }
    public void setHPRD_total1(String hPRD_total1) {
        HPRD_total1 = hPRD_total1;
    }
    public String getHPRD_total2() {
        return HPRD_total2;
    }
    public void setHPRD_total2(String hPRD_total2) {
        HPRD_total2 = hPRD_total2;
    }
    public String getHPRD_total3() {
        return HPRD_total3;
    }
    public void setHPRD_total3(String hPRD_total3) {
        HPRD_total3 = hPRD_total3;
    }
    public String getHPRD_total4() {
        return HPRD_total4;
    }
    public void setHPRD_total4(String hPRD_total4) {
        HPRD_total4 = hPRD_total4;
    }
    public String getHPRD_total5() {
        return HPRD_total5;
    }
    public void setHPRD_total5(String hPRD_total5) {
        HPRD_total5 = hPRD_total5;
    }
    public String getAld_dt_fri1() {
        return ald_dt_fri1;
    }
    public void setAld_dt_fri1(String ald_dt_fri1) {
        this.ald_dt_fri1 = ald_dt_fri1;
    }
    public String getAld_dt_fri2() {
        return ald_dt_fri2;
    }
    public void setAld_dt_fri2(String ald_dt_fri2) {
        this.ald_dt_fri2 = ald_dt_fri2;
    }
    public String getAld_dt_fri3() {
        return ald_dt_fri3;
    }
    public void setAld_dt_fri3(String ald_dt_fri3) {
        this.ald_dt_fri3 = ald_dt_fri3;
    }
    public String getAld_dt_fri4() {
        return ald_dt_fri4;
    }
    public void setAld_dt_fri4(String ald_dt_fri4) {
        this.ald_dt_fri4 = ald_dt_fri4;
    }
    public String getAld_dt_fri5() {
        return ald_dt_fri5;
    }
    public void setAld_dt_fri5(String ald_dt_fri5) {
        this.ald_dt_fri5 = ald_dt_fri5;
    }
    public String getAld_dt_mon1() {
        return ald_dt_mon1;
    }
    public void setAld_dt_mon1(String ald_dt_mon1) {
        this.ald_dt_mon1 = ald_dt_mon1;
    }
    public String getAld_dt_mon2() {
        return ald_dt_mon2;
    }
    public void setAld_dt_mon2(String ald_dt_mon2) {
        this.ald_dt_mon2 = ald_dt_mon2;
    }
    public String getAld_dt_mon3() {
        return ald_dt_mon3;
    }
    public void setAld_dt_mon3(String ald_dt_mon3) {
        this.ald_dt_mon3 = ald_dt_mon3;
    }
    public String getAld_dt_mon4() {
        return ald_dt_mon4;
    }
    public void setAld_dt_mon4(String ald_dt_mon4) {
        this.ald_dt_mon4 = ald_dt_mon4;
    }
    public String getAld_dt_mon5() {
        return ald_dt_mon5;
    }
    public void setAld_dt_mon5(String ald_dt_mon5) {
        this.ald_dt_mon5 = ald_dt_mon5;
    }
    public String getAld_dt_sat1() {
        return ald_dt_sat1;
    }
    public void setAld_dt_sat1(String ald_dt_sat1) {
        this.ald_dt_sat1 = ald_dt_sat1;
    }
    public String getAld_dt_sat2() {
        return ald_dt_sat2;
    }
    public void setAld_dt_sat2(String ald_dt_sat2) {
        this.ald_dt_sat2 = ald_dt_sat2;
    }
    public String getAld_dt_sat3() {
        return ald_dt_sat3;
    }
    public void setAld_dt_sat3(String ald_dt_sat3) {
        this.ald_dt_sat3 = ald_dt_sat3;
    }
    public String getAld_dt_sat4() {
        return ald_dt_sat4;
    }
    public void setAld_dt_sat4(String ald_dt_sat4) {
        this.ald_dt_sat4 = ald_dt_sat4;
    }
    public String getAld_dt_sat5() {
        return ald_dt_sat5;
    }
    public void setAld_dt_sat5(String ald_dt_sat5) {
        this.ald_dt_sat5 = ald_dt_sat5;
    }
    public String getAld_dt_sun1() {
        return ald_dt_sun1;
    }
    public void setAld_dt_sun1(String ald_dt_sun1) {
        this.ald_dt_sun1 = ald_dt_sun1;
    }
    public String getAld_dt_sun2() {
        return ald_dt_sun2;
    }
    public void setAld_dt_sun2(String ald_dt_sun2) {
        this.ald_dt_sun2 = ald_dt_sun2;
    }
    public String getAld_dt_sun3() {
        return ald_dt_sun3;
    }
    public void setAld_dt_sun3(String ald_dt_sun3) {
        this.ald_dt_sun3 = ald_dt_sun3;
    }
    public String getAld_dt_sun4() {
        return ald_dt_sun4;
    }
    public void setAld_dt_sun4(String ald_dt_sun4) {
        this.ald_dt_sun4 = ald_dt_sun4;
    }
    public String getAld_dt_sun5() {
        return ald_dt_sun5;
    }
    public void setAld_dt_sun5(String ald_dt_sun5) {
        this.ald_dt_sun5 = ald_dt_sun5;
    }
    public String getAld_dt_thu1() {
        return ald_dt_thu1;
    }
    public void setAld_dt_thu1(String ald_dt_thu1) {
        this.ald_dt_thu1 = ald_dt_thu1;
    }
    public String getAld_dt_thu2() {
        return ald_dt_thu2;
    }
    public void setAld_dt_thu2(String ald_dt_thu2) {
        this.ald_dt_thu2 = ald_dt_thu2;
    }
    public String getAld_dt_thu3() {
        return ald_dt_thu3;
    }
    public void setAld_dt_thu3(String ald_dt_thu3) {
        this.ald_dt_thu3 = ald_dt_thu3;
    }
    public String getAld_dt_thu4() {
        return ald_dt_thu4;
    }
    public void setAld_dt_thu4(String ald_dt_thu4) {
        this.ald_dt_thu4 = ald_dt_thu4;
    }
    public String getAld_dt_thu5() {
        return ald_dt_thu5;
    }
    public void setAld_dt_thu5(String ald_dt_thu5) {
        this.ald_dt_thu5 = ald_dt_thu5;
    }
    public String getAld_dt_tue1() {
        return ald_dt_tue1;
    }
    public void setAld_dt_tue1(String ald_dt_tue1) {
        this.ald_dt_tue1 = ald_dt_tue1;
    }
    public String getAld_dt_tue2() {
        return ald_dt_tue2;
    }
    public void setAld_dt_tue2(String ald_dt_tue2) {
        this.ald_dt_tue2 = ald_dt_tue2;
    }
    public String getAld_dt_tue3() {
        return ald_dt_tue3;
    }
    public void setAld_dt_tue3(String ald_dt_tue3) {
        this.ald_dt_tue3 = ald_dt_tue3;
    }
    public String getAld_dt_tue4() {
        return ald_dt_tue4;
    }
    public void setAld_dt_tue4(String ald_dt_tue4) {
        this.ald_dt_tue4 = ald_dt_tue4;
    }
    public String getAld_dt_tue5() {
        return ald_dt_tue5;
    }
    public void setAld_dt_tue5(String ald_dt_tue5) {
        this.ald_dt_tue5 = ald_dt_tue5;
    }
    public String getAld_dt_wed1() {
        return ald_dt_wed1;
    }
    public void setAld_dt_wed1(String ald_dt_wed1) {
        this.ald_dt_wed1 = ald_dt_wed1;
    }
    public String getAld_dt_wed2() {
        return ald_dt_wed2;
    }
    public void setAld_dt_wed2(String ald_dt_wed2) {
        this.ald_dt_wed2 = ald_dt_wed2;
    }
    public String getAld_dt_wed3() {
        return ald_dt_wed3;
    }
    public void setAld_dt_wed3(String ald_dt_wed3) {
        this.ald_dt_wed3 = ald_dt_wed3;
    }
    public String getAld_dt_wed4() {
        return ald_dt_wed4;
    }
    public void setAld_dt_wed4(String ald_dt_wed4) {
        this.ald_dt_wed4 = ald_dt_wed4;
    }
    public String getAld_dt_wed5() {
        return ald_dt_wed5;
    }
    public void setAld_dt_wed5(String ald_dt_wed5) {
        this.ald_dt_wed5 = ald_dt_wed5;
    }
    public String getAld_ot_fri1() {
        return ald_ot_fri1;
    }
    public void setAld_ot_fri1(String ald_ot_fri1) {
        this.ald_ot_fri1 = ald_ot_fri1;
    }
    public String getAld_ot_fri2() {
        return ald_ot_fri2;
    }
    public void setAld_ot_fri2(String ald_ot_fri2) {
        this.ald_ot_fri2 = ald_ot_fri2;
    }
    public String getAld_ot_fri3() {
        return ald_ot_fri3;
    }
    public void setAld_ot_fri3(String ald_ot_fri3) {
        this.ald_ot_fri3 = ald_ot_fri3;
    }
    public String getAld_ot_fri4() {
        return ald_ot_fri4;
    }
    public void setAld_ot_fri4(String ald_ot_fri4) {
        this.ald_ot_fri4 = ald_ot_fri4;
    }
    public String getAld_ot_fri5() {
        return ald_ot_fri5;
    }
    public void setAld_ot_fri5(String ald_ot_fri5) {
        this.ald_ot_fri5 = ald_ot_fri5;
    }
    public String getAld_ot_mon1() {
        return ald_ot_mon1;
    }
    public void setAld_ot_mon1(String ald_ot_mon1) {
        this.ald_ot_mon1 = ald_ot_mon1;
    }
    public String getAld_ot_mon2() {
        return ald_ot_mon2;
    }
    public void setAld_ot_mon2(String ald_ot_mon2) {
        this.ald_ot_mon2 = ald_ot_mon2;
    }
    public String getAld_ot_mon3() {
        return ald_ot_mon3;
    }
    public void setAld_ot_mon3(String ald_ot_mon3) {
        this.ald_ot_mon3 = ald_ot_mon3;
    }
    public String getAld_ot_mon4() {
        return ald_ot_mon4;
    }
    public void setAld_ot_mon4(String ald_ot_mon4) {
        this.ald_ot_mon4 = ald_ot_mon4;
    }
    public String getAld_ot_mon5() {
        return ald_ot_mon5;
    }
    public void setAld_ot_mon5(String ald_ot_mon5) {
        this.ald_ot_mon5 = ald_ot_mon5;
    }
    public String getAld_ot_sat1() {
        return ald_ot_sat1;
    }
    public void setAld_ot_sat1(String ald_ot_sat1) {
        this.ald_ot_sat1 = ald_ot_sat1;
    }
    public String getAld_ot_sat2() {
        return ald_ot_sat2;
    }
    public void setAld_ot_sat2(String ald_ot_sat2) {
        this.ald_ot_sat2 = ald_ot_sat2;
    }
    public String getAld_ot_sat3() {
        return ald_ot_sat3;
    }
    public void setAld_ot_sat3(String ald_ot_sat3) {
        this.ald_ot_sat3 = ald_ot_sat3;
    }
    public String getAld_ot_sat4() {
        return ald_ot_sat4;
    }
    public void setAld_ot_sat4(String ald_ot_sat4) {
        this.ald_ot_sat4 = ald_ot_sat4;
    }
    public String getAld_ot_sat5() {
        return ald_ot_sat5;
    }
    public void setAld_ot_sat5(String ald_ot_sat5) {
        this.ald_ot_sat5 = ald_ot_sat5;
    }
    public String getAld_ot_sun1() {
        return ald_ot_sun1;
    }
    public void setAld_ot_sun1(String ald_ot_sun1) {
        this.ald_ot_sun1 = ald_ot_sun1;
    }
    public String getAld_ot_sun2() {
        return ald_ot_sun2;
    }
    public void setAld_ot_sun2(String ald_ot_sun2) {
        this.ald_ot_sun2 = ald_ot_sun2;
    }
    public String getAld_ot_sun3() {
        return ald_ot_sun3;
    }
    public void setAld_ot_sun3(String ald_ot_sun3) {
        this.ald_ot_sun3 = ald_ot_sun3;
    }
    public String getAld_ot_sun4() {
        return ald_ot_sun4;
    }
    public void setAld_ot_sun4(String ald_ot_sun4) {
        this.ald_ot_sun4 = ald_ot_sun4;
    }
    public String getAld_ot_sun5() {
        return ald_ot_sun5;
    }
    public void setAld_ot_sun5(String ald_ot_sun5) {
        this.ald_ot_sun5 = ald_ot_sun5;
    }
    public String getAld_ot_thu1() {
        return ald_ot_thu1;
    }
    public void setAld_ot_thu1(String ald_ot_thu1) {
        this.ald_ot_thu1 = ald_ot_thu1;
    }
    public String getAld_ot_thu2() {
        return ald_ot_thu2;
    }
    public void setAld_ot_thu2(String ald_ot_thu2) {
        this.ald_ot_thu2 = ald_ot_thu2;
    }
    public String getAld_ot_thu3() {
        return ald_ot_thu3;
    }
    public void setAld_ot_thu3(String ald_ot_thu3) {
        this.ald_ot_thu3 = ald_ot_thu3;
    }
    public String getAld_ot_thu4() {
        return ald_ot_thu4;
    }
    public void setAld_ot_thu4(String ald_ot_thu4) {
        this.ald_ot_thu4 = ald_ot_thu4;
    }
    public String getAld_ot_thu5() {
        return ald_ot_thu5;
    }
    public void setAld_ot_thu5(String ald_ot_thu5) {
        this.ald_ot_thu5 = ald_ot_thu5;
    }
    public String getAld_ot_tue1() {
        return ald_ot_tue1;
    }
    public void setAld_ot_tue1(String ald_ot_tue1) {
        this.ald_ot_tue1 = ald_ot_tue1;
    }
    public String getAld_ot_tue2() {
        return ald_ot_tue2;
    }
    public void setAld_ot_tue2(String ald_ot_tue2) {
        this.ald_ot_tue2 = ald_ot_tue2;
    }
    public String getAld_ot_tue3() {
        return ald_ot_tue3;
    }
    public void setAld_ot_tue3(String ald_ot_tue3) {
        this.ald_ot_tue3 = ald_ot_tue3;
    }
    public String getAld_ot_tue4() {
        return ald_ot_tue4;
    }
    public void setAld_ot_tue4(String ald_ot_tue4) {
        this.ald_ot_tue4 = ald_ot_tue4;
    }
    public String getAld_ot_tue5() {
        return ald_ot_tue5;
    }
    public void setAld_ot_tue5(String ald_ot_tue5) {
        this.ald_ot_tue5 = ald_ot_tue5;
    }
    public String getAld_ot_wed1() {
        return ald_ot_wed1;
    }
    public void setAld_ot_wed1(String ald_ot_wed1) {
        this.ald_ot_wed1 = ald_ot_wed1;
    }
    public String getAld_ot_wed2() {
        return ald_ot_wed2;
    }
    public void setAld_ot_wed2(String ald_ot_wed2) {
        this.ald_ot_wed2 = ald_ot_wed2;
    }
    public String getAld_ot_wed3() {
        return ald_ot_wed3;
    }
    public void setAld_ot_wed3(String ald_ot_wed3) {
        this.ald_ot_wed3 = ald_ot_wed3;
    }
    public String getAld_ot_wed4() {
        return ald_ot_wed4;
    }
    public void setAld_ot_wed4(String ald_ot_wed4) {
        this.ald_ot_wed4 = ald_ot_wed4;
    }
    public String getAld_ot_wed5() {
        return ald_ot_wed5;
    }
    public void setAld_ot_wed5(String ald_ot_wed5) {
        this.ald_ot_wed5 = ald_ot_wed5;
    }
    public String getAld_pt_fri1() {
        return ald_pt_fri1;
    }
    public void setAld_pt_fri1(String ald_pt_fri1) {
        this.ald_pt_fri1 = ald_pt_fri1;
    }
    public String getAld_pt_fri2() {
        return ald_pt_fri2;
    }
    public void setAld_pt_fri2(String ald_pt_fri2) {
        this.ald_pt_fri2 = ald_pt_fri2;
    }
    public String getAld_pt_fri3() {
        return ald_pt_fri3;
    }
    public void setAld_pt_fri3(String ald_pt_fri3) {
        this.ald_pt_fri3 = ald_pt_fri3;
    }
    public String getAld_pt_fri4() {
        return ald_pt_fri4;
    }
    public void setAld_pt_fri4(String ald_pt_fri4) {
        this.ald_pt_fri4 = ald_pt_fri4;
    }
    public String getAld_pt_fri5() {
        return ald_pt_fri5;
    }
    public void setAld_pt_fri5(String ald_pt_fri5) {
        this.ald_pt_fri5 = ald_pt_fri5;
    }
    public String getAld_pt_mon1() {
        return ald_pt_mon1;
    }
    public void setAld_pt_mon1(String ald_pt_mon1) {
        this.ald_pt_mon1 = ald_pt_mon1;
    }
    public String getAld_pt_mon2() {
        return ald_pt_mon2;
    }
    public void setAld_pt_mon2(String ald_pt_mon2) {
        this.ald_pt_mon2 = ald_pt_mon2;
    }
    public String getAld_pt_mon3() {
        return ald_pt_mon3;
    }
    public void setAld_pt_mon3(String ald_pt_mon3) {
        this.ald_pt_mon3 = ald_pt_mon3;
    }
    public String getAld_pt_mon4() {
        return ald_pt_mon4;
    }
    public void setAld_pt_mon4(String ald_pt_mon4) {
        this.ald_pt_mon4 = ald_pt_mon4;
    }
    public String getAld_pt_mon5() {
        return ald_pt_mon5;
    }
    public void setAld_pt_mon5(String ald_pt_mon5) {
        this.ald_pt_mon5 = ald_pt_mon5;
    }
    public String getAld_pt_sat1() {
        return ald_pt_sat1;
    }
    public void setAld_pt_sat1(String ald_pt_sat1) {
        this.ald_pt_sat1 = ald_pt_sat1;
    }
    public String getAld_pt_sat2() {
        return ald_pt_sat2;
    }
    public void setAld_pt_sat2(String ald_pt_sat2) {
        this.ald_pt_sat2 = ald_pt_sat2;
    }
    public String getAld_pt_sat3() {
        return ald_pt_sat3;
    }
    public void setAld_pt_sat3(String ald_pt_sat3) {
        this.ald_pt_sat3 = ald_pt_sat3;
    }
    public String getAld_pt_sat4() {
        return ald_pt_sat4;
    }
    public void setAld_pt_sat4(String ald_pt_sat4) {
        this.ald_pt_sat4 = ald_pt_sat4;
    }
    public String getAld_pt_sat5() {
        return ald_pt_sat5;
    }
    public void setAld_pt_sat5(String ald_pt_sat5) {
        this.ald_pt_sat5 = ald_pt_sat5;
    }
    public String getAld_pt_sun1() {
        return ald_pt_sun1;
    }
    public void setAld_pt_sun1(String ald_pt_sun1) {
        this.ald_pt_sun1 = ald_pt_sun1;
    }
    public String getAld_pt_sun2() {
        return ald_pt_sun2;
    }
    public void setAld_pt_sun2(String ald_pt_sun2) {
        this.ald_pt_sun2 = ald_pt_sun2;
    }
    public String getAld_pt_sun3() {
        return ald_pt_sun3;
    }
    public void setAld_pt_sun3(String ald_pt_sun3) {
        this.ald_pt_sun3 = ald_pt_sun3;
    }
    public String getAld_pt_sun4() {
        return ald_pt_sun4;
    }
    public void setAld_pt_sun4(String ald_pt_sun4) {
        this.ald_pt_sun4 = ald_pt_sun4;
    }
    public String getAld_pt_sun5() {
        return ald_pt_sun5;
    }
    public void setAld_pt_sun5(String ald_pt_sun5) {
        this.ald_pt_sun5 = ald_pt_sun5;
    }
    public String getAld_pt_thu1() {
        return ald_pt_thu1;
    }
    public void setAld_pt_thu1(String ald_pt_thu1) {
        this.ald_pt_thu1 = ald_pt_thu1;
    }
    public String getAld_pt_thu2() {
        return ald_pt_thu2;
    }
    public void setAld_pt_thu2(String ald_pt_thu2) {
        this.ald_pt_thu2 = ald_pt_thu2;
    }
    public String getAld_pt_thu3() {
        return ald_pt_thu3;
    }
    public void setAld_pt_thu3(String ald_pt_thu3) {
        this.ald_pt_thu3 = ald_pt_thu3;
    }
    public String getAld_pt_thu4() {
        return ald_pt_thu4;
    }
    public void setAld_pt_thu4(String ald_pt_thu4) {
        this.ald_pt_thu4 = ald_pt_thu4;
    }
    public String getAld_pt_thu5() {
        return ald_pt_thu5;
    }
    public void setAld_pt_thu5(String ald_pt_thu5) {
        this.ald_pt_thu5 = ald_pt_thu5;
    }
    public String getAld_pt_tue1() {
        return ald_pt_tue1;
    }
    public void setAld_pt_tue1(String ald_pt_tue1) {
        this.ald_pt_tue1 = ald_pt_tue1;
    }
    public String getAld_pt_tue2() {
        return ald_pt_tue2;
    }
    public void setAld_pt_tue2(String ald_pt_tue2) {
        this.ald_pt_tue2 = ald_pt_tue2;
    }
    public String getAld_pt_tue3() {
        return ald_pt_tue3;
    }
    public void setAld_pt_tue3(String ald_pt_tue3) {
        this.ald_pt_tue3 = ald_pt_tue3;
    }
    public String getAld_pt_tue4() {
        return ald_pt_tue4;
    }
    public void setAld_pt_tue4(String ald_pt_tue4) {
        this.ald_pt_tue4 = ald_pt_tue4;
    }
    public String getAld_pt_tue5() {
        return ald_pt_tue5;
    }
    public void setAld_pt_tue5(String ald_pt_tue5) {
        this.ald_pt_tue5 = ald_pt_tue5;
    }
    public String getAld_pt_wed1() {
        return ald_pt_wed1;
    }
    public void setAld_pt_wed1(String ald_pt_wed1) {
        this.ald_pt_wed1 = ald_pt_wed1;
    }
    public String getAld_pt_wed2() {
        return ald_pt_wed2;
    }
    public void setAld_pt_wed2(String ald_pt_wed2) {
        this.ald_pt_wed2 = ald_pt_wed2;
    }
    public String getAld_pt_wed3() {
        return ald_pt_wed3;
    }
    public void setAld_pt_wed3(String ald_pt_wed3) {
        this.ald_pt_wed3 = ald_pt_wed3;
    }
    public String getAld_pt_wed4() {
        return ald_pt_wed4;
    }
    public void setAld_pt_wed4(String ald_pt_wed4) {
        this.ald_pt_wed4 = ald_pt_wed4;
    }
    public String getAld_pt_wed5() {
        return ald_pt_wed5;
    }
    public void setAld_pt_wed5(String ald_pt_wed5) {
        this.ald_pt_wed5 = ald_pt_wed5;
    }
    public String getAld_rt_fri1() {
        return ald_rt_fri1;
    }
    public void setAld_rt_fri1(String ald_rt_fri1) {
        this.ald_rt_fri1 = ald_rt_fri1;
    }
    public String getAld_rt_fri2() {
        return ald_rt_fri2;
    }
    public void setAld_rt_fri2(String ald_rt_fri2) {
        this.ald_rt_fri2 = ald_rt_fri2;
    }
    public String getAld_rt_fri3() {
        return ald_rt_fri3;
    }
    public void setAld_rt_fri3(String ald_rt_fri3) {
        this.ald_rt_fri3 = ald_rt_fri3;
    }
    public String getAld_rt_fri4() {
        return ald_rt_fri4;
    }
    public void setAld_rt_fri4(String ald_rt_fri4) {
        this.ald_rt_fri4 = ald_rt_fri4;
    }
    public String getAld_rt_fri5() {
        return ald_rt_fri5;
    }
    public void setAld_rt_fri5(String ald_rt_fri5) {
        this.ald_rt_fri5 = ald_rt_fri5;
    }
    public String getAld_rt_mon1() {
        return ald_rt_mon1;
    }
    public void setAld_rt_mon1(String ald_rt_mon1) {
        this.ald_rt_mon1 = ald_rt_mon1;
    }
    public String getAld_rt_mon2() {
        return ald_rt_mon2;
    }
    public void setAld_rt_mon2(String ald_rt_mon2) {
        this.ald_rt_mon2 = ald_rt_mon2;
    }
    public String getAld_rt_mon3() {
        return ald_rt_mon3;
    }
    public void setAld_rt_mon3(String ald_rt_mon3) {
        this.ald_rt_mon3 = ald_rt_mon3;
    }
    public String getAld_rt_mon4() {
        return ald_rt_mon4;
    }
    public void setAld_rt_mon4(String ald_rt_mon4) {
        this.ald_rt_mon4 = ald_rt_mon4;
    }
    public String getAld_rt_mon5() {
        return ald_rt_mon5;
    }
    public void setAld_rt_mon5(String ald_rt_mon5) {
        this.ald_rt_mon5 = ald_rt_mon5;
    }
    public String getAld_rt_sat1() {
        return ald_rt_sat1;
    }
    public void setAld_rt_sat1(String ald_rt_sat1) {
        this.ald_rt_sat1 = ald_rt_sat1;
    }
    public String getAld_rt_sat2() {
        return ald_rt_sat2;
    }
    public void setAld_rt_sat2(String ald_rt_sat2) {
        this.ald_rt_sat2 = ald_rt_sat2;
    }
    public String getAld_rt_sat3() {
        return ald_rt_sat3;
    }
    public void setAld_rt_sat3(String ald_rt_sat3) {
        this.ald_rt_sat3 = ald_rt_sat3;
    }
    public String getAld_rt_sat4() {
        return ald_rt_sat4;
    }
    public void setAld_rt_sat4(String ald_rt_sat4) {
        this.ald_rt_sat4 = ald_rt_sat4;
    }
    public String getAld_rt_sat5() {
        return ald_rt_sat5;
    }
    public void setAld_rt_sat5(String ald_rt_sat5) {
        this.ald_rt_sat5 = ald_rt_sat5;
    }
    public String getAld_rt_sun1() {
        return ald_rt_sun1;
    }
    public void setAld_rt_sun1(String ald_rt_sun1) {
        this.ald_rt_sun1 = ald_rt_sun1;
    }
    public String getAld_rt_sun2() {
        return ald_rt_sun2;
    }
    public void setAld_rt_sun2(String ald_rt_sun2) {
        this.ald_rt_sun2 = ald_rt_sun2;
    }
    public String getAld_rt_sun3() {
        return ald_rt_sun3;
    }
    public void setAld_rt_sun3(String ald_rt_sun3) {
        this.ald_rt_sun3 = ald_rt_sun3;
    }
    public String getAld_rt_sun4() {
        return ald_rt_sun4;
    }
    public void setAld_rt_sun4(String ald_rt_sun4) {
        this.ald_rt_sun4 = ald_rt_sun4;
    }
    public String getAld_rt_sun5() {
        return ald_rt_sun5;
    }
    public void setAld_rt_sun5(String ald_rt_sun5) {
        this.ald_rt_sun5 = ald_rt_sun5;
    }
    public String getAld_rt_thu1() {
        return ald_rt_thu1;
    }
    public void setAld_rt_thu1(String ald_rt_thu1) {
        this.ald_rt_thu1 = ald_rt_thu1;
    }
    public String getAld_rt_thu2() {
        return ald_rt_thu2;
    }
    public void setAld_rt_thu2(String ald_rt_thu2) {
        this.ald_rt_thu2 = ald_rt_thu2;
    }
    public String getAld_rt_thu3() {
        return ald_rt_thu3;
    }
    public void setAld_rt_thu3(String ald_rt_thu3) {
        this.ald_rt_thu3 = ald_rt_thu3;
    }
    public String getAld_rt_thu4() {
        return ald_rt_thu4;
    }
    public void setAld_rt_thu4(String ald_rt_thu4) {
        this.ald_rt_thu4 = ald_rt_thu4;
    }
    public String getAld_rt_thu5() {
        return ald_rt_thu5;
    }
    public void setAld_rt_thu5(String ald_rt_thu5) {
        this.ald_rt_thu5 = ald_rt_thu5;
    }
    public String getAld_rt_tue1() {
        return ald_rt_tue1;
    }
    public void setAld_rt_tue1(String ald_rt_tue1) {
        this.ald_rt_tue1 = ald_rt_tue1;
    }
    public String getAld_rt_tue2() {
        return ald_rt_tue2;
    }
    public void setAld_rt_tue2(String ald_rt_tue2) {
        this.ald_rt_tue2 = ald_rt_tue2;
    }
    public String getAld_rt_tue3() {
        return ald_rt_tue3;
    }
    public void setAld_rt_tue3(String ald_rt_tue3) {
        this.ald_rt_tue3 = ald_rt_tue3;
    }
    public String getAld_rt_tue4() {
        return ald_rt_tue4;
    }
    public void setAld_rt_tue4(String ald_rt_tue4) {
        this.ald_rt_tue4 = ald_rt_tue4;
    }
    public String getAld_rt_tue5() {
        return ald_rt_tue5;
    }
    public void setAld_rt_tue5(String ald_rt_tue5) {
        this.ald_rt_tue5 = ald_rt_tue5;
    }
    public String getAld_rt_wed1() {
        return ald_rt_wed1;
    }
    public void setAld_rt_wed1(String ald_rt_wed1) {
        this.ald_rt_wed1 = ald_rt_wed1;
    }
    public String getAld_rt_wed2() {
        return ald_rt_wed2;
    }
    public void setAld_rt_wed2(String ald_rt_wed2) {
        this.ald_rt_wed2 = ald_rt_wed2;
    }
    public String getAld_rt_wed3() {
        return ald_rt_wed3;
    }
    public void setAld_rt_wed3(String ald_rt_wed3) {
        this.ald_rt_wed3 = ald_rt_wed3;
    }
    public String getAld_rt_wed4() {
        return ald_rt_wed4;
    }
    public void setAld_rt_wed4(String ald_rt_wed4) {
        this.ald_rt_wed4 = ald_rt_wed4;
    }
    public String getAld_rt_wed5() {
        return ald_rt_wed5;
    }
    public void setAld_rt_wed5(String ald_rt_wed5) {
        this.ald_rt_wed5 = ald_rt_wed5;
    }
    public String getAld_sp_fri1() {
        return ald_sp_fri1;
    }
    public void setAld_sp_fri1(String ald_sp_fri1) {
        this.ald_sp_fri1 = ald_sp_fri1;
    }
    public String getAld_sp_fri2() {
        return ald_sp_fri2;
    }
    public void setAld_sp_fri2(String ald_sp_fri2) {
        this.ald_sp_fri2 = ald_sp_fri2;
    }
    public String getAld_sp_fri3() {
        return ald_sp_fri3;
    }
    public void setAld_sp_fri3(String ald_sp_fri3) {
        this.ald_sp_fri3 = ald_sp_fri3;
    }
    public String getAld_sp_fri4() {
        return ald_sp_fri4;
    }
    public void setAld_sp_fri4(String ald_sp_fri4) {
        this.ald_sp_fri4 = ald_sp_fri4;
    }
    public String getAld_sp_fri5() {
        return ald_sp_fri5;
    }
    public void setAld_sp_fri5(String ald_sp_fri5) {
        this.ald_sp_fri5 = ald_sp_fri5;
    }
    public String getAld_sp_mon1() {
        return ald_sp_mon1;
    }
    public void setAld_sp_mon1(String ald_sp_mon1) {
        this.ald_sp_mon1 = ald_sp_mon1;
    }
    public String getAld_sp_mon2() {
        return ald_sp_mon2;
    }
    public void setAld_sp_mon2(String ald_sp_mon2) {
        this.ald_sp_mon2 = ald_sp_mon2;
    }
    public String getAld_sp_mon3() {
        return ald_sp_mon3;
    }
    public void setAld_sp_mon3(String ald_sp_mon3) {
        this.ald_sp_mon3 = ald_sp_mon3;
    }
    public String getAld_sp_mon4() {
        return ald_sp_mon4;
    }
    public void setAld_sp_mon4(String ald_sp_mon4) {
        this.ald_sp_mon4 = ald_sp_mon4;
    }
    public String getAld_sp_mon5() {
        return ald_sp_mon5;
    }
    public void setAld_sp_mon5(String ald_sp_mon5) {
        this.ald_sp_mon5 = ald_sp_mon5;
    }
    public String getAld_sp_sat1() {
        return ald_sp_sat1;
    }
    public void setAld_sp_sat1(String ald_sp_sat1) {
        this.ald_sp_sat1 = ald_sp_sat1;
    }
    public String getAld_sp_sat2() {
        return ald_sp_sat2;
    }
    public void setAld_sp_sat2(String ald_sp_sat2) {
        this.ald_sp_sat2 = ald_sp_sat2;
    }
    public String getAld_sp_sat3() {
        return ald_sp_sat3;
    }
    public void setAld_sp_sat3(String ald_sp_sat3) {
        this.ald_sp_sat3 = ald_sp_sat3;
    }
    public String getAld_sp_sat4() {
        return ald_sp_sat4;
    }
    public void setAld_sp_sat4(String ald_sp_sat4) {
        this.ald_sp_sat4 = ald_sp_sat4;
    }
    public String getAld_sp_sat5() {
        return ald_sp_sat5;
    }
    public void setAld_sp_sat5(String ald_sp_sat5) {
        this.ald_sp_sat5 = ald_sp_sat5;
    }
    public String getAld_sp_sun1() {
        return ald_sp_sun1;
    }
    public void setAld_sp_sun1(String ald_sp_sun1) {
        this.ald_sp_sun1 = ald_sp_sun1;
    }
    public String getAld_sp_sun2() {
        return ald_sp_sun2;
    }
    public void setAld_sp_sun2(String ald_sp_sun2) {
        this.ald_sp_sun2 = ald_sp_sun2;
    }
    public String getAld_sp_sun3() {
        return ald_sp_sun3;
    }
    public void setAld_sp_sun3(String ald_sp_sun3) {
        this.ald_sp_sun3 = ald_sp_sun3;
    }
    public String getAld_sp_sun4() {
        return ald_sp_sun4;
    }
    public void setAld_sp_sun4(String ald_sp_sun4) {
        this.ald_sp_sun4 = ald_sp_sun4;
    }
    public String getAld_sp_sun5() {
        return ald_sp_sun5;
    }
    public void setAld_sp_sun5(String ald_sp_sun5) {
        this.ald_sp_sun5 = ald_sp_sun5;
    }
    public String getAld_sp_thu1() {
        return ald_sp_thu1;
    }
    public void setAld_sp_thu1(String ald_sp_thu1) {
        this.ald_sp_thu1 = ald_sp_thu1;
    }
    public String getAld_sp_thu2() {
        return ald_sp_thu2;
    }
    public void setAld_sp_thu2(String ald_sp_thu2) {
        this.ald_sp_thu2 = ald_sp_thu2;
    }
    public String getAld_sp_thu3() {
        return ald_sp_thu3;
    }
    public void setAld_sp_thu3(String ald_sp_thu3) {
        this.ald_sp_thu3 = ald_sp_thu3;
    }
    public String getAld_sp_thu4() {
        return ald_sp_thu4;
    }
    public void setAld_sp_thu4(String ald_sp_thu4) {
        this.ald_sp_thu4 = ald_sp_thu4;
    }
    public String getAld_sp_thu5() {
        return ald_sp_thu5;
    }
    public void setAld_sp_thu5(String ald_sp_thu5) {
        this.ald_sp_thu5 = ald_sp_thu5;
    }
    public String getAld_sp_tue1() {
        return ald_sp_tue1;
    }
    public void setAld_sp_tue1(String ald_sp_tue1) {
        this.ald_sp_tue1 = ald_sp_tue1;
    }
    public String getAld_sp_tue2() {
        return ald_sp_tue2;
    }
    public void setAld_sp_tue2(String ald_sp_tue2) {
        this.ald_sp_tue2 = ald_sp_tue2;
    }
    public String getAld_sp_tue3() {
        return ald_sp_tue3;
    }
    public void setAld_sp_tue3(String ald_sp_tue3) {
        this.ald_sp_tue3 = ald_sp_tue3;
    }
    public String getAld_sp_tue4() {
        return ald_sp_tue4;
    }
    public void setAld_sp_tue4(String ald_sp_tue4) {
        this.ald_sp_tue4 = ald_sp_tue4;
    }
    public String getAld_sp_tue5() {
        return ald_sp_tue5;
    }
    public void setAld_sp_tue5(String ald_sp_tue5) {
        this.ald_sp_tue5 = ald_sp_tue5;
    }
    public String getAld_sp_wed1() {
        return ald_sp_wed1;
    }
    public void setAld_sp_wed1(String ald_sp_wed1) {
        this.ald_sp_wed1 = ald_sp_wed1;
    }
    public String getAld_sp_wed2() {
        return ald_sp_wed2;
    }
    public void setAld_sp_wed2(String ald_sp_wed2) {
        this.ald_sp_wed2 = ald_sp_wed2;
    }
    public String getAld_sp_wed3() {
        return ald_sp_wed3;
    }
    public void setAld_sp_wed3(String ald_sp_wed3) {
        this.ald_sp_wed3 = ald_sp_wed3;
    }
    public String getAld_sp_wed4() {
        return ald_sp_wed4;
    }
    public void setAld_sp_wed4(String ald_sp_wed4) {
        this.ald_sp_wed4 = ald_sp_wed4;
    }
    public String getAld_sp_wed5() {
        return ald_sp_wed5;
    }
    public void setAld_sp_wed5(String ald_sp_wed5) {
        this.ald_sp_wed5 = ald_sp_wed5;
    }
    public String getAld_sw_fri1() {
        return ald_sw_fri1;
    }
    public void setAld_sw_fri1(String ald_sw_fri1) {
        this.ald_sw_fri1 = ald_sw_fri1;
    }
    public String getAld_sw_fri2() {
        return ald_sw_fri2;
    }
    public void setAld_sw_fri2(String ald_sw_fri2) {
        this.ald_sw_fri2 = ald_sw_fri2;
    }
    public String getAld_sw_fri3() {
        return ald_sw_fri3;
    }
    public void setAld_sw_fri3(String ald_sw_fri3) {
        this.ald_sw_fri3 = ald_sw_fri3;
    }
    public String getAld_sw_fri4() {
        return ald_sw_fri4;
    }
    public void setAld_sw_fri4(String ald_sw_fri4) {
        this.ald_sw_fri4 = ald_sw_fri4;
    }
    public String getAld_sw_fri5() {
        return ald_sw_fri5;
    }
    public void setAld_sw_fri5(String ald_sw_fri5) {
        this.ald_sw_fri5 = ald_sw_fri5;
    }
    public String getAld_sw_mon1() {
        return ald_sw_mon1;
    }
    public void setAld_sw_mon1(String ald_sw_mon1) {
        this.ald_sw_mon1 = ald_sw_mon1;
    }
    public String getAld_sw_mon2() {
        return ald_sw_mon2;
    }
    public void setAld_sw_mon2(String ald_sw_mon2) {
        this.ald_sw_mon2 = ald_sw_mon2;
    }
    public String getAld_sw_mon3() {
        return ald_sw_mon3;
    }
    public void setAld_sw_mon3(String ald_sw_mon3) {
        this.ald_sw_mon3 = ald_sw_mon3;
    }
    public String getAld_sw_mon4() {
        return ald_sw_mon4;
    }
    public void setAld_sw_mon4(String ald_sw_mon4) {
        this.ald_sw_mon4 = ald_sw_mon4;
    }
    public String getAld_sw_mon5() {
        return ald_sw_mon5;
    }
    public void setAld_sw_mon5(String ald_sw_mon5) {
        this.ald_sw_mon5 = ald_sw_mon5;
    }
    public String getAld_sw_sat1() {
        return ald_sw_sat1;
    }
    public void setAld_sw_sat1(String ald_sw_sat1) {
        this.ald_sw_sat1 = ald_sw_sat1;
    }
    public String getAld_sw_sat2() {
        return ald_sw_sat2;
    }
    public void setAld_sw_sat2(String ald_sw_sat2) {
        this.ald_sw_sat2 = ald_sw_sat2;
    }
    public String getAld_sw_sat3() {
        return ald_sw_sat3;
    }
    public void setAld_sw_sat3(String ald_sw_sat3) {
        this.ald_sw_sat3 = ald_sw_sat3;
    }
    public String getAld_sw_sat4() {
        return ald_sw_sat4;
    }
    public void setAld_sw_sat4(String ald_sw_sat4) {
        this.ald_sw_sat4 = ald_sw_sat4;
    }
    public String getAld_sw_sat5() {
        return ald_sw_sat5;
    }
    public void setAld_sw_sat5(String ald_sw_sat5) {
        this.ald_sw_sat5 = ald_sw_sat5;
    }
    public String getAld_sw_sun1() {
        return ald_sw_sun1;
    }
    public void setAld_sw_sun1(String ald_sw_sun1) {
        this.ald_sw_sun1 = ald_sw_sun1;
    }
    public String getAld_sw_sun2() {
        return ald_sw_sun2;
    }
    public void setAld_sw_sun2(String ald_sw_sun2) {
        this.ald_sw_sun2 = ald_sw_sun2;
    }
    public String getAld_sw_sun3() {
        return ald_sw_sun3;
    }
    public void setAld_sw_sun3(String ald_sw_sun3) {
        this.ald_sw_sun3 = ald_sw_sun3;
    }
    public String getAld_sw_sun4() {
        return ald_sw_sun4;
    }
    public void setAld_sw_sun4(String ald_sw_sun4) {
        this.ald_sw_sun4 = ald_sw_sun4;
    }
    public String getAld_sw_sun5() {
        return ald_sw_sun5;
    }
    public void setAld_sw_sun5(String ald_sw_sun5) {
        this.ald_sw_sun5 = ald_sw_sun5;
    }
    public String getAld_sw_thu1() {
        return ald_sw_thu1;
    }
    public void setAld_sw_thu1(String ald_sw_thu1) {
        this.ald_sw_thu1 = ald_sw_thu1;
    }
    public String getAld_sw_thu2() {
        return ald_sw_thu2;
    }
    public void setAld_sw_thu2(String ald_sw_thu2) {
        this.ald_sw_thu2 = ald_sw_thu2;
    }
    public String getAld_sw_thu3() {
        return ald_sw_thu3;
    }
    public void setAld_sw_thu3(String ald_sw_thu3) {
        this.ald_sw_thu3 = ald_sw_thu3;
    }
    public String getAld_sw_thu4() {
        return ald_sw_thu4;
    }
    public void setAld_sw_thu4(String ald_sw_thu4) {
        this.ald_sw_thu4 = ald_sw_thu4;
    }
    public String getAld_sw_thu5() {
        return ald_sw_thu5;
    }
    public void setAld_sw_thu5(String ald_sw_thu5) {
        this.ald_sw_thu5 = ald_sw_thu5;
    }
    public String getAld_sw_tue1() {
        return ald_sw_tue1;
    }
    public void setAld_sw_tue1(String ald_sw_tue1) {
        this.ald_sw_tue1 = ald_sw_tue1;
    }
    public String getAld_sw_tue2() {
        return ald_sw_tue2;
    }
    public void setAld_sw_tue2(String ald_sw_tue2) {
        this.ald_sw_tue2 = ald_sw_tue2;
    }
    public String getAld_sw_tue3() {
        return ald_sw_tue3;
    }
    public void setAld_sw_tue3(String ald_sw_tue3) {
        this.ald_sw_tue3 = ald_sw_tue3;
    }
    public String getAld_sw_tue4() {
        return ald_sw_tue4;
    }
    public void setAld_sw_tue4(String ald_sw_tue4) {
        this.ald_sw_tue4 = ald_sw_tue4;
    }
    public String getAld_sw_tue5() {
        return ald_sw_tue5;
    }
    public void setAld_sw_tue5(String ald_sw_tue5) {
        this.ald_sw_tue5 = ald_sw_tue5;
    }
    public String getAld_sw_wed1() {
        return ald_sw_wed1;
    }
    public void setAld_sw_wed1(String ald_sw_wed1) {
        this.ald_sw_wed1 = ald_sw_wed1;
    }
    public String getAld_sw_wed2() {
        return ald_sw_wed2;
    }
    public void setAld_sw_wed2(String ald_sw_wed2) {
        this.ald_sw_wed2 = ald_sw_wed2;
    }
    public String getAld_sw_wed3() {
        return ald_sw_wed3;
    }
    public void setAld_sw_wed3(String ald_sw_wed3) {
        this.ald_sw_wed3 = ald_sw_wed3;
    }
    public String getAld_sw_wed4() {
        return ald_sw_wed4;
    }
    public void setAld_sw_wed4(String ald_sw_wed4) {
        this.ald_sw_wed4 = ald_sw_wed4;
    }
    public String getAld_sw_wed5() {
        return ald_sw_wed5;
    }
    public void setAld_sw_wed5(String ald_sw_wed5) {
        this.ald_sw_wed5 = ald_sw_wed5;
    }
    public String getRn_day_fri1() {
        return rn_day_fri1;
    }
    public void setRn_day_fri1(String rn_day_fri1) {
        this.rn_day_fri1 = rn_day_fri1;
    }
    public String getRn_day_fri2() {
        return rn_day_fri2;
    }
    public void setRn_day_fri2(String rn_day_fri2) {
        this.rn_day_fri2 = rn_day_fri2;
    }
    public String getRn_day_fri3() {
        return rn_day_fri3;
    }
    public void setRn_day_fri3(String rn_day_fri3) {
        this.rn_day_fri3 = rn_day_fri3;
    }
    public String getRn_day_fri4() {
        return rn_day_fri4;
    }
    public void setRn_day_fri4(String rn_day_fri4) {
        this.rn_day_fri4 = rn_day_fri4;
    }
    public String getRn_day_fri5() {
        return rn_day_fri5;
    }
    public void setRn_day_fri5(String rn_day_fri5) {
        this.rn_day_fri5 = rn_day_fri5;
    }
    public String getRn_day_mon1() {
        return rn_day_mon1;
    }
    public void setRn_day_mon1(String rn_day_mon1) {
        this.rn_day_mon1 = rn_day_mon1;
    }
    public String getRn_day_mon2() {
        return rn_day_mon2;
    }
    public void setRn_day_mon2(String rn_day_mon2) {
        this.rn_day_mon2 = rn_day_mon2;
    }
    public String getRn_day_mon3() {
        return rn_day_mon3;
    }
    public void setRn_day_mon3(String rn_day_mon3) {
        this.rn_day_mon3 = rn_day_mon3;
    }
    public String getRn_day_mon4() {
        return rn_day_mon4;
    }
    public void setRn_day_mon4(String rn_day_mon4) {
        this.rn_day_mon4 = rn_day_mon4;
    }
    public String getRn_day_mon5() {
        return rn_day_mon5;
    }
    public void setRn_day_mon5(String rn_day_mon5) {
        this.rn_day_mon5 = rn_day_mon5;
    }
    public String getRn_day_sat1() {
        return rn_day_sat1;
    }
    public void setRn_day_sat1(String rn_day_sat1) {
        this.rn_day_sat1 = rn_day_sat1;
    }
    public String getRn_day_sat2() {
        return rn_day_sat2;
    }
    public void setRn_day_sat2(String rn_day_sat2) {
        this.rn_day_sat2 = rn_day_sat2;
    }
    public String getRn_day_sat3() {
        return rn_day_sat3;
    }
    public void setRn_day_sat3(String rn_day_sat3) {
        this.rn_day_sat3 = rn_day_sat3;
    }
    public String getRn_day_sat4() {
        return rn_day_sat4;
    }
    public void setRn_day_sat4(String rn_day_sat4) {
        this.rn_day_sat4 = rn_day_sat4;
    }
    public String getRn_day_sat5() {
        return rn_day_sat5;
    }
    public void setRn_day_sat5(String rn_day_sat5) {
        this.rn_day_sat5 = rn_day_sat5;
    }
    public String getRn_day_sun1() {
        return rn_day_sun1;
    }
    public void setRn_day_sun1(String rn_day_sun1) {
        this.rn_day_sun1 = rn_day_sun1;
    }
    public String getRn_day_sun2() {
        return rn_day_sun2;
    }
    public void setRn_day_sun2(String rn_day_sun2) {
        this.rn_day_sun2 = rn_day_sun2;
    }
    public String getRn_day_sun3() {
        return rn_day_sun3;
    }
    public void setRn_day_sun3(String rn_day_sun3) {
        this.rn_day_sun3 = rn_day_sun3;
    }
    public String getRn_day_sun4() {
        return rn_day_sun4;
    }
    public void setRn_day_sun4(String rn_day_sun4) {
        this.rn_day_sun4 = rn_day_sun4;
    }
    public String getRn_day_sun5() {
        return rn_day_sun5;
    }
    public void setRn_day_sun5(String rn_day_sun5) {
        this.rn_day_sun5 = rn_day_sun5;
    }
    public String getRn_day_thu1() {
        return rn_day_thu1;
    }
    public void setRn_day_thu1(String rn_day_thu1) {
        this.rn_day_thu1 = rn_day_thu1;
    }
    public String getRn_day_thu2() {
        return rn_day_thu2;
    }
    public void setRn_day_thu2(String rn_day_thu2) {
        this.rn_day_thu2 = rn_day_thu2;
    }
    public String getRn_day_thu3() {
        return rn_day_thu3;
    }
    public void setRn_day_thu3(String rn_day_thu3) {
        this.rn_day_thu3 = rn_day_thu3;
    }
    public String getRn_day_thu4() {
        return rn_day_thu4;
    }
    public void setRn_day_thu4(String rn_day_thu4) {
        this.rn_day_thu4 = rn_day_thu4;
    }
    public String getRn_day_thu5() {
        return rn_day_thu5;
    }
    public void setRn_day_thu5(String rn_day_thu5) {
        this.rn_day_thu5 = rn_day_thu5;
    }
    public String getRn_day_tue1() {
        return rn_day_tue1;
    }
    public void setRn_day_tue1(String rn_day_tue1) {
        this.rn_day_tue1 = rn_day_tue1;
    }
    public String getRn_day_tue2() {
        return rn_day_tue2;
    }
    public void setRn_day_tue2(String rn_day_tue2) {
        this.rn_day_tue2 = rn_day_tue2;
    }
    public String getRn_day_tue3() {
        return rn_day_tue3;
    }
    public void setRn_day_tue3(String rn_day_tue3) {
        this.rn_day_tue3 = rn_day_tue3;
    }
    public String getRn_day_tue4() {
        return rn_day_tue4;
    }
    public void setRn_day_tue4(String rn_day_tue4) {
        this.rn_day_tue4 = rn_day_tue4;
    }
    public String getRn_day_tue5() {
        return rn_day_tue5;
    }
    public void setRn_day_tue5(String rn_day_tue5) {
        this.rn_day_tue5 = rn_day_tue5;
    }
    public String getRn_day_wed1() {
        return rn_day_wed1;
    }
    public void setRn_day_wed1(String rn_day_wed1) {
        this.rn_day_wed1 = rn_day_wed1;
    }
    public String getRn_day_wed2() {
        return rn_day_wed2;
    }
    public void setRn_day_wed2(String rn_day_wed2) {
        this.rn_day_wed2 = rn_day_wed2;
    }
    public String getRn_day_wed3() {
        return rn_day_wed3;
    }
    public void setRn_day_wed3(String rn_day_wed3) {
        this.rn_day_wed3 = rn_day_wed3;
    }
    public String getRn_day_wed4() {
        return rn_day_wed4;
    }
    public void setRn_day_wed4(String rn_day_wed4) {
        this.rn_day_wed4 = rn_day_wed4;
    }
    public String getRn_day_wed5() {
        return rn_day_wed5;
    }
    public void setRn_day_wed5(String rn_day_wed5) {
        this.rn_day_wed5 = rn_day_wed5;
    }
    public String getRn_eve_fri1() {
        return rn_eve_fri1;
    }
    public void setRn_eve_fri1(String rn_eve_fri1) {
        this.rn_eve_fri1 = rn_eve_fri1;
    }
    public String getRn_eve_fri2() {
        return rn_eve_fri2;
    }
    public void setRn_eve_fri2(String rn_eve_fri2) {
        this.rn_eve_fri2 = rn_eve_fri2;
    }
    public String getRn_eve_fri3() {
        return rn_eve_fri3;
    }
    public void setRn_eve_fri3(String rn_eve_fri3) {
        this.rn_eve_fri3 = rn_eve_fri3;
    }
    public String getRn_eve_fri4() {
        return rn_eve_fri4;
    }
    public void setRn_eve_fri4(String rn_eve_fri4) {
        this.rn_eve_fri4 = rn_eve_fri4;
    }
    public String getRn_eve_fri5() {
        return rn_eve_fri5;
    }
    public void setRn_eve_fri5(String rn_eve_fri5) {
        this.rn_eve_fri5 = rn_eve_fri5;
    }
    public String getRn_eve_mon1() {
        return rn_eve_mon1;
    }
    public void setRn_eve_mon1(String rn_eve_mon1) {
        this.rn_eve_mon1 = rn_eve_mon1;
    }
    public String getRn_eve_mon2() {
        return rn_eve_mon2;
    }
    public void setRn_eve_mon2(String rn_eve_mon2) {
        this.rn_eve_mon2 = rn_eve_mon2;
    }
    public String getRn_eve_mon3() {
        return rn_eve_mon3;
    }
    public void setRn_eve_mon3(String rn_eve_mon3) {
        this.rn_eve_mon3 = rn_eve_mon3;
    }
    public String getRn_eve_mon4() {
        return rn_eve_mon4;
    }
    public void setRn_eve_mon4(String rn_eve_mon4) {
        this.rn_eve_mon4 = rn_eve_mon4;
    }
    public String getRn_eve_mon5() {
        return rn_eve_mon5;
    }
    public void setRn_eve_mon5(String rn_eve_mon5) {
        this.rn_eve_mon5 = rn_eve_mon5;
    }
    public String getRn_eve_sat1() {
        return rn_eve_sat1;
    }
    public void setRn_eve_sat1(String rn_eve_sat1) {
        this.rn_eve_sat1 = rn_eve_sat1;
    }
    public String getRn_eve_sat2() {
        return rn_eve_sat2;
    }
    public void setRn_eve_sat2(String rn_eve_sat2) {
        this.rn_eve_sat2 = rn_eve_sat2;
    }
    public String getRn_eve_sat3() {
        return rn_eve_sat3;
    }
    public void setRn_eve_sat3(String rn_eve_sat3) {
        this.rn_eve_sat3 = rn_eve_sat3;
    }
    public String getRn_eve_sat4() {
        return rn_eve_sat4;
    }
    public void setRn_eve_sat4(String rn_eve_sat4) {
        this.rn_eve_sat4 = rn_eve_sat4;
    }
    public String getRn_eve_sat5() {
        return rn_eve_sat5;
    }
    public void setRn_eve_sat5(String rn_eve_sat5) {
        this.rn_eve_sat5 = rn_eve_sat5;
    }
    public String getRn_eve_sun1() {
        return rn_eve_sun1;
    }
    public void setRn_eve_sun1(String rn_eve_sun1) {
        this.rn_eve_sun1 = rn_eve_sun1;
    }
    public String getRn_eve_sun2() {
        return rn_eve_sun2;
    }
    public void setRn_eve_sun2(String rn_eve_sun2) {
        this.rn_eve_sun2 = rn_eve_sun2;
    }
    public String getRn_eve_sun3() {
        return rn_eve_sun3;
    }
    public void setRn_eve_sun3(String rn_eve_sun3) {
        this.rn_eve_sun3 = rn_eve_sun3;
    }
    public String getRn_eve_sun4() {
        return rn_eve_sun4;
    }
    public void setRn_eve_sun4(String rn_eve_sun4) {
        this.rn_eve_sun4 = rn_eve_sun4;
    }
    public String getRn_eve_sun5() {
        return rn_eve_sun5;
    }
    public void setRn_eve_sun5(String rn_eve_sun5) {
        this.rn_eve_sun5 = rn_eve_sun5;
    }
    public String getRn_eve_thu1() {
        return rn_eve_thu1;
    }
    public void setRn_eve_thu1(String rn_eve_thu1) {
        this.rn_eve_thu1 = rn_eve_thu1;
    }
    public String getRn_eve_thu2() {
        return rn_eve_thu2;
    }
    public void setRn_eve_thu2(String rn_eve_thu2) {
        this.rn_eve_thu2 = rn_eve_thu2;
    }
    public String getRn_eve_thu3() {
        return rn_eve_thu3;
    }
    public void setRn_eve_thu3(String rn_eve_thu3) {
        this.rn_eve_thu3 = rn_eve_thu3;
    }
    public String getRn_eve_thu4() {
        return rn_eve_thu4;
    }
    public void setRn_eve_thu4(String rn_eve_thu4) {
        this.rn_eve_thu4 = rn_eve_thu4;
    }
    public String getRn_eve_thu5() {
        return rn_eve_thu5;
    }
    public void setRn_eve_thu5(String rn_eve_thu5) {
        this.rn_eve_thu5 = rn_eve_thu5;
    }
    public String getRn_eve_tue1() {
        return rn_eve_tue1;
    }
    public void setRn_eve_tue1(String rn_eve_tue1) {
        this.rn_eve_tue1 = rn_eve_tue1;
    }
    public String getRn_eve_tue2() {
        return rn_eve_tue2;
    }
    public void setRn_eve_tue2(String rn_eve_tue2) {
        this.rn_eve_tue2 = rn_eve_tue2;
    }
    public String getRn_eve_tue3() {
        return rn_eve_tue3;
    }
    public void setRn_eve_tue3(String rn_eve_tue3) {
        this.rn_eve_tue3 = rn_eve_tue3;
    }
    public String getRn_eve_tue4() {
        return rn_eve_tue4;
    }
    public void setRn_eve_tue4(String rn_eve_tue4) {
        this.rn_eve_tue4 = rn_eve_tue4;
    }
    public String getRn_eve_tue5() {
        return rn_eve_tue5;
    }
    public void setRn_eve_tue5(String rn_eve_tue5) {
        this.rn_eve_tue5 = rn_eve_tue5;
    }
    public String getRn_eve_wed1() {
        return rn_eve_wed1;
    }
    public void setRn_eve_wed1(String rn_eve_wed1) {
        this.rn_eve_wed1 = rn_eve_wed1;
    }
    public String getRn_eve_wed2() {
        return rn_eve_wed2;
    }
    public void setRn_eve_wed2(String rn_eve_wed2) {
        this.rn_eve_wed2 = rn_eve_wed2;
    }
    public String getRn_eve_wed3() {
        return rn_eve_wed3;
    }
    public void setRn_eve_wed3(String rn_eve_wed3) {
        this.rn_eve_wed3 = rn_eve_wed3;
    }
    public String getRn_eve_wed4() {
        return rn_eve_wed4;
    }
    public void setRn_eve_wed4(String rn_eve_wed4) {
        this.rn_eve_wed4 = rn_eve_wed4;
    }
    public String getRn_eve_wed5() {
        return rn_eve_wed5;
    }
    public void setRn_eve_wed5(String rn_eve_wed5) {
        this.rn_eve_wed5 = rn_eve_wed5;
    }
    public String getWeek_total1() {
        return week_total1;
    }
    public void setWeek_total1(String week_total1) {
        this.week_total1 = week_total1;
    }
    public String getWeek_total2() {
        return week_total2;
    }
    public void setWeek_total2(String week_total2) {
        this.week_total2 = week_total2;
    }
    public String getWeek_total3() {
        return week_total3;
    }
    public void setWeek_total3(String week_total3) {
        this.week_total3 = week_total3;
    }
    public String getWeek_total4() {
        return week_total4;
    }
    public void setWeek_total4(String week_total4) {
        this.week_total4 = week_total4;
    }
    public String getWeek_total5() {
        return week_total5;
    }
    public void setWeek_total5(String week_total5) {
        this.week_total5 = week_total5;
    }
    public String getFacilityName() {
        return facilityName;
    }
    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }
    public String getHca_day_fri1() {
        return hca_day_fri1;
    }
    public void setHca_day_fri1(String hca_day_fri1) {
        this.hca_day_fri1 = hca_day_fri1;
    }
    public String getHca_day_fri2() {
        return hca_day_fri2;
    }
    public void setHca_day_fri2(String hca_day_fri2) {
        this.hca_day_fri2 = hca_day_fri2;
    }
    public String getHca_day_fri3() {
        return hca_day_fri3;
    }
    public void setHca_day_fri3(String hca_day_fri3) {
        this.hca_day_fri3 = hca_day_fri3;
    }
    public String getHca_day_fri4() {
        return hca_day_fri4;
    }
    public void setHca_day_fri4(String hca_day_fri4) {
        this.hca_day_fri4 = hca_day_fri4;
    }
    public String getHca_day_fri5() {
        return hca_day_fri5;
    }
    public void setHca_day_fri5(String hca_day_fri5) {
        this.hca_day_fri5 = hca_day_fri5;
    }
    public String getHca_day_mon1() {
        return hca_day_mon1;
    }
    public void setHca_day_mon1(String hca_day_mon1) {
        this.hca_day_mon1 = hca_day_mon1;
    }
    public String getHca_day_mon2() {
        return hca_day_mon2;
    }
    public void setHca_day_mon2(String hca_day_mon2) {
        this.hca_day_mon2 = hca_day_mon2;
    }
    public String getHca_day_mon3() {
        return hca_day_mon3;
    }
    public void setHca_day_mon3(String hca_day_mon3) {
        this.hca_day_mon3 = hca_day_mon3;
    }
    public String getHca_day_mon4() {
        return hca_day_mon4;
    }
    public void setHca_day_mon4(String hca_day_mon4) {
        this.hca_day_mon4 = hca_day_mon4;
    }
    public String getHca_day_mon5() {
        return hca_day_mon5;
    }
    public void setHca_day_mon5(String hca_day_mon5) {
        this.hca_day_mon5 = hca_day_mon5;
    }
    public String getHca_day_sat1() {
        return hca_day_sat1;
    }
    public void setHca_day_sat1(String hca_day_sat1) {
        this.hca_day_sat1 = hca_day_sat1;
    }
    public String getHca_day_sat2() {
        return hca_day_sat2;
    }
    public void setHca_day_sat2(String hca_day_sat2) {
        this.hca_day_sat2 = hca_day_sat2;
    }
    public String getHca_day_sat3() {
        return hca_day_sat3;
    }
    public void setHca_day_sat3(String hca_day_sat3) {
        this.hca_day_sat3 = hca_day_sat3;
    }
    public String getHca_day_sat4() {
        return hca_day_sat4;
    }
    public void setHca_day_sat4(String hca_day_sat4) {
        this.hca_day_sat4 = hca_day_sat4;
    }
    public String getHca_day_sat5() {
        return hca_day_sat5;
    }
    public void setHca_day_sat5(String hca_day_sat5) {
        this.hca_day_sat5 = hca_day_sat5;
    }
    public String getHca_day_sun1() {
        return hca_day_sun1;
    }
    public void setHca_day_sun1(String hca_day_sun1) {
        this.hca_day_sun1 = hca_day_sun1;
    }
    public String getHca_day_sun2() {
        return hca_day_sun2;
    }
    public void setHca_day_sun2(String hca_day_sun2) {
        this.hca_day_sun2 = hca_day_sun2;
    }
    public String getHca_day_sun3() {
        return hca_day_sun3;
    }
    public void setHca_day_sun3(String hca_day_sun3) {
        this.hca_day_sun3 = hca_day_sun3;
    }
    public String getHca_day_sun4() {
        return hca_day_sun4;
    }
    public void setHca_day_sun4(String hca_day_sun4) {
        this.hca_day_sun4 = hca_day_sun4;
    }
    public String getHca_day_sun5() {
        return hca_day_sun5;
    }
    public void setHca_day_sun5(String hca_day_sun5) {
        this.hca_day_sun5 = hca_day_sun5;
    }
    public String getHca_day_thu1() {
        return hca_day_thu1;
    }
    public void setHca_day_thu1(String hca_day_thu1) {
        this.hca_day_thu1 = hca_day_thu1;
    }
    public String getHca_day_thu2() {
        return hca_day_thu2;
    }
    public void setHca_day_thu2(String hca_day_thu2) {
        this.hca_day_thu2 = hca_day_thu2;
    }
    public String getHca_day_thu3() {
        return hca_day_thu3;
    }
    public void setHca_day_thu3(String hca_day_thu3) {
        this.hca_day_thu3 = hca_day_thu3;
    }
    public String getHca_day_thu4() {
        return hca_day_thu4;
    }
    public void setHca_day_thu4(String hca_day_thu4) {
        this.hca_day_thu4 = hca_day_thu4;
    }
    public String getHca_day_thu5() {
        return hca_day_thu5;
    }
    public void setHca_day_thu5(String hca_day_thu5) {
        this.hca_day_thu5 = hca_day_thu5;
    }
    public String getHca_day_tue1() {
        return hca_day_tue1;
    }
    public void setHca_day_tue1(String hca_day_tue1) {
        this.hca_day_tue1 = hca_day_tue1;
    }
    public String getHca_day_tue2() {
        return hca_day_tue2;
    }
    public void setHca_day_tue2(String hca_day_tue2) {
        this.hca_day_tue2 = hca_day_tue2;
    }
    public String getHca_day_tue3() {
        return hca_day_tue3;
    }
    public void setHca_day_tue3(String hca_day_tue3) {
        this.hca_day_tue3 = hca_day_tue3;
    }
    public String getHca_day_tue4() {
        return hca_day_tue4;
    }
    public void setHca_day_tue4(String hca_day_tue4) {
        this.hca_day_tue4 = hca_day_tue4;
    }
    public String getHca_day_tue5() {
        return hca_day_tue5;
    }
    public void setHca_day_tue5(String hca_day_tue5) {
        this.hca_day_tue5 = hca_day_tue5;
    }
    public String getHca_day_wed1() {
        return hca_day_wed1;
    }
    public void setHca_day_wed1(String hca_day_wed1) {
        this.hca_day_wed1 = hca_day_wed1;
    }
    public String getHca_day_wed2() {
        return hca_day_wed2;
    }
    public void setHca_day_wed2(String hca_day_wed2) {
        this.hca_day_wed2 = hca_day_wed2;
    }
    public String getHca_day_wed3() {
        return hca_day_wed3;
    }
    public void setHca_day_wed3(String hca_day_wed3) {
        this.hca_day_wed3 = hca_day_wed3;
    }
    public String getHca_day_wed4() {
        return hca_day_wed4;
    }
    public void setHca_day_wed4(String hca_day_wed4) {
        this.hca_day_wed4 = hca_day_wed4;
    }
    public String getHca_day_wed5() {
        return hca_day_wed5;
    }
    public void setHca_day_wed5(String hca_day_wed5) {
        this.hca_day_wed5 = hca_day_wed5;
    }
    public String getHca_eve_fri1() {
        return hca_eve_fri1;
    }
    public void setHca_eve_fri1(String hca_eve_fri1) {
        this.hca_eve_fri1 = hca_eve_fri1;
    }
    public String getHca_eve_fri2() {
        return hca_eve_fri2;
    }
    public void setHca_eve_fri2(String hca_eve_fri2) {
        this.hca_eve_fri2 = hca_eve_fri2;
    }
    public String getHca_eve_fri3() {
        return hca_eve_fri3;
    }
    public void setHca_eve_fri3(String hca_eve_fri3) {
        this.hca_eve_fri3 = hca_eve_fri3;
    }
    public String getHca_eve_fri4() {
        return hca_eve_fri4;
    }
    public void setHca_eve_fri4(String hca_eve_fri4) {
        this.hca_eve_fri4 = hca_eve_fri4;
    }
    public String getHca_eve_fri5() {
        return hca_eve_fri5;
    }
    public void setHca_eve_fri5(String hca_eve_fri5) {
        this.hca_eve_fri5 = hca_eve_fri5;
    }
    public String getHca_eve_mon1() {
        return hca_eve_mon1;
    }
    public void setHca_eve_mon1(String hca_eve_mon1) {
        this.hca_eve_mon1 = hca_eve_mon1;
    }
    public String getHca_eve_mon2() {
        return hca_eve_mon2;
    }
    public void setHca_eve_mon2(String hca_eve_mon2) {
        this.hca_eve_mon2 = hca_eve_mon2;
    }
    public String getHca_eve_mon3() {
        return hca_eve_mon3;
    }
    public void setHca_eve_mon3(String hca_eve_mon3) {
        this.hca_eve_mon3 = hca_eve_mon3;
    }
    public String getHca_eve_mon4() {
        return hca_eve_mon4;
    }
    public void setHca_eve_mon4(String hca_eve_mon4) {
        this.hca_eve_mon4 = hca_eve_mon4;
    }
    public String getHca_eve_mon5() {
        return hca_eve_mon5;
    }
    public void setHca_eve_mon5(String hca_eve_mon5) {
        this.hca_eve_mon5 = hca_eve_mon5;
    }
    public String getHca_eve_sat1() {
        return hca_eve_sat1;
    }
    public void setHca_eve_sat1(String hca_eve_sat1) {
        this.hca_eve_sat1 = hca_eve_sat1;
    }
    public String getHca_eve_sat2() {
        return hca_eve_sat2;
    }
    public void setHca_eve_sat2(String hca_eve_sat2) {
        this.hca_eve_sat2 = hca_eve_sat2;
    }
    public String getHca_eve_sat3() {
        return hca_eve_sat3;
    }
    public void setHca_eve_sat3(String hca_eve_sat3) {
        this.hca_eve_sat3 = hca_eve_sat3;
    }
    public String getHca_eve_sat4() {
        return hca_eve_sat4;
    }
    public void setHca_eve_sat4(String hca_eve_sat4) {
        this.hca_eve_sat4 = hca_eve_sat4;
    }
    public String getHca_eve_sat5() {
        return hca_eve_sat5;
    }
    public void setHca_eve_sat5(String hca_eve_sat5) {
        this.hca_eve_sat5 = hca_eve_sat5;
    }
    public String getHca_eve_sun1() {
        return hca_eve_sun1;
    }
    public void setHca_eve_sun1(String hca_eve_sun1) {
        this.hca_eve_sun1 = hca_eve_sun1;
    }
    public String getHca_eve_sun2() {
        return hca_eve_sun2;
    }
    public void setHca_eve_sun2(String hca_eve_sun2) {
        this.hca_eve_sun2 = hca_eve_sun2;
    }
    public String getHca_eve_sun3() {
        return hca_eve_sun3;
    }
    public void setHca_eve_sun3(String hca_eve_sun3) {
        this.hca_eve_sun3 = hca_eve_sun3;
    }
    public String getHca_eve_sun4() {
        return hca_eve_sun4;
    }
    public void setHca_eve_sun4(String hca_eve_sun4) {
        this.hca_eve_sun4 = hca_eve_sun4;
    }
    public String getHca_eve_sun5() {
        return hca_eve_sun5;
    }
    public void setHca_eve_sun5(String hca_eve_sun5) {
        this.hca_eve_sun5 = hca_eve_sun5;
    }
    public String getHca_eve_thu1() {
        return hca_eve_thu1;
    }
    public void setHca_eve_thu1(String hca_eve_thu1) {
        this.hca_eve_thu1 = hca_eve_thu1;
    }
    public String getHca_eve_thu2() {
        return hca_eve_thu2;
    }
    public void setHca_eve_thu2(String hca_eve_thu2) {
        this.hca_eve_thu2 = hca_eve_thu2;
    }
    public String getHca_eve_thu3() {
        return hca_eve_thu3;
    }
    public void setHca_eve_thu3(String hca_eve_thu3) {
        this.hca_eve_thu3 = hca_eve_thu3;
    }
    public String getHca_eve_thu4() {
        return hca_eve_thu4;
    }
    public void setHca_eve_thu4(String hca_eve_thu4) {
        this.hca_eve_thu4 = hca_eve_thu4;
    }
    public String getHca_eve_thu5() {
        return hca_eve_thu5;
    }
    public void setHca_eve_thu5(String hca_eve_thu5) {
        this.hca_eve_thu5 = hca_eve_thu5;
    }
    public String getHca_eve_tue1() {
        return hca_eve_tue1;
    }
    public void setHca_eve_tue1(String hca_eve_tue1) {
        this.hca_eve_tue1 = hca_eve_tue1;
    }
    public String getHca_eve_tue2() {
        return hca_eve_tue2;
    }
    public void setHca_eve_tue2(String hca_eve_tue2) {
        this.hca_eve_tue2 = hca_eve_tue2;
    }
    public String getHca_eve_tue3() {
        return hca_eve_tue3;
    }
    public void setHca_eve_tue3(String hca_eve_tue3) {
        this.hca_eve_tue3 = hca_eve_tue3;
    }
    public String getHca_eve_tue4() {
        return hca_eve_tue4;
    }
    public void setHca_eve_tue4(String hca_eve_tue4) {
        this.hca_eve_tue4 = hca_eve_tue4;
    }
    public String getHca_eve_tue5() {
        return hca_eve_tue5;
    }
    public void setHca_eve_tue5(String hca_eve_tue5) {
        this.hca_eve_tue5 = hca_eve_tue5;
    }
    public String getHca_eve_wed1() {
        return hca_eve_wed1;
    }
    public void setHca_eve_wed1(String hca_eve_wed1) {
        this.hca_eve_wed1 = hca_eve_wed1;
    }
    public String getHca_eve_wed2() {
        return hca_eve_wed2;
    }
    public void setHca_eve_wed2(String hca_eve_wed2) {
        this.hca_eve_wed2 = hca_eve_wed2;
    }
    public String getHca_eve_wed3() {
        return hca_eve_wed3;
    }
    public void setHca_eve_wed3(String hca_eve_wed3) {
        this.hca_eve_wed3 = hca_eve_wed3;
    }
    public String getHca_eve_wed4() {
        return hca_eve_wed4;
    }
    public void setHca_eve_wed4(String hca_eve_wed4) {
        this.hca_eve_wed4 = hca_eve_wed4;
    }
    public String getHca_eve_wed5() {
        return hca_eve_wed5;
    }
    public void setHca_eve_wed5(String hca_eve_wed5) {
        this.hca_eve_wed5 = hca_eve_wed5;
    }
    public String getLpn_day_fri1() {
        return lpn_day_fri1;
    }
    public void setLpn_day_fri1(String lpn_day_fri1) {
        this.lpn_day_fri1 = lpn_day_fri1;
    }
    public String getLpn_day_fri2() {
        return lpn_day_fri2;
    }
    public void setLpn_day_fri2(String lpn_day_fri2) {
        this.lpn_day_fri2 = lpn_day_fri2;
    }
    public String getLpn_day_fri3() {
        return lpn_day_fri3;
    }
    public void setLpn_day_fri3(String lpn_day_fri3) {
        this.lpn_day_fri3 = lpn_day_fri3;
    }
    public String getLpn_day_fri4() {
        return lpn_day_fri4;
    }
    public void setLpn_day_fri4(String lpn_day_fri4) {
        this.lpn_day_fri4 = lpn_day_fri4;
    }
    public String getLpn_day_fri5() {
        return lpn_day_fri5;
    }
    public void setLpn_day_fri5(String lpn_day_fri5) {
        this.lpn_day_fri5 = lpn_day_fri5;
    }
    public String getLpn_day_mon1() {
        return lpn_day_mon1;
    }
    public void setLpn_day_mon1(String lpn_day_mon1) {
        this.lpn_day_mon1 = lpn_day_mon1;
    }
    public String getLpn_day_mon2() {
        return lpn_day_mon2;
    }
    public void setLpn_day_mon2(String lpn_day_mon2) {
        this.lpn_day_mon2 = lpn_day_mon2;
    }
    public String getLpn_day_mon3() {
        return lpn_day_mon3;
    }
    public void setLpn_day_mon3(String lpn_day_mon3) {
        this.lpn_day_mon3 = lpn_day_mon3;
    }
    public String getLpn_day_mon4() {
        return lpn_day_mon4;
    }
    public void setLpn_day_mon4(String lpn_day_mon4) {
        this.lpn_day_mon4 = lpn_day_mon4;
    }
    public String getLpn_day_mon5() {
        return lpn_day_mon5;
    }
    public void setLpn_day_mon5(String lpn_day_mon5) {
        this.lpn_day_mon5 = lpn_day_mon5;
    }
    public String getLpn_day_sat1() {
        return lpn_day_sat1;
    }
    public void setLpn_day_sat1(String lpn_day_sat1) {
        this.lpn_day_sat1 = lpn_day_sat1;
    }
    public String getLpn_day_sat2() {
        return lpn_day_sat2;
    }
    public void setLpn_day_sat2(String lpn_day_sat2) {
        this.lpn_day_sat2 = lpn_day_sat2;
    }
    public String getLpn_day_sat3() {
        return lpn_day_sat3;
    }
    public void setLpn_day_sat3(String lpn_day_sat3) {
        this.lpn_day_sat3 = lpn_day_sat3;
    }
    public String getLpn_day_sat4() {
        return lpn_day_sat4;
    }
    public void setLpn_day_sat4(String lpn_day_sat4) {
        this.lpn_day_sat4 = lpn_day_sat4;
    }
    public String getLpn_day_sat5() {
        return lpn_day_sat5;
    }
    public void setLpn_day_sat5(String lpn_day_sat5) {
        this.lpn_day_sat5 = lpn_day_sat5;
    }
    public String getLpn_day_sun1() {
        return lpn_day_sun1;
    }
    public void setLpn_day_sun1(String lpn_day_sun1) {
        this.lpn_day_sun1 = lpn_day_sun1;
    }
    public String getLpn_day_sun2() {
        return lpn_day_sun2;
    }
    public void setLpn_day_sun2(String lpn_day_sun2) {
        this.lpn_day_sun2 = lpn_day_sun2;
    }
    public String getLpn_day_sun3() {
        return lpn_day_sun3;
    }
    public void setLpn_day_sun3(String lpn_day_sun3) {
        this.lpn_day_sun3 = lpn_day_sun3;
    }
    public String getLpn_day_sun4() {
        return lpn_day_sun4;
    }
    public void setLpn_day_sun4(String lpn_day_sun4) {
        this.lpn_day_sun4 = lpn_day_sun4;
    }
    public String getLpn_day_sun5() {
        return lpn_day_sun5;
    }
    public void setLpn_day_sun5(String lpn_day_sun5) {
        this.lpn_day_sun5 = lpn_day_sun5;
    }
    public String getLpn_day_thu1() {
        return lpn_day_thu1;
    }
    public void setLpn_day_thu1(String lpn_day_thu1) {
        this.lpn_day_thu1 = lpn_day_thu1;
    }
    public String getLpn_day_thu2() {
        return lpn_day_thu2;
    }
    public void setLpn_day_thu2(String lpn_day_thu2) {
        this.lpn_day_thu2 = lpn_day_thu2;
    }
    public String getLpn_day_thu3() {
        return lpn_day_thu3;
    }
    public void setLpn_day_thu3(String lpn_day_thu3) {
        this.lpn_day_thu3 = lpn_day_thu3;
    }
    public String getLpn_day_thu4() {
        return lpn_day_thu4;
    }
    public void setLpn_day_thu4(String lpn_day_thu4) {
        this.lpn_day_thu4 = lpn_day_thu4;
    }
    public String getLpn_day_thu5() {
        return lpn_day_thu5;
    }
    public void setLpn_day_thu5(String lpn_day_thu5) {
        this.lpn_day_thu5 = lpn_day_thu5;
    }
    public String getLpn_day_tue1() {
        return lpn_day_tue1;
    }
    public void setLpn_day_tue1(String lpn_day_tue1) {
        this.lpn_day_tue1 = lpn_day_tue1;
    }
    public String getLpn_day_tue2() {
        return lpn_day_tue2;
    }
    public void setLpn_day_tue2(String lpn_day_tue2) {
        this.lpn_day_tue2 = lpn_day_tue2;
    }
    public String getLpn_day_tue3() {
        return lpn_day_tue3;
    }
    public void setLpn_day_tue3(String lpn_day_tue3) {
        this.lpn_day_tue3 = lpn_day_tue3;
    }
    public String getLpn_day_tue4() {
        return lpn_day_tue4;
    }
    public void setLpn_day_tue4(String lpn_day_tue4) {
        this.lpn_day_tue4 = lpn_day_tue4;
    }
    public String getLpn_day_tue5() {
        return lpn_day_tue5;
    }
    public void setLpn_day_tue5(String lpn_day_tue5) {
        this.lpn_day_tue5 = lpn_day_tue5;
    }
    public String getLpn_day_wed1() {
        return lpn_day_wed1;
    }
    public void setLpn_day_wed1(String lpn_day_wed1) {
        this.lpn_day_wed1 = lpn_day_wed1;
    }
    public String getLpn_day_wed2() {
        return lpn_day_wed2;
    }
    public void setLpn_day_wed2(String lpn_day_wed2) {
        this.lpn_day_wed2 = lpn_day_wed2;
    }
    public String getLpn_day_wed3() {
        return lpn_day_wed3;
    }
    public void setLpn_day_wed3(String lpn_day_wed3) {
        this.lpn_day_wed3 = lpn_day_wed3;
    }
    public String getLpn_day_wed4() {
        return lpn_day_wed4;
    }
    public void setLpn_day_wed4(String lpn_day_wed4) {
        this.lpn_day_wed4 = lpn_day_wed4;
    }
    public String getLpn_day_wed5() {
        return lpn_day_wed5;
    }
    public void setLpn_day_wed5(String lpn_day_wed5) {
        this.lpn_day_wed5 = lpn_day_wed5;
    }
    public String getLpn_eve_fri1() {
        return lpn_eve_fri1;
    }
    public void setLpn_eve_fri1(String lpn_eve_fri1) {
        this.lpn_eve_fri1 = lpn_eve_fri1;
    }
    public String getLpn_eve_fri2() {
        return lpn_eve_fri2;
    }
    public void setLpn_eve_fri2(String lpn_eve_fri2) {
        this.lpn_eve_fri2 = lpn_eve_fri2;
    }
    public String getLpn_eve_fri3() {
        return lpn_eve_fri3;
    }
    public void setLpn_eve_fri3(String lpn_eve_fri3) {
        this.lpn_eve_fri3 = lpn_eve_fri3;
    }
    public String getLpn_eve_fri4() {
        return lpn_eve_fri4;
    }
    public void setLpn_eve_fri4(String lpn_eve_fri4) {
        this.lpn_eve_fri4 = lpn_eve_fri4;
    }
    public String getLpn_eve_fri5() {
        return lpn_eve_fri5;
    }
    public void setLpn_eve_fri5(String lpn_eve_fri5) {
        this.lpn_eve_fri5 = lpn_eve_fri5;
    }
    public String getLpn_eve_mon1() {
        return lpn_eve_mon1;
    }
    public void setLpn_eve_mon1(String lpn_eve_mon1) {
        this.lpn_eve_mon1 = lpn_eve_mon1;
    }
    public String getLpn_eve_mon2() {
        return lpn_eve_mon2;
    }
    public void setLpn_eve_mon2(String lpn_eve_mon2) {
        this.lpn_eve_mon2 = lpn_eve_mon2;
    }
    public String getLpn_eve_mon3() {
        return lpn_eve_mon3;
    }
    public void setLpn_eve_mon3(String lpn_eve_mon3) {
        this.lpn_eve_mon3 = lpn_eve_mon3;
    }
    public String getLpn_eve_mon4() {
        return lpn_eve_mon4;
    }
    public void setLpn_eve_mon4(String lpn_eve_mon4) {
        this.lpn_eve_mon4 = lpn_eve_mon4;
    }
    public String getLpn_eve_mon5() {
        return lpn_eve_mon5;
    }
    public void setLpn_eve_mon5(String lpn_eve_mon5) {
        this.lpn_eve_mon5 = lpn_eve_mon5;
    }
    public String getLpn_eve_sat1() {
        return lpn_eve_sat1;
    }
    public void setLpn_eve_sat1(String lpn_eve_sat1) {
        this.lpn_eve_sat1 = lpn_eve_sat1;
    }
    public String getLpn_eve_sat2() {
        return lpn_eve_sat2;
    }
    public void setLpn_eve_sat2(String lpn_eve_sat2) {
        this.lpn_eve_sat2 = lpn_eve_sat2;
    }
    public String getLpn_eve_sat3() {
        return lpn_eve_sat3;
    }
    public void setLpn_eve_sat3(String lpn_eve_sat3) {
        this.lpn_eve_sat3 = lpn_eve_sat3;
    }
    public String getLpn_eve_sat4() {
        return lpn_eve_sat4;
    }
    public void setLpn_eve_sat4(String lpn_eve_sat4) {
        this.lpn_eve_sat4 = lpn_eve_sat4;
    }
    public String getLpn_eve_sat5() {
        return lpn_eve_sat5;
    }
    public void setLpn_eve_sat5(String lpn_eve_sat5) {
        this.lpn_eve_sat5 = lpn_eve_sat5;
    }
    public String getLpn_eve_sun1() {
        return lpn_eve_sun1;
    }
    public void setLpn_eve_sun1(String lpn_eve_sun1) {
        this.lpn_eve_sun1 = lpn_eve_sun1;
    }
    public String getLpn_eve_sun2() {
        return lpn_eve_sun2;
    }
    public void setLpn_eve_sun2(String lpn_eve_sun2) {
        this.lpn_eve_sun2 = lpn_eve_sun2;
    }
    public String getLpn_eve_sun3() {
        return lpn_eve_sun3;
    }
    public void setLpn_eve_sun3(String lpn_eve_sun3) {
        this.lpn_eve_sun3 = lpn_eve_sun3;
    }
    public String getLpn_eve_sun4() {
        return lpn_eve_sun4;
    }
    public void setLpn_eve_sun4(String lpn_eve_sun4) {
        this.lpn_eve_sun4 = lpn_eve_sun4;
    }
    public String getLpn_eve_sun5() {
        return lpn_eve_sun5;
    }
    public void setLpn_eve_sun5(String lpn_eve_sun5) {
        this.lpn_eve_sun5 = lpn_eve_sun5;
    }
    public String getLpn_eve_thu1() {
        return lpn_eve_thu1;
    }
    public void setLpn_eve_thu1(String lpn_eve_thu1) {
        this.lpn_eve_thu1 = lpn_eve_thu1;
    }
    public String getLpn_eve_thu2() {
        return lpn_eve_thu2;
    }
    public void setLpn_eve_thu2(String lpn_eve_thu2) {
        this.lpn_eve_thu2 = lpn_eve_thu2;
    }
    public String getLpn_eve_thu3() {
        return lpn_eve_thu3;
    }
    public void setLpn_eve_thu3(String lpn_eve_thu3) {
        this.lpn_eve_thu3 = lpn_eve_thu3;
    }
    public String getLpn_eve_thu4() {
        return lpn_eve_thu4;
    }
    public void setLpn_eve_thu4(String lpn_eve_thu4) {
        this.lpn_eve_thu4 = lpn_eve_thu4;
    }
    public String getLpn_eve_thu5() {
        return lpn_eve_thu5;
    }
    public void setLpn_eve_thu5(String lpn_eve_thu5) {
        this.lpn_eve_thu5 = lpn_eve_thu5;
    }
    public String getLpn_eve_tue1() {
        return lpn_eve_tue1;
    }
    public void setLpn_eve_tue1(String lpn_eve_tue1) {
        this.lpn_eve_tue1 = lpn_eve_tue1;
    }
    public String getLpn_eve_tue2() {
        return lpn_eve_tue2;
    }
    public void setLpn_eve_tue2(String lpn_eve_tue2) {
        this.lpn_eve_tue2 = lpn_eve_tue2;
    }
    public String getLpn_eve_tue3() {
        return lpn_eve_tue3;
    }
    public void setLpn_eve_tue3(String lpn_eve_tue3) {
        this.lpn_eve_tue3 = lpn_eve_tue3;
    }
    public String getLpn_eve_tue4() {
        return lpn_eve_tue4;
    }
    public void setLpn_eve_tue4(String lpn_eve_tue4) {
        this.lpn_eve_tue4 = lpn_eve_tue4;
    }
    public String getLpn_eve_tue5() {
        return lpn_eve_tue5;
    }
    public void setLpn_eve_tue5(String lpn_eve_tue5) {
        this.lpn_eve_tue5 = lpn_eve_tue5;
    }
    public String getLpn_eve_wed1() {
        return lpn_eve_wed1;
    }
    public void setLpn_eve_wed1(String lpn_eve_wed1) {
        this.lpn_eve_wed1 = lpn_eve_wed1;
    }
    public String getLpn_eve_wed2() {
        return lpn_eve_wed2;
    }
    public void setLpn_eve_wed2(String lpn_eve_wed2) {
        this.lpn_eve_wed2 = lpn_eve_wed2;
    }
    public String getLpn_eve_wed3() {
        return lpn_eve_wed3;
    }
    public void setLpn_eve_wed3(String lpn_eve_wed3) {
        this.lpn_eve_wed3 = lpn_eve_wed3;
    }
    public String getLpn_eve_wed4() {
        return lpn_eve_wed4;
    }
    public void setLpn_eve_wed4(String lpn_eve_wed4) {
        this.lpn_eve_wed4 = lpn_eve_wed4;
    }
    public String getLpn_eve_wed5() {
        return lpn_eve_wed5;
    }
    public void setLpn_eve_wed5(String lpn_eve_wed5) {
        this.lpn_eve_wed5 = lpn_eve_wed5;
    }
    public String getTotal_label1() {
        return total_label1;
    }
    public void setTotal_label1(String total_label1) {
        this.total_label1 = total_label1;
    }
    public String getTotal_label2() {
        return total_label2;
    }
    public void setTotal_label2(String total_label2) {
        this.total_label2 = total_label2;
    }
    public String getTotal_label3() {
        return total_label3;
    }
    public void setTotal_label3(String total_label3) {
        this.total_label3 = total_label3;
    }
    public String getTotal_label4() {
        return total_label4;
    }
    public void setTotal_label4(String total_label4) {
        this.total_label4 = total_label4;
    }
    public String getTotal_label5() {
        return total_label5;
    }
    public void setTotal_label5(String total_label5) {
        this.total_label5 = total_label5;
    }
    public String getAld_dt_label1() {
        return ald_dt_label1;
    }
    public void setAld_dt_label1(String ald_dt_label1) {
        this.ald_dt_label1 = ald_dt_label1;
    }
    public String getAld_dt_label2() {
        return ald_dt_label2;
    }
    public void setAld_dt_label2(String ald_dt_label2) {
        this.ald_dt_label2 = ald_dt_label2;
    }
    public String getAld_dt_label3() {
        return ald_dt_label3;
    }
    public void setAld_dt_label3(String ald_dt_label3) {
        this.ald_dt_label3 = ald_dt_label3;
    }
    public String getAld_dt_label4() {
        return ald_dt_label4;
    }
    public void setAld_dt_label4(String ald_dt_label4) {
        this.ald_dt_label4 = ald_dt_label4;
    }
    public String getAld_dt_label5() {
        return ald_dt_label5;
    }
    public void setAld_dt_label5(String ald_dt_label5) {
        this.ald_dt_label5 = ald_dt_label5;
    }
    public String getAld_dt_total1() {
        return ald_dt_total1;
    }
    public void setAld_dt_total1(String ald_dt_total1) {
        this.ald_dt_total1 = ald_dt_total1;
    }
    public String getAld_dt_total2() {
        return ald_dt_total2;
    }
    public void setAld_dt_total2(String ald_dt_total2) {
        this.ald_dt_total2 = ald_dt_total2;
    }
    public String getAld_dt_total3() {
        return ald_dt_total3;
    }
    public void setAld_dt_total3(String ald_dt_total3) {
        this.ald_dt_total3 = ald_dt_total3;
    }
    public String getAld_dt_total4() {
        return ald_dt_total4;
    }
    public void setAld_dt_total4(String ald_dt_total4) {
        this.ald_dt_total4 = ald_dt_total4;
    }
    public String getAld_dt_total5() {
        return ald_dt_total5;
    }
    public void setAld_dt_total5(String ald_dt_total5) {
        this.ald_dt_total5 = ald_dt_total5;
    }
    public String getAld_ot_label1() {
        return ald_ot_label1;
    }
    public void setAld_ot_label1(String ald_ot_label1) {
        this.ald_ot_label1 = ald_ot_label1;
    }
    public String getAld_ot_label2() {
        return ald_ot_label2;
    }
    public void setAld_ot_label2(String ald_ot_label2) {
        this.ald_ot_label2 = ald_ot_label2;
    }
    public String getAld_ot_label3() {
        return ald_ot_label3;
    }
    public void setAld_ot_label3(String ald_ot_label3) {
        this.ald_ot_label3 = ald_ot_label3;
    }
    public String getAld_ot_label4() {
        return ald_ot_label4;
    }
    public void setAld_ot_label4(String ald_ot_label4) {
        this.ald_ot_label4 = ald_ot_label4;
    }
    public String getAld_ot_label5() {
        return ald_ot_label5;
    }
    public void setAld_ot_label5(String ald_ot_label5) {
        this.ald_ot_label5 = ald_ot_label5;
    }
    public String getAld_ot_total1() {
        return ald_ot_total1;
    }
    public void setAld_ot_total1(String ald_ot_total1) {
        this.ald_ot_total1 = ald_ot_total1;
    }
    public String getAld_ot_total2() {
        return ald_ot_total2;
    }
    public void setAld_ot_total2(String ald_ot_total2) {
        this.ald_ot_total2 = ald_ot_total2;
    }
    public String getAld_ot_total3() {
        return ald_ot_total3;
    }
    public void setAld_ot_total3(String ald_ot_total3) {
        this.ald_ot_total3 = ald_ot_total3;
    }
    public String getAld_ot_total4() {
        return ald_ot_total4;
    }
    public void setAld_ot_total4(String ald_ot_total4) {
        this.ald_ot_total4 = ald_ot_total4;
    }
    public String getAld_ot_total5() {
        return ald_ot_total5;
    }
    public void setAld_ot_total5(String ald_ot_total5) {
        this.ald_ot_total5 = ald_ot_total5;
    }
    public String getAld_pt_label1() {
        return ald_pt_label1;
    }
    public void setAld_pt_label1(String ald_pt_label1) {
        this.ald_pt_label1 = ald_pt_label1;
    }
    public String getAld_pt_label2() {
        return ald_pt_label2;
    }
    public void setAld_pt_label2(String ald_pt_label2) {
        this.ald_pt_label2 = ald_pt_label2;
    }
    public String getAld_pt_label3() {
        return ald_pt_label3;
    }
    public void setAld_pt_label3(String ald_pt_label3) {
        this.ald_pt_label3 = ald_pt_label3;
    }
    public String getAld_pt_label4() {
        return ald_pt_label4;
    }
    public void setAld_pt_label4(String ald_pt_label4) {
        this.ald_pt_label4 = ald_pt_label4;
    }
    public String getAld_pt_label5() {
        return ald_pt_label5;
    }
    public void setAld_pt_label5(String ald_pt_label5) {
        this.ald_pt_label5 = ald_pt_label5;
    }
    public String getAld_pt_total1() {
        return ald_pt_total1;
    }
    public void setAld_pt_total1(String ald_pt_total1) {
        this.ald_pt_total1 = ald_pt_total1;
    }
    public String getAld_pt_total2() {
        return ald_pt_total2;
    }
    public void setAld_pt_total2(String ald_pt_total2) {
        this.ald_pt_total2 = ald_pt_total2;
    }
    public String getAld_pt_total3() {
        return ald_pt_total3;
    }
    public void setAld_pt_total3(String ald_pt_total3) {
        this.ald_pt_total3 = ald_pt_total3;
    }
    public String getAld_pt_total4() {
        return ald_pt_total4;
    }
    public void setAld_pt_total4(String ald_pt_total4) {
        this.ald_pt_total4 = ald_pt_total4;
    }
    public String getAld_pt_total5() {
        return ald_pt_total5;
    }
    public void setAld_pt_total5(String ald_pt_total5) {
        this.ald_pt_total5 = ald_pt_total5;
    }
    public String getAld_rt_label1() {
        return ald_rt_label1;
    }
    public void setAld_rt_label1(String ald_rt_label1) {
        this.ald_rt_label1 = ald_rt_label1;
    }
    public String getAld_rt_label2() {
        return ald_rt_label2;
    }
    public void setAld_rt_label2(String ald_rt_label2) {
        this.ald_rt_label2 = ald_rt_label2;
    }
    public String getAld_rt_label3() {
        return ald_rt_label3;
    }
    public void setAld_rt_label3(String ald_rt_label3) {
        this.ald_rt_label3 = ald_rt_label3;
    }
    public String getAld_rt_label4() {
        return ald_rt_label4;
    }
    public void setAld_rt_label4(String ald_rt_label4) {
        this.ald_rt_label4 = ald_rt_label4;
    }
    public String getAld_rt_label5() {
        return ald_rt_label5;
    }
    public void setAld_rt_label5(String ald_rt_label5) {
        this.ald_rt_label5 = ald_rt_label5;
    }
    public String getAld_rt_total1() {
        return ald_rt_total1;
    }
    public void setAld_rt_total1(String ald_rt_total1) {
        this.ald_rt_total1 = ald_rt_total1;
    }
    public String getAld_rt_total2() {
        return ald_rt_total2;
    }
    public void setAld_rt_total2(String ald_rt_total2) {
        this.ald_rt_total2 = ald_rt_total2;
    }
    public String getAld_rt_total3() {
        return ald_rt_total3;
    }
    public void setAld_rt_total3(String ald_rt_total3) {
        this.ald_rt_total3 = ald_rt_total3;
    }
    public String getAld_rt_total4() {
        return ald_rt_total4;
    }
    public void setAld_rt_total4(String ald_rt_total4) {
        this.ald_rt_total4 = ald_rt_total4;
    }
    public String getAld_rt_total5() {
        return ald_rt_total5;
    }
    public void setAld_rt_total5(String ald_rt_total5) {
        this.ald_rt_total5 = ald_rt_total5;
    }
    public String getAld_sp_label1() {
        return ald_sp_label1;
    }
    public void setAld_sp_label1(String ald_sp_label1) {
        this.ald_sp_label1 = ald_sp_label1;
    }
    public String getAld_sp_label2() {
        return ald_sp_label2;
    }
    public void setAld_sp_label2(String ald_sp_label2) {
        this.ald_sp_label2 = ald_sp_label2;
    }
    public String getAld_sp_label3() {
        return ald_sp_label3;
    }
    public void setAld_sp_label3(String ald_sp_label3) {
        this.ald_sp_label3 = ald_sp_label3;
    }
    public String getAld_sp_label4() {
        return ald_sp_label4;
    }
    public void setAld_sp_label4(String ald_sp_label4) {
        this.ald_sp_label4 = ald_sp_label4;
    }
    public String getAld_sp_label5() {
        return ald_sp_label5;
    }
    public void setAld_sp_label5(String ald_sp_label5) {
        this.ald_sp_label5 = ald_sp_label5;
    }
    public String getAld_sp_total1() {
        return ald_sp_total1;
    }
    public void setAld_sp_total1(String ald_sp_total1) {
        this.ald_sp_total1 = ald_sp_total1;
    }
    public String getAld_sp_total2() {
        return ald_sp_total2;
    }
    public void setAld_sp_total2(String ald_sp_total2) {
        this.ald_sp_total2 = ald_sp_total2;
    }
    public String getAld_sp_total3() {
        return ald_sp_total3;
    }
    public void setAld_sp_total3(String ald_sp_total3) {
        this.ald_sp_total3 = ald_sp_total3;
    }
    public String getAld_sp_total4() {
        return ald_sp_total4;
    }
    public void setAld_sp_total4(String ald_sp_total4) {
        this.ald_sp_total4 = ald_sp_total4;
    }
    public String getAld_sp_total5() {
        return ald_sp_total5;
    }
    public void setAld_sp_total5(String ald_sp_total5) {
        this.ald_sp_total5 = ald_sp_total5;
    }
    public String getAld_sw_label1() {
        return ald_sw_label1;
    }
    public void setAld_sw_label1(String ald_sw_label1) {
        this.ald_sw_label1 = ald_sw_label1;
    }
    public String getAld_sw_label2() {
        return ald_sw_label2;
    }
    public void setAld_sw_label2(String ald_sw_label2) {
        this.ald_sw_label2 = ald_sw_label2;
    }
    public String getAld_sw_label3() {
        return ald_sw_label3;
    }
    public void setAld_sw_label3(String ald_sw_label3) {
        this.ald_sw_label3 = ald_sw_label3;
    }
    public String getAld_sw_label4() {
        return ald_sw_label4;
    }
    public void setAld_sw_label4(String ald_sw_label4) {
        this.ald_sw_label4 = ald_sw_label4;
    }
    public String getAld_sw_label5() {
        return ald_sw_label5;
    }
    public void setAld_sw_label5(String ald_sw_label5) {
        this.ald_sw_label5 = ald_sw_label5;
    }
    public String getAld_sw_total1() {
        return ald_sw_total1;
    }
    public void setAld_sw_total1(String ald_sw_total1) {
        this.ald_sw_total1 = ald_sw_total1;
    }
    public String getAld_sw_total2() {
        return ald_sw_total2;
    }
    public void setAld_sw_total2(String ald_sw_total2) {
        this.ald_sw_total2 = ald_sw_total2;
    }
    public String getAld_sw_total3() {
        return ald_sw_total3;
    }
    public void setAld_sw_total3(String ald_sw_total3) {
        this.ald_sw_total3 = ald_sw_total3;
    }
    public String getAld_sw_total4() {
        return ald_sw_total4;
    }
    public void setAld_sw_total4(String ald_sw_total4) {
        this.ald_sw_total4 = ald_sw_total4;
    }
    public String getAld_sw_total5() {
        return ald_sw_total5;
    }
    public void setAld_sw_total5(String ald_sw_total5) {
        this.ald_sw_total5 = ald_sw_total5;
    }
    public String getAllied_label1() {
        return allied_label1;
    }
    public void setAllied_label1(String allied_label1) {
        this.allied_label1 = allied_label1;
    }
    public String getAllied_label2() {
        return allied_label2;
    }
    public void setAllied_label2(String allied_label2) {
        this.allied_label2 = allied_label2;
    }
    public String getAllied_label3() {
        return allied_label3;
    }
    public void setAllied_label3(String allied_label3) {
        this.allied_label3 = allied_label3;
    }
    public String getAllied_label4() {
        return allied_label4;
    }
    public void setAllied_label4(String allied_label4) {
        this.allied_label4 = allied_label4;
    }
    public String getAllied_label5() {
        return allied_label5;
    }
    public void setAllied_label5(String allied_label5) {
        this.allied_label5 = allied_label5;
    }
    public String getAnnual_total1() {
        return annual_total1;
    }
    public void setAnnual_total1(String annual_total1) {
        this.annual_total1 = annual_total1;
    }
    public String getAnnual_total2() {
        return annual_total2;
    }
    public void setAnnual_total2(String annual_total2) {
        this.annual_total2 = annual_total2;
    }
    public String getAnnual_total3() {
        return annual_total3;
    }
    public void setAnnual_total3(String annual_total3) {
        this.annual_total3 = annual_total3;
    }
    public String getAnnual_total4() {
        return annual_total4;
    }
    public void setAnnual_total4(String annual_total4) {
        this.annual_total4 = annual_total4;
    }
    public String getAnnual_total5() {
        return annual_total5;
    }
    public void setAnnual_total5(String annual_total5) {
        this.annual_total5 = annual_total5;
    }
    public String getHprdTotalTue1() {
        return hprdTotalTue1;
    }
    public void setHprdTotalTue1(String hprdTotalTue1) {
        this.hprdTotalTue1 = hprdTotalTue1;
    }
    public String getHprdTotalTue2() {
        return hprdTotalTue2;
    }
    public void setHprdTotalTue2(String hprdTotalTue2) {
        this.hprdTotalTue2 = hprdTotalTue2;
    }
    public String getHprdTotalTue3() {
        return hprdTotalTue3;
    }
    public void setHprdTotalTue3(String hprdTotalTue3) {
        this.hprdTotalTue3 = hprdTotalTue3;
    }
    public String getHprdTotalTue4() {
        return hprdTotalTue4;
    }
    public void setHprdTotalTue4(String hprdTotalTue4) {
        this.hprdTotalTue4 = hprdTotalTue4;
    }
    public String getHprdTotalTue5() {
        return hprdTotalTue5;
    }
    public void setHprdTotalTue5(String hprdTotalTue5) {
        this.hprdTotalTue5 = hprdTotalTue5;
    }
    public String getNnp_other_mon() {
        return nnp_other_mon;
    }
    public void setNnp_other_mon(String nnp_other_mon) {
        this.nnp_other_mon = nnp_other_mon;
    }
    public String getNp_fri_total1() {
        return np_fri_total1;
    }
    public void setNp_fri_total1(String np_fri_total1) {
        this.np_fri_total1 = np_fri_total1;
    }
    public String getNp_fri_total2() {
        return np_fri_total2;
    }
    public void setNp_fri_total2(String np_fri_total2) {
        this.np_fri_total2 = np_fri_total2;
    }
    public String getNp_fri_total3() {
        return np_fri_total3;
    }
    public void setNp_fri_total3(String np_fri_total3) {
        this.np_fri_total3 = np_fri_total3;
    }
    public String getNp_fri_total4() {
        return np_fri_total4;
    }
    public void setNp_fri_total4(String np_fri_total4) {
        this.np_fri_total4 = np_fri_total4;
    }
    public String getNp_fri_total5() {
        return np_fri_total5;
    }
    public void setNp_fri_total5(String np_fri_total5) {
        this.np_fri_total5 = np_fri_total5;
    }
    public String getNp_mon_total1() {
        return np_mon_total1;
    }
    public void setNp_mon_total1(String np_mon_total1) {
        this.np_mon_total1 = np_mon_total1;
    }
    public String getNp_mon_total2() {
        return np_mon_total2;
    }
    public void setNp_mon_total2(String np_mon_total2) {
        this.np_mon_total2 = np_mon_total2;
    }
    public String getNp_mon_total3() {
        return np_mon_total3;
    }
    public void setNp_mon_total3(String np_mon_total3) {
        this.np_mon_total3 = np_mon_total3;
    }
    public String getNp_mon_total4() {
        return np_mon_total4;
    }
    public void setNp_mon_total4(String np_mon_total4) {
        this.np_mon_total4 = np_mon_total4;
    }
    public String getNp_mon_total5() {
        return np_mon_total5;
    }
    public void setNp_mon_total5(String np_mon_total5) {
        this.np_mon_total5 = np_mon_total5;
    }
    public String getNp_sat_total1() {
        return np_sat_total1;
    }
    public void setNp_sat_total1(String np_sat_total1) {
        this.np_sat_total1 = np_sat_total1;
    }
    public String getNp_sat_total2() {
        return np_sat_total2;
    }
    public void setNp_sat_total2(String np_sat_total2) {
        this.np_sat_total2 = np_sat_total2;
    }
    public String getNp_sat_total3() {
        return np_sat_total3;
    }
    public void setNp_sat_total3(String np_sat_total3) {
        this.np_sat_total3 = np_sat_total3;
    }
    public String getNp_sat_total4() {
        return np_sat_total4;
    }
    public void setNp_sat_total4(String np_sat_total4) {
        this.np_sat_total4 = np_sat_total4;
    }
    public String getNp_sat_total5() {
        return np_sat_total5;
    }
    public void setNp_sat_total5(String np_sat_total5) {
        this.np_sat_total5 = np_sat_total5;
    }
    public String getNp_sun_total1() {
        return np_sun_total1;
    }
    public void setNp_sun_total1(String np_sun_total1) {
        this.np_sun_total1 = np_sun_total1;
    }
    public String getNp_sun_total2() {
        return np_sun_total2;
    }
    public void setNp_sun_total2(String np_sun_total2) {
        this.np_sun_total2 = np_sun_total2;
    }
    public String getNp_sun_total3() {
        return np_sun_total3;
    }
    public void setNp_sun_total3(String np_sun_total3) {
        this.np_sun_total3 = np_sun_total3;
    }
    public String getNp_sun_total4() {
        return np_sun_total4;
    }
    public void setNp_sun_total4(String np_sun_total4) {
        this.np_sun_total4 = np_sun_total4;
    }
    public String getNp_sun_total5() {
        return np_sun_total5;
    }
    public void setNp_sun_total5(String np_sun_total5) {
        this.np_sun_total5 = np_sun_total5;
    }
    public String getNp_thu_total1() {
        return np_thu_total1;
    }
    public void setNp_thu_total1(String np_thu_total1) {
        this.np_thu_total1 = np_thu_total1;
    }
    public String getNp_thu_total2() {
        return np_thu_total2;
    }
    public void setNp_thu_total2(String np_thu_total2) {
        this.np_thu_total2 = np_thu_total2;
    }
    public String getNp_thu_total3() {
        return np_thu_total3;
    }
    public void setNp_thu_total3(String np_thu_total3) {
        this.np_thu_total3 = np_thu_total3;
    }
    public String getNp_thu_total4() {
        return np_thu_total4;
    }
    public void setNp_thu_total4(String np_thu_total4) {
        this.np_thu_total4 = np_thu_total4;
    }
    public String getNp_thu_total5() {
        return np_thu_total5;
    }
    public void setNp_thu_total5(String np_thu_total5) {
        this.np_thu_total5 = np_thu_total5;
    }
    public String getNp_tue_total1() {
        return np_tue_total1;
    }
    public void setNp_tue_total1(String np_tue_total1) {
        this.np_tue_total1 = np_tue_total1;
    }
    public String getNp_tue_total2() {
        return np_tue_total2;
    }
    public void setNp_tue_total2(String np_tue_total2) {
        this.np_tue_total2 = np_tue_total2;
    }
    public String getNp_tue_total3() {
        return np_tue_total3;
    }
    public void setNp_tue_total3(String np_tue_total3) {
        this.np_tue_total3 = np_tue_total3;
    }
    public String getNp_tue_total4() {
        return np_tue_total4;
    }
    public void setNp_tue_total4(String np_tue_total4) {
        this.np_tue_total4 = np_tue_total4;
    }
    public String getNp_tue_total5() {
        return np_tue_total5;
    }
    public void setNp_tue_total5(String np_tue_total5) {
        this.np_tue_total5 = np_tue_total5;
    }
    public String getNp_wed_total1() {
        return np_wed_total1;
    }
    public void setNp_wed_total1(String np_wed_total1) {
        this.np_wed_total1 = np_wed_total1;
    }
    public String getNp_wed_total2() {
        return np_wed_total2;
    }
    public void setNp_wed_total2(String np_wed_total2) {
        this.np_wed_total2 = np_wed_total2;
    }
    public String getNp_wed_total3() {
        return np_wed_total3;
    }
    public void setNp_wed_total3(String np_wed_total3) {
        this.np_wed_total3 = np_wed_total3;
    }
    public String getNp_wed_total4() {
        return np_wed_total4;
    }
    public void setNp_wed_total4(String np_wed_total4) {
        this.np_wed_total4 = np_wed_total4;
    }
    public String getNp_wed_total5() {
        return np_wed_total5;
    }
    public void setNp_wed_total5(String np_wed_total5) {
        this.np_wed_total5 = np_wed_total5;
    }
    public String getRevisionDate1() {
        return revisionDate1;
    }
    public void setRevisionDate1(String revisionDate1) {
        this.revisionDate1 = revisionDate1;
    }
    public String getRevisionDate2() {
        return revisionDate2;
    }
    public void setRevisionDate2(String revisionDate2) {
        this.revisionDate2 = revisionDate2;
    }
    public String getRevisionDate3() {
        return revisionDate3;
    }
    public void setRevisionDate3(String revisionDate3) {
        this.revisionDate3 = revisionDate3;
    }
    public String getRevisionDate4() {
        return revisionDate4;
    }
    public void setRevisionDate4(String revisionDate4) {
        this.revisionDate4 = revisionDate4;
    }
    public String getRevisionDate5() {
        return revisionDate5;
    }
    public void setRevisionDate5(String revisionDate5) {
        this.revisionDate5 = revisionDate5;
    }
    public String getRn_day_label() {
        return rn_day_label;
    }
    public void setRn_day_label(String rn_day_label) {
        this.rn_day_label = rn_day_label;
    }
    public String getRn_day_label1() {
        return rn_day_label1;
    }
    public void setRn_day_label1(String rn_day_label1) {
        this.rn_day_label1 = rn_day_label1;
    }
    public String getRn_day_label2() {
        return rn_day_label2;
    }
    public void setRn_day_label2(String rn_day_label2) {
        this.rn_day_label2 = rn_day_label2;
    }
    public String getRn_day_label3() {
        return rn_day_label3;
    }
    public void setRn_day_label3(String rn_day_label3) {
        this.rn_day_label3 = rn_day_label3;
    }
    public String getRn_day_label4() {
        return rn_day_label4;
    }
    public void setRn_day_label4(String rn_day_label4) {
        this.rn_day_label4 = rn_day_label4;
    }
    public String getRn_day_label5() {
        return rn_day_label5;
    }
    public void setRn_day_label5(String rn_day_label5) {
        this.rn_day_label5 = rn_day_label5;
    }
    public String getRn_day_total1() {
        return rn_day_total1;
    }
    public void setRn_day_total1(String rn_day_total1) {
        this.rn_day_total1 = rn_day_total1;
    }
    public String getRn_day_total2() {
        return rn_day_total2;
    }
    public void setRn_day_total2(String rn_day_total2) {
        this.rn_day_total2 = rn_day_total2;
    }
    public String getRn_day_total3() {
        return rn_day_total3;
    }
    public void setRn_day_total3(String rn_day_total3) {
        this.rn_day_total3 = rn_day_total3;
    }
    public String getRn_day_total4() {
        return rn_day_total4;
    }
    public void setRn_day_total4(String rn_day_total4) {
        this.rn_day_total4 = rn_day_total4;
    }
    public String getRn_day_total5() {
        return rn_day_total5;
    }
    public void setRn_day_total5(String rn_day_total5) {
        this.rn_day_total5 = rn_day_total5;
    }
    public String getRn_eve_label() {
        return rn_eve_label;
    }
    public void setRn_eve_label(String rn_eve_label) {
        this.rn_eve_label = rn_eve_label;
    }
    public String getRn_eve_label1() {
        return rn_eve_label1;
    }
    public void setRn_eve_label1(String rn_eve_label1) {
        this.rn_eve_label1 = rn_eve_label1;
    }
    public String getRn_eve_label2() {
        return rn_eve_label2;
    }
    public void setRn_eve_label2(String rn_eve_label2) {
        this.rn_eve_label2 = rn_eve_label2;
    }
    public String getRn_eve_label3() {
        return rn_eve_label3;
    }
    public void setRn_eve_label3(String rn_eve_label3) {
        this.rn_eve_label3 = rn_eve_label3;
    }
    public String getRn_eve_label4() {
        return rn_eve_label4;
    }
    public void setRn_eve_label4(String rn_eve_label4) {
        this.rn_eve_label4 = rn_eve_label4;
    }
    public String getRn_eve_label5() {
        return rn_eve_label5;
    }
    public void setRn_eve_label5(String rn_eve_label5) {
        this.rn_eve_label5 = rn_eve_label5;
    }
    public String getRn_eve_total1() {
        return rn_eve_total1;
    }
    public void setRn_eve_total1(String rn_eve_total1) {
        this.rn_eve_total1 = rn_eve_total1;
    }
    public String getRn_eve_total2() {
        return rn_eve_total2;
    }
    public void setRn_eve_total2(String rn_eve_total2) {
        this.rn_eve_total2 = rn_eve_total2;
    }
    public String getRn_eve_total3() {
        return rn_eve_total3;
    }
    public void setRn_eve_total3(String rn_eve_total3) {
        this.rn_eve_total3 = rn_eve_total3;
    }
    public String getRn_eve_total4() {
        return rn_eve_total4;
    }
    public void setRn_eve_total4(String rn_eve_total4) {
        this.rn_eve_total4 = rn_eve_total4;
    }
    public String getRn_eve_total5() {
        return rn_eve_total5;
    }
    public void setRn_eve_total5(String rn_eve_total5) {
        this.rn_eve_total5 = rn_eve_total5;
    }
    public String getRn_fri_total1() {
        return rn_fri_total1;
    }
    public void setRn_fri_total1(String rn_fri_total1) {
        this.rn_fri_total1 = rn_fri_total1;
    }
    public String getRn_fri_total2() {
        return rn_fri_total2;
    }
    public void setRn_fri_total2(String rn_fri_total2) {
        this.rn_fri_total2 = rn_fri_total2;
    }
    public String getRn_fri_total3() {
        return rn_fri_total3;
    }
    public void setRn_fri_total3(String rn_fri_total3) {
        this.rn_fri_total3 = rn_fri_total3;
    }
    public String getRn_fri_total4() {
        return rn_fri_total4;
    }
    public void setRn_fri_total4(String rn_fri_total4) {
        this.rn_fri_total4 = rn_fri_total4;
    }
    public String getRn_fri_total5() {
        return rn_fri_total5;
    }
    public void setRn_fri_total5(String rn_fri_total5) {
        this.rn_fri_total5 = rn_fri_total5;
    }
    public String getRn_mon_total1() {
        return rn_mon_total1;
    }
    public void setRn_mon_total1(String rn_mon_total1) {
        this.rn_mon_total1 = rn_mon_total1;
    }
    public String getRn_mon_total2() {
        return rn_mon_total2;
    }
    public void setRn_mon_total2(String rn_mon_total2) {
        this.rn_mon_total2 = rn_mon_total2;
    }
    public String getRn_mon_total3() {
        return rn_mon_total3;
    }
    public void setRn_mon_total3(String rn_mon_total3) {
        this.rn_mon_total3 = rn_mon_total3;
    }
    public String getRn_mon_total4() {
        return rn_mon_total4;
    }
    public void setRn_mon_total4(String rn_mon_total4) {
        this.rn_mon_total4 = rn_mon_total4;
    }
    public String getRn_mon_total5() {
        return rn_mon_total5;
    }
    public void setRn_mon_total5(String rn_mon_total5) {
        this.rn_mon_total5 = rn_mon_total5;
    }
    public String getRn_night_fri1() {
        return rn_night_fri1;
    }
    public void setRn_night_fri1(String rn_night_fri1) {
        this.rn_night_fri1 = rn_night_fri1;
    }
    public String getRn_night_fri2() {
        return rn_night_fri2;
    }
    public void setRn_night_fri2(String rn_night_fri2) {
        this.rn_night_fri2 = rn_night_fri2;
    }
    public String getRn_night_fri3() {
        return rn_night_fri3;
    }
    public void setRn_night_fri3(String rn_night_fri3) {
        this.rn_night_fri3 = rn_night_fri3;
    }
    public String getRn_night_fri4() {
        return rn_night_fri4;
    }
    public void setRn_night_fri4(String rn_night_fri4) {
        this.rn_night_fri4 = rn_night_fri4;
    }
    public String getRn_night_fri5() {
        return rn_night_fri5;
    }
    public void setRn_night_fri5(String rn_night_fri5) {
        this.rn_night_fri5 = rn_night_fri5;
    }
    public String getRn_night_mon1() {
        return rn_night_mon1;
    }
    public void setRn_night_mon1(String rn_night_mon1) {
        this.rn_night_mon1 = rn_night_mon1;
    }
    public String getRn_night_mon2() {
        return rn_night_mon2;
    }
    public void setRn_night_mon2(String rn_night_mon2) {
        this.rn_night_mon2 = rn_night_mon2;
    }
    public String getRn_night_mon3() {
        return rn_night_mon3;
    }
    public void setRn_night_mon3(String rn_night_mon3) {
        this.rn_night_mon3 = rn_night_mon3;
    }
    public String getRn_night_mon4() {
        return rn_night_mon4;
    }
    public void setRn_night_mon4(String rn_night_mon4) {
        this.rn_night_mon4 = rn_night_mon4;
    }
    public String getRn_night_mon5() {
        return rn_night_mon5;
    }
    public void setRn_night_mon5(String rn_night_mon5) {
        this.rn_night_mon5 = rn_night_mon5;
    }
    public String getRn_night_sat1() {
        return rn_night_sat1;
    }
    public void setRn_night_sat1(String rn_night_sat1) {
        this.rn_night_sat1 = rn_night_sat1;
    }
    public String getRn_night_sat2() {
        return rn_night_sat2;
    }
    public void setRn_night_sat2(String rn_night_sat2) {
        this.rn_night_sat2 = rn_night_sat2;
    }
    public String getRn_night_sat3() {
        return rn_night_sat3;
    }
    public void setRn_night_sat3(String rn_night_sat3) {
        this.rn_night_sat3 = rn_night_sat3;
    }
    public String getRn_night_sat4() {
        return rn_night_sat4;
    }
    public void setRn_night_sat4(String rn_night_sat4) {
        this.rn_night_sat4 = rn_night_sat4;
    }
    public String getRn_night_sat5() {
        return rn_night_sat5;
    }
    public void setRn_night_sat5(String rn_night_sat5) {
        this.rn_night_sat5 = rn_night_sat5;
    }
    public String getRn_night_sun1() {
        return rn_night_sun1;
    }
    public void setRn_night_sun1(String rn_night_sun1) {
        this.rn_night_sun1 = rn_night_sun1;
    }
    public String getRn_night_sun2() {
        return rn_night_sun2;
    }
    public void setRn_night_sun2(String rn_night_sun2) {
        this.rn_night_sun2 = rn_night_sun2;
    }
    public String getRn_night_sun3() {
        return rn_night_sun3;
    }
    public void setRn_night_sun3(String rn_night_sun3) {
        this.rn_night_sun3 = rn_night_sun3;
    }
    public String getRn_night_sun4() {
        return rn_night_sun4;
    }
    public void setRn_night_sun4(String rn_night_sun4) {
        this.rn_night_sun4 = rn_night_sun4;
    }
    public String getRn_night_sun5() {
        return rn_night_sun5;
    }
    public void setRn_night_sun5(String rn_night_sun5) {
        this.rn_night_sun5 = rn_night_sun5;
    }
    public String getRn_night_thu1() {
        return rn_night_thu1;
    }
    public void setRn_night_thu1(String rn_night_thu1) {
        this.rn_night_thu1 = rn_night_thu1;
    }
    public String getRn_night_thu2() {
        return rn_night_thu2;
    }
    public void setRn_night_thu2(String rn_night_thu2) {
        this.rn_night_thu2 = rn_night_thu2;
    }
    public String getRn_night_thu3() {
        return rn_night_thu3;
    }
    public void setRn_night_thu3(String rn_night_thu3) {
        this.rn_night_thu3 = rn_night_thu3;
    }
    public String getRn_night_thu4() {
        return rn_night_thu4;
    }
    public void setRn_night_thu4(String rn_night_thu4) {
        this.rn_night_thu4 = rn_night_thu4;
    }
    public String getRn_night_thu5() {
        return rn_night_thu5;
    }
    public void setRn_night_thu5(String rn_night_thu5) {
        this.rn_night_thu5 = rn_night_thu5;
    }
    public String getRn_night_tue1() {
        return rn_night_tue1;
    }
    public void setRn_night_tue1(String rn_night_tue1) {
        this.rn_night_tue1 = rn_night_tue1;
    }
    public String getRn_night_tue2() {
        return rn_night_tue2;
    }
    public void setRn_night_tue2(String rn_night_tue2) {
        this.rn_night_tue2 = rn_night_tue2;
    }
    public String getRn_night_tue3() {
        return rn_night_tue3;
    }
    public void setRn_night_tue3(String rn_night_tue3) {
        this.rn_night_tue3 = rn_night_tue3;
    }
    public String getRn_night_tue4() {
        return rn_night_tue4;
    }
    public void setRn_night_tue4(String rn_night_tue4) {
        this.rn_night_tue4 = rn_night_tue4;
    }
    public String getRn_night_tue5() {
        return rn_night_tue5;
    }
    public void setRn_night_tue5(String rn_night_tue5) {
        this.rn_night_tue5 = rn_night_tue5;
    }
    public String getRn_night_wed1() {
        return rn_night_wed1;
    }
    public void setRn_night_wed1(String rn_night_wed1) {
        this.rn_night_wed1 = rn_night_wed1;
    }
    public String getRn_night_wed2() {
        return rn_night_wed2;
    }
    public void setRn_night_wed2(String rn_night_wed2) {
        this.rn_night_wed2 = rn_night_wed2;
    }
    public String getRn_night_wed3() {
        return rn_night_wed3;
    }
    public void setRn_night_wed3(String rn_night_wed3) {
        this.rn_night_wed3 = rn_night_wed3;
    }
    public String getRn_night_wed4() {
        return rn_night_wed4;
    }
    public void setRn_night_wed4(String rn_night_wed4) {
        this.rn_night_wed4 = rn_night_wed4;
    }
    public String getRn_night_wed5() {
        return rn_night_wed5;
    }
    public void setRn_night_wed5(String rn_night_wed5) {
        this.rn_night_wed5 = rn_night_wed5;
    }
    public String getRn_sat_total1() {
        return rn_sat_total1;
    }
    public void setRn_sat_total1(String rn_sat_total1) {
        this.rn_sat_total1 = rn_sat_total1;
    }
    public String getRn_sat_total2() {
        return rn_sat_total2;
    }
    public void setRn_sat_total2(String rn_sat_total2) {
        this.rn_sat_total2 = rn_sat_total2;
    }
    public String getRn_sat_total3() {
        return rn_sat_total3;
    }
    public void setRn_sat_total3(String rn_sat_total3) {
        this.rn_sat_total3 = rn_sat_total3;
    }
    public String getRn_sat_total4() {
        return rn_sat_total4;
    }
    public void setRn_sat_total4(String rn_sat_total4) {
        this.rn_sat_total4 = rn_sat_total4;
    }
    public String getRn_sat_total5() {
        return rn_sat_total5;
    }
    public void setRn_sat_total5(String rn_sat_total5) {
        this.rn_sat_total5 = rn_sat_total5;
    }
    public String getRn_sun_total1() {
        return rn_sun_total1;
    }
    public void setRn_sun_total1(String rn_sun_total1) {
        this.rn_sun_total1 = rn_sun_total1;
    }
    public String getRn_sun_total2() {
        return rn_sun_total2;
    }
    public void setRn_sun_total2(String rn_sun_total2) {
        this.rn_sun_total2 = rn_sun_total2;
    }
    public String getRn_sun_total3() {
        return rn_sun_total3;
    }
    public void setRn_sun_total3(String rn_sun_total3) {
        this.rn_sun_total3 = rn_sun_total3;
    }
    public String getRn_sun_total4() {
        return rn_sun_total4;
    }
    public void setRn_sun_total4(String rn_sun_total4) {
        this.rn_sun_total4 = rn_sun_total4;
    }
    public String getRn_sun_total5() {
        return rn_sun_total5;
    }
    public void setRn_sun_total5(String rn_sun_total5) {
        this.rn_sun_total5 = rn_sun_total5;
    }
    public String getRn_thu_total1() {
        return rn_thu_total1;
    }
    public void setRn_thu_total1(String rn_thu_total1) {
        this.rn_thu_total1 = rn_thu_total1;
    }
    public String getRn_thu_total2() {
        return rn_thu_total2;
    }
    public void setRn_thu_total2(String rn_thu_total2) {
        this.rn_thu_total2 = rn_thu_total2;
    }
    public String getRn_thu_total3() {
        return rn_thu_total3;
    }
    public void setRn_thu_total3(String rn_thu_total3) {
        this.rn_thu_total3 = rn_thu_total3;
    }
    public String getRn_thu_total4() {
        return rn_thu_total4;
    }
    public void setRn_thu_total4(String rn_thu_total4) {
        this.rn_thu_total4 = rn_thu_total4;
    }
    public String getRn_thu_total5() {
        return rn_thu_total5;
    }
    public void setRn_thu_total5(String rn_thu_total5) {
        this.rn_thu_total5 = rn_thu_total5;
    }
    public String getRn_tue_total1() {
        return rn_tue_total1;
    }
    public void setRn_tue_total1(String rn_tue_total1) {
        this.rn_tue_total1 = rn_tue_total1;
    }
    public String getRn_tue_total2() {
        return rn_tue_total2;
    }
    public void setRn_tue_total2(String rn_tue_total2) {
        this.rn_tue_total2 = rn_tue_total2;
    }
    public String getRn_tue_total3() {
        return rn_tue_total3;
    }
    public void setRn_tue_total3(String rn_tue_total3) {
        this.rn_tue_total3 = rn_tue_total3;
    }
    public String getRn_tue_total4() {
        return rn_tue_total4;
    }
    public void setRn_tue_total4(String rn_tue_total4) {
        this.rn_tue_total4 = rn_tue_total4;
    }
    public String getRn_tue_total5() {
        return rn_tue_total5;
    }
    public void setRn_tue_total5(String rn_tue_total5) {
        this.rn_tue_total5 = rn_tue_total5;
    }
    public String getRn_wed_total1() {
        return rn_wed_total1;
    }
    public void setRn_wed_total1(String rn_wed_total1) {
        this.rn_wed_total1 = rn_wed_total1;
    }
    public String getRn_wed_total2() {
        return rn_wed_total2;
    }
    public void setRn_wed_total2(String rn_wed_total2) {
        this.rn_wed_total2 = rn_wed_total2;
    }
    public String getRn_wed_total3() {
        return rn_wed_total3;
    }
    public void setRn_wed_total3(String rn_wed_total3) {
        this.rn_wed_total3 = rn_wed_total3;
    }
    public String getRn_wed_total4() {
        return rn_wed_total4;
    }
    public void setRn_wed_total4(String rn_wed_total4) {
        this.rn_wed_total4 = rn_wed_total4;
    }
    public String getRn_wed_total5() {
        return rn_wed_total5;
    }
    public void setRn_wed_total5(String rn_wed_total5) {
        this.rn_wed_total5 = rn_wed_total5;
    }
    public String getAld_dt_annual1() {
        return ald_dt_annual1;
    }
    public void setAld_dt_annual1(String ald_dt_annual1) {
        this.ald_dt_annual1 = ald_dt_annual1;
    }
    public String getAld_dt_annual2() {
        return ald_dt_annual2;
    }
    public void setAld_dt_annual2(String ald_dt_annual2) {
        this.ald_dt_annual2 = ald_dt_annual2;
    }
    public String getAld_dt_annual3() {
        return ald_dt_annual3;
    }
    public void setAld_dt_annual3(String ald_dt_annual3) {
        this.ald_dt_annual3 = ald_dt_annual3;
    }
    public String getAld_dt_annual4() {
        return ald_dt_annual4;
    }
    public void setAld_dt_annual4(String ald_dt_annual4) {
        this.ald_dt_annual4 = ald_dt_annual4;
    }
    public String getAld_dt_annual5() {
        return ald_dt_annual5;
    }
    public void setAld_dt_annual5(String ald_dt_annual5) {
        this.ald_dt_annual5 = ald_dt_annual5;
    }
    public String getAld_fri_total1() {
        return ald_fri_total1;
    }
    public void setAld_fri_total1(String ald_fri_total1) {
        this.ald_fri_total1 = ald_fri_total1;
    }
    public String getAld_fri_total2() {
        return ald_fri_total2;
    }
    public void setAld_fri_total2(String ald_fri_total2) {
        this.ald_fri_total2 = ald_fri_total2;
    }
    public String getAld_fri_total3() {
        return ald_fri_total3;
    }
    public void setAld_fri_total3(String ald_fri_total3) {
        this.ald_fri_total3 = ald_fri_total3;
    }
    public String getAld_fri_total4() {
        return ald_fri_total4;
    }
    public void setAld_fri_total4(String ald_fri_total4) {
        this.ald_fri_total4 = ald_fri_total4;
    }
    public String getAld_fri_total5() {
        return ald_fri_total5;
    }
    public void setAld_fri_total5(String ald_fri_total5) {
        this.ald_fri_total5 = ald_fri_total5;
    }
    public String getAld_mon_total1() {
        return ald_mon_total1;
    }
    public void setAld_mon_total1(String ald_mon_total1) {
        this.ald_mon_total1 = ald_mon_total1;
    }
    public String getAld_mon_total2() {
        return ald_mon_total2;
    }
    public void setAld_mon_total2(String ald_mon_total2) {
        this.ald_mon_total2 = ald_mon_total2;
    }
    public String getAld_mon_total3() {
        return ald_mon_total3;
    }
    public void setAld_mon_total3(String ald_mon_total3) {
        this.ald_mon_total3 = ald_mon_total3;
    }
    public String getAld_mon_total4() {
        return ald_mon_total4;
    }
    public void setAld_mon_total4(String ald_mon_total4) {
        this.ald_mon_total4 = ald_mon_total4;
    }
    public String getAld_mon_total5() {
        return ald_mon_total5;
    }
    public void setAld_mon_total5(String ald_mon_total5) {
        this.ald_mon_total5 = ald_mon_total5;
    }
    public String getAld_ot_annual1() {
        return ald_ot_annual1;
    }
    public void setAld_ot_annual1(String ald_ot_annual1) {
        this.ald_ot_annual1 = ald_ot_annual1;
    }
    public String getAld_ot_annual2() {
        return ald_ot_annual2;
    }
    public void setAld_ot_annual2(String ald_ot_annual2) {
        this.ald_ot_annual2 = ald_ot_annual2;
    }
    public String getAld_ot_annual3() {
        return ald_ot_annual3;
    }
    public void setAld_ot_annual3(String ald_ot_annual3) {
        this.ald_ot_annual3 = ald_ot_annual3;
    }
    public String getAld_ot_annual4() {
        return ald_ot_annual4;
    }
    public void setAld_ot_annual4(String ald_ot_annual4) {
        this.ald_ot_annual4 = ald_ot_annual4;
    }
    public String getAld_ot_annual5() {
        return ald_ot_annual5;
    }
    public void setAld_ot_annual5(String ald_ot_annual5) {
        this.ald_ot_annual5 = ald_ot_annual5;
    }
    public String getAld_pt_annual1() {
        return ald_pt_annual1;
    }
    public void setAld_pt_annual1(String ald_pt_annual1) {
        this.ald_pt_annual1 = ald_pt_annual1;
    }
    public String getAld_pt_annual2() {
        return ald_pt_annual2;
    }
    public void setAld_pt_annual2(String ald_pt_annual2) {
        this.ald_pt_annual2 = ald_pt_annual2;
    }
    public String getAld_pt_annual3() {
        return ald_pt_annual3;
    }
    public void setAld_pt_annual3(String ald_pt_annual3) {
        this.ald_pt_annual3 = ald_pt_annual3;
    }
    public String getAld_pt_annual4() {
        return ald_pt_annual4;
    }
    public void setAld_pt_annual4(String ald_pt_annual4) {
        this.ald_pt_annual4 = ald_pt_annual4;
    }
    public String getAld_pt_annual5() {
        return ald_pt_annual5;
    }
    public void setAld_pt_annual5(String ald_pt_annual5) {
        this.ald_pt_annual5 = ald_pt_annual5;
    }
    public String getAld_rt_annual1() {
        return ald_rt_annual1;
    }
    public void setAld_rt_annual1(String ald_rt_annual1) {
        this.ald_rt_annual1 = ald_rt_annual1;
    }
    public String getAld_rt_annual2() {
        return ald_rt_annual2;
    }
    public void setAld_rt_annual2(String ald_rt_annual2) {
        this.ald_rt_annual2 = ald_rt_annual2;
    }
    public String getAld_rt_annual3() {
        return ald_rt_annual3;
    }
    public void setAld_rt_annual3(String ald_rt_annual3) {
        this.ald_rt_annual3 = ald_rt_annual3;
    }
    public String getAld_rt_annual4() {
        return ald_rt_annual4;
    }
    public void setAld_rt_annual4(String ald_rt_annual4) {
        this.ald_rt_annual4 = ald_rt_annual4;
    }
    public String getAld_rt_annual5() {
        return ald_rt_annual5;
    }
    public void setAld_rt_annual5(String ald_rt_annual5) {
        this.ald_rt_annual5 = ald_rt_annual5;
    }
    public String getAld_sat_total1() {
        return ald_sat_total1;
    }
    public void setAld_sat_total1(String ald_sat_total1) {
        this.ald_sat_total1 = ald_sat_total1;
    }
    public String getAld_sat_total2() {
        return ald_sat_total2;
    }
    public void setAld_sat_total2(String ald_sat_total2) {
        this.ald_sat_total2 = ald_sat_total2;
    }
    public String getAld_sat_total3() {
        return ald_sat_total3;
    }
    public void setAld_sat_total3(String ald_sat_total3) {
        this.ald_sat_total3 = ald_sat_total3;
    }
    public String getAld_sat_total4() {
        return ald_sat_total4;
    }
    public void setAld_sat_total4(String ald_sat_total4) {
        this.ald_sat_total4 = ald_sat_total4;
    }
    public String getAld_sat_total5() {
        return ald_sat_total5;
    }
    public void setAld_sat_total5(String ald_sat_total5) {
        this.ald_sat_total5 = ald_sat_total5;
    }
    public String getAld_sp_annual1() {
        return ald_sp_annual1;
    }
    public void setAld_sp_annual1(String ald_sp_annual1) {
        this.ald_sp_annual1 = ald_sp_annual1;
    }
    public String getAld_sp_annual2() {
        return ald_sp_annual2;
    }
    public void setAld_sp_annual2(String ald_sp_annual2) {
        this.ald_sp_annual2 = ald_sp_annual2;
    }
    public String getAld_sp_annual3() {
        return ald_sp_annual3;
    }
    public void setAld_sp_annual3(String ald_sp_annual3) {
        this.ald_sp_annual3 = ald_sp_annual3;
    }
    public String getAld_sp_annual4() {
        return ald_sp_annual4;
    }
    public void setAld_sp_annual4(String ald_sp_annual4) {
        this.ald_sp_annual4 = ald_sp_annual4;
    }
    public String getAld_sp_annual5() {
        return ald_sp_annual5;
    }
    public void setAld_sp_annual5(String ald_sp_annual5) {
        this.ald_sp_annual5 = ald_sp_annual5;
    }
    public String getAld_sun_total1() {
        return ald_sun_total1;
    }
    public void setAld_sun_total1(String ald_sun_total1) {
        this.ald_sun_total1 = ald_sun_total1;
    }
    public String getAld_sun_total2() {
        return ald_sun_total2;
    }
    public void setAld_sun_total2(String ald_sun_total2) {
        this.ald_sun_total2 = ald_sun_total2;
    }
    public String getAld_sun_total3() {
        return ald_sun_total3;
    }
    public void setAld_sun_total3(String ald_sun_total3) {
        this.ald_sun_total3 = ald_sun_total3;
    }
    public String getAld_sun_total4() {
        return ald_sun_total4;
    }
    public void setAld_sun_total4(String ald_sun_total4) {
        this.ald_sun_total4 = ald_sun_total4;
    }
    public String getAld_sun_total5() {
        return ald_sun_total5;
    }
    public void setAld_sun_total5(String ald_sun_total5) {
        this.ald_sun_total5 = ald_sun_total5;
    }
    public String getAld_sw_annual1() {
        return ald_sw_annual1;
    }
    public void setAld_sw_annual1(String ald_sw_annual1) {
        this.ald_sw_annual1 = ald_sw_annual1;
    }
    public String getAld_sw_annual2() {
        return ald_sw_annual2;
    }
    public void setAld_sw_annual2(String ald_sw_annual2) {
        this.ald_sw_annual2 = ald_sw_annual2;
    }
    public String getAld_sw_annual3() {
        return ald_sw_annual3;
    }
    public void setAld_sw_annual3(String ald_sw_annual3) {
        this.ald_sw_annual3 = ald_sw_annual3;
    }
    public String getAld_sw_annual4() {
        return ald_sw_annual4;
    }
    public void setAld_sw_annual4(String ald_sw_annual4) {
        this.ald_sw_annual4 = ald_sw_annual4;
    }
    public String getAld_sw_annual5() {
        return ald_sw_annual5;
    }
    public void setAld_sw_annual5(String ald_sw_annual5) {
        this.ald_sw_annual5 = ald_sw_annual5;
    }
    public String getAld_thu_total1() {
        return ald_thu_total1;
    }
    public void setAld_thu_total1(String ald_thu_total1) {
        this.ald_thu_total1 = ald_thu_total1;
    }
    public String getAld_thu_total2() {
        return ald_thu_total2;
    }
    public void setAld_thu_total2(String ald_thu_total2) {
        this.ald_thu_total2 = ald_thu_total2;
    }
    public String getAld_thu_total3() {
        return ald_thu_total3;
    }
    public void setAld_thu_total3(String ald_thu_total3) {
        this.ald_thu_total3 = ald_thu_total3;
    }
    public String getAld_thu_total4() {
        return ald_thu_total4;
    }
    public void setAld_thu_total4(String ald_thu_total4) {
        this.ald_thu_total4 = ald_thu_total4;
    }
    public String getAld_thu_total5() {
        return ald_thu_total5;
    }
    public void setAld_thu_total5(String ald_thu_total5) {
        this.ald_thu_total5 = ald_thu_total5;
    }
    public String getAld_tue_total1() {
        return ald_tue_total1;
    }
    public void setAld_tue_total1(String ald_tue_total1) {
        this.ald_tue_total1 = ald_tue_total1;
    }
    public String getAld_tue_total2() {
        return ald_tue_total2;
    }
    public void setAld_tue_total2(String ald_tue_total2) {
        this.ald_tue_total2 = ald_tue_total2;
    }
    public String getAld_tue_total3() {
        return ald_tue_total3;
    }
    public void setAld_tue_total3(String ald_tue_total3) {
        this.ald_tue_total3 = ald_tue_total3;
    }
    public String getAld_tue_total4() {
        return ald_tue_total4;
    }
    public void setAld_tue_total4(String ald_tue_total4) {
        this.ald_tue_total4 = ald_tue_total4;
    }
    public String getAld_tue_total5() {
        return ald_tue_total5;
    }
    public void setAld_tue_total5(String ald_tue_total5) {
        this.ald_tue_total5 = ald_tue_total5;
    }
    public String getAld_wed_total1() {
        return ald_wed_total1;
    }
    public void setAld_wed_total1(String ald_wed_total1) {
        this.ald_wed_total1 = ald_wed_total1;
    }
    public String getAld_wed_total2() {
        return ald_wed_total2;
    }
    public void setAld_wed_total2(String ald_wed_total2) {
        this.ald_wed_total2 = ald_wed_total2;
    }
    public String getAld_wed_total3() {
        return ald_wed_total3;
    }
    public void setAld_wed_total3(String ald_wed_total3) {
        this.ald_wed_total3 = ald_wed_total3;
    }
    public String getAld_wed_total4() {
        return ald_wed_total4;
    }
    public void setAld_wed_total4(String ald_wed_total4) {
        this.ald_wed_total4 = ald_wed_total4;
    }
    public String getAld_wed_total5() {
        return ald_wed_total5;
    }
    public void setAld_wed_total5(String ald_wed_total5) {
        this.ald_wed_total5 = ald_wed_total5;
    }
    public String getAldnop_at_fri1() {
        return aldnop_at_fri1;
    }
    public void setAldnop_at_fri1(String aldnop_at_fri1) {
        this.aldnop_at_fri1 = aldnop_at_fri1;
    }
    public String getAldnop_at_fri2() {
        return aldnop_at_fri2;
    }
    public void setAldnop_at_fri2(String aldnop_at_fri2) {
        this.aldnop_at_fri2 = aldnop_at_fri2;
    }
    public String getAldnop_at_fri3() {
        return aldnop_at_fri3;
    }
    public void setAldnop_at_fri3(String aldnop_at_fri3) {
        this.aldnop_at_fri3 = aldnop_at_fri3;
    }
    public String getAldnop_at_fri4() {
        return aldnop_at_fri4;
    }
    public void setAldnop_at_fri4(String aldnop_at_fri4) {
        this.aldnop_at_fri4 = aldnop_at_fri4;
    }
    public String getAldnop_at_fri5() {
        return aldnop_at_fri5;
    }
    public void setAldnop_at_fri5(String aldnop_at_fri5) {
        this.aldnop_at_fri5 = aldnop_at_fri5;
    }
    public String getAldnop_at_mon1() {
        return aldnop_at_mon1;
    }
    public void setAldnop_at_mon1(String aldnop_at_mon1) {
        this.aldnop_at_mon1 = aldnop_at_mon1;
    }
    public String getAldnop_at_mon2() {
        return aldnop_at_mon2;
    }
    public void setAldnop_at_mon2(String aldnop_at_mon2) {
        this.aldnop_at_mon2 = aldnop_at_mon2;
    }
    public String getAldnop_at_mon3() {
        return aldnop_at_mon3;
    }
    public void setAldnop_at_mon3(String aldnop_at_mon3) {
        this.aldnop_at_mon3 = aldnop_at_mon3;
    }
    public String getAldnop_at_mon4() {
        return aldnop_at_mon4;
    }
    public void setAldnop_at_mon4(String aldnop_at_mon4) {
        this.aldnop_at_mon4 = aldnop_at_mon4;
    }
    public String getAldnop_at_mon5() {
        return aldnop_at_mon5;
    }
    public void setAldnop_at_mon5(String aldnop_at_mon5) {
        this.aldnop_at_mon5 = aldnop_at_mon5;
    }
    public String getAldnop_at_sat1() {
        return aldnop_at_sat1;
    }
    public void setAldnop_at_sat1(String aldnop_at_sat1) {
        this.aldnop_at_sat1 = aldnop_at_sat1;
    }
    public String getAldnop_at_sat2() {
        return aldnop_at_sat2;
    }
    public void setAldnop_at_sat2(String aldnop_at_sat2) {
        this.aldnop_at_sat2 = aldnop_at_sat2;
    }
    public String getAldnop_at_sat3() {
        return aldnop_at_sat3;
    }
    public void setAldnop_at_sat3(String aldnop_at_sat3) {
        this.aldnop_at_sat3 = aldnop_at_sat3;
    }
    public String getAldnop_at_sat4() {
        return aldnop_at_sat4;
    }
    public void setAldnop_at_sat4(String aldnop_at_sat4) {
        this.aldnop_at_sat4 = aldnop_at_sat4;
    }
    public String getAldnop_at_sat5() {
        return aldnop_at_sat5;
    }
    public void setAldnop_at_sat5(String aldnop_at_sat5) {
        this.aldnop_at_sat5 = aldnop_at_sat5;
    }
    public String getAldnop_at_sun1() {
        return aldnop_at_sun1;
    }
    public void setAldnop_at_sun1(String aldnop_at_sun1) {
        this.aldnop_at_sun1 = aldnop_at_sun1;
    }
    public String getAldnop_at_sun2() {
        return aldnop_at_sun2;
    }
    public void setAldnop_at_sun2(String aldnop_at_sun2) {
        this.aldnop_at_sun2 = aldnop_at_sun2;
    }
    public String getAldnop_at_sun3() {
        return aldnop_at_sun3;
    }
    public void setAldnop_at_sun3(String aldnop_at_sun3) {
        this.aldnop_at_sun3 = aldnop_at_sun3;
    }
    public String getAldnop_at_sun4() {
        return aldnop_at_sun4;
    }
    public void setAldnop_at_sun4(String aldnop_at_sun4) {
        this.aldnop_at_sun4 = aldnop_at_sun4;
    }
    public String getAldnop_at_sun5() {
        return aldnop_at_sun5;
    }
    public void setAldnop_at_sun5(String aldnop_at_sun5) {
        this.aldnop_at_sun5 = aldnop_at_sun5;
    }
    public String getAldnop_at_thu1() {
        return aldnop_at_thu1;
    }
    public void setAldnop_at_thu1(String aldnop_at_thu1) {
        this.aldnop_at_thu1 = aldnop_at_thu1;
    }
    public String getAldnop_at_thu2() {
        return aldnop_at_thu2;
    }
    public void setAldnop_at_thu2(String aldnop_at_thu2) {
        this.aldnop_at_thu2 = aldnop_at_thu2;
    }
    public String getAldnop_at_thu3() {
        return aldnop_at_thu3;
    }
    public void setAldnop_at_thu3(String aldnop_at_thu3) {
        this.aldnop_at_thu3 = aldnop_at_thu3;
    }
    public String getAldnop_at_thu4() {
        return aldnop_at_thu4;
    }
    public void setAldnop_at_thu4(String aldnop_at_thu4) {
        this.aldnop_at_thu4 = aldnop_at_thu4;
    }
    public String getAldnop_at_thu5() {
        return aldnop_at_thu5;
    }
    public void setAldnop_at_thu5(String aldnop_at_thu5) {
        this.aldnop_at_thu5 = aldnop_at_thu5;
    }
    public String getAldnop_at_tue1() {
        return aldnop_at_tue1;
    }
    public void setAldnop_at_tue1(String aldnop_at_tue1) {
        this.aldnop_at_tue1 = aldnop_at_tue1;
    }
    public String getAldnop_at_tue2() {
        return aldnop_at_tue2;
    }
    public void setAldnop_at_tue2(String aldnop_at_tue2) {
        this.aldnop_at_tue2 = aldnop_at_tue2;
    }
    public String getAldnop_at_tue3() {
        return aldnop_at_tue3;
    }
    public void setAldnop_at_tue3(String aldnop_at_tue3) {
        this.aldnop_at_tue3 = aldnop_at_tue3;
    }
    public String getAldnop_at_tue4() {
        return aldnop_at_tue4;
    }
    public void setAldnop_at_tue4(String aldnop_at_tue4) {
        this.aldnop_at_tue4 = aldnop_at_tue4;
    }
    public String getAldnop_at_tue5() {
        return aldnop_at_tue5;
    }
    public void setAldnop_at_tue5(String aldnop_at_tue5) {
        this.aldnop_at_tue5 = aldnop_at_tue5;
    }
    public String getAldnop_at_wed1() {
        return aldnop_at_wed1;
    }
    public void setAldnop_at_wed1(String aldnop_at_wed1) {
        this.aldnop_at_wed1 = aldnop_at_wed1;
    }
    public String getAldnop_at_wed2() {
        return aldnop_at_wed2;
    }
    public void setAldnop_at_wed2(String aldnop_at_wed2) {
        this.aldnop_at_wed2 = aldnop_at_wed2;
    }
    public String getAldnop_at_wed3() {
        return aldnop_at_wed3;
    }
    public void setAldnop_at_wed3(String aldnop_at_wed3) {
        this.aldnop_at_wed3 = aldnop_at_wed3;
    }
    public String getAldnop_at_wed4() {
        return aldnop_at_wed4;
    }
    public void setAldnop_at_wed4(String aldnop_at_wed4) {
        this.aldnop_at_wed4 = aldnop_at_wed4;
    }
    public String getAldnop_at_wed5() {
        return aldnop_at_wed5;
    }
    public void setAldnop_at_wed5(String aldnop_at_wed5) {
        this.aldnop_at_wed5 = aldnop_at_wed5;
    }
    public String getAldnop_aw_fri1() {
        return aldnop_aw_fri1;
    }
    public void setAldnop_aw_fri1(String aldnop_aw_fri1) {
        this.aldnop_aw_fri1 = aldnop_aw_fri1;
    }
    public String getAldnop_aw_fri2() {
        return aldnop_aw_fri2;
    }
    public void setAldnop_aw_fri2(String aldnop_aw_fri2) {
        this.aldnop_aw_fri2 = aldnop_aw_fri2;
    }
    public String getAldnop_aw_fri3() {
        return aldnop_aw_fri3;
    }
    public void setAldnop_aw_fri3(String aldnop_aw_fri3) {
        this.aldnop_aw_fri3 = aldnop_aw_fri3;
    }
    public String getAldnop_aw_fri4() {
        return aldnop_aw_fri4;
    }
    public void setAldnop_aw_fri4(String aldnop_aw_fri4) {
        this.aldnop_aw_fri4 = aldnop_aw_fri4;
    }
    public String getAldnop_aw_fri5() {
        return aldnop_aw_fri5;
    }
    public void setAldnop_aw_fri5(String aldnop_aw_fri5) {
        this.aldnop_aw_fri5 = aldnop_aw_fri5;
    }
    public String getAldnop_aw_mon1() {
        return aldnop_aw_mon1;
    }
    public void setAldnop_aw_mon1(String aldnop_aw_mon1) {
        this.aldnop_aw_mon1 = aldnop_aw_mon1;
    }
    public String getAldnop_aw_mon2() {
        return aldnop_aw_mon2;
    }
    public void setAldnop_aw_mon2(String aldnop_aw_mon2) {
        this.aldnop_aw_mon2 = aldnop_aw_mon2;
    }
    public String getAldnop_aw_mon3() {
        return aldnop_aw_mon3;
    }
    public void setAldnop_aw_mon3(String aldnop_aw_mon3) {
        this.aldnop_aw_mon3 = aldnop_aw_mon3;
    }
    public String getAldnop_aw_mon4() {
        return aldnop_aw_mon4;
    }
    public void setAldnop_aw_mon4(String aldnop_aw_mon4) {
        this.aldnop_aw_mon4 = aldnop_aw_mon4;
    }
    public String getAldnop_aw_mon5() {
        return aldnop_aw_mon5;
    }
    public void setAldnop_aw_mon5(String aldnop_aw_mon5) {
        this.aldnop_aw_mon5 = aldnop_aw_mon5;
    }
    public String getAldnop_aw_sat1() {
        return aldnop_aw_sat1;
    }
    public void setAldnop_aw_sat1(String aldnop_aw_sat1) {
        this.aldnop_aw_sat1 = aldnop_aw_sat1;
    }
    public String getAldnop_aw_sat2() {
        return aldnop_aw_sat2;
    }
    public void setAldnop_aw_sat2(String aldnop_aw_sat2) {
        this.aldnop_aw_sat2 = aldnop_aw_sat2;
    }
    public String getAldnop_aw_sat3() {
        return aldnop_aw_sat3;
    }
    public void setAldnop_aw_sat3(String aldnop_aw_sat3) {
        this.aldnop_aw_sat3 = aldnop_aw_sat3;
    }
    public String getAldnop_aw_sat4() {
        return aldnop_aw_sat4;
    }
    public void setAldnop_aw_sat4(String aldnop_aw_sat4) {
        this.aldnop_aw_sat4 = aldnop_aw_sat4;
    }
    public String getAldnop_aw_sat5() {
        return aldnop_aw_sat5;
    }
    public void setAldnop_aw_sat5(String aldnop_aw_sat5) {
        this.aldnop_aw_sat5 = aldnop_aw_sat5;
    }
    public String getAldnop_aw_sun1() {
        return aldnop_aw_sun1;
    }
    public void setAldnop_aw_sun1(String aldnop_aw_sun1) {
        this.aldnop_aw_sun1 = aldnop_aw_sun1;
    }
    public String getAldnop_aw_sun2() {
        return aldnop_aw_sun2;
    }
    public void setAldnop_aw_sun2(String aldnop_aw_sun2) {
        this.aldnop_aw_sun2 = aldnop_aw_sun2;
    }
    public String getAldnop_aw_sun3() {
        return aldnop_aw_sun3;
    }
    public void setAldnop_aw_sun3(String aldnop_aw_sun3) {
        this.aldnop_aw_sun3 = aldnop_aw_sun3;
    }
    public String getAldnop_aw_sun4() {
        return aldnop_aw_sun4;
    }
    public void setAldnop_aw_sun4(String aldnop_aw_sun4) {
        this.aldnop_aw_sun4 = aldnop_aw_sun4;
    }
    public String getAldnop_aw_sun5() {
        return aldnop_aw_sun5;
    }
    public void setAldnop_aw_sun5(String aldnop_aw_sun5) {
        this.aldnop_aw_sun5 = aldnop_aw_sun5;
    }
    public String getAldnop_aw_thu1() {
        return aldnop_aw_thu1;
    }
    public void setAldnop_aw_thu1(String aldnop_aw_thu1) {
        this.aldnop_aw_thu1 = aldnop_aw_thu1;
    }
    public String getAldnop_aw_thu2() {
        return aldnop_aw_thu2;
    }
    public void setAldnop_aw_thu2(String aldnop_aw_thu2) {
        this.aldnop_aw_thu2 = aldnop_aw_thu2;
    }
    public String getAldnop_aw_thu3() {
        return aldnop_aw_thu3;
    }
    public void setAldnop_aw_thu3(String aldnop_aw_thu3) {
        this.aldnop_aw_thu3 = aldnop_aw_thu3;
    }
    public String getAldnop_aw_thu4() {
        return aldnop_aw_thu4;
    }
    public void setAldnop_aw_thu4(String aldnop_aw_thu4) {
        this.aldnop_aw_thu4 = aldnop_aw_thu4;
    }
    public String getAldnop_aw_thu5() {
        return aldnop_aw_thu5;
    }
    public void setAldnop_aw_thu5(String aldnop_aw_thu5) {
        this.aldnop_aw_thu5 = aldnop_aw_thu5;
    }
    public String getAldnop_aw_tue1() {
        return aldnop_aw_tue1;
    }
    public void setAldnop_aw_tue1(String aldnop_aw_tue1) {
        this.aldnop_aw_tue1 = aldnop_aw_tue1;
    }
    public String getAldnop_aw_tue2() {
        return aldnop_aw_tue2;
    }
    public void setAldnop_aw_tue2(String aldnop_aw_tue2) {
        this.aldnop_aw_tue2 = aldnop_aw_tue2;
    }
    public String getAldnop_aw_tue3() {
        return aldnop_aw_tue3;
    }
    public void setAldnop_aw_tue3(String aldnop_aw_tue3) {
        this.aldnop_aw_tue3 = aldnop_aw_tue3;
    }
    public String getAldnop_aw_tue4() {
        return aldnop_aw_tue4;
    }
    public void setAldnop_aw_tue4(String aldnop_aw_tue4) {
        this.aldnop_aw_tue4 = aldnop_aw_tue4;
    }
    public String getAldnop_aw_tue5() {
        return aldnop_aw_tue5;
    }
    public void setAldnop_aw_tue5(String aldnop_aw_tue5) {
        this.aldnop_aw_tue5 = aldnop_aw_tue5;
    }
    public String getAldnop_aw_wed1() {
        return aldnop_aw_wed1;
    }
    public void setAldnop_aw_wed1(String aldnop_aw_wed1) {
        this.aldnop_aw_wed1 = aldnop_aw_wed1;
    }
    public String getAldnop_aw_wed2() {
        return aldnop_aw_wed2;
    }
    public void setAldnop_aw_wed2(String aldnop_aw_wed2) {
        this.aldnop_aw_wed2 = aldnop_aw_wed2;
    }
    public String getAldnop_aw_wed3() {
        return aldnop_aw_wed3;
    }
    public void setAldnop_aw_wed3(String aldnop_aw_wed3) {
        this.aldnop_aw_wed3 = aldnop_aw_wed3;
    }
    public String getAldnop_aw_wed4() {
        return aldnop_aw_wed4;
    }
    public void setAldnop_aw_wed4(String aldnop_aw_wed4) {
        this.aldnop_aw_wed4 = aldnop_aw_wed4;
    }
    public String getAldnop_aw_wed5() {
        return aldnop_aw_wed5;
    }
    public void setAldnop_aw_wed5(String aldnop_aw_wed5) {
        this.aldnop_aw_wed5 = aldnop_aw_wed5;
    }
    public String getAldnop_mt_fri1() {
        return aldnop_mt_fri1;
    }
    public void setAldnop_mt_fri1(String aldnop_mt_fri1) {
        this.aldnop_mt_fri1 = aldnop_mt_fri1;
    }
    public String getAldnop_mt_fri2() {
        return aldnop_mt_fri2;
    }
    public void setAldnop_mt_fri2(String aldnop_mt_fri2) {
        this.aldnop_mt_fri2 = aldnop_mt_fri2;
    }
    public String getAldnop_mt_fri3() {
        return aldnop_mt_fri3;
    }
    public void setAldnop_mt_fri3(String aldnop_mt_fri3) {
        this.aldnop_mt_fri3 = aldnop_mt_fri3;
    }
    public String getAldnop_mt_fri4() {
        return aldnop_mt_fri4;
    }
    public void setAldnop_mt_fri4(String aldnop_mt_fri4) {
        this.aldnop_mt_fri4 = aldnop_mt_fri4;
    }
    public String getAldnop_mt_fri5() {
        return aldnop_mt_fri5;
    }
    public void setAldnop_mt_fri5(String aldnop_mt_fri5) {
        this.aldnop_mt_fri5 = aldnop_mt_fri5;
    }
    public String getAldnop_mt_mon1() {
        return aldnop_mt_mon1;
    }
    public void setAldnop_mt_mon1(String aldnop_mt_mon1) {
        this.aldnop_mt_mon1 = aldnop_mt_mon1;
    }
    public String getAldnop_mt_mon2() {
        return aldnop_mt_mon2;
    }
    public void setAldnop_mt_mon2(String aldnop_mt_mon2) {
        this.aldnop_mt_mon2 = aldnop_mt_mon2;
    }
    public String getAldnop_mt_mon3() {
        return aldnop_mt_mon3;
    }
    public void setAldnop_mt_mon3(String aldnop_mt_mon3) {
        this.aldnop_mt_mon3 = aldnop_mt_mon3;
    }
    public String getAldnop_mt_mon4() {
        return aldnop_mt_mon4;
    }
    public void setAldnop_mt_mon4(String aldnop_mt_mon4) {
        this.aldnop_mt_mon4 = aldnop_mt_mon4;
    }
    public String getAldnop_mt_mon5() {
        return aldnop_mt_mon5;
    }
    public void setAldnop_mt_mon5(String aldnop_mt_mon5) {
        this.aldnop_mt_mon5 = aldnop_mt_mon5;
    }
    public String getAldnop_mt_sat1() {
        return aldnop_mt_sat1;
    }
    public void setAldnop_mt_sat1(String aldnop_mt_sat1) {
        this.aldnop_mt_sat1 = aldnop_mt_sat1;
    }
    public String getAldnop_mt_sat2() {
        return aldnop_mt_sat2;
    }
    public void setAldnop_mt_sat2(String aldnop_mt_sat2) {
        this.aldnop_mt_sat2 = aldnop_mt_sat2;
    }
    public String getAldnop_mt_sat3() {
        return aldnop_mt_sat3;
    }
    public void setAldnop_mt_sat3(String aldnop_mt_sat3) {
        this.aldnop_mt_sat3 = aldnop_mt_sat3;
    }
    public String getAldnop_mt_sat4() {
        return aldnop_mt_sat4;
    }
    public void setAldnop_mt_sat4(String aldnop_mt_sat4) {
        this.aldnop_mt_sat4 = aldnop_mt_sat4;
    }
    public String getAldnop_mt_sat5() {
        return aldnop_mt_sat5;
    }
    public void setAldnop_mt_sat5(String aldnop_mt_sat5) {
        this.aldnop_mt_sat5 = aldnop_mt_sat5;
    }
    public String getAldnop_mt_sun1() {
        return aldnop_mt_sun1;
    }
    public void setAldnop_mt_sun1(String aldnop_mt_sun1) {
        this.aldnop_mt_sun1 = aldnop_mt_sun1;
    }
    public String getAldnop_mt_sun2() {
        return aldnop_mt_sun2;
    }
    public void setAldnop_mt_sun2(String aldnop_mt_sun2) {
        this.aldnop_mt_sun2 = aldnop_mt_sun2;
    }
    public String getAldnop_mt_sun3() {
        return aldnop_mt_sun3;
    }
    public void setAldnop_mt_sun3(String aldnop_mt_sun3) {
        this.aldnop_mt_sun3 = aldnop_mt_sun3;
    }
    public String getAldnop_mt_sun4() {
        return aldnop_mt_sun4;
    }
    public void setAldnop_mt_sun4(String aldnop_mt_sun4) {
        this.aldnop_mt_sun4 = aldnop_mt_sun4;
    }
    public String getAldnop_mt_sun5() {
        return aldnop_mt_sun5;
    }
    public void setAldnop_mt_sun5(String aldnop_mt_sun5) {
        this.aldnop_mt_sun5 = aldnop_mt_sun5;
    }
    public String getAldnop_mt_thu1() {
        return aldnop_mt_thu1;
    }
    public void setAldnop_mt_thu1(String aldnop_mt_thu1) {
        this.aldnop_mt_thu1 = aldnop_mt_thu1;
    }
    public String getAldnop_mt_thu2() {
        return aldnop_mt_thu2;
    }
    public void setAldnop_mt_thu2(String aldnop_mt_thu2) {
        this.aldnop_mt_thu2 = aldnop_mt_thu2;
    }
    public String getAldnop_mt_thu3() {
        return aldnop_mt_thu3;
    }
    public void setAldnop_mt_thu3(String aldnop_mt_thu3) {
        this.aldnop_mt_thu3 = aldnop_mt_thu3;
    }
    public String getAldnop_mt_thu4() {
        return aldnop_mt_thu4;
    }
    public void setAldnop_mt_thu4(String aldnop_mt_thu4) {
        this.aldnop_mt_thu4 = aldnop_mt_thu4;
    }
    public String getAldnop_mt_thu5() {
        return aldnop_mt_thu5;
    }
    public void setAldnop_mt_thu5(String aldnop_mt_thu5) {
        this.aldnop_mt_thu5 = aldnop_mt_thu5;
    }
    public String getAldnop_mt_tue1() {
        return aldnop_mt_tue1;
    }
    public void setAldnop_mt_tue1(String aldnop_mt_tue1) {
        this.aldnop_mt_tue1 = aldnop_mt_tue1;
    }
    public String getAldnop_mt_tue2() {
        return aldnop_mt_tue2;
    }
    public void setAldnop_mt_tue2(String aldnop_mt_tue2) {
        this.aldnop_mt_tue2 = aldnop_mt_tue2;
    }
    public String getAldnop_mt_tue3() {
        return aldnop_mt_tue3;
    }
    public void setAldnop_mt_tue3(String aldnop_mt_tue3) {
        this.aldnop_mt_tue3 = aldnop_mt_tue3;
    }
    public String getAldnop_mt_tue4() {
        return aldnop_mt_tue4;
    }
    public void setAldnop_mt_tue4(String aldnop_mt_tue4) {
        this.aldnop_mt_tue4 = aldnop_mt_tue4;
    }
    public String getAldnop_mt_tue5() {
        return aldnop_mt_tue5;
    }
    public void setAldnop_mt_tue5(String aldnop_mt_tue5) {
        this.aldnop_mt_tue5 = aldnop_mt_tue5;
    }
    public String getAldnop_mt_wed1() {
        return aldnop_mt_wed1;
    }
    public void setAldnop_mt_wed1(String aldnop_mt_wed1) {
        this.aldnop_mt_wed1 = aldnop_mt_wed1;
    }
    public String getAldnop_mt_wed2() {
        return aldnop_mt_wed2;
    }
    public void setAldnop_mt_wed2(String aldnop_mt_wed2) {
        this.aldnop_mt_wed2 = aldnop_mt_wed2;
    }
    public String getAldnop_mt_wed3() {
        return aldnop_mt_wed3;
    }
    public void setAldnop_mt_wed3(String aldnop_mt_wed3) {
        this.aldnop_mt_wed3 = aldnop_mt_wed3;
    }
    public String getAldnop_mt_wed4() {
        return aldnop_mt_wed4;
    }
    public void setAldnop_mt_wed4(String aldnop_mt_wed4) {
        this.aldnop_mt_wed4 = aldnop_mt_wed4;
    }
    public String getAldnop_mt_wed5() {
        return aldnop_mt_wed5;
    }
    public void setAldnop_mt_wed5(String aldnop_mt_wed5) {
        this.aldnop_mt_wed5 = aldnop_mt_wed5;
    }
    public String getAldnop_ra_fri1() {
        return aldnop_ra_fri1;
    }
    public void setAldnop_ra_fri1(String aldnop_ra_fri1) {
        this.aldnop_ra_fri1 = aldnop_ra_fri1;
    }
    public String getAldnop_ra_fri2() {
        return aldnop_ra_fri2;
    }
    public void setAldnop_ra_fri2(String aldnop_ra_fri2) {
        this.aldnop_ra_fri2 = aldnop_ra_fri2;
    }
    public String getAldnop_ra_fri3() {
        return aldnop_ra_fri3;
    }
    public void setAldnop_ra_fri3(String aldnop_ra_fri3) {
        this.aldnop_ra_fri3 = aldnop_ra_fri3;
    }
    public String getAldnop_ra_fri4() {
        return aldnop_ra_fri4;
    }
    public void setAldnop_ra_fri4(String aldnop_ra_fri4) {
        this.aldnop_ra_fri4 = aldnop_ra_fri4;
    }
    public String getAldnop_ra_fri5() {
        return aldnop_ra_fri5;
    }
    public void setAldnop_ra_fri5(String aldnop_ra_fri5) {
        this.aldnop_ra_fri5 = aldnop_ra_fri5;
    }
    public String getAldnop_ra_mon1() {
        return aldnop_ra_mon1;
    }
    public void setAldnop_ra_mon1(String aldnop_ra_mon1) {
        this.aldnop_ra_mon1 = aldnop_ra_mon1;
    }
    public String getAldnop_ra_mon2() {
        return aldnop_ra_mon2;
    }
    public void setAldnop_ra_mon2(String aldnop_ra_mon2) {
        this.aldnop_ra_mon2 = aldnop_ra_mon2;
    }
    public String getAldnop_ra_mon3() {
        return aldnop_ra_mon3;
    }
    public void setAldnop_ra_mon3(String aldnop_ra_mon3) {
        this.aldnop_ra_mon3 = aldnop_ra_mon3;
    }
    public String getAldnop_ra_mon4() {
        return aldnop_ra_mon4;
    }
    public void setAldnop_ra_mon4(String aldnop_ra_mon4) {
        this.aldnop_ra_mon4 = aldnop_ra_mon4;
    }
    public String getAldnop_ra_mon5() {
        return aldnop_ra_mon5;
    }
    public void setAldnop_ra_mon5(String aldnop_ra_mon5) {
        this.aldnop_ra_mon5 = aldnop_ra_mon5;
    }
    public String getAldnop_ra_sat1() {
        return aldnop_ra_sat1;
    }
    public void setAldnop_ra_sat1(String aldnop_ra_sat1) {
        this.aldnop_ra_sat1 = aldnop_ra_sat1;
    }
    public String getAldnop_ra_sat2() {
        return aldnop_ra_sat2;
    }
    public void setAldnop_ra_sat2(String aldnop_ra_sat2) {
        this.aldnop_ra_sat2 = aldnop_ra_sat2;
    }
    public String getAldnop_ra_sat3() {
        return aldnop_ra_sat3;
    }
    public void setAldnop_ra_sat3(String aldnop_ra_sat3) {
        this.aldnop_ra_sat3 = aldnop_ra_sat3;
    }
    public String getAldnop_ra_sat4() {
        return aldnop_ra_sat4;
    }
    public void setAldnop_ra_sat4(String aldnop_ra_sat4) {
        this.aldnop_ra_sat4 = aldnop_ra_sat4;
    }
    public String getAldnop_ra_sat5() {
        return aldnop_ra_sat5;
    }
    public void setAldnop_ra_sat5(String aldnop_ra_sat5) {
        this.aldnop_ra_sat5 = aldnop_ra_sat5;
    }
    public String getAldnop_ra_sun1() {
        return aldnop_ra_sun1;
    }
    public void setAldnop_ra_sun1(String aldnop_ra_sun1) {
        this.aldnop_ra_sun1 = aldnop_ra_sun1;
    }
    public String getAldnop_ra_sun2() {
        return aldnop_ra_sun2;
    }
    public void setAldnop_ra_sun2(String aldnop_ra_sun2) {
        this.aldnop_ra_sun2 = aldnop_ra_sun2;
    }
    public String getAldnop_ra_sun3() {
        return aldnop_ra_sun3;
    }
    public void setAldnop_ra_sun3(String aldnop_ra_sun3) {
        this.aldnop_ra_sun3 = aldnop_ra_sun3;
    }
    public String getAldnop_ra_sun4() {
        return aldnop_ra_sun4;
    }
    public void setAldnop_ra_sun4(String aldnop_ra_sun4) {
        this.aldnop_ra_sun4 = aldnop_ra_sun4;
    }
    public String getAldnop_ra_sun5() {
        return aldnop_ra_sun5;
    }
    public void setAldnop_ra_sun5(String aldnop_ra_sun5) {
        this.aldnop_ra_sun5 = aldnop_ra_sun5;
    }
    public String getAldnop_ra_thu1() {
        return aldnop_ra_thu1;
    }
    public void setAldnop_ra_thu1(String aldnop_ra_thu1) {
        this.aldnop_ra_thu1 = aldnop_ra_thu1;
    }
    public String getAldnop_ra_thu2() {
        return aldnop_ra_thu2;
    }
    public void setAldnop_ra_thu2(String aldnop_ra_thu2) {
        this.aldnop_ra_thu2 = aldnop_ra_thu2;
    }
    public String getAldnop_ra_thu3() {
        return aldnop_ra_thu3;
    }
    public void setAldnop_ra_thu3(String aldnop_ra_thu3) {
        this.aldnop_ra_thu3 = aldnop_ra_thu3;
    }
    public String getAldnop_ra_thu4() {
        return aldnop_ra_thu4;
    }
    public void setAldnop_ra_thu4(String aldnop_ra_thu4) {
        this.aldnop_ra_thu4 = aldnop_ra_thu4;
    }
    public String getAldnop_ra_thu5() {
        return aldnop_ra_thu5;
    }
    public void setAldnop_ra_thu5(String aldnop_ra_thu5) {
        this.aldnop_ra_thu5 = aldnop_ra_thu5;
    }
    public String getAldnop_ra_tue1() {
        return aldnop_ra_tue1;
    }
    public void setAldnop_ra_tue1(String aldnop_ra_tue1) {
        this.aldnop_ra_tue1 = aldnop_ra_tue1;
    }
    public String getAldnop_ra_tue2() {
        return aldnop_ra_tue2;
    }
    public void setAldnop_ra_tue2(String aldnop_ra_tue2) {
        this.aldnop_ra_tue2 = aldnop_ra_tue2;
    }
    public String getAldnop_ra_tue3() {
        return aldnop_ra_tue3;
    }
    public void setAldnop_ra_tue3(String aldnop_ra_tue3) {
        this.aldnop_ra_tue3 = aldnop_ra_tue3;
    }
    public String getAldnop_ra_tue4() {
        return aldnop_ra_tue4;
    }
    public void setAldnop_ra_tue4(String aldnop_ra_tue4) {
        this.aldnop_ra_tue4 = aldnop_ra_tue4;
    }
    public String getAldnop_ra_tue5() {
        return aldnop_ra_tue5;
    }
    public void setAldnop_ra_tue5(String aldnop_ra_tue5) {
        this.aldnop_ra_tue5 = aldnop_ra_tue5;
    }
    public String getAldnop_ra_wed1() {
        return aldnop_ra_wed1;
    }
    public void setAldnop_ra_wed1(String aldnop_ra_wed1) {
        this.aldnop_ra_wed1 = aldnop_ra_wed1;
    }
    public String getAldnop_ra_wed2() {
        return aldnop_ra_wed2;
    }
    public void setAldnop_ra_wed2(String aldnop_ra_wed2) {
        this.aldnop_ra_wed2 = aldnop_ra_wed2;
    }
    public String getAldnop_ra_wed3() {
        return aldnop_ra_wed3;
    }
    public void setAldnop_ra_wed3(String aldnop_ra_wed3) {
        this.aldnop_ra_wed3 = aldnop_ra_wed3;
    }
    public String getAldnop_ra_wed4() {
        return aldnop_ra_wed4;
    }
    public void setAldnop_ra_wed4(String aldnop_ra_wed4) {
        this.aldnop_ra_wed4 = aldnop_ra_wed4;
    }
    public String getAldnop_ra_wed5() {
        return aldnop_ra_wed5;
    }
    public void setAldnop_ra_wed5(String aldnop_ra_wed5) {
        this.aldnop_ra_wed5 = aldnop_ra_wed5;
    }
    public String getAldnop_rt_fri1() {
        return aldnop_rt_fri1;
    }
    public void setAldnop_rt_fri1(String aldnop_rt_fri1) {
        this.aldnop_rt_fri1 = aldnop_rt_fri1;
    }
    public String getAldnop_rt_fri2() {
        return aldnop_rt_fri2;
    }
    public void setAldnop_rt_fri2(String aldnop_rt_fri2) {
        this.aldnop_rt_fri2 = aldnop_rt_fri2;
    }
    public String getAldnop_rt_fri3() {
        return aldnop_rt_fri3;
    }
    public void setAldnop_rt_fri3(String aldnop_rt_fri3) {
        this.aldnop_rt_fri3 = aldnop_rt_fri3;
    }
    public String getAldnop_rt_fri4() {
        return aldnop_rt_fri4;
    }
    public void setAldnop_rt_fri4(String aldnop_rt_fri4) {
        this.aldnop_rt_fri4 = aldnop_rt_fri4;
    }
    public String getAldnop_rt_fri5() {
        return aldnop_rt_fri5;
    }
    public void setAldnop_rt_fri5(String aldnop_rt_fri5) {
        this.aldnop_rt_fri5 = aldnop_rt_fri5;
    }
    public String getAldnop_rt_mon1() {
        return aldnop_rt_mon1;
    }
    public void setAldnop_rt_mon1(String aldnop_rt_mon1) {
        this.aldnop_rt_mon1 = aldnop_rt_mon1;
    }
    public String getAldnop_rt_mon2() {
        return aldnop_rt_mon2;
    }
    public void setAldnop_rt_mon2(String aldnop_rt_mon2) {
        this.aldnop_rt_mon2 = aldnop_rt_mon2;
    }
    public String getAldnop_rt_mon3() {
        return aldnop_rt_mon3;
    }
    public void setAldnop_rt_mon3(String aldnop_rt_mon3) {
        this.aldnop_rt_mon3 = aldnop_rt_mon3;
    }
    public String getAldnop_rt_mon4() {
        return aldnop_rt_mon4;
    }
    public void setAldnop_rt_mon4(String aldnop_rt_mon4) {
        this.aldnop_rt_mon4 = aldnop_rt_mon4;
    }
    public String getAldnop_rt_mon5() {
        return aldnop_rt_mon5;
    }
    public void setAldnop_rt_mon5(String aldnop_rt_mon5) {
        this.aldnop_rt_mon5 = aldnop_rt_mon5;
    }
    public String getAldnop_rt_sat1() {
        return aldnop_rt_sat1;
    }
    public void setAldnop_rt_sat1(String aldnop_rt_sat1) {
        this.aldnop_rt_sat1 = aldnop_rt_sat1;
    }
    public String getAldnop_rt_sat2() {
        return aldnop_rt_sat2;
    }
    public void setAldnop_rt_sat2(String aldnop_rt_sat2) {
        this.aldnop_rt_sat2 = aldnop_rt_sat2;
    }
    public String getAldnop_rt_sat3() {
        return aldnop_rt_sat3;
    }
    public void setAldnop_rt_sat3(String aldnop_rt_sat3) {
        this.aldnop_rt_sat3 = aldnop_rt_sat3;
    }
    public String getAldnop_rt_sat4() {
        return aldnop_rt_sat4;
    }
    public void setAldnop_rt_sat4(String aldnop_rt_sat4) {
        this.aldnop_rt_sat4 = aldnop_rt_sat4;
    }
    public String getAldnop_rt_sat5() {
        return aldnop_rt_sat5;
    }
    public void setAldnop_rt_sat5(String aldnop_rt_sat5) {
        this.aldnop_rt_sat5 = aldnop_rt_sat5;
    }
    public String getAldnop_rt_sun1() {
        return aldnop_rt_sun1;
    }
    public void setAldnop_rt_sun1(String aldnop_rt_sun1) {
        this.aldnop_rt_sun1 = aldnop_rt_sun1;
    }
    public String getAldnop_rt_sun2() {
        return aldnop_rt_sun2;
    }
    public void setAldnop_rt_sun2(String aldnop_rt_sun2) {
        this.aldnop_rt_sun2 = aldnop_rt_sun2;
    }
    public String getAldnop_rt_sun3() {
        return aldnop_rt_sun3;
    }
    public void setAldnop_rt_sun3(String aldnop_rt_sun3) {
        this.aldnop_rt_sun3 = aldnop_rt_sun3;
    }
    public String getAldnop_rt_sun4() {
        return aldnop_rt_sun4;
    }
    public void setAldnop_rt_sun4(String aldnop_rt_sun4) {
        this.aldnop_rt_sun4 = aldnop_rt_sun4;
    }
    public String getAldnop_rt_sun5() {
        return aldnop_rt_sun5;
    }
    public void setAldnop_rt_sun5(String aldnop_rt_sun5) {
        this.aldnop_rt_sun5 = aldnop_rt_sun5;
    }
    public String getAldnop_rt_thu1() {
        return aldnop_rt_thu1;
    }
    public void setAldnop_rt_thu1(String aldnop_rt_thu1) {
        this.aldnop_rt_thu1 = aldnop_rt_thu1;
    }
    public String getAldnop_rt_thu2() {
        return aldnop_rt_thu2;
    }
    public void setAldnop_rt_thu2(String aldnop_rt_thu2) {
        this.aldnop_rt_thu2 = aldnop_rt_thu2;
    }
    public String getAldnop_rt_thu3() {
        return aldnop_rt_thu3;
    }
    public void setAldnop_rt_thu3(String aldnop_rt_thu3) {
        this.aldnop_rt_thu3 = aldnop_rt_thu3;
    }
    public String getAldnop_rt_thu4() {
        return aldnop_rt_thu4;
    }
    public void setAldnop_rt_thu4(String aldnop_rt_thu4) {
        this.aldnop_rt_thu4 = aldnop_rt_thu4;
    }
    public String getAldnop_rt_thu5() {
        return aldnop_rt_thu5;
    }
    public void setAldnop_rt_thu5(String aldnop_rt_thu5) {
        this.aldnop_rt_thu5 = aldnop_rt_thu5;
    }
    public String getAldnop_rt_tue1() {
        return aldnop_rt_tue1;
    }
    public void setAldnop_rt_tue1(String aldnop_rt_tue1) {
        this.aldnop_rt_tue1 = aldnop_rt_tue1;
    }
    public String getAldnop_rt_tue2() {
        return aldnop_rt_tue2;
    }
    public void setAldnop_rt_tue2(String aldnop_rt_tue2) {
        this.aldnop_rt_tue2 = aldnop_rt_tue2;
    }
    public String getAldnop_rt_tue3() {
        return aldnop_rt_tue3;
    }
    public void setAldnop_rt_tue3(String aldnop_rt_tue3) {
        this.aldnop_rt_tue3 = aldnop_rt_tue3;
    }
    public String getAldnop_rt_tue4() {
        return aldnop_rt_tue4;
    }
    public void setAldnop_rt_tue4(String aldnop_rt_tue4) {
        this.aldnop_rt_tue4 = aldnop_rt_tue4;
    }
    public String getAldnop_rt_tue5() {
        return aldnop_rt_tue5;
    }
    public void setAldnop_rt_tue5(String aldnop_rt_tue5) {
        this.aldnop_rt_tue5 = aldnop_rt_tue5;
    }
    public String getAldnop_rt_wed1() {
        return aldnop_rt_wed1;
    }
    public void setAldnop_rt_wed1(String aldnop_rt_wed1) {
        this.aldnop_rt_wed1 = aldnop_rt_wed1;
    }
    public String getAldnop_rt_wed2() {
        return aldnop_rt_wed2;
    }
    public void setAldnop_rt_wed2(String aldnop_rt_wed2) {
        this.aldnop_rt_wed2 = aldnop_rt_wed2;
    }
    public String getAldnop_rt_wed3() {
        return aldnop_rt_wed3;
    }
    public void setAldnop_rt_wed3(String aldnop_rt_wed3) {
        this.aldnop_rt_wed3 = aldnop_rt_wed3;
    }
    public String getAldnop_rt_wed4() {
        return aldnop_rt_wed4;
    }
    public void setAldnop_rt_wed4(String aldnop_rt_wed4) {
        this.aldnop_rt_wed4 = aldnop_rt_wed4;
    }
    public String getAldnop_rt_wed5() {
        return aldnop_rt_wed5;
    }
    public void setAldnop_rt_wed5(String aldnop_rt_wed5) {
        this.aldnop_rt_wed5 = aldnop_rt_wed5;
    }
    public String getHca_day_label1() {
        return hca_day_label1;
    }
    public void setHca_day_label1(String hca_day_label1) {
        this.hca_day_label1 = hca_day_label1;
    }
    public String getHca_day_label2() {
        return hca_day_label2;
    }
    public void setHca_day_label2(String hca_day_label2) {
        this.hca_day_label2 = hca_day_label2;
    }
    public String getHca_day_label3() {
        return hca_day_label3;
    }
    public void setHca_day_label3(String hca_day_label3) {
        this.hca_day_label3 = hca_day_label3;
    }
    public String getHca_day_label4() {
        return hca_day_label4;
    }
    public void setHca_day_label4(String hca_day_label4) {
        this.hca_day_label4 = hca_day_label4;
    }
    public String getHca_day_label5() {
        return hca_day_label5;
    }
    public void setHca_day_label5(String hca_day_label5) {
        this.hca_day_label5 = hca_day_label5;
    }
    public String getHca_day_total1() {
        return hca_day_total1;
    }
    public void setHca_day_total1(String hca_day_total1) {
        this.hca_day_total1 = hca_day_total1;
    }
    public String getHca_day_total2() {
        return hca_day_total2;
    }
    public void setHca_day_total2(String hca_day_total2) {
        this.hca_day_total2 = hca_day_total2;
    }
    public String getHca_day_total3() {
        return hca_day_total3;
    }
    public void setHca_day_total3(String hca_day_total3) {
        this.hca_day_total3 = hca_day_total3;
    }
    public String getHca_day_total4() {
        return hca_day_total4;
    }
    public void setHca_day_total4(String hca_day_total4) {
        this.hca_day_total4 = hca_day_total4;
    }
    public String getHca_day_total5() {
        return hca_day_total5;
    }
    public void setHca_day_total5(String hca_day_total5) {
        this.hca_day_total5 = hca_day_total5;
    }
    public String getHca_eve_label1() {
        return hca_eve_label1;
    }
    public void setHca_eve_label1(String hca_eve_label1) {
        this.hca_eve_label1 = hca_eve_label1;
    }
    public String getHca_eve_label2() {
        return hca_eve_label2;
    }
    public void setHca_eve_label2(String hca_eve_label2) {
        this.hca_eve_label2 = hca_eve_label2;
    }
    public String getHca_eve_label3() {
        return hca_eve_label3;
    }
    public void setHca_eve_label3(String hca_eve_label3) {
        this.hca_eve_label3 = hca_eve_label3;
    }
    public String getHca_eve_label4() {
        return hca_eve_label4;
    }
    public void setHca_eve_label4(String hca_eve_label4) {
        this.hca_eve_label4 = hca_eve_label4;
    }
    public String getHca_eve_label5() {
        return hca_eve_label5;
    }
    public void setHca_eve_label5(String hca_eve_label5) {
        this.hca_eve_label5 = hca_eve_label5;
    }
    public String getHca_eve_total1() {
        return hca_eve_total1;
    }
    public void setHca_eve_total1(String hca_eve_total1) {
        this.hca_eve_total1 = hca_eve_total1;
    }
    public String getHca_eve_total2() {
        return hca_eve_total2;
    }
    public void setHca_eve_total2(String hca_eve_total2) {
        this.hca_eve_total2 = hca_eve_total2;
    }
    public String getHca_eve_total3() {
        return hca_eve_total3;
    }
    public void setHca_eve_total3(String hca_eve_total3) {
        this.hca_eve_total3 = hca_eve_total3;
    }
    public String getHca_eve_total4() {
        return hca_eve_total4;
    }
    public void setHca_eve_total4(String hca_eve_total4) {
        this.hca_eve_total4 = hca_eve_total4;
    }
    public String getHca_eve_total5() {
        return hca_eve_total5;
    }
    public void setHca_eve_total5(String hca_eve_total5) {
        this.hca_eve_total5 = hca_eve_total5;
    }
    public String getHca_fri_total1() {
        return hca_fri_total1;
    }
    public void setHca_fri_total1(String hca_fri_total1) {
        this.hca_fri_total1 = hca_fri_total1;
    }
    public String getHca_fri_total2() {
        return hca_fri_total2;
    }
    public void setHca_fri_total2(String hca_fri_total2) {
        this.hca_fri_total2 = hca_fri_total2;
    }
    public String getHca_fri_total3() {
        return hca_fri_total3;
    }
    public void setHca_fri_total3(String hca_fri_total3) {
        this.hca_fri_total3 = hca_fri_total3;
    }
    public String getHca_fri_total4() {
        return hca_fri_total4;
    }
    public void setHca_fri_total4(String hca_fri_total4) {
        this.hca_fri_total4 = hca_fri_total4;
    }
    public String getHca_fri_total5() {
        return hca_fri_total5;
    }
    public void setHca_fri_total5(String hca_fri_total5) {
        this.hca_fri_total5 = hca_fri_total5;
    }
    public String getHca_mon_total1() {
        return hca_mon_total1;
    }
    public void setHca_mon_total1(String hca_mon_total1) {
        this.hca_mon_total1 = hca_mon_total1;
    }
    public String getHca_mon_total2() {
        return hca_mon_total2;
    }
    public void setHca_mon_total2(String hca_mon_total2) {
        this.hca_mon_total2 = hca_mon_total2;
    }
    public String getHca_mon_total3() {
        return hca_mon_total3;
    }
    public void setHca_mon_total3(String hca_mon_total3) {
        this.hca_mon_total3 = hca_mon_total3;
    }
    public String getHca_mon_total4() {
        return hca_mon_total4;
    }
    public void setHca_mon_total4(String hca_mon_total4) {
        this.hca_mon_total4 = hca_mon_total4;
    }
    public String getHca_mon_total5() {
        return hca_mon_total5;
    }
    public void setHca_mon_total5(String hca_mon_total5) {
        this.hca_mon_total5 = hca_mon_total5;
    }
    public String getHca_night_fri1() {
        return hca_night_fri1;
    }
    public void setHca_night_fri1(String hca_night_fri1) {
        this.hca_night_fri1 = hca_night_fri1;
    }
    public String getHca_night_fri2() {
        return hca_night_fri2;
    }
    public void setHca_night_fri2(String hca_night_fri2) {
        this.hca_night_fri2 = hca_night_fri2;
    }
    public String getHca_night_fri3() {
        return hca_night_fri3;
    }
    public void setHca_night_fri3(String hca_night_fri3) {
        this.hca_night_fri3 = hca_night_fri3;
    }
    public String getHca_night_fri4() {
        return hca_night_fri4;
    }
    public void setHca_night_fri4(String hca_night_fri4) {
        this.hca_night_fri4 = hca_night_fri4;
    }
    public String getHca_night_fri5() {
        return hca_night_fri5;
    }
    public void setHca_night_fri5(String hca_night_fri5) {
        this.hca_night_fri5 = hca_night_fri5;
    }
    public String getHca_night_mon1() {
        return hca_night_mon1;
    }
    public void setHca_night_mon1(String hca_night_mon1) {
        this.hca_night_mon1 = hca_night_mon1;
    }
    public String getHca_night_mon2() {
        return hca_night_mon2;
    }
    public void setHca_night_mon2(String hca_night_mon2) {
        this.hca_night_mon2 = hca_night_mon2;
    }
    public String getHca_night_mon3() {
        return hca_night_mon3;
    }
    public void setHca_night_mon3(String hca_night_mon3) {
        this.hca_night_mon3 = hca_night_mon3;
    }
    public String getHca_night_mon4() {
        return hca_night_mon4;
    }
    public void setHca_night_mon4(String hca_night_mon4) {
        this.hca_night_mon4 = hca_night_mon4;
    }
    public String getHca_night_mon5() {
        return hca_night_mon5;
    }
    public void setHca_night_mon5(String hca_night_mon5) {
        this.hca_night_mon5 = hca_night_mon5;
    }
    public String getHca_night_sat1() {
        return hca_night_sat1;
    }
    public void setHca_night_sat1(String hca_night_sat1) {
        this.hca_night_sat1 = hca_night_sat1;
    }
    public String getHca_night_sat2() {
        return hca_night_sat2;
    }
    public void setHca_night_sat2(String hca_night_sat2) {
        this.hca_night_sat2 = hca_night_sat2;
    }
    public String getHca_night_sat3() {
        return hca_night_sat3;
    }
    public void setHca_night_sat3(String hca_night_sat3) {
        this.hca_night_sat3 = hca_night_sat3;
    }
    public String getHca_night_sat4() {
        return hca_night_sat4;
    }
    public void setHca_night_sat4(String hca_night_sat4) {
        this.hca_night_sat4 = hca_night_sat4;
    }
    public String getHca_night_sat5() {
        return hca_night_sat5;
    }
    public void setHca_night_sat5(String hca_night_sat5) {
        this.hca_night_sat5 = hca_night_sat5;
    }
    public String getHca_night_sun1() {
        return hca_night_sun1;
    }
    public void setHca_night_sun1(String hca_night_sun1) {
        this.hca_night_sun1 = hca_night_sun1;
    }
    public String getHca_night_sun2() {
        return hca_night_sun2;
    }
    public void setHca_night_sun2(String hca_night_sun2) {
        this.hca_night_sun2 = hca_night_sun2;
    }
    public String getHca_night_sun3() {
        return hca_night_sun3;
    }
    public void setHca_night_sun3(String hca_night_sun3) {
        this.hca_night_sun3 = hca_night_sun3;
    }
    public String getHca_night_sun4() {
        return hca_night_sun4;
    }
    public void setHca_night_sun4(String hca_night_sun4) {
        this.hca_night_sun4 = hca_night_sun4;
    }
    public String getHca_night_sun5() {
        return hca_night_sun5;
    }
    public void setHca_night_sun5(String hca_night_sun5) {
        this.hca_night_sun5 = hca_night_sun5;
    }
    public String getHca_night_thu1() {
        return hca_night_thu1;
    }
    public void setHca_night_thu1(String hca_night_thu1) {
        this.hca_night_thu1 = hca_night_thu1;
    }
    public String getHca_night_thu2() {
        return hca_night_thu2;
    }
    public void setHca_night_thu2(String hca_night_thu2) {
        this.hca_night_thu2 = hca_night_thu2;
    }
    public String getHca_night_thu3() {
        return hca_night_thu3;
    }
    public void setHca_night_thu3(String hca_night_thu3) {
        this.hca_night_thu3 = hca_night_thu3;
    }
    public String getHca_night_thu4() {
        return hca_night_thu4;
    }
    public void setHca_night_thu4(String hca_night_thu4) {
        this.hca_night_thu4 = hca_night_thu4;
    }
    public String getHca_night_thu5() {
        return hca_night_thu5;
    }
    public void setHca_night_thu5(String hca_night_thu5) {
        this.hca_night_thu5 = hca_night_thu5;
    }
    public String getHca_night_tue1() {
        return hca_night_tue1;
    }
    public void setHca_night_tue1(String hca_night_tue1) {
        this.hca_night_tue1 = hca_night_tue1;
    }
    public String getHca_night_tue2() {
        return hca_night_tue2;
    }
    public void setHca_night_tue2(String hca_night_tue2) {
        this.hca_night_tue2 = hca_night_tue2;
    }
    public String getHca_night_tue3() {
        return hca_night_tue3;
    }
    public void setHca_night_tue3(String hca_night_tue3) {
        this.hca_night_tue3 = hca_night_tue3;
    }
    public String getHca_night_tue4() {
        return hca_night_tue4;
    }
    public void setHca_night_tue4(String hca_night_tue4) {
        this.hca_night_tue4 = hca_night_tue4;
    }
    public String getHca_night_tue5() {
        return hca_night_tue5;
    }
    public void setHca_night_tue5(String hca_night_tue5) {
        this.hca_night_tue5 = hca_night_tue5;
    }
    public String getHca_night_wed1() {
        return hca_night_wed1;
    }
    public void setHca_night_wed1(String hca_night_wed1) {
        this.hca_night_wed1 = hca_night_wed1;
    }
    public String getHca_night_wed2() {
        return hca_night_wed2;
    }
    public void setHca_night_wed2(String hca_night_wed2) {
        this.hca_night_wed2 = hca_night_wed2;
    }
    public String getHca_night_wed3() {
        return hca_night_wed3;
    }
    public void setHca_night_wed3(String hca_night_wed3) {
        this.hca_night_wed3 = hca_night_wed3;
    }
    public String getHca_night_wed4() {
        return hca_night_wed4;
    }
    public void setHca_night_wed4(String hca_night_wed4) {
        this.hca_night_wed4 = hca_night_wed4;
    }
    public String getHca_night_wed5() {
        return hca_night_wed5;
    }
    public void setHca_night_wed5(String hca_night_wed5) {
        this.hca_night_wed5 = hca_night_wed5;
    }
    public String getHca_sat_total1() {
        return hca_sat_total1;
    }
    public void setHca_sat_total1(String hca_sat_total1) {
        this.hca_sat_total1 = hca_sat_total1;
    }
    public String getHca_sat_total2() {
        return hca_sat_total2;
    }
    public void setHca_sat_total2(String hca_sat_total2) {
        this.hca_sat_total2 = hca_sat_total2;
    }
    public String getHca_sat_total3() {
        return hca_sat_total3;
    }
    public void setHca_sat_total3(String hca_sat_total3) {
        this.hca_sat_total3 = hca_sat_total3;
    }
    public String getHca_sat_total4() {
        return hca_sat_total4;
    }
    public void setHca_sat_total4(String hca_sat_total4) {
        this.hca_sat_total4 = hca_sat_total4;
    }
    public String getHca_sat_total5() {
        return hca_sat_total5;
    }
    public void setHca_sat_total5(String hca_sat_total5) {
        this.hca_sat_total5 = hca_sat_total5;
    }
    public String getHca_sun_total1() {
        return hca_sun_total1;
    }
    public void setHca_sun_total1(String hca_sun_total1) {
        this.hca_sun_total1 = hca_sun_total1;
    }
    public String getHca_sun_total2() {
        return hca_sun_total2;
    }
    public void setHca_sun_total2(String hca_sun_total2) {
        this.hca_sun_total2 = hca_sun_total2;
    }
    public String getHca_sun_total3() {
        return hca_sun_total3;
    }
    public void setHca_sun_total3(String hca_sun_total3) {
        this.hca_sun_total3 = hca_sun_total3;
    }
    public String getHca_sun_total4() {
        return hca_sun_total4;
    }
    public void setHca_sun_total4(String hca_sun_total4) {
        this.hca_sun_total4 = hca_sun_total4;
    }
    public String getHca_sun_total5() {
        return hca_sun_total5;
    }
    public void setHca_sun_total5(String hca_sun_total5) {
        this.hca_sun_total5 = hca_sun_total5;
    }
    public String getHca_thu_total1() {
        return hca_thu_total1;
    }
    public void setHca_thu_total1(String hca_thu_total1) {
        this.hca_thu_total1 = hca_thu_total1;
    }
    public String getHca_thu_total2() {
        return hca_thu_total2;
    }
    public void setHca_thu_total2(String hca_thu_total2) {
        this.hca_thu_total2 = hca_thu_total2;
    }
    public String getHca_thu_total3() {
        return hca_thu_total3;
    }
    public void setHca_thu_total3(String hca_thu_total3) {
        this.hca_thu_total3 = hca_thu_total3;
    }
    public String getHca_thu_total4() {
        return hca_thu_total4;
    }
    public void setHca_thu_total4(String hca_thu_total4) {
        this.hca_thu_total4 = hca_thu_total4;
    }
    public String getHca_thu_total5() {
        return hca_thu_total5;
    }
    public void setHca_thu_total5(String hca_thu_total5) {
        this.hca_thu_total5 = hca_thu_total5;
    }
    public String getHca_tue_total1() {
        return hca_tue_total1;
    }
    public void setHca_tue_total1(String hca_tue_total1) {
        this.hca_tue_total1 = hca_tue_total1;
    }
    public String getHca_tue_total2() {
        return hca_tue_total2;
    }
    public void setHca_tue_total2(String hca_tue_total2) {
        this.hca_tue_total2 = hca_tue_total2;
    }
    public String getHca_tue_total3() {
        return hca_tue_total3;
    }
    public void setHca_tue_total3(String hca_tue_total3) {
        this.hca_tue_total3 = hca_tue_total3;
    }
    public String getHca_tue_total4() {
        return hca_tue_total4;
    }
    public void setHca_tue_total4(String hca_tue_total4) {
        this.hca_tue_total4 = hca_tue_total4;
    }
    public String getHca_tue_total5() {
        return hca_tue_total5;
    }
    public void setHca_tue_total5(String hca_tue_total5) {
        this.hca_tue_total5 = hca_tue_total5;
    }
    public String getHca_wed_total1() {
        return hca_wed_total1;
    }
    public void setHca_wed_total1(String hca_wed_total1) {
        this.hca_wed_total1 = hca_wed_total1;
    }
    public String getHca_wed_total2() {
        return hca_wed_total2;
    }
    public void setHca_wed_total2(String hca_wed_total2) {
        this.hca_wed_total2 = hca_wed_total2;
    }
    public String getHca_wed_total3() {
        return hca_wed_total3;
    }
    public void setHca_wed_total3(String hca_wed_total3) {
        this.hca_wed_total3 = hca_wed_total3;
    }
    public String getHca_wed_total4() {
        return hca_wed_total4;
    }
    public void setHca_wed_total4(String hca_wed_total4) {
        this.hca_wed_total4 = hca_wed_total4;
    }
    public String getHca_wed_total5() {
        return hca_wed_total5;
    }
    public void setHca_wed_total5(String hca_wed_total5) {
        this.hca_wed_total5 = hca_wed_total5;
    }
    public String getLpn_day_label1() {
        return lpn_day_label1;
    }
    public void setLpn_day_label1(String lpn_day_label1) {
        this.lpn_day_label1 = lpn_day_label1;
    }
    public String getLpn_day_label2() {
        return lpn_day_label2;
    }
    public void setLpn_day_label2(String lpn_day_label2) {
        this.lpn_day_label2 = lpn_day_label2;
    }
    public String getLpn_day_label3() {
        return lpn_day_label3;
    }
    public void setLpn_day_label3(String lpn_day_label3) {
        this.lpn_day_label3 = lpn_day_label3;
    }
    public String getLpn_day_label4() {
        return lpn_day_label4;
    }
    public void setLpn_day_label4(String lpn_day_label4) {
        this.lpn_day_label4 = lpn_day_label4;
    }
    public String getLpn_day_label5() {
        return lpn_day_label5;
    }
    public void setLpn_day_label5(String lpn_day_label5) {
        this.lpn_day_label5 = lpn_day_label5;
    }
    public String getLpn_day_total1() {
        return lpn_day_total1;
    }
    public void setLpn_day_total1(String lpn_day_total1) {
        this.lpn_day_total1 = lpn_day_total1;
    }
    public String getLpn_day_total2() {
        return lpn_day_total2;
    }
    public void setLpn_day_total2(String lpn_day_total2) {
        this.lpn_day_total2 = lpn_day_total2;
    }
    public String getLpn_day_total3() {
        return lpn_day_total3;
    }
    public void setLpn_day_total3(String lpn_day_total3) {
        this.lpn_day_total3 = lpn_day_total3;
    }
    public String getLpn_day_total4() {
        return lpn_day_total4;
    }
    public void setLpn_day_total4(String lpn_day_total4) {
        this.lpn_day_total4 = lpn_day_total4;
    }
    public String getLpn_day_total5() {
        return lpn_day_total5;
    }
    public void setLpn_day_total5(String lpn_day_total5) {
        this.lpn_day_total5 = lpn_day_total5;
    }
    public String getLpn_eve_label1() {
        return lpn_eve_label1;
    }
    public void setLpn_eve_label1(String lpn_eve_label1) {
        this.lpn_eve_label1 = lpn_eve_label1;
    }
    public String getLpn_eve_label2() {
        return lpn_eve_label2;
    }
    public void setLpn_eve_label2(String lpn_eve_label2) {
        this.lpn_eve_label2 = lpn_eve_label2;
    }
    public String getLpn_eve_label3() {
        return lpn_eve_label3;
    }
    public void setLpn_eve_label3(String lpn_eve_label3) {
        this.lpn_eve_label3 = lpn_eve_label3;
    }
    public String getLpn_eve_label4() {
        return lpn_eve_label4;
    }
    public void setLpn_eve_label4(String lpn_eve_label4) {
        this.lpn_eve_label4 = lpn_eve_label4;
    }
    public String getLpn_eve_label5() {
        return lpn_eve_label5;
    }
    public void setLpn_eve_label5(String lpn_eve_label5) {
        this.lpn_eve_label5 = lpn_eve_label5;
    }
    public String getLpn_eve_total1() {
        return lpn_eve_total1;
    }
    public void setLpn_eve_total1(String lpn_eve_total1) {
        this.lpn_eve_total1 = lpn_eve_total1;
    }
    public String getLpn_eve_total2() {
        return lpn_eve_total2;
    }
    public void setLpn_eve_total2(String lpn_eve_total2) {
        this.lpn_eve_total2 = lpn_eve_total2;
    }
    public String getLpn_eve_total3() {
        return lpn_eve_total3;
    }
    public void setLpn_eve_total3(String lpn_eve_total3) {
        this.lpn_eve_total3 = lpn_eve_total3;
    }
    public String getLpn_eve_total4() {
        return lpn_eve_total4;
    }
    public void setLpn_eve_total4(String lpn_eve_total4) {
        this.lpn_eve_total4 = lpn_eve_total4;
    }
    public String getLpn_eve_total5() {
        return lpn_eve_total5;
    }
    public void setLpn_eve_total5(String lpn_eve_total5) {
        this.lpn_eve_total5 = lpn_eve_total5;
    }
    public String getLpn_fri_total1() {
        return lpn_fri_total1;
    }
    public void setLpn_fri_total1(String lpn_fri_total1) {
        this.lpn_fri_total1 = lpn_fri_total1;
    }
    public String getLpn_fri_total2() {
        return lpn_fri_total2;
    }
    public void setLpn_fri_total2(String lpn_fri_total2) {
        this.lpn_fri_total2 = lpn_fri_total2;
    }
    public String getLpn_fri_total3() {
        return lpn_fri_total3;
    }
    public void setLpn_fri_total3(String lpn_fri_total3) {
        this.lpn_fri_total3 = lpn_fri_total3;
    }
    public String getLpn_fri_total4() {
        return lpn_fri_total4;
    }
    public void setLpn_fri_total4(String lpn_fri_total4) {
        this.lpn_fri_total4 = lpn_fri_total4;
    }
    public String getLpn_fri_total5() {
        return lpn_fri_total5;
    }
    public void setLpn_fri_total5(String lpn_fri_total5) {
        this.lpn_fri_total5 = lpn_fri_total5;
    }
    public String getLpn_mon_total1() {
        return lpn_mon_total1;
    }
    public void setLpn_mon_total1(String lpn_mon_total1) {
        this.lpn_mon_total1 = lpn_mon_total1;
    }
    public String getLpn_mon_total2() {
        return lpn_mon_total2;
    }
    public void setLpn_mon_total2(String lpn_mon_total2) {
        this.lpn_mon_total2 = lpn_mon_total2;
    }
    public String getLpn_mon_total3() {
        return lpn_mon_total3;
    }
    public void setLpn_mon_total3(String lpn_mon_total3) {
        this.lpn_mon_total3 = lpn_mon_total3;
    }
    public String getLpn_mon_total4() {
        return lpn_mon_total4;
    }
    public void setLpn_mon_total4(String lpn_mon_total4) {
        this.lpn_mon_total4 = lpn_mon_total4;
    }
    public String getLpn_mon_total5() {
        return lpn_mon_total5;
    }
    public void setLpn_mon_total5(String lpn_mon_total5) {
        this.lpn_mon_total5 = lpn_mon_total5;
    }
    public String getLpn_night_fri1() {
        return lpn_night_fri1;
    }
    public void setLpn_night_fri1(String lpn_night_fri1) {
        this.lpn_night_fri1 = lpn_night_fri1;
    }
    public String getLpn_night_fri2() {
        return lpn_night_fri2;
    }
    public void setLpn_night_fri2(String lpn_night_fri2) {
        this.lpn_night_fri2 = lpn_night_fri2;
    }
    public String getLpn_night_fri3() {
        return lpn_night_fri3;
    }
    public void setLpn_night_fri3(String lpn_night_fri3) {
        this.lpn_night_fri3 = lpn_night_fri3;
    }
    public String getLpn_night_fri4() {
        return lpn_night_fri4;
    }
    public void setLpn_night_fri4(String lpn_night_fri4) {
        this.lpn_night_fri4 = lpn_night_fri4;
    }
    public String getLpn_night_fri5() {
        return lpn_night_fri5;
    }
    public void setLpn_night_fri5(String lpn_night_fri5) {
        this.lpn_night_fri5 = lpn_night_fri5;
    }
    public String getLpn_night_mon1() {
        return lpn_night_mon1;
    }
    public void setLpn_night_mon1(String lpn_night_mon1) {
        this.lpn_night_mon1 = lpn_night_mon1;
    }
    public String getLpn_night_mon2() {
        return lpn_night_mon2;
    }
    public void setLpn_night_mon2(String lpn_night_mon2) {
        this.lpn_night_mon2 = lpn_night_mon2;
    }
    public String getLpn_night_mon3() {
        return lpn_night_mon3;
    }
    public void setLpn_night_mon3(String lpn_night_mon3) {
        this.lpn_night_mon3 = lpn_night_mon3;
    }
    public String getLpn_night_mon4() {
        return lpn_night_mon4;
    }
    public void setLpn_night_mon4(String lpn_night_mon4) {
        this.lpn_night_mon4 = lpn_night_mon4;
    }
    public String getLpn_night_mon5() {
        return lpn_night_mon5;
    }
    public void setLpn_night_mon5(String lpn_night_mon5) {
        this.lpn_night_mon5 = lpn_night_mon5;
    }
    public String getLpn_night_sat1() {
        return lpn_night_sat1;
    }
    public void setLpn_night_sat1(String lpn_night_sat1) {
        this.lpn_night_sat1 = lpn_night_sat1;
    }
    public String getLpn_night_sat2() {
        return lpn_night_sat2;
    }
    public void setLpn_night_sat2(String lpn_night_sat2) {
        this.lpn_night_sat2 = lpn_night_sat2;
    }
    public String getLpn_night_sat3() {
        return lpn_night_sat3;
    }
    public void setLpn_night_sat3(String lpn_night_sat3) {
        this.lpn_night_sat3 = lpn_night_sat3;
    }
    public String getLpn_night_sat4() {
        return lpn_night_sat4;
    }
    public void setLpn_night_sat4(String lpn_night_sat4) {
        this.lpn_night_sat4 = lpn_night_sat4;
    }
    public String getLpn_night_sat5() {
        return lpn_night_sat5;
    }
    public void setLpn_night_sat5(String lpn_night_sat5) {
        this.lpn_night_sat5 = lpn_night_sat5;
    }
    public String getLpn_night_sun1() {
        return lpn_night_sun1;
    }
    public void setLpn_night_sun1(String lpn_night_sun1) {
        this.lpn_night_sun1 = lpn_night_sun1;
    }
    public String getLpn_night_sun2() {
        return lpn_night_sun2;
    }
    public void setLpn_night_sun2(String lpn_night_sun2) {
        this.lpn_night_sun2 = lpn_night_sun2;
    }
    public String getLpn_night_sun3() {
        return lpn_night_sun3;
    }
    public void setLpn_night_sun3(String lpn_night_sun3) {
        this.lpn_night_sun3 = lpn_night_sun3;
    }
    public String getLpn_night_sun4() {
        return lpn_night_sun4;
    }
    public void setLpn_night_sun4(String lpn_night_sun4) {
        this.lpn_night_sun4 = lpn_night_sun4;
    }
    public String getLpn_night_sun5() {
        return lpn_night_sun5;
    }
    public void setLpn_night_sun5(String lpn_night_sun5) {
        this.lpn_night_sun5 = lpn_night_sun5;
    }
    public String getLpn_night_thu1() {
        return lpn_night_thu1;
    }
    public void setLpn_night_thu1(String lpn_night_thu1) {
        this.lpn_night_thu1 = lpn_night_thu1;
    }
    public String getLpn_night_thu2() {
        return lpn_night_thu2;
    }
    public void setLpn_night_thu2(String lpn_night_thu2) {
        this.lpn_night_thu2 = lpn_night_thu2;
    }
    public String getLpn_night_thu3() {
        return lpn_night_thu3;
    }
    public void setLpn_night_thu3(String lpn_night_thu3) {
        this.lpn_night_thu3 = lpn_night_thu3;
    }
    public String getLpn_night_thu4() {
        return lpn_night_thu4;
    }
    public void setLpn_night_thu4(String lpn_night_thu4) {
        this.lpn_night_thu4 = lpn_night_thu4;
    }
    public String getLpn_night_thu5() {
        return lpn_night_thu5;
    }
    public void setLpn_night_thu5(String lpn_night_thu5) {
        this.lpn_night_thu5 = lpn_night_thu5;
    }
    public String getLpn_night_tue1() {
        return lpn_night_tue1;
    }
    public void setLpn_night_tue1(String lpn_night_tue1) {
        this.lpn_night_tue1 = lpn_night_tue1;
    }
    public String getLpn_night_tue2() {
        return lpn_night_tue2;
    }
    public void setLpn_night_tue2(String lpn_night_tue2) {
        this.lpn_night_tue2 = lpn_night_tue2;
    }
    public String getLpn_night_tue3() {
        return lpn_night_tue3;
    }
    public void setLpn_night_tue3(String lpn_night_tue3) {
        this.lpn_night_tue3 = lpn_night_tue3;
    }
    public String getLpn_night_tue4() {
        return lpn_night_tue4;
    }
    public void setLpn_night_tue4(String lpn_night_tue4) {
        this.lpn_night_tue4 = lpn_night_tue4;
    }
    public String getLpn_night_tue5() {
        return lpn_night_tue5;
    }
    public void setLpn_night_tue5(String lpn_night_tue5) {
        this.lpn_night_tue5 = lpn_night_tue5;
    }
    public String getLpn_night_wed1() {
        return lpn_night_wed1;
    }
    public void setLpn_night_wed1(String lpn_night_wed1) {
        this.lpn_night_wed1 = lpn_night_wed1;
    }
    public String getLpn_night_wed2() {
        return lpn_night_wed2;
    }
    public void setLpn_night_wed2(String lpn_night_wed2) {
        this.lpn_night_wed2 = lpn_night_wed2;
    }
    public String getLpn_night_wed3() {
        return lpn_night_wed3;
    }
    public void setLpn_night_wed3(String lpn_night_wed3) {
        this.lpn_night_wed3 = lpn_night_wed3;
    }
    public String getLpn_night_wed4() {
        return lpn_night_wed4;
    }
    public void setLpn_night_wed4(String lpn_night_wed4) {
        this.lpn_night_wed4 = lpn_night_wed4;
    }
    public String getLpn_night_wed5() {
        return lpn_night_wed5;
    }
    public void setLpn_night_wed5(String lpn_night_wed5) {
        this.lpn_night_wed5 = lpn_night_wed5;
    }
    public String getLpn_sat_total1() {
        return lpn_sat_total1;
    }
    public void setLpn_sat_total1(String lpn_sat_total1) {
        this.lpn_sat_total1 = lpn_sat_total1;
    }
    public String getLpn_sat_total2() {
        return lpn_sat_total2;
    }
    public void setLpn_sat_total2(String lpn_sat_total2) {
        this.lpn_sat_total2 = lpn_sat_total2;
    }
    public String getLpn_sat_total3() {
        return lpn_sat_total3;
    }
    public void setLpn_sat_total3(String lpn_sat_total3) {
        this.lpn_sat_total3 = lpn_sat_total3;
    }
    public String getLpn_sat_total4() {
        return lpn_sat_total4;
    }
    public void setLpn_sat_total4(String lpn_sat_total4) {
        this.lpn_sat_total4 = lpn_sat_total4;
    }
    public String getLpn_sat_total5() {
        return lpn_sat_total5;
    }
    public void setLpn_sat_total5(String lpn_sat_total5) {
        this.lpn_sat_total5 = lpn_sat_total5;
    }
    public String getLpn_sun_total1() {
        return lpn_sun_total1;
    }
    public void setLpn_sun_total1(String lpn_sun_total1) {
        this.lpn_sun_total1 = lpn_sun_total1;
    }
    public String getLpn_sun_total2() {
        return lpn_sun_total2;
    }
    public void setLpn_sun_total2(String lpn_sun_total2) {
        this.lpn_sun_total2 = lpn_sun_total2;
    }
    public String getLpn_sun_total3() {
        return lpn_sun_total3;
    }
    public void setLpn_sun_total3(String lpn_sun_total3) {
        this.lpn_sun_total3 = lpn_sun_total3;
    }
    public String getLpn_sun_total4() {
        return lpn_sun_total4;
    }
    public void setLpn_sun_total4(String lpn_sun_total4) {
        this.lpn_sun_total4 = lpn_sun_total4;
    }
    public String getLpn_sun_total5() {
        return lpn_sun_total5;
    }
    public void setLpn_sun_total5(String lpn_sun_total5) {
        this.lpn_sun_total5 = lpn_sun_total5;
    }
    public String getLpn_thu_total1() {
        return lpn_thu_total1;
    }
    public void setLpn_thu_total1(String lpn_thu_total1) {
        this.lpn_thu_total1 = lpn_thu_total1;
    }
    public String getLpn_thu_total2() {
        return lpn_thu_total2;
    }
    public void setLpn_thu_total2(String lpn_thu_total2) {
        this.lpn_thu_total2 = lpn_thu_total2;
    }
    public String getLpn_thu_total3() {
        return lpn_thu_total3;
    }
    public void setLpn_thu_total3(String lpn_thu_total3) {
        this.lpn_thu_total3 = lpn_thu_total3;
    }
    public String getLpn_thu_total4() {
        return lpn_thu_total4;
    }
    public void setLpn_thu_total4(String lpn_thu_total4) {
        this.lpn_thu_total4 = lpn_thu_total4;
    }
    public String getLpn_thu_total5() {
        return lpn_thu_total5;
    }
    public void setLpn_thu_total5(String lpn_thu_total5) {
        this.lpn_thu_total5 = lpn_thu_total5;
    }
    public String getLpn_tue_total1() {
        return lpn_tue_total1;
    }
    public void setLpn_tue_total1(String lpn_tue_total1) {
        this.lpn_tue_total1 = lpn_tue_total1;
    }
    public String getLpn_tue_total2() {
        return lpn_tue_total2;
    }
    public void setLpn_tue_total2(String lpn_tue_total2) {
        this.lpn_tue_total2 = lpn_tue_total2;
    }
    public String getLpn_tue_total3() {
        return lpn_tue_total3;
    }
    public void setLpn_tue_total3(String lpn_tue_total3) {
        this.lpn_tue_total3 = lpn_tue_total3;
    }
    public String getLpn_tue_total4() {
        return lpn_tue_total4;
    }
    public void setLpn_tue_total4(String lpn_tue_total4) {
        this.lpn_tue_total4 = lpn_tue_total4;
    }
    public String getLpn_tue_total5() {
        return lpn_tue_total5;
    }
    public void setLpn_tue_total5(String lpn_tue_total5) {
        this.lpn_tue_total5 = lpn_tue_total5;
    }
    public String getLpn_wed_total1() {
        return lpn_wed_total1;
    }
    public void setLpn_wed_total1(String lpn_wed_total1) {
        this.lpn_wed_total1 = lpn_wed_total1;
    }
    public String getLpn_wed_total2() {
        return lpn_wed_total2;
    }
    public void setLpn_wed_total2(String lpn_wed_total2) {
        this.lpn_wed_total2 = lpn_wed_total2;
    }
    public String getLpn_wed_total3() {
        return lpn_wed_total3;
    }
    public void setLpn_wed_total3(String lpn_wed_total3) {
        this.lpn_wed_total3 = lpn_wed_total3;
    }
    public String getLpn_wed_total4() {
        return lpn_wed_total4;
    }
    public void setLpn_wed_total4(String lpn_wed_total4) {
        this.lpn_wed_total4 = lpn_wed_total4;
    }
    public String getLpn_wed_total5() {
        return lpn_wed_total5;
    }
    public void setLpn_wed_total5(String lpn_wed_total5) {
        this.lpn_wed_total5 = lpn_wed_total5;
    }
    public String getNnp_fri_total1() {
        return nnp_fri_total1;
    }
    public void setNnp_fri_total1(String nnp_fri_total1) {
        this.nnp_fri_total1 = nnp_fri_total1;
    }
    public String getNnp_fri_total2() {
        return nnp_fri_total2;
    }
    public void setNnp_fri_total2(String nnp_fri_total2) {
        this.nnp_fri_total2 = nnp_fri_total2;
    }
    public String getNnp_fri_total3() {
        return nnp_fri_total3;
    }
    public void setNnp_fri_total3(String nnp_fri_total3) {
        this.nnp_fri_total3 = nnp_fri_total3;
    }
    public String getNnp_fri_total4() {
        return nnp_fri_total4;
    }
    public void setNnp_fri_total4(String nnp_fri_total4) {
        this.nnp_fri_total4 = nnp_fri_total4;
    }
    public String getNnp_fri_total5() {
        return nnp_fri_total5;
    }
    public void setNnp_fri_total5(String nnp_fri_total5) {
        this.nnp_fri_total5 = nnp_fri_total5;
    }
    public String getNnp_mon_total1() {
        return nnp_mon_total1;
    }
    public void setNnp_mon_total1(String nnp_mon_total1) {
        this.nnp_mon_total1 = nnp_mon_total1;
    }
    public String getNnp_mon_total2() {
        return nnp_mon_total2;
    }
    public void setNnp_mon_total2(String nnp_mon_total2) {
        this.nnp_mon_total2 = nnp_mon_total2;
    }
    public String getNnp_mon_total3() {
        return nnp_mon_total3;
    }
    public void setNnp_mon_total3(String nnp_mon_total3) {
        this.nnp_mon_total3 = nnp_mon_total3;
    }
    public String getNnp_mon_total4() {
        return nnp_mon_total4;
    }
    public void setNnp_mon_total4(String nnp_mon_total4) {
        this.nnp_mon_total4 = nnp_mon_total4;
    }
    public String getNnp_mon_total5() {
        return nnp_mon_total5;
    }
    public void setNnp_mon_total5(String nnp_mon_total5) {
        this.nnp_mon_total5 = nnp_mon_total5;
    }
    public String getNnp_sat_total1() {
        return nnp_sat_total1;
    }
    public void setNnp_sat_total1(String nnp_sat_total1) {
        this.nnp_sat_total1 = nnp_sat_total1;
    }
    public String getNnp_sat_total2() {
        return nnp_sat_total2;
    }
    public void setNnp_sat_total2(String nnp_sat_total2) {
        this.nnp_sat_total2 = nnp_sat_total2;
    }
    public String getNnp_sat_total3() {
        return nnp_sat_total3;
    }
    public void setNnp_sat_total3(String nnp_sat_total3) {
        this.nnp_sat_total3 = nnp_sat_total3;
    }
    public String getNnp_sat_total4() {
        return nnp_sat_total4;
    }
    public void setNnp_sat_total4(String nnp_sat_total4) {
        this.nnp_sat_total4 = nnp_sat_total4;
    }
    public String getNnp_sat_total5() {
        return nnp_sat_total5;
    }
    public void setNnp_sat_total5(String nnp_sat_total5) {
        this.nnp_sat_total5 = nnp_sat_total5;
    }
    public String getNnp_sun_total1() {
        return nnp_sun_total1;
    }
    public void setNnp_sun_total1(String nnp_sun_total1) {
        this.nnp_sun_total1 = nnp_sun_total1;
    }
    public String getNnp_sun_total2() {
        return nnp_sun_total2;
    }
    public void setNnp_sun_total2(String nnp_sun_total2) {
        this.nnp_sun_total2 = nnp_sun_total2;
    }
    public String getNnp_sun_total3() {
        return nnp_sun_total3;
    }
    public void setNnp_sun_total3(String nnp_sun_total3) {
        this.nnp_sun_total3 = nnp_sun_total3;
    }
    public String getNnp_sun_total4() {
        return nnp_sun_total4;
    }
    public void setNnp_sun_total4(String nnp_sun_total4) {
        this.nnp_sun_total4 = nnp_sun_total4;
    }
    public String getNnp_sun_total5() {
        return nnp_sun_total5;
    }
    public void setNnp_sun_total5(String nnp_sun_total5) {
        this.nnp_sun_total5 = nnp_sun_total5;
    }
    public String getNnp_thu_total1() {
        return nnp_thu_total1;
    }
    public void setNnp_thu_total1(String nnp_thu_total1) {
        this.nnp_thu_total1 = nnp_thu_total1;
    }
    public String getNnp_thu_total2() {
        return nnp_thu_total2;
    }
    public void setNnp_thu_total2(String nnp_thu_total2) {
        this.nnp_thu_total2 = nnp_thu_total2;
    }
    public String getNnp_thu_total3() {
        return nnp_thu_total3;
    }
    public void setNnp_thu_total3(String nnp_thu_total3) {
        this.nnp_thu_total3 = nnp_thu_total3;
    }
    public String getNnp_thu_total4() {
        return nnp_thu_total4;
    }
    public void setNnp_thu_total4(String nnp_thu_total4) {
        this.nnp_thu_total4 = nnp_thu_total4;
    }
    public String getNnp_thu_total5() {
        return nnp_thu_total5;
    }
    public void setNnp_thu_total5(String nnp_thu_total5) {
        this.nnp_thu_total5 = nnp_thu_total5;
    }
    public String getNnp_tue_total1() {
        return nnp_tue_total1;
    }
    public void setNnp_tue_total1(String nnp_tue_total1) {
        this.nnp_tue_total1 = nnp_tue_total1;
    }
    public String getNnp_tue_total2() {
        return nnp_tue_total2;
    }
    public void setNnp_tue_total2(String nnp_tue_total2) {
        this.nnp_tue_total2 = nnp_tue_total2;
    }
    public String getNnp_tue_total3() {
        return nnp_tue_total3;
    }
    public void setNnp_tue_total3(String nnp_tue_total3) {
        this.nnp_tue_total3 = nnp_tue_total3;
    }
    public String getNnp_tue_total4() {
        return nnp_tue_total4;
    }
    public void setNnp_tue_total4(String nnp_tue_total4) {
        this.nnp_tue_total4 = nnp_tue_total4;
    }
    public String getNnp_tue_total5() {
        return nnp_tue_total5;
    }
    public void setNnp_tue_total5(String nnp_tue_total5) {
        this.nnp_tue_total5 = nnp_tue_total5;
    }
    public String getNnp_wed_total1() {
        return nnp_wed_total1;
    }
    public void setNnp_wed_total1(String nnp_wed_total1) {
        this.nnp_wed_total1 = nnp_wed_total1;
    }
    public String getNnp_wed_total2() {
        return nnp_wed_total2;
    }
    public void setNnp_wed_total2(String nnp_wed_total2) {
        this.nnp_wed_total2 = nnp_wed_total2;
    }
    public String getNnp_wed_total3() {
        return nnp_wed_total3;
    }
    public void setNnp_wed_total3(String nnp_wed_total3) {
        this.nnp_wed_total3 = nnp_wed_total3;
    }
    public String getNnp_wed_total4() {
        return nnp_wed_total4;
    }
    public void setNnp_wed_total4(String nnp_wed_total4) {
        this.nnp_wed_total4 = nnp_wed_total4;
    }
    public String getNnp_wed_total5() {
        return nnp_wed_total5;
    }
    public void setNnp_wed_total5(String nnp_wed_total5) {
        this.nnp_wed_total5 = nnp_wed_total5;
    }
    public String getNp_week_total1() {
        return np_week_total1;
    }
    public void setNp_week_total1(String np_week_total1) {
        this.np_week_total1 = np_week_total1;
    }
    public String getNp_week_total2() {
        return np_week_total2;
    }
    public void setNp_week_total2(String np_week_total2) {
        this.np_week_total2 = np_week_total2;
    }
    public String getNp_week_total3() {
        return np_week_total3;
    }
    public void setNp_week_total3(String np_week_total3) {
        this.np_week_total3 = np_week_total3;
    }
    public String getNp_week_total4() {
        return np_week_total4;
    }
    public void setNp_week_total4(String np_week_total4) {
        this.np_week_total4 = np_week_total4;
    }
    public String getNp_week_total5() {
        return np_week_total5;
    }
    public void setNp_week_total5(String np_week_total5) {
        this.np_week_total5 = np_week_total5;
    }
    public String getNursing_label1() {
        return nursing_label1;
    }
    public void setNursing_label1(String nursing_label1) {
        this.nursing_label1 = nursing_label1;
    }
    public String getNursing_label2() {
        return nursing_label2;
    }
    public void setNursing_label2(String nursing_label2) {
        this.nursing_label2 = nursing_label2;
    }
    public String getNursing_label3() {
        return nursing_label3;
    }
    public void setNursing_label3(String nursing_label3) {
        this.nursing_label3 = nursing_label3;
    }
    public String getNursing_label4() {
        return nursing_label4;
    }
    public void setNursing_label4(String nursing_label4) {
        this.nursing_label4 = nursing_label4;
    }
    public String getNursing_label5() {
        return nursing_label5;
    }
    public void setNursing_label5(String nursing_label5) {
        this.nursing_label5 = nursing_label5;
    }
    public String getPeriodEndDate1() {
        return periodEndDate1;
    }
    public void setPeriodEndDate1(String periodEndDate1) {
        this.periodEndDate1 = periodEndDate1;
    }
    public String getPeriodEndDate2() {
        return periodEndDate2;
    }
    public void setPeriodEndDate2(String periodEndDate2) {
        this.periodEndDate2 = periodEndDate2;
    }
    public String getPeriodEndDate3() {
        return periodEndDate3;
    }
    public void setPeriodEndDate3(String periodEndDate3) {
        this.periodEndDate3 = periodEndDate3;
    }
    public String getPeriodEndDate4() {
        return periodEndDate4;
    }
    public void setPeriodEndDate4(String periodEndDate4) {
        this.periodEndDate4 = periodEndDate4;
    }
    public String getPeriodEndDate5() {
        return periodEndDate5;
    }
    public void setPeriodEndDate5(String periodEndDate5) {
        this.periodEndDate5 = periodEndDate5;
    }
    public String getRn_day_annual1() {
        return rn_day_annual1;
    }
    public void setRn_day_annual1(String rn_day_annual1) {
        this.rn_day_annual1 = rn_day_annual1;
    }
    public String getRn_day_annual2() {
        return rn_day_annual2;
    }
    public void setRn_day_annual2(String rn_day_annual2) {
        this.rn_day_annual2 = rn_day_annual2;
    }
    public String getRn_day_annual3() {
        return rn_day_annual3;
    }
    public void setRn_day_annual3(String rn_day_annual3) {
        this.rn_day_annual3 = rn_day_annual3;
    }
    public String getRn_day_annual4() {
        return rn_day_annual4;
    }
    public void setRn_day_annual4(String rn_day_annual4) {
        this.rn_day_annual4 = rn_day_annual4;
    }
    public String getRn_day_annual5() {
        return rn_day_annual5;
    }
    public void setRn_day_annual5(String rn_day_annual5) {
        this.rn_day_annual5 = rn_day_annual5;
    }
    public String getRn_eve_annual1() {
        return rn_eve_annual1;
    }
    public void setRn_eve_annual1(String rn_eve_annual1) {
        this.rn_eve_annual1 = rn_eve_annual1;
    }
    public String getRn_eve_annual2() {
        return rn_eve_annual2;
    }
    public void setRn_eve_annual2(String rn_eve_annual2) {
        this.rn_eve_annual2 = rn_eve_annual2;
    }
    public String getRn_eve_annual3() {
        return rn_eve_annual3;
    }
    public void setRn_eve_annual3(String rn_eve_annual3) {
        this.rn_eve_annual3 = rn_eve_annual3;
    }
    public String getRn_eve_annual4() {
        return rn_eve_annual4;
    }
    public void setRn_eve_annual4(String rn_eve_annual4) {
        this.rn_eve_annual4 = rn_eve_annual4;
    }
    public String getRn_eve_annual5() {
        return rn_eve_annual5;
    }
    public void setRn_eve_annual5(String rn_eve_annual5) {
        this.rn_eve_annual5 = rn_eve_annual5;
    }
    public String getRn_week_total1() {
        return rn_week_total1;
    }
    public void setRn_week_total1(String rn_week_total1) {
        this.rn_week_total1 = rn_week_total1;
    }
    public String getRn_week_total2() {
        return rn_week_total2;
    }
    public void setRn_week_total2(String rn_week_total2) {
        this.rn_week_total2 = rn_week_total2;
    }
    public String getRn_week_total3() {
        return rn_week_total3;
    }
    public void setRn_week_total3(String rn_week_total3) {
        this.rn_week_total3 = rn_week_total3;
    }
    public String getRn_week_total4() {
        return rn_week_total4;
    }
    public void setRn_week_total4(String rn_week_total4) {
        this.rn_week_total4 = rn_week_total4;
    }
    public String getRn_week_total5() {
        return rn_week_total5;
    }
    public void setRn_week_total5(String rn_week_total5) {
        this.rn_week_total5 = rn_week_total5;
    }
    public String getHPRD_total_fri1() {
        return HPRD_total_fri1;
    }
    public void setHPRD_total_fri1(String hPRD_total_fri1) {
        HPRD_total_fri1 = hPRD_total_fri1;
    }
    public String getHPRD_total_fri2() {
        return HPRD_total_fri2;
    }
    public void setHPRD_total_fri2(String hPRD_total_fri2) {
        HPRD_total_fri2 = hPRD_total_fri2;
    }
    public String getHPRD_total_fri3() {
        return HPRD_total_fri3;
    }
    public void setHPRD_total_fri3(String hPRD_total_fri3) {
        HPRD_total_fri3 = hPRD_total_fri3;
    }
    public String getHPRD_total_fri4() {
        return HPRD_total_fri4;
    }
    public void setHPRD_total_fri4(String hPRD_total_fri4) {
        HPRD_total_fri4 = hPRD_total_fri4;
    }
    public String getHPRD_total_fri5() {
        return HPRD_total_fri5;
    }
    public void setHPRD_total_fri5(String hPRD_total_fri5) {
        HPRD_total_fri5 = hPRD_total_fri5;
    }
    public String getHPRD_total_mon1() {
        return HPRD_total_mon1;
    }
    public void setHPRD_total_mon1(String hPRD_total_mon1) {
        HPRD_total_mon1 = hPRD_total_mon1;
    }
    public String getHPRD_total_mon2() {
        return HPRD_total_mon2;
    }
    public void setHPRD_total_mon2(String hPRD_total_mon2) {
        HPRD_total_mon2 = hPRD_total_mon2;
    }
    public String getHPRD_total_mon3() {
        return HPRD_total_mon3;
    }
    public void setHPRD_total_mon3(String hPRD_total_mon3) {
        HPRD_total_mon3 = hPRD_total_mon3;
    }
    public String getHPRD_total_mon4() {
        return HPRD_total_mon4;
    }
    public void setHPRD_total_mon4(String hPRD_total_mon4) {
        HPRD_total_mon4 = hPRD_total_mon4;
    }
    public String getHPRD_total_mon5() {
        return HPRD_total_mon5;
    }
    public void setHPRD_total_mon5(String hPRD_total_mon5) {
        HPRD_total_mon5 = hPRD_total_mon5;
    }
    public String getHPRD_total_sat1() {
        return HPRD_total_sat1;
    }
    public void setHPRD_total_sat1(String hPRD_total_sat1) {
        HPRD_total_sat1 = hPRD_total_sat1;
    }
    public String getHPRD_total_sat2() {
        return HPRD_total_sat2;
    }
    public void setHPRD_total_sat2(String hPRD_total_sat2) {
        HPRD_total_sat2 = hPRD_total_sat2;
    }
    public String getHPRD_total_sat3() {
        return HPRD_total_sat3;
    }
    public void setHPRD_total_sat3(String hPRD_total_sat3) {
        HPRD_total_sat3 = hPRD_total_sat3;
    }
    public String getHPRD_total_sat4() {
        return HPRD_total_sat4;
    }
    public void setHPRD_total_sat4(String hPRD_total_sat4) {
        HPRD_total_sat4 = hPRD_total_sat4;
    }
    public String getHPRD_total_sat5() {
        return HPRD_total_sat5;
    }
    public void setHPRD_total_sat5(String hPRD_total_sat5) {
        HPRD_total_sat5 = hPRD_total_sat5;
    }
    public String getHPRD_total_sun1() {
        return HPRD_total_sun1;
    }
    public void setHPRD_total_sun1(String hPRD_total_sun1) {
        HPRD_total_sun1 = hPRD_total_sun1;
    }
    public String getHPRD_total_sun2() {
        return HPRD_total_sun2;
    }
    public void setHPRD_total_sun2(String hPRD_total_sun2) {
        HPRD_total_sun2 = hPRD_total_sun2;
    }
    public String getHPRD_total_sun3() {
        return HPRD_total_sun3;
    }
    public void setHPRD_total_sun3(String hPRD_total_sun3) {
        HPRD_total_sun3 = hPRD_total_sun3;
    }
    public String getHPRD_total_sun4() {
        return HPRD_total_sun4;
    }
    public void setHPRD_total_sun4(String hPRD_total_sun4) {
        HPRD_total_sun4 = hPRD_total_sun4;
    }
    public String getHPRD_total_sun5() {
        return HPRD_total_sun5;
    }
    public void setHPRD_total_sun5(String hPRD_total_sun5) {
        HPRD_total_sun5 = hPRD_total_sun5;
    }
    public String getHPRD_total_thu1() {
        return HPRD_total_thu1;
    }
    public void setHPRD_total_thu1(String hPRD_total_thu1) {
        HPRD_total_thu1 = hPRD_total_thu1;
    }
    public String getHPRD_total_thu2() {
        return HPRD_total_thu2;
    }
    public void setHPRD_total_thu2(String hPRD_total_thu2) {
        HPRD_total_thu2 = hPRD_total_thu2;
    }
    public String getHPRD_total_thu3() {
        return HPRD_total_thu3;
    }
    public void setHPRD_total_thu3(String hPRD_total_thu3) {
        HPRD_total_thu3 = hPRD_total_thu3;
    }
    public String getHPRD_total_thu4() {
        return HPRD_total_thu4;
    }
    public void setHPRD_total_thu4(String hPRD_total_thu4) {
        HPRD_total_thu4 = hPRD_total_thu4;
    }
    public String getHPRD_total_thu5() {
        return HPRD_total_thu5;
    }
    public void setHPRD_total_thu5(String hPRD_total_thu5) {
        HPRD_total_thu5 = hPRD_total_thu5;
    }
    public String getHPRD_total_wed1() {
        return HPRD_total_wed1;
    }
    public void setHPRD_total_wed1(String hPRD_total_wed1) {
        HPRD_total_wed1 = hPRD_total_wed1;
    }
    public String getHPRD_total_wed2() {
        return HPRD_total_wed2;
    }
    public void setHPRD_total_wed2(String hPRD_total_wed2) {
        HPRD_total_wed2 = hPRD_total_wed2;
    }
    public String getHPRD_total_wed3() {
        return HPRD_total_wed3;
    }
    public void setHPRD_total_wed3(String hPRD_total_wed3) {
        HPRD_total_wed3 = hPRD_total_wed3;
    }
    public String getHPRD_total_wed4() {
        return HPRD_total_wed4;
    }
    public void setHPRD_total_wed4(String hPRD_total_wed4) {
        HPRD_total_wed4 = hPRD_total_wed4;
    }
    public String getHPRD_total_wed5() {
        return HPRD_total_wed5;
    }
    public void setHPRD_total_wed5(String hPRD_total_wed5) {
        HPRD_total_wed5 = hPRD_total_wed5;
    }
    public String getAld_week_total1() {
        return ald_week_total1;
    }
    public void setAld_week_total1(String ald_week_total1) {
        this.ald_week_total1 = ald_week_total1;
    }
    public String getAld_week_total2() {
        return ald_week_total2;
    }
    public void setAld_week_total2(String ald_week_total2) {
        this.ald_week_total2 = ald_week_total2;
    }
    public String getAld_week_total3() {
        return ald_week_total3;
    }
    public void setAld_week_total3(String ald_week_total3) {
        this.ald_week_total3 = ald_week_total3;
    }
    public String getAld_week_total4() {
        return ald_week_total4;
    }
    public void setAld_week_total4(String ald_week_total4) {
        this.ald_week_total4 = ald_week_total4;
    }
    public String getAld_week_total5() {
        return ald_week_total5;
    }
    public void setAld_week_total5(String ald_week_total5) {
        this.ald_week_total5 = ald_week_total5;
    }
    public String getAlliedNP_label1() {
        return alliedNP_label1;
    }
    public void setAlliedNP_label1(String alliedNP_label1) {
        this.alliedNP_label1 = alliedNP_label1;
    }
    public String getAlliedNP_label2() {
        return alliedNP_label2;
    }
    public void setAlliedNP_label2(String alliedNP_label2) {
        this.alliedNP_label2 = alliedNP_label2;
    }
    public String getAlliedNP_label3() {
        return alliedNP_label3;
    }
    public void setAlliedNP_label3(String alliedNP_label3) {
        this.alliedNP_label3 = alliedNP_label3;
    }
    public String getAlliedNP_label4() {
        return alliedNP_label4;
    }
    public void setAlliedNP_label4(String alliedNP_label4) {
        this.alliedNP_label4 = alliedNP_label4;
    }
    public String getAlliedNP_label5() {
        return alliedNP_label5;
    }
    public void setAlliedNP_label5(String alliedNP_label5) {
        this.alliedNP_label5 = alliedNP_label5;
    }
    public String getHca_day_annual1() {
        return hca_day_annual1;
    }
    public void setHca_day_annual1(String hca_day_annual1) {
        this.hca_day_annual1 = hca_day_annual1;
    }
    public String getHca_day_annual2() {
        return hca_day_annual2;
    }
    public void setHca_day_annual2(String hca_day_annual2) {
        this.hca_day_annual2 = hca_day_annual2;
    }
    public String getHca_day_annual3() {
        return hca_day_annual3;
    }
    public void setHca_day_annual3(String hca_day_annual3) {
        this.hca_day_annual3 = hca_day_annual3;
    }
    public String getHca_day_annual4() {
        return hca_day_annual4;
    }
    public void setHca_day_annual4(String hca_day_annual4) {
        this.hca_day_annual4 = hca_day_annual4;
    }
    public String getHca_day_annual5() {
        return hca_day_annual5;
    }
    public void setHca_day_annual5(String hca_day_annual5) {
        this.hca_day_annual5 = hca_day_annual5;
    }
    public String getHca_eve_annual1() {
        return hca_eve_annual1;
    }
    public void setHca_eve_annual1(String hca_eve_annual1) {
        this.hca_eve_annual1 = hca_eve_annual1;
    }
    public String getHca_eve_annual2() {
        return hca_eve_annual2;
    }
    public void setHca_eve_annual2(String hca_eve_annual2) {
        this.hca_eve_annual2 = hca_eve_annual2;
    }
    public String getHca_eve_annual3() {
        return hca_eve_annual3;
    }
    public void setHca_eve_annual3(String hca_eve_annual3) {
        this.hca_eve_annual3 = hca_eve_annual3;
    }
    public String getHca_eve_annual4() {
        return hca_eve_annual4;
    }
    public void setHca_eve_annual4(String hca_eve_annual4) {
        this.hca_eve_annual4 = hca_eve_annual4;
    }
    public String getHca_eve_annual5() {
        return hca_eve_annual5;
    }
    public void setHca_eve_annual5(String hca_eve_annual5) {
        this.hca_eve_annual5 = hca_eve_annual5;
    }
    public String getHca_week_total1() {
        return hca_week_total1;
    }
    public void setHca_week_total1(String hca_week_total1) {
        this.hca_week_total1 = hca_week_total1;
    }
    public String getHca_week_total2() {
        return hca_week_total2;
    }
    public void setHca_week_total2(String hca_week_total2) {
        this.hca_week_total2 = hca_week_total2;
    }
    public String getHca_week_total3() {
        return hca_week_total3;
    }
    public void setHca_week_total3(String hca_week_total3) {
        this.hca_week_total3 = hca_week_total3;
    }
    public String getHca_week_total4() {
        return hca_week_total4;
    }
    public void setHca_week_total4(String hca_week_total4) {
        this.hca_week_total4 = hca_week_total4;
    }
    public String getHca_week_total5() {
        return hca_week_total5;
    }
    public void setHca_week_total5(String hca_week_total5) {
        this.hca_week_total5 = hca_week_total5;
    }
    public String getLpn_day_annual1() {
        return lpn_day_annual1;
    }
    public void setLpn_day_annual1(String lpn_day_annual1) {
        this.lpn_day_annual1 = lpn_day_annual1;
    }
    public String getLpn_day_annual2() {
        return lpn_day_annual2;
    }
    public void setLpn_day_annual2(String lpn_day_annual2) {
        this.lpn_day_annual2 = lpn_day_annual2;
    }
    public String getLpn_day_annual3() {
        return lpn_day_annual3;
    }
    public void setLpn_day_annual3(String lpn_day_annual3) {
        this.lpn_day_annual3 = lpn_day_annual3;
    }
    public String getLpn_day_annual4() {
        return lpn_day_annual4;
    }
    public void setLpn_day_annual4(String lpn_day_annual4) {
        this.lpn_day_annual4 = lpn_day_annual4;
    }
    public String getLpn_day_annual5() {
        return lpn_day_annual5;
    }
    public void setLpn_day_annual5(String lpn_day_annual5) {
        this.lpn_day_annual5 = lpn_day_annual5;
    }
    public String getLpn_eve_annual1() {
        return lpn_eve_annual1;
    }
    public void setLpn_eve_annual1(String lpn_eve_annual1) {
        this.lpn_eve_annual1 = lpn_eve_annual1;
    }
    public String getLpn_eve_annual2() {
        return lpn_eve_annual2;
    }
    public void setLpn_eve_annual2(String lpn_eve_annual2) {
        this.lpn_eve_annual2 = lpn_eve_annual2;
    }
    public String getLpn_eve_annual3() {
        return lpn_eve_annual3;
    }
    public void setLpn_eve_annual3(String lpn_eve_annual3) {
        this.lpn_eve_annual3 = lpn_eve_annual3;
    }
    public String getLpn_eve_annual4() {
        return lpn_eve_annual4;
    }
    public void setLpn_eve_annual4(String lpn_eve_annual4) {
        this.lpn_eve_annual4 = lpn_eve_annual4;
    }
    public String getLpn_eve_annual5() {
        return lpn_eve_annual5;
    }
    public void setLpn_eve_annual5(String lpn_eve_annual5) {
        this.lpn_eve_annual5 = lpn_eve_annual5;
    }
    public String getLpn_week_total1() {
        return lpn_week_total1;
    }
    public void setLpn_week_total1(String lpn_week_total1) {
        this.lpn_week_total1 = lpn_week_total1;
    }
    public String getLpn_week_total2() {
        return lpn_week_total2;
    }
    public void setLpn_week_total2(String lpn_week_total2) {
        this.lpn_week_total2 = lpn_week_total2;
    }
    public String getLpn_week_total3() {
        return lpn_week_total3;
    }
    public void setLpn_week_total3(String lpn_week_total3) {
        this.lpn_week_total3 = lpn_week_total3;
    }
    public String getLpn_week_total4() {
        return lpn_week_total4;
    }
    public void setLpn_week_total4(String lpn_week_total4) {
        this.lpn_week_total4 = lpn_week_total4;
    }
    public String getLpn_week_total5() {
        return lpn_week_total5;
    }
    public void setLpn_week_total5(String lpn_week_total5) {
        this.lpn_week_total5 = lpn_week_total5;
    }
    public String getNnp_week_total1() {
        return nnp_week_total1;
    }
    public void setNnp_week_total1(String nnp_week_total1) {
        this.nnp_week_total1 = nnp_week_total1;
    }
    public String getNnp_week_total2() {
        return nnp_week_total2;
    }
    public void setNnp_week_total2(String nnp_week_total2) {
        this.nnp_week_total2 = nnp_week_total2;
    }
    public String getNnp_week_total3() {
        return nnp_week_total3;
    }
    public void setNnp_week_total3(String nnp_week_total3) {
        this.nnp_week_total3 = nnp_week_total3;
    }
    public String getNnp_week_total4() {
        return nnp_week_total4;
    }
    public void setNnp_week_total4(String nnp_week_total4) {
        this.nnp_week_total4 = nnp_week_total4;
    }
    public String getNnp_week_total5() {
        return nnp_week_total5;
    }
    public void setNnp_week_total5(String nnp_week_total5) {
        this.nnp_week_total5 = nnp_week_total5;
    }
    public String getRevisionReason1() {
        return revisionReason1;
    }
    public void setRevisionReason1(String revisionReason1) {
        this.revisionReason1 = revisionReason1;
    }
    public String getRevisionReason2() {
        return revisionReason2;
    }
    public void setRevisionReason2(String revisionReason2) {
        this.revisionReason2 = revisionReason2;
    }
    public String getRevisionReason3() {
        return revisionReason3;
    }
    public void setRevisionReason3(String revisionReason3) {
        this.revisionReason3 = revisionReason3;
    }
    public String getRevisionReason4() {
        return revisionReason4;
    }
    public void setRevisionReason4(String revisionReason4) {
        this.revisionReason4 = revisionReason4;
    }
    public String getRevisionReason5() {
        return revisionReason5;
    }
    public void setRevisionReason5(String revisionReason5) {
        this.revisionReason5 = revisionReason5;
    }
    public String getRn_night_label() {
        return rn_night_label;
    }
    public void setRn_night_label(String rn_night_label) {
        this.rn_night_label = rn_night_label;
    }
    public String getRn_night_label1() {
        return rn_night_label1;
    }
    public void setRn_night_label1(String rn_night_label1) {
        this.rn_night_label1 = rn_night_label1;
    }
    public String getRn_night_label2() {
        return rn_night_label2;
    }
    public void setRn_night_label2(String rn_night_label2) {
        this.rn_night_label2 = rn_night_label2;
    }
    public String getRn_night_label3() {
        return rn_night_label3;
    }
    public void setRn_night_label3(String rn_night_label3) {
        this.rn_night_label3 = rn_night_label3;
    }
    public String getRn_night_label4() {
        return rn_night_label4;
    }
    public void setRn_night_label4(String rn_night_label4) {
        this.rn_night_label4 = rn_night_label4;
    }
    public String getRn_night_label5() {
        return rn_night_label5;
    }
    public void setRn_night_label5(String rn_night_label5) {
        this.rn_night_label5 = rn_night_label5;
    }
    public String getRn_night_total1() {
        return rn_night_total1;
    }
    public void setRn_night_total1(String rn_night_total1) {
        this.rn_night_total1 = rn_night_total1;
    }
    public String getRn_night_total2() {
        return rn_night_total2;
    }
    public void setRn_night_total2(String rn_night_total2) {
        this.rn_night_total2 = rn_night_total2;
    }
    public String getRn_night_total3() {
        return rn_night_total3;
    }
    public void setRn_night_total3(String rn_night_total3) {
        this.rn_night_total3 = rn_night_total3;
    }
    public String getRn_night_total4() {
        return rn_night_total4;
    }
    public void setRn_night_total4(String rn_night_total4) {
        this.rn_night_total4 = rn_night_total4;
    }
    public String getRn_night_total5() {
        return rn_night_total5;
    }
    public void setRn_night_total5(String rn_night_total5) {
        this.rn_night_total5 = rn_night_total5;
    }
    public String getSummary_annual1() {
        return summary_annual1;
    }
    public void setSummary_annual1(String summary_annual1) {
        this.summary_annual1 = summary_annual1;
    }
    public String getSummary_annual2() {
        return summary_annual2;
    }
    public void setSummary_annual2(String summary_annual2) {
        this.summary_annual2 = summary_annual2;
    }
    public String getSummary_annual3() {
        return summary_annual3;
    }
    public void setSummary_annual3(String summary_annual3) {
        this.summary_annual3 = summary_annual3;
    }
    public String getSummary_annual4() {
        return summary_annual4;
    }
    public void setSummary_annual4(String summary_annual4) {
        this.summary_annual4 = summary_annual4;
    }
    public String getSummary_annual5() {
        return summary_annual5;
    }
    public void setSummary_annual5(String summary_annual5) {
        this.summary_annual5 = summary_annual5;
    }
    public String getHPRD_allied_fri1() {
        return HPRD_allied_fri1;
    }
    public void setHPRD_allied_fri1(String hPRD_allied_fri1) {
        HPRD_allied_fri1 = hPRD_allied_fri1;
    }
    public String getHPRD_allied_fri2() {
        return HPRD_allied_fri2;
    }
    public void setHPRD_allied_fri2(String hPRD_allied_fri2) {
        HPRD_allied_fri2 = hPRD_allied_fri2;
    }
    public String getHPRD_allied_fri3() {
        return HPRD_allied_fri3;
    }
    public void setHPRD_allied_fri3(String hPRD_allied_fri3) {
        HPRD_allied_fri3 = hPRD_allied_fri3;
    }
    public String getHPRD_allied_fri4() {
        return HPRD_allied_fri4;
    }
    public void setHPRD_allied_fri4(String hPRD_allied_fri4) {
        HPRD_allied_fri4 = hPRD_allied_fri4;
    }
    public String getHPRD_allied_fri5() {
        return HPRD_allied_fri5;
    }
    public void setHPRD_allied_fri5(String hPRD_allied_fri5) {
        HPRD_allied_fri5 = hPRD_allied_fri5;
    }
    public String getHPRD_allied_mon1() {
        return HPRD_allied_mon1;
    }
    public void setHPRD_allied_mon1(String hPRD_allied_mon1) {
        HPRD_allied_mon1 = hPRD_allied_mon1;
    }
    public String getHPRD_allied_mon2() {
        return HPRD_allied_mon2;
    }
    public void setHPRD_allied_mon2(String hPRD_allied_mon2) {
        HPRD_allied_mon2 = hPRD_allied_mon2;
    }
    public String getHPRD_allied_mon3() {
        return HPRD_allied_mon3;
    }
    public void setHPRD_allied_mon3(String hPRD_allied_mon3) {
        HPRD_allied_mon3 = hPRD_allied_mon3;
    }
    public String getHPRD_allied_mon4() {
        return HPRD_allied_mon4;
    }
    public void setHPRD_allied_mon4(String hPRD_allied_mon4) {
        HPRD_allied_mon4 = hPRD_allied_mon4;
    }
    public String getHPRD_allied_mon5() {
        return HPRD_allied_mon5;
    }
    public void setHPRD_allied_mon5(String hPRD_allied_mon5) {
        HPRD_allied_mon5 = hPRD_allied_mon5;
    }
    public String getHPRD_allied_sat1() {
        return HPRD_allied_sat1;
    }
    public void setHPRD_allied_sat1(String hPRD_allied_sat1) {
        HPRD_allied_sat1 = hPRD_allied_sat1;
    }
    public String getHPRD_allied_sat2() {
        return HPRD_allied_sat2;
    }
    public void setHPRD_allied_sat2(String hPRD_allied_sat2) {
        HPRD_allied_sat2 = hPRD_allied_sat2;
    }
    public String getHPRD_allied_sat3() {
        return HPRD_allied_sat3;
    }
    public void setHPRD_allied_sat3(String hPRD_allied_sat3) {
        HPRD_allied_sat3 = hPRD_allied_sat3;
    }
    public String getHPRD_allied_sat4() {
        return HPRD_allied_sat4;
    }
    public void setHPRD_allied_sat4(String hPRD_allied_sat4) {
        HPRD_allied_sat4 = hPRD_allied_sat4;
    }
    public String getHPRD_allied_sat5() {
        return HPRD_allied_sat5;
    }
    public void setHPRD_allied_sat5(String hPRD_allied_sat5) {
        HPRD_allied_sat5 = hPRD_allied_sat5;
    }
    public String getHPRD_allied_sun1() {
        return HPRD_allied_sun1;
    }
    public void setHPRD_allied_sun1(String hPRD_allied_sun1) {
        HPRD_allied_sun1 = hPRD_allied_sun1;
    }
    public String getHPRD_allied_sun2() {
        return HPRD_allied_sun2;
    }
    public void setHPRD_allied_sun2(String hPRD_allied_sun2) {
        HPRD_allied_sun2 = hPRD_allied_sun2;
    }
    public String getHPRD_allied_sun3() {
        return HPRD_allied_sun3;
    }
    public void setHPRD_allied_sun3(String hPRD_allied_sun3) {
        HPRD_allied_sun3 = hPRD_allied_sun3;
    }
    public String getHPRD_allied_sun4() {
        return HPRD_allied_sun4;
    }
    public void setHPRD_allied_sun4(String hPRD_allied_sun4) {
        HPRD_allied_sun4 = hPRD_allied_sun4;
    }
    public String getHPRD_allied_sun5() {
        return HPRD_allied_sun5;
    }
    public void setHPRD_allied_sun5(String hPRD_allied_sun5) {
        HPRD_allied_sun5 = hPRD_allied_sun5;
    }
    public String getHPRD_allied_thu1() {
        return HPRD_allied_thu1;
    }
    public void setHPRD_allied_thu1(String hPRD_allied_thu1) {
        HPRD_allied_thu1 = hPRD_allied_thu1;
    }
    public String getHPRD_allied_thu2() {
        return HPRD_allied_thu2;
    }
    public void setHPRD_allied_thu2(String hPRD_allied_thu2) {
        HPRD_allied_thu2 = hPRD_allied_thu2;
    }
    public String getHPRD_allied_thu3() {
        return HPRD_allied_thu3;
    }
    public void setHPRD_allied_thu3(String hPRD_allied_thu3) {
        HPRD_allied_thu3 = hPRD_allied_thu3;
    }
    public String getHPRD_allied_thu4() {
        return HPRD_allied_thu4;
    }
    public void setHPRD_allied_thu4(String hPRD_allied_thu4) {
        HPRD_allied_thu4 = hPRD_allied_thu4;
    }
    public String getHPRD_allied_thu5() {
        return HPRD_allied_thu5;
    }
    public void setHPRD_allied_thu5(String hPRD_allied_thu5) {
        HPRD_allied_thu5 = hPRD_allied_thu5;
    }
    public String getHPRD_allied_tue1() {
        return HPRD_allied_tue1;
    }
    public void setHPRD_allied_tue1(String hPRD_allied_tue1) {
        HPRD_allied_tue1 = hPRD_allied_tue1;
    }
    public String getHPRD_allied_tue2() {
        return HPRD_allied_tue2;
    }
    public void setHPRD_allied_tue2(String hPRD_allied_tue2) {
        HPRD_allied_tue2 = hPRD_allied_tue2;
    }
    public String getHPRD_allied_tue3() {
        return HPRD_allied_tue3;
    }
    public void setHPRD_allied_tue3(String hPRD_allied_tue3) {
        HPRD_allied_tue3 = hPRD_allied_tue3;
    }
    public String getHPRD_allied_tue4() {
        return HPRD_allied_tue4;
    }
    public void setHPRD_allied_tue4(String hPRD_allied_tue4) {
        HPRD_allied_tue4 = hPRD_allied_tue4;
    }
    public String getHPRD_allied_tue5() {
        return HPRD_allied_tue5;
    }
    public void setHPRD_allied_tue5(String hPRD_allied_tue5) {
        HPRD_allied_tue5 = hPRD_allied_tue5;
    }
    public String getHPRD_allied_wed1() {
        return HPRD_allied_wed1;
    }
    public void setHPRD_allied_wed1(String hPRD_allied_wed1) {
        HPRD_allied_wed1 = hPRD_allied_wed1;
    }
    public String getHPRD_allied_wed2() {
        return HPRD_allied_wed2;
    }
    public void setHPRD_allied_wed2(String hPRD_allied_wed2) {
        HPRD_allied_wed2 = hPRD_allied_wed2;
    }
    public String getHPRD_allied_wed3() {
        return HPRD_allied_wed3;
    }
    public void setHPRD_allied_wed3(String hPRD_allied_wed3) {
        HPRD_allied_wed3 = hPRD_allied_wed3;
    }
    public String getHPRD_allied_wed4() {
        return HPRD_allied_wed4;
    }
    public void setHPRD_allied_wed4(String hPRD_allied_wed4) {
        HPRD_allied_wed4 = hPRD_allied_wed4;
    }
    public String getHPRD_allied_wed5() {
        return HPRD_allied_wed5;
    }
    public void setHPRD_allied_wed5(String hPRD_allied_wed5) {
        HPRD_allied_wed5 = hPRD_allied_wed5;
    }
    public String getAldnop_at_label1() {
        return aldnop_at_label1;
    }
    public void setAldnop_at_label1(String aldnop_at_label1) {
        this.aldnop_at_label1 = aldnop_at_label1;
    }
    public String getAldnop_at_label2() {
        return aldnop_at_label2;
    }
    public void setAldnop_at_label2(String aldnop_at_label2) {
        this.aldnop_at_label2 = aldnop_at_label2;
    }
    public String getAldnop_at_label3() {
        return aldnop_at_label3;
    }
    public void setAldnop_at_label3(String aldnop_at_label3) {
        this.aldnop_at_label3 = aldnop_at_label3;
    }
    public String getAldnop_at_label4() {
        return aldnop_at_label4;
    }
    public void setAldnop_at_label4(String aldnop_at_label4) {
        this.aldnop_at_label4 = aldnop_at_label4;
    }
    public String getAldnop_at_label5() {
        return aldnop_at_label5;
    }
    public void setAldnop_at_label5(String aldnop_at_label5) {
        this.aldnop_at_label5 = aldnop_at_label5;
    }
    public String getAldnop_at_total1() {
        return aldnop_at_total1;
    }
    public void setAldnop_at_total1(String aldnop_at_total1) {
        this.aldnop_at_total1 = aldnop_at_total1;
    }
    public String getAldnop_at_total2() {
        return aldnop_at_total2;
    }
    public void setAldnop_at_total2(String aldnop_at_total2) {
        this.aldnop_at_total2 = aldnop_at_total2;
    }
    public String getAldnop_at_total3() {
        return aldnop_at_total3;
    }
    public void setAldnop_at_total3(String aldnop_at_total3) {
        this.aldnop_at_total3 = aldnop_at_total3;
    }
    public String getAldnop_at_total4() {
        return aldnop_at_total4;
    }
    public void setAldnop_at_total4(String aldnop_at_total4) {
        this.aldnop_at_total4 = aldnop_at_total4;
    }
    public String getAldnop_at_total5() {
        return aldnop_at_total5;
    }
    public void setAldnop_at_total5(String aldnop_at_total5) {
        this.aldnop_at_total5 = aldnop_at_total5;
    }
    public String getAldnop_aw_label1() {
        return aldnop_aw_label1;
    }
    public void setAldnop_aw_label1(String aldnop_aw_label1) {
        this.aldnop_aw_label1 = aldnop_aw_label1;
    }
    public String getAldnop_aw_label2() {
        return aldnop_aw_label2;
    }
    public void setAldnop_aw_label2(String aldnop_aw_label2) {
        this.aldnop_aw_label2 = aldnop_aw_label2;
    }
    public String getAldnop_aw_label3() {
        return aldnop_aw_label3;
    }
    public void setAldnop_aw_label3(String aldnop_aw_label3) {
        this.aldnop_aw_label3 = aldnop_aw_label3;
    }
    public String getAldnop_aw_label4() {
        return aldnop_aw_label4;
    }
    public void setAldnop_aw_label4(String aldnop_aw_label4) {
        this.aldnop_aw_label4 = aldnop_aw_label4;
    }
    public String getAldnop_aw_label5() {
        return aldnop_aw_label5;
    }
    public void setAldnop_aw_label5(String aldnop_aw_label5) {
        this.aldnop_aw_label5 = aldnop_aw_label5;
    }
    public String getAldnop_aw_total1() {
        return aldnop_aw_total1;
    }
    public void setAldnop_aw_total1(String aldnop_aw_total1) {
        this.aldnop_aw_total1 = aldnop_aw_total1;
    }
    public String getAldnop_aw_total2() {
        return aldnop_aw_total2;
    }
    public void setAldnop_aw_total2(String aldnop_aw_total2) {
        this.aldnop_aw_total2 = aldnop_aw_total2;
    }
    public String getAldnop_aw_total3() {
        return aldnop_aw_total3;
    }
    public void setAldnop_aw_total3(String aldnop_aw_total3) {
        this.aldnop_aw_total3 = aldnop_aw_total3;
    }
    public String getAldnop_aw_total4() {
        return aldnop_aw_total4;
    }
    public void setAldnop_aw_total4(String aldnop_aw_total4) {
        this.aldnop_aw_total4 = aldnop_aw_total4;
    }
    public String getAldnop_aw_total5() {
        return aldnop_aw_total5;
    }
    public void setAldnop_aw_total5(String aldnop_aw_total5) {
        this.aldnop_aw_total5 = aldnop_aw_total5;
    }
    public String getAldnop_mt_label1() {
        return aldnop_mt_label1;
    }
    public void setAldnop_mt_label1(String aldnop_mt_label1) {
        this.aldnop_mt_label1 = aldnop_mt_label1;
    }
    public String getAldnop_mt_label2() {
        return aldnop_mt_label2;
    }
    public void setAldnop_mt_label2(String aldnop_mt_label2) {
        this.aldnop_mt_label2 = aldnop_mt_label2;
    }
    public String getAldnop_mt_label3() {
        return aldnop_mt_label3;
    }
    public void setAldnop_mt_label3(String aldnop_mt_label3) {
        this.aldnop_mt_label3 = aldnop_mt_label3;
    }
    public String getAldnop_mt_label4() {
        return aldnop_mt_label4;
    }
    public void setAldnop_mt_label4(String aldnop_mt_label4) {
        this.aldnop_mt_label4 = aldnop_mt_label4;
    }
    public String getAldnop_mt_label5() {
        return aldnop_mt_label5;
    }
    public void setAldnop_mt_label5(String aldnop_mt_label5) {
        this.aldnop_mt_label5 = aldnop_mt_label5;
    }
    public String getAldnop_mt_total1() {
        return aldnop_mt_total1;
    }
    public void setAldnop_mt_total1(String aldnop_mt_total1) {
        this.aldnop_mt_total1 = aldnop_mt_total1;
    }
    public String getAldnop_mt_total2() {
        return aldnop_mt_total2;
    }
    public void setAldnop_mt_total2(String aldnop_mt_total2) {
        this.aldnop_mt_total2 = aldnop_mt_total2;
    }
    public String getAldnop_mt_total3() {
        return aldnop_mt_total3;
    }
    public void setAldnop_mt_total3(String aldnop_mt_total3) {
        this.aldnop_mt_total3 = aldnop_mt_total3;
    }
    public String getAldnop_mt_total4() {
        return aldnop_mt_total4;
    }
    public void setAldnop_mt_total4(String aldnop_mt_total4) {
        this.aldnop_mt_total4 = aldnop_mt_total4;
    }
    public String getAldnop_mt_total5() {
        return aldnop_mt_total5;
    }
    public void setAldnop_mt_total5(String aldnop_mt_total5) {
        this.aldnop_mt_total5 = aldnop_mt_total5;
    }
    public String getAldnop_ra_label1() {
        return aldnop_ra_label1;
    }
    public void setAldnop_ra_label1(String aldnop_ra_label1) {
        this.aldnop_ra_label1 = aldnop_ra_label1;
    }
    public String getAldnop_ra_label2() {
        return aldnop_ra_label2;
    }
    public void setAldnop_ra_label2(String aldnop_ra_label2) {
        this.aldnop_ra_label2 = aldnop_ra_label2;
    }
    public String getAldnop_ra_label3() {
        return aldnop_ra_label3;
    }
    public void setAldnop_ra_label3(String aldnop_ra_label3) {
        this.aldnop_ra_label3 = aldnop_ra_label3;
    }
    public String getAldnop_ra_label4() {
        return aldnop_ra_label4;
    }
    public void setAldnop_ra_label4(String aldnop_ra_label4) {
        this.aldnop_ra_label4 = aldnop_ra_label4;
    }
    public String getAldnop_ra_label5() {
        return aldnop_ra_label5;
    }
    public void setAldnop_ra_label5(String aldnop_ra_label5) {
        this.aldnop_ra_label5 = aldnop_ra_label5;
    }
    public String getAldnop_ra_total1() {
        return aldnop_ra_total1;
    }
    public void setAldnop_ra_total1(String aldnop_ra_total1) {
        this.aldnop_ra_total1 = aldnop_ra_total1;
    }
    public String getAldnop_ra_total2() {
        return aldnop_ra_total2;
    }
    public void setAldnop_ra_total2(String aldnop_ra_total2) {
        this.aldnop_ra_total2 = aldnop_ra_total2;
    }
    public String getAldnop_ra_total3() {
        return aldnop_ra_total3;
    }
    public void setAldnop_ra_total3(String aldnop_ra_total3) {
        this.aldnop_ra_total3 = aldnop_ra_total3;
    }
    public String getAldnop_ra_total4() {
        return aldnop_ra_total4;
    }
    public void setAldnop_ra_total4(String aldnop_ra_total4) {
        this.aldnop_ra_total4 = aldnop_ra_total4;
    }
    public String getAldnop_ra_total5() {
        return aldnop_ra_total5;
    }
    public void setAldnop_ra_total5(String aldnop_ra_total5) {
        this.aldnop_ra_total5 = aldnop_ra_total5;
    }
    public String getAldnop_rt_label1() {
        return aldnop_rt_label1;
    }
    public void setAldnop_rt_label1(String aldnop_rt_label1) {
        this.aldnop_rt_label1 = aldnop_rt_label1;
    }
    public String getAldnop_rt_label2() {
        return aldnop_rt_label2;
    }
    public void setAldnop_rt_label2(String aldnop_rt_label2) {
        this.aldnop_rt_label2 = aldnop_rt_label2;
    }
    public String getAldnop_rt_label3() {
        return aldnop_rt_label3;
    }
    public void setAldnop_rt_label3(String aldnop_rt_label3) {
        this.aldnop_rt_label3 = aldnop_rt_label3;
    }
    public String getAldnop_rt_label4() {
        return aldnop_rt_label4;
    }
    public void setAldnop_rt_label4(String aldnop_rt_label4) {
        this.aldnop_rt_label4 = aldnop_rt_label4;
    }
    public String getAldnop_rt_label5() {
        return aldnop_rt_label5;
    }
    public void setAldnop_rt_label5(String aldnop_rt_label5) {
        this.aldnop_rt_label5 = aldnop_rt_label5;
    }
    public String getAldnop_rt_total1() {
        return aldnop_rt_total1;
    }
    public void setAldnop_rt_total1(String aldnop_rt_total1) {
        this.aldnop_rt_total1 = aldnop_rt_total1;
    }
    public String getAldnop_rt_total2() {
        return aldnop_rt_total2;
    }
    public void setAldnop_rt_total2(String aldnop_rt_total2) {
        this.aldnop_rt_total2 = aldnop_rt_total2;
    }
    public String getAldnop_rt_total3() {
        return aldnop_rt_total3;
    }
    public void setAldnop_rt_total3(String aldnop_rt_total3) {
        this.aldnop_rt_total3 = aldnop_rt_total3;
    }
    public String getAldnop_rt_total4() {
        return aldnop_rt_total4;
    }
    public void setAldnop_rt_total4(String aldnop_rt_total4) {
        this.aldnop_rt_total4 = aldnop_rt_total4;
    }
    public String getAldnop_rt_total5() {
        return aldnop_rt_total5;
    }
    public void setAldnop_rt_total5(String aldnop_rt_total5) {
        this.aldnop_rt_total5 = aldnop_rt_total5;
    }
    public String getHca_night_label1() {
        return hca_night_label1;
    }
    public void setHca_night_label1(String hca_night_label1) {
        this.hca_night_label1 = hca_night_label1;
    }
    public String getHca_night_label2() {
        return hca_night_label2;
    }
    public void setHca_night_label2(String hca_night_label2) {
        this.hca_night_label2 = hca_night_label2;
    }
    public String getHca_night_label3() {
        return hca_night_label3;
    }
    public void setHca_night_label3(String hca_night_label3) {
        this.hca_night_label3 = hca_night_label3;
    }
    public String getHca_night_label4() {
        return hca_night_label4;
    }
    public void setHca_night_label4(String hca_night_label4) {
        this.hca_night_label4 = hca_night_label4;
    }
    public String getHca_night_label5() {
        return hca_night_label5;
    }
    public void setHca_night_label5(String hca_night_label5) {
        this.hca_night_label5 = hca_night_label5;
    }
    public String getHca_night_total1() {
        return hca_night_total1;
    }
    public void setHca_night_total1(String hca_night_total1) {
        this.hca_night_total1 = hca_night_total1;
    }
    public String getHca_night_total2() {
        return hca_night_total2;
    }
    public void setHca_night_total2(String hca_night_total2) {
        this.hca_night_total2 = hca_night_total2;
    }
    public String getHca_night_total3() {
        return hca_night_total3;
    }
    public void setHca_night_total3(String hca_night_total3) {
        this.hca_night_total3 = hca_night_total3;
    }
    public String getHca_night_total4() {
        return hca_night_total4;
    }
    public void setHca_night_total4(String hca_night_total4) {
        this.hca_night_total4 = hca_night_total4;
    }
    public String getHca_night_total5() {
        return hca_night_total5;
    }
    public void setHca_night_total5(String hca_night_total5) {
        this.hca_night_total5 = hca_night_total5;
    }
    public String getLpn_night_label1() {
        return lpn_night_label1;
    }
    public void setLpn_night_label1(String lpn_night_label1) {
        this.lpn_night_label1 = lpn_night_label1;
    }
    public String getLpn_night_label2() {
        return lpn_night_label2;
    }
    public void setLpn_night_label2(String lpn_night_label2) {
        this.lpn_night_label2 = lpn_night_label2;
    }
    public String getLpn_night_label3() {
        return lpn_night_label3;
    }
    public void setLpn_night_label3(String lpn_night_label3) {
        this.lpn_night_label3 = lpn_night_label3;
    }
    public String getLpn_night_label4() {
        return lpn_night_label4;
    }
    public void setLpn_night_label4(String lpn_night_label4) {
        this.lpn_night_label4 = lpn_night_label4;
    }
    public String getLpn_night_label5() {
        return lpn_night_label5;
    }
    public void setLpn_night_label5(String lpn_night_label5) {
        this.lpn_night_label5 = lpn_night_label5;
    }
    public String getLpn_night_total1() {
        return lpn_night_total1;
    }
    public void setLpn_night_total1(String lpn_night_total1) {
        this.lpn_night_total1 = lpn_night_total1;
    }
    public String getLpn_night_total2() {
        return lpn_night_total2;
    }
    public void setLpn_night_total2(String lpn_night_total2) {
        this.lpn_night_total2 = lpn_night_total2;
    }
    public String getLpn_night_total3() {
        return lpn_night_total3;
    }
    public void setLpn_night_total3(String lpn_night_total3) {
        this.lpn_night_total3 = lpn_night_total3;
    }
    public String getLpn_night_total4() {
        return lpn_night_total4;
    }
    public void setLpn_night_total4(String lpn_night_total4) {
        this.lpn_night_total4 = lpn_night_total4;
    }
    public String getLpn_night_total5() {
        return lpn_night_total5;
    }
    public void setLpn_night_total5(String lpn_night_total5) {
        this.lpn_night_total5 = lpn_night_total5;
    }
    public String getNp_annual_total1() {
        return np_annual_total1;
    }
    public void setNp_annual_total1(String np_annual_total1) {
        this.np_annual_total1 = np_annual_total1;
    }
    public String getNp_annual_total2() {
        return np_annual_total2;
    }
    public void setNp_annual_total2(String np_annual_total2) {
        this.np_annual_total2 = np_annual_total2;
    }
    public String getNp_annual_total3() {
        return np_annual_total3;
    }
    public void setNp_annual_total3(String np_annual_total3) {
        this.np_annual_total3 = np_annual_total3;
    }
    public String getNp_annual_total4() {
        return np_annual_total4;
    }
    public void setNp_annual_total4(String np_annual_total4) {
        this.np_annual_total4 = np_annual_total4;
    }
    public String getNp_annual_total5() {
        return np_annual_total5;
    }
    public void setNp_annual_total5(String np_annual_total5) {
        this.np_annual_total5 = np_annual_total5;
    }
    public String getPeriodStartDate1() {
        return periodStartDate1;
    }
    public void setPeriodStartDate1(String periodStartDate1) {
        this.periodStartDate1 = periodStartDate1;
    }
    public String getPeriodStartDate2() {
        return periodStartDate2;
    }
    public void setPeriodStartDate2(String periodStartDate2) {
        this.periodStartDate2 = periodStartDate2;
    }
    public String getPeriodStartDate3() {
        return periodStartDate3;
    }
    public void setPeriodStartDate3(String periodStartDate3) {
        this.periodStartDate3 = periodStartDate3;
    }
    public String getPeriodStartDate4() {
        return periodStartDate4;
    }
    public void setPeriodStartDate4(String periodStartDate4) {
        this.periodStartDate4 = periodStartDate4;
    }
    public String getPeriodStartDate5() {
        return periodStartDate5;
    }
    public void setPeriodStartDate5(String periodStartDate5) {
        this.periodStartDate5 = periodStartDate5;
    }
    public String getProviderName_AT1() {
        return providerName_AT1;
    }
    public void setProviderName_AT1(String providerName_AT1) {
        this.providerName_AT1 = providerName_AT1;
    }
    public String getProviderName_AT2() {
        return providerName_AT2;
    }
    public void setProviderName_AT2(String providerName_AT2) {
        this.providerName_AT2 = providerName_AT2;
    }
    public String getProviderName_AT3() {
        return providerName_AT3;
    }
    public void setProviderName_AT3(String providerName_AT3) {
        this.providerName_AT3 = providerName_AT3;
    }
    public String getProviderName_AT4() {
        return providerName_AT4;
    }
    public void setProviderName_AT4(String providerName_AT4) {
        this.providerName_AT4 = providerName_AT4;
    }
    public String getProviderName_AT5() {
        return providerName_AT5;
    }
    public void setProviderName_AT5(String providerName_AT5) {
        this.providerName_AT5 = providerName_AT5;
    }
    public String getProviderName_AW1() {
        return providerName_AW1;
    }
    public void setProviderName_AW1(String providerName_AW1) {
        this.providerName_AW1 = providerName_AW1;
    }
    public String getProviderName_AW2() {
        return providerName_AW2;
    }
    public void setProviderName_AW2(String providerName_AW2) {
        this.providerName_AW2 = providerName_AW2;
    }
    public String getProviderName_AW3() {
        return providerName_AW3;
    }
    public void setProviderName_AW3(String providerName_AW3) {
        this.providerName_AW3 = providerName_AW3;
    }
    public String getProviderName_AW4() {
        return providerName_AW4;
    }
    public void setProviderName_AW4(String providerName_AW4) {
        this.providerName_AW4 = providerName_AW4;
    }
    public String getProviderName_AW5() {
        return providerName_AW5;
    }
    public void setProviderName_AW5(String providerName_AW5) {
        this.providerName_AW5 = providerName_AW5;
    }
    public String getProviderName_DT1() {
        return providerName_DT1;
    }
    public void setProviderName_DT1(String providerName_DT1) {
        this.providerName_DT1 = providerName_DT1;
    }
    public String getProviderName_DT2() {
        return providerName_DT2;
    }
    public void setProviderName_DT2(String providerName_DT2) {
        this.providerName_DT2 = providerName_DT2;
    }
    public String getProviderName_DT3() {
        return providerName_DT3;
    }
    public void setProviderName_DT3(String providerName_DT3) {
        this.providerName_DT3 = providerName_DT3;
    }
    public String getProviderName_DT4() {
        return providerName_DT4;
    }
    public void setProviderName_DT4(String providerName_DT4) {
        this.providerName_DT4 = providerName_DT4;
    }
    public String getProviderName_DT5() {
        return providerName_DT5;
    }
    public void setProviderName_DT5(String providerName_DT5) {
        this.providerName_DT5 = providerName_DT5;
    }
    public String getProviderName_MT1() {
        return providerName_MT1;
    }
    public void setProviderName_MT1(String providerName_MT1) {
        this.providerName_MT1 = providerName_MT1;
    }
    public String getProviderName_MT2() {
        return providerName_MT2;
    }
    public void setProviderName_MT2(String providerName_MT2) {
        this.providerName_MT2 = providerName_MT2;
    }
    public String getProviderName_MT3() {
        return providerName_MT3;
    }
    public void setProviderName_MT3(String providerName_MT3) {
        this.providerName_MT3 = providerName_MT3;
    }
    public String getProviderName_MT4() {
        return providerName_MT4;
    }
    public void setProviderName_MT4(String providerName_MT4) {
        this.providerName_MT4 = providerName_MT4;
    }
    public String getProviderName_MT5() {
        return providerName_MT5;
    }
    public void setProviderName_MT5(String providerName_MT5) {
        this.providerName_MT5 = providerName_MT5;
    }
    public String getProviderName_OT1() {
        return providerName_OT1;
    }
    public void setProviderName_OT1(String providerName_OT1) {
        this.providerName_OT1 = providerName_OT1;
    }
    public String getProviderName_OT2() {
        return providerName_OT2;
    }
    public void setProviderName_OT2(String providerName_OT2) {
        this.providerName_OT2 = providerName_OT2;
    }
    public String getProviderName_OT3() {
        return providerName_OT3;
    }
    public void setProviderName_OT3(String providerName_OT3) {
        this.providerName_OT3 = providerName_OT3;
    }
    public String getProviderName_OT4() {
        return providerName_OT4;
    }
    public void setProviderName_OT4(String providerName_OT4) {
        this.providerName_OT4 = providerName_OT4;
    }
    public String getProviderName_OT5() {
        return providerName_OT5;
    }
    public void setProviderName_OT5(String providerName_OT5) {
        this.providerName_OT5 = providerName_OT5;
    }
    public String getProviderName_PT1() {
        return providerName_PT1;
    }
    public void setProviderName_PT1(String providerName_PT1) {
        this.providerName_PT1 = providerName_PT1;
    }
    public String getProviderName_PT2() {
        return providerName_PT2;
    }
    public void setProviderName_PT2(String providerName_PT2) {
        this.providerName_PT2 = providerName_PT2;
    }
    public String getProviderName_PT3() {
        return providerName_PT3;
    }
    public void setProviderName_PT3(String providerName_PT3) {
        this.providerName_PT3 = providerName_PT3;
    }
    public String getProviderName_PT4() {
        return providerName_PT4;
    }
    public void setProviderName_PT4(String providerName_PT4) {
        this.providerName_PT4 = providerName_PT4;
    }
    public String getProviderName_PT5() {
        return providerName_PT5;
    }
    public void setProviderName_PT5(String providerName_PT5) {
        this.providerName_PT5 = providerName_PT5;
    }
    public String getProviderName_RA1() {
        return providerName_RA1;
    }
    public void setProviderName_RA1(String providerName_RA1) {
        this.providerName_RA1 = providerName_RA1;
    }
    public String getProviderName_RA2() {
        return providerName_RA2;
    }
    public void setProviderName_RA2(String providerName_RA2) {
        this.providerName_RA2 = providerName_RA2;
    }
    public String getProviderName_RA3() {
        return providerName_RA3;
    }
    public void setProviderName_RA3(String providerName_RA3) {
        this.providerName_RA3 = providerName_RA3;
    }
    public String getProviderName_RA4() {
        return providerName_RA4;
    }
    public void setProviderName_RA4(String providerName_RA4) {
        this.providerName_RA4 = providerName_RA4;
    }
    public String getProviderName_RA5() {
        return providerName_RA5;
    }
    public void setProviderName_RA5(String providerName_RA5) {
        this.providerName_RA5 = providerName_RA5;
    }
    public String getProviderName_RN1() {
        return providerName_RN1;
    }
    public void setProviderName_RN1(String providerName_RN1) {
        this.providerName_RN1 = providerName_RN1;
    }
    public String getProviderName_RN2() {
        return providerName_RN2;
    }
    public void setProviderName_RN2(String providerName_RN2) {
        this.providerName_RN2 = providerName_RN2;
    }
    public String getProviderName_RN3() {
        return providerName_RN3;
    }
    public void setProviderName_RN3(String providerName_RN3) {
        this.providerName_RN3 = providerName_RN3;
    }
    public String getProviderName_RN4() {
        return providerName_RN4;
    }
    public void setProviderName_RN4(String providerName_RN4) {
        this.providerName_RN4 = providerName_RN4;
    }
    public String getProviderName_RN5() {
        return providerName_RN5;
    }
    public void setProviderName_RN5(String providerName_RN5) {
        this.providerName_RN5 = providerName_RN5;
    }
    public String getProviderName_RT1() {
        return providerName_RT1;
    }
    public void setProviderName_RT1(String providerName_RT1) {
        this.providerName_RT1 = providerName_RT1;
    }
    public String getProviderName_RT2() {
        return providerName_RT2;
    }
    public void setProviderName_RT2(String providerName_RT2) {
        this.providerName_RT2 = providerName_RT2;
    }
    public String getProviderName_RT3() {
        return providerName_RT3;
    }
    public void setProviderName_RT3(String providerName_RT3) {
        this.providerName_RT3 = providerName_RT3;
    }
    public String getProviderName_RT4() {
        return providerName_RT4;
    }
    public void setProviderName_RT4(String providerName_RT4) {
        this.providerName_RT4 = providerName_RT4;
    }
    public String getProviderName_RT5() {
        return providerName_RT5;
    }
    public void setProviderName_RT5(String providerName_RT5) {
        this.providerName_RT5 = providerName_RT5;
    }
    public String getProviderName_SL1() {
        return providerName_SL1;
    }
    public void setProviderName_SL1(String providerName_SL1) {
        this.providerName_SL1 = providerName_SL1;
    }
    public String getProviderName_SL2() {
        return providerName_SL2;
    }
    public void setProviderName_SL2(String providerName_SL2) {
        this.providerName_SL2 = providerName_SL2;
    }
    public String getProviderName_SL3() {
        return providerName_SL3;
    }
    public void setProviderName_SL3(String providerName_SL3) {
        this.providerName_SL3 = providerName_SL3;
    }
    public String getProviderName_SL4() {
        return providerName_SL4;
    }
    public void setProviderName_SL4(String providerName_SL4) {
        this.providerName_SL4 = providerName_SL4;
    }
    public String getProviderName_SL5() {
        return providerName_SL5;
    }
    public void setProviderName_SL5(String providerName_SL5) {
        this.providerName_SL5 = providerName_SL5;
    }
    public String getProviderName_SW1() {
        return providerName_SW1;
    }
    public void setProviderName_SW1(String providerName_SW1) {
        this.providerName_SW1 = providerName_SW1;
    }
    public String getProviderName_SW2() {
        return providerName_SW2;
    }
    public void setProviderName_SW2(String providerName_SW2) {
        this.providerName_SW2 = providerName_SW2;
    }
    public String getProviderName_SW3() {
        return providerName_SW3;
    }
    public void setProviderName_SW3(String providerName_SW3) {
        this.providerName_SW3 = providerName_SW3;
    }
    public String getProviderName_SW4() {
        return providerName_SW4;
    }
    public void setProviderName_SW4(String providerName_SW4) {
        this.providerName_SW4 = providerName_SW4;
    }
    public String getProviderName_SW5() {
        return providerName_SW5;
    }
    public void setProviderName_SW5(String providerName_SW5) {
        this.providerName_SW5 = providerName_SW5;
    }
    public String getRn_annual_total1() {
        return rn_annual_total1;
    }
    public void setRn_annual_total1(String rn_annual_total1) {
        this.rn_annual_total1 = rn_annual_total1;
    }
    public String getRn_annual_total2() {
        return rn_annual_total2;
    }
    public void setRn_annual_total2(String rn_annual_total2) {
        this.rn_annual_total2 = rn_annual_total2;
    }
    public String getRn_annual_total3() {
        return rn_annual_total3;
    }
    public void setRn_annual_total3(String rn_annual_total3) {
        this.rn_annual_total3 = rn_annual_total3;
    }
    public String getRn_annual_total4() {
        return rn_annual_total4;
    }
    public void setRn_annual_total4(String rn_annual_total4) {
        this.rn_annual_total4 = rn_annual_total4;
    }
    public String getRn_annual_total5() {
        return rn_annual_total5;
    }
    public void setRn_annual_total5(String rn_annual_total5) {
        this.rn_annual_total5 = rn_annual_total5;
    }
    public String getRn_night_annual1() {
        return rn_night_annual1;
    }
    public void setRn_night_annual1(String rn_night_annual1) {
        this.rn_night_annual1 = rn_night_annual1;
    }
    public String getRn_night_annual2() {
        return rn_night_annual2;
    }
    public void setRn_night_annual2(String rn_night_annual2) {
        this.rn_night_annual2 = rn_night_annual2;
    }
    public String getRn_night_annual3() {
        return rn_night_annual3;
    }
    public void setRn_night_annual3(String rn_night_annual3) {
        this.rn_night_annual3 = rn_night_annual3;
    }
    public String getRn_night_annual4() {
        return rn_night_annual4;
    }
    public void setRn_night_annual4(String rn_night_annual4) {
        this.rn_night_annual4 = rn_night_annual4;
    }
    public String getRn_night_annual5() {
        return rn_night_annual5;
    }
    public void setRn_night_annual5(String rn_night_annual5) {
        this.rn_night_annual5 = rn_night_annual5;
    }
    public String getSummary_inHouse1() {
        return summary_inHouse1;
    }
    public void setSummary_inHouse1(String summary_inHouse1) {
        this.summary_inHouse1 = summary_inHouse1;
    }
    public String getSummary_inHouse2() {
        return summary_inHouse2;
    }
    public void setSummary_inHouse2(String summary_inHouse2) {
        this.summary_inHouse2 = summary_inHouse2;
    }
    public String getSummary_inHouse3() {
        return summary_inHouse3;
    }
    public void setSummary_inHouse3(String summary_inHouse3) {
        this.summary_inHouse3 = summary_inHouse3;
    }
    public String getSummary_inHouse4() {
        return summary_inHouse4;
    }
    public void setSummary_inHouse4(String summary_inHouse4) {
        this.summary_inHouse4 = summary_inHouse4;
    }
    public String getSummary_inHouse5() {
        return summary_inHouse5;
    }
    public void setSummary_inHouse5(String summary_inHouse5) {
        this.summary_inHouse5 = summary_inHouse5;
    }
    public String getHPRD_nursing_fri1() {
        return HPRD_nursing_fri1;
    }
    public void setHPRD_nursing_fri1(String hPRD_nursing_fri1) {
        HPRD_nursing_fri1 = hPRD_nursing_fri1;
    }
    public String getHPRD_nursing_fri2() {
        return HPRD_nursing_fri2;
    }
    public void setHPRD_nursing_fri2(String hPRD_nursing_fri2) {
        HPRD_nursing_fri2 = hPRD_nursing_fri2;
    }
    public String getHPRD_nursing_fri3() {
        return HPRD_nursing_fri3;
    }
    public void setHPRD_nursing_fri3(String hPRD_nursing_fri3) {
        HPRD_nursing_fri3 = hPRD_nursing_fri3;
    }
    public String getHPRD_nursing_fri4() {
        return HPRD_nursing_fri4;
    }
    public void setHPRD_nursing_fri4(String hPRD_nursing_fri4) {
        HPRD_nursing_fri4 = hPRD_nursing_fri4;
    }
    public String getHPRD_nursing_fri5() {
        return HPRD_nursing_fri5;
    }
    public void setHPRD_nursing_fri5(String hPRD_nursing_fri5) {
        HPRD_nursing_fri5 = hPRD_nursing_fri5;
    }
    public String getHPRD_nursing_mon1() {
        return HPRD_nursing_mon1;
    }
    public void setHPRD_nursing_mon1(String hPRD_nursing_mon1) {
        HPRD_nursing_mon1 = hPRD_nursing_mon1;
    }
    public String getHPRD_nursing_mon2() {
        return HPRD_nursing_mon2;
    }
    public void setHPRD_nursing_mon2(String hPRD_nursing_mon2) {
        HPRD_nursing_mon2 = hPRD_nursing_mon2;
    }
    public String getHPRD_nursing_mon3() {
        return HPRD_nursing_mon3;
    }
    public void setHPRD_nursing_mon3(String hPRD_nursing_mon3) {
        HPRD_nursing_mon3 = hPRD_nursing_mon3;
    }
    public String getHPRD_nursing_mon4() {
        return HPRD_nursing_mon4;
    }
    public void setHPRD_nursing_mon4(String hPRD_nursing_mon4) {
        HPRD_nursing_mon4 = hPRD_nursing_mon4;
    }
    public String getHPRD_nursing_mon5() {
        return HPRD_nursing_mon5;
    }
    public void setHPRD_nursing_mon5(String hPRD_nursing_mon5) {
        HPRD_nursing_mon5 = hPRD_nursing_mon5;
    }
    public String getHPRD_nursing_sat1() {
        return HPRD_nursing_sat1;
    }
    public void setHPRD_nursing_sat1(String hPRD_nursing_sat1) {
        HPRD_nursing_sat1 = hPRD_nursing_sat1;
    }
    public String getHPRD_nursing_sat2() {
        return HPRD_nursing_sat2;
    }
    public void setHPRD_nursing_sat2(String hPRD_nursing_sat2) {
        HPRD_nursing_sat2 = hPRD_nursing_sat2;
    }
    public String getHPRD_nursing_sat3() {
        return HPRD_nursing_sat3;
    }
    public void setHPRD_nursing_sat3(String hPRD_nursing_sat3) {
        HPRD_nursing_sat3 = hPRD_nursing_sat3;
    }
    public String getHPRD_nursing_sat4() {
        return HPRD_nursing_sat4;
    }
    public void setHPRD_nursing_sat4(String hPRD_nursing_sat4) {
        HPRD_nursing_sat4 = hPRD_nursing_sat4;
    }
    public String getHPRD_nursing_sat5() {
        return HPRD_nursing_sat5;
    }
    public void setHPRD_nursing_sat5(String hPRD_nursing_sat5) {
        HPRD_nursing_sat5 = hPRD_nursing_sat5;
    }
    public String getHPRD_nursing_sun1() {
        return HPRD_nursing_sun1;
    }
    public void setHPRD_nursing_sun1(String hPRD_nursing_sun1) {
        HPRD_nursing_sun1 = hPRD_nursing_sun1;
    }
    public String getHPRD_nursing_sun2() {
        return HPRD_nursing_sun2;
    }
    public void setHPRD_nursing_sun2(String hPRD_nursing_sun2) {
        HPRD_nursing_sun2 = hPRD_nursing_sun2;
    }
    public String getHPRD_nursing_sun3() {
        return HPRD_nursing_sun3;
    }
    public void setHPRD_nursing_sun3(String hPRD_nursing_sun3) {
        HPRD_nursing_sun3 = hPRD_nursing_sun3;
    }
    public String getHPRD_nursing_sun4() {
        return HPRD_nursing_sun4;
    }
    public void setHPRD_nursing_sun4(String hPRD_nursing_sun4) {
        HPRD_nursing_sun4 = hPRD_nursing_sun4;
    }
    public String getHPRD_nursing_sun5() {
        return HPRD_nursing_sun5;
    }
    public void setHPRD_nursing_sun5(String hPRD_nursing_sun5) {
        HPRD_nursing_sun5 = hPRD_nursing_sun5;
    }
    public String getHPRD_nursing_thu1() {
        return HPRD_nursing_thu1;
    }
    public void setHPRD_nursing_thu1(String hPRD_nursing_thu1) {
        HPRD_nursing_thu1 = hPRD_nursing_thu1;
    }
    public String getHPRD_nursing_thu2() {
        return HPRD_nursing_thu2;
    }
    public void setHPRD_nursing_thu2(String hPRD_nursing_thu2) {
        HPRD_nursing_thu2 = hPRD_nursing_thu2;
    }
    public String getHPRD_nursing_thu3() {
        return HPRD_nursing_thu3;
    }
    public void setHPRD_nursing_thu3(String hPRD_nursing_thu3) {
        HPRD_nursing_thu3 = hPRD_nursing_thu3;
    }
    public String getHPRD_nursing_thu4() {
        return HPRD_nursing_thu4;
    }
    public void setHPRD_nursing_thu4(String hPRD_nursing_thu4) {
        HPRD_nursing_thu4 = hPRD_nursing_thu4;
    }
    public String getHPRD_nursing_thu5() {
        return HPRD_nursing_thu5;
    }
    public void setHPRD_nursing_thu5(String hPRD_nursing_thu5) {
        HPRD_nursing_thu5 = hPRD_nursing_thu5;
    }
    public String getHPRD_nursing_tue1() {
        return HPRD_nursing_tue1;
    }
    public void setHPRD_nursing_tue1(String hPRD_nursing_tue1) {
        HPRD_nursing_tue1 = hPRD_nursing_tue1;
    }
    public String getHPRD_nursing_tue2() {
        return HPRD_nursing_tue2;
    }
    public void setHPRD_nursing_tue2(String hPRD_nursing_tue2) {
        HPRD_nursing_tue2 = hPRD_nursing_tue2;
    }
    public String getHPRD_nursing_tue3() {
        return HPRD_nursing_tue3;
    }
    public void setHPRD_nursing_tue3(String hPRD_nursing_tue3) {
        HPRD_nursing_tue3 = hPRD_nursing_tue3;
    }
    public String getHPRD_nursing_tue4() {
        return HPRD_nursing_tue4;
    }
    public void setHPRD_nursing_tue4(String hPRD_nursing_tue4) {
        HPRD_nursing_tue4 = hPRD_nursing_tue4;
    }
    public String getHPRD_nursing_tue5() {
        return HPRD_nursing_tue5;
    }
    public void setHPRD_nursing_tue5(String hPRD_nursing_tue5) {
        HPRD_nursing_tue5 = hPRD_nursing_tue5;
    }
    public String getHPRD_nursing_wed1() {
        return HPRD_nursing_wed1;
    }
    public void setHPRD_nursing_wed1(String hPRD_nursing_wed1) {
        HPRD_nursing_wed1 = hPRD_nursing_wed1;
    }
    public String getHPRD_nursing_wed2() {
        return HPRD_nursing_wed2;
    }
    public void setHPRD_nursing_wed2(String hPRD_nursing_wed2) {
        HPRD_nursing_wed2 = hPRD_nursing_wed2;
    }
    public String getHPRD_nursing_wed3() {
        return HPRD_nursing_wed3;
    }
    public void setHPRD_nursing_wed3(String hPRD_nursing_wed3) {
        HPRD_nursing_wed3 = hPRD_nursing_wed3;
    }
    public String getHPRD_nursing_wed4() {
        return HPRD_nursing_wed4;
    }
    public void setHPRD_nursing_wed4(String hPRD_nursing_wed4) {
        HPRD_nursing_wed4 = hPRD_nursing_wed4;
    }
    public String getHPRD_nursing_wed5() {
        return HPRD_nursing_wed5;
    }
    public void setHPRD_nursing_wed5(String hPRD_nursing_wed5) {
        HPRD_nursing_wed5 = hPRD_nursing_wed5;
    }
    public String getAld_annual_total1() {
        return ald_annual_total1;
    }
    public void setAld_annual_total1(String ald_annual_total1) {
        this.ald_annual_total1 = ald_annual_total1;
    }
    public String getAld_annual_total2() {
        return ald_annual_total2;
    }
    public void setAld_annual_total2(String ald_annual_total2) {
        this.ald_annual_total2 = ald_annual_total2;
    }
    public String getAld_annual_total3() {
        return ald_annual_total3;
    }
    public void setAld_annual_total3(String ald_annual_total3) {
        this.ald_annual_total3 = ald_annual_total3;
    }
    public String getAld_annual_total4() {
        return ald_annual_total4;
    }
    public void setAld_annual_total4(String ald_annual_total4) {
        this.ald_annual_total4 = ald_annual_total4;
    }
    public String getAld_annual_total5() {
        return ald_annual_total5;
    }
    public void setAld_annual_total5(String ald_annual_total5) {
        this.ald_annual_total5 = ald_annual_total5;
    }
    public String getAldnop_at_annual1() {
        return aldnop_at_annual1;
    }
    public void setAldnop_at_annual1(String aldnop_at_annual1) {
        this.aldnop_at_annual1 = aldnop_at_annual1;
    }
    public String getAldnop_at_annual2() {
        return aldnop_at_annual2;
    }
    public void setAldnop_at_annual2(String aldnop_at_annual2) {
        this.aldnop_at_annual2 = aldnop_at_annual2;
    }
    public String getAldnop_at_annual3() {
        return aldnop_at_annual3;
    }
    public void setAldnop_at_annual3(String aldnop_at_annual3) {
        this.aldnop_at_annual3 = aldnop_at_annual3;
    }
    public String getAldnop_at_annual4() {
        return aldnop_at_annual4;
    }
    public void setAldnop_at_annual4(String aldnop_at_annual4) {
        this.aldnop_at_annual4 = aldnop_at_annual4;
    }
    public String getAldnop_at_annual5() {
        return aldnop_at_annual5;
    }
    public void setAldnop_at_annual5(String aldnop_at_annual5) {
        this.aldnop_at_annual5 = aldnop_at_annual5;
    }
    public String getAldnop_aw_annual1() {
        return aldnop_aw_annual1;
    }
    public void setAldnop_aw_annual1(String aldnop_aw_annual1) {
        this.aldnop_aw_annual1 = aldnop_aw_annual1;
    }
    public String getAldnop_aw_annual2() {
        return aldnop_aw_annual2;
    }
    public void setAldnop_aw_annual2(String aldnop_aw_annual2) {
        this.aldnop_aw_annual2 = aldnop_aw_annual2;
    }
    public String getAldnop_aw_annual3() {
        return aldnop_aw_annual3;
    }
    public void setAldnop_aw_annual3(String aldnop_aw_annual3) {
        this.aldnop_aw_annual3 = aldnop_aw_annual3;
    }
    public String getAldnop_aw_annual4() {
        return aldnop_aw_annual4;
    }
    public void setAldnop_aw_annual4(String aldnop_aw_annual4) {
        this.aldnop_aw_annual4 = aldnop_aw_annual4;
    }
    public String getAldnop_aw_annual5() {
        return aldnop_aw_annual5;
    }
    public void setAldnop_aw_annual5(String aldnop_aw_annual5) {
        this.aldnop_aw_annual5 = aldnop_aw_annual5;
    }
    public String getAldnop_fri_total1() {
        return aldnop_fri_total1;
    }
    public void setAldnop_fri_total1(String aldnop_fri_total1) {
        this.aldnop_fri_total1 = aldnop_fri_total1;
    }
    public String getAldnop_fri_total2() {
        return aldnop_fri_total2;
    }
    public void setAldnop_fri_total2(String aldnop_fri_total2) {
        this.aldnop_fri_total2 = aldnop_fri_total2;
    }
    public String getAldnop_fri_total3() {
        return aldnop_fri_total3;
    }
    public void setAldnop_fri_total3(String aldnop_fri_total3) {
        this.aldnop_fri_total3 = aldnop_fri_total3;
    }
    public String getAldnop_fri_total4() {
        return aldnop_fri_total4;
    }
    public void setAldnop_fri_total4(String aldnop_fri_total4) {
        this.aldnop_fri_total4 = aldnop_fri_total4;
    }
    public String getAldnop_fri_total5() {
        return aldnop_fri_total5;
    }
    public void setAldnop_fri_total5(String aldnop_fri_total5) {
        this.aldnop_fri_total5 = aldnop_fri_total5;
    }
    public String getAldnop_mon_total1() {
        return aldnop_mon_total1;
    }
    public void setAldnop_mon_total1(String aldnop_mon_total1) {
        this.aldnop_mon_total1 = aldnop_mon_total1;
    }
    public String getAldnop_mon_total2() {
        return aldnop_mon_total2;
    }
    public void setAldnop_mon_total2(String aldnop_mon_total2) {
        this.aldnop_mon_total2 = aldnop_mon_total2;
    }
    public String getAldnop_mon_total3() {
        return aldnop_mon_total3;
    }
    public void setAldnop_mon_total3(String aldnop_mon_total3) {
        this.aldnop_mon_total3 = aldnop_mon_total3;
    }
    public String getAldnop_mon_total4() {
        return aldnop_mon_total4;
    }
    public void setAldnop_mon_total4(String aldnop_mon_total4) {
        this.aldnop_mon_total4 = aldnop_mon_total4;
    }
    public String getAldnop_mon_total5() {
        return aldnop_mon_total5;
    }
    public void setAldnop_mon_total5(String aldnop_mon_total5) {
        this.aldnop_mon_total5 = aldnop_mon_total5;
    }
    public String getAldnop_mt_annual1() {
        return aldnop_mt_annual1;
    }
    public void setAldnop_mt_annual1(String aldnop_mt_annual1) {
        this.aldnop_mt_annual1 = aldnop_mt_annual1;
    }
    public String getAldnop_mt_annual2() {
        return aldnop_mt_annual2;
    }
    public void setAldnop_mt_annual2(String aldnop_mt_annual2) {
        this.aldnop_mt_annual2 = aldnop_mt_annual2;
    }
    public String getAldnop_mt_annual3() {
        return aldnop_mt_annual3;
    }
    public void setAldnop_mt_annual3(String aldnop_mt_annual3) {
        this.aldnop_mt_annual3 = aldnop_mt_annual3;
    }
    public String getAldnop_mt_annual4() {
        return aldnop_mt_annual4;
    }
    public void setAldnop_mt_annual4(String aldnop_mt_annual4) {
        this.aldnop_mt_annual4 = aldnop_mt_annual4;
    }
    public String getAldnop_mt_annual5() {
        return aldnop_mt_annual5;
    }
    public void setAldnop_mt_annual5(String aldnop_mt_annual5) {
        this.aldnop_mt_annual5 = aldnop_mt_annual5;
    }
    public String getAldnop_ra_annual1() {
        return aldnop_ra_annual1;
    }
    public void setAldnop_ra_annual1(String aldnop_ra_annual1) {
        this.aldnop_ra_annual1 = aldnop_ra_annual1;
    }
    public String getAldnop_ra_annual2() {
        return aldnop_ra_annual2;
    }
    public void setAldnop_ra_annual2(String aldnop_ra_annual2) {
        this.aldnop_ra_annual2 = aldnop_ra_annual2;
    }
    public String getAldnop_ra_annual3() {
        return aldnop_ra_annual3;
    }
    public void setAldnop_ra_annual3(String aldnop_ra_annual3) {
        this.aldnop_ra_annual3 = aldnop_ra_annual3;
    }
    public String getAldnop_ra_annual4() {
        return aldnop_ra_annual4;
    }
    public void setAldnop_ra_annual4(String aldnop_ra_annual4) {
        this.aldnop_ra_annual4 = aldnop_ra_annual4;
    }
    public String getAldnop_ra_annual5() {
        return aldnop_ra_annual5;
    }
    public void setAldnop_ra_annual5(String aldnop_ra_annual5) {
        this.aldnop_ra_annual5 = aldnop_ra_annual5;
    }
    public String getAldnop_rt_annual1() {
        return aldnop_rt_annual1;
    }
    public void setAldnop_rt_annual1(String aldnop_rt_annual1) {
        this.aldnop_rt_annual1 = aldnop_rt_annual1;
    }
    public String getAldnop_rt_annual2() {
        return aldnop_rt_annual2;
    }
    public void setAldnop_rt_annual2(String aldnop_rt_annual2) {
        this.aldnop_rt_annual2 = aldnop_rt_annual2;
    }
    public String getAldnop_rt_annual3() {
        return aldnop_rt_annual3;
    }
    public void setAldnop_rt_annual3(String aldnop_rt_annual3) {
        this.aldnop_rt_annual3 = aldnop_rt_annual3;
    }
    public String getAldnop_rt_annual4() {
        return aldnop_rt_annual4;
    }
    public void setAldnop_rt_annual4(String aldnop_rt_annual4) {
        this.aldnop_rt_annual4 = aldnop_rt_annual4;
    }
    public String getAldnop_rt_annual5() {
        return aldnop_rt_annual5;
    }
    public void setAldnop_rt_annual5(String aldnop_rt_annual5) {
        this.aldnop_rt_annual5 = aldnop_rt_annual5;
    }
    public String getAldnop_sat_total1() {
        return aldnop_sat_total1;
    }
    public void setAldnop_sat_total1(String aldnop_sat_total1) {
        this.aldnop_sat_total1 = aldnop_sat_total1;
    }
    public String getAldnop_sat_total2() {
        return aldnop_sat_total2;
    }
    public void setAldnop_sat_total2(String aldnop_sat_total2) {
        this.aldnop_sat_total2 = aldnop_sat_total2;
    }
    public String getAldnop_sat_total3() {
        return aldnop_sat_total3;
    }
    public void setAldnop_sat_total3(String aldnop_sat_total3) {
        this.aldnop_sat_total3 = aldnop_sat_total3;
    }
    public String getAldnop_sat_total4() {
        return aldnop_sat_total4;
    }
    public void setAldnop_sat_total4(String aldnop_sat_total4) {
        this.aldnop_sat_total4 = aldnop_sat_total4;
    }
    public String getAldnop_sat_total5() {
        return aldnop_sat_total5;
    }
    public void setAldnop_sat_total5(String aldnop_sat_total5) {
        this.aldnop_sat_total5 = aldnop_sat_total5;
    }
    public String getAldnop_sun_total1() {
        return aldnop_sun_total1;
    }
    public void setAldnop_sun_total1(String aldnop_sun_total1) {
        this.aldnop_sun_total1 = aldnop_sun_total1;
    }
    public String getAldnop_sun_total2() {
        return aldnop_sun_total2;
    }
    public void setAldnop_sun_total2(String aldnop_sun_total2) {
        this.aldnop_sun_total2 = aldnop_sun_total2;
    }
    public String getAldnop_sun_total3() {
        return aldnop_sun_total3;
    }
    public void setAldnop_sun_total3(String aldnop_sun_total3) {
        this.aldnop_sun_total3 = aldnop_sun_total3;
    }
    public String getAldnop_sun_total4() {
        return aldnop_sun_total4;
    }
    public void setAldnop_sun_total4(String aldnop_sun_total4) {
        this.aldnop_sun_total4 = aldnop_sun_total4;
    }
    public String getAldnop_sun_total5() {
        return aldnop_sun_total5;
    }
    public void setAldnop_sun_total5(String aldnop_sun_total5) {
        this.aldnop_sun_total5 = aldnop_sun_total5;
    }
    public String getAldnop_thu_total1() {
        return aldnop_thu_total1;
    }
    public void setAldnop_thu_total1(String aldnop_thu_total1) {
        this.aldnop_thu_total1 = aldnop_thu_total1;
    }
    public String getAldnop_thu_total2() {
        return aldnop_thu_total2;
    }
    public void setAldnop_thu_total2(String aldnop_thu_total2) {
        this.aldnop_thu_total2 = aldnop_thu_total2;
    }
    public String getAldnop_thu_total3() {
        return aldnop_thu_total3;
    }
    public void setAldnop_thu_total3(String aldnop_thu_total3) {
        this.aldnop_thu_total3 = aldnop_thu_total3;
    }
    public String getAldnop_thu_total4() {
        return aldnop_thu_total4;
    }
    public void setAldnop_thu_total4(String aldnop_thu_total4) {
        this.aldnop_thu_total4 = aldnop_thu_total4;
    }
    public String getAldnop_thu_total5() {
        return aldnop_thu_total5;
    }
    public void setAldnop_thu_total5(String aldnop_thu_total5) {
        this.aldnop_thu_total5 = aldnop_thu_total5;
    }
    public String getAldnop_tue_total1() {
        return aldnop_tue_total1;
    }
    public void setAldnop_tue_total1(String aldnop_tue_total1) {
        this.aldnop_tue_total1 = aldnop_tue_total1;
    }
    public String getAldnop_tue_total2() {
        return aldnop_tue_total2;
    }
    public void setAldnop_tue_total2(String aldnop_tue_total2) {
        this.aldnop_tue_total2 = aldnop_tue_total2;
    }
    public String getAldnop_tue_total3() {
        return aldnop_tue_total3;
    }
    public void setAldnop_tue_total3(String aldnop_tue_total3) {
        this.aldnop_tue_total3 = aldnop_tue_total3;
    }
    public String getAldnop_tue_total4() {
        return aldnop_tue_total4;
    }
    public void setAldnop_tue_total4(String aldnop_tue_total4) {
        this.aldnop_tue_total4 = aldnop_tue_total4;
    }
    public String getAldnop_tue_total5() {
        return aldnop_tue_total5;
    }
    public void setAldnop_tue_total5(String aldnop_tue_total5) {
        this.aldnop_tue_total5 = aldnop_tue_total5;
    }
    public String getAldnop_wed_total1() {
        return aldnop_wed_total1;
    }
    public void setAldnop_wed_total1(String aldnop_wed_total1) {
        this.aldnop_wed_total1 = aldnop_wed_total1;
    }
    public String getAldnop_wed_total2() {
        return aldnop_wed_total2;
    }
    public void setAldnop_wed_total2(String aldnop_wed_total2) {
        this.aldnop_wed_total2 = aldnop_wed_total2;
    }
    public String getAldnop_wed_total3() {
        return aldnop_wed_total3;
    }
    public void setAldnop_wed_total3(String aldnop_wed_total3) {
        this.aldnop_wed_total3 = aldnop_wed_total3;
    }
    public String getAldnop_wed_total4() {
        return aldnop_wed_total4;
    }
    public void setAldnop_wed_total4(String aldnop_wed_total4) {
        this.aldnop_wed_total4 = aldnop_wed_total4;
    }
    public String getAldnop_wed_total5() {
        return aldnop_wed_total5;
    }
    public void setAldnop_wed_total5(String aldnop_wed_total5) {
        this.aldnop_wed_total5 = aldnop_wed_total5;
    }
    public String getAlliedProf_label1() {
        return alliedProf_label1;
    }
    public void setAlliedProf_label1(String alliedProf_label1) {
        this.alliedProf_label1 = alliedProf_label1;
    }
    public String getAlliedProf_label2() {
        return alliedProf_label2;
    }
    public void setAlliedProf_label2(String alliedProf_label2) {
        this.alliedProf_label2 = alliedProf_label2;
    }
    public String getAlliedProf_label3() {
        return alliedProf_label3;
    }
    public void setAlliedProf_label3(String alliedProf_label3) {
        this.alliedProf_label3 = alliedProf_label3;
    }
    public String getAlliedProf_label4() {
        return alliedProf_label4;
    }
    public void setAlliedProf_label4(String alliedProf_label4) {
        this.alliedProf_label4 = alliedProf_label4;
    }
    public String getAlliedProf_label5() {
        return alliedProf_label5;
    }
    public void setAlliedProf_label5(String alliedProf_label5) {
        this.alliedProf_label5 = alliedProf_label5;
    }
    public String getAllied_fri_total1() {
        return allied_fri_total1;
    }
    public void setAllied_fri_total1(String allied_fri_total1) {
        this.allied_fri_total1 = allied_fri_total1;
    }
    public String getAllied_fri_total2() {
        return allied_fri_total2;
    }
    public void setAllied_fri_total2(String allied_fri_total2) {
        this.allied_fri_total2 = allied_fri_total2;
    }
    public String getAllied_fri_total3() {
        return allied_fri_total3;
    }
    public void setAllied_fri_total3(String allied_fri_total3) {
        this.allied_fri_total3 = allied_fri_total3;
    }
    public String getAllied_fri_total4() {
        return allied_fri_total4;
    }
    public void setAllied_fri_total4(String allied_fri_total4) {
        this.allied_fri_total4 = allied_fri_total4;
    }
    public String getAllied_fri_total5() {
        return allied_fri_total5;
    }
    public void setAllied_fri_total5(String allied_fri_total5) {
        this.allied_fri_total5 = allied_fri_total5;
    }
    public String getAllied_mon_total1() {
        return allied_mon_total1;
    }
    public void setAllied_mon_total1(String allied_mon_total1) {
        this.allied_mon_total1 = allied_mon_total1;
    }
    public String getAllied_mon_total2() {
        return allied_mon_total2;
    }
    public void setAllied_mon_total2(String allied_mon_total2) {
        this.allied_mon_total2 = allied_mon_total2;
    }
    public String getAllied_mon_total3() {
        return allied_mon_total3;
    }
    public void setAllied_mon_total3(String allied_mon_total3) {
        this.allied_mon_total3 = allied_mon_total3;
    }
    public String getAllied_mon_total4() {
        return allied_mon_total4;
    }
    public void setAllied_mon_total4(String allied_mon_total4) {
        this.allied_mon_total4 = allied_mon_total4;
    }
    public String getAllied_mon_total5() {
        return allied_mon_total5;
    }
    public void setAllied_mon_total5(String allied_mon_total5) {
        this.allied_mon_total5 = allied_mon_total5;
    }
    public String getAllied_sat_total1() {
        return allied_sat_total1;
    }
    public void setAllied_sat_total1(String allied_sat_total1) {
        this.allied_sat_total1 = allied_sat_total1;
    }
    public String getAllied_sat_total2() {
        return allied_sat_total2;
    }
    public void setAllied_sat_total2(String allied_sat_total2) {
        this.allied_sat_total2 = allied_sat_total2;
    }
    public String getAllied_sat_total3() {
        return allied_sat_total3;
    }
    public void setAllied_sat_total3(String allied_sat_total3) {
        this.allied_sat_total3 = allied_sat_total3;
    }
    public String getAllied_sat_total4() {
        return allied_sat_total4;
    }
    public void setAllied_sat_total4(String allied_sat_total4) {
        this.allied_sat_total4 = allied_sat_total4;
    }
    public String getAllied_sat_total5() {
        return allied_sat_total5;
    }
    public void setAllied_sat_total5(String allied_sat_total5) {
        this.allied_sat_total5 = allied_sat_total5;
    }
    public String getAllied_sun_total1() {
        return allied_sun_total1;
    }
    public void setAllied_sun_total1(String allied_sun_total1) {
        this.allied_sun_total1 = allied_sun_total1;
    }
    public String getAllied_sun_total2() {
        return allied_sun_total2;
    }
    public void setAllied_sun_total2(String allied_sun_total2) {
        this.allied_sun_total2 = allied_sun_total2;
    }
    public String getAllied_sun_total3() {
        return allied_sun_total3;
    }
    public void setAllied_sun_total3(String allied_sun_total3) {
        this.allied_sun_total3 = allied_sun_total3;
    }
    public String getAllied_sun_total4() {
        return allied_sun_total4;
    }
    public void setAllied_sun_total4(String allied_sun_total4) {
        this.allied_sun_total4 = allied_sun_total4;
    }
    public String getAllied_sun_total5() {
        return allied_sun_total5;
    }
    public void setAllied_sun_total5(String allied_sun_total5) {
        this.allied_sun_total5 = allied_sun_total5;
    }
    public String getAllied_thu_total1() {
        return allied_thu_total1;
    }
    public void setAllied_thu_total1(String allied_thu_total1) {
        this.allied_thu_total1 = allied_thu_total1;
    }
    public String getAllied_thu_total2() {
        return allied_thu_total2;
    }
    public void setAllied_thu_total2(String allied_thu_total2) {
        this.allied_thu_total2 = allied_thu_total2;
    }
    public String getAllied_thu_total3() {
        return allied_thu_total3;
    }
    public void setAllied_thu_total3(String allied_thu_total3) {
        this.allied_thu_total3 = allied_thu_total3;
    }
    public String getAllied_thu_total4() {
        return allied_thu_total4;
    }
    public void setAllied_thu_total4(String allied_thu_total4) {
        this.allied_thu_total4 = allied_thu_total4;
    }
    public String getAllied_thu_total5() {
        return allied_thu_total5;
    }
    public void setAllied_thu_total5(String allied_thu_total5) {
        this.allied_thu_total5 = allied_thu_total5;
    }
    public String getAllied_tue_total1() {
        return allied_tue_total1;
    }
    public void setAllied_tue_total1(String allied_tue_total1) {
        this.allied_tue_total1 = allied_tue_total1;
    }
    public String getAllied_tue_total2() {
        return allied_tue_total2;
    }
    public void setAllied_tue_total2(String allied_tue_total2) {
        this.allied_tue_total2 = allied_tue_total2;
    }
    public String getAllied_tue_total3() {
        return allied_tue_total3;
    }
    public void setAllied_tue_total3(String allied_tue_total3) {
        this.allied_tue_total3 = allied_tue_total3;
    }
    public String getAllied_tue_total4() {
        return allied_tue_total4;
    }
    public void setAllied_tue_total4(String allied_tue_total4) {
        this.allied_tue_total4 = allied_tue_total4;
    }
    public String getAllied_tue_total5() {
        return allied_tue_total5;
    }
    public void setAllied_tue_total5(String allied_tue_total5) {
        this.allied_tue_total5 = allied_tue_total5;
    }
    public String getAllied_wed_total1() {
        return allied_wed_total1;
    }
    public void setAllied_wed_total1(String allied_wed_total1) {
        this.allied_wed_total1 = allied_wed_total1;
    }
    public String getAllied_wed_total2() {
        return allied_wed_total2;
    }
    public void setAllied_wed_total2(String allied_wed_total2) {
        this.allied_wed_total2 = allied_wed_total2;
    }
    public String getAllied_wed_total3() {
        return allied_wed_total3;
    }
    public void setAllied_wed_total3(String allied_wed_total3) {
        this.allied_wed_total3 = allied_wed_total3;
    }
    public String getAllied_wed_total4() {
        return allied_wed_total4;
    }
    public void setAllied_wed_total4(String allied_wed_total4) {
        this.allied_wed_total4 = allied_wed_total4;
    }
    public String getAllied_wed_total5() {
        return allied_wed_total5;
    }
    public void setAllied_wed_total5(String allied_wed_total5) {
        this.allied_wed_total5 = allied_wed_total5;
    }
    public String getContractedOut_AT1() {
        return contractedOut_AT1;
    }
    public void setContractedOut_AT1(String contractedOut_AT1) {
        this.contractedOut_AT1 = contractedOut_AT1;
    }
    public String getContractedOut_AT2() {
        return contractedOut_AT2;
    }
    public void setContractedOut_AT2(String contractedOut_AT2) {
        this.contractedOut_AT2 = contractedOut_AT2;
    }
    public String getContractedOut_AT3() {
        return contractedOut_AT3;
    }
    public void setContractedOut_AT3(String contractedOut_AT3) {
        this.contractedOut_AT3 = contractedOut_AT3;
    }
    public String getContractedOut_AT4() {
        return contractedOut_AT4;
    }
    public void setContractedOut_AT4(String contractedOut_AT4) {
        this.contractedOut_AT4 = contractedOut_AT4;
    }
    public String getContractedOut_AT5() {
        return contractedOut_AT5;
    }
    public void setContractedOut_AT5(String contractedOut_AT5) {
        this.contractedOut_AT5 = contractedOut_AT5;
    }
    public String getContractedOut_AW1() {
        return contractedOut_AW1;
    }
    public void setContractedOut_AW1(String contractedOut_AW1) {
        this.contractedOut_AW1 = contractedOut_AW1;
    }
    public String getContractedOut_AW2() {
        return contractedOut_AW2;
    }
    public void setContractedOut_AW2(String contractedOut_AW2) {
        this.contractedOut_AW2 = contractedOut_AW2;
    }
    public String getContractedOut_AW3() {
        return contractedOut_AW3;
    }
    public void setContractedOut_AW3(String contractedOut_AW3) {
        this.contractedOut_AW3 = contractedOut_AW3;
    }
    public String getContractedOut_AW4() {
        return contractedOut_AW4;
    }
    public void setContractedOut_AW4(String contractedOut_AW4) {
        this.contractedOut_AW4 = contractedOut_AW4;
    }
    public String getContractedOut_AW5() {
        return contractedOut_AW5;
    }
    public void setContractedOut_AW5(String contractedOut_AW5) {
        this.contractedOut_AW5 = contractedOut_AW5;
    }
    public String getContractedOut_DT1() {
        return contractedOut_DT1;
    }
    public void setContractedOut_DT1(String contractedOut_DT1) {
        this.contractedOut_DT1 = contractedOut_DT1;
    }
    public String getContractedOut_DT2() {
        return contractedOut_DT2;
    }
    public void setContractedOut_DT2(String contractedOut_DT2) {
        this.contractedOut_DT2 = contractedOut_DT2;
    }
    public String getContractedOut_DT3() {
        return contractedOut_DT3;
    }
    public void setContractedOut_DT3(String contractedOut_DT3) {
        this.contractedOut_DT3 = contractedOut_DT3;
    }
    public String getContractedOut_DT4() {
        return contractedOut_DT4;
    }
    public void setContractedOut_DT4(String contractedOut_DT4) {
        this.contractedOut_DT4 = contractedOut_DT4;
    }
    public String getContractedOut_DT5() {
        return contractedOut_DT5;
    }
    public void setContractedOut_DT5(String contractedOut_DT5) {
        this.contractedOut_DT5 = contractedOut_DT5;
    }
    public String getContractedOut_MT1() {
        return contractedOut_MT1;
    }
    public void setContractedOut_MT1(String contractedOut_MT1) {
        this.contractedOut_MT1 = contractedOut_MT1;
    }
    public String getContractedOut_MT2() {
        return contractedOut_MT2;
    }
    public void setContractedOut_MT2(String contractedOut_MT2) {
        this.contractedOut_MT2 = contractedOut_MT2;
    }
    public String getContractedOut_MT3() {
        return contractedOut_MT3;
    }
    public void setContractedOut_MT3(String contractedOut_MT3) {
        this.contractedOut_MT3 = contractedOut_MT3;
    }
    public String getContractedOut_MT4() {
        return contractedOut_MT4;
    }
    public void setContractedOut_MT4(String contractedOut_MT4) {
        this.contractedOut_MT4 = contractedOut_MT4;
    }
    public String getContractedOut_MT5() {
        return contractedOut_MT5;
    }
    public void setContractedOut_MT5(String contractedOut_MT5) {
        this.contractedOut_MT5 = contractedOut_MT5;
    }
    public String getContractedOut_OT1() {
        return contractedOut_OT1;
    }
    public void setContractedOut_OT1(String contractedOut_OT1) {
        this.contractedOut_OT1 = contractedOut_OT1;
    }
    public String getContractedOut_OT2() {
        return contractedOut_OT2;
    }
    public void setContractedOut_OT2(String contractedOut_OT2) {
        this.contractedOut_OT2 = contractedOut_OT2;
    }
    public String getContractedOut_OT3() {
        return contractedOut_OT3;
    }
    public void setContractedOut_OT3(String contractedOut_OT3) {
        this.contractedOut_OT3 = contractedOut_OT3;
    }
    public String getContractedOut_OT4() {
        return contractedOut_OT4;
    }
    public void setContractedOut_OT4(String contractedOut_OT4) {
        this.contractedOut_OT4 = contractedOut_OT4;
    }
    public String getContractedOut_OT5() {
        return contractedOut_OT5;
    }
    public void setContractedOut_OT5(String contractedOut_OT5) {
        this.contractedOut_OT5 = contractedOut_OT5;
    }
    public String getContractedOut_PT1() {
        return contractedOut_PT1;
    }
    public void setContractedOut_PT1(String contractedOut_PT1) {
        this.contractedOut_PT1 = contractedOut_PT1;
    }
    public String getContractedOut_PT2() {
        return contractedOut_PT2;
    }
    public void setContractedOut_PT2(String contractedOut_PT2) {
        this.contractedOut_PT2 = contractedOut_PT2;
    }
    public String getContractedOut_PT3() {
        return contractedOut_PT3;
    }
    public void setContractedOut_PT3(String contractedOut_PT3) {
        this.contractedOut_PT3 = contractedOut_PT3;
    }
    public String getContractedOut_PT4() {
        return contractedOut_PT4;
    }
    public void setContractedOut_PT4(String contractedOut_PT4) {
        this.contractedOut_PT4 = contractedOut_PT4;
    }
    public String getContractedOut_PT5() {
        return contractedOut_PT5;
    }
    public void setContractedOut_PT5(String contractedOut_PT5) {
        this.contractedOut_PT5 = contractedOut_PT5;
    }
    public String getContractedOut_RA1() {
        return contractedOut_RA1;
    }
    public void setContractedOut_RA1(String contractedOut_RA1) {
        this.contractedOut_RA1 = contractedOut_RA1;
    }
    public String getContractedOut_RA2() {
        return contractedOut_RA2;
    }
    public void setContractedOut_RA2(String contractedOut_RA2) {
        this.contractedOut_RA2 = contractedOut_RA2;
    }
    public String getContractedOut_RA3() {
        return contractedOut_RA3;
    }
    public void setContractedOut_RA3(String contractedOut_RA3) {
        this.contractedOut_RA3 = contractedOut_RA3;
    }
    public String getContractedOut_RA4() {
        return contractedOut_RA4;
    }
    public void setContractedOut_RA4(String contractedOut_RA4) {
        this.contractedOut_RA4 = contractedOut_RA4;
    }
    public String getContractedOut_RA5() {
        return contractedOut_RA5;
    }
    public void setContractedOut_RA5(String contractedOut_RA5) {
        this.contractedOut_RA5 = contractedOut_RA5;
    }
    public String getContractedOut_RN1() {
        return contractedOut_RN1;
    }
    public void setContractedOut_RN1(String contractedOut_RN1) {
        this.contractedOut_RN1 = contractedOut_RN1;
    }
    public String getContractedOut_RN2() {
        return contractedOut_RN2;
    }
    public void setContractedOut_RN2(String contractedOut_RN2) {
        this.contractedOut_RN2 = contractedOut_RN2;
    }
    public String getContractedOut_RN3() {
        return contractedOut_RN3;
    }
    public void setContractedOut_RN3(String contractedOut_RN3) {
        this.contractedOut_RN3 = contractedOut_RN3;
    }
    public String getContractedOut_RN4() {
        return contractedOut_RN4;
    }
    public void setContractedOut_RN4(String contractedOut_RN4) {
        this.contractedOut_RN4 = contractedOut_RN4;
    }
    public String getContractedOut_RN5() {
        return contractedOut_RN5;
    }
    public void setContractedOut_RN5(String contractedOut_RN5) {
        this.contractedOut_RN5 = contractedOut_RN5;
    }
    public String getContractedOut_RT1() {
        return contractedOut_RT1;
    }
    public void setContractedOut_RT1(String contractedOut_RT1) {
        this.contractedOut_RT1 = contractedOut_RT1;
    }
    public String getContractedOut_RT2() {
        return contractedOut_RT2;
    }
    public void setContractedOut_RT2(String contractedOut_RT2) {
        this.contractedOut_RT2 = contractedOut_RT2;
    }
    public String getContractedOut_RT3() {
        return contractedOut_RT3;
    }
    public void setContractedOut_RT3(String contractedOut_RT3) {
        this.contractedOut_RT3 = contractedOut_RT3;
    }
    public String getContractedOut_RT4() {
        return contractedOut_RT4;
    }
    public void setContractedOut_RT4(String contractedOut_RT4) {
        this.contractedOut_RT4 = contractedOut_RT4;
    }
    public String getContractedOut_RT5() {
        return contractedOut_RT5;
    }
    public void setContractedOut_RT5(String contractedOut_RT5) {
        this.contractedOut_RT5 = contractedOut_RT5;
    }
    public String getContractedOut_SL1() {
        return contractedOut_SL1;
    }
    public void setContractedOut_SL1(String contractedOut_SL1) {
        this.contractedOut_SL1 = contractedOut_SL1;
    }
    public String getContractedOut_SL2() {
        return contractedOut_SL2;
    }
    public void setContractedOut_SL2(String contractedOut_SL2) {
        this.contractedOut_SL2 = contractedOut_SL2;
    }
    public String getContractedOut_SL3() {
        return contractedOut_SL3;
    }
    public void setContractedOut_SL3(String contractedOut_SL3) {
        this.contractedOut_SL3 = contractedOut_SL3;
    }
    public String getContractedOut_SL4() {
        return contractedOut_SL4;
    }
    public void setContractedOut_SL4(String contractedOut_SL4) {
        this.contractedOut_SL4 = contractedOut_SL4;
    }
    public String getContractedOut_SL5() {
        return contractedOut_SL5;
    }
    public void setContractedOut_SL5(String contractedOut_SL5) {
        this.contractedOut_SL5 = contractedOut_SL5;
    }
    public String getContractedOut_SW1() {
        return contractedOut_SW1;
    }
    public void setContractedOut_SW1(String contractedOut_SW1) {
        this.contractedOut_SW1 = contractedOut_SW1;
    }
    public String getContractedOut_SW2() {
        return contractedOut_SW2;
    }
    public void setContractedOut_SW2(String contractedOut_SW2) {
        this.contractedOut_SW2 = contractedOut_SW2;
    }
    public String getContractedOut_SW3() {
        return contractedOut_SW3;
    }
    public void setContractedOut_SW3(String contractedOut_SW3) {
        this.contractedOut_SW3 = contractedOut_SW3;
    }
    public String getContractedOut_SW4() {
        return contractedOut_SW4;
    }
    public void setContractedOut_SW4(String contractedOut_SW4) {
        this.contractedOut_SW4 = contractedOut_SW4;
    }
    public String getContractedOut_SW5() {
        return contractedOut_SW5;
    }
    public void setContractedOut_SW5(String contractedOut_SW5) {
        this.contractedOut_SW5 = contractedOut_SW5;
    }
    public String getHca_annual_total1() {
        return hca_annual_total1;
    }
    public void setHca_annual_total1(String hca_annual_total1) {
        this.hca_annual_total1 = hca_annual_total1;
    }
    public String getHca_annual_total2() {
        return hca_annual_total2;
    }
    public void setHca_annual_total2(String hca_annual_total2) {
        this.hca_annual_total2 = hca_annual_total2;
    }
    public String getHca_annual_total3() {
        return hca_annual_total3;
    }
    public void setHca_annual_total3(String hca_annual_total3) {
        this.hca_annual_total3 = hca_annual_total3;
    }
    public String getHca_annual_total4() {
        return hca_annual_total4;
    }
    public void setHca_annual_total4(String hca_annual_total4) {
        this.hca_annual_total4 = hca_annual_total4;
    }
    public String getHca_annual_total5() {
        return hca_annual_total5;
    }
    public void setHca_annual_total5(String hca_annual_total5) {
        this.hca_annual_total5 = hca_annual_total5;
    }
    public String getHca_night_annual1() {
        return hca_night_annual1;
    }
    public void setHca_night_annual1(String hca_night_annual1) {
        this.hca_night_annual1 = hca_night_annual1;
    }
    public String getHca_night_annual2() {
        return hca_night_annual2;
    }
    public void setHca_night_annual2(String hca_night_annual2) {
        this.hca_night_annual2 = hca_night_annual2;
    }
    public String getHca_night_annual3() {
        return hca_night_annual3;
    }
    public void setHca_night_annual3(String hca_night_annual3) {
        this.hca_night_annual3 = hca_night_annual3;
    }
    public String getHca_night_annual4() {
        return hca_night_annual4;
    }
    public void setHca_night_annual4(String hca_night_annual4) {
        this.hca_night_annual4 = hca_night_annual4;
    }
    public String getHca_night_annual5() {
        return hca_night_annual5;
    }
    public void setHca_night_annual5(String hca_night_annual5) {
        this.hca_night_annual5 = hca_night_annual5;
    }
    public String getLpn_annual_total1() {
        return lpn_annual_total1;
    }
    public void setLpn_annual_total1(String lpn_annual_total1) {
        this.lpn_annual_total1 = lpn_annual_total1;
    }
    public String getLpn_annual_total2() {
        return lpn_annual_total2;
    }
    public void setLpn_annual_total2(String lpn_annual_total2) {
        this.lpn_annual_total2 = lpn_annual_total2;
    }
    public String getLpn_annual_total3() {
        return lpn_annual_total3;
    }
    public void setLpn_annual_total3(String lpn_annual_total3) {
        this.lpn_annual_total3 = lpn_annual_total3;
    }
    public String getLpn_annual_total4() {
        return lpn_annual_total4;
    }
    public void setLpn_annual_total4(String lpn_annual_total4) {
        this.lpn_annual_total4 = lpn_annual_total4;
    }
    public String getLpn_annual_total5() {
        return lpn_annual_total5;
    }
    public void setLpn_annual_total5(String lpn_annual_total5) {
        this.lpn_annual_total5 = lpn_annual_total5;
    }
    public String getLpn_night_annual1() {
        return lpn_night_annual1;
    }
    public void setLpn_night_annual1(String lpn_night_annual1) {
        this.lpn_night_annual1 = lpn_night_annual1;
    }
    public String getLpn_night_annual2() {
        return lpn_night_annual2;
    }
    public void setLpn_night_annual2(String lpn_night_annual2) {
        this.lpn_night_annual2 = lpn_night_annual2;
    }
    public String getLpn_night_annual3() {
        return lpn_night_annual3;
    }
    public void setLpn_night_annual3(String lpn_night_annual3) {
        this.lpn_night_annual3 = lpn_night_annual3;
    }
    public String getLpn_night_annual4() {
        return lpn_night_annual4;
    }
    public void setLpn_night_annual4(String lpn_night_annual4) {
        this.lpn_night_annual4 = lpn_night_annual4;
    }
    public String getLpn_night_annual5() {
        return lpn_night_annual5;
    }
    public void setLpn_night_annual5(String lpn_night_annual5) {
        this.lpn_night_annual5 = lpn_night_annual5;
    }
    public String getNnp_annual_total1() {
        return nnp_annual_total1;
    }
    public void setNnp_annual_total1(String nnp_annual_total1) {
        this.nnp_annual_total1 = nnp_annual_total1;
    }
    public String getNnp_annual_total2() {
        return nnp_annual_total2;
    }
    public void setNnp_annual_total2(String nnp_annual_total2) {
        this.nnp_annual_total2 = nnp_annual_total2;
    }
    public String getNnp_annual_total3() {
        return nnp_annual_total3;
    }
    public void setNnp_annual_total3(String nnp_annual_total3) {
        this.nnp_annual_total3 = nnp_annual_total3;
    }
    public String getNnp_annual_total4() {
        return nnp_annual_total4;
    }
    public void setNnp_annual_total4(String nnp_annual_total4) {
        this.nnp_annual_total4 = nnp_annual_total4;
    }
    public String getNnp_annual_total5() {
        return nnp_annual_total5;
    }
    public void setNnp_annual_total5(String nnp_annual_total5) {
        this.nnp_annual_total5 = nnp_annual_total5;
    }
    public String getPercentageOut_AT1() {
        return percentageOut_AT1;
    }
    public void setPercentageOut_AT1(String percentageOut_AT1) {
        this.percentageOut_AT1 = percentageOut_AT1;
    }
    public String getPercentageOut_AT2() {
        return percentageOut_AT2;
    }
    public void setPercentageOut_AT2(String percentageOut_AT2) {
        this.percentageOut_AT2 = percentageOut_AT2;
    }
    public String getPercentageOut_AT3() {
        return percentageOut_AT3;
    }
    public void setPercentageOut_AT3(String percentageOut_AT3) {
        this.percentageOut_AT3 = percentageOut_AT3;
    }
    public String getPercentageOut_AT4() {
        return percentageOut_AT4;
    }
    public void setPercentageOut_AT4(String percentageOut_AT4) {
        this.percentageOut_AT4 = percentageOut_AT4;
    }
    public String getPercentageOut_AT5() {
        return percentageOut_AT5;
    }
    public void setPercentageOut_AT5(String percentageOut_AT5) {
        this.percentageOut_AT5 = percentageOut_AT5;
    }
    public String getPercentageOut_AW1() {
        return percentageOut_AW1;
    }
    public void setPercentageOut_AW1(String percentageOut_AW1) {
        this.percentageOut_AW1 = percentageOut_AW1;
    }
    public String getPercentageOut_AW2() {
        return percentageOut_AW2;
    }
    public void setPercentageOut_AW2(String percentageOut_AW2) {
        this.percentageOut_AW2 = percentageOut_AW2;
    }
    public String getPercentageOut_AW3() {
        return percentageOut_AW3;
    }
    public void setPercentageOut_AW3(String percentageOut_AW3) {
        this.percentageOut_AW3 = percentageOut_AW3;
    }
    public String getPercentageOut_AW4() {
        return percentageOut_AW4;
    }
    public void setPercentageOut_AW4(String percentageOut_AW4) {
        this.percentageOut_AW4 = percentageOut_AW4;
    }
    public String getPercentageOut_AW5() {
        return percentageOut_AW5;
    }
    public void setPercentageOut_AW5(String percentageOut_AW5) {
        this.percentageOut_AW5 = percentageOut_AW5;
    }
    public String getPercentageOut_DT1() {
        return percentageOut_DT1;
    }
    public void setPercentageOut_DT1(String percentageOut_DT1) {
        this.percentageOut_DT1 = percentageOut_DT1;
    }
    public String getPercentageOut_DT2() {
        return percentageOut_DT2;
    }
    public void setPercentageOut_DT2(String percentageOut_DT2) {
        this.percentageOut_DT2 = percentageOut_DT2;
    }
    public String getPercentageOut_DT3() {
        return percentageOut_DT3;
    }
    public void setPercentageOut_DT3(String percentageOut_DT3) {
        this.percentageOut_DT3 = percentageOut_DT3;
    }
    public String getPercentageOut_DT4() {
        return percentageOut_DT4;
    }
    public void setPercentageOut_DT4(String percentageOut_DT4) {
        this.percentageOut_DT4 = percentageOut_DT4;
    }
    public String getPercentageOut_DT5() {
        return percentageOut_DT5;
    }
    public void setPercentageOut_DT5(String percentageOut_DT5) {
        this.percentageOut_DT5 = percentageOut_DT5;
    }
    public String getPercentageOut_MT1() {
        return percentageOut_MT1;
    }
    public void setPercentageOut_MT1(String percentageOut_MT1) {
        this.percentageOut_MT1 = percentageOut_MT1;
    }
    public String getPercentageOut_MT2() {
        return percentageOut_MT2;
    }
    public void setPercentageOut_MT2(String percentageOut_MT2) {
        this.percentageOut_MT2 = percentageOut_MT2;
    }
    public String getPercentageOut_MT3() {
        return percentageOut_MT3;
    }
    public void setPercentageOut_MT3(String percentageOut_MT3) {
        this.percentageOut_MT3 = percentageOut_MT3;
    }
    public String getPercentageOut_MT4() {
        return percentageOut_MT4;
    }
    public void setPercentageOut_MT4(String percentageOut_MT4) {
        this.percentageOut_MT4 = percentageOut_MT4;
    }
    public String getPercentageOut_MT5() {
        return percentageOut_MT5;
    }
    public void setPercentageOut_MT5(String percentageOut_MT5) {
        this.percentageOut_MT5 = percentageOut_MT5;
    }
    public String getPercentageOut_OT1() {
        return percentageOut_OT1;
    }
    public void setPercentageOut_OT1(String percentageOut_OT1) {
        this.percentageOut_OT1 = percentageOut_OT1;
    }
    public String getPercentageOut_OT2() {
        return percentageOut_OT2;
    }
    public void setPercentageOut_OT2(String percentageOut_OT2) {
        this.percentageOut_OT2 = percentageOut_OT2;
    }
    public String getPercentageOut_OT3() {
        return percentageOut_OT3;
    }
    public void setPercentageOut_OT3(String percentageOut_OT3) {
        this.percentageOut_OT3 = percentageOut_OT3;
    }
    public String getPercentageOut_OT4() {
        return percentageOut_OT4;
    }
    public void setPercentageOut_OT4(String percentageOut_OT4) {
        this.percentageOut_OT4 = percentageOut_OT4;
    }
    public String getPercentageOut_OT5() {
        return percentageOut_OT5;
    }
    public void setPercentageOut_OT5(String percentageOut_OT5) {
        this.percentageOut_OT5 = percentageOut_OT5;
    }
    public String getPercentageOut_PT1() {
        return percentageOut_PT1;
    }
    public void setPercentageOut_PT1(String percentageOut_PT1) {
        this.percentageOut_PT1 = percentageOut_PT1;
    }
    public String getPercentageOut_PT2() {
        return percentageOut_PT2;
    }
    public void setPercentageOut_PT2(String percentageOut_PT2) {
        this.percentageOut_PT2 = percentageOut_PT2;
    }
    public String getPercentageOut_PT3() {
        return percentageOut_PT3;
    }
    public void setPercentageOut_PT3(String percentageOut_PT3) {
        this.percentageOut_PT3 = percentageOut_PT3;
    }
    public String getPercentageOut_PT4() {
        return percentageOut_PT4;
    }
    public void setPercentageOut_PT4(String percentageOut_PT4) {
        this.percentageOut_PT4 = percentageOut_PT4;
    }
    public String getPercentageOut_PT5() {
        return percentageOut_PT5;
    }
    public void setPercentageOut_PT5(String percentageOut_PT5) {
        this.percentageOut_PT5 = percentageOut_PT5;
    }
    public String getPercentageOut_RA1() {
        return percentageOut_RA1;
    }
    public void setPercentageOut_RA1(String percentageOut_RA1) {
        this.percentageOut_RA1 = percentageOut_RA1;
    }
    public String getPercentageOut_RA2() {
        return percentageOut_RA2;
    }
    public void setPercentageOut_RA2(String percentageOut_RA2) {
        this.percentageOut_RA2 = percentageOut_RA2;
    }
    public String getPercentageOut_RA3() {
        return percentageOut_RA3;
    }
    public void setPercentageOut_RA3(String percentageOut_RA3) {
        this.percentageOut_RA3 = percentageOut_RA3;
    }
    public String getPercentageOut_RA4() {
        return percentageOut_RA4;
    }
    public void setPercentageOut_RA4(String percentageOut_RA4) {
        this.percentageOut_RA4 = percentageOut_RA4;
    }
    public String getPercentageOut_RA5() {
        return percentageOut_RA5;
    }
    public void setPercentageOut_RA5(String percentageOut_RA5) {
        this.percentageOut_RA5 = percentageOut_RA5;
    }
    public String getPercentageOut_RN1() {
        return percentageOut_RN1;
    }
    public void setPercentageOut_RN1(String percentageOut_RN1) {
        this.percentageOut_RN1 = percentageOut_RN1;
    }
    public String getPercentageOut_RN2() {
        return percentageOut_RN2;
    }
    public void setPercentageOut_RN2(String percentageOut_RN2) {
        this.percentageOut_RN2 = percentageOut_RN2;
    }
    public String getPercentageOut_RN3() {
        return percentageOut_RN3;
    }
    public void setPercentageOut_RN3(String percentageOut_RN3) {
        this.percentageOut_RN3 = percentageOut_RN3;
    }
    public String getPercentageOut_RN4() {
        return percentageOut_RN4;
    }
    public void setPercentageOut_RN4(String percentageOut_RN4) {
        this.percentageOut_RN4 = percentageOut_RN4;
    }
    public String getPercentageOut_RN5() {
        return percentageOut_RN5;
    }
    public void setPercentageOut_RN5(String percentageOut_RN5) {
        this.percentageOut_RN5 = percentageOut_RN5;
    }
    public String getPercentageOut_RT1() {
        return percentageOut_RT1;
    }
    public void setPercentageOut_RT1(String percentageOut_RT1) {
        this.percentageOut_RT1 = percentageOut_RT1;
    }
    public String getPercentageOut_RT2() {
        return percentageOut_RT2;
    }
    public void setPercentageOut_RT2(String percentageOut_RT2) {
        this.percentageOut_RT2 = percentageOut_RT2;
    }
    public String getPercentageOut_RT3() {
        return percentageOut_RT3;
    }
    public void setPercentageOut_RT3(String percentageOut_RT3) {
        this.percentageOut_RT3 = percentageOut_RT3;
    }
    public String getPercentageOut_RT4() {
        return percentageOut_RT4;
    }
    public void setPercentageOut_RT4(String percentageOut_RT4) {
        this.percentageOut_RT4 = percentageOut_RT4;
    }
    public String getPercentageOut_RT5() {
        return percentageOut_RT5;
    }
    public void setPercentageOut_RT5(String percentageOut_RT5) {
        this.percentageOut_RT5 = percentageOut_RT5;
    }
    public String getPercentageOut_SL1() {
        return percentageOut_SL1;
    }
    public void setPercentageOut_SL1(String percentageOut_SL1) {
        this.percentageOut_SL1 = percentageOut_SL1;
    }
    public String getPercentageOut_SL2() {
        return percentageOut_SL2;
    }
    public void setPercentageOut_SL2(String percentageOut_SL2) {
        this.percentageOut_SL2 = percentageOut_SL2;
    }
    public String getPercentageOut_SL3() {
        return percentageOut_SL3;
    }
    public void setPercentageOut_SL3(String percentageOut_SL3) {
        this.percentageOut_SL3 = percentageOut_SL3;
    }
    public String getPercentageOut_SL4() {
        return percentageOut_SL4;
    }
    public void setPercentageOut_SL4(String percentageOut_SL4) {
        this.percentageOut_SL4 = percentageOut_SL4;
    }
    public String getPercentageOut_SL5() {
        return percentageOut_SL5;
    }
    public void setPercentageOut_SL5(String percentageOut_SL5) {
        this.percentageOut_SL5 = percentageOut_SL5;
    }
    public String getPercentageOut_SW1() {
        return percentageOut_SW1;
    }
    public void setPercentageOut_SW1(String percentageOut_SW1) {
        this.percentageOut_SW1 = percentageOut_SW1;
    }
    public String getPercentageOut_SW2() {
        return percentageOut_SW2;
    }
    public void setPercentageOut_SW2(String percentageOut_SW2) {
        this.percentageOut_SW2 = percentageOut_SW2;
    }
    public String getPercentageOut_SW3() {
        return percentageOut_SW3;
    }
    public void setPercentageOut_SW3(String percentageOut_SW3) {
        this.percentageOut_SW3 = percentageOut_SW3;
    }
    public String getPercentageOut_SW4() {
        return percentageOut_SW4;
    }
    public void setPercentageOut_SW4(String percentageOut_SW4) {
        this.percentageOut_SW4 = percentageOut_SW4;
    }
    public String getPercentageOut_SW5() {
        return percentageOut_SW5;
    }
    public void setPercentageOut_SW5(String percentageOut_SW5) {
        this.percentageOut_SW5 = percentageOut_SW5;
    }
    public String getProviderName_LPN1() {
        return providerName_LPN1;
    }
    public void setProviderName_LPN1(String providerName_LPN1) {
        this.providerName_LPN1 = providerName_LPN1;
    }
    public String getProviderName_LPN2() {
        return providerName_LPN2;
    }
    public void setProviderName_LPN2(String providerName_LPN2) {
        this.providerName_LPN2 = providerName_LPN2;
    }
    public String getProviderName_LPN3() {
        return providerName_LPN3;
    }
    public void setProviderName_LPN3(String providerName_LPN3) {
        this.providerName_LPN3 = providerName_LPN3;
    }
    public String getProviderName_LPN4() {
        return providerName_LPN4;
    }
    public void setProviderName_LPN4(String providerName_LPN4) {
        this.providerName_LPN4 = providerName_LPN4;
    }
    public String getProviderName_LPN5() {
        return providerName_LPN5;
    }
    public void setProviderName_LPN5(String providerName_LPN5) {
        this.providerName_LPN5 = providerName_LPN5;
    }
    public String getStaffingPlanType1() {
        return staffingPlanType1;
    }
    public void setStaffingPlanType1(String staffingPlanType1) {
        this.staffingPlanType1 = staffingPlanType1;
    }
    public String getStaffingPlanType2() {
        return staffingPlanType2;
    }
    public void setStaffingPlanType2(String staffingPlanType2) {
        this.staffingPlanType2 = staffingPlanType2;
    }
    public String getStaffingPlanType3() {
        return staffingPlanType3;
    }
    public void setStaffingPlanType3(String staffingPlanType3) {
        this.staffingPlanType3 = staffingPlanType3;
    }
    public String getStaffingPlanType4() {
        return staffingPlanType4;
    }
    public void setStaffingPlanType4(String staffingPlanType4) {
        this.staffingPlanType4 = staffingPlanType4;
    }
    public String getStaffingPlanType5() {
        return staffingPlanType5;
    }
    public void setStaffingPlanType5(String staffingPlanType5) {
        this.staffingPlanType5 = staffingPlanType5;
    }
    public String getHPRD_allied_total1() {
        return HPRD_allied_total1;
    }
    public void setHPRD_allied_total1(String hPRD_allied_total1) {
        HPRD_allied_total1 = hPRD_allied_total1;
    }
    public String getHPRD_allied_total2() {
        return HPRD_allied_total2;
    }
    public void setHPRD_allied_total2(String hPRD_allied_total2) {
        HPRD_allied_total2 = hPRD_allied_total2;
    }
    public String getHPRD_allied_total3() {
        return HPRD_allied_total3;
    }
    public void setHPRD_allied_total3(String hPRD_allied_total3) {
        HPRD_allied_total3 = hPRD_allied_total3;
    }
    public String getHPRD_allied_total4() {
        return HPRD_allied_total4;
    }
    public void setHPRD_allied_total4(String hPRD_allied_total4) {
        HPRD_allied_total4 = hPRD_allied_total4;
    }
    public String getHPRD_allied_total5() {
        return HPRD_allied_total5;
    }
    public void setHPRD_allied_total5(String hPRD_allied_total5) {
        HPRD_allied_total5 = hPRD_allied_total5;
    }
    public String getAldnop_week_total1() {
        return aldnop_week_total1;
    }
    public void setAldnop_week_total1(String aldnop_week_total1) {
        this.aldnop_week_total1 = aldnop_week_total1;
    }
    public String getAldnop_week_total2() {
        return aldnop_week_total2;
    }
    public void setAldnop_week_total2(String aldnop_week_total2) {
        this.aldnop_week_total2 = aldnop_week_total2;
    }
    public String getAldnop_week_total3() {
        return aldnop_week_total3;
    }
    public void setAldnop_week_total3(String aldnop_week_total3) {
        this.aldnop_week_total3 = aldnop_week_total3;
    }
    public String getAldnop_week_total4() {
        return aldnop_week_total4;
    }
    public void setAldnop_week_total4(String aldnop_week_total4) {
        this.aldnop_week_total4 = aldnop_week_total4;
    }
    public String getAldnop_week_total5() {
        return aldnop_week_total5;
    }
    public void setAldnop_week_total5(String aldnop_week_total5) {
        this.aldnop_week_total5 = aldnop_week_total5;
    }
    public String getAllied_week_total1() {
        return allied_week_total1;
    }
    public void setAllied_week_total1(String allied_week_total1) {
        this.allied_week_total1 = allied_week_total1;
    }
    public String getAllied_week_total2() {
        return allied_week_total2;
    }
    public void setAllied_week_total2(String allied_week_total2) {
        this.allied_week_total2 = allied_week_total2;
    }
    public String getAllied_week_total3() {
        return allied_week_total3;
    }
    public void setAllied_week_total3(String allied_week_total3) {
        this.allied_week_total3 = allied_week_total3;
    }
    public String getAllied_week_total4() {
        return allied_week_total4;
    }
    public void setAllied_week_total4(String allied_week_total4) {
        this.allied_week_total4 = allied_week_total4;
    }
    public String getAllied_week_total5() {
        return allied_week_total5;
    }
    public void setAllied_week_total5(String allied_week_total5) {
        this.allied_week_total5 = allied_week_total5;
    }
    public String getAlliednp_other_mon() {
        return alliednp_other_mon;
    }
    public void setAlliednp_other_mon(String alliednp_other_mon) {
        this.alliednp_other_mon = alliednp_other_mon;
    }
    public String getContractedOut_HCA1() {
        return contractedOut_HCA1;
    }
    public void setContractedOut_HCA1(String contractedOut_HCA1) {
        this.contractedOut_HCA1 = contractedOut_HCA1;
    }
    public String getContractedOut_HCA2() {
        return contractedOut_HCA2;
    }
    public void setContractedOut_HCA2(String contractedOut_HCA2) {
        this.contractedOut_HCA2 = contractedOut_HCA2;
    }
    public String getContractedOut_HCA3() {
        return contractedOut_HCA3;
    }
    public void setContractedOut_HCA3(String contractedOut_HCA3) {
        this.contractedOut_HCA3 = contractedOut_HCA3;
    }
    public String getContractedOut_HCA4() {
        return contractedOut_HCA4;
    }
    public void setContractedOut_HCA4(String contractedOut_HCA4) {
        this.contractedOut_HCA4 = contractedOut_HCA4;
    }
    public String getContractedOut_HCA5() {
        return contractedOut_HCA5;
    }
    public void setContractedOut_HCA5(String contractedOut_HCA5) {
        this.contractedOut_HCA5 = contractedOut_HCA5;
    }
    public String getContractedOut_LPN1() {
        return contractedOut_LPN1;
    }
    public void setContractedOut_LPN1(String contractedOut_LPN1) {
        this.contractedOut_LPN1 = contractedOut_LPN1;
    }
    public String getContractedOut_LPN2() {
        return contractedOut_LPN2;
    }
    public void setContractedOut_LPN2(String contractedOut_LPN2) {
        this.contractedOut_LPN2 = contractedOut_LPN2;
    }
    public String getContractedOut_LPN3() {
        return contractedOut_LPN3;
    }
    public void setContractedOut_LPN3(String contractedOut_LPN3) {
        this.contractedOut_LPN3 = contractedOut_LPN3;
    }
    public String getContractedOut_LPN4() {
        return contractedOut_LPN4;
    }
    public void setContractedOut_LPN4(String contractedOut_LPN4) {
        this.contractedOut_LPN4 = contractedOut_LPN4;
    }
    public String getContractedOut_LPN5() {
        return contractedOut_LPN5;
    }
    public void setContractedOut_LPN5(String contractedOut_LPN5) {
        this.contractedOut_LPN5 = contractedOut_LPN5;
    }
    public String getNumberOfTotalBeds1() {
        return numberOfTotalBeds1;
    }
    public void setNumberOfTotalBeds1(String numberOfTotalBeds1) {
        this.numberOfTotalBeds1 = numberOfTotalBeds1;
    }
    public String getNumberOfTotalBeds2() {
        return numberOfTotalBeds2;
    }
    public void setNumberOfTotalBeds2(String numberOfTotalBeds2) {
        this.numberOfTotalBeds2 = numberOfTotalBeds2;
    }
    public String getNumberOfTotalBeds3() {
        return numberOfTotalBeds3;
    }
    public void setNumberOfTotalBeds3(String numberOfTotalBeds3) {
        this.numberOfTotalBeds3 = numberOfTotalBeds3;
    }
    public String getNumberOfTotalBeds4() {
        return numberOfTotalBeds4;
    }
    public void setNumberOfTotalBeds4(String numberOfTotalBeds4) {
        this.numberOfTotalBeds4 = numberOfTotalBeds4;
    }
    public String getNumberOfTotalBeds5() {
        return numberOfTotalBeds5;
    }
    public void setNumberOfTotalBeds5(String numberOfTotalBeds5) {
        this.numberOfTotalBeds5 = numberOfTotalBeds5;
    }
    public String getNursing_fri_total1() {
        return nursing_fri_total1;
    }
    public void setNursing_fri_total1(String nursing_fri_total1) {
        this.nursing_fri_total1 = nursing_fri_total1;
    }
    public String getNursing_fri_total2() {
        return nursing_fri_total2;
    }
    public void setNursing_fri_total2(String nursing_fri_total2) {
        this.nursing_fri_total2 = nursing_fri_total2;
    }
    public String getNursing_fri_total3() {
        return nursing_fri_total3;
    }
    public void setNursing_fri_total3(String nursing_fri_total3) {
        this.nursing_fri_total3 = nursing_fri_total3;
    }
    public String getNursing_fri_total4() {
        return nursing_fri_total4;
    }
    public void setNursing_fri_total4(String nursing_fri_total4) {
        this.nursing_fri_total4 = nursing_fri_total4;
    }
    public String getNursing_fri_total5() {
        return nursing_fri_total5;
    }
    public void setNursing_fri_total5(String nursing_fri_total5) {
        this.nursing_fri_total5 = nursing_fri_total5;
    }
    public String getNursing_mon_total1() {
        return nursing_mon_total1;
    }
    public void setNursing_mon_total1(String nursing_mon_total1) {
        this.nursing_mon_total1 = nursing_mon_total1;
    }
    public String getNursing_mon_total2() {
        return nursing_mon_total2;
    }
    public void setNursing_mon_total2(String nursing_mon_total2) {
        this.nursing_mon_total2 = nursing_mon_total2;
    }
    public String getNursing_mon_total3() {
        return nursing_mon_total3;
    }
    public void setNursing_mon_total3(String nursing_mon_total3) {
        this.nursing_mon_total3 = nursing_mon_total3;
    }
    public String getNursing_mon_total4() {
        return nursing_mon_total4;
    }
    public void setNursing_mon_total4(String nursing_mon_total4) {
        this.nursing_mon_total4 = nursing_mon_total4;
    }
    public String getNursing_mon_total5() {
        return nursing_mon_total5;
    }
    public void setNursing_mon_total5(String nursing_mon_total5) {
        this.nursing_mon_total5 = nursing_mon_total5;
    }
    public String getNursing_other_mon1() {
        return nursing_other_mon1;
    }
    public void setNursing_other_mon1(String nursing_other_mon1) {
        this.nursing_other_mon1 = nursing_other_mon1;
    }
    public String getNursing_other_mon2() {
        return nursing_other_mon2;
    }
    public void setNursing_other_mon2(String nursing_other_mon2) {
        this.nursing_other_mon2 = nursing_other_mon2;
    }
    public String getNursing_other_mon3() {
        return nursing_other_mon3;
    }
    public void setNursing_other_mon3(String nursing_other_mon3) {
        this.nursing_other_mon3 = nursing_other_mon3;
    }
    public String getNursing_other_mon4() {
        return nursing_other_mon4;
    }
    public void setNursing_other_mon4(String nursing_other_mon4) {
        this.nursing_other_mon4 = nursing_other_mon4;
    }
    public String getNursing_other_mon5() {
        return nursing_other_mon5;
    }
    public void setNursing_other_mon5(String nursing_other_mon5) {
        this.nursing_other_mon5 = nursing_other_mon5;
    }
    public String getNursing_sat_total1() {
        return nursing_sat_total1;
    }
    public void setNursing_sat_total1(String nursing_sat_total1) {
        this.nursing_sat_total1 = nursing_sat_total1;
    }
    public String getNursing_sat_total2() {
        return nursing_sat_total2;
    }
    public void setNursing_sat_total2(String nursing_sat_total2) {
        this.nursing_sat_total2 = nursing_sat_total2;
    }
    public String getNursing_sat_total3() {
        return nursing_sat_total3;
    }
    public void setNursing_sat_total3(String nursing_sat_total3) {
        this.nursing_sat_total3 = nursing_sat_total3;
    }
    public String getNursing_sat_total4() {
        return nursing_sat_total4;
    }
    public void setNursing_sat_total4(String nursing_sat_total4) {
        this.nursing_sat_total4 = nursing_sat_total4;
    }
    public String getNursing_sat_total5() {
        return nursing_sat_total5;
    }
    public void setNursing_sat_total5(String nursing_sat_total5) {
        this.nursing_sat_total5 = nursing_sat_total5;
    }
    public String getNursing_sun_total1() {
        return nursing_sun_total1;
    }
    public void setNursing_sun_total1(String nursing_sun_total1) {
        this.nursing_sun_total1 = nursing_sun_total1;
    }
    public String getNursing_sun_total2() {
        return nursing_sun_total2;
    }
    public void setNursing_sun_total2(String nursing_sun_total2) {
        this.nursing_sun_total2 = nursing_sun_total2;
    }
    public String getNursing_sun_total3() {
        return nursing_sun_total3;
    }
    public void setNursing_sun_total3(String nursing_sun_total3) {
        this.nursing_sun_total3 = nursing_sun_total3;
    }
    public String getNursing_sun_total4() {
        return nursing_sun_total4;
    }
    public void setNursing_sun_total4(String nursing_sun_total4) {
        this.nursing_sun_total4 = nursing_sun_total4;
    }
    public String getNursing_sun_total5() {
        return nursing_sun_total5;
    }
    public void setNursing_sun_total5(String nursing_sun_total5) {
        this.nursing_sun_total5 = nursing_sun_total5;
    }
    public String getNursing_thu_total1() {
        return nursing_thu_total1;
    }
    public void setNursing_thu_total1(String nursing_thu_total1) {
        this.nursing_thu_total1 = nursing_thu_total1;
    }
    public String getNursing_thu_total2() {
        return nursing_thu_total2;
    }
    public void setNursing_thu_total2(String nursing_thu_total2) {
        this.nursing_thu_total2 = nursing_thu_total2;
    }
    public String getNursing_thu_total3() {
        return nursing_thu_total3;
    }
    public void setNursing_thu_total3(String nursing_thu_total3) {
        this.nursing_thu_total3 = nursing_thu_total3;
    }
    public String getNursing_thu_total4() {
        return nursing_thu_total4;
    }
    public void setNursing_thu_total4(String nursing_thu_total4) {
        this.nursing_thu_total4 = nursing_thu_total4;
    }
    public String getNursing_thu_total5() {
        return nursing_thu_total5;
    }
    public void setNursing_thu_total5(String nursing_thu_total5) {
        this.nursing_thu_total5 = nursing_thu_total5;
    }
    public String getNursing_tue_total1() {
        return nursing_tue_total1;
    }
    public void setNursing_tue_total1(String nursing_tue_total1) {
        this.nursing_tue_total1 = nursing_tue_total1;
    }
    public String getNursing_tue_total2() {
        return nursing_tue_total2;
    }
    public void setNursing_tue_total2(String nursing_tue_total2) {
        this.nursing_tue_total2 = nursing_tue_total2;
    }
    public String getNursing_tue_total3() {
        return nursing_tue_total3;
    }
    public void setNursing_tue_total3(String nursing_tue_total3) {
        this.nursing_tue_total3 = nursing_tue_total3;
    }
    public String getNursing_tue_total4() {
        return nursing_tue_total4;
    }
    public void setNursing_tue_total4(String nursing_tue_total4) {
        this.nursing_tue_total4 = nursing_tue_total4;
    }
    public String getNursing_tue_total5() {
        return nursing_tue_total5;
    }
    public void setNursing_tue_total5(String nursing_tue_total5) {
        this.nursing_tue_total5 = nursing_tue_total5;
    }
    public String getNursing_wed_total1() {
        return nursing_wed_total1;
    }
    public void setNursing_wed_total1(String nursing_wed_total1) {
        this.nursing_wed_total1 = nursing_wed_total1;
    }
    public String getNursing_wed_total2() {
        return nursing_wed_total2;
    }
    public void setNursing_wed_total2(String nursing_wed_total2) {
        this.nursing_wed_total2 = nursing_wed_total2;
    }
    public String getNursing_wed_total3() {
        return nursing_wed_total3;
    }
    public void setNursing_wed_total3(String nursing_wed_total3) {
        this.nursing_wed_total3 = nursing_wed_total3;
    }
    public String getNursing_wed_total4() {
        return nursing_wed_total4;
    }
    public void setNursing_wed_total4(String nursing_wed_total4) {
        this.nursing_wed_total4 = nursing_wed_total4;
    }
    public String getNursing_wed_total5() {
        return nursing_wed_total5;
    }
    public void setNursing_wed_total5(String nursing_wed_total5) {
        this.nursing_wed_total5 = nursing_wed_total5;
    }
    public String getPercentageOut_HCA1() {
        return percentageOut_HCA1;
    }
    public void setPercentageOut_HCA1(String percentageOut_HCA1) {
        this.percentageOut_HCA1 = percentageOut_HCA1;
    }
    public String getPercentageOut_HCA2() {
        return percentageOut_HCA2;
    }
    public void setPercentageOut_HCA2(String percentageOut_HCA2) {
        this.percentageOut_HCA2 = percentageOut_HCA2;
    }
    public String getPercentageOut_HCA3() {
        return percentageOut_HCA3;
    }
    public void setPercentageOut_HCA3(String percentageOut_HCA3) {
        this.percentageOut_HCA3 = percentageOut_HCA3;
    }
    public String getPercentageOut_HCA4() {
        return percentageOut_HCA4;
    }
    public void setPercentageOut_HCA4(String percentageOut_HCA4) {
        this.percentageOut_HCA4 = percentageOut_HCA4;
    }
    public String getPercentageOut_HCA5() {
        return percentageOut_HCA5;
    }
    public void setPercentageOut_HCA5(String percentageOut_HCA5) {
        this.percentageOut_HCA5 = percentageOut_HCA5;
    }
    public String getPercentageOut_LPN1() {
        return percentageOut_LPN1;
    }
    public void setPercentageOut_LPN1(String percentageOut_LPN1) {
        this.percentageOut_LPN1 = percentageOut_LPN1;
    }
    public String getPercentageOut_LPN2() {
        return percentageOut_LPN2;
    }
    public void setPercentageOut_LPN2(String percentageOut_LPN2) {
        this.percentageOut_LPN2 = percentageOut_LPN2;
    }
    public String getPercentageOut_LPN3() {
        return percentageOut_LPN3;
    }
    public void setPercentageOut_LPN3(String percentageOut_LPN3) {
        this.percentageOut_LPN3 = percentageOut_LPN3;
    }
    public String getPercentageOut_LPN4() {
        return percentageOut_LPN4;
    }
    public void setPercentageOut_LPN4(String percentageOut_LPN4) {
        this.percentageOut_LPN4 = percentageOut_LPN4;
    }
    public String getPercentageOut_LPN5() {
        return percentageOut_LPN5;
    }
    public void setPercentageOut_LPN5(String percentageOut_LPN5) {
        this.percentageOut_LPN5 = percentageOut_LPN5;
    }
    public String getProviderName_HCA21() {
        return providerName_HCA21;
    }
    public void setProviderName_HCA21(String providerName_HCA21) {
        this.providerName_HCA21 = providerName_HCA21;
    }
    public String getProviderName_HCA22() {
        return providerName_HCA22;
    }
    public void setProviderName_HCA22(String providerName_HCA22) {
        this.providerName_HCA22 = providerName_HCA22;
    }
    public String getProviderName_HCA23() {
        return providerName_HCA23;
    }
    public void setProviderName_HCA23(String providerName_HCA23) {
        this.providerName_HCA23 = providerName_HCA23;
    }
    public String getProviderName_HCA24() {
        return providerName_HCA24;
    }
    public void setProviderName_HCA24(String providerName_HCA24) {
        this.providerName_HCA24 = providerName_HCA24;
    }
    public String getProviderName_HCA25() {
        return providerName_HCA25;
    }
    public void setProviderName_HCA25(String providerName_HCA25) {
        this.providerName_HCA25 = providerName_HCA25;
    }
    public String getProviderName_resp1() {
        return providerName_resp1;
    }
    public void setProviderName_resp1(String providerName_resp1) {
        this.providerName_resp1 = providerName_resp1;
    }
    public String getProviderName_resp2() {
        return providerName_resp2;
    }
    public void setProviderName_resp2(String providerName_resp2) {
        this.providerName_resp2 = providerName_resp2;
    }
    public String getProviderName_resp3() {
        return providerName_resp3;
    }
    public void setProviderName_resp3(String providerName_resp3) {
        this.providerName_resp3 = providerName_resp3;
    }
    public String getProviderName_resp4() {
        return providerName_resp4;
    }
    public void setProviderName_resp4(String providerName_resp4) {
        this.providerName_resp4 = providerName_resp4;
    }
    public String getProviderName_resp5() {
        return providerName_resp5;
    }
    public void setProviderName_resp5(String providerName_resp5) {
        this.providerName_resp5 = providerName_resp5;
    }
    public String getSummary_annual_AT1() {
        return summary_annual_AT1;
    }
    public void setSummary_annual_AT1(String summary_annual_AT1) {
        this.summary_annual_AT1 = summary_annual_AT1;
    }
    public String getSummary_annual_AT2() {
        return summary_annual_AT2;
    }
    public void setSummary_annual_AT2(String summary_annual_AT2) {
        this.summary_annual_AT2 = summary_annual_AT2;
    }
    public String getSummary_annual_AT3() {
        return summary_annual_AT3;
    }
    public void setSummary_annual_AT3(String summary_annual_AT3) {
        this.summary_annual_AT3 = summary_annual_AT3;
    }
    public String getSummary_annual_AT4() {
        return summary_annual_AT4;
    }
    public void setSummary_annual_AT4(String summary_annual_AT4) {
        this.summary_annual_AT4 = summary_annual_AT4;
    }
    public String getSummary_annual_AT5() {
        return summary_annual_AT5;
    }
    public void setSummary_annual_AT5(String summary_annual_AT5) {
        this.summary_annual_AT5 = summary_annual_AT5;
    }
    public String getSummary_annual_AW1() {
        return summary_annual_AW1;
    }
    public void setSummary_annual_AW1(String summary_annual_AW1) {
        this.summary_annual_AW1 = summary_annual_AW1;
    }
    public String getSummary_annual_AW2() {
        return summary_annual_AW2;
    }
    public void setSummary_annual_AW2(String summary_annual_AW2) {
        this.summary_annual_AW2 = summary_annual_AW2;
    }
    public String getSummary_annual_AW3() {
        return summary_annual_AW3;
    }
    public void setSummary_annual_AW3(String summary_annual_AW3) {
        this.summary_annual_AW3 = summary_annual_AW3;
    }
    public String getSummary_annual_AW4() {
        return summary_annual_AW4;
    }
    public void setSummary_annual_AW4(String summary_annual_AW4) {
        this.summary_annual_AW4 = summary_annual_AW4;
    }
    public String getSummary_annual_AW5() {
        return summary_annual_AW5;
    }
    public void setSummary_annual_AW5(String summary_annual_AW5) {
        this.summary_annual_AW5 = summary_annual_AW5;
    }
    public String getSummary_annual_DT1() {
        return summary_annual_DT1;
    }
    public void setSummary_annual_DT1(String summary_annual_DT1) {
        this.summary_annual_DT1 = summary_annual_DT1;
    }
    public String getSummary_annual_DT2() {
        return summary_annual_DT2;
    }
    public void setSummary_annual_DT2(String summary_annual_DT2) {
        this.summary_annual_DT2 = summary_annual_DT2;
    }
    public String getSummary_annual_DT3() {
        return summary_annual_DT3;
    }
    public void setSummary_annual_DT3(String summary_annual_DT3) {
        this.summary_annual_DT3 = summary_annual_DT3;
    }
    public String getSummary_annual_DT4() {
        return summary_annual_DT4;
    }
    public void setSummary_annual_DT4(String summary_annual_DT4) {
        this.summary_annual_DT4 = summary_annual_DT4;
    }
    public String getSummary_annual_DT5() {
        return summary_annual_DT5;
    }
    public void setSummary_annual_DT5(String summary_annual_DT5) {
        this.summary_annual_DT5 = summary_annual_DT5;
    }
    public String getSummary_annual_MT1() {
        return summary_annual_MT1;
    }
    public void setSummary_annual_MT1(String summary_annual_MT1) {
        this.summary_annual_MT1 = summary_annual_MT1;
    }
    public String getSummary_annual_MT2() {
        return summary_annual_MT2;
    }
    public void setSummary_annual_MT2(String summary_annual_MT2) {
        this.summary_annual_MT2 = summary_annual_MT2;
    }
    public String getSummary_annual_MT3() {
        return summary_annual_MT3;
    }
    public void setSummary_annual_MT3(String summary_annual_MT3) {
        this.summary_annual_MT3 = summary_annual_MT3;
    }
    public String getSummary_annual_MT4() {
        return summary_annual_MT4;
    }
    public void setSummary_annual_MT4(String summary_annual_MT4) {
        this.summary_annual_MT4 = summary_annual_MT4;
    }
    public String getSummary_annual_MT5() {
        return summary_annual_MT5;
    }
    public void setSummary_annual_MT5(String summary_annual_MT5) {
        this.summary_annual_MT5 = summary_annual_MT5;
    }
    public String getSummary_annual_OT1() {
        return summary_annual_OT1;
    }
    public void setSummary_annual_OT1(String summary_annual_OT1) {
        this.summary_annual_OT1 = summary_annual_OT1;
    }
    public String getSummary_annual_OT2() {
        return summary_annual_OT2;
    }
    public void setSummary_annual_OT2(String summary_annual_OT2) {
        this.summary_annual_OT2 = summary_annual_OT2;
    }
    public String getSummary_annual_OT3() {
        return summary_annual_OT3;
    }
    public void setSummary_annual_OT3(String summary_annual_OT3) {
        this.summary_annual_OT3 = summary_annual_OT3;
    }
    public String getSummary_annual_OT4() {
        return summary_annual_OT4;
    }
    public void setSummary_annual_OT4(String summary_annual_OT4) {
        this.summary_annual_OT4 = summary_annual_OT4;
    }
    public String getSummary_annual_OT5() {
        return summary_annual_OT5;
    }
    public void setSummary_annual_OT5(String summary_annual_OT5) {
        this.summary_annual_OT5 = summary_annual_OT5;
    }
    public String getSummary_annual_PT1() {
        return summary_annual_PT1;
    }
    public void setSummary_annual_PT1(String summary_annual_PT1) {
        this.summary_annual_PT1 = summary_annual_PT1;
    }
    public String getSummary_annual_PT2() {
        return summary_annual_PT2;
    }
    public void setSummary_annual_PT2(String summary_annual_PT2) {
        this.summary_annual_PT2 = summary_annual_PT2;
    }
    public String getSummary_annual_PT3() {
        return summary_annual_PT3;
    }
    public void setSummary_annual_PT3(String summary_annual_PT3) {
        this.summary_annual_PT3 = summary_annual_PT3;
    }
    public String getSummary_annual_PT4() {
        return summary_annual_PT4;
    }
    public void setSummary_annual_PT4(String summary_annual_PT4) {
        this.summary_annual_PT4 = summary_annual_PT4;
    }
    public String getSummary_annual_PT5() {
        return summary_annual_PT5;
    }
    public void setSummary_annual_PT5(String summary_annual_PT5) {
        this.summary_annual_PT5 = summary_annual_PT5;
    }
    public String getSummary_annual_RA1() {
        return summary_annual_RA1;
    }
    public void setSummary_annual_RA1(String summary_annual_RA1) {
        this.summary_annual_RA1 = summary_annual_RA1;
    }
    public String getSummary_annual_RA2() {
        return summary_annual_RA2;
    }
    public void setSummary_annual_RA2(String summary_annual_RA2) {
        this.summary_annual_RA2 = summary_annual_RA2;
    }
    public String getSummary_annual_RA3() {
        return summary_annual_RA3;
    }
    public void setSummary_annual_RA3(String summary_annual_RA3) {
        this.summary_annual_RA3 = summary_annual_RA3;
    }
    public String getSummary_annual_RA4() {
        return summary_annual_RA4;
    }
    public void setSummary_annual_RA4(String summary_annual_RA4) {
        this.summary_annual_RA4 = summary_annual_RA4;
    }
    public String getSummary_annual_RA5() {
        return summary_annual_RA5;
    }
    public void setSummary_annual_RA5(String summary_annual_RA5) {
        this.summary_annual_RA5 = summary_annual_RA5;
    }
    public String getSummary_annual_RN1() {
        return summary_annual_RN1;
    }
    public void setSummary_annual_RN1(String summary_annual_RN1) {
        this.summary_annual_RN1 = summary_annual_RN1;
    }
    public String getSummary_annual_RN2() {
        return summary_annual_RN2;
    }
    public void setSummary_annual_RN2(String summary_annual_RN2) {
        this.summary_annual_RN2 = summary_annual_RN2;
    }
    public String getSummary_annual_RN3() {
        return summary_annual_RN3;
    }
    public void setSummary_annual_RN3(String summary_annual_RN3) {
        this.summary_annual_RN3 = summary_annual_RN3;
    }
    public String getSummary_annual_RN4() {
        return summary_annual_RN4;
    }
    public void setSummary_annual_RN4(String summary_annual_RN4) {
        this.summary_annual_RN4 = summary_annual_RN4;
    }
    public String getSummary_annual_RN5() {
        return summary_annual_RN5;
    }
    public void setSummary_annual_RN5(String summary_annual_RN5) {
        this.summary_annual_RN5 = summary_annual_RN5;
    }
    public String getSummary_annual_RT1() {
        return summary_annual_RT1;
    }
    public void setSummary_annual_RT1(String summary_annual_RT1) {
        this.summary_annual_RT1 = summary_annual_RT1;
    }
    public String getSummary_annual_RT2() {
        return summary_annual_RT2;
    }
    public void setSummary_annual_RT2(String summary_annual_RT2) {
        this.summary_annual_RT2 = summary_annual_RT2;
    }
    public String getSummary_annual_RT3() {
        return summary_annual_RT3;
    }
    public void setSummary_annual_RT3(String summary_annual_RT3) {
        this.summary_annual_RT3 = summary_annual_RT3;
    }
    public String getSummary_annual_RT4() {
        return summary_annual_RT4;
    }
    public void setSummary_annual_RT4(String summary_annual_RT4) {
        this.summary_annual_RT4 = summary_annual_RT4;
    }
    public String getSummary_annual_RT5() {
        return summary_annual_RT5;
    }
    public void setSummary_annual_RT5(String summary_annual_RT5) {
        this.summary_annual_RT5 = summary_annual_RT5;
    }
    public String getSummary_annual_SL1() {
        return summary_annual_SL1;
    }
    public void setSummary_annual_SL1(String summary_annual_SL1) {
        this.summary_annual_SL1 = summary_annual_SL1;
    }
    public String getSummary_annual_SL2() {
        return summary_annual_SL2;
    }
    public void setSummary_annual_SL2(String summary_annual_SL2) {
        this.summary_annual_SL2 = summary_annual_SL2;
    }
    public String getSummary_annual_SL3() {
        return summary_annual_SL3;
    }
    public void setSummary_annual_SL3(String summary_annual_SL3) {
        this.summary_annual_SL3 = summary_annual_SL3;
    }
    public String getSummary_annual_SL4() {
        return summary_annual_SL4;
    }
    public void setSummary_annual_SL4(String summary_annual_SL4) {
        this.summary_annual_SL4 = summary_annual_SL4;
    }
    public String getSummary_annual_SL5() {
        return summary_annual_SL5;
    }
    public void setSummary_annual_SL5(String summary_annual_SL5) {
        this.summary_annual_SL5 = summary_annual_SL5;
    }
    public String getSummary_annual_SW1() {
        return summary_annual_SW1;
    }
    public void setSummary_annual_SW1(String summary_annual_SW1) {
        this.summary_annual_SW1 = summary_annual_SW1;
    }
    public String getSummary_annual_SW2() {
        return summary_annual_SW2;
    }
    public void setSummary_annual_SW2(String summary_annual_SW2) {
        this.summary_annual_SW2 = summary_annual_SW2;
    }
    public String getSummary_annual_SW3() {
        return summary_annual_SW3;
    }
    public void setSummary_annual_SW3(String summary_annual_SW3) {
        this.summary_annual_SW3 = summary_annual_SW3;
    }
    public String getSummary_annual_SW4() {
        return summary_annual_SW4;
    }
    public void setSummary_annual_SW4(String summary_annual_SW4) {
        this.summary_annual_SW4 = summary_annual_SW4;
    }
    public String getSummary_annual_SW5() {
        return summary_annual_SW5;
    }
    public void setSummary_annual_SW5(String summary_annual_SW5) {
        this.summary_annual_SW5 = summary_annual_SW5;
    }
    public String getHPRD_nursing_total1() {
        return HPRD_nursing_total1;
    }
    public void setHPRD_nursing_total1(String hPRD_nursing_total1) {
        HPRD_nursing_total1 = hPRD_nursing_total1;
    }
    public String getHPRD_nursing_total2() {
        return HPRD_nursing_total2;
    }
    public void setHPRD_nursing_total2(String hPRD_nursing_total2) {
        HPRD_nursing_total2 = hPRD_nursing_total2;
    }
    public String getHPRD_nursing_total3() {
        return HPRD_nursing_total3;
    }
    public void setHPRD_nursing_total3(String hPRD_nursing_total3) {
        HPRD_nursing_total3 = hPRD_nursing_total3;
    }
    public String getHPRD_nursing_total4() {
        return HPRD_nursing_total4;
    }
    public void setHPRD_nursing_total4(String hPRD_nursing_total4) {
        HPRD_nursing_total4 = hPRD_nursing_total4;
    }
    public String getHPRD_nursing_total5() {
        return HPRD_nursing_total5;
    }
    public void setHPRD_nursing_total5(String hPRD_nursing_total5) {
        HPRD_nursing_total5 = hPRD_nursing_total5;
    }
    public String getAlliedNP_fri_total1() {
        return alliedNP_fri_total1;
    }
    public void setAlliedNP_fri_total1(String alliedNP_fri_total1) {
        this.alliedNP_fri_total1 = alliedNP_fri_total1;
    }
    public String getAlliedNP_fri_total2() {
        return alliedNP_fri_total2;
    }
    public void setAlliedNP_fri_total2(String alliedNP_fri_total2) {
        this.alliedNP_fri_total2 = alliedNP_fri_total2;
    }
    public String getAlliedNP_fri_total3() {
        return alliedNP_fri_total3;
    }
    public void setAlliedNP_fri_total3(String alliedNP_fri_total3) {
        this.alliedNP_fri_total3 = alliedNP_fri_total3;
    }
    public String getAlliedNP_fri_total4() {
        return alliedNP_fri_total4;
    }
    public void setAlliedNP_fri_total4(String alliedNP_fri_total4) {
        this.alliedNP_fri_total4 = alliedNP_fri_total4;
    }
    public String getAlliedNP_fri_total5() {
        return alliedNP_fri_total5;
    }
    public void setAlliedNP_fri_total5(String alliedNP_fri_total5) {
        this.alliedNP_fri_total5 = alliedNP_fri_total5;
    }
    public String getAlliedNP_mon_total1() {
        return alliedNP_mon_total1;
    }
    public void setAlliedNP_mon_total1(String alliedNP_mon_total1) {
        this.alliedNP_mon_total1 = alliedNP_mon_total1;
    }
    public String getAlliedNP_mon_total2() {
        return alliedNP_mon_total2;
    }
    public void setAlliedNP_mon_total2(String alliedNP_mon_total2) {
        this.alliedNP_mon_total2 = alliedNP_mon_total2;
    }
    public String getAlliedNP_mon_total3() {
        return alliedNP_mon_total3;
    }
    public void setAlliedNP_mon_total3(String alliedNP_mon_total3) {
        this.alliedNP_mon_total3 = alliedNP_mon_total3;
    }
    public String getAlliedNP_mon_total4() {
        return alliedNP_mon_total4;
    }
    public void setAlliedNP_mon_total4(String alliedNP_mon_total4) {
        this.alliedNP_mon_total4 = alliedNP_mon_total4;
    }
    public String getAlliedNP_mon_total5() {
        return alliedNP_mon_total5;
    }
    public void setAlliedNP_mon_total5(String alliedNP_mon_total5) {
        this.alliedNP_mon_total5 = alliedNP_mon_total5;
    }
    public String getAlliedNP_sat_total1() {
        return alliedNP_sat_total1;
    }
    public void setAlliedNP_sat_total1(String alliedNP_sat_total1) {
        this.alliedNP_sat_total1 = alliedNP_sat_total1;
    }
    public String getAlliedNP_sat_total2() {
        return alliedNP_sat_total2;
    }
    public void setAlliedNP_sat_total2(String alliedNP_sat_total2) {
        this.alliedNP_sat_total2 = alliedNP_sat_total2;
    }
    public String getAlliedNP_sat_total3() {
        return alliedNP_sat_total3;
    }
    public void setAlliedNP_sat_total3(String alliedNP_sat_total3) {
        this.alliedNP_sat_total3 = alliedNP_sat_total3;
    }
    public String getAlliedNP_sat_total4() {
        return alliedNP_sat_total4;
    }
    public void setAlliedNP_sat_total4(String alliedNP_sat_total4) {
        this.alliedNP_sat_total4 = alliedNP_sat_total4;
    }
    public String getAlliedNP_sat_total5() {
        return alliedNP_sat_total5;
    }
    public void setAlliedNP_sat_total5(String alliedNP_sat_total5) {
        this.alliedNP_sat_total5 = alliedNP_sat_total5;
    }
    public String getAlliedNP_sun_total1() {
        return alliedNP_sun_total1;
    }
    public void setAlliedNP_sun_total1(String alliedNP_sun_total1) {
        this.alliedNP_sun_total1 = alliedNP_sun_total1;
    }
    public String getAlliedNP_sun_total2() {
        return alliedNP_sun_total2;
    }
    public void setAlliedNP_sun_total2(String alliedNP_sun_total2) {
        this.alliedNP_sun_total2 = alliedNP_sun_total2;
    }
    public String getAlliedNP_sun_total3() {
        return alliedNP_sun_total3;
    }
    public void setAlliedNP_sun_total3(String alliedNP_sun_total3) {
        this.alliedNP_sun_total3 = alliedNP_sun_total3;
    }
    public String getAlliedNP_sun_total4() {
        return alliedNP_sun_total4;
    }
    public void setAlliedNP_sun_total4(String alliedNP_sun_total4) {
        this.alliedNP_sun_total4 = alliedNP_sun_total4;
    }
    public String getAlliedNP_sun_total5() {
        return alliedNP_sun_total5;
    }
    public void setAlliedNP_sun_total5(String alliedNP_sun_total5) {
        this.alliedNP_sun_total5 = alliedNP_sun_total5;
    }
    public String getAlliedNP_thu_total1() {
        return alliedNP_thu_total1;
    }
    public void setAlliedNP_thu_total1(String alliedNP_thu_total1) {
        this.alliedNP_thu_total1 = alliedNP_thu_total1;
    }
    public String getAlliedNP_thu_total2() {
        return alliedNP_thu_total2;
    }
    public void setAlliedNP_thu_total2(String alliedNP_thu_total2) {
        this.alliedNP_thu_total2 = alliedNP_thu_total2;
    }
    public String getAlliedNP_thu_total3() {
        return alliedNP_thu_total3;
    }
    public void setAlliedNP_thu_total3(String alliedNP_thu_total3) {
        this.alliedNP_thu_total3 = alliedNP_thu_total3;
    }
    public String getAlliedNP_thu_total4() {
        return alliedNP_thu_total4;
    }
    public void setAlliedNP_thu_total4(String alliedNP_thu_total4) {
        this.alliedNP_thu_total4 = alliedNP_thu_total4;
    }
    public String getAlliedNP_thu_total5() {
        return alliedNP_thu_total5;
    }
    public void setAlliedNP_thu_total5(String alliedNP_thu_total5) {
        this.alliedNP_thu_total5 = alliedNP_thu_total5;
    }
    public String getAlliedNP_tue_total1() {
        return alliedNP_tue_total1;
    }
    public void setAlliedNP_tue_total1(String alliedNP_tue_total1) {
        this.alliedNP_tue_total1 = alliedNP_tue_total1;
    }
    public String getAlliedNP_tue_total2() {
        return alliedNP_tue_total2;
    }
    public void setAlliedNP_tue_total2(String alliedNP_tue_total2) {
        this.alliedNP_tue_total2 = alliedNP_tue_total2;
    }
    public String getAlliedNP_tue_total3() {
        return alliedNP_tue_total3;
    }
    public void setAlliedNP_tue_total3(String alliedNP_tue_total3) {
        this.alliedNP_tue_total3 = alliedNP_tue_total3;
    }
    public String getAlliedNP_tue_total4() {
        return alliedNP_tue_total4;
    }
    public void setAlliedNP_tue_total4(String alliedNP_tue_total4) {
        this.alliedNP_tue_total4 = alliedNP_tue_total4;
    }
    public String getAlliedNP_tue_total5() {
        return alliedNP_tue_total5;
    }
    public void setAlliedNP_tue_total5(String alliedNP_tue_total5) {
        this.alliedNP_tue_total5 = alliedNP_tue_total5;
    }
    public String getAlliedNP_wed_total1() {
        return alliedNP_wed_total1;
    }
    public void setAlliedNP_wed_total1(String alliedNP_wed_total1) {
        this.alliedNP_wed_total1 = alliedNP_wed_total1;
    }
    public String getAlliedNP_wed_total2() {
        return alliedNP_wed_total2;
    }
    public void setAlliedNP_wed_total2(String alliedNP_wed_total2) {
        this.alliedNP_wed_total2 = alliedNP_wed_total2;
    }
    public String getAlliedNP_wed_total3() {
        return alliedNP_wed_total3;
    }
    public void setAlliedNP_wed_total3(String alliedNP_wed_total3) {
        this.alliedNP_wed_total3 = alliedNP_wed_total3;
    }
    public String getAlliedNP_wed_total4() {
        return alliedNP_wed_total4;
    }
    public void setAlliedNP_wed_total4(String alliedNP_wed_total4) {
        this.alliedNP_wed_total4 = alliedNP_wed_total4;
    }
    public String getAlliedNP_wed_total5() {
        return alliedNP_wed_total5;
    }
    public void setAlliedNP_wed_total5(String alliedNP_wed_total5) {
        this.alliedNP_wed_total5 = alliedNP_wed_total5;
    }
    public String getContractedOut_resp1() {
        return contractedOut_resp1;
    }
    public void setContractedOut_resp1(String contractedOut_resp1) {
        this.contractedOut_resp1 = contractedOut_resp1;
    }
    public String getContractedOut_resp2() {
        return contractedOut_resp2;
    }
    public void setContractedOut_resp2(String contractedOut_resp2) {
        this.contractedOut_resp2 = contractedOut_resp2;
    }
    public String getContractedOut_resp3() {
        return contractedOut_resp3;
    }
    public void setContractedOut_resp3(String contractedOut_resp3) {
        this.contractedOut_resp3 = contractedOut_resp3;
    }
    public String getContractedOut_resp4() {
        return contractedOut_resp4;
    }
    public void setContractedOut_resp4(String contractedOut_resp4) {
        this.contractedOut_resp4 = contractedOut_resp4;
    }
    public String getContractedOut_resp5() {
        return contractedOut_resp5;
    }
    public void setContractedOut_resp5(String contractedOut_resp5) {
        this.contractedOut_resp5 = contractedOut_resp5;
    }
    public String getNursing_week_total1() {
        return nursing_week_total1;
    }
    public void setNursing_week_total1(String nursing_week_total1) {
        this.nursing_week_total1 = nursing_week_total1;
    }
    public String getNursing_week_total2() {
        return nursing_week_total2;
    }
    public void setNursing_week_total2(String nursing_week_total2) {
        this.nursing_week_total2 = nursing_week_total2;
    }
    public String getNursing_week_total3() {
        return nursing_week_total3;
    }
    public void setNursing_week_total3(String nursing_week_total3) {
        this.nursing_week_total3 = nursing_week_total3;
    }
    public String getNursing_week_total4() {
        return nursing_week_total4;
    }
    public void setNursing_week_total4(String nursing_week_total4) {
        this.nursing_week_total4 = nursing_week_total4;
    }
    public String getNursing_week_total5() {
        return nursing_week_total5;
    }
    public void setNursing_week_total5(String nursing_week_total5) {
        this.nursing_week_total5 = nursing_week_total5;
    }
    public String getPercentageOut_resp1() {
        return percentageOut_resp1;
    }
    public void setPercentageOut_resp1(String percentageOut_resp1) {
        this.percentageOut_resp1 = percentageOut_resp1;
    }
    public String getPercentageOut_resp2() {
        return percentageOut_resp2;
    }
    public void setPercentageOut_resp2(String percentageOut_resp2) {
        this.percentageOut_resp2 = percentageOut_resp2;
    }
    public String getPercentageOut_resp3() {
        return percentageOut_resp3;
    }
    public void setPercentageOut_resp3(String percentageOut_resp3) {
        this.percentageOut_resp3 = percentageOut_resp3;
    }
    public String getPercentageOut_resp4() {
        return percentageOut_resp4;
    }
    public void setPercentageOut_resp4(String percentageOut_resp4) {
        this.percentageOut_resp4 = percentageOut_resp4;
    }
    public String getPercentageOut_resp5() {
        return percentageOut_resp5;
    }
    public void setPercentageOut_resp5(String percentageOut_resp5) {
        this.percentageOut_resp5 = percentageOut_resp5;
    }
    public String getSummary_annual_HCA1() {
        return summary_annual_HCA1;
    }
    public void setSummary_annual_HCA1(String summary_annual_HCA1) {
        this.summary_annual_HCA1 = summary_annual_HCA1;
    }
    public String getSummary_annual_HCA2() {
        return summary_annual_HCA2;
    }
    public void setSummary_annual_HCA2(String summary_annual_HCA2) {
        this.summary_annual_HCA2 = summary_annual_HCA2;
    }
    public String getSummary_annual_HCA3() {
        return summary_annual_HCA3;
    }
    public void setSummary_annual_HCA3(String summary_annual_HCA3) {
        this.summary_annual_HCA3 = summary_annual_HCA3;
    }
    public String getSummary_annual_HCA4() {
        return summary_annual_HCA4;
    }
    public void setSummary_annual_HCA4(String summary_annual_HCA4) {
        this.summary_annual_HCA4 = summary_annual_HCA4;
    }
    public String getSummary_annual_HCA5() {
        return summary_annual_HCA5;
    }
    public void setSummary_annual_HCA5(String summary_annual_HCA5) {
        this.summary_annual_HCA5 = summary_annual_HCA5;
    }
    public String getSummary_annual_LPN1() {
        return summary_annual_LPN1;
    }
    public void setSummary_annual_LPN1(String summary_annual_LPN1) {
        this.summary_annual_LPN1 = summary_annual_LPN1;
    }
    public String getSummary_annual_LPN2() {
        return summary_annual_LPN2;
    }
    public void setSummary_annual_LPN2(String summary_annual_LPN2) {
        this.summary_annual_LPN2 = summary_annual_LPN2;
    }
    public String getSummary_annual_LPN3() {
        return summary_annual_LPN3;
    }
    public void setSummary_annual_LPN3(String summary_annual_LPN3) {
        this.summary_annual_LPN3 = summary_annual_LPN3;
    }
    public String getSummary_annual_LPN4() {
        return summary_annual_LPN4;
    }
    public void setSummary_annual_LPN4(String summary_annual_LPN4) {
        this.summary_annual_LPN4 = summary_annual_LPN4;
    }
    public String getSummary_annual_LPN5() {
        return summary_annual_LPN5;
    }
    public void setSummary_annual_LPN5(String summary_annual_LPN5) {
        this.summary_annual_LPN5 = summary_annual_LPN5;
    }
    public String getSummary_contracted1() {
        return summary_contracted1;
    }
    public void setSummary_contracted1(String summary_contracted1) {
        this.summary_contracted1 = summary_contracted1;
    }
    public String getSummary_contracted2() {
        return summary_contracted2;
    }
    public void setSummary_contracted2(String summary_contracted2) {
        this.summary_contracted2 = summary_contracted2;
    }
    public String getSummary_contracted3() {
        return summary_contracted3;
    }
    public void setSummary_contracted3(String summary_contracted3) {
        this.summary_contracted3 = summary_contracted3;
    }
    public String getSummary_contracted4() {
        return summary_contracted4;
    }
    public void setSummary_contracted4(String summary_contracted4) {
        this.summary_contracted4 = summary_contracted4;
    }
    public String getSummary_contracted5() {
        return summary_contracted5;
    }
    public void setSummary_contracted5(String summary_contracted5) {
        this.summary_contracted5 = summary_contracted5;
    }
    public String getSummary_inHouse_AT1() {
        return summary_inHouse_AT1;
    }
    public void setSummary_inHouse_AT1(String summary_inHouse_AT1) {
        this.summary_inHouse_AT1 = summary_inHouse_AT1;
    }
    public String getSummary_inHouse_AT2() {
        return summary_inHouse_AT2;
    }
    public void setSummary_inHouse_AT2(String summary_inHouse_AT2) {
        this.summary_inHouse_AT2 = summary_inHouse_AT2;
    }
    public String getSummary_inHouse_AT3() {
        return summary_inHouse_AT3;
    }
    public void setSummary_inHouse_AT3(String summary_inHouse_AT3) {
        this.summary_inHouse_AT3 = summary_inHouse_AT3;
    }
    public String getSummary_inHouse_AT4() {
        return summary_inHouse_AT4;
    }
    public void setSummary_inHouse_AT4(String summary_inHouse_AT4) {
        this.summary_inHouse_AT4 = summary_inHouse_AT4;
    }
    public String getSummary_inHouse_AT5() {
        return summary_inHouse_AT5;
    }
    public void setSummary_inHouse_AT5(String summary_inHouse_AT5) {
        this.summary_inHouse_AT5 = summary_inHouse_AT5;
    }
    public String getSummary_inHouse_AW1() {
        return summary_inHouse_AW1;
    }
    public void setSummary_inHouse_AW1(String summary_inHouse_AW1) {
        this.summary_inHouse_AW1 = summary_inHouse_AW1;
    }
    public String getSummary_inHouse_AW2() {
        return summary_inHouse_AW2;
    }
    public void setSummary_inHouse_AW2(String summary_inHouse_AW2) {
        this.summary_inHouse_AW2 = summary_inHouse_AW2;
    }
    public String getSummary_inHouse_AW3() {
        return summary_inHouse_AW3;
    }
    public void setSummary_inHouse_AW3(String summary_inHouse_AW3) {
        this.summary_inHouse_AW3 = summary_inHouse_AW3;
    }
    public String getSummary_inHouse_AW4() {
        return summary_inHouse_AW4;
    }
    public void setSummary_inHouse_AW4(String summary_inHouse_AW4) {
        this.summary_inHouse_AW4 = summary_inHouse_AW4;
    }
    public String getSummary_inHouse_AW5() {
        return summary_inHouse_AW5;
    }
    public void setSummary_inHouse_AW5(String summary_inHouse_AW5) {
        this.summary_inHouse_AW5 = summary_inHouse_AW5;
    }
    public String getSummary_inHouse_DT1() {
        return summary_inHouse_DT1;
    }
    public void setSummary_inHouse_DT1(String summary_inHouse_DT1) {
        this.summary_inHouse_DT1 = summary_inHouse_DT1;
    }
    public String getSummary_inHouse_DT2() {
        return summary_inHouse_DT2;
    }
    public void setSummary_inHouse_DT2(String summary_inHouse_DT2) {
        this.summary_inHouse_DT2 = summary_inHouse_DT2;
    }
    public String getSummary_inHouse_DT3() {
        return summary_inHouse_DT3;
    }
    public void setSummary_inHouse_DT3(String summary_inHouse_DT3) {
        this.summary_inHouse_DT3 = summary_inHouse_DT3;
    }
    public String getSummary_inHouse_DT4() {
        return summary_inHouse_DT4;
    }
    public void setSummary_inHouse_DT4(String summary_inHouse_DT4) {
        this.summary_inHouse_DT4 = summary_inHouse_DT4;
    }
    public String getSummary_inHouse_DT5() {
        return summary_inHouse_DT5;
    }
    public void setSummary_inHouse_DT5(String summary_inHouse_DT5) {
        this.summary_inHouse_DT5 = summary_inHouse_DT5;
    }
    public String getSummary_inHouse_MT1() {
        return summary_inHouse_MT1;
    }
    public void setSummary_inHouse_MT1(String summary_inHouse_MT1) {
        this.summary_inHouse_MT1 = summary_inHouse_MT1;
    }
    public String getSummary_inHouse_MT2() {
        return summary_inHouse_MT2;
    }
    public void setSummary_inHouse_MT2(String summary_inHouse_MT2) {
        this.summary_inHouse_MT2 = summary_inHouse_MT2;
    }
    public String getSummary_inHouse_MT3() {
        return summary_inHouse_MT3;
    }
    public void setSummary_inHouse_MT3(String summary_inHouse_MT3) {
        this.summary_inHouse_MT3 = summary_inHouse_MT3;
    }
    public String getSummary_inHouse_MT4() {
        return summary_inHouse_MT4;
    }
    public void setSummary_inHouse_MT4(String summary_inHouse_MT4) {
        this.summary_inHouse_MT4 = summary_inHouse_MT4;
    }
    public String getSummary_inHouse_MT5() {
        return summary_inHouse_MT5;
    }
    public void setSummary_inHouse_MT5(String summary_inHouse_MT5) {
        this.summary_inHouse_MT5 = summary_inHouse_MT5;
    }
    public String getSummary_inHouse_OT1() {
        return summary_inHouse_OT1;
    }
    public void setSummary_inHouse_OT1(String summary_inHouse_OT1) {
        this.summary_inHouse_OT1 = summary_inHouse_OT1;
    }
    public String getSummary_inHouse_OT2() {
        return summary_inHouse_OT2;
    }
    public void setSummary_inHouse_OT2(String summary_inHouse_OT2) {
        this.summary_inHouse_OT2 = summary_inHouse_OT2;
    }
    public String getSummary_inHouse_OT3() {
        return summary_inHouse_OT3;
    }
    public void setSummary_inHouse_OT3(String summary_inHouse_OT3) {
        this.summary_inHouse_OT3 = summary_inHouse_OT3;
    }
    public String getSummary_inHouse_OT4() {
        return summary_inHouse_OT4;
    }
    public void setSummary_inHouse_OT4(String summary_inHouse_OT4) {
        this.summary_inHouse_OT4 = summary_inHouse_OT4;
    }
    public String getSummary_inHouse_OT5() {
        return summary_inHouse_OT5;
    }
    public void setSummary_inHouse_OT5(String summary_inHouse_OT5) {
        this.summary_inHouse_OT5 = summary_inHouse_OT5;
    }
    public String getSummary_inHouse_PT1() {
        return summary_inHouse_PT1;
    }
    public void setSummary_inHouse_PT1(String summary_inHouse_PT1) {
        this.summary_inHouse_PT1 = summary_inHouse_PT1;
    }
    public String getSummary_inHouse_PT2() {
        return summary_inHouse_PT2;
    }
    public void setSummary_inHouse_PT2(String summary_inHouse_PT2) {
        this.summary_inHouse_PT2 = summary_inHouse_PT2;
    }
    public String getSummary_inHouse_PT3() {
        return summary_inHouse_PT3;
    }
    public void setSummary_inHouse_PT3(String summary_inHouse_PT3) {
        this.summary_inHouse_PT3 = summary_inHouse_PT3;
    }
    public String getSummary_inHouse_PT4() {
        return summary_inHouse_PT4;
    }
    public void setSummary_inHouse_PT4(String summary_inHouse_PT4) {
        this.summary_inHouse_PT4 = summary_inHouse_PT4;
    }
    public String getSummary_inHouse_PT5() {
        return summary_inHouse_PT5;
    }
    public void setSummary_inHouse_PT5(String summary_inHouse_PT5) {
        this.summary_inHouse_PT5 = summary_inHouse_PT5;
    }
    public String getSummary_inHouse_RA1() {
        return summary_inHouse_RA1;
    }
    public void setSummary_inHouse_RA1(String summary_inHouse_RA1) {
        this.summary_inHouse_RA1 = summary_inHouse_RA1;
    }
    public String getSummary_inHouse_RA2() {
        return summary_inHouse_RA2;
    }
    public void setSummary_inHouse_RA2(String summary_inHouse_RA2) {
        this.summary_inHouse_RA2 = summary_inHouse_RA2;
    }
    public String getSummary_inHouse_RA3() {
        return summary_inHouse_RA3;
    }
    public void setSummary_inHouse_RA3(String summary_inHouse_RA3) {
        this.summary_inHouse_RA3 = summary_inHouse_RA3;
    }
    public String getSummary_inHouse_RA4() {
        return summary_inHouse_RA4;
    }
    public void setSummary_inHouse_RA4(String summary_inHouse_RA4) {
        this.summary_inHouse_RA4 = summary_inHouse_RA4;
    }
    public String getSummary_inHouse_RA5() {
        return summary_inHouse_RA5;
    }
    public void setSummary_inHouse_RA5(String summary_inHouse_RA5) {
        this.summary_inHouse_RA5 = summary_inHouse_RA5;
    }
    public String getSummary_inHouse_RN1() {
        return summary_inHouse_RN1;
    }
    public void setSummary_inHouse_RN1(String summary_inHouse_RN1) {
        this.summary_inHouse_RN1 = summary_inHouse_RN1;
    }
    public String getSummary_inHouse_RN2() {
        return summary_inHouse_RN2;
    }
    public void setSummary_inHouse_RN2(String summary_inHouse_RN2) {
        this.summary_inHouse_RN2 = summary_inHouse_RN2;
    }
    public String getSummary_inHouse_RN3() {
        return summary_inHouse_RN3;
    }
    public void setSummary_inHouse_RN3(String summary_inHouse_RN3) {
        this.summary_inHouse_RN3 = summary_inHouse_RN3;
    }
    public String getSummary_inHouse_RN4() {
        return summary_inHouse_RN4;
    }
    public void setSummary_inHouse_RN4(String summary_inHouse_RN4) {
        this.summary_inHouse_RN4 = summary_inHouse_RN4;
    }
    public String getSummary_inHouse_RN5() {
        return summary_inHouse_RN5;
    }
    public void setSummary_inHouse_RN5(String summary_inHouse_RN5) {
        this.summary_inHouse_RN5 = summary_inHouse_RN5;
    }
    public String getSummary_inHouse_RT1() {
        return summary_inHouse_RT1;
    }
    public void setSummary_inHouse_RT1(String summary_inHouse_RT1) {
        this.summary_inHouse_RT1 = summary_inHouse_RT1;
    }
    public String getSummary_inHouse_RT2() {
        return summary_inHouse_RT2;
    }
    public void setSummary_inHouse_RT2(String summary_inHouse_RT2) {
        this.summary_inHouse_RT2 = summary_inHouse_RT2;
    }
    public String getSummary_inHouse_RT3() {
        return summary_inHouse_RT3;
    }
    public void setSummary_inHouse_RT3(String summary_inHouse_RT3) {
        this.summary_inHouse_RT3 = summary_inHouse_RT3;
    }
    public String getSummary_inHouse_RT4() {
        return summary_inHouse_RT4;
    }
    public void setSummary_inHouse_RT4(String summary_inHouse_RT4) {
        this.summary_inHouse_RT4 = summary_inHouse_RT4;
    }
    public String getSummary_inHouse_RT5() {
        return summary_inHouse_RT5;
    }
    public void setSummary_inHouse_RT5(String summary_inHouse_RT5) {
        this.summary_inHouse_RT5 = summary_inHouse_RT5;
    }
    public String getSummary_inHouse_SL1() {
        return summary_inHouse_SL1;
    }
    public void setSummary_inHouse_SL1(String summary_inHouse_SL1) {
        this.summary_inHouse_SL1 = summary_inHouse_SL1;
    }
    public String getSummary_inHouse_SL2() {
        return summary_inHouse_SL2;
    }
    public void setSummary_inHouse_SL2(String summary_inHouse_SL2) {
        this.summary_inHouse_SL2 = summary_inHouse_SL2;
    }
    public String getSummary_inHouse_SL3() {
        return summary_inHouse_SL3;
    }
    public void setSummary_inHouse_SL3(String summary_inHouse_SL3) {
        this.summary_inHouse_SL3 = summary_inHouse_SL3;
    }
    public String getSummary_inHouse_SL4() {
        return summary_inHouse_SL4;
    }
    public void setSummary_inHouse_SL4(String summary_inHouse_SL4) {
        this.summary_inHouse_SL4 = summary_inHouse_SL4;
    }
    public String getSummary_inHouse_SL5() {
        return summary_inHouse_SL5;
    }
    public void setSummary_inHouse_SL5(String summary_inHouse_SL5) {
        this.summary_inHouse_SL5 = summary_inHouse_SL5;
    }
    public String getSummary_inHouse_SW1() {
        return summary_inHouse_SW1;
    }
    public void setSummary_inHouse_SW1(String summary_inHouse_SW1) {
        this.summary_inHouse_SW1 = summary_inHouse_SW1;
    }
    public String getSummary_inHouse_SW2() {
        return summary_inHouse_SW2;
    }
    public void setSummary_inHouse_SW2(String summary_inHouse_SW2) {
        this.summary_inHouse_SW2 = summary_inHouse_SW2;
    }
    public String getSummary_inHouse_SW3() {
        return summary_inHouse_SW3;
    }
    public void setSummary_inHouse_SW3(String summary_inHouse_SW3) {
        this.summary_inHouse_SW3 = summary_inHouse_SW3;
    }
    public String getSummary_inHouse_SW4() {
        return summary_inHouse_SW4;
    }
    public void setSummary_inHouse_SW4(String summary_inHouse_SW4) {
        this.summary_inHouse_SW4 = summary_inHouse_SW4;
    }
    public String getSummary_inHouse_SW5() {
        return summary_inHouse_SW5;
    }
    public void setSummary_inHouse_SW5(String summary_inHouse_SW5) {
        this.summary_inHouse_SW5 = summary_inHouse_SW5;
    }
    public String getAldnop_annual_total1() {
        return aldnop_annual_total1;
    }
    public void setAldnop_annual_total1(String aldnop_annual_total1) {
        this.aldnop_annual_total1 = aldnop_annual_total1;
    }
    public String getAldnop_annual_total2() {
        return aldnop_annual_total2;
    }
    public void setAldnop_annual_total2(String aldnop_annual_total2) {
        this.aldnop_annual_total2 = aldnop_annual_total2;
    }
    public String getAldnop_annual_total3() {
        return aldnop_annual_total3;
    }
    public void setAldnop_annual_total3(String aldnop_annual_total3) {
        this.aldnop_annual_total3 = aldnop_annual_total3;
    }
    public String getAldnop_annual_total4() {
        return aldnop_annual_total4;
    }
    public void setAldnop_annual_total4(String aldnop_annual_total4) {
        this.aldnop_annual_total4 = aldnop_annual_total4;
    }
    public String getAldnop_annual_total5() {
        return aldnop_annual_total5;
    }
    public void setAldnop_annual_total5(String aldnop_annual_total5) {
        this.aldnop_annual_total5 = aldnop_annual_total5;
    }
    public String getAlliedNP_week_total1() {
        return alliedNP_week_total1;
    }
    public void setAlliedNP_week_total1(String alliedNP_week_total1) {
        this.alliedNP_week_total1 = alliedNP_week_total1;
    }
    public String getAlliedNP_week_total2() {
        return alliedNP_week_total2;
    }
    public void setAlliedNP_week_total2(String alliedNP_week_total2) {
        this.alliedNP_week_total2 = alliedNP_week_total2;
    }
    public String getAlliedNP_week_total3() {
        return alliedNP_week_total3;
    }
    public void setAlliedNP_week_total3(String alliedNP_week_total3) {
        this.alliedNP_week_total3 = alliedNP_week_total3;
    }
    public String getAlliedNP_week_total4() {
        return alliedNP_week_total4;
    }
    public void setAlliedNP_week_total4(String alliedNP_week_total4) {
        this.alliedNP_week_total4 = alliedNP_week_total4;
    }
    public String getAlliedNP_week_total5() {
        return alliedNP_week_total5;
    }
    public void setAlliedNP_week_total5(String alliedNP_week_total5) {
        this.alliedNP_week_total5 = alliedNP_week_total5;
    }
    public String getAllied_annual_total1() {
        return allied_annual_total1;
    }
    public void setAllied_annual_total1(String allied_annual_total1) {
        this.allied_annual_total1 = allied_annual_total1;
    }
    public String getAllied_annual_total2() {
        return allied_annual_total2;
    }
    public void setAllied_annual_total2(String allied_annual_total2) {
        this.allied_annual_total2 = allied_annual_total2;
    }
    public String getAllied_annual_total3() {
        return allied_annual_total3;
    }
    public void setAllied_annual_total3(String allied_annual_total3) {
        this.allied_annual_total3 = allied_annual_total3;
    }
    public String getAllied_annual_total4() {
        return allied_annual_total4;
    }
    public void setAllied_annual_total4(String allied_annual_total4) {
        this.allied_annual_total4 = allied_annual_total4;
    }
    public String getAllied_annual_total5() {
        return allied_annual_total5;
    }
    public void setAllied_annual_total5(String allied_annual_total5) {
        this.allied_annual_total5 = allied_annual_total5;
    }
    public String getSummary_annual_resp1() {
        return summary_annual_resp1;
    }
    public void setSummary_annual_resp1(String summary_annual_resp1) {
        this.summary_annual_resp1 = summary_annual_resp1;
    }
    public String getSummary_annual_resp2() {
        return summary_annual_resp2;
    }
    public void setSummary_annual_resp2(String summary_annual_resp2) {
        this.summary_annual_resp2 = summary_annual_resp2;
    }
    public String getSummary_annual_resp3() {
        return summary_annual_resp3;
    }
    public void setSummary_annual_resp3(String summary_annual_resp3) {
        this.summary_annual_resp3 = summary_annual_resp3;
    }
    public String getSummary_annual_resp4() {
        return summary_annual_resp4;
    }
    public void setSummary_annual_resp4(String summary_annual_resp4) {
        this.summary_annual_resp4 = summary_annual_resp4;
    }
    public String getSummary_annual_resp5() {
        return summary_annual_resp5;
    }
    public void setSummary_annual_resp5(String summary_annual_resp5) {
        this.summary_annual_resp5 = summary_annual_resp5;
    }
    public String getSummary_inHouse_HCA1() {
        return summary_inHouse_HCA1;
    }
    public void setSummary_inHouse_HCA1(String summary_inHouse_HCA1) {
        this.summary_inHouse_HCA1 = summary_inHouse_HCA1;
    }
    public String getSummary_inHouse_HCA2() {
        return summary_inHouse_HCA2;
    }
    public void setSummary_inHouse_HCA2(String summary_inHouse_HCA2) {
        this.summary_inHouse_HCA2 = summary_inHouse_HCA2;
    }
    public String getSummary_inHouse_HCA3() {
        return summary_inHouse_HCA3;
    }
    public void setSummary_inHouse_HCA3(String summary_inHouse_HCA3) {
        this.summary_inHouse_HCA3 = summary_inHouse_HCA3;
    }
    public String getSummary_inHouse_HCA4() {
        return summary_inHouse_HCA4;
    }
    public void setSummary_inHouse_HCA4(String summary_inHouse_HCA4) {
        this.summary_inHouse_HCA4 = summary_inHouse_HCA4;
    }
    public String getSummary_inHouse_HCA5() {
        return summary_inHouse_HCA5;
    }
    public void setSummary_inHouse_HCA5(String summary_inHouse_HCA5) {
        this.summary_inHouse_HCA5 = summary_inHouse_HCA5;
    }
    public String getSummary_inHouse_LPN1() {
        return summary_inHouse_LPN1;
    }
    public void setSummary_inHouse_LPN1(String summary_inHouse_LPN1) {
        this.summary_inHouse_LPN1 = summary_inHouse_LPN1;
    }
    public String getSummary_inHouse_LPN2() {
        return summary_inHouse_LPN2;
    }
    public void setSummary_inHouse_LPN2(String summary_inHouse_LPN2) {
        this.summary_inHouse_LPN2 = summary_inHouse_LPN2;
    }
    public String getSummary_inHouse_LPN3() {
        return summary_inHouse_LPN3;
    }
    public void setSummary_inHouse_LPN3(String summary_inHouse_LPN3) {
        this.summary_inHouse_LPN3 = summary_inHouse_LPN3;
    }
    public String getSummary_inHouse_LPN4() {
        return summary_inHouse_LPN4;
    }
    public void setSummary_inHouse_LPN4(String summary_inHouse_LPN4) {
        this.summary_inHouse_LPN4 = summary_inHouse_LPN4;
    }
    public String getSummary_inHouse_LPN5() {
        return summary_inHouse_LPN5;
    }
    public void setSummary_inHouse_LPN5(String summary_inHouse_LPN5) {
        this.summary_inHouse_LPN5 = summary_inHouse_LPN5;
    }
    public String getAlliedProf_fri_total1() {
        return alliedProf_fri_total1;
    }
    public void setAlliedProf_fri_total1(String alliedProf_fri_total1) {
        this.alliedProf_fri_total1 = alliedProf_fri_total1;
    }
    public String getAlliedProf_fri_total2() {
        return alliedProf_fri_total2;
    }
    public void setAlliedProf_fri_total2(String alliedProf_fri_total2) {
        this.alliedProf_fri_total2 = alliedProf_fri_total2;
    }
    public String getAlliedProf_fri_total3() {
        return alliedProf_fri_total3;
    }
    public void setAlliedProf_fri_total3(String alliedProf_fri_total3) {
        this.alliedProf_fri_total3 = alliedProf_fri_total3;
    }
    public String getAlliedProf_fri_total4() {
        return alliedProf_fri_total4;
    }
    public void setAlliedProf_fri_total4(String alliedProf_fri_total4) {
        this.alliedProf_fri_total4 = alliedProf_fri_total4;
    }
    public String getAlliedProf_fri_total5() {
        return alliedProf_fri_total5;
    }
    public void setAlliedProf_fri_total5(String alliedProf_fri_total5) {
        this.alliedProf_fri_total5 = alliedProf_fri_total5;
    }
    public String getAlliedProf_mon_total1() {
        return alliedProf_mon_total1;
    }
    public void setAlliedProf_mon_total1(String alliedProf_mon_total1) {
        this.alliedProf_mon_total1 = alliedProf_mon_total1;
    }
    public String getAlliedProf_mon_total2() {
        return alliedProf_mon_total2;
    }
    public void setAlliedProf_mon_total2(String alliedProf_mon_total2) {
        this.alliedProf_mon_total2 = alliedProf_mon_total2;
    }
    public String getAlliedProf_mon_total3() {
        return alliedProf_mon_total3;
    }
    public void setAlliedProf_mon_total3(String alliedProf_mon_total3) {
        this.alliedProf_mon_total3 = alliedProf_mon_total3;
    }
    public String getAlliedProf_mon_total4() {
        return alliedProf_mon_total4;
    }
    public void setAlliedProf_mon_total4(String alliedProf_mon_total4) {
        this.alliedProf_mon_total4 = alliedProf_mon_total4;
    }
    public String getAlliedProf_mon_total5() {
        return alliedProf_mon_total5;
    }
    public void setAlliedProf_mon_total5(String alliedProf_mon_total5) {
        this.alliedProf_mon_total5 = alliedProf_mon_total5;
    }
    public String getAlliedProf_sat_total1() {
        return alliedProf_sat_total1;
    }
    public void setAlliedProf_sat_total1(String alliedProf_sat_total1) {
        this.alliedProf_sat_total1 = alliedProf_sat_total1;
    }
    public String getAlliedProf_sat_total2() {
        return alliedProf_sat_total2;
    }
    public void setAlliedProf_sat_total2(String alliedProf_sat_total2) {
        this.alliedProf_sat_total2 = alliedProf_sat_total2;
    }
    public String getAlliedProf_sat_total3() {
        return alliedProf_sat_total3;
    }
    public void setAlliedProf_sat_total3(String alliedProf_sat_total3) {
        this.alliedProf_sat_total3 = alliedProf_sat_total3;
    }
    public String getAlliedProf_sat_total4() {
        return alliedProf_sat_total4;
    }
    public void setAlliedProf_sat_total4(String alliedProf_sat_total4) {
        this.alliedProf_sat_total4 = alliedProf_sat_total4;
    }
    public String getAlliedProf_sat_total5() {
        return alliedProf_sat_total5;
    }
    public void setAlliedProf_sat_total5(String alliedProf_sat_total5) {
        this.alliedProf_sat_total5 = alliedProf_sat_total5;
    }
    public String getAlliedProf_sun_total1() {
        return alliedProf_sun_total1;
    }
    public void setAlliedProf_sun_total1(String alliedProf_sun_total1) {
        this.alliedProf_sun_total1 = alliedProf_sun_total1;
    }
    public String getAlliedProf_sun_total2() {
        return alliedProf_sun_total2;
    }
    public void setAlliedProf_sun_total2(String alliedProf_sun_total2) {
        this.alliedProf_sun_total2 = alliedProf_sun_total2;
    }
    public String getAlliedProf_sun_total3() {
        return alliedProf_sun_total3;
    }
    public void setAlliedProf_sun_total3(String alliedProf_sun_total3) {
        this.alliedProf_sun_total3 = alliedProf_sun_total3;
    }
    public String getAlliedProf_sun_total4() {
        return alliedProf_sun_total4;
    }
    public void setAlliedProf_sun_total4(String alliedProf_sun_total4) {
        this.alliedProf_sun_total4 = alliedProf_sun_total4;
    }
    public String getAlliedProf_sun_total5() {
        return alliedProf_sun_total5;
    }
    public void setAlliedProf_sun_total5(String alliedProf_sun_total5) {
        this.alliedProf_sun_total5 = alliedProf_sun_total5;
    }
    public String getAlliedProf_thu_total1() {
        return alliedProf_thu_total1;
    }
    public void setAlliedProf_thu_total1(String alliedProf_thu_total1) {
        this.alliedProf_thu_total1 = alliedProf_thu_total1;
    }
    public String getAlliedProf_thu_total2() {
        return alliedProf_thu_total2;
    }
    public void setAlliedProf_thu_total2(String alliedProf_thu_total2) {
        this.alliedProf_thu_total2 = alliedProf_thu_total2;
    }
    public String getAlliedProf_thu_total3() {
        return alliedProf_thu_total3;
    }
    public void setAlliedProf_thu_total3(String alliedProf_thu_total3) {
        this.alliedProf_thu_total3 = alliedProf_thu_total3;
    }
    public String getAlliedProf_thu_total4() {
        return alliedProf_thu_total4;
    }
    public void setAlliedProf_thu_total4(String alliedProf_thu_total4) {
        this.alliedProf_thu_total4 = alliedProf_thu_total4;
    }
    public String getAlliedProf_thu_total5() {
        return alliedProf_thu_total5;
    }
    public void setAlliedProf_thu_total5(String alliedProf_thu_total5) {
        this.alliedProf_thu_total5 = alliedProf_thu_total5;
    }
    public String getAlliedProf_tue_total1() {
        return alliedProf_tue_total1;
    }
    public void setAlliedProf_tue_total1(String alliedProf_tue_total1) {
        this.alliedProf_tue_total1 = alliedProf_tue_total1;
    }
    public String getAlliedProf_tue_total2() {
        return alliedProf_tue_total2;
    }
    public void setAlliedProf_tue_total2(String alliedProf_tue_total2) {
        this.alliedProf_tue_total2 = alliedProf_tue_total2;
    }
    public String getAlliedProf_tue_total3() {
        return alliedProf_tue_total3;
    }
    public void setAlliedProf_tue_total3(String alliedProf_tue_total3) {
        this.alliedProf_tue_total3 = alliedProf_tue_total3;
    }
    public String getAlliedProf_tue_total4() {
        return alliedProf_tue_total4;
    }
    public void setAlliedProf_tue_total4(String alliedProf_tue_total4) {
        this.alliedProf_tue_total4 = alliedProf_tue_total4;
    }
    public String getAlliedProf_tue_total5() {
        return alliedProf_tue_total5;
    }
    public void setAlliedProf_tue_total5(String alliedProf_tue_total5) {
        this.alliedProf_tue_total5 = alliedProf_tue_total5;
    }
    public String getAlliedProf_wed_total1() {
        return alliedProf_wed_total1;
    }
    public void setAlliedProf_wed_total1(String alliedProf_wed_total1) {
        this.alliedProf_wed_total1 = alliedProf_wed_total1;
    }
    public String getAlliedProf_wed_total2() {
        return alliedProf_wed_total2;
    }
    public void setAlliedProf_wed_total2(String alliedProf_wed_total2) {
        this.alliedProf_wed_total2 = alliedProf_wed_total2;
    }
    public String getAlliedProf_wed_total3() {
        return alliedProf_wed_total3;
    }
    public void setAlliedProf_wed_total3(String alliedProf_wed_total3) {
        this.alliedProf_wed_total3 = alliedProf_wed_total3;
    }
    public String getAlliedProf_wed_total4() {
        return alliedProf_wed_total4;
    }
    public void setAlliedProf_wed_total4(String alliedProf_wed_total4) {
        this.alliedProf_wed_total4 = alliedProf_wed_total4;
    }
    public String getAlliedProf_wed_total5() {
        return alliedProf_wed_total5;
    }
    public void setAlliedProf_wed_total5(String alliedProf_wed_total5) {
        this.alliedProf_wed_total5 = alliedProf_wed_total5;
    }
    public String getNursing_annual_total1() {
        return nursing_annual_total1;
    }
    public void setNursing_annual_total1(String nursing_annual_total1) {
        this.nursing_annual_total1 = nursing_annual_total1;
    }
    public String getNursing_annual_total2() {
        return nursing_annual_total2;
    }
    public void setNursing_annual_total2(String nursing_annual_total2) {
        this.nursing_annual_total2 = nursing_annual_total2;
    }
    public String getNursing_annual_total3() {
        return nursing_annual_total3;
    }
    public void setNursing_annual_total3(String nursing_annual_total3) {
        this.nursing_annual_total3 = nursing_annual_total3;
    }
    public String getNursing_annual_total4() {
        return nursing_annual_total4;
    }
    public void setNursing_annual_total4(String nursing_annual_total4) {
        this.nursing_annual_total4 = nursing_annual_total4;
    }
    public String getNursing_annual_total5() {
        return nursing_annual_total5;
    }
    public void setNursing_annual_total5(String nursing_annual_total5) {
        this.nursing_annual_total5 = nursing_annual_total5;
    }
    public String getSummary_inHouse_resp1() {
        return summary_inHouse_resp1;
    }
    public void setSummary_inHouse_resp1(String summary_inHouse_resp1) {
        this.summary_inHouse_resp1 = summary_inHouse_resp1;
    }
    public String getSummary_inHouse_resp2() {
        return summary_inHouse_resp2;
    }
    public void setSummary_inHouse_resp2(String summary_inHouse_resp2) {
        this.summary_inHouse_resp2 = summary_inHouse_resp2;
    }
    public String getSummary_inHouse_resp3() {
        return summary_inHouse_resp3;
    }
    public void setSummary_inHouse_resp3(String summary_inHouse_resp3) {
        this.summary_inHouse_resp3 = summary_inHouse_resp3;
    }
    public String getSummary_inHouse_resp4() {
        return summary_inHouse_resp4;
    }
    public void setSummary_inHouse_resp4(String summary_inHouse_resp4) {
        this.summary_inHouse_resp4 = summary_inHouse_resp4;
    }
    public String getSummary_inHouse_resp5() {
        return summary_inHouse_resp5;
    }
    public void setSummary_inHouse_resp5(String summary_inHouse_resp5) {
        this.summary_inHouse_resp5 = summary_inHouse_resp5;
    }
    public String getAlliedNP_annual_total1() {
        return alliedNP_annual_total1;
    }
    public void setAlliedNP_annual_total1(String alliedNP_annual_total1) {
        this.alliedNP_annual_total1 = alliedNP_annual_total1;
    }
    public String getAlliedNP_annual_total2() {
        return alliedNP_annual_total2;
    }
    public void setAlliedNP_annual_total2(String alliedNP_annual_total2) {
        this.alliedNP_annual_total2 = alliedNP_annual_total2;
    }
    public String getAlliedNP_annual_total3() {
        return alliedNP_annual_total3;
    }
    public void setAlliedNP_annual_total3(String alliedNP_annual_total3) {
        this.alliedNP_annual_total3 = alliedNP_annual_total3;
    }
    public String getAlliedNP_annual_total4() {
        return alliedNP_annual_total4;
    }
    public void setAlliedNP_annual_total4(String alliedNP_annual_total4) {
        this.alliedNP_annual_total4 = alliedNP_annual_total4;
    }
    public String getAlliedNP_annual_total5() {
        return alliedNP_annual_total5;
    }
    public void setAlliedNP_annual_total5(String alliedNP_annual_total5) {
        this.alliedNP_annual_total5 = alliedNP_annual_total5;
    }
    public String getAlliedProf_week_total1() {
        return alliedProf_week_total1;
    }
    public void setAlliedProf_week_total1(String alliedProf_week_total1) {
        this.alliedProf_week_total1 = alliedProf_week_total1;
    }
    public String getAlliedProf_week_total2() {
        return alliedProf_week_total2;
    }
    public void setAlliedProf_week_total2(String alliedProf_week_total2) {
        this.alliedProf_week_total2 = alliedProf_week_total2;
    }
    public String getAlliedProf_week_total3() {
        return alliedProf_week_total3;
    }
    public void setAlliedProf_week_total3(String alliedProf_week_total3) {
        this.alliedProf_week_total3 = alliedProf_week_total3;
    }
    public String getAlliedProf_week_total4() {
        return alliedProf_week_total4;
    }
    public void setAlliedProf_week_total4(String alliedProf_week_total4) {
        this.alliedProf_week_total4 = alliedProf_week_total4;
    }
    public String getAlliedProf_week_total5() {
        return alliedProf_week_total5;
    }
    public void setAlliedProf_week_total5(String alliedProf_week_total5) {
        this.alliedProf_week_total5 = alliedProf_week_total5;
    }
    public String getProf_staff_percentage1() {
        return prof_staff_percentage1;
    }
    public void setProf_staff_percentage1(String prof_staff_percentage1) {
        this.prof_staff_percentage1 = prof_staff_percentage1;
    }
    public String getProf_staff_percentage2() {
        return prof_staff_percentage2;
    }
    public void setProf_staff_percentage2(String prof_staff_percentage2) {
        this.prof_staff_percentage2 = prof_staff_percentage2;
    }
    public String getProf_staff_percentage3() {
        return prof_staff_percentage3;
    }
    public void setProf_staff_percentage3(String prof_staff_percentage3) {
        this.prof_staff_percentage3 = prof_staff_percentage3;
    }
    public String getProf_staff_percentage4() {
        return prof_staff_percentage4;
    }
    public void setProf_staff_percentage4(String prof_staff_percentage4) {
        this.prof_staff_percentage4 = prof_staff_percentage4;
    }
    public String getProf_staff_percentage5() {
        return prof_staff_percentage5;
    }
    public void setProf_staff_percentage5(String prof_staff_percentage5) {
        this.prof_staff_percentage5 = prof_staff_percentage5;
    }
    public String getSummary_contracted_AT1() {
        return summary_contracted_AT1;
    }
    public void setSummary_contracted_AT1(String summary_contracted_AT1) {
        this.summary_contracted_AT1 = summary_contracted_AT1;
    }
    public String getSummary_contracted_AT2() {
        return summary_contracted_AT2;
    }
    public void setSummary_contracted_AT2(String summary_contracted_AT2) {
        this.summary_contracted_AT2 = summary_contracted_AT2;
    }
    public String getSummary_contracted_AT3() {
        return summary_contracted_AT3;
    }
    public void setSummary_contracted_AT3(String summary_contracted_AT3) {
        this.summary_contracted_AT3 = summary_contracted_AT3;
    }
    public String getSummary_contracted_AT4() {
        return summary_contracted_AT4;
    }
    public void setSummary_contracted_AT4(String summary_contracted_AT4) {
        this.summary_contracted_AT4 = summary_contracted_AT4;
    }
    public String getSummary_contracted_AT5() {
        return summary_contracted_AT5;
    }
    public void setSummary_contracted_AT5(String summary_contracted_AT5) {
        this.summary_contracted_AT5 = summary_contracted_AT5;
    }
    public String getSummary_contracted_AW1() {
        return summary_contracted_AW1;
    }
    public void setSummary_contracted_AW1(String summary_contracted_AW1) {
        this.summary_contracted_AW1 = summary_contracted_AW1;
    }
    public String getSummary_contracted_AW2() {
        return summary_contracted_AW2;
    }
    public void setSummary_contracted_AW2(String summary_contracted_AW2) {
        this.summary_contracted_AW2 = summary_contracted_AW2;
    }
    public String getSummary_contracted_AW3() {
        return summary_contracted_AW3;
    }
    public void setSummary_contracted_AW3(String summary_contracted_AW3) {
        this.summary_contracted_AW3 = summary_contracted_AW3;
    }
    public String getSummary_contracted_AW4() {
        return summary_contracted_AW4;
    }
    public void setSummary_contracted_AW4(String summary_contracted_AW4) {
        this.summary_contracted_AW4 = summary_contracted_AW4;
    }
    public String getSummary_contracted_AW5() {
        return summary_contracted_AW5;
    }
    public void setSummary_contracted_AW5(String summary_contracted_AW5) {
        this.summary_contracted_AW5 = summary_contracted_AW5;
    }
    public String getSummary_contracted_DT1() {
        return summary_contracted_DT1;
    }
    public void setSummary_contracted_DT1(String summary_contracted_DT1) {
        this.summary_contracted_DT1 = summary_contracted_DT1;
    }
    public String getSummary_contracted_DT2() {
        return summary_contracted_DT2;
    }
    public void setSummary_contracted_DT2(String summary_contracted_DT2) {
        this.summary_contracted_DT2 = summary_contracted_DT2;
    }
    public String getSummary_contracted_DT3() {
        return summary_contracted_DT3;
    }
    public void setSummary_contracted_DT3(String summary_contracted_DT3) {
        this.summary_contracted_DT3 = summary_contracted_DT3;
    }
    public String getSummary_contracted_DT4() {
        return summary_contracted_DT4;
    }
    public void setSummary_contracted_DT4(String summary_contracted_DT4) {
        this.summary_contracted_DT4 = summary_contracted_DT4;
    }
    public String getSummary_contracted_DT5() {
        return summary_contracted_DT5;
    }
    public void setSummary_contracted_DT5(String summary_contracted_DT5) {
        this.summary_contracted_DT5 = summary_contracted_DT5;
    }
    public String getSummary_contracted_MT1() {
        return summary_contracted_MT1;
    }
    public void setSummary_contracted_MT1(String summary_contracted_MT1) {
        this.summary_contracted_MT1 = summary_contracted_MT1;
    }
    public String getSummary_contracted_MT2() {
        return summary_contracted_MT2;
    }
    public void setSummary_contracted_MT2(String summary_contracted_MT2) {
        this.summary_contracted_MT2 = summary_contracted_MT2;
    }
    public String getSummary_contracted_MT3() {
        return summary_contracted_MT3;
    }
    public void setSummary_contracted_MT3(String summary_contracted_MT3) {
        this.summary_contracted_MT3 = summary_contracted_MT3;
    }
    public String getSummary_contracted_MT4() {
        return summary_contracted_MT4;
    }
    public void setSummary_contracted_MT4(String summary_contracted_MT4) {
        this.summary_contracted_MT4 = summary_contracted_MT4;
    }
    public String getSummary_contracted_MT5() {
        return summary_contracted_MT5;
    }
    public void setSummary_contracted_MT5(String summary_contracted_MT5) {
        this.summary_contracted_MT5 = summary_contracted_MT5;
    }
    public String getSummary_contracted_OT1() {
        return summary_contracted_OT1;
    }
    public void setSummary_contracted_OT1(String summary_contracted_OT1) {
        this.summary_contracted_OT1 = summary_contracted_OT1;
    }
    public String getSummary_contracted_OT2() {
        return summary_contracted_OT2;
    }
    public void setSummary_contracted_OT2(String summary_contracted_OT2) {
        this.summary_contracted_OT2 = summary_contracted_OT2;
    }
    public String getSummary_contracted_OT3() {
        return summary_contracted_OT3;
    }
    public void setSummary_contracted_OT3(String summary_contracted_OT3) {
        this.summary_contracted_OT3 = summary_contracted_OT3;
    }
    public String getSummary_contracted_OT4() {
        return summary_contracted_OT4;
    }
    public void setSummary_contracted_OT4(String summary_contracted_OT4) {
        this.summary_contracted_OT4 = summary_contracted_OT4;
    }
    public String getSummary_contracted_OT5() {
        return summary_contracted_OT5;
    }
    public void setSummary_contracted_OT5(String summary_contracted_OT5) {
        this.summary_contracted_OT5 = summary_contracted_OT5;
    }
    public String getSummary_contracted_PT1() {
        return summary_contracted_PT1;
    }
    public void setSummary_contracted_PT1(String summary_contracted_PT1) {
        this.summary_contracted_PT1 = summary_contracted_PT1;
    }
    public String getSummary_contracted_PT2() {
        return summary_contracted_PT2;
    }
    public void setSummary_contracted_PT2(String summary_contracted_PT2) {
        this.summary_contracted_PT2 = summary_contracted_PT2;
    }
    public String getSummary_contracted_PT3() {
        return summary_contracted_PT3;
    }
    public void setSummary_contracted_PT3(String summary_contracted_PT3) {
        this.summary_contracted_PT3 = summary_contracted_PT3;
    }
    public String getSummary_contracted_PT4() {
        return summary_contracted_PT4;
    }
    public void setSummary_contracted_PT4(String summary_contracted_PT4) {
        this.summary_contracted_PT4 = summary_contracted_PT4;
    }
    public String getSummary_contracted_PT5() {
        return summary_contracted_PT5;
    }
    public void setSummary_contracted_PT5(String summary_contracted_PT5) {
        this.summary_contracted_PT5 = summary_contracted_PT5;
    }
    public String getSummary_contracted_RA1() {
        return summary_contracted_RA1;
    }
    public void setSummary_contracted_RA1(String summary_contracted_RA1) {
        this.summary_contracted_RA1 = summary_contracted_RA1;
    }
    public String getSummary_contracted_RA2() {
        return summary_contracted_RA2;
    }
    public void setSummary_contracted_RA2(String summary_contracted_RA2) {
        this.summary_contracted_RA2 = summary_contracted_RA2;
    }
    public String getSummary_contracted_RA3() {
        return summary_contracted_RA3;
    }
    public void setSummary_contracted_RA3(String summary_contracted_RA3) {
        this.summary_contracted_RA3 = summary_contracted_RA3;
    }
    public String getSummary_contracted_RA4() {
        return summary_contracted_RA4;
    }
    public void setSummary_contracted_RA4(String summary_contracted_RA4) {
        this.summary_contracted_RA4 = summary_contracted_RA4;
    }
    public String getSummary_contracted_RA5() {
        return summary_contracted_RA5;
    }
    public void setSummary_contracted_RA5(String summary_contracted_RA5) {
        this.summary_contracted_RA5 = summary_contracted_RA5;
    }
    public String getSummary_contracted_RN1() {
        return summary_contracted_RN1;
    }
    public void setSummary_contracted_RN1(String summary_contracted_RN1) {
        this.summary_contracted_RN1 = summary_contracted_RN1;
    }
    public String getSummary_contracted_RN2() {
        return summary_contracted_RN2;
    }
    public void setSummary_contracted_RN2(String summary_contracted_RN2) {
        this.summary_contracted_RN2 = summary_contracted_RN2;
    }
    public String getSummary_contracted_RN3() {
        return summary_contracted_RN3;
    }
    public void setSummary_contracted_RN3(String summary_contracted_RN3) {
        this.summary_contracted_RN3 = summary_contracted_RN3;
    }
    public String getSummary_contracted_RN4() {
        return summary_contracted_RN4;
    }
    public void setSummary_contracted_RN4(String summary_contracted_RN4) {
        this.summary_contracted_RN4 = summary_contracted_RN4;
    }
    public String getSummary_contracted_RN5() {
        return summary_contracted_RN5;
    }
    public void setSummary_contracted_RN5(String summary_contracted_RN5) {
        this.summary_contracted_RN5 = summary_contracted_RN5;
    }
    public String getSummary_contracted_RT1() {
        return summary_contracted_RT1;
    }
    public void setSummary_contracted_RT1(String summary_contracted_RT1) {
        this.summary_contracted_RT1 = summary_contracted_RT1;
    }
    public String getSummary_contracted_RT2() {
        return summary_contracted_RT2;
    }
    public void setSummary_contracted_RT2(String summary_contracted_RT2) {
        this.summary_contracted_RT2 = summary_contracted_RT2;
    }
    public String getSummary_contracted_RT3() {
        return summary_contracted_RT3;
    }
    public void setSummary_contracted_RT3(String summary_contracted_RT3) {
        this.summary_contracted_RT3 = summary_contracted_RT3;
    }
    public String getSummary_contracted_RT4() {
        return summary_contracted_RT4;
    }
    public void setSummary_contracted_RT4(String summary_contracted_RT4) {
        this.summary_contracted_RT4 = summary_contracted_RT4;
    }
    public String getSummary_contracted_RT5() {
        return summary_contracted_RT5;
    }
    public void setSummary_contracted_RT5(String summary_contracted_RT5) {
        this.summary_contracted_RT5 = summary_contracted_RT5;
    }
    public String getSummary_contracted_SL1() {
        return summary_contracted_SL1;
    }
    public void setSummary_contracted_SL1(String summary_contracted_SL1) {
        this.summary_contracted_SL1 = summary_contracted_SL1;
    }
    public String getSummary_contracted_SL2() {
        return summary_contracted_SL2;
    }
    public void setSummary_contracted_SL2(String summary_contracted_SL2) {
        this.summary_contracted_SL2 = summary_contracted_SL2;
    }
    public String getSummary_contracted_SL3() {
        return summary_contracted_SL3;
    }
    public void setSummary_contracted_SL3(String summary_contracted_SL3) {
        this.summary_contracted_SL3 = summary_contracted_SL3;
    }
    public String getSummary_contracted_SL4() {
        return summary_contracted_SL4;
    }
    public void setSummary_contracted_SL4(String summary_contracted_SL4) {
        this.summary_contracted_SL4 = summary_contracted_SL4;
    }
    public String getSummary_contracted_SL5() {
        return summary_contracted_SL5;
    }
    public void setSummary_contracted_SL5(String summary_contracted_SL5) {
        this.summary_contracted_SL5 = summary_contracted_SL5;
    }
    public String getSummary_contracted_SW1() {
        return summary_contracted_SW1;
    }
    public void setSummary_contracted_SW1(String summary_contracted_SW1) {
        this.summary_contracted_SW1 = summary_contracted_SW1;
    }
    public String getSummary_contracted_SW2() {
        return summary_contracted_SW2;
    }
    public void setSummary_contracted_SW2(String summary_contracted_SW2) {
        this.summary_contracted_SW2 = summary_contracted_SW2;
    }
    public String getSummary_contracted_SW3() {
        return summary_contracted_SW3;
    }
    public void setSummary_contracted_SW3(String summary_contracted_SW3) {
        this.summary_contracted_SW3 = summary_contracted_SW3;
    }
    public String getSummary_contracted_SW4() {
        return summary_contracted_SW4;
    }
    public void setSummary_contracted_SW4(String summary_contracted_SW4) {
        this.summary_contracted_SW4 = summary_contracted_SW4;
    }
    public String getSummary_contracted_SW5() {
        return summary_contracted_SW5;
    }
    public void setSummary_contracted_SW5(String summary_contracted_SW5) {
        this.summary_contracted_SW5 = summary_contracted_SW5;
    }
    public String getProf_staff_explanation1() {
        return prof_staff_explanation1;
    }
    public void setProf_staff_explanation1(String prof_staff_explanation1) {
        this.prof_staff_explanation1 = prof_staff_explanation1;
    }
    public String getProf_staff_explanation2() {
        return prof_staff_explanation2;
    }
    public void setProf_staff_explanation2(String prof_staff_explanation2) {
        this.prof_staff_explanation2 = prof_staff_explanation2;
    }
    public String getProf_staff_explanation3() {
        return prof_staff_explanation3;
    }
    public void setProf_staff_explanation3(String prof_staff_explanation3) {
        this.prof_staff_explanation3 = prof_staff_explanation3;
    }
    public String getProf_staff_explanation4() {
        return prof_staff_explanation4;
    }
    public void setProf_staff_explanation4(String prof_staff_explanation4) {
        this.prof_staff_explanation4 = prof_staff_explanation4;
    }
    public String getProf_staff_explanation5() {
        return prof_staff_explanation5;
    }
    public void setProf_staff_explanation5(String prof_staff_explanation5) {
        this.prof_staff_explanation5 = prof_staff_explanation5;
    }
    public String getSummary_contracted_HCA1() {
        return summary_contracted_HCA1;
    }
    public void setSummary_contracted_HCA1(String summary_contracted_HCA1) {
        this.summary_contracted_HCA1 = summary_contracted_HCA1;
    }
    public String getSummary_contracted_HCA2() {
        return summary_contracted_HCA2;
    }
    public void setSummary_contracted_HCA2(String summary_contracted_HCA2) {
        this.summary_contracted_HCA2 = summary_contracted_HCA2;
    }
    public String getSummary_contracted_HCA3() {
        return summary_contracted_HCA3;
    }
    public void setSummary_contracted_HCA3(String summary_contracted_HCA3) {
        this.summary_contracted_HCA3 = summary_contracted_HCA3;
    }
    public String getSummary_contracted_HCA4() {
        return summary_contracted_HCA4;
    }
    public void setSummary_contracted_HCA4(String summary_contracted_HCA4) {
        this.summary_contracted_HCA4 = summary_contracted_HCA4;
    }
    public String getSummary_contracted_HCA5() {
        return summary_contracted_HCA5;
    }
    public void setSummary_contracted_HCA5(String summary_contracted_HCA5) {
        this.summary_contracted_HCA5 = summary_contracted_HCA5;
    }
    public String getSummary_contracted_LPN1() {
        return summary_contracted_LPN1;
    }
    public void setSummary_contracted_LPN1(String summary_contracted_LPN1) {
        this.summary_contracted_LPN1 = summary_contracted_LPN1;
    }
    public String getSummary_contracted_LPN2() {
        return summary_contracted_LPN2;
    }
    public void setSummary_contracted_LPN2(String summary_contracted_LPN2) {
        this.summary_contracted_LPN2 = summary_contracted_LPN2;
    }
    public String getSummary_contracted_LPN3() {
        return summary_contracted_LPN3;
    }
    public void setSummary_contracted_LPN3(String summary_contracted_LPN3) {
        this.summary_contracted_LPN3 = summary_contracted_LPN3;
    }
    public String getSummary_contracted_LPN4() {
        return summary_contracted_LPN4;
    }
    public void setSummary_contracted_LPN4(String summary_contracted_LPN4) {
        this.summary_contracted_LPN4 = summary_contracted_LPN4;
    }
    public String getSummary_contracted_LPN5() {
        return summary_contracted_LPN5;
    }
    public void setSummary_contracted_LPN5(String summary_contracted_LPN5) {
        this.summary_contracted_LPN5 = summary_contracted_LPN5;
    }
    public String getRN_LPN_staff_percentage1() {
        return RN_LPN_staff_percentage1;
    }
    public void setRN_LPN_staff_percentage1(String rN_LPN_staff_percentage1) {
        RN_LPN_staff_percentage1 = rN_LPN_staff_percentage1;
    }
    public String getRN_LPN_staff_percentage2() {
        return RN_LPN_staff_percentage2;
    }
    public void setRN_LPN_staff_percentage2(String rN_LPN_staff_percentage2) {
        RN_LPN_staff_percentage2 = rN_LPN_staff_percentage2;
    }
    public String getRN_LPN_staff_percentage3() {
        return RN_LPN_staff_percentage3;
    }
    public void setRN_LPN_staff_percentage3(String rN_LPN_staff_percentage3) {
        RN_LPN_staff_percentage3 = rN_LPN_staff_percentage3;
    }
    public String getRN_LPN_staff_percentage4() {
        return RN_LPN_staff_percentage4;
    }
    public void setRN_LPN_staff_percentage4(String rN_LPN_staff_percentage4) {
        RN_LPN_staff_percentage4 = rN_LPN_staff_percentage4;
    }
    public String getRN_LPN_staff_percentage5() {
        return RN_LPN_staff_percentage5;
    }
    public void setRN_LPN_staff_percentage5(String rN_LPN_staff_percentage5) {
        RN_LPN_staff_percentage5 = rN_LPN_staff_percentage5;
    }
    public String getAlliedProf_annual_total1() {
        return alliedProf_annual_total1;
    }
    public void setAlliedProf_annual_total1(String alliedProf_annual_total1) {
        this.alliedProf_annual_total1 = alliedProf_annual_total1;
    }
    public String getAlliedProf_annual_total2() {
        return alliedProf_annual_total2;
    }
    public void setAlliedProf_annual_total2(String alliedProf_annual_total2) {
        this.alliedProf_annual_total2 = alliedProf_annual_total2;
    }
    public String getAlliedProf_annual_total3() {
        return alliedProf_annual_total3;
    }
    public void setAlliedProf_annual_total3(String alliedProf_annual_total3) {
        this.alliedProf_annual_total3 = alliedProf_annual_total3;
    }
    public String getAlliedProf_annual_total4() {
        return alliedProf_annual_total4;
    }
    public void setAlliedProf_annual_total4(String alliedProf_annual_total4) {
        this.alliedProf_annual_total4 = alliedProf_annual_total4;
    }
    public String getAlliedProf_annual_total5() {
        return alliedProf_annual_total5;
    }
    public void setAlliedProf_annual_total5(String alliedProf_annual_total5) {
        this.alliedProf_annual_total5 = alliedProf_annual_total5;
    }
    public String getSummary_annual_nursingP1() {
        return summary_annual_nursingP1;
    }
    public void setSummary_annual_nursingP1(String summary_annual_nursingP1) {
        this.summary_annual_nursingP1 = summary_annual_nursingP1;
    }
    public String getSummary_annual_nursingP2() {
        return summary_annual_nursingP2;
    }
    public void setSummary_annual_nursingP2(String summary_annual_nursingP2) {
        this.summary_annual_nursingP2 = summary_annual_nursingP2;
    }
    public String getSummary_annual_nursingP3() {
        return summary_annual_nursingP3;
    }
    public void setSummary_annual_nursingP3(String summary_annual_nursingP3) {
        this.summary_annual_nursingP3 = summary_annual_nursingP3;
    }
    public String getSummary_annual_nursingP4() {
        return summary_annual_nursingP4;
    }
    public void setSummary_annual_nursingP4(String summary_annual_nursingP4) {
        this.summary_annual_nursingP4 = summary_annual_nursingP4;
    }
    public String getSummary_annual_nursingP5() {
        return summary_annual_nursingP5;
    }
    public void setSummary_annual_nursingP5(String summary_annual_nursingP5) {
        this.summary_annual_nursingP5 = summary_annual_nursingP5;
    }
    public String getSummary_contracted_resp1() {
        return summary_contracted_resp1;
    }
    public void setSummary_contracted_resp1(String summary_contracted_resp1) {
        this.summary_contracted_resp1 = summary_contracted_resp1;
    }
    public String getSummary_contracted_resp2() {
        return summary_contracted_resp2;
    }
    public void setSummary_contracted_resp2(String summary_contracted_resp2) {
        this.summary_contracted_resp2 = summary_contracted_resp2;
    }
    public String getSummary_contracted_resp3() {
        return summary_contracted_resp3;
    }
    public void setSummary_contracted_resp3(String summary_contracted_resp3) {
        this.summary_contracted_resp3 = summary_contracted_resp3;
    }
    public String getSummary_contracted_resp4() {
        return summary_contracted_resp4;
    }
    public void setSummary_contracted_resp4(String summary_contracted_resp4) {
        this.summary_contracted_resp4 = summary_contracted_resp4;
    }
    public String getSummary_contracted_resp5() {
        return summary_contracted_resp5;
    }
    public void setSummary_contracted_resp5(String summary_contracted_resp5) {
        this.summary_contracted_resp5 = summary_contracted_resp5;
    }
    public String getRN_LPN_staff_explanation1() {
        return RN_LPN_staff_explanation1;
    }
    public void setRN_LPN_staff_explanation1(String rN_LPN_staff_explanation1) {
        RN_LPN_staff_explanation1 = rN_LPN_staff_explanation1;
    }
    public String getRN_LPN_staff_explanation2() {
        return RN_LPN_staff_explanation2;
    }
    public void setRN_LPN_staff_explanation2(String rN_LPN_staff_explanation2) {
        RN_LPN_staff_explanation2 = rN_LPN_staff_explanation2;
    }
    public String getRN_LPN_staff_explanation3() {
        return RN_LPN_staff_explanation3;
    }
    public void setRN_LPN_staff_explanation3(String rN_LPN_staff_explanation3) {
        RN_LPN_staff_explanation3 = rN_LPN_staff_explanation3;
    }
    public String getRN_LPN_staff_explanation4() {
        return RN_LPN_staff_explanation4;
    }
    public void setRN_LPN_staff_explanation4(String rN_LPN_staff_explanation4) {
        RN_LPN_staff_explanation4 = rN_LPN_staff_explanation4;
    }
    public String getRN_LPN_staff_explanation5() {
        return RN_LPN_staff_explanation5;
    }
    public void setRN_LPN_staff_explanation5(String rN_LPN_staff_explanation5) {
        RN_LPN_staff_explanation5 = rN_LPN_staff_explanation5;
    }
    public String getSummary_annual_nursingNP1() {
        return summary_annual_nursingNP1;
    }
    public void setSummary_annual_nursingNP1(String summary_annual_nursingNP1) {
        this.summary_annual_nursingNP1 = summary_annual_nursingNP1;
    }
    public String getSummary_annual_nursingNP2() {
        return summary_annual_nursingNP2;
    }
    public void setSummary_annual_nursingNP2(String summary_annual_nursingNP2) {
        this.summary_annual_nursingNP2 = summary_annual_nursingNP2;
    }
    public String getSummary_annual_nursingNP3() {
        return summary_annual_nursingNP3;
    }
    public void setSummary_annual_nursingNP3(String summary_annual_nursingNP3) {
        this.summary_annual_nursingNP3 = summary_annual_nursingNP3;
    }
    public String getSummary_annual_nursingNP4() {
        return summary_annual_nursingNP4;
    }
    public void setSummary_annual_nursingNP4(String summary_annual_nursingNP4) {
        this.summary_annual_nursingNP4 = summary_annual_nursingNP4;
    }
    public String getSummary_annual_nursingNP5() {
        return summary_annual_nursingNP5;
    }
    public void setSummary_annual_nursingNP5(String summary_annual_nursingNP5) {
        this.summary_annual_nursingNP5 = summary_annual_nursingNP5;
    }
    public String getSummary_inHouse_nursingP1() {
        return summary_inHouse_nursingP1;
    }
    public void setSummary_inHouse_nursingP1(String summary_inHouse_nursingP1) {
        this.summary_inHouse_nursingP1 = summary_inHouse_nursingP1;
    }
    public String getSummary_inHouse_nursingP2() {
        return summary_inHouse_nursingP2;
    }
    public void setSummary_inHouse_nursingP2(String summary_inHouse_nursingP2) {
        this.summary_inHouse_nursingP2 = summary_inHouse_nursingP2;
    }
    public String getSummary_inHouse_nursingP3() {
        return summary_inHouse_nursingP3;
    }
    public void setSummary_inHouse_nursingP3(String summary_inHouse_nursingP3) {
        this.summary_inHouse_nursingP3 = summary_inHouse_nursingP3;
    }
    public String getSummary_inHouse_nursingP4() {
        return summary_inHouse_nursingP4;
    }
    public void setSummary_inHouse_nursingP4(String summary_inHouse_nursingP4) {
        this.summary_inHouse_nursingP4 = summary_inHouse_nursingP4;
    }
    public String getSummary_inHouse_nursingP5() {
        return summary_inHouse_nursingP5;
    }
    public void setSummary_inHouse_nursingP5(String summary_inHouse_nursingP5) {
        this.summary_inHouse_nursingP5 = summary_inHouse_nursingP5;
    }
    public String getSummary_annual_alliedProf1() {
        return summary_annual_alliedProf1;
    }
    public void setSummary_annual_alliedProf1(String summary_annual_alliedProf1) {
        this.summary_annual_alliedProf1 = summary_annual_alliedProf1;
    }
    public String getSummary_annual_alliedProf2() {
        return summary_annual_alliedProf2;
    }
    public void setSummary_annual_alliedProf2(String summary_annual_alliedProf2) {
        this.summary_annual_alliedProf2 = summary_annual_alliedProf2;
    }
    public String getSummary_annual_alliedProf3() {
        return summary_annual_alliedProf3;
    }
    public void setSummary_annual_alliedProf3(String summary_annual_alliedProf3) {
        this.summary_annual_alliedProf3 = summary_annual_alliedProf3;
    }
    public String getSummary_annual_alliedProf4() {
        return summary_annual_alliedProf4;
    }
    public void setSummary_annual_alliedProf4(String summary_annual_alliedProf4) {
        this.summary_annual_alliedProf4 = summary_annual_alliedProf4;
    }
    public String getSummary_annual_alliedProf5() {
        return summary_annual_alliedProf5;
    }
    public void setSummary_annual_alliedProf5(String summary_annual_alliedProf5) {
        this.summary_annual_alliedProf5 = summary_annual_alliedProf5;
    }
    public String getSummary_inHouse_nursingNP1() {
        return summary_inHouse_nursingNP1;
    }
    public void setSummary_inHouse_nursingNP1(String summary_inHouse_nursingNP1) {
        this.summary_inHouse_nursingNP1 = summary_inHouse_nursingNP1;
    }
    public String getSummary_inHouse_nursingNP2() {
        return summary_inHouse_nursingNP2;
    }
    public void setSummary_inHouse_nursingNP2(String summary_inHouse_nursingNP2) {
        this.summary_inHouse_nursingNP2 = summary_inHouse_nursingNP2;
    }
    public String getSummary_inHouse_nursingNP3() {
        return summary_inHouse_nursingNP3;
    }
    public void setSummary_inHouse_nursingNP3(String summary_inHouse_nursingNP3) {
        this.summary_inHouse_nursingNP3 = summary_inHouse_nursingNP3;
    }
    public String getSummary_inHouse_nursingNP4() {
        return summary_inHouse_nursingNP4;
    }
    public void setSummary_inHouse_nursingNP4(String summary_inHouse_nursingNP4) {
        this.summary_inHouse_nursingNP4 = summary_inHouse_nursingNP4;
    }
    public String getSummary_inHouse_nursingNP5() {
        return summary_inHouse_nursingNP5;
    }
    public void setSummary_inHouse_nursingNP5(String summary_inHouse_nursingNP5) {
        this.summary_inHouse_nursingNP5 = summary_inHouse_nursingNP5;
    }
    public String getProviderName_otherNursingP1() {
        return providerName_otherNursingP1;
    }
    public void setProviderName_otherNursingP1(String providerName_otherNursingP1) {
        this.providerName_otherNursingP1 = providerName_otherNursingP1;
    }
    public String getProviderName_otherNursingP2() {
        return providerName_otherNursingP2;
    }
    public void setProviderName_otherNursingP2(String providerName_otherNursingP2) {
        this.providerName_otherNursingP2 = providerName_otherNursingP2;
    }
    public String getProviderName_otherNursingP3() {
        return providerName_otherNursingP3;
    }
    public void setProviderName_otherNursingP3(String providerName_otherNursingP3) {
        this.providerName_otherNursingP3 = providerName_otherNursingP3;
    }
    public String getProviderName_otherNursingP4() {
        return providerName_otherNursingP4;
    }
    public void setProviderName_otherNursingP4(String providerName_otherNursingP4) {
        this.providerName_otherNursingP4 = providerName_otherNursingP4;
    }
    public String getProviderName_otherNursingP5() {
        return providerName_otherNursingP5;
    }
    public void setProviderName_otherNursingP5(String providerName_otherNursingP5) {
        this.providerName_otherNursingP5 = providerName_otherNursingP5;
    }
    public String getSummary_annual_alliedNProf1() {
        return summary_annual_alliedNProf1;
    }
    public void setSummary_annual_alliedNProf1(String summary_annual_alliedNProf1) {
        this.summary_annual_alliedNProf1 = summary_annual_alliedNProf1;
    }
    public String getSummary_annual_alliedNProf2() {
        return summary_annual_alliedNProf2;
    }
    public void setSummary_annual_alliedNProf2(String summary_annual_alliedNProf2) {
        this.summary_annual_alliedNProf2 = summary_annual_alliedNProf2;
    }
    public String getSummary_annual_alliedNProf3() {
        return summary_annual_alliedNProf3;
    }
    public void setSummary_annual_alliedNProf3(String summary_annual_alliedNProf3) {
        this.summary_annual_alliedNProf3 = summary_annual_alliedNProf3;
    }
    public String getSummary_annual_alliedNProf4() {
        return summary_annual_alliedNProf4;
    }
    public void setSummary_annual_alliedNProf4(String summary_annual_alliedNProf4) {
        this.summary_annual_alliedNProf4 = summary_annual_alliedNProf4;
    }
    public String getSummary_annual_alliedNProf5() {
        return summary_annual_alliedNProf5;
    }
    public void setSummary_annual_alliedNProf5(String summary_annual_alliedNProf5) {
        this.summary_annual_alliedNProf5 = summary_annual_alliedNProf5;
    }
    public String getSummary_inHouse_alliedProf1() {
        return summary_inHouse_alliedProf1;
    }
    public void setSummary_inHouse_alliedProf1(String summary_inHouse_alliedProf1) {
        this.summary_inHouse_alliedProf1 = summary_inHouse_alliedProf1;
    }
    public String getSummary_inHouse_alliedProf2() {
        return summary_inHouse_alliedProf2;
    }
    public void setSummary_inHouse_alliedProf2(String summary_inHouse_alliedProf2) {
        this.summary_inHouse_alliedProf2 = summary_inHouse_alliedProf2;
    }
    public String getSummary_inHouse_alliedProf3() {
        return summary_inHouse_alliedProf3;
    }
    public void setSummary_inHouse_alliedProf3(String summary_inHouse_alliedProf3) {
        this.summary_inHouse_alliedProf3 = summary_inHouse_alliedProf3;
    }
    public String getSummary_inHouse_alliedProf4() {
        return summary_inHouse_alliedProf4;
    }
    public void setSummary_inHouse_alliedProf4(String summary_inHouse_alliedProf4) {
        this.summary_inHouse_alliedProf4 = summary_inHouse_alliedProf4;
    }
    public String getSummary_inHouse_alliedProf5() {
        return summary_inHouse_alliedProf5;
    }
    public void setSummary_inHouse_alliedProf5(String summary_inHouse_alliedProf5) {
        this.summary_inHouse_alliedProf5 = summary_inHouse_alliedProf5;
    }
    public String getContractedOut_otherNursingP1() {
        return contractedOut_otherNursingP1;
    }
    public void setContractedOut_otherNursingP1(String contractedOut_otherNursingP1) {
        this.contractedOut_otherNursingP1 = contractedOut_otherNursingP1;
    }
    public String getContractedOut_otherNursingP2() {
        return contractedOut_otherNursingP2;
    }
    public void setContractedOut_otherNursingP2(String contractedOut_otherNursingP2) {
        this.contractedOut_otherNursingP2 = contractedOut_otherNursingP2;
    }
    public String getContractedOut_otherNursingP3() {
        return contractedOut_otherNursingP3;
    }
    public void setContractedOut_otherNursingP3(String contractedOut_otherNursingP3) {
        this.contractedOut_otherNursingP3 = contractedOut_otherNursingP3;
    }
    public String getContractedOut_otherNursingP4() {
        return contractedOut_otherNursingP4;
    }
    public void setContractedOut_otherNursingP4(String contractedOut_otherNursingP4) {
        this.contractedOut_otherNursingP4 = contractedOut_otherNursingP4;
    }
    public String getContractedOut_otherNursingP5() {
        return contractedOut_otherNursingP5;
    }
    public void setContractedOut_otherNursingP5(String contractedOut_otherNursingP5) {
        this.contractedOut_otherNursingP5 = contractedOut_otherNursingP5;
    }
    public String getPercentageOut_otherNursingP1() {
        return percentageOut_otherNursingP1;
    }
    public void setPercentageOut_otherNursingP1(String percentageOut_otherNursingP1) {
        this.percentageOut_otherNursingP1 = percentageOut_otherNursingP1;
    }
    public String getPercentageOut_otherNursingP2() {
        return percentageOut_otherNursingP2;
    }
    public void setPercentageOut_otherNursingP2(String percentageOut_otherNursingP2) {
        this.percentageOut_otherNursingP2 = percentageOut_otherNursingP2;
    }
    public String getPercentageOut_otherNursingP3() {
        return percentageOut_otherNursingP3;
    }
    public void setPercentageOut_otherNursingP3(String percentageOut_otherNursingP3) {
        this.percentageOut_otherNursingP3 = percentageOut_otherNursingP3;
    }
    public String getPercentageOut_otherNursingP4() {
        return percentageOut_otherNursingP4;
    }
    public void setPercentageOut_otherNursingP4(String percentageOut_otherNursingP4) {
        this.percentageOut_otherNursingP4 = percentageOut_otherNursingP4;
    }
    public String getPercentageOut_otherNursingP5() {
        return percentageOut_otherNursingP5;
    }
    public void setPercentageOut_otherNursingP5(String percentageOut_otherNursingP5) {
        this.percentageOut_otherNursingP5 = percentageOut_otherNursingP5;
    }
    public String getProviderName_otherNursingNP1() {
        return providerName_otherNursingNP1;
    }
    public void setProviderName_otherNursingNP1(String providerName_otherNursingNP1) {
        this.providerName_otherNursingNP1 = providerName_otherNursingNP1;
    }
    public String getProviderName_otherNursingNP2() {
        return providerName_otherNursingNP2;
    }
    public void setProviderName_otherNursingNP2(String providerName_otherNursingNP2) {
        this.providerName_otherNursingNP2 = providerName_otherNursingNP2;
    }
    public String getProviderName_otherNursingNP3() {
        return providerName_otherNursingNP3;
    }
    public void setProviderName_otherNursingNP3(String providerName_otherNursingNP3) {
        this.providerName_otherNursingNP3 = providerName_otherNursingNP3;
    }
    public String getProviderName_otherNursingNP4() {
        return providerName_otherNursingNP4;
    }
    public void setProviderName_otherNursingNP4(String providerName_otherNursingNP4) {
        this.providerName_otherNursingNP4 = providerName_otherNursingNP4;
    }
    public String getProviderName_otherNursingNP5() {
        return providerName_otherNursingNP5;
    }
    public void setProviderName_otherNursingNP5(String providerName_otherNursingNP5) {
        this.providerName_otherNursingNP5 = providerName_otherNursingNP5;
    }
    public String getSummary_contracted_nursingP1() {
        return summary_contracted_nursingP1;
    }
    public void setSummary_contracted_nursingP1(String summary_contracted_nursingP1) {
        this.summary_contracted_nursingP1 = summary_contracted_nursingP1;
    }
    public String getSummary_contracted_nursingP2() {
        return summary_contracted_nursingP2;
    }
    public void setSummary_contracted_nursingP2(String summary_contracted_nursingP2) {
        this.summary_contracted_nursingP2 = summary_contracted_nursingP2;
    }
    public String getSummary_contracted_nursingP3() {
        return summary_contracted_nursingP3;
    }
    public void setSummary_contracted_nursingP3(String summary_contracted_nursingP3) {
        this.summary_contracted_nursingP3 = summary_contracted_nursingP3;
    }
    public String getSummary_contracted_nursingP4() {
        return summary_contracted_nursingP4;
    }
    public void setSummary_contracted_nursingP4(String summary_contracted_nursingP4) {
        this.summary_contracted_nursingP4 = summary_contracted_nursingP4;
    }
    public String getSummary_contracted_nursingP5() {
        return summary_contracted_nursingP5;
    }
    public void setSummary_contracted_nursingP5(String summary_contracted_nursingP5) {
        this.summary_contracted_nursingP5 = summary_contracted_nursingP5;
    }
    public String getSummary_inHouse_alliedNProf1() {
        return summary_inHouse_alliedNProf1;
    }
    public void setSummary_inHouse_alliedNProf1(String summary_inHouse_alliedNProf1) {
        this.summary_inHouse_alliedNProf1 = summary_inHouse_alliedNProf1;
    }
    public String getSummary_inHouse_alliedNProf2() {
        return summary_inHouse_alliedNProf2;
    }
    public void setSummary_inHouse_alliedNProf2(String summary_inHouse_alliedNProf2) {
        this.summary_inHouse_alliedNProf2 = summary_inHouse_alliedNProf2;
    }
    public String getSummary_inHouse_alliedNProf3() {
        return summary_inHouse_alliedNProf3;
    }
    public void setSummary_inHouse_alliedNProf3(String summary_inHouse_alliedNProf3) {
        this.summary_inHouse_alliedNProf3 = summary_inHouse_alliedNProf3;
    }
    public String getSummary_inHouse_alliedNProf4() {
        return summary_inHouse_alliedNProf4;
    }
    public void setSummary_inHouse_alliedNProf4(String summary_inHouse_alliedNProf4) {
        this.summary_inHouse_alliedNProf4 = summary_inHouse_alliedNProf4;
    }
    public String getSummary_inHouse_alliedNProf5() {
        return summary_inHouse_alliedNProf5;
    }
    public void setSummary_inHouse_alliedNProf5(String summary_inHouse_alliedNProf5) {
        this.summary_inHouse_alliedNProf5 = summary_inHouse_alliedNProf5;
    }
    public String getContractedOut_otherNursingNP1() {
        return contractedOut_otherNursingNP1;
    }
    public void setContractedOut_otherNursingNP1(String contractedOut_otherNursingNP1) {
        this.contractedOut_otherNursingNP1 = contractedOut_otherNursingNP1;
    }
    public String getContractedOut_otherNursingNP2() {
        return contractedOut_otherNursingNP2;
    }
    public void setContractedOut_otherNursingNP2(String contractedOut_otherNursingNP2) {
        this.contractedOut_otherNursingNP2 = contractedOut_otherNursingNP2;
    }
    public String getContractedOut_otherNursingNP3() {
        return contractedOut_otherNursingNP3;
    }
    public void setContractedOut_otherNursingNP3(String contractedOut_otherNursingNP3) {
        this.contractedOut_otherNursingNP3 = contractedOut_otherNursingNP3;
    }
    public String getContractedOut_otherNursingNP4() {
        return contractedOut_otherNursingNP4;
    }
    public void setContractedOut_otherNursingNP4(String contractedOut_otherNursingNP4) {
        this.contractedOut_otherNursingNP4 = contractedOut_otherNursingNP4;
    }
    public String getContractedOut_otherNursingNP5() {
        return contractedOut_otherNursingNP5;
    }
    public void setContractedOut_otherNursingNP5(String contractedOut_otherNursingNP5) {
        this.contractedOut_otherNursingNP5 = contractedOut_otherNursingNP5;
    }
    public String getPercentageOut_otherNursingNP1() {
        return percentageOut_otherNursingNP1;
    }
    public void setPercentageOut_otherNursingNP1(String percentageOut_otherNursingNP1) {
        this.percentageOut_otherNursingNP1 = percentageOut_otherNursingNP1;
    }
    public String getPercentageOut_otherNursingNP2() {
        return percentageOut_otherNursingNP2;
    }
    public void setPercentageOut_otherNursingNP2(String percentageOut_otherNursingNP2) {
        this.percentageOut_otherNursingNP2 = percentageOut_otherNursingNP2;
    }
    public String getPercentageOut_otherNursingNP3() {
        return percentageOut_otherNursingNP3;
    }
    public void setPercentageOut_otherNursingNP3(String percentageOut_otherNursingNP3) {
        this.percentageOut_otherNursingNP3 = percentageOut_otherNursingNP3;
    }
    public String getPercentageOut_otherNursingNP4() {
        return percentageOut_otherNursingNP4;
    }
    public void setPercentageOut_otherNursingNP4(String percentageOut_otherNursingNP4) {
        this.percentageOut_otherNursingNP4 = percentageOut_otherNursingNP4;
    }
    public String getPercentageOut_otherNursingNP5() {
        return percentageOut_otherNursingNP5;
    }
    public void setPercentageOut_otherNursingNP5(String percentageOut_otherNursingNP5) {
        this.percentageOut_otherNursingNP5 = percentageOut_otherNursingNP5;
    }
    public String getProviderName_otherAlliedProf1() {
        return providerName_otherAlliedProf1;
    }
    public void setProviderName_otherAlliedProf1(String providerName_otherAlliedProf1) {
        this.providerName_otherAlliedProf1 = providerName_otherAlliedProf1;
    }
    public String getProviderName_otherAlliedProf2() {
        return providerName_otherAlliedProf2;
    }
    public void setProviderName_otherAlliedProf2(String providerName_otherAlliedProf2) {
        this.providerName_otherAlliedProf2 = providerName_otherAlliedProf2;
    }
    public String getProviderName_otherAlliedProf3() {
        return providerName_otherAlliedProf3;
    }
    public void setProviderName_otherAlliedProf3(String providerName_otherAlliedProf3) {
        this.providerName_otherAlliedProf3 = providerName_otherAlliedProf3;
    }
    public String getProviderName_otherAlliedProf4() {
        return providerName_otherAlliedProf4;
    }
    public void setProviderName_otherAlliedProf4(String providerName_otherAlliedProf4) {
        this.providerName_otherAlliedProf4 = providerName_otherAlliedProf4;
    }
    public String getProviderName_otherAlliedProf5() {
        return providerName_otherAlliedProf5;
    }
    public void setProviderName_otherAlliedProf5(String providerName_otherAlliedProf5) {
        this.providerName_otherAlliedProf5 = providerName_otherAlliedProf5;
    }
    public String getSummary_annual_otherNursingP1() {
        return summary_annual_otherNursingP1;
    }
    public void setSummary_annual_otherNursingP1(String summary_annual_otherNursingP1) {
        this.summary_annual_otherNursingP1 = summary_annual_otherNursingP1;
    }
    public String getSummary_annual_otherNursingP2() {
        return summary_annual_otherNursingP2;
    }
    public void setSummary_annual_otherNursingP2(String summary_annual_otherNursingP2) {
        this.summary_annual_otherNursingP2 = summary_annual_otherNursingP2;
    }
    public String getSummary_annual_otherNursingP3() {
        return summary_annual_otherNursingP3;
    }
    public void setSummary_annual_otherNursingP3(String summary_annual_otherNursingP3) {
        this.summary_annual_otherNursingP3 = summary_annual_otherNursingP3;
    }
    public String getSummary_annual_otherNursingP4() {
        return summary_annual_otherNursingP4;
    }
    public void setSummary_annual_otherNursingP4(String summary_annual_otherNursingP4) {
        this.summary_annual_otherNursingP4 = summary_annual_otherNursingP4;
    }
    public String getSummary_annual_otherNursingP5() {
        return summary_annual_otherNursingP5;
    }
    public void setSummary_annual_otherNursingP5(String summary_annual_otherNursingP5) {
        this.summary_annual_otherNursingP5 = summary_annual_otherNursingP5;
    }
    public String getSummary_contracted_nursingNP1() {
        return summary_contracted_nursingNP1;
    }
    public void setSummary_contracted_nursingNP1(String summary_contracted_nursingNP1) {
        this.summary_contracted_nursingNP1 = summary_contracted_nursingNP1;
    }
    public String getSummary_contracted_nursingNP2() {
        return summary_contracted_nursingNP2;
    }
    public void setSummary_contracted_nursingNP2(String summary_contracted_nursingNP2) {
        this.summary_contracted_nursingNP2 = summary_contracted_nursingNP2;
    }
    public String getSummary_contracted_nursingNP3() {
        return summary_contracted_nursingNP3;
    }
    public void setSummary_contracted_nursingNP3(String summary_contracted_nursingNP3) {
        this.summary_contracted_nursingNP3 = summary_contracted_nursingNP3;
    }
    public String getSummary_contracted_nursingNP4() {
        return summary_contracted_nursingNP4;
    }
    public void setSummary_contracted_nursingNP4(String summary_contracted_nursingNP4) {
        this.summary_contracted_nursingNP4 = summary_contracted_nursingNP4;
    }
    public String getSummary_contracted_nursingNP5() {
        return summary_contracted_nursingNP5;
    }
    public void setSummary_contracted_nursingNP5(String summary_contracted_nursingNP5) {
        this.summary_contracted_nursingNP5 = summary_contracted_nursingNP5;
    }
    public String getContractedOut_otherAlliedProf1() {
        return contractedOut_otherAlliedProf1;
    }
    public void setContractedOut_otherAlliedProf1(String contractedOut_otherAlliedProf1) {
        this.contractedOut_otherAlliedProf1 = contractedOut_otherAlliedProf1;
    }
    public String getContractedOut_otherAlliedProf2() {
        return contractedOut_otherAlliedProf2;
    }
    public void setContractedOut_otherAlliedProf2(String contractedOut_otherAlliedProf2) {
        this.contractedOut_otherAlliedProf2 = contractedOut_otherAlliedProf2;
    }
    public String getContractedOut_otherAlliedProf3() {
        return contractedOut_otherAlliedProf3;
    }
    public void setContractedOut_otherAlliedProf3(String contractedOut_otherAlliedProf3) {
        this.contractedOut_otherAlliedProf3 = contractedOut_otherAlliedProf3;
    }
    public String getContractedOut_otherAlliedProf4() {
        return contractedOut_otherAlliedProf4;
    }
    public void setContractedOut_otherAlliedProf4(String contractedOut_otherAlliedProf4) {
        this.contractedOut_otherAlliedProf4 = contractedOut_otherAlliedProf4;
    }
    public String getContractedOut_otherAlliedProf5() {
        return contractedOut_otherAlliedProf5;
    }
    public void setContractedOut_otherAlliedProf5(String contractedOut_otherAlliedProf5) {
        this.contractedOut_otherAlliedProf5 = contractedOut_otherAlliedProf5;
    }
    public String getPercentageOut_otherAlliedProf1() {
        return percentageOut_otherAlliedProf1;
    }
    public void setPercentageOut_otherAlliedProf1(String percentageOut_otherAlliedProf1) {
        this.percentageOut_otherAlliedProf1 = percentageOut_otherAlliedProf1;
    }
    public String getPercentageOut_otherAlliedProf2() {
        return percentageOut_otherAlliedProf2;
    }
    public void setPercentageOut_otherAlliedProf2(String percentageOut_otherAlliedProf2) {
        this.percentageOut_otherAlliedProf2 = percentageOut_otherAlliedProf2;
    }
    public String getPercentageOut_otherAlliedProf3() {
        return percentageOut_otherAlliedProf3;
    }
    public void setPercentageOut_otherAlliedProf3(String percentageOut_otherAlliedProf3) {
        this.percentageOut_otherAlliedProf3 = percentageOut_otherAlliedProf3;
    }
    public String getPercentageOut_otherAlliedProf4() {
        return percentageOut_otherAlliedProf4;
    }
    public void setPercentageOut_otherAlliedProf4(String percentageOut_otherAlliedProf4) {
        this.percentageOut_otherAlliedProf4 = percentageOut_otherAlliedProf4;
    }
    public String getPercentageOut_otherAlliedProf5() {
        return percentageOut_otherAlliedProf5;
    }
    public void setPercentageOut_otherAlliedProf5(String percentageOut_otherAlliedProf5) {
        this.percentageOut_otherAlliedProf5 = percentageOut_otherAlliedProf5;
    }
    public String getProviderName_otherAlliedNProf1() {
        return providerName_otherAlliedNProf1;
    }
    public void setProviderName_otherAlliedNProf1(String providerName_otherAlliedNProf1) {
        this.providerName_otherAlliedNProf1 = providerName_otherAlliedNProf1;
    }
    public String getProviderName_otherAlliedNProf2() {
        return providerName_otherAlliedNProf2;
    }
    public void setProviderName_otherAlliedNProf2(String providerName_otherAlliedNProf2) {
        this.providerName_otherAlliedNProf2 = providerName_otherAlliedNProf2;
    }
    public String getProviderName_otherAlliedNProf3() {
        return providerName_otherAlliedNProf3;
    }
    public void setProviderName_otherAlliedNProf3(String providerName_otherAlliedNProf3) {
        this.providerName_otherAlliedNProf3 = providerName_otherAlliedNProf3;
    }
    public String getProviderName_otherAlliedNProf4() {
        return providerName_otherAlliedNProf4;
    }
    public void setProviderName_otherAlliedNProf4(String providerName_otherAlliedNProf4) {
        this.providerName_otherAlliedNProf4 = providerName_otherAlliedNProf4;
    }
    public String getProviderName_otherAlliedNProf5() {
        return providerName_otherAlliedNProf5;
    }
    public void setProviderName_otherAlliedNProf5(String providerName_otherAlliedNProf5) {
        this.providerName_otherAlliedNProf5 = providerName_otherAlliedNProf5;
    }
    public String getSummary_annual_otherNursingNP1() {
        return summary_annual_otherNursingNP1;
    }
    public void setSummary_annual_otherNursingNP1(String summary_annual_otherNursingNP1) {
        this.summary_annual_otherNursingNP1 = summary_annual_otherNursingNP1;
    }
    public String getSummary_annual_otherNursingNP2() {
        return summary_annual_otherNursingNP2;
    }
    public void setSummary_annual_otherNursingNP2(String summary_annual_otherNursingNP2) {
        this.summary_annual_otherNursingNP2 = summary_annual_otherNursingNP2;
    }
    public String getSummary_annual_otherNursingNP3() {
        return summary_annual_otherNursingNP3;
    }
    public void setSummary_annual_otherNursingNP3(String summary_annual_otherNursingNP3) {
        this.summary_annual_otherNursingNP3 = summary_annual_otherNursingNP3;
    }
    public String getSummary_annual_otherNursingNP4() {
        return summary_annual_otherNursingNP4;
    }
    public void setSummary_annual_otherNursingNP4(String summary_annual_otherNursingNP4) {
        this.summary_annual_otherNursingNP4 = summary_annual_otherNursingNP4;
    }
    public String getSummary_annual_otherNursingNP5() {
        return summary_annual_otherNursingNP5;
    }
    public void setSummary_annual_otherNursingNP5(String summary_annual_otherNursingNP5) {
        this.summary_annual_otherNursingNP5 = summary_annual_otherNursingNP5;
    }
    public String getSummary_contracted_alliedProf1() {
        return summary_contracted_alliedProf1;
    }
    public void setSummary_contracted_alliedProf1(String summary_contracted_alliedProf1) {
        this.summary_contracted_alliedProf1 = summary_contracted_alliedProf1;
    }
    public String getSummary_contracted_alliedProf2() {
        return summary_contracted_alliedProf2;
    }
    public void setSummary_contracted_alliedProf2(String summary_contracted_alliedProf2) {
        this.summary_contracted_alliedProf2 = summary_contracted_alliedProf2;
    }
    public String getSummary_contracted_alliedProf3() {
        return summary_contracted_alliedProf3;
    }
    public void setSummary_contracted_alliedProf3(String summary_contracted_alliedProf3) {
        this.summary_contracted_alliedProf3 = summary_contracted_alliedProf3;
    }
    public String getSummary_contracted_alliedProf4() {
        return summary_contracted_alliedProf4;
    }
    public void setSummary_contracted_alliedProf4(String summary_contracted_alliedProf4) {
        this.summary_contracted_alliedProf4 = summary_contracted_alliedProf4;
    }
    public String getSummary_contracted_alliedProf5() {
        return summary_contracted_alliedProf5;
    }
    public void setSummary_contracted_alliedProf5(String summary_contracted_alliedProf5) {
        this.summary_contracted_alliedProf5 = summary_contracted_alliedProf5;
    }
    public String getSummary_inHouse_otherNursingP1() {
        return summary_inHouse_otherNursingP1;
    }
    public void setSummary_inHouse_otherNursingP1(String summary_inHouse_otherNursingP1) {
        this.summary_inHouse_otherNursingP1 = summary_inHouse_otherNursingP1;
    }
    public String getSummary_inHouse_otherNursingP2() {
        return summary_inHouse_otherNursingP2;
    }
    public void setSummary_inHouse_otherNursingP2(String summary_inHouse_otherNursingP2) {
        this.summary_inHouse_otherNursingP2 = summary_inHouse_otherNursingP2;
    }
    public String getSummary_inHouse_otherNursingP3() {
        return summary_inHouse_otherNursingP3;
    }
    public void setSummary_inHouse_otherNursingP3(String summary_inHouse_otherNursingP3) {
        this.summary_inHouse_otherNursingP3 = summary_inHouse_otherNursingP3;
    }
    public String getSummary_inHouse_otherNursingP4() {
        return summary_inHouse_otherNursingP4;
    }
    public void setSummary_inHouse_otherNursingP4(String summary_inHouse_otherNursingP4) {
        this.summary_inHouse_otherNursingP4 = summary_inHouse_otherNursingP4;
    }
    public String getSummary_inHouse_otherNursingP5() {
        return summary_inHouse_otherNursingP5;
    }
    public void setSummary_inHouse_otherNursingP5(String summary_inHouse_otherNursingP5) {
        this.summary_inHouse_otherNursingP5 = summary_inHouse_otherNursingP5;
    }
    public String getContractedOut_otherAlliedNProf1() {
        return contractedOut_otherAlliedNProf1;
    }
    public void setContractedOut_otherAlliedNProf1(String contractedOut_otherAlliedNProf1) {
        this.contractedOut_otherAlliedNProf1 = contractedOut_otherAlliedNProf1;
    }
    public String getContractedOut_otherAlliedNProf2() {
        return contractedOut_otherAlliedNProf2;
    }
    public void setContractedOut_otherAlliedNProf2(String contractedOut_otherAlliedNProf2) {
        this.contractedOut_otherAlliedNProf2 = contractedOut_otherAlliedNProf2;
    }
    public String getContractedOut_otherAlliedNProf3() {
        return contractedOut_otherAlliedNProf3;
    }
    public void setContractedOut_otherAlliedNProf3(String contractedOut_otherAlliedNProf3) {
        this.contractedOut_otherAlliedNProf3 = contractedOut_otherAlliedNProf3;
    }
    public String getContractedOut_otherAlliedNProf4() {
        return contractedOut_otherAlliedNProf4;
    }
    public void setContractedOut_otherAlliedNProf4(String contractedOut_otherAlliedNProf4) {
        this.contractedOut_otherAlliedNProf4 = contractedOut_otherAlliedNProf4;
    }
    public String getContractedOut_otherAlliedNProf5() {
        return contractedOut_otherAlliedNProf5;
    }
    public void setContractedOut_otherAlliedNProf5(String contractedOut_otherAlliedNProf5) {
        this.contractedOut_otherAlliedNProf5 = contractedOut_otherAlliedNProf5;
    }
    public String getPercentageOut_otherAlliedNProf1() {
        return percentageOut_otherAlliedNProf1;
    }
    public void setPercentageOut_otherAlliedNProf1(String percentageOut_otherAlliedNProf1) {
        this.percentageOut_otherAlliedNProf1 = percentageOut_otherAlliedNProf1;
    }
    public String getPercentageOut_otherAlliedNProf2() {
        return percentageOut_otherAlliedNProf2;
    }
    public void setPercentageOut_otherAlliedNProf2(String percentageOut_otherAlliedNProf2) {
        this.percentageOut_otherAlliedNProf2 = percentageOut_otherAlliedNProf2;
    }
    public String getPercentageOut_otherAlliedNProf3() {
        return percentageOut_otherAlliedNProf3;
    }
    public void setPercentageOut_otherAlliedNProf3(String percentageOut_otherAlliedNProf3) {
        this.percentageOut_otherAlliedNProf3 = percentageOut_otherAlliedNProf3;
    }
    public String getPercentageOut_otherAlliedNProf4() {
        return percentageOut_otherAlliedNProf4;
    }
    public void setPercentageOut_otherAlliedNProf4(String percentageOut_otherAlliedNProf4) {
        this.percentageOut_otherAlliedNProf4 = percentageOut_otherAlliedNProf4;
    }
    public String getPercentageOut_otherAlliedNProf5() {
        return percentageOut_otherAlliedNProf5;
    }
    public void setPercentageOut_otherAlliedNProf5(String percentageOut_otherAlliedNProf5) {
        this.percentageOut_otherAlliedNProf5 = percentageOut_otherAlliedNProf5;
    }
    public String getSummary_annual_otherAlliedProf1() {
        return summary_annual_otherAlliedProf1;
    }
    public void setSummary_annual_otherAlliedProf1(String summary_annual_otherAlliedProf1) {
        this.summary_annual_otherAlliedProf1 = summary_annual_otherAlliedProf1;
    }
    public String getSummary_annual_otherAlliedProf2() {
        return summary_annual_otherAlliedProf2;
    }
    public void setSummary_annual_otherAlliedProf2(String summary_annual_otherAlliedProf2) {
        this.summary_annual_otherAlliedProf2 = summary_annual_otherAlliedProf2;
    }
    public String getSummary_annual_otherAlliedProf3() {
        return summary_annual_otherAlliedProf3;
    }
    public void setSummary_annual_otherAlliedProf3(String summary_annual_otherAlliedProf3) {
        this.summary_annual_otherAlliedProf3 = summary_annual_otherAlliedProf3;
    }
    public String getSummary_annual_otherAlliedProf4() {
        return summary_annual_otherAlliedProf4;
    }
    public void setSummary_annual_otherAlliedProf4(String summary_annual_otherAlliedProf4) {
        this.summary_annual_otherAlliedProf4 = summary_annual_otherAlliedProf4;
    }
    public String getSummary_annual_otherAlliedProf5() {
        return summary_annual_otherAlliedProf5;
    }
    public void setSummary_annual_otherAlliedProf5(String summary_annual_otherAlliedProf5) {
        this.summary_annual_otherAlliedProf5 = summary_annual_otherAlliedProf5;
    }
    public String getSummary_contracted_alliedNProf1() {
        return summary_contracted_alliedNProf1;
    }
    public void setSummary_contracted_alliedNProf1(String summary_contracted_alliedNProf1) {
        this.summary_contracted_alliedNProf1 = summary_contracted_alliedNProf1;
    }
    public String getSummary_contracted_alliedNProf2() {
        return summary_contracted_alliedNProf2;
    }
    public void setSummary_contracted_alliedNProf2(String summary_contracted_alliedNProf2) {
        this.summary_contracted_alliedNProf2 = summary_contracted_alliedNProf2;
    }
    public String getSummary_contracted_alliedNProf3() {
        return summary_contracted_alliedNProf3;
    }
    public void setSummary_contracted_alliedNProf3(String summary_contracted_alliedNProf3) {
        this.summary_contracted_alliedNProf3 = summary_contracted_alliedNProf3;
    }
    public String getSummary_contracted_alliedNProf4() {
        return summary_contracted_alliedNProf4;
    }
    public void setSummary_contracted_alliedNProf4(String summary_contracted_alliedNProf4) {
        this.summary_contracted_alliedNProf4 = summary_contracted_alliedNProf4;
    }
    public String getSummary_contracted_alliedNProf5() {
        return summary_contracted_alliedNProf5;
    }
    public void setSummary_contracted_alliedNProf5(String summary_contracted_alliedNProf5) {
        this.summary_contracted_alliedNProf5 = summary_contracted_alliedNProf5;
    }
    public String getSummary_inHouse_otherNursingNP1() {
        return summary_inHouse_otherNursingNP1;
    }
    public void setSummary_inHouse_otherNursingNP1(String summary_inHouse_otherNursingNP1) {
        this.summary_inHouse_otherNursingNP1 = summary_inHouse_otherNursingNP1;
    }
    public String getSummary_inHouse_otherNursingNP2() {
        return summary_inHouse_otherNursingNP2;
    }
    public void setSummary_inHouse_otherNursingNP2(String summary_inHouse_otherNursingNP2) {
        this.summary_inHouse_otherNursingNP2 = summary_inHouse_otherNursingNP2;
    }
    public String getSummary_inHouse_otherNursingNP3() {
        return summary_inHouse_otherNursingNP3;
    }
    public void setSummary_inHouse_otherNursingNP3(String summary_inHouse_otherNursingNP3) {
        this.summary_inHouse_otherNursingNP3 = summary_inHouse_otherNursingNP3;
    }
    public String getSummary_inHouse_otherNursingNP4() {
        return summary_inHouse_otherNursingNP4;
    }
    public void setSummary_inHouse_otherNursingNP4(String summary_inHouse_otherNursingNP4) {
        this.summary_inHouse_otherNursingNP4 = summary_inHouse_otherNursingNP4;
    }
    public String getSummary_inHouse_otherNursingNP5() {
        return summary_inHouse_otherNursingNP5;
    }
    public void setSummary_inHouse_otherNursingNP5(String summary_inHouse_otherNursingNP5) {
        this.summary_inHouse_otherNursingNP5 = summary_inHouse_otherNursingNP5;
    }
    public String getSummary_annual_otherAlliedNProf1() {
        return summary_annual_otherAlliedNProf1;
    }
    public void setSummary_annual_otherAlliedNProf1(String summary_annual_otherAlliedNProf1) {
        this.summary_annual_otherAlliedNProf1 = summary_annual_otherAlliedNProf1;
    }
    public String getSummary_annual_otherAlliedNProf2() {
        return summary_annual_otherAlliedNProf2;
    }
    public void setSummary_annual_otherAlliedNProf2(String summary_annual_otherAlliedNProf2) {
        this.summary_annual_otherAlliedNProf2 = summary_annual_otherAlliedNProf2;
    }
    public String getSummary_annual_otherAlliedNProf3() {
        return summary_annual_otherAlliedNProf3;
    }
    public void setSummary_annual_otherAlliedNProf3(String summary_annual_otherAlliedNProf3) {
        this.summary_annual_otherAlliedNProf3 = summary_annual_otherAlliedNProf3;
    }
    public String getSummary_annual_otherAlliedNProf4() {
        return summary_annual_otherAlliedNProf4;
    }
    public void setSummary_annual_otherAlliedNProf4(String summary_annual_otherAlliedNProf4) {
        this.summary_annual_otherAlliedNProf4 = summary_annual_otherAlliedNProf4;
    }
    public String getSummary_annual_otherAlliedNProf5() {
        return summary_annual_otherAlliedNProf5;
    }
    public void setSummary_annual_otherAlliedNProf5(String summary_annual_otherAlliedNProf5) {
        this.summary_annual_otherAlliedNProf5 = summary_annual_otherAlliedNProf5;
    }
    public String getSummary_inHouse_otherAlliedProf1() {
        return summary_inHouse_otherAlliedProf1;
    }
    public void setSummary_inHouse_otherAlliedProf1(String summary_inHouse_otherAlliedProf1) {
        this.summary_inHouse_otherAlliedProf1 = summary_inHouse_otherAlliedProf1;
    }
    public String getSummary_inHouse_otherAlliedProf2() {
        return summary_inHouse_otherAlliedProf2;
    }
    public void setSummary_inHouse_otherAlliedProf2(String summary_inHouse_otherAlliedProf2) {
        this.summary_inHouse_otherAlliedProf2 = summary_inHouse_otherAlliedProf2;
    }
    public String getSummary_inHouse_otherAlliedProf3() {
        return summary_inHouse_otherAlliedProf3;
    }
    public void setSummary_inHouse_otherAlliedProf3(String summary_inHouse_otherAlliedProf3) {
        this.summary_inHouse_otherAlliedProf3 = summary_inHouse_otherAlliedProf3;
    }
    public String getSummary_inHouse_otherAlliedProf4() {
        return summary_inHouse_otherAlliedProf4;
    }
    public void setSummary_inHouse_otherAlliedProf4(String summary_inHouse_otherAlliedProf4) {
        this.summary_inHouse_otherAlliedProf4 = summary_inHouse_otherAlliedProf4;
    }
    public String getSummary_inHouse_otherAlliedProf5() {
        return summary_inHouse_otherAlliedProf5;
    }
    public void setSummary_inHouse_otherAlliedProf5(String summary_inHouse_otherAlliedProf5) {
        this.summary_inHouse_otherAlliedProf5 = summary_inHouse_otherAlliedProf5;
    }
    public String getSummary_contracted_otherNursingP1() {
        return summary_contracted_otherNursingP1;
    }
    public void setSummary_contracted_otherNursingP1(String summary_contracted_otherNursingP1) {
        this.summary_contracted_otherNursingP1 = summary_contracted_otherNursingP1;
    }
    public String getSummary_contracted_otherNursingP2() {
        return summary_contracted_otherNursingP2;
    }
    public void setSummary_contracted_otherNursingP2(String summary_contracted_otherNursingP2) {
        this.summary_contracted_otherNursingP2 = summary_contracted_otherNursingP2;
    }
    public String getSummary_contracted_otherNursingP3() {
        return summary_contracted_otherNursingP3;
    }
    public void setSummary_contracted_otherNursingP3(String summary_contracted_otherNursingP3) {
        this.summary_contracted_otherNursingP3 = summary_contracted_otherNursingP3;
    }
    public String getSummary_contracted_otherNursingP4() {
        return summary_contracted_otherNursingP4;
    }
    public void setSummary_contracted_otherNursingP4(String summary_contracted_otherNursingP4) {
        this.summary_contracted_otherNursingP4 = summary_contracted_otherNursingP4;
    }
    public String getSummary_contracted_otherNursingP5() {
        return summary_contracted_otherNursingP5;
    }
    public void setSummary_contracted_otherNursingP5(String summary_contracted_otherNursingP5) {
        this.summary_contracted_otherNursingP5 = summary_contracted_otherNursingP5;
    }
    public String getSummary_inHouse_otherAlliedNProf1() {
        return summary_inHouse_otherAlliedNProf1;
    }
    public void setSummary_inHouse_otherAlliedNProf1(String summary_inHouse_otherAlliedNProf1) {
        this.summary_inHouse_otherAlliedNProf1 = summary_inHouse_otherAlliedNProf1;
    }
    public String getSummary_inHouse_otherAlliedNProf2() {
        return summary_inHouse_otherAlliedNProf2;
    }
    public void setSummary_inHouse_otherAlliedNProf2(String summary_inHouse_otherAlliedNProf2) {
        this.summary_inHouse_otherAlliedNProf2 = summary_inHouse_otherAlliedNProf2;
    }
    public String getSummary_inHouse_otherAlliedNProf3() {
        return summary_inHouse_otherAlliedNProf3;
    }
    public void setSummary_inHouse_otherAlliedNProf3(String summary_inHouse_otherAlliedNProf3) {
        this.summary_inHouse_otherAlliedNProf3 = summary_inHouse_otherAlliedNProf3;
    }
    public String getSummary_inHouse_otherAlliedNProf4() {
        return summary_inHouse_otherAlliedNProf4;
    }
    public void setSummary_inHouse_otherAlliedNProf4(String summary_inHouse_otherAlliedNProf4) {
        this.summary_inHouse_otherAlliedNProf4 = summary_inHouse_otherAlliedNProf4;
    }
    public String getSummary_inHouse_otherAlliedNProf5() {
        return summary_inHouse_otherAlliedNProf5;
    }
    public void setSummary_inHouse_otherAlliedNProf5(String summary_inHouse_otherAlliedNProf5) {
        this.summary_inHouse_otherAlliedNProf5 = summary_inHouse_otherAlliedNProf5;
    }
    public String getSummary_contracted_otherNursingNP1() {
        return summary_contracted_otherNursingNP1;
    }
    public void setSummary_contracted_otherNursingNP1(String summary_contracted_otherNursingNP1) {
        this.summary_contracted_otherNursingNP1 = summary_contracted_otherNursingNP1;
    }
    public String getSummary_contracted_otherNursingNP2() {
        return summary_contracted_otherNursingNP2;
    }
    public void setSummary_contracted_otherNursingNP2(String summary_contracted_otherNursingNP2) {
        this.summary_contracted_otherNursingNP2 = summary_contracted_otherNursingNP2;
    }
    public String getSummary_contracted_otherNursingNP3() {
        return summary_contracted_otherNursingNP3;
    }
    public void setSummary_contracted_otherNursingNP3(String summary_contracted_otherNursingNP3) {
        this.summary_contracted_otherNursingNP3 = summary_contracted_otherNursingNP3;
    }
    public String getSummary_contracted_otherNursingNP4() {
        return summary_contracted_otherNursingNP4;
    }
    public void setSummary_contracted_otherNursingNP4(String summary_contracted_otherNursingNP4) {
        this.summary_contracted_otherNursingNP4 = summary_contracted_otherNursingNP4;
    }
    public String getSummary_contracted_otherNursingNP5() {
        return summary_contracted_otherNursingNP5;
    }
    public void setSummary_contracted_otherNursingNP5(String summary_contracted_otherNursingNP5) {
        this.summary_contracted_otherNursingNP5 = summary_contracted_otherNursingNP5;
    }
    public String getSummary_contracted_otherAlliedProf1() {
        return summary_contracted_otherAlliedProf1;
    }
    public void setSummary_contracted_otherAlliedProf1(String summary_contracted_otherAlliedProf1) {
        this.summary_contracted_otherAlliedProf1 = summary_contracted_otherAlliedProf1;
    }
    public String getSummary_contracted_otherAlliedProf2() {
        return summary_contracted_otherAlliedProf2;
    }
    public void setSummary_contracted_otherAlliedProf2(String summary_contracted_otherAlliedProf2) {
        this.summary_contracted_otherAlliedProf2 = summary_contracted_otherAlliedProf2;
    }
    public String getSummary_contracted_otherAlliedProf3() {
        return summary_contracted_otherAlliedProf3;
    }
    public void setSummary_contracted_otherAlliedProf3(String summary_contracted_otherAlliedProf3) {
        this.summary_contracted_otherAlliedProf3 = summary_contracted_otherAlliedProf3;
    }
    public String getSummary_contracted_otherAlliedProf4() {
        return summary_contracted_otherAlliedProf4;
    }
    public void setSummary_contracted_otherAlliedProf4(String summary_contracted_otherAlliedProf4) {
        this.summary_contracted_otherAlliedProf4 = summary_contracted_otherAlliedProf4;
    }
    public String getSummary_contracted_otherAlliedProf5() {
        return summary_contracted_otherAlliedProf5;
    }
    public void setSummary_contracted_otherAlliedProf5(String summary_contracted_otherAlliedProf5) {
        this.summary_contracted_otherAlliedProf5 = summary_contracted_otherAlliedProf5;
    }
    public String getSummary_contracted_otherAlliedNProf1() {
        return summary_contracted_otherAlliedNProf1;
    }
    public void setSummary_contracted_otherAlliedNProf1(String summary_contracted_otherAlliedNProf1) {
        this.summary_contracted_otherAlliedNProf1 = summary_contracted_otherAlliedNProf1;
    }
    public String getSummary_contracted_otherAlliedNProf2() {
        return summary_contracted_otherAlliedNProf2;
    }
    public void setSummary_contracted_otherAlliedNProf2(String summary_contracted_otherAlliedNProf2) {
        this.summary_contracted_otherAlliedNProf2 = summary_contracted_otherAlliedNProf2;
    }
    public String getSummary_contracted_otherAlliedNProf3() {
        return summary_contracted_otherAlliedNProf3;
    }
    public void setSummary_contracted_otherAlliedNProf3(String summary_contracted_otherAlliedNProf3) {
        this.summary_contracted_otherAlliedNProf3 = summary_contracted_otherAlliedNProf3;
    }
    public String getSummary_contracted_otherAlliedNProf4() {
        return summary_contracted_otherAlliedNProf4;
    }
    public void setSummary_contracted_otherAlliedNProf4(String summary_contracted_otherAlliedNProf4) {
        this.summary_contracted_otherAlliedNProf4 = summary_contracted_otherAlliedNProf4;
    }
    public String getSummary_contracted_otherAlliedNProf5() {
        return summary_contracted_otherAlliedNProf5;
    }
    public void setSummary_contracted_otherAlliedNProf5(String summary_contracted_otherAlliedNProf5) {
        this.summary_contracted_otherAlliedNProf5 = summary_contracted_otherAlliedNProf5;
    }
    public String getDoesTheStaffingPatternProvideNote1() {
        return doesTheStaffingPatternProvideNote1;
    }
    public void setDoesTheStaffingPatternProvideNote1(String doesTheStaffingPatternProvideNote1) {
        this.doesTheStaffingPatternProvideNote1 = doesTheStaffingPatternProvideNote1;
    }
    public String getDoesTheStaffingPatternProvideNote2() {
        return doesTheStaffingPatternProvideNote2;
    }
    public void setDoesTheStaffingPatternProvideNote2(String doesTheStaffingPatternProvideNote2) {
        this.doesTheStaffingPatternProvideNote2 = doesTheStaffingPatternProvideNote2;
    }
    public String getDoesTheStaffingPatternProvideNote3() {
        return doesTheStaffingPatternProvideNote3;
    }
    public void setDoesTheStaffingPatternProvideNote3(String doesTheStaffingPatternProvideNote3) {
        this.doesTheStaffingPatternProvideNote3 = doesTheStaffingPatternProvideNote3;
    }
    public String getDoesTheStaffingPatternProvideNote4() {
        return doesTheStaffingPatternProvideNote4;
    }
    public void setDoesTheStaffingPatternProvideNote4(String doesTheStaffingPatternProvideNote4) {
        this.doesTheStaffingPatternProvideNote4 = doesTheStaffingPatternProvideNote4;
    }
    public String getDoesTheStaffingPatternProvideNote5() {
        return doesTheStaffingPatternProvideNote5;
    }
    public void setDoesTheStaffingPatternProvideNote5(String doesTheStaffingPatternProvideNote5) {
        this.doesTheStaffingPatternProvideNote5 = doesTheStaffingPatternProvideNote5;
    }
    public String[] getDoesTheStaffingPatternProvide1() {
        return doesTheStaffingPatternProvide1;
    }
    public void setDoesTheStaffingPatternProvide1(String[] doesTheStaffingPatternProvide1) {
        this.doesTheStaffingPatternProvide1 = doesTheStaffingPatternProvide1;
    }
    public String[] getDoesTheStaffingPatternProvide2() {
        return doesTheStaffingPatternProvide2;
    }
    public void setDoesTheStaffingPatternProvide2(String[] doesTheStaffingPatternProvide2) {
        this.doesTheStaffingPatternProvide2 = doesTheStaffingPatternProvide2;
    }
    public String[] getDoesTheStaffingPatternProvide3() {
        return doesTheStaffingPatternProvide3;
    }
    public void setDoesTheStaffingPatternProvide3(String[] doesTheStaffingPatternProvide3) {
        this.doesTheStaffingPatternProvide3 = doesTheStaffingPatternProvide3;
    }
    public String[] getDoesTheStaffingPatternProvide4() {
        return doesTheStaffingPatternProvide4;
    }
    public void setDoesTheStaffingPatternProvide4(String[] doesTheStaffingPatternProvide4) {
        this.doesTheStaffingPatternProvide4 = doesTheStaffingPatternProvide4;
    }
    public String[] getDoesTheStaffingPatternProvide5() {
        return doesTheStaffingPatternProvide5;
    }
    public void setDoesTheStaffingPatternProvide5(String[] doesTheStaffingPatternProvide5) {
        this.doesTheStaffingPatternProvide5 = doesTheStaffingPatternProvide5;
    }
    public ArrayList<NpDatagrid> getNpDatagrid1() {
        return npDatagrid1;
    }
    public void setNpDatagrid1(ArrayList<NpDatagrid> npDatagrid1) {
        this.npDatagrid1 = npDatagrid1;
    }
    public ArrayList<NpDatagrid> getNpDatagrid2() {
        return npDatagrid2;
    }
    public void setNpDatagrid2(ArrayList<NpDatagrid> npDatagrid2) {
        this.npDatagrid2 = npDatagrid2;
    }
    public ArrayList<NpDatagrid> getNpDatagrid3() {
        return npDatagrid3;
    }
    public void setNpDatagrid3(ArrayList<NpDatagrid> npDatagrid3) {
        this.npDatagrid3 = npDatagrid3;
    }
    public ArrayList<NpDatagrid> getNpDatagrid4() {
        return npDatagrid4;
    }
    public void setNpDatagrid4(ArrayList<NpDatagrid> npDatagrid4) {
        this.npDatagrid4 = npDatagrid4;
    }
    public ArrayList<NpDatagrid> getNpDatagrid5() {
        return npDatagrid5;
    }
    public void setNpDatagrid5(ArrayList<NpDatagrid> npDatagrid5) {
        this.npDatagrid5 = npDatagrid5;
    }
    public ArrayList<NnpDatagrid> getNnpDatagrid1() {
        return nnpDatagrid1;
    }
    public void setNnpDatagrid1(ArrayList<NnpDatagrid> nnpDatagrid1) {
        this.nnpDatagrid1 = nnpDatagrid1;
    }
    public ArrayList<NnpDatagrid> getNnpDatagrid2() {
        return nnpDatagrid2;
    }
    public void setNnpDatagrid2(ArrayList<NnpDatagrid> nnpDatagrid2) {
        this.nnpDatagrid2 = nnpDatagrid2;
    }
    public ArrayList<NnpDatagrid> getNnpDatagrid3() {
        return nnpDatagrid3;
    }
    public void setNnpDatagrid3(ArrayList<NnpDatagrid> nnpDatagrid3) {
        this.nnpDatagrid3 = nnpDatagrid3;
    }
    public ArrayList<NnpDatagrid> getNnpDatagrid4() {
        return nnpDatagrid4;
    }
    public void setNnpDatagrid4(ArrayList<NnpDatagrid> nnpDatagrid4) {
        this.nnpDatagrid4 = nnpDatagrid4;
    }
    public ArrayList<NnpDatagrid> getNnpDatagrid5() {
        return nnpDatagrid5;
    }
    public void setNnpDatagrid5(ArrayList<NnpDatagrid> nnpDatagrid5) {
        this.nnpDatagrid5 = nnpDatagrid5;
    }
    public ArrayList<AldDatagrid> getAldDatagrid1() {
        return aldDatagrid1;
    }
    public void setAldDatagrid1(ArrayList<AldDatagrid> aldDatagrid1) {
        this.aldDatagrid1 = aldDatagrid1;
    }
    public ArrayList<AldDatagrid> getAldDatagrid2() {
        return aldDatagrid2;
    }
    public void setAldDatagrid2(ArrayList<AldDatagrid> aldDatagrid2) {
        this.aldDatagrid2 = aldDatagrid2;
    }
    public ArrayList<AldDatagrid> getAldDatagrid3() {
        return aldDatagrid3;
    }
    public void setAldDatagrid3(ArrayList<AldDatagrid> aldDatagrid3) {
        this.aldDatagrid3 = aldDatagrid3;
    }
    public ArrayList<AldDatagrid> getAldDatagrid4() {
        return aldDatagrid4;
    }
    public void setAldDatagrid4(ArrayList<AldDatagrid> aldDatagrid4) {
        this.aldDatagrid4 = aldDatagrid4;
    }
    public ArrayList<AldDatagrid> getAldDatagrid5() {
        return aldDatagrid5;
    }
    public void setAldDatagrid5(ArrayList<AldDatagrid> aldDatagrid5) {
        this.aldDatagrid5 = aldDatagrid5;
    }
    public ArrayList<AldNopDatagrid> getAldnopDatagrid1() {
        return aldnopDatagrid1;
    }
    public void setAldnopDatagrid1(ArrayList<AldNopDatagrid> aldNopDatagrid1) {
        this.aldnopDatagrid1 = aldNopDatagrid1;
    }
    public ArrayList<AldNopDatagrid> getAldnopDatagrid2() {
        return aldnopDatagrid2;
    }
    public void setAldnopDatagrid2(ArrayList<AldNopDatagrid> aldNopDatagrid2) {
        this.aldnopDatagrid2 = aldNopDatagrid2;
    }
    public ArrayList<AldNopDatagrid> getAldnopDatagrid3() {
        return aldnopDatagrid3;
    }
    public void setAldnopDatagrid3(ArrayList<AldNopDatagrid> aldNopDatagrid3) {
        this.aldnopDatagrid3 = aldNopDatagrid3;
    }
    public ArrayList<AldNopDatagrid> getAldnopDatagrid4() {
        return aldnopDatagrid4;
    }
    public void setAldnopDatagrid4(ArrayList<AldNopDatagrid> aldNopDatagrid4) {
        this.aldnopDatagrid4 = aldNopDatagrid4;
    }
    public ArrayList<AldNopDatagrid> getAldnopDatagrid5() {
        return aldnopDatagrid5;
    }
    public void setAldnopDatagrid5(ArrayList<AldNopDatagrid> aldNopDatagrid5) {
        this.aldnopDatagrid5 = aldNopDatagrid5;
    }
}
