package com.bloghub.velocity.generator;


public class GenDao {

	public void testEntityVM() {
		BaseContext genBase = new BaseContext();
		genBase.init("com.bloghub.web.dao", "User", "Dao");
		genBase.merge();
	}

}
