package br.com.doefacil.doefacil.pojo;

public class Ong {

   private String _id;
   private String ongName;
   private String ongAddress;
   private String ongEmail;
   private String ongPhone;
   private String ongImg;
   private String ongDescription;
   private String ongSite;
   private String ongPix;
   private String ongBankName;
   private String ongBankAgency;
   private String ongBankAccount;

   public Ong(String _id, String ongName, String ongAddress, String ongEmail, String ongPhone, String ongImg, String ongDescription, String ongSite, String ongPix, String ongBankName, String ongBankAgency, String ongBankAccount){

       this._id = _id;
       this.ongName = ongName;
       this.ongAddress = ongAddress;
       this.ongEmail = ongEmail;
       this.ongPhone = ongPhone;
       this.ongImg = ongImg;
       this.ongDescription = ongDescription;
       this.ongSite = ongSite;
       this.ongPix = ongPix;
       this.ongBankName = ongBankName;
       this.ongBankAgency = ongBankAgency;
       this.ongBankAccount = ongBankAccount;

   }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getOngName() {
        return ongName;
    }

    public void setOngName(String ongName) {
        this.ongName = ongName;
    }

    public String getOngAddress() {
        return ongAddress;
    }

    public void setOngAddress(String ongAddress) {
        this.ongAddress = ongAddress;
    }

    public String getOngEmail() {
        return ongEmail;
    }

    public void setOngEmail(String ongEmail) {
        this.ongEmail = ongEmail;
    }

    public String getOngPhone() {
        return ongPhone;
    }

    public void setOngPhone(String ongPhone) {
        this.ongPhone = ongPhone;
    }

    public String getOngImg() {
        return ongImg;
    }

    public void setOngImg(String ongImg) {
        this.ongImg = ongImg;
    }

    public String getOngDescription() {
        return ongDescription;
    }

    public void setOngDescription(String ongDescription) {
        this.ongDescription = ongDescription;
    }

    public String getOngSite() {
        return ongSite;
    }

    public void setOngSite(String ongSite) {
        this.ongSite = ongSite;
    }

    public String getOngPix() {
        return ongPix;
    }

    public void setOngPix(String ongPix) {
        this.ongPix = ongPix;
    }

    public String getOngBankName() {
        return ongBankName;
    }

    public void setOngBankName(String ongBankName) {
        this.ongBankName = ongBankName;
    }

    public String getOngBankAgency() {
        return ongBankAgency;
    }

    public void setOngBankAgency(String ongBankAgency) {
        this.ongBankAgency = ongBankAgency;
    }

    public String getOngBankAccount() {
        return ongBankAccount;
    }

    public void setOngBankAccount(String ongBankAccount) {
        this.ongBankAccount = ongBankAccount;
    }
}
