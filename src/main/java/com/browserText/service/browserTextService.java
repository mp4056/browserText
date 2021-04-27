package com.browserText.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.browserText.model.BrowserTextModel;

@Service
public interface browserTextService {

	BrowserTextModel saveBrowserText(BrowserTextModel browserTextModel);

	void deleteBrowserTextById(String id);

	void deleteAll();
	
	List<BrowserTextModel> findBrowserTextById(String id);

	List<BrowserTextModel> findAll();
}
