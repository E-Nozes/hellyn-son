package br.com.fiap.hellynson.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Map the 'recycling_center' table in the database.
 *
 * @author Gabriel Oliveira
 */
@Entity
@Table(name = "recycling_center")
public class RecyclingCenter {

    @Id
    @Column(name = "recycling_center_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String name;

    @NotEmpty
    @Size(max = 100)
    @Column(length = 100)
    private String notes;

    @NotNull
    @Column(nullable = false)
    private Boolean cooperative;

    @ManyToOne
    @JoinColumn(name = "responsible_person_id")
    private ResponsiblePerson responsiblePerson;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getCooperative() {
        return cooperative;
    }

    public void setCooperative(Boolean cooperative) {
        this.cooperative = cooperative;
    }

    public ResponsiblePerson getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(ResponsiblePerson responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "RecyclingCenter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                ", cooperative=" + cooperative +
                ", responsiblePerson=" + responsiblePerson +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecyclingCenter)) return false;
        RecyclingCenter that = (RecyclingCenter) o;
        return getId().equals(that.getId()) &&
                getName().equals(that.getName()) &&
                getCooperative().equals(that.getCooperative()) &&
                getAddress().equals(that.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCooperative(), getAddress());
    }

}
