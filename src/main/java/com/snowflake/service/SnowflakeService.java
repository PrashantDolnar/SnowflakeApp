package com.snowflake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snowflake.dao.SnowflakeDao;

@Service
public class SnowflakeService {
	 
	@Autowired
	private SnowflakeDao dao;

	    public String fetchVersion() throws Exception {
	        return dao.getVersion();
	    }

		public List<Object> getEmployeeList() throws Exception {
			return dao.getEmployeeList();
		}

		public boolean updateNameById(String req) throws Exception {
			// TODO Auto-generated method stub
			return dao.updateNameById(req);
		}
	}

