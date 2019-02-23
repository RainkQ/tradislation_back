package tk.tnicy.tradislation.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SmallType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer smallTypeId;

    private String typeName;

    private Integer bigTypeId;

    public Integer getSmallTypeId() {
        return smallTypeId;
    }

    public void setSmallTypeId(Integer smallTypeId) {
        this.smallTypeId = smallTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getBigTypeId() {
        return bigTypeId;
    }

    public void setBigTypeId(Integer bigTypeId) {
        this.bigTypeId = bigTypeId;
    }

    public SmallType() {
    }

    public SmallType(Integer smallTypeId, String typeName, Integer bigTypeId) {
        this.smallTypeId = smallTypeId;
        this.typeName = typeName;
        this.bigTypeId = bigTypeId;
    }
}
