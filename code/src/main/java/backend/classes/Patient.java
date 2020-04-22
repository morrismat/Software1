package backend.classes;

import java.util.Date;
import java.util.List;

import backend.NotImplementedException;
import frontend.EHRRunner;
import frontend.GenericRunner;
import frontend.patient.PatientRunner;

public class Patient extends User {
	private Date DOB;
	private char gender; 
	private String PatientID; 
	private String race; 
	private String ethnicity; 
	private boolean married;

	public Patient(String id) {
		PatientID = id;
	}
	public Patient(String id, java.sql.Date date, char gen,String r, String eth, boolean m) {
		// TODO Auto-generated constructor stub
		PatientID = id;
		DOB = date; 
		gender = gen; 
		race = r; 
		ethnicity = eth; 
		married =m; 
		
	}

	public Patient(List<String> headerList, List<Object> dataList) {
		// Check that the headerList is not null
		if(headerList != null) {
			// Create string constants to represent the class variables
			final String dateOfBirth = "DOB";
			final String patientGender = "Gender";
			final String identification = "ID";
			final String race = "Race";
			final String ethnicBackground = "Ethnicity";
			final String maritalStatus = "MaritalStatus";
			
			// For every value in the headerList
			for(int i = 0; i < headerList.size(); i++) {
				
				// If the string represents the date of birth
				if(headerList.get(i).contentEquals(dateOfBirth)) {
					// Initialize date of birth from the data list
					this.DOB = (Date)dataList.get(i);
				}
				// Otherwise if it represents the gender
				else if(headerList.get(i).contentEquals(patientGender)) {
					// Initialize the gender from the data list
					this.gender = (char)dataList.get(i);
				}
				// Otherwise if it represents the ID
				else if(headerList.get(i).contentEquals(identification)) {
					// Initialize the ID from the data list
					this.PatientID = (String)dataList.get(i);
				}
				// Otherwise if it represents the race
				else if(headerList.get(i).contentEquals(race)) {
					// Initialize the race from the data list
					this.race = (String)dataList.get(i);
				}
				// Otherwise if it represents the ethnicity
				else if(headerList.get(i).contentEquals(ethnicBackground)) {
					// Initialize the ethnicity from the data list
					this.ethnicity = (String)dataList.get(i);
				}
				// Otherwise if it represents marital status
				else if(headerList.get(i).contentEquals(maritalStatus)) {
					// Initialize the marital status from the data list
					this.married = (boolean)dataList.get(i);
				}
				// In any other case report an error for initializing an illegal value
				else {
					System.out.println("Error: initializing illegal Patient value");
				}
			}
		}
		// Otherwise print an error about initializing from empty values
		else {
			System.out.println("Error: initializing from empty set of values");
		}
	}
	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPatientID() {
		return PatientID;
	}

	public void setPatientID(String patientID) {
		PatientID = patientID;
	}
	@Override 
	public GenericRunner accept(EHRRunner r) {
		return new PatientRunner(r);
	}
	

}
