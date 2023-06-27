package ca.bc.gov.chefs.etl.forms.ltc.staffing.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LTCStaffingPlanMainEntity implements IModel{

    private List<LTCStaffingPlan> LTCStaffingPlan;
    private List<LTCStaffPlanPerf> LTCStaffPlanPerf;
    private List<LTCStaffPlanPosType> LTCStaffPlanPosType;
    private List<LTCStaffingHrs> LTCStaffingHrs;
    private List<LTCStaffingAddPos> LTCStaffingAddPos;

    public List<LTCStaffingPlan> getLTCStaffingPlan() {
        return LTCStaffingPlan;
    }

    public void setLTCStaffingPlan(List<LTCStaffingPlan> lTCStaffingPlan) {
        LTCStaffingPlan = lTCStaffingPlan;
    }

    public List<LTCStaffPlanPerf> getLTCStaffPlanPerf() {
        return LTCStaffPlanPerf;
    }

    public void setLTCStaffPlanPerf(List<LTCStaffPlanPerf> lTCStaffPlanPerf) {
        LTCStaffPlanPerf = lTCStaffPlanPerf;
    }

    public List<LTCStaffPlanPosType> getLTCStaffPlanPosType() {
        return LTCStaffPlanPosType;
    }

    public void setLTCStaffPlanPosType(List<LTCStaffPlanPosType> lTCStaffPlanPosType) {
        LTCStaffPlanPosType = lTCStaffPlanPosType;
    }

    public List<LTCStaffingHrs> getLTCStaffingHrs() {
        return LTCStaffingHrs;
    }

    public void setLTCStaffingHrs(List<LTCStaffingHrs> lTCStaffingHrs) {
        LTCStaffingHrs = lTCStaffingHrs;
    }

    public List<LTCStaffingAddPos> getLTCStaffingAddPos() {
        return LTCStaffingAddPos;
    }

    public void setLTCStaffingAddPos(List<LTCStaffingAddPos> lTCStaffingAddPos) {
        LTCStaffingAddPos = lTCStaffingAddPos;
    }

    @Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return null;
	}

	@Override
	public List<String> getCsvElements() {
        return null;
	}

	@Override
	public List<IModel> getObjects() {
        List<IModel> ltcStaffingPlanIModels = new ArrayList<>();
        ltcStaffingPlanIModels.addAll(this.getLTCStaffingPlan());
        ltcStaffingPlanIModels.addAll(this.getLTCStaffPlanPerf());
        ltcStaffingPlanIModels.addAll(this.getLTCStaffPlanPosType());
        ltcStaffingPlanIModels.addAll(this.getLTCStaffingHrs());
        ltcStaffingPlanIModels.addAll(this.getLTCStaffingAddPos());
		return ltcStaffingPlanIModels;
	}

}
