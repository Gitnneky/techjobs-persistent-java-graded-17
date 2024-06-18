package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {


        @NotBlank
        @Size(max=255, message = "Location can only be 255 characters long.")
        private String location;

        @OneToMany
        @JoinColumn(name = "employer_id") //specifies the foreign key column in the Job table
        private List<Job> jobs = new ArrayList<>(); //list of jobs associated with this employer

        public Employer(String location){
            super();
            this.location = location;
        }

        public Employer() {}

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public List<Job> getJobs() {
            return jobs;
        }

        public void setJobs(List<Job> jobs) {
            this.jobs = jobs;
        }
    }

