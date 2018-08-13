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

import java.net.URI;

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
@ApiModel(value = "GetFileChildAttributesResponse", description = "Response for the USS file GET attributes request's children")
public class GetFileChildAttributesResponse {

	@ApiModelProperty(value = "The name of the child resource", dataType = "string", required = true)
	private String name;
	@ApiModelProperty(value = "The type of the child resource", dataType = "string", required = true, allowableValues = "directory,file")
	private UssFileType type;
	@ApiModelProperty(value = "The path of the child resource", required = true)
	private URI link;
}