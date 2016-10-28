import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class CreateAppointment {
    @Test
    public void itCreatesAppointmentWithUniqueId() throws Exception {
        Appointment appointment = createAppointment();
        Appointment appointment2 = createAppointment();
        assertNotEquals(appointment.getId(), appointment2.getId());
    }

    private Appointment createAppointment() {
        AppointmentCreatorSpy spy = new AppointmentCreatorSpy();
        AppointmentCreator creator = new AppointmentCreator(spy);
        creator.create();
        return spy.spyGetCreatedAppointment();
    }

    private class AppointmentCreatorSpy implements AppointmentCreatorObserver {
        private Appointment appointment;

        Appointment spyGetCreatedAppointment() {
            return appointment;
        }

        @Override
        public void setCreatedAppointment(Appointment appointment) {
            this.appointment = appointment;
        }
    }
}
