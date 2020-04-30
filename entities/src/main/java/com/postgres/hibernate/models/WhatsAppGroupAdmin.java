package com.postgres.hibernate.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "whatsapp_group_admin")
public class WhatsAppGroupAdmin  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer adminId;

    @Column(name = "admin_name")
    private String adminName;


    @ManyToMany(mappedBy = "admins")
    private Set<WhatsAppGroup> groups;

    public WhatsAppGroupAdmin() {
    }

    public WhatsAppGroupAdmin(String adminName) {
        this.adminName = adminName;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }


    public Set<WhatsAppGroup> getGroups() {
        if(null == groups)
            groups = new HashSet<>();
        return groups;
    }

    public void setGroups(Set<WhatsAppGroup> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WhatsAppGroupAdmin{");
        sb.append("adminId=").append(adminId);
        sb.append(", adminName='").append(adminName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
