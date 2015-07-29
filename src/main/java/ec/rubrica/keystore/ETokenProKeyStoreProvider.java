/*
* Copyright (c) 2009-2015 Rubrica.ec
*
* This is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation; either version 2.1 of
* the License, or (at your option) any later version.
*/

package ec.rubrica.keystore;

import java.io.File;

/**
* Implementacion de <code>KeyStoreProvider</code> para utilizar con librerias
* PKCS#11 de eToken Pro 72k, instaladas previamente.
*
* @author Ricardo Arguello <ricardo@rubrica.ec>
*/
public class ETokenProKeyStoreProvider extends PKCS11KeyStoreProvider {

	private static final String CONFIG;
	private static final String DRIVER_FILE = "/usr/lib/libeTPkcs11.so";

	static {
		StringBuffer config = new StringBuffer();
		config.append("name=EtokenPro\n");
		config.append("library=" + DRIVER_FILE + "\n");
		config.append("disabledMechanisms={ CKM_SHA1_RSA_PKCS }");
		CONFIG = config.toString();
	}

	@Override
	public String getConfig() {
		return CONFIG;
	}

	@Override
	public boolean existeDriver() {
		File driver = new File(DRIVER_FILE);
		return driver.exists();
	}
}
