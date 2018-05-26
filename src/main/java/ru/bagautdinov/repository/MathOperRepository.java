package ru.bagautdinov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bagautdinov.models.MathOper;
import ru.bagautdinov.models.User;

@Repository
public interface MathOperRepository extends JpaRepository<MathOper, Long> {
    MathOper findByOwner(User owner);
}
