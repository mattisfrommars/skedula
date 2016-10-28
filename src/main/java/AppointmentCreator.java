import static java.util.UUID.randomUUID;

class AppointmentCreator {
    private final AppointmentCreatorObserver observer;

    AppointmentCreator(AppointmentCreatorObserver observer) {
        this.observer = observer;
    }

    void create() {
        String id = randomUUID().toString();
        observer.setCreatedAppointment(new Appointment(id));
    }
}
