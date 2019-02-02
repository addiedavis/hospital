package hospital;

import java.util.Collection;

public interface MedicalDuties {

	void assignPatient(Patient patient);

	Collection<Patient> getPatients();

	String getStatus();

	void careForPatient(Patient patient);

}