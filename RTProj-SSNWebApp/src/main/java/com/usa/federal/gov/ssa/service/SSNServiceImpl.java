package com.usa.federal.gov.ssa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.federal.gov.ssa.config.AppsMessage;
import com.usa.federal.gov.ssa.constants.AppsConstantHelper;
import com.usa.federal.gov.ssa.dto.SsnDetailsDTO;
import com.usa.federal.gov.ssa.dto.StateNameDTO;
import com.usa.federal.gov.ssa.entity.SsnMasterEntity;
import com.usa.federal.gov.ssa.entity.StateMasterEntity;
import com.usa.federal.gov.ssa.exception.NoDataFoundException;
import com.usa.federal.gov.ssa.exception.SsnWebAppException;
import com.usa.federal.gov.ssa.repositery.SsnRepository;
import com.usa.federal.gov.ssa.repositery.StateRepository;
import com.usa.federal.gov.ssa.utility.SSNAppsUtil;

/**
 * This is the implementation class of SSNService interface.
 * 
 * @author manash
 *
 */
@Service("ssnService")
public class SSNServiceImpl implements SSNService {

	/**
	 * Initializing Logger object to perform logging operation.
	 */
	private static final Logger LOG = LogManager.getLogger(SSNServiceImpl.class);

	/**
	 * Inject repository class object to service class to perform curd operation.
	 */
	@Autowired
	private StateRepository stateRepo;
	/**
	 * Inject repository class object to service class to perform curd operation.
	 */
	@Autowired
	private SsnRepository ssnRepo;
	/**
	 * This is the field which binded with properties file show messages.
	 */
	@Autowired
	private AppsMessage msg;

	@Override
	public String enrollSSN(SsnDetailsDTO dto) {
		SsnMasterEntity entity = null;
		LOG.debug("***enrollSSN() method execution started***");
		entity = new SsnMasterEntity();
		try {
			BeanUtils.copyProperties(dto, entity);
			entity.setPhoto(dto.getPhoto().getBytes());
			entity = ssnRepo.save(entity);
		} catch (Exception e) {
			LOG.error("***enrollSSN method throwing execution***");
			throw new SsnWebAppException(e.getMessage());
		}
		LOG.info("enrollSSN() method execution completed sucessfully***");
		return (entity.getSsnNo() != null) ? msg.getProperties().get(AppsConstantHelper.SUCC_MSG)
				+ (SSNAppsUtil.formatSSNNumber(entity.getSsnNo())) + "."
				: msg.getProperties().get(AppsConstantHelper.FAIL_MSG);
	}

	@Override
	public List<SsnDetailsDTO> getAllSSN() {
		List<SsnMasterEntity> listEntity = null;
		LOG.debug("***getAllSSN() method execution started***");
		try {
			listEntity = ssnRepo.findAll();
			List<SsnDetailsDTO> listDTO = new ArrayList<SsnDetailsDTO>(listEntity.size());
			LOG.debug("***listEntity having some element***");
			listEntity.forEach(entity -> {
				SsnDetailsDTO dto = new SsnDetailsDTO();
				BeanUtils.copyProperties(entity, dto);
				listDTO.add(dto);
			});
			LOG.info("***getAllSSN() method execution completed sucessfully***");
			return listDTO;
		} catch (Exception e) {
			LOG.error("***getAllSSN() method throwing exception***");
			throw new SsnWebAppException(e.getMessage());
		}
	}

	@Override
	public List<StateNameDTO> getAllState() {
		List<StateMasterEntity> stateList = null;
		LOG.debug("***getAllState() method execution started***");
		try {
			stateList = stateRepo.findAll();
			List<StateNameDTO> listDTO = new ArrayList<StateNameDTO>(stateList.size());
			if (!stateList.isEmpty()) {
				LOG.debug("Sucessfully getting all states from database***");
				stateList.forEach(entity -> {
					StateNameDTO dto = new StateNameDTO();
					BeanUtils.copyProperties(entity, dto);
					listDTO.add(dto);
				});
			} else
				LOG.warn("***state list is empty***");

			LOG.info("***getAllState() method execution completed sucessfully***");
			return listDTO;

		} catch (Exception e) {
			LOG.error("getAllState() method throwing exception***");
			throw new SsnWebAppException(e.getMessage());
		}
	}

	@Override
	public String getStateBySSN(Long ssnNo) {
		LOG.debug("getStateBySSN() method execution started***");
		Optional<SsnMasterEntity> opt = ssnRepo.findById(ssnNo);
		if (!opt.isPresent()) {
			LOG.error("***Optional object is empty, throws exception***");
			throw new NoDataFoundException("NO DATA FOUND EXCRPTION!!!");
		}
		LOG.info("***getStateBySSN() method executed sucessfully***");
		return opt.get().getState();
	}
}
