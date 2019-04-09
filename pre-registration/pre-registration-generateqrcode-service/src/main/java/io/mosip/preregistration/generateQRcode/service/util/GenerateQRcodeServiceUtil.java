package io.mosip.preregistration.generateQRcode.service.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.mosip.kernel.core.logger.spi.Logger;
import io.mosip.preregistration.core.common.dto.MainRequestDTO;
import io.mosip.preregistration.core.config.LoggerConfiguration;
import io.mosip.preregistration.generateQRcode.service.GenerateQRcodeService;


/**
 * @author Sanober Noor
 *@since 1.0.0
 */
@Component
public class GenerateQRcodeServiceUtil {
	
	
	private Logger log = LoggerConfiguration.logConfig(GenerateQRcodeService.class);
	
	
	/**
	 * Method to generate currentresponsetime.
	 * 
	 * @return the string.
	 */
	public String getCurrentResponseTime() {
		return LocalDateTime.now(ZoneId.of("UTC")).toString();
	}
	
	public Map<String, String> prepareRequestMap(MainRequestDTO<?> requestDto) {
		log.info("sessionId", "idType", "id", "In prepareRequestMap method of Login Service Util");
		Map<String, String> requestMap = new HashMap<>();
		requestMap.put("id", requestDto.getId());
		requestMap.put("version", requestDto.getVersion());
		LocalDate date = requestDto.getRequesttime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		requestMap.put("requesttime",date.toString());
		requestMap.put("request", requestDto.getRequest().toString());
		return requestMap;
	}

}
