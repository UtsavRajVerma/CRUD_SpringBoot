package com.extramarks.form_v2.springboot_v2.repository;

import com.extramarks.form_v2.springboot_v2.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form,Integer> {

}
