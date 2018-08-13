/**
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Copyright IBM Corporation 2018
 */

package com.ibm.atlas.model.datasets;

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
@ApiModel(value = "DataSetContentResponse", description = "Response for the Dataset file GET content request")
public class DataSetContentResponse {

	@ApiModelProperty(value = "The content of the data set", dataType = "string", required = true, example = "This is some test content")
	private String records;
	@ApiModelProperty(value = "The checksum of the data set", dataType = "string", required = false)
	private String checksum;
}