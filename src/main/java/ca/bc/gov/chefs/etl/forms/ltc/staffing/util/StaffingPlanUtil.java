package ca.bc.gov.chefs.etl.forms.ltc.staffing.util;

import java.util.List;

import ca.bc.gov.chefs.etl.forms.ltc.staffing.model.LTCStaffPlanPerf;

public class StaffingPlanUtil {
    
    public static List<LTCStaffPlanPerf> mapPlanPerf(List<LTCStaffPlanPerf> planPerfMap, String[] data, String confirmationID, String index){
        if(data != null && data.length > 0){
            for(String reason : data){
                LTCStaffPlanPerf LTCStaffPlanPerf = new LTCStaffPlanPerf();
                LTCStaffPlanPerf.setConfirmationId(confirmationID);
                LTCStaffPlanPerf.setStaffingPlanNum(index);
                LTCStaffPlanPerf.setPerf_4_2(reason);
                planPerfMap.add(LTCStaffPlanPerf);
            }
        }     
        return  planPerfMap;
    }
}
