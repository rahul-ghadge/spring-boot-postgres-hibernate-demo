package com.postgres.hibernate.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "whatsapp_group")
public class WhatsAppGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "no_of_members")
    private int noOfMembers;

    @Column(name = "created_year")
    private int createdYear;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="admin_groups",
            joinColumns={ @JoinColumn(referencedColumnName="ID") },
            inverseJoinColumns={ @JoinColumn(referencedColumnName="ID") })
    private Set<WhatsAppGroupAdmin> admins;


    public WhatsAppGroup() {
    }

    public WhatsAppGroup(String groupName, int noOfMembers, int createdYear) {
        this.groupName = groupName;
        this.noOfMembers = noOfMembers;
        this.createdYear = createdYear;
    }


    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getNoOfMembers() {
        return noOfMembers;
    }

    public void setNoOfMembers(int noOfMembers) {
        this.noOfMembers = noOfMembers;
    }

    public int getCreatedYear() {
        return createdYear;
    }

    public void setCreatedYear(int createdYear) {
        this.createdYear = createdYear;
    }

    public Set<WhatsAppGroupAdmin> getAdmins() {
        if (null == admins)
            admins = new HashSet<>();
        return admins;
    }

    public void setAdmins(Set<WhatsAppGroupAdmin> admins) {
        this.admins = admins;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WhatsAppGroup{");
        sb.append("groupId=").append(groupId);
        sb.append(", groupName='").append(groupName).append('\'');
        sb.append(", noOfMembers=").append(noOfMembers);
        sb.append(", createdYear=").append(createdYear);
        sb.append('}');
        return sb.toString();
    }
}