package com.slavadolbilov.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Message {
    private String message;
    private String sender;
    private Date recipient;
}
