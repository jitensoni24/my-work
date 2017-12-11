package com.bskyb.db.repository;

import com.bskyb.db.entity.Department;

@org.springframework.stereotype.Repository
public class DepartmentRepository  extends Repository<Department> {

	public DepartmentRepository() {
		super(Department.class);
	}
}
