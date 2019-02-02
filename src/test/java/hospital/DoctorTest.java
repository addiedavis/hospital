package hospital;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.instanceOf;

import java.util.Collection;

import org.junit.Test;

public class DoctorTest {
	Doctor underTest = new Doctor("Addie");
	Patient patient = new Patient();

	@Test
	public void shouldHaveAName() {
		String checkName = underTest.getName();
		assertThat(checkName, is("Addie"));
	}

	@Test
	public void shouleBeAnInstanceOfMedicalDuties() {
		assertThat(underTest, instanceOf(MedicalDuties.class));
	}

	@Test
	public void shouldBeAbleToAssignAPatientToDoctorWorkLoad() {
		Patient patient1 = new Patient();
		underTest.assignPatient(patient1);
		Collection<Patient> doctorPatients = underTest.getPatients();
		assertThat(doctorPatients, contains(patient1));
	}

	@Test
	public void statusShouldReportAsAvailableWith2Patients() {
		Patient patient1 = new Patient();
		Patient patient2 = new Patient();
		underTest.assignPatient(patient1);
		underTest.assignPatient(patient2);
		String statusCheck = underTest.getStatus();
		assertThat(statusCheck, is("Available"));
	}

	@Test
	public void statusShouldReportAsFullWith6Patients() {
		Patient patient1 = new Patient();
		Patient patient2 = new Patient();
		Patient patient3 = new Patient();
		Patient patient4 = new Patient();
		Patient patient5 = new Patient();
		Patient patient6 = new Patient();
		underTest.assignPatient(patient1);
		underTest.assignPatient(patient2);
		underTest.assignPatient(patient3);
		underTest.assignPatient(patient4);
		underTest.assignPatient(patient5);
		underTest.assignPatient(patient6);
		String statusCheck = underTest.getStatus();
		assertThat(statusCheck, is("Full"));
	}

	@Test
	public void shouldIncreaseHealthLevelBy5WhenCaredForPatient() {
		underTest.assignPatient(patient);
		underTest.careForPatient(patient);
		int healthCheck = patient.getHealthLevel();
		assertThat(healthCheck, is(15));
	}

	@Test
	public void shouldIncreaseHealthLevelFrom2to7WhenCareForPatient() {
		Patient patient = new Patient(2);
		underTest.assignPatient(patient);
		underTest.careForPatient(patient);
		int healthCheck = patient.getHealthLevel();
		assertThat(healthCheck, is(12));
	}

}
