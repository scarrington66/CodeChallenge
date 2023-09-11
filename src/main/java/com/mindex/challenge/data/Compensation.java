package com.mindex.challenge.data;

import lombok.Data;
import java.util.Date;

@Data
public class Compensation {
    private String compensationId;
    private double salary;
    private Date effectiveDate;
}
