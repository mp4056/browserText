package com.practice2.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.practice2.DAO.BrowserTextRepository;
import com.practice2.model.BrowserTextModel;

import javassist.expr.NewArray;

@Service
public class browserTextServiceImpl implements browserTextService {

	@Autowired
	private BrowserTextRepository browserTextRepository;

	@Override
	@Transactional
	public BrowserTextModel saveBrowserText(BrowserTextModel browserTextModel) {
		return browserTextRepository.save(browserTextModel);
	}

	@Override
	@Transactional
	public List<BrowserTextModel> findBrowserTextById(String id) {
		return browserTextRepository.findBrowserTextById(id);
	}

	@Override
	@Transactional
	public void deleteBrowserTextById(String id) {
		browserTextRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() {
		browserTextRepository.deleteAll();
	}

	@Override
	@Transactional
	public List<BrowserTextModel> findAll() {
		return browserTextRepository.findAll();
	}

	@Override 
	@Transactional
	public void createBrowserText(
			String title,
			String text,
			String label) {
		BrowserTextModel btm = new BrowserTextModel();
		LocalDateTime currentTime = LocalDateTime.now();
		btm.setTitle(title);
		btm.setTimestamp(currentTime);
		btm.setText(text);
		btm.setArchived(false);
		btm.setLabel(label);
		browserTextRepository.save(btm);
	}

	


}
