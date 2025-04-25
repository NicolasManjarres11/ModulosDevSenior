package com.devsenior.nmanja.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "departments")

public class Department {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name = "department_id")
        private Integer departmentId;

        @Column(name = "department_name", nullable=false)
        private String name;

        @ManyToOne
        @JoinColumn(name ="location_id", referencedColumnName = "location_id")
        private Location location;

        public Integer getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(Integer departmentId) {
            this.departmentId = departmentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        @Override
        public String toString() {
            return String.format("""
                    {
                        id: %d,
                        name: '%s',
                        location: {
                          id: %d,
                          address: '%s',
                          city: '%s'
                        }
                    }
                    """, departmentId, name, location.getId(), location.getAddress(), location.getCity());
}

}
