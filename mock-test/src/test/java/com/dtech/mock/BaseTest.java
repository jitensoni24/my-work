package com.dtech.mock;

import org.junit.BeforeClass;

import com.tobedevoured.modelcitizen.ModelFactory;
import com.tobedevoured.modelcitizen.RegisterBlueprintException;

public abstract class BaseTest {

	protected static ModelFactory modelFactory;
	
	public static void initModelFactory() throws RegisterBlueprintException {
		modelFactory = new ModelFactory();
		modelFactory.setRegisterBlueprintsByPackage("com.dtech.mock.blueprint");
	}
	
	@BeforeClass
	public static void init() throws Exception {
		initModelFactory();
	}
}
