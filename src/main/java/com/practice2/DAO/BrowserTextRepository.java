package com.browserText.DAO;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.browserText.model.BrowserTextModel;

@Repository
public interface BrowserTextRepository extends JpaRepository<BrowserTextModel,String> {
	
	List<BrowserTextModel> findBrowserTextById (String id);
	List<BrowserTextModel> findBrowserTextByTitle (String title);
	List<BrowserTextModel> findAll();
	List<BrowserTextModel> deleteBrowserTextById(String id);
	void deleteAll();

}
