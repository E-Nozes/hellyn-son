package br.com.fiap.hellynson.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Map the 'landfill' table in the database.
 *
 * @author Gabriel Oliveira
 */
@Entity
@Table(name = "landfill")
public class Landfill {

    @Id
    @Column(name = "landfill_id")
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
        return "Landfill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                ", responsiblePerson=" + responsiblePerson +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Landfill)) return false;
        Landfill landfill = (Landfill) o;
        return getId().equals(landfill.getId()) &&
                getName().equals(landfill.getName()) &&
                getAddress().equals(landfill.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAddress());
    }

}
