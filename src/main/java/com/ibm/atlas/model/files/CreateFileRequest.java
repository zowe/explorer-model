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
@ApiModel(value = "CreateFileRequest", description = "Body for the USS create file Request")
public class CreateFileRequest {

	@ApiModelProperty(value = "The type of resource to be created", dataType = "string", required = true, allowableValues = "directory,file")
	private UssFileType type;
	@ApiModelProperty(value = "The fully qualified path to the resource to be created", dataType = "java.lang.String", required = true, example = "/u/atlas/newDirectory")
	private String path;
	@ApiModelProperty(value = "The permissions of the resource in numeric form", dataType = "java.lang.String", required = false, example = "777")
	private String permissions;
}