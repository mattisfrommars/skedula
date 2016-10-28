import java.util.Date;

public class CreateAppointmentParams {
    Date startDate;
    Date endDate;
    String createdBy;

    public CreateAppointmentParams(Date startDate, Date endDate, String createdBy) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdBy = createdBy;
    }
}
