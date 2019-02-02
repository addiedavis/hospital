package hospital;

import java.util.ArrayList;
import java.util.Collection;

public class Nurse implements MedicalDuties {

	private String name;
	private Collection<Patient> patients = new ArrayList<>();
	private String status;

	public String getName() {
		return name;
	}

	public Nurse(String name) {
		this.name = name;
	}

	@Override
	public void assignPatient(Patient patient) {
		patients.add(patient);
	}

	@Override
	public Collection<Patient> getPatients() {
		return patients;
	}

	@Override
	public String getStatus() {
		if (patients.size() <= 2) {
			status = "Available";
		} else {
			status = "Full";
		}
		return status;

	}

	@Override
	public void careForPatient(Patient patient) {
		patient.increaseHealthLevel(5);
	}

}
