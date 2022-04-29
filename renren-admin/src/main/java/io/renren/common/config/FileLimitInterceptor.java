package io.renren.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;

@ControllerAdvice
public class FileLimitInterceptor {
	
	static final Logger logger = LoggerFactory.getLogger(FileLimitInterceptor.class);
	
	@ExceptionHandler(value = MultipartException.class)
    @ResponseBody
    public void fileErrorHandler(MaxUploadSizeExceededException ex) {
        logger.error(ex.getMessage());
    }
	
}
