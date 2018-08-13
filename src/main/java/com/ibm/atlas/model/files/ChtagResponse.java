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

import java.util.Arrays;
import java.util.List;

/**
 * taken from https://www.ibm.com/support/knowledgecenter/en/SSLTBW_2.3.0/com.ibm.zos.v2r3.izua700/IZUHPINFO_API_PutUnixFileUtilities.htm
 * however link https://www.ibm.com/support/knowledgecenter/en/SSLTBW_2.1.0/com.ibm.zos.v2r1.bpxa400/bpxug294.htm 
 * indicates that "If no file tag exists on a particular file, that file is treated as an EBCDIC file"
 */
public class ChtagResponse {
	/* Sample input */
	/* t ISO8859-1   T=on  stop.log */
	
	private String delims = "[ ]+";
	
	private List<String> asciiCode = Arrays.asList(new String[]{"00367", "ISO8859-1", "ISO8859-2", "00913", "ISO8859-4", "ISO8859-5", "ISO8859-8", "ISO8859-9"
			, "ISO8859-15", "01008", "01011", "01012","01013","01014","01016","01017","01019",
			"IBM-4909", "05012", "05104", "25488", "25491", "61699", "61700", "61710"});
	
	private final String TEXT = "T=on"; //$NON-NLS-1$
	
	/* Candidate for automatic conversion flag - t (on) */
	private boolean txtflag = false;
	
	/* Coded character set (CCSID) */
	private String isoTag = "" ; //$NON-NLS-1$
    
	private String stdout ;	
	
	public ChtagResponse(String stdout) {
		this.stdout = stdout;
		String[] tokens = stdout.split(delims);
		txtflag = stdout.contains(TEXT);
		if (tokens.length>1) {
			isoTag = tokens[1];
		}
	}

	public boolean convertRecommended() {
		// Generally "T=off" represents binary. 
		// However the majority of these examples would be files which have never been tagged and are EBCDIC
		// If they are binary they would appear as gibberish in the editor either way
		// So hence the specific test
		// -   untagged    T=off   file5
		if (txtflag) {
			return !asciiCode.contains(isoTag) && (isoTag.matches("\\d+") || isoTag.startsWith("IBM")); //$NON-NLS-1$
		}
		return isoTag.equals("untagged");
	}

	public String toString() {
		return this.stdout;
	}
 }
