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
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(exclude = { "lastModifiedDate" })
@Builder
@NoArgsConstructor
@AllArgsConstructor

@JsonInclude(Include.NON_NULL)
@ApiModel(value = "GetFileAttributesResponse", description = "Response for the USS file GET attributes request")
public class GetFileAttributesResponse {

	@ApiModelProperty(value = "The type of the resource", dataType = "string", required = true, allowableValues = "directory,file")
	private UssFileType type;
	@ApiModelProperty(value = "The owner of the resource", required = true)
	private String fileOwner;
	@ApiModelProperty(value = "The owner's group", required = true)
	private String group;
	@ApiModelProperty(value = "Symbolic Permissions of the resource", required = true, example = "rwxr-xr-x")
	private String permissionsSymbolic;
	@ApiModelProperty(value = "Numberic Permissions of the resource", required = true, example = "755")
	private String permissionsNumeric;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	@ApiModelProperty(value = "The date the resource was last modified in ISO 8601 format", required = true, example = "2017-11-17T13:50:09")
	private Date lastModifiedDate;
	@ApiModelProperty(value = "The size of the resource in bytes", required = true)
	private Long size;
	@ApiModelProperty(value = "The children of the resource", required = false)
	private List<GetFileChildAttributesResponse> children;
	@ApiModelProperty(value = "Link to the content if the resource is a file", required = false)
	private URI content;
}