package com.scorpions.projectDetailsMgmt.req;

import java.time.Month;
import lombok.Data;

@Data
public class WorkDuration {
    private Month month;
    private Integer year;
}
