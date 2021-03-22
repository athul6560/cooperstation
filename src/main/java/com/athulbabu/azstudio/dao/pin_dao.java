package com.athulbabu.azstudio.dao;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.athulbabu.azstudio.model.pinSubmitModel;



public interface pin_dao extends JpaRepository<pinSubmitModel, Integer>{
	
	pinSubmitModel findByEmail(String user_email);
	
	@Transactional
	void deleteByEmail(String user_email);

}
