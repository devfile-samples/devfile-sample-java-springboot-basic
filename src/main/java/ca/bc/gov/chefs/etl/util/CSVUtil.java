package ca.bc.gov.chefs.etl.util;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import ca.bc.gov.chefs.etl.forms.testform.LoginCredentials;
import ca.bc.gov.chefs.etl.forms.testform.PersonDetails;
import ca.bc.gov.chefs.etl.forms.testform.TestModel;
import ca.bc.gov.chefs.etl.parser.IModel;

public class CSVUtil {

	public static void main(String[] args) {
		List<IModel> ll = new ArrayList<>();
		TestModel testModel = new TestModel();
		LoginCredentials loginCredentials = new LoginCredentials();
		PersonDetails personDetails = new PersonDetails();

		loginCredentials.setUsername("prit27");
		loginCredentials.setPassword("prit9867");

		personDetails.setFirstname("Prit");
		personDetails.setLastname("Thakkar");
		personDetails.setEducation("Dalhousie University");
		personDetails.setBirthPlace("Ahmedabad India");

		testModel.setLoginCredentials(loginCredentials);
		testModel.setPersonDetails(personDetails);

		TestModel testModel2 = new TestModel();
		LoginCredentials loginCredentials2 = new LoginCredentials();
		PersonDetails personDetails2 = new PersonDetails();

		loginCredentials2.setUsername("john98");
		loginCredentials2.setPassword("hiiamjohn");

		personDetails2.setFirstname("John");
		personDetails2.setLastname("Wohnms");
		personDetails2.setEducation("University of Victoria");
		personDetails2.setBirthPlace("Vancouver BC");

		testModel2.setLoginCredentials(loginCredentials2);
		testModel2.setPersonDetails(personDetails2);

		ll.add(testModel);
		ll.add(testModel2);
		Map<String, List<List<String>>> map = provider(ll);
		System.out.println(map.toString());
		FileUtil.writeToCSVFile(map);
	}

	public static Map<String, List<List<String>>> provider(List<IModel> items) {
		Map<String, List<List<String>>> map = new HashMap<>();
		for (IModel item : items) {
			Queue<IModel> children = new LinkedList<>();
			children.addAll(item.getObjects());
			List<List<String>> parentLs = map.getOrDefault(item.getFormType(), new ArrayList<>());
			parentLs.add(item.getCsvElements());
			map.put(item.getFormType(), parentLs);
			while (!children.isEmpty()) {
				IModel model = children.poll();
				List<List<String>> ls = map.getOrDefault(model.getFormType(), new ArrayList<>());
				ls.add(model.getCsvElements());
				map.put(model.getFormType(), ls);
				List<IModel> nestedChildren = model.getObjects();
				if (nestedChildren.size() == 0) {
					continue;
				}
				children.addAll(nestedChildren);
			}
		}
		return map;
	}

	public static String generateFileName(String fileType) {
		DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
		return fileType.concat(LocalDate.now().format(formatter)).concat(".csv");
	}
	
	public static String getFormattedDate(String date) {
		try {
//		String isoDate = date;
//		SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//		SimpleDateFormat targetFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//		String targetDate = targetFormat.format(isoFormat.parse(isoDate));
//		System.out.println(targetDate);
		
		String dateTimeString = date;
        OffsetDateTime dateTime = OffsetDateTime.parse(dateTimeString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = dateTime.format(formatter);
        System.out.println(formattedDateTime);
		return formattedDateTime;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
