package com.santiagoposadag.cs50.receiverconsumer.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User implements Serializable {

    @Id
    private String userId;
    private String userName;
    private String userLastName;
    private  String routingKey;

}
