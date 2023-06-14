package br.com.doefacil.doefacil.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document
public class Donor {

    @Id
    String _id;
    String name;
    String address;
    String email;
    String phone_number;

}
