package com.postgres.hibernate.models;


import javax.persistence.*;

@Entity
@Table(name = "key_details")
public class KeyEntity {

    private static final long serialVersionUID = -1798070786993154676L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_Id", unique = true, nullable = false)
    private Integer keyId;

    @Column(name = "key_no", unique = true, nullable = false)
    private String keyNo;

    private String color;


    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="owner_details_id")
    private OwnerEntity owner;


    public KeyEntity() {
    }

    public KeyEntity(String keyNo, String color) {
        this.keyNo = keyNo;
        this.color = color;
    }

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public String getKeyNo() {
        return keyNo;
    }

    public void setKeyNo(String keyNo) {
        this.keyNo = keyNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public OwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(OwnerEntity owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("KeysEntity{");
        sb.append("keyId=").append(keyId);
        sb.append(", keyNo='").append(keyNo).append('\'');
        sb.append(", color='").append(color);
        sb.append('}');
        return sb.toString();
    }
}
