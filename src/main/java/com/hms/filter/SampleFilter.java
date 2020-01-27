package com.hms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class SampleFilter implements Filter {

	private static final Logger LOGGER = LogManager.getLogger(SampleFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		LOGGER.info("Starting a transaction with {}", req.getRequestURI());

		chain.doFilter(request, response);
		LOGGER.info("Commiting a transaction with {}", req.getRequestURI());
	}

}
