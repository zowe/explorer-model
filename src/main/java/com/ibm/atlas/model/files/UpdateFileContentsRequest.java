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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@JsonInclude(Include.NON_NULL)
@ApiModel(value = "UpdateFileRequest", description = "Body for the USS update file Request")
public class UpdateFileContentsRequest {

	@ApiModelProperty(value = "The content to write in the file", dataType = "string", required = true, example = "This is some test content")
	private String content;
	@ApiModelProperty(value = "An optional checksum based on the previous content of the file. If checksum is passed and it does not match the checksum returned by the previous read, it is deemed a concurrent update has occurred, and the write fails.", dataType = "java.lang.String", required = false, example = "checksum_value")
	private String checksum;
	// TODO - add codepage here - not required default to IOS8859-1?
}