package com.bloghub.velocity.generator;


public class GenEntity {

	public void testEntityVM() {
		BaseContext genBase = new BaseContext();
		genBase.init("com.bloghub.web.entity", "User", "Entity");
		genBase.merge();
	}

}
