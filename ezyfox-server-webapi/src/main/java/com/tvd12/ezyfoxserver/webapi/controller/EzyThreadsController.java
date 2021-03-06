package com.tvd12.ezyfoxserver.webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvd12.ezyfoxserver.monitor.EzyMonitor;
import com.tvd12.ezyfoxserver.monitor.EzyThreadsMonitor;
import com.tvd12.ezyfoxserver.monitor.data.EzyThreadDetails;
import com.tvd12.ezyfoxserver.monitor.data.EzyThreadsDetail;
import com.tvd12.ezyfoxserver.webapi.exception.EzyThreadNotFoundException;

@RestController
@RequestMapping("admin/threads")
public class EzyThreadsController extends EzyAbstractController {

	@Autowired
	protected EzyMonitor monitor;
	
	@GetMapping("/count")
	public int getThreadCount() {
		return getThreadsMonitor().getThreadCount();
	}
	
	@GetMapping("/all")
	public EzyThreadsDetail getThreads() {
		return getThreadsMonitor().getThreadsDetails();
	}
	
	@GetMapping("/{id}")
	public EzyThreadDetails getThread(@PathVariable long id) {
		if(id <= 0)
			throw EzyThreadNotFoundException.invalid(id);
		EzyThreadDetails details = getThreadsMonitor().getThreadDetails(id);
		if(details == null)
			throw EzyThreadNotFoundException.notFound(id);
		return details;
	}
	
	protected EzyThreadsMonitor getThreadsMonitor() {
		return monitor.getThreadsMonitor();
	}
	
}
