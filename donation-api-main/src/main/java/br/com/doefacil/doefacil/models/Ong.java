package br.com.doefacil.doefacil.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document
public class Ong {

    @Id
    String _id;
    String ongName;
    String ongAddress;
    String ongEmail;
    String ongPhone;
    String ongImg;
    String ongDescription;
    String ongSite;
    String ongPix;
    String ongBankName;
    String ongBankAgency;
    String ongBankAccount;

}
