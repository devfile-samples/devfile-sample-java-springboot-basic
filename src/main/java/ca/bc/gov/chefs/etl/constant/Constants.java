package ca.bc.gov.chefs.etl.constant;

import java.util.HashMap;
import java.util.Map;

import ca.bc.gov.chefs.etl.util.FileUtil;

public class Constants {

	/*
	 * Constants representing keys in application.properties.
	 * 
	 */
	public final static Map<String, String[]> HEADERS = new HashMap<String, String[]>();
	public final static Map<String,String> UNENC_FILE_PATH = new HashMap<String,String>();
	public final static Map<String,String> ENC_FILE_PATH = new HashMap<String,String>();
	public final static Map<String,String> HA_DICTIONNARY = new HashMap<String,String>();

	/* CHEFS API  */
	public final static String CHEFS_API_URL = "chefs.http.uri";
	public final static String COMPLETED_STATUS = "COMPLETED";

	/* Custom Properties */

	public final static String IS_HEADER_ADDED = "isHeaderAdded";

	/* HealthAuthorities */
	static{
		HA_DICTIONNARY.put("FHA", "fraser");
		HA_DICTIONNARY.put("IHA", "interior");
		HA_DICTIONNARY.put("VIHA", "island");
		HA_DICTIONNARY.put("NHA", "northern");
		HA_DICTIONNARY.put("VCH", "vancouver.coastal");
	}

	/* Default values for empty Strings and Numbers */
	public final static String DEFAULT_STRING_VALUE = "Not Provided";
	public final static String DEFAULT_DECIMAL_VALUE = "-99";
	public final static String DEFAULT_NA_VALUE = "Not Applicable";
	
	/* AIMS */
	public final static String AIMS_USERNAME = "aims.username";
	public final static String AIMS_PASSWORD = "aims.password";

	
	public final static String AIMS_FORM = "AIMS_FORM";
	public final static String AIMS_MISUSE = "AIMS_MISUSE";
	public final static String AIMS_REFERRAL = "AIMS_REFERRAL";

	/* LTC Facility */
	public final static String LTC_FACILITY_PROPERTY = "ltc.facility.";

	/* LTC Quarterly YTD */
	public final static String LTC_YTD_PROPERTY = "ltc.ytd.";
	public final static String IN_SCOPE = "inScope";
	public final static String OUT_OF_SCOPE = "outOfScope";
	public final static String PRIVATE_BED = "privateBed";

	/* LTC Staffing Plan */
	public final static String LTC_STAFFING_PLAN_PROPERTY = "ltc.staffing.plan.";

	// Constants for Sub table: LTC_YTD_DIRECT_CARE_HRS
	public final static String DC_HRS_OTHER = "Other";

	// Constants for Sub table: LTC_YTD_COMP_ADD_POS
	public final static String POS_TYPE_OTHER = "Other";

	public final static String DEFAULT_OTHER_VALUE = "Other";

	/* Form Names */
	public final static String LTC_BED_YTD_OCCUPIED_DAYS = "LTC_BED_YTD_OCCUPIED_DAYS";
	public final static String LTC_BED_YTD_OCCUPANCY_RATE = "LTC_BED_YTD_OCCUPANCY_RATE";
	public final static String LTC_BED_YTD_MAX_OCCUPANCY = "LTC_BED_YTD_MAX_OCCUPANCY";
	public final static String LTC_YTD_DIRECT_CARE_HRS = "LTC_YTD_DIRECT_CARE_HRS";
	public final static String LTC_YTD_COMP_HRS = "LTC_YTD_COMP_HRS";
	public final static String LTC_YTD_COMP_SAL = "LTC_YTD_COMP_SAL";
	public final static String LTC_YTD_COMP_ADD_POS = "LTC_YTD_COMP_ADD_POS";
	public final static String LTC_YTD_DIRECT_CARE_COST = "LTC_YTD_DIRECT_CARE_COST";
	public final static String LTC_YTD_REV = "LTC_YTD_REV";
	public final static String LTC_YTD_EXP = "LTC_YTD_EXP";
	public final static String LTC_YTD_COMP_BENEFITS = "LTC_YTD_COMP_BENEFITS";
	public final static String LTC_YTD_SUBMISSION = "LTC_YTD_SUBMISSION";
	public static final String LTC_YTD_REV_SUBTOTALS = "LTC_YTD_REV_SUBTOTALS";
	public static final String LTC_YTD_EXP_SUBTOTALS = "LTC_YTD_EXP_SUBTOTALS";
	public static final String LTC_YTD_DEP = "LTC_YTD_DEP";
	public static final String LTC_YTD_DEP_SUBTOTALS = "LTC_YTD_DEP_SUBTOTALS";
	public static final String LTC_YTD_SUM_TOTALS = "LTC_YTD_SUM_TOTALS";
	public static final String LTC_YTD_COMP_SAL_SUBTOTALS = "LTC_YTD_COMP_SAL_SUBTOTALS";
	public static final String LTC_BED_YTD_MAX_OCCY_TOTALS = "LTC_BED_YTD_MAX_OCCY_TOTALS";
	public static final String LTC_YTD_COMP_HRS_SUBTOTALS = "LTC_YTD_COMP_HRS_SUBTOTALS";
	public static final String LTC_YTD_COMP_HRS_TOTALS = "LTC_YTD_COMP_HRS_TOTALS";
	public static final String LTC_YTD_COMP_SAL_TOTALS = "LTC_YTD_COMP_SAL_TOTALS";
	public static final String LTC_YTD_DIRECT_CARE_HRS_SUBS = "LTC_YTD_DIRECT_CARE_HRS_SUBS";
	public static final String LTC_YTD_DIRECT_CARE_COST_SUBS = "LTC_YTD_DIRECT_CARE_COST_SUBS";
	public static final String LTC_BED_YTD_OCCUPANCY_RATE_TOT = "LTC_BED_YTD_OCCUPANCY_RATE_TOT";
	public static final String LTC_BED_YTD_OCCUPIED_DAYS_TOT = "LTC_BED_YTD_OCCUPIED_DAYS_TOT";
	public static final String LTC_YTD_DIRECT_CARE_VACANCY = "LTC_YTD_DIRECT_CARE_VACANCY";

	public final static String LTC_FACILITY = "LTC_FACILITY";
	public static final String LTC_FACILITY_APPROVER = "LTC_FACILITY_APPROVER";
	public static final String LTC_FACILITY_PREPARER = "LTC_FACILITY_PREPARER";

	public final static String LTC_STAFFING_SUBMISSION = "LTC_STAFFING_SUBMISSION";
	public final static String LTC_STAFFING_PLAN = "LTC_STAFFING_PLAN";
	public final static String LTC_STAFF_PLAN_PERF_4_2 = "LTC_STAFF_PLAN_PERF_4_2";
	public final static String LTC_STAFF_PLAN_POS_SUBTOTALS = "LTC_STAFF_PLAN_POS_SUBTOTALS";
	public final static String LTC_STAFF_PLAN_POS_TYPE = "LTC_STAFF_PLAN_POS_TYPE";
	public final static String LTC_STAFFING_HRS = "LTC_STAFFING_HRS";
	public final static String LTC_STAFFING_ADD_POS = "LTC_STAFFING_ADD_POS";

	/* File Constants */
	public final static String PROPERTIES_DATA_DIR = "data-dir";
	public final static String PROPERTIES_ENC_DATA_DIR = "enc-data-dir";
	public static final String DATA_DIRECTORY = FileUtil.buildDirectoryPath(PROPERTIES_DATA_DIR);
	public static final String ENCRYPTED_DATA_DIRECTORY = FileUtil.buildDirectoryPath(PROPERTIES_ENC_DATA_DIR);

	public static final String ENCRYPTION_SECRET_PATH = "encryption-secret-path";
	public static final String ENCRYPTION_SECRET_PWD = "encryption-secret-pwd";

	public final static String PROPERTIES_LTC_FACILITY_DIR = "ltc-facility-dir";
	public final static String LTC_FACILITY_DIR = FileUtil.getDirectoryName(PROPERTIES_LTC_FACILITY_DIR);
	public static final String LTC_FACILITY_UNENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_LTC_FACILITY_DIR, false);
	public static final String LTC_FACILITY_ENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_LTC_FACILITY_DIR, true);
	
	public final static String PROPERTIES_AIMS_DIR = "aims-dir";
	public final static String AIMS_DIR = FileUtil.getDirectoryName(PROPERTIES_AIMS_DIR);
	public static final String AIMS_UNENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_AIMS_DIR, false);
	public static final String AIMS_ENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_AIMS_DIR, true);
	
	public final static String PROPERTIES_LTC_QUARTERLY_DIR = "ltc-quarterly-dir";
	public final static String LTC_QUARTERLY_DIR = FileUtil.getDirectoryName(PROPERTIES_LTC_QUARTERLY_DIR);
	public static final String LTC_QUARTERLY_YTD_UNENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_LTC_QUARTERLY_DIR, false);
	public static final String LTC_QUARTERLY_YTD_ENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_LTC_QUARTERLY_DIR, true);

	public final static String PROPERTIES_LTC_STAFFING_PLAN_DIR = "ltc-staffing-plan-dir";
	public final static String LTC_STAFFING_PLAN_DIR = FileUtil.getDirectoryName(PROPERTIES_LTC_STAFFING_PLAN_DIR);
	public static final String LTC_STAFFING_PLAN_UNENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_LTC_STAFFING_PLAN_DIR, false);
	public static final String LTC_STAFFING_PLAN_ENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_LTC_STAFFING_PLAN_DIR, true);

	/* public Encryption Key */
	public final static String PUBLIC_KEY_NAME_PROPERTY = "public-key-file-name";
	public final static String PUBLIC_KEY_PATH = FileUtil.buildPublicKeyPath(PUBLIC_KEY_NAME_PROPERTY);
	


	static {
		
		UNENC_FILE_PATH.put(LTC_FACILITY_DIR, LTC_FACILITY_UNENCRYPTED_FP);
		UNENC_FILE_PATH.put(LTC_QUARTERLY_DIR, LTC_QUARTERLY_YTD_UNENCRYPTED_FP);
		UNENC_FILE_PATH.put(AIMS_DIR,AIMS_UNENCRYPTED_FP);
		UNENC_FILE_PATH.put(LTC_STAFFING_PLAN_DIR, LTC_STAFFING_PLAN_UNENCRYPTED_FP);
		
		ENC_FILE_PATH.put(AIMS_DIR, AIMS_ENCRYPTED_FP);
		ENC_FILE_PATH.put(LTC_FACILITY_DIR, LTC_FACILITY_ENCRYPTED_FP);
		ENC_FILE_PATH.put(LTC_QUARTERLY_DIR, LTC_QUARTERLY_YTD_ENCRYPTED_FP);
		ENC_FILE_PATH.put(LTC_STAFFING_PLAN_DIR, LTC_STAFFING_PLAN_ENCRYPTED_FP);
		
		HEADERS.put("TestModel#Main", new String[] { "confirmationId", "formName", "version", "createdAt", "fullName",
				"username", "email", "status", "assignee", "assigneeEmail", });

		HEADERS.put("TestModel#LoginCredentials", new String[] { "username1", "password", "confirmationId" });

		HEADERS.put("TestModel#PersonDetails",
				new String[] { "firstName", "lastName", "birthPlace", "education", "confirmationId" });
		//

		HEADERS.put(AIMS_FORM,
				new String[] { "Confirmation_ID", "Is_Deleted","Submission_Date", "Submitted_by", "Submission_type", "Agency_Code",
						"Program_Type", "Office_Code", "Referral_Source", "Office_Date", "Regional_HA",
						"Contracting_HA", "Health_Num", "Last_Name", "First_Name", "Middle_Name", "Gender", "Birthdate",
						"Postal_Code", "Primary_Language", "Education_Level", "Marital_Status", "Employment_Status",
						"Number_Dependent_Children", "Methadone_Maintenance", "Current_Injection_Drug_Use", "Client_Type",
						"Other_Client_Info", "Substance_Relation", "Primary_Drug_of_Choice", "Is_Screened", "Is_Administered",
						"Is_Referred","Activity_Date", "Activity_Service_Provider_Code", "Discharge_Type", "Discharge_Date",
						"Discharge_Service_Provider_Code", "Discharge_Program_Completion" });
		HEADERS.put(AIMS_MISUSE, new String[] { "Confirmation_ID", "Substance_misuses" });

		HEADERS.put(AIMS_REFERRAL, new String[] { "Confirmation_ID", "AIMS_REFERRAL_NUM", "Referral_Date",
				"Service_Provider_Code", "Referral_Target", });

		// LTC Facility
		HEADERS.put(LTC_FACILITY,
				new String[] { "Confirmation_ID","Is_Deleted", "Submission_Date", "Submitted_by","Facility_Name", "Facility_Address", "Facility_City",
						"Facility_Postal_Code", "Facility_Telephone", "Facility_Website", "CCIMS_ID", "Program_type",
						"Ownership_type", "Legislation_type", "Accreditation_Body", "Accreditation_Date",
						"Accreditation_Expiry_Date", "Health_Authority", "Owner_Name", "Owner_Address", "Owner_City",
						"Owner_postal_code", "Owner_contact_Name","Owner_contact_phone","Owner_contact_position", "Owner_contact_email", "Operator_Name",
						"Operator_Address", "Operator_City", "Operator_postal_code", "Operator_contact_Name",
						"Operator_contact_phone", "Operator_contact_position", "Operator_contact_email", });

		HEADERS.put(LTC_FACILITY_APPROVER, new String[] {
				"CONFIRMATION_ID",
				"APPROVER_NUM",
				"APPROVER_CONTACT_NAME",
				"APPROVER_CONTACT_POSITION",
				"APPROVER_CONTACT_PHONE",
				"APPROVER_CONTACT_EMAIL",	
		});
		HEADERS.put(LTC_FACILITY_PREPARER, new String[] {
				"CONFIRMATION_ID",
				"PREPARER_NUM",
				"PREPARER_CONTACT_NAME",
				"PREPARER_CONTACT_POSITION",
				"PREPARER_CONTACT_PHONE",
				"PREPARER_CONTACT_EMAIL",
		});
		
		// LTC Quarterly YTD
		HEADERS.put(LTC_YTD_SUBMISSION,
				new String[] { "CONFIRMATION_ID", "IS_DELETED", "SUBMISSION_DATE", "SUBMITTED_BY", "CCIMS_ID", "SUBMISSION_TYPE", 
						"PERIOD","SUBMISSION_FY", "NB_TOTAL_BEDS", "NB_FUNDED_BEDS", "OCC_RATE_THRESHOLD", 
						"TOTAL_BENEFITS", "TOTAL_SALARIES_WAGES", "BENEFITS_PERCENT", "TOTAL_VACANCIES" });

		HEADERS.put(LTC_YTD_REV, new String[] { "CONFIRMATION_ID", "REV_TYPE", "REV_NAME", "REV_YTD", "REV_NOTES", });

		HEADERS.put(LTC_YTD_REV_SUBTOTALS, new String[] { "CONFIRMATION_ID", "REV_TYPE", "SUB_TOTAL_REV_YTD", "SUB_TOTAL_REV_NOTES"});

		HEADERS.put(LTC_YTD_EXP, new String[] { "CONFIRMATION_ID", "EXP_TYPE", "EXP_NAME", "EXP_YTD", "EXP_NOTES", });

		HEADERS.put(LTC_YTD_EXP_SUBTOTALS, new String[] { "CONFIRMATION_ID", "EXP_TYPE", "SUB_TOTAL_EXP_YTD", "SUB_TOTAL_EXP_NOTES"});
		
		HEADERS.put(LTC_YTD_DEP, new String[] { "CONFIRMATION_ID", "DEP_NAME", "DEP_YTD", "DEP_NOTES"});
		
		HEADERS.put(LTC_YTD_DEP_SUBTOTALS, new String[] { "CONFIRMATION_ID", "SUB_TOTAL_DEP_YTD", "SUB_TOTAL_DEP_NOTES"});
		
		HEADERS.put(LTC_YTD_SUM_TOTALS, new String[] { "CONFIRMATION_ID", "TOT_NAME", "SUM_YTD","TOT_NOTES"});

		HEADERS.put(LTC_YTD_COMP_SAL,
		new String[] { "CONFIRMATION_ID", "COMP_SAL_TYPE", "COMP_SAL_NAME", "COMP_SAL_STAFF_YTD",
				"COMP_SAL_CONTRACT_SERVICES_YTD", "COMP_SAL_TOTAL_COST_YTD", "COMP_SAL_OTHER_NAME" });

		HEADERS.put(LTC_YTD_COMP_SAL_SUBTOTALS,
		new String[] { "Confirmation_ID", "Comp_Sal_Type", "Sub_Total_Comp_Sal_Staff_YTD",
				"Sub_Total_Comp_Sal_Contract_Services_YTD", "Sub_Total_Comp_Sal_Total_Cost_YTD" });

		HEADERS.put(LTC_YTD_COMP_SAL_TOTALS,
		new String[] { "Confirmation_ID", "Comp_Sal_Total_Type", "Total_Comp_Sal_Staff_YTD",
				"Total_Comp_Sal_Contract_Services_YTD", "Total_Comp_Sal_Total_Cost_YTD" });

		HEADERS.put(LTC_YTD_COMP_HRS,
				new String[] { "CONFIRMATION_ID", "COMP_HRS_TYPE", "COMP_HRS_NAME", "COMP_HRS_STAFF_YTD",
				 "COMP_HRS_CONTRACT_SERVICES_YTD", "COMP_TOTAL_WORKED_HRS_YTD", "COMP_HRS_OTHER_NAME" });

		HEADERS.put(LTC_YTD_COMP_HRS_SUBTOTALS,
				new String[] { "Confirmation_ID", "Comp_Hrs_Type", "Sub_Total_Comp_Hrs_Staff_YTD",
						"Sub_Total_Comp_Hrs_Contract_Services_YTD", "Sub_Total_Comp_Total_Worked_Hrs_YTD", });

		HEADERS.put(LTC_YTD_COMP_HRS_TOTALS,
				new String[] { "Confirmation_ID", "Comp_Hrs_Total_Type", "Total_Comp_Hrs_Staff_YTD",
						"Total_Comp_Hrs_Contract_Services_YTD", "Total_Comp_Hrs_Total_Cost_YTD", });
		
		HEADERS.put(LTC_YTD_COMP_ADD_POS, new String[] { "CONFIRMATION_ID", "ADD_POS_TYPE", "ADD_POS_NAME",
		"ADD_POS_CONTRACTED_OUT_YTD", "ADD_POS_LEGAL_NAME_CONTRACT_SERVICE_YTD", "ADD_POS_PERCENT_SERVICE_CONTRACT_OUT_YTD",
		"ADD_POS_OTHER_NAME" });

		HEADERS.put(LTC_YTD_COMP_BENEFITS, new String[] { "CONFIRMATION_ID", "BENEFITS_TYPE", "BENEFITS_AMOUNT_YTD","BENEFITS_PERCENTAGE_ALLOCATION" });

		HEADERS.put(LTC_YTD_DIRECT_CARE_HRS, new String[] { "CONFIRMATION_ID", "DIR_CARE_TYPE", "DIR_CARE_NAME", "DIR_CARE_OTHER_VALUE",
				"DIR_CARE_PROD_HRS_REG_YTD", "DIR_CARE_PROD_HRS_OT_YTD", "DIR_CARE_PROD_HRS_CONTRACTED_YTD", 
				"DIR_CARE_PROD_HRS_AGENCY_STUFF_UTIL_YTD", "DIR_CARE_PROD_HRS_SUBTOTAL_YTD", "DIR_CARE_PROD_HRS_TOTAL_YTD",
				"DIR_CARE_NON_PROD_HRS_VAC_YTD", "DIR_CARE_NON_PROD_HRS_SICK_YTD", "DIR_CARE_NON_PROD_HRS_OTHER_YTD",
				"DIR_CARE_NON_PROD_HRS_TOTAL_YTD","DIR_CARE_TOTAL_HRS_PAID_YTD"
		});
		HEADERS.put(LTC_YTD_DIRECT_CARE_HRS_SUBS,
				new String[] { "CONFIRMATION_ID", "DIR_CARE_TYPE", "SUB_TOTAL_DIR_CARE_PROD_HRS_REGULAR_YTD",
						"SUB_TOTAL_DIR_CARE_PROD_HRS_OT_YTD", "SUB_TOTAL_DIR_CARE_PROD_HRS_SUBTOTAL_YTD","SUB_TOTAL_DIR_CARE_PROD_HRS_CONT_SERV_YTD",
						"SUB_TOTAL_DIR_CARE_PROD_HRS_AGENCY_STUFF_UTIL_YTD", "SUB_TOTAL_DIR_CARE_PROD_HRS_TOTAL_YTD",
						"SUB_TOTAL_DIR_CARE_NON_PROD_HRS_VAC_YTD", "SUB_TOTAL_DIR_CARE_NON_PROD_HRS_SICK_YTD",
						"SUB_TOTAL_DIR_CARE_NON_PROD_HRS_OTHER_SERV_YTD", "SUB_TOTAL_DIR_CARE_NON_PROD_HRS_TOTAL_YTD",
						"SUB_TOTAL_DIR_CARE_TOTAL_HRS_PAID_YTD",

				});

		HEADERS.put(LTC_YTD_DIRECT_CARE_COST,
		new String[] { "CONFIRMATION_ID", "DIR_CARE_COST_TYPE", "DIR_CARE_COST_NAME","DIR_CARE_OTHER_VALUE",
				"DIR_CARE_COST_PROD_HRS_REG_YTD", "DIR_CARE_COST_PROD_HRS_OT_YTD",
				"DIR_CARE_CST_PROD_HRS_CONTRACTED_YTD", "DIR_CARE_COST_PROD_HRS_AGENCY_STUFF_UTIL_YTD",
				"DIR_CARE_COST_PROD_HRS_SUBTOTAL_YTD", "DIR_CARE_COST_PROD_HRS_TOTAL_YTD", "DIR_CARE_COST_NON_PROD_HRS_VAC_YTD",
				"DIR_CARE_COST_NON_PROD_HRS_SICK_YTD", "DIR_CARE_COST_NON_PROD_HRS_OTHER_YTD",
				"DIR_CARE_COST_NON_PROD_HRS_TOTAL_YTD", "DIR_CARE_COST_TOTAL_HRS_PAID_YTD",
				"DIR_CARE_COST_HOURLY_RATE_STAFF_YTD", "DIR_CARE_COST_HOURLY_RATE_CONTRACTED_YTD"
			});
		
		HEADERS.put(LTC_YTD_DIRECT_CARE_COST_SUBS, new String[] {
				"CONFIRMATION_ID",
				"DIR_CARE_TYPE",
				"SUB_TOTAL_DIR_CARE_COST_PROD_HRS_REGULAR_YTD",
				"SUB_TOTAL_DIR_CARE_COST_PROD_HRS_OT_YTD",
				"SUB_TOTAL_DIR_CARE_COST_PROD_HRS_SUBTOTAL_YTD",
				"SUB_TOTAL_DIR_CARE_COST_PROD_HRS_CONT_SERV_YTD",
				"SUB_TOTAL_DIR_CARE_COST_PROD_HRS_AGENCY_STUFF_UTIL_YTD",
				"SUB_TOTAL_DIR_CARE_COST_PROD_HRS_TOTAL_YTD",
				"SUB_TOTAL_DIR_CARE_COST_NON_PROD_HRS_VAC_YTD",
				"SUB_TOTAL_DIR_CARE_COST_NON_PROD_HRS_SICK_YTD",
				"SUB_TOTAL_DIR_CARE_COST_NON_PROD_HRS_OTHER_SERV_YTD",
				"SUB_TOTAL_DIR_CARE_COST_NON_PROD_HRS_TOTAL_YTD",
				"SUB_TOTAL_DIR_CARE_COST_TOTAL_HRS_PAID_YTD",
				"SUB_TOTAL_DIR_CARE_COST_HOURLY_RATE_STAFF_YTD",
				"SUB_TOTAL_DIR_CARE_COST_HOURLY_RATE_CONTRACTED_YTD",
		});

		HEADERS.put(LTC_BED_YTD_MAX_OCCUPANCY,
		new String[] { "CONFIRMATION_ID", "BED_INDEX", "QUARTER_INVENTORY", "BED_FUNDING_TYPE", "BED_SUBTYPE", "START_DATE",
				"END_DATE", "NUMBER_OF_BEDS", "MAXIMUM_BED_DAYS", "NOTES" });
				
		HEADERS.put(LTC_BED_YTD_MAX_OCCY_TOTALS, new String[] {
				"CONFIRMATION_ID",
				"BED_OCCUPANCY_TYPE",
				"BED_FUNDING_TYPE",
				"TOTAL_BED_QUARTER_1",
				"TOTAL_BED_QUARTER_2",
				"TOTAL_BED_QUARTER_3",
				"TOTAL_BED_QUARTER_4",
				"TOTAL_PLANNED_BED_DAYS"
		});
		
		HEADERS.put(LTC_BED_YTD_OCCUPIED_DAYS, new String[] { "CONFIRMATION_ID", "OCC_QUARTER", "OCC_MONTH",
				"OCC_DAYS_YTD_IN_SCOPE_PUBLIC", "OCC_DAYS_YTD_OUT_SCOPE_PUBLIC", "OCC_DAYS_YTD_PRIVATE","OCC_DAYS_YTD_TOTAL_DAYS"  });
		
		HEADERS.put(LTC_BED_YTD_OCCUPIED_DAYS_TOT, new String[] {
			"CONFIRMATION_ID",
			"OCC_QUARTER",
			"TOTAL_OCC_DAYS_YTD_IN_SCOPE_PUBLIC",
			"TOTAL_OCC_DAYS_YTD_OUT_SCOPE_PUBLIC",
			"TOTAL_OCC_DAYS_YTD_PRIVATE",
			"TOTAL_OCC_DAYS_YTD_TOTAL_DAYS",
		});

		HEADERS.put(LTC_BED_YTD_OCCUPANCY_RATE,
		new String[] { "CONFIRMATION_ID", "OCC_RATE_QUARTER", "OCC_RATE_BED_TYPES", "PLAN_MAX_OCC_DAYS",
		"YTD_MAX_OCC_DAYS", "YTD_OCC_DAYS", "PERCENT_OCC", "OCC_RATE_NOTES", });
				
		HEADERS.put(LTC_BED_YTD_OCCUPANCY_RATE_TOT, new String[] {
				"CONFIRMATION_ID",
				"OCC_RATE_QUARTER",
				"TOTAL_PLAN_MAX_OCC_DAYS",
				"TOTAL_YTD_MAX_OCC_DAYS",
				"TOTAL_YTD_OCC_DAYS",
				"TOTAL_PERCENT_OCC"
		});
		HEADERS.put(LTC_YTD_DIRECT_CARE_VACANCY, new String[] {
				"CONFIRMATION_ID",
				"DIR_CARE_VACANCY_TYPE",
				"DIR_CARE_VACANCY_NAME",
				"DIR_CARE_VAC_POSITIONS",		
				"DIR_CARE_VAC_OTHER_NAME"		
		});

		HEADERS.put(LTC_STAFFING_SUBMISSION, new String[] {
			"CONFIRMATION_ID", "IS_DELETED", "SUBMISSION_DATE", "SUBMITTED_BY", "CCIMS_ID", "SUBMISSION_FY"
		});

		HEADERS.put(LTC_STAFFING_PLAN, new String[] {
			"Confirmation_ID", "Staffing_plan_num", "Staff_Plan_For", "Period_start", "Period_end",
			"Revision_date", "Reason_for_rev", "Nb_Total_Beds", "Cumulative_Total_DCH_Q1", "Cumulative_Total_DCH_Q2",
			"Cumulative_Total_DCH_Q3", "Cumulative_Total_DCH_Q4", "Perf_4.1",
			"Staff_Plan_For_Other"
		});

		HEADERS.put(LTC_STAFF_PLAN_PERF_4_2, new String[] {
			"Confirmation_ID", "Staffing_plan_Num", "Perf_4_2"
		});

		HEADERS.put(LTC_STAFF_PLAN_POS_SUBTOTALS, new String[] {
			"Confirmation_ID", "Staffing_plan_Num", "Staff_Plan_staffing_type", "Sum_Staff_Class_hrs_Mon",
			"Sum_Staff_Class_hrs_Tue","Sum_Staff_Class_hrs_Wed","Sum_Staff_Class_hrs_Thu", "Sum_Staff_Class_hrs_Fri",
			"Sum_Staff_Class_hrs_Sat", "Sum_Staff_Class_hrs_Sun", "Sum_Staff_Class_hrs_Wk_Total", "Sum_Staff_Class_hrs_Annual"
		});

		HEADERS.put(LTC_STAFF_PLAN_POS_TYPE, new String[]{
			"Confirmation_ID", "Staffing_plan_Num", "Staff_hrs_Pos_Type", "Staff_hrs_Pos_Other_Name", "Sum_Staff_hrs_Mon",
			"Sum_Staff_hrs_Tue", "Sum_Staff_hrs_Wed", "Sum_Staff_hrs_Thu", "Sum_Staff_hrs_Fri", "Sum_Staff_hrs_Sat",
			"Sum_Staff_hrs_Sun", "Sum_Staff_hrs_wk_total", "Sum_Staff_hrs_annual", "Sum_Pos_Annual", "Sum_Pos_Inhouse",
			"Sum_Pos_Contracted"
		});

		HEADERS.put(LTC_STAFFING_HRS, new String[]{
			"Confirmation_ID","Staffing_plan_Num", "Staff_hrs_Pos_Type", "Staff_hrs_pos_shift_type", "Staff_hrs_Mon",
			"Staff_hrs_Tue","Staff_hrs_Wed","Staff_hrs_Thu","Staff_hrs_Fri", "Staff_hrs_Sat", "Staff_hrs_Sun",
			"Staff_hrs_Wk_Total", "Staff_hrs_Annual", "RN_24_7"
		});

		HEADERS.put(LTC_STAFFING_ADD_POS, new String[]{
			"Confirmation_ID", "Staffing_plan_Num", "Staff_hrs_Pos_Type", "Staff_hrs_Service_Contract_Out", 
			"Staff_hrs_Legal_Name_Contract_Service", "Staff_hrs_Percent_Service_Contract_Out"
		});
	}
}
