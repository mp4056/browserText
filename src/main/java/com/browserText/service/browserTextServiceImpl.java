package com.browserText.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import com.browserText.DAO.BrowserTextRepository;
import com.browserText.model.BrowserTextModel;

@Service
public class browserTextServiceImpl implements browserTextService{
 
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
	
	@SuppressWarnings("unchecked") // 檢查選擇記事本是否存在於列表內
	@Transactional
	public List<BrowserTextModel> isExisting(String inputid, Model model) {
		List<BrowserTextModel> list = (List<BrowserTextModel>) model.getAttribute("allTextModels");
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == inputid) {
			}else {
				list.remove(i);
			}
			
		}
		return list;
	}
}
