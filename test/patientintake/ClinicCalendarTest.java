package patientintake;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarTest {

    @Test
    public void shouldTestAddAppointment() {
        //set-up
        ClinicCalendar clinicCalendar = new ClinicCalendar();

        //execute
        clinicCalendar.addAppointment(
                "Tarun",
                "Kumar",
                "johnson",
                "2/22/2020 05:45 PM");
        List<PatientAppointment> appointments = clinicCalendar.getAppointments();

        //assertions

        // check list of appointment
        assertNotNull(appointments);
        assertEquals(1,appointments.size());
        PatientAppointment enteredAppointment = appointments.get(0);
        assertEquals("Tarun",enteredAppointment.getPatientFirstName());
        assertEquals("Kumar",enteredAppointment.getPatientLastName());
        assertEquals("Beth Johnson",enteredAppointment.getDoctor().getName());
        assertEquals("2/22/2020 05:45 PM",enteredAppointment.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a")));

        assertSame(Doctor.johnson.getName(),enteredAppointment.getDoctor().getName());
    }
}