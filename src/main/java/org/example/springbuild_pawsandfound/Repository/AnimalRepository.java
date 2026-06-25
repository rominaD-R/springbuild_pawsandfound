package org.example.springbuild_pawsandfound.Repository;

import org.example.springbuild_pawsandfound.Models.AnimalShelter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<AnimalShelter, Integer> {
}
