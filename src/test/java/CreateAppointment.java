import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.matchers.JUnitMatchers.hasItem;

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
