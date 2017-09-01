package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Session {

    private String sessionId;
    private Date loginTime;
}
