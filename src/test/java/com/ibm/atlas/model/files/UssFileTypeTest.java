/**
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Copyright IBM Corporation 2016, 2018
 */

package com.ibm.atlas.model.files;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UssFileTypeTest {

	@Test
	public void testName() throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		assertEquals(UssFileType.directory, mapper.readValue("\"directory\"", UssFileType.class));
		assertEquals(UssFileType.file, mapper.readValue("\"file\"", UssFileType.class));
	}

}
