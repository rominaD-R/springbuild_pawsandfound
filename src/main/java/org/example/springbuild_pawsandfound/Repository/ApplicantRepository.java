package org.example.springbuild_pawsandfound.Repository;

import org.example.springbuild_pawsandfound.Models.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {

}
