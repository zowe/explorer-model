/**
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Copyright IBM Corporation 2018
 */

package com.ibm.atlas.model.files;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChtagResponseTest {

	@Test
	public void testIt() throws Exception {
		assertFalse(new ChtagResponse("t ISO8859-1   T=on  stop.log").convertRecommended());
		assertFalse(new ChtagResponse("t ISO8859-4   T=on  stop.log").convertRecommended());
		assertFalse(new ChtagResponse("t 01016   T=on  stop.log").convertRecommended());
		assertFalse(new ChtagResponse("t 00913   T=on  stop.log").convertRecommended());
		assertFalse(new ChtagResponse("t 61710   T=on  stop.log").convertRecommended());
		assertFalse(new ChtagResponse("t 00367   T=on  stop.log").convertRecommended());
		
		assertFalse(new ChtagResponse("t ISO8859-1   T=off  stop.log").convertRecommended());
		assertFalse(new ChtagResponse("t ISO8859-4   T=off  stop.log").convertRecommended());
		assertFalse(new ChtagResponse("t 01016   T=off  stop.log").convertRecommended());
		assertFalse(new ChtagResponse("t 00913   T=off  stop.log").convertRecommended());
		assertFalse(new ChtagResponse("t 61710   T=off  stop.log").convertRecommended());
		assertFalse(new ChtagResponse("t 00367   T=off  stop.log").convertRecommended());		
		
		assertFalse(new ChtagResponse("t ISO8859-1   T=off  stop.log").convertRecommended());
		assertTrue(new ChtagResponse("t IBM-282   T=on  stop.log").convertRecommended());
		assertTrue(new ChtagResponse("t IBM-1047   T=on  stop.log").convertRecommended());
		assertTrue(new ChtagResponse("t 61711   T=on  stop.log").convertRecommended());
		assertTrue(new ChtagResponse("t 675   T=on  stop.log").convertRecommended());

		assertTrue(new ChtagResponse("- untagged    T=off hello.pdf").convertRecommended());

		assertFalse(new ChtagResponse("").convertRecommended());
	}

}
