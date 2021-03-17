
package emergon.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "Customer")
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

    @Id
    @Column(name = "ID", table = "CUSTOMER", nullable = false, unique = true, insertable = true, updatable = true)
    private int id;
    @Column(name = "NAME", table = "CUSTOMER")
    @Basic(fetch = FetchType.EAGER, optional = false)
    private String name;
    @Column(name = "ZIP")
    private int zip;
    @Transient
    private String zipcode;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getZipcode(){
        if(zipcode == null && zip > 0){
            zipcode = convertToString(zip);
        }
        return zipcode;
    }
    
    public void setZipcode(String zipcode){
        this.zipcode = zipcode;
        this.zip = convertToInt(zipcode);
    }
    
    private String convertToString(int zip){
        return Integer.toString(zip);
    }
    
    private int convertToInt(String zipcode){
        return Integer.parseInt(zipcode);
    }
    
}
